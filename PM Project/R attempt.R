links <- fread("~/Documents/ProjectEuler/PM Project/links.csv",header = T)

decompose <- prcomp(t(as.matrix(links[,-1,with = F])))

all.clusters <- lapply(1:53, kmeans, x = t(decompose[[2]]))

best <- which.min(diff(sapply(all.clusters, function (x) x$tot.withinss))) + 1

cluster <- all.clusters[[best]]
 
result <- data.table(Cluster = cluster$cluster,
										 Names = links$V1,
										 Decompose_1 = decompose[[2]][,1],
										 Decompose_2 = decompose[[2]][,2])

plot(result[, Decompose_1], result[,Decompose_2], col = result[, Cluster])
