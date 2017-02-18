#' Euler 34
#'
#' Finds the sum of numbers that are equal to the digit sum of that numbers factorial
#'
#' This could be amde to be faster by reducing the search area.
#'
#' @return
#' @export
#'
#' @examples
euler34 <- function() {

	# Find the limit for which there can no longer be any solutions
	n <- 1:100
	largest.possible.number <- sapply(n,function(x) {as.numeric(paste0(rep("9",length.out = x),collapse = ""))})
	largest.possible.sum <- n*factorial(9)
	possible <- largest.possible.number < largest.possible.sum

	# Logic for finding numbers which equal the sum of the digits of their factorial
	equalsSumOfFactorialDigits <- function (i){
		if(sum(factorial(getDigits(i))) == i) {
			result <- i
		} else {
			result <- 0
		}
	}

	# Find solutions given limit
	results <- sapply(3:10^(sum(possible)), equalsSumOfFactorialDigits)

	# Produce the results
	sum(results)
}
