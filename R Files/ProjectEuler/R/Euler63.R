#' Euler 63
#'
#' Finds the sum of integers which have the same number of digits that
#' they are a power of.
#'
#' @param range.powers Range of powers to check
#' @param range.input Range of numbers to take a power of
#'
#' @return
#' @export
euler63 <- function(range.powers = 1:50, range.input = 1:1000) {

	# Calculate the powers
	powers <- sapply(range.input,function (x) {sapply(range.powers,function (y) {x^y})})

	# Sum the digits
	count <- apply(powers,2,function (x) {sapply(x,digits)})

	# Create a matrix to check equal values
	equal <- matrix(nrow = dim(count)[1], ncol = dim(count)[2])

	# For each in the range of powers, check which match the digit length
	for (i in range.powers) {
		equal[i,] <- sapply(count[i,], function (x) {x == range.powers[i]})
	}

	# Return the sum
	sum(equal)

}
