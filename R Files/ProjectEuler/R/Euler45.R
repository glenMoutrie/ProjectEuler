#' Euler 45
#'
#' Generates triangular numbers that are also pentagonal and hexagonal in a certain range.
#'
#' This successfully solves Problem 45 by default
#'
#' @return A array of integers
#'
#' @examples
#' # Solution to Euler 45
#' euler45()[3]
euler45 <- function(x = 100000) {
	range <- 1:x

	tri <- sapply(range, getTriangle)
	pent <- sapply(range, getPentagonal)
	hex <- sapply(range, getHexagonal)

	sapply(which(tri %in% pent & tri %in% hex), getTriangle)
}

