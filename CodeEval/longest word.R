inputs <- list("some line with text", "another line")

getLongest <- function(text) {
	if (length(text) > 0){
		split <- unlist(strsplit(text, " "))
		cat(split[which.max(sapply(split,nchar))],"\n")
	}
}

invisible(lapply(inputs, getLongest))
