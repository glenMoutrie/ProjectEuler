#' Euler 29 Slow
#'
#' Finds the number of unique values of a^b for a range of a and b values.
#'
#' This is a slower version of \code{euler29}
#'
#' @param max max interger value of a and b
#'
#' @return Integer value of unique results
#' @export
euler29Slow <- function(max = 100) {

	# Create the range
	aRange <- bRange <- 2:100
	results <- NULL

	# Calculate the values
	for(a in aRange) {
		for(b in bRange) {
			results[length(results) + 1] <- a^b
		}
	}

	# Get the length of unique results
	length(unique(results))
}


#' Euler 29
#'
#' Finds the number of unique values of a^b for a range of a and b values.
#'
#' This is a faster version of \code{euler29Slow}
#'
#' @param max max interger value of a and b
#'
#' @return Integer value of unique results
#' @export
euler29 <- function(max = 100) {

	# Range of inputs
	a <- b <- 2:max

	# Perform calculations and get unique results
	length(unique(as.vector(sapply(a, function(x){sapply(x,`^`,b)}))))
}
