#' Euler 1
#'
#' Calculates the sum of all multiples of 3 and 5 under 1000
#'
#' Solves Problem 1 by default
#'
#' @param numbers Range of numbers to check
#'
#' @return Total sum
#' @export
#'
#' @examples
#' euler1(1:10)
euler1 <- function(numbers = 1:999) {

	# Checks if value is a multiple of 3 or 5
	check <- function(i){
		if(i%%3==0) {
			T
		} else if (i%%5==0) {
			T
		} else {
			F
		}
	}

	sum(numbers[sapply(numbers,check)])
}
