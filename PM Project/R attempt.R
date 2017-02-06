library(data.table)
library(rjson)
library(RColorBrewer)

# Read in the data table
links <- fread("~/Documents/ProjectEuler/PM Project/links.csv",header = T)

meta <- fread("~/Documents/ProjectEuler/PM Project/meta.csv")

# Decompose the data set
decompose <- prcomp(as.matrix(links[,-1,with = F]))

# Knee point function (this is used to select dimensions and clusters)
kneePoint <- function(series) {
	
	max.point <- max(series)
	min.point <- min(series)
	
	n <- length(series)
	which.max(abs(series - seq(from = max.point, to = min.point, by = (min.point - max.point)/(n - 1))))
	
}

# Best columns 
best.comp <- kneePoint(decompose$sdev)

# Calculate the clusters
all.clusters <- lapply(1:53, kmeans, x = decompose$x[,1:best.comp])

# Get a list of within differences sum
diff.within <- sapply(all.clusters, function (x) x$tot.withinss)

# Find the best cluster using the knee point
best <- kneePoint(diff.within)

# Assign to cluster
cluster <- all.clusters[[best]]

# Clean up the result of the clustering 
result <- data.table(Cluster = cluster$cluster,
										 Names = links$V1,
										 Decompose_1 = decompose[["x"]][,1],
										 Decompose_2 = decompose[["x"]][,2])

View(result[order(result$Cluster)])

periods <- list(`Sir Winston Churchill` = "Churchill",
								`Edward Heath` = "Forgettable Tories",
								`The Earl of Wilmington` = "Early Prime Ministers",
								`H. H. Asquith` = "Asquith",
								`David Cameron` = "Modern Tories",
								`Tony Blair` = "Modern Labour",
								`The Duke of Wellington` = "Wellington",
								`The Marquess of Salisbury` = "Victorian Era Prime Ministers",
								`Margaret Thatcher` = "Thatcher",
								`William Pitt the Younger` = "Very Early Prime Ministers",
								`Benjamin Disraeli` = "Early 20th Century",
								`Ramsay MacDonald` = "Labours First Leaders",
								`Sir Anthony Eden` = "Post War Tories")

cluster.names <- as.list(1:14)

for (i in names(periods)) {
	tryCatch(expr = cluster.names[[result[which(result$Names == i), Cluster]]] <- periods[[i]],
					 error = function (e) {cat(i); print(e)})
	
}


# Own internal R check, both printing and plotting the results
plot(result[, Decompose_1], result[,Decompose_2], col = result[, Cluster]); result[order(result$Cluster)]

# Merge the meta data and the results
output <- merge(result, meta[,-1, with =F] , by.x = "Names", by.y = "Name")

createHTML <- function(row) {
	paste0("<a href = '", row["url"], "'>",
				 row["Names"],"</a><br>")
	# "<img src = 'https:", row["image"],"'></img><br>")
}

output[, name  := apply(output,1,createHTML)]

output <- setnames(output, c("Decompose_1", "Decompose_2"), c("x","y"))

output <- split(output, output$Cluster)

cluster.meta <- data.table(name = names(output), color = colorRamps::blue2red(length(output)))
cluster.meta <- split(cluster.meta, cluster.meta$name)
cluster.meta <- lapply(cluster.meta, as.list)

for (i in as.character(1:14)) {
	data <- as.list(split(output[[i]][,c("x","y","name", "Names"), with = F],1:nrow(output[[i]])))
	names(data) <- c()
	cluster.meta[[i]]$data <- data
}

names(cluster.meta) <- c()

# Export as a JSON object
json.output <- toJSON(cluster.meta)
write(json.output, "~/Documents/ProjectEuler/PM Project/forGraph.json")
