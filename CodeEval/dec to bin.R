decToBin <- function(input) {
	output <- as.character(as.integer(intToBits(as.integer(input))))
	cat(as.integer(paste0(output[length(output):1],collapse="")),"\n")
}
decToBin("2")