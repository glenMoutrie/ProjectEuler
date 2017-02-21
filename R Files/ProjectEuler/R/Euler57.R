#' Euler 57
#'
#' Solves Euler 57, creating the continued fraction and counting the number of times
#' the numerator is larger than the denominator.
#'
#' @param n Size to test to
#'
#' @return Solution
#' @export
euler57 <- function(n = 10^3) {
	d <- denominatorSequence(n)
	n <- numeratorSequence(n)

	sum(sapply(d,digits) < sapply(n,digits))

}

# The below functions are utilities to generate the continued fraction. This may be able to be
# abstracted for most if not all continued fractions, but is a little too bespoke for this problem
# at this point of time.
update <- function(d.lag.1, d.lag.2) {
	(d.lag.1 * 2) + d.lag.2
}

denominatorSequence <- function(n, include.one = F) {
	output <- integer(n + 1)
	output[1] <- 1
	output[2] <- 2

	i <- 3

	while (i <= n + 1) {

		output[i] <- update(output[i-1],output[i-2])

		i <- i + 1

	}

	if (include.one) {

		return(output)

	} else {

		return(output[-1])

	}

}

numeratorSequence <- function(n) {
	denom <- denominatorSequence(n, T)
	output <- integer(n)
	j <- 1

	for(i in 2:(n + 1)) {
		output[j] <- denom[i] + denom[i - 1]
		j <- j + 1
	}

	output

}


