#' Estimate a triangular number
#'
#' @param n Which traingular number
#'
#' @return Triangular number
#' @export
#'
#' @examples
#' getTriangle(10)
getTriangle <- function(n) {
	n*(n + 1)/2
}

#' Generate series of triangular numbers
#'
#' Generates a series of triangular numbers all of which are below a given value
#'
#' @param max Maximum value in the series
#'
#' @return Numeric vector
#' @export
#'
#' @examples
#' generateTriangularNumbers(10)
generateTriangularNumbers <- function (max) {
	output <- 1
	n <- 1
	while (tail(output,1) < max) {
		output <- append(output, getTriangle(n))
		n <- n + 1
	}
	output
}

#' Estimate a pentagonal number
#'
#' @param n Which pentagonal number
#'
#' @return Pentagonal number
#' @export
#'
#' @examples
#' getPentagonal(10)
getPentagonal <- function(n) {
	n*(3*n-1)/2
}

#' Estimate a hexagonal number
#'
#' @param n Which hexagonal number
#'
#' @return Hexagonal number
#' @export
#'
#' @examples
#' getHexagonal(10)
getHexagonal <- function(n) {
	n*(2*n-1)
}

#' Fibbonaci Sequence
#'
#' Generates fibbonci numbers up to a certain given value
#'
#' @param highest.val Highest value
#'
#' @return
#' @export
#'
#' @examples
#' fibb(13)
fibb <- function(highest.val) {
	output <- 1:2
	final.term <- tail(output,1)

	while(final.term < highest.val) {
		next.index <- length(output)
		output[next.index+1] <- sum(output[next.index-1],output[next.index])
		final.term <- tail(output,1)
	}

	output

}
