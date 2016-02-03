checkSubset <- function(subset){
	sum(sort(subset)-(1:length(subset))) == 0
}

formatString <- function(input.string) {
	split <- unlist(strsplit(input.string,";"))
	n <- as.numeric(split[1])
	m <- matrix(as.numeric(unlist(strsplit(split[2],","))),n,n)
	list(sol = m, dim = n)
}

checkSolution <- function (solution, dimension) {

	correct <- T
	dim.sq.rt <- sqrt(dimension)

	# Check the rows
	for(i in 1:nrow(solution)) {
		correct <- checkSubset(solution[i,])
		if(!correct) {
			return(correct)
		}
	}

	# Check the columns
	for(j in 1:ncol(solution)) {
		correct <- checkSubset(solution[,j])
		if(!correct) {
			return(correct)
		}
	}

	# Check each sub matrix
	for(i in seq(0,dimension - 1,dim.sq.rt)){
		for(j in seq(0,dimension - 1,dim.sq.rt)){
			correct <- checkSubset(solution[1:dim.sq.rt + i,1:dim.sq.rt + j])
		}
	}

	correct
}


formatted <- formatString("4;2,1,3,2,3,2,1,4,1,4,2,3,2,3,4,1")
if(checkSolution(formatted[[1]],formatted[[2]])) {
	cat("True\n")
} else {
	cat("False\n")
}
