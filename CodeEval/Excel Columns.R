# input <- 3702
# input <- 53
input <- 703

# As a funciton
provideExcelCol <- function(input) {
	original <- input
	output <- list("","","")
	bench.one <- (26^2) # 676
	
	if(input > bench.one + 26) {
		new.input <- input - bench.one*(floor(bench.one/input)) - 26
		div <- input/(bench.one)
		input <- (input - 26)%%(bench.one)
		
		if(input == 0) {
			input <- bench.one + 26
			output[[1]] <- LETTERS[floor(div)]
		} else {
			output[[1]] <- LETTERS[floor(div)]
		}
		# input <- new.input

	}
	
	if(input > 26) {
		div <- (input)/26
		
		input <- (input%%26)
		if(input == 0) {
			input <- 26
			output[[2]] <- LETTERS[floor(div) - 1]
		} else {
			output[[2]] <- LETTERS[floor(div)]
		}
	}
	
	output[[3]] <- LETTERS[input]
	for(i in 1:3){
		if(!output[[i]] %in% LETTERS){
			output[[i]] <- "_"
		}
	}

	paste(output,collapse = "")
}

range <- 1:2000
result <- sapply(range, provideExcelCol)
names(result) <- range
result
provideExcelCol(3702)
