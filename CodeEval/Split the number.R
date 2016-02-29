inputs <- list("3413289830 a-bcdefghij",
							 "776 a+bc",
							 "12345 a+bcde",
							 "1232 ab+cd",
							 "90602 a+bcde")

formatInput <- function (string) {
	split <- unlist(strsplit(string," "))
	
	getId <- function(locOrFun, str) {
		output <- grep(pattern = "[[:punct:]]",
				 x = unlist(strsplit(str,"")),
				 value = locOrFun)
		
		ifelse(locOrFun,output,as.numeric(output))
		
	}
	
	id <- lapply(c(T,F), getId, split[2])
	
	list(as.numeric(split[[1]]),id[[1]],id[[2]], nchar(split[[1]]))
}

calculate <- function(input) {
	lhs <-  floor(input[[1]]/(10^(input[[4]] - input[[3]] + 1)))
	rhs <-  input[[1]]%%(10^(input[[4]] - input[[3]] + 1))
	cat(getAnywhere(input[[2]])[[2]][[1]](lhs, rhs),"\n")
}

test <- lapply(inputs, formatInput)
sapply(test,calculate)

cat(calculate(formatInput(test)),"\n")
