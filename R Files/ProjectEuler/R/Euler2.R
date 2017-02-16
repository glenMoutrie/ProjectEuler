
#' Euler 2
#'
#' Finds the sum of all evevn fibbonaci numbers below a certain value
#'
#' @param len Maximum value
#'
#' @return Integer
#' @export
euler2 <- function(len = 4*10^6) {
	sequence <- fibb(len)

	# Take the sum for all even numbers
	sum(sequence[sequence%%2==0])
}
