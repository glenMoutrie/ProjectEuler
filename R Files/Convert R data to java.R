convertDataFrameJArray <- function(data) {
	output <- "Number[][] data = {"
	for(i in 1:nrow(data)) {
		output <- paste0(output,"{",
										 paste0(data[i,],collapse = ","),
										 "}")
		if(i != nrow(data)) {
			output <- paste0(output, ",")
		}
	}
	
	output <- paste0(output, "};")
	
	output
}

convertDataFrameJArray(iris)
