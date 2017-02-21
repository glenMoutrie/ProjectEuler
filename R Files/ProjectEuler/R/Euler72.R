
#' Euler 72
#'
#' Attempt at Euler 72, there is a working solution in java that uses the totient
#' equation.
#'
#' @return
#' @export
#'
#' @examples
euler72 <- function() {
	target <- 10^6
	phi <- 0:(target)
	result <- 0

	for(i in 3:target) {
		if (phi[i] == i) {
			cat("hit")
			for(j in seq(i, target, i)) {
				pi[j] <- phi[j]/(i*(i-1))
			}
		}

		result <- result + phi[i]

	}

	result
}

