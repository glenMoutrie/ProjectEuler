inputs <- list("1556 9144 6285 339",
							 "6363 1811 2857 7650",
							"6011 5940 0319 9511",
							 "5537 0213 6797 6815",
							 "5574 8363 8022 9735",
							 "3044 8507 9391 30",
							 "6370 1675 9034 6211 774")
oddProcess <- function(odd) {
	odd <- odd*2
	if(odd > 9){
		odd <- floor(odd/10) + odd%%10
	}
	odd
}
checkNumber <- function(input.string) {

	# Format the inputs
	input.string <- gsub(x = input.string,pattern = " ",replacement = "")
	input <- as.numeric(unlist(strsplit(input.string,"")))

	# Select the odd numbers
	start.int <- ifelse(length(input)%%2 == 0,1,2)
	odd.inputs <- seq(from = start.int,by = 2,to = length(input))
	odd.output <- sapply(input[odd.inputs], oddProcess)

	cat(as.numeric((sum(odd.output) + sum(input[-odd.inputs]))%%10==0),"\n")
}
sapply(inputs,checkNumber)
