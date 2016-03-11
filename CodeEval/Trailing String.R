trailingString <- function(input) {
	words <- unlist(strsplit(input,","))
	n <- sapply(words, nchar)
	
	if(n[1] < n[2]) {
		return(0)
	} else {
		check <- all.equal(substring(words[1], n[1] - n[2] + 1, n[1]), words[2])
		return(ifelse(isTRUE(check),1,0))
	}
}

test <- list("Hello World,World",
							 "Hello CodeEval,CodeEval",
							 "San Francisco,San Jose")
sapply(test, trailingString)