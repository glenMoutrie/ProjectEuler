library(data.table)

# Read in the data table
links <- fread("~/Documents/ProjectEuler/PM Project/links.csv",header = T)

# Decompose the data set
decompose <- prcomp(as.matrix(links[,-1,with = F]))

kneePoint <- function(series) {
	
	max.point <- max(series)
	min.point <- min(series)
	
	n <- length(series)
	which.max(abs(series - seq(from = max.point, to = min.point, by = (min.point - max.point)/(n - 1))))
	
}

best.comp <- kneePoint(decompose$sdev)

# Calculate the clusters
all.clusters <- lapply(1:53, kmeans, x = decompose$x[,1:best.comp])

# Get a list of within differences sum
diff.within <- sapply(all.clusters, function (x) x$tot.withinss)


best <- kneePoint(diff.within)

cluster <- all.clusters[[best]]
 
result <- data.table(Cluster = cluster$cluster,
										 Names = links$V1,
										 Decompose_1 = decompose[["x"]][,1],
										 Decompose_2 = decompose[["x"]][,2])

plot(result[, Decompose_1], result[,Decompose_2], col = result[, Cluster])

result[order(result$Cluster)]
