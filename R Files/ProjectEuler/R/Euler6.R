#' Euler 6
#'
#' Calculates the difference between the sum of squares and the square of the sum
#' for a range of values.
#'
#' @param numbers Range of values to perform function on
#'
#' @return Solution
#' @export
euler6 <- function(numbers = 1:100) {
	square.of.sum <- sum(numbers)^2
	sum.of.square <- sum(numbers^2)
	square.of.sum - sum.of.square
}
