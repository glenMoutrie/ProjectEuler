test <- list("5;0,1,2,3,0",
"20;0,1,10,3,2,4,5,7,6,8,11,9,15,12,13,4,16,18,17,14")

toNumeric <- function(string) {
	split <- as.numeric(unlist(strsplit(x = string,split = "[[:punct:]]",fixed = F)))
	list(n = split[1], array = split[-1])
}

getResult <- function(input) {
	cat(names(which(table(input$array) > 1)),"\n")
}

duplicates <- function(initial) {
	getResult(toNumeric(initial))
}

duplicates(test[[2]])
# lapply(lapply(test,toNumeric),getResult)
x <- lapply(test,duplicates)
