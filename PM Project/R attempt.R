library(data.table)
library(rjson)

# Read in the data table
links <- fread("~/Documents/ProjectEuler/PM Project/links.csv",header = T)

meta <- fread("~/Documents/ProjectEuler/PM Project/meta.csv")

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

# Find the best cluster using the knee point
best <- kneePoint(diff.within)

# Assign to cluster
cluster <- all.clusters[[best]]

# Clean up the result of the clustering 
result <- data.table(Cluster = cluster$cluster,
										 Names = links$V1,
										 Decompose_1 = decompose[["x"]][,1],
										 Decompose_2 = decompose[["x"]][,2])

# Own internal R check, both printing and plotting the results
plot(result[, Decompose_1], result[,Decompose_2], col = result[, Cluster]); result[order(result$Cluster)]

# Merge the meta data and the results
output <- merge(result, meta[,-1, with =F] , by.x = "Names", by.y = "Name")

# Export as a JSON object
json.output <- toJSON(split(output, seq(nrow(output))))
write(json.output, "~/Documents/ProjectEuler/PM Project/forGraph.json")