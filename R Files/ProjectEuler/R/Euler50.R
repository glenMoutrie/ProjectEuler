#' Euler 50
#'
#' Finds the prime number that can be written as the longest sum of consecutive primes.
#'
#' @param verbose If true will print diagnostic information
#'
#' @return Prime number satisfying criteria
#' @export
euler50 <- function(verbose = F) {
	# Find all primes under a million
	largest.number <- 10^6
	range <- 1:(1*largest.number)
	primes <- isPrime(range)

	# Find the cumulative sum of all primes
	cumulative.sum <- cumsum(as.numeric(range[primes]))
	refined <- cumulative.sum < (largest.number)
	cumulative.sum <- cumulative.sum[refined]

	# This is the largest possible consectutive prime sum under a million.
	# This however is not the solution...
	largest.sequence <- length(cumulative.sum)
	number.of.primes <- sum(primes)

	# This total will be replaced by anything that is found above it
	max.total <- 0
	final.target <- NULL

	for(i in order(1:largest.sequence,decreasing = T)) {
		for(j in 1:(number.of.primes - largest.sequence + 1)) {
			target <-( (1:i)+(j-1))

			# Print message
			if (verbose) print(target)

			if(length(target) == 1) break
			new.total <- sum(range[primes][target])

			# Print message
			if (verbose) print(paste0("New total is : ",new.total))


			if (new.total > largest.number) {
				break
			} else if (primes[new.total] && new.total>max.total) {

				# Final check
				max.total <- new.total
				final.target <- target
				return(max.total)
			}
		}
	}

}

