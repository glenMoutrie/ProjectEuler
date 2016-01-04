inputs <- list("(1,2,3);(2,4,6);(4,5,5);(7,3,11);(9,2,14);(13,7,15);(14,3,17)",
							 "(2,22,3);(6,12,10);(15,6,21)",
							 "(1,2,6);(9,23,22);(22,6,24);(8,14,19);(23,12,30)")

stringToDataFrame <- function(integers) {
	data.frame(index = integers[1]:integers[3], height = integers[2])
}

getCordinates <- function(string.input) {
	do.call(args = lapply(sapply(unlist(strsplit(string.input,"\\;")),
															 function (x) {lapply(strsplit(gsub(x = gsub(x = x,pattern = "\\(",replacement = ""),pattern = "\\)",replacement = ""),",")
															 										 ,as.numeric)}),
												stringToDataFrame), what = rbind)
}
getCordinates(inputs[[1]])

createOutput <- function(cleaned.data) {
	start <- min(cleaned.data[,1])
	range <- start:max(cleaned.data[,1])
	output <- c()
	for(i in range) {output[length(output) + 1] <- max(cleaned.data[which(cleaned.data[,1] == i),2])}
	data.frame(length = range, height = output, changed = c(0,diff(output)) != 0)
}
output <- createOutput(getCordinates(inputs[[1]]))
output
first.diff <- diff(c(0,output))!=0
(1:17)[first.diff != 0 || diff((1:17)[first.diff]) == 1]
plot(1:17,as.numeric(strsplit(output," ")[[1]]))

createSkyScraper <- function(data.frame){
	
}

outputs <- list("1 2 2 4 4 5 5 4 6 0 7 3 11 2 13 7 15 3 17 0",
								"2 22 3 0 6 12 10 0 15 6 21 0",
								"1 2 6 0 8 14 9 23 22 6 23 12 30 0")