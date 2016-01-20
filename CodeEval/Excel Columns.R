# input <- 3702
# input <- 53
input <- 703

# As a funciton
provideExcelCol <- function(input) {
	output <- list("","","")
	bench.one <- 26^3
	bench.two <- 26^2
	if(input == bench.one + bench.two + 26) {
		return("ZZZ")
	}
	
	# Allocate [[1]]
	if(input > bench.two + 26){
		remainder <- input - bench.two - 26
		input <- remainder%%(bench.two)
		output[[1]] <- LETTERS[floor(remainder/bench.two) + 1]# + ifelse(input==0,0,1)]
	}
	if(input == 0) {
		input <- bench.two
	}
	
	# Allocate[[2]]
	if(input > 26) {
		remainder <- input - 26
		input <- remainder%%26
		output[[2]] <- LETTERS[floor(remainder/26) + ifelse(output[[1]] == "",0,1) + ifelse(input==0,0,1)]
		if(is.na(output[[2]])) {
			output[[2]] <- "A"
		}
	} else if (output[[1]] != "") {
		output[[2]] <- "A"
	}
	if(input == 0) {
		input <- 26
	}
	
	output[[3]] <- LETTERS[input + ifelse(output[[2]] == "",0,0)]
	
	# for(i in 1:3){
	# 	if(length(output[[i]]) == 0){
	# 		output[[i]] <- 0
	# 	} else if(!output[[i]] %in% LETTERS){
	# 		# output[[i]] <- "_"
	# 	} else if (is.na(output[[i]])){
	# 		output[[i]] <- "$"
	# 	}
	# }
	
	paste0(output,collapse = "")
}

range <- 1:((26^3) + (26^2) + 26)
result <- sapply(range, provideExcelCol)
output <- as.data.frame(matrix(result,ncol = 26,byrow = T))
View(output)
provideExcelCol(53*26)

# ###
# # Sample code to read test cases
# # As a funciton
# provideExcelCol <- function(input) {
# 	output <- list("","","")
# 	bench.one <- 26^3
# 	bench.two <- 26^2
# 	if(input == bench.one + bench.two + 26) {
# 		return("ZZZ")
# 	}
# 	
# 	# Allocate [[1]]
# 	if(input > bench.two + 26){
# 		remainder <- input - bench.two - 26
# 		input <- remainder%%(bench.two)
# 		output[[1]] <- LETTERS[floor(remainder/bench.two) + 1]# + ifelse(input==0,0,1)]
# 	}
# 	if(input == 0) {
# 		input <- bench.two
# 	}
# 	
# 	# Allocate[[2]]
# 	if(input > 26) {
# 		remainder <- input - 26
# 		input <- remainder%%26
# 		output[[2]] <- LETTERS[floor(remainder/26) + ifelse(output[[1]] == "",0,1) + ifelse(input==0,0,1)]
# 		if(is.na(output[[2]])) {
# 			output[[2]] <- "A"
# 		}
# 	} else if (output[[1]] != "") {
# 		output[[2]] <- "A"
# 	}
# 	if(input == 0) {
# 		input <- 26
# 	}
# 	
# 	output[[3]] <- LETTERS[input + ifelse(output[[2]] == "",0,0)]
# 	
# 	# for(i in 1:3){
# 	# 	if(length(output[[i]]) == 0){
# 	# 		output[[i]] <- 0
# 	# 	} else if(!output[[i]] %in% LETTERS){
# 	# 		# output[[i]] <- "_"
# 	# 	} else if (is.na(output[[i]])){
# 	# 		output[[i]] <- "$"
# 	# 	}
# 	# }
# 	
# 	paste0(output,collapse = "")
# }
# args <- commandArgs(trailingOnly=TRUE)
# test.cases <- strsplit(readLines(args[[1]], warn=FALSE), '\n')
# for (test in test.cases) {
# 	if (length(test) > 0) {
# 		# ignore test if it is an empty line
# 		# 'test' represents the test case, do something with it
# 		cat(provideExcelCol(as.numeric(test)),"\n")
# 	}
# }
