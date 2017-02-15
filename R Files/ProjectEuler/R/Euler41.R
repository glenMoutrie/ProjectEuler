#' Euler 49
#'
#' Finds the largest pandigital prime.
#'
#' @param max Largest pandigital to consider.
#' @param verbose If a message is printed on the search
#'
#' @return
#' @export
euler41 <- function(max = 7654321, verbose = F) {

	found <- F

	while(!found) {

		# Go to next pandigital
		max <- bindDigits(permutate(getDigits(max), "DOWN"))

		# Check if it is prime
		found <- isPrime(max)

		# Message
		if (verbose) cat("Max: ", max, ", Found: ", found, "\n")
	}

	# Return largest
	max
}


