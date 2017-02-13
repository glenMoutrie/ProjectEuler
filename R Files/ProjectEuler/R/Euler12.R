#' Euler 12
#'
#' Ridiculous brute force edition........
#'
#' This is a slow solution to Euler 12, but on my system solves in a time of 40 seconds approx.
#'
#' @return Soltion
#' @export
#'
#' @examples
euler12 <- function() {
	quick.check <- 1
	iteration <- 2

	numberOfDivisors <- function (x) {
		i <- 1
		total <- 1
		while (i <= sqrt(x)) {
			if (x%%i == 0) {
				total <- total + 2
			}
			i <- i + 1
		}

		total
	}

	number.of.divisors <- 0
	while(number.of.divisors <= 500) {
		quick.check <- iteration + quick.check
		iteration <- iteration + 1
		number.of.divisors <- numberOfDivisors(quick.check)
	}

	quick.check

}
