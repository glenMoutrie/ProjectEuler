#' Euler 11
#'
#' This solves Euler 11 when given the problems source file. This is achieved
#' by considering each possible 4x4 submatrix
#'
#' @param src Location of the source file
#'
#' @return Solution
#'
#' @examples
#' euler11()
euler11 <- function(src = "~/Documents/java/ProjectEuler/input11.csv") {

	# Read input and covert to matrix
	input <- as.matrix(read.csv(src,sep = " ",header = F))
	colnames(input) <- NULL

	# Set largest sum to zero
	largest.so.far <- 0

	# Checks the revers diagonal (bottom left to top right) of submatrix
	otherDiagonal <- function(x) {
		first <- x[4,1]
		second <- x[3,2]
		third <- x[2,3]
		fourth <- x[1,4]
		result <- c(first,second,third,fourth)
		return(result)
	}

	# Iterate over possible matrix starting points
	for(i in 0:16) {
		for(j in 0:16) {

			# Check horizontal
			largest.so.far <- max(prod(input[1+i,1:4+j]),largest.so.far)

			# Check diagonals
			largest.so.far <- max(prod(diag(input[1:4+i,1:4+j])),largest.so.far)
			largest.so.far <- max(prod(otherDiagonal(input[1:4+i,1:4+j])),largest.so.far)

			if (i == 16) {
				# Checking instances where horizontal is the only viable direction
				largest.so.far <- max(prod(input[2+i,1:4+j]),largest.so.far)
				largest.so.far <- max(prod(input[3+i,1:4+j]),largest.so.far)
				largest.so.far <- max(prod(input[4+i,1:4+j]),largest.so.far)
			}

			if (j == 16) {
				# Checking instances where vertical is the only viable direction
				largest.so.far <- max(prod(input[1:4+i,2+j]),largest.so.far)
				largest.so.far <- max(prod(input[1:4+i,3+j]),largest.so.far)
				largest.so.far <- max(prod(input[1:4+i,4+j]),largest.so.far)
			}
		}
	}

	# Return the result
	largest.so.far

}
