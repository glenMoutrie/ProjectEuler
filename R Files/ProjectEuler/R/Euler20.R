#' Euler 21
#'
#' Provides a one line solution for problem 21, printing the sum of digits of the factorial of 100.
#'
#' @return
#' @export
euler21 <- function() {
	sum(lapply(strsplit(as.character(factorialZ(100)),""),as.numeric)[[1]])
}
