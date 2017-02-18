#' Euler 28
#'
#' Finds the sum of all the digits on the diagonals of the square by
#' generating a sequence of odd numbers then finding the sequence of the
#' corner values.
#'
#' @param squares.dim Dimension of the square (row or column)
#'
#' @return Integer result
#' @export
euler28 <- function(squares.dim = 1001) {

	# Gernerate odd numbers
	skip <- seq(2,squares.dim,2)
	numbers <- 1

	for (i in skip) {
		# Add the relevant indexes for the corners
		numbers <- append(numbers, seq(from = tail(numbers, 1) + i, by = i, length.out = 4))
	}
	sum(numbers)
}
