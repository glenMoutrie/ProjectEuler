#' Euler 53
#'
#' Sums combinations of combinations.
#'
#' @return
#' @export
euler53 <- function() {
	all.values <- matrix(NA, nrow = 100, ncol = 100)

	for (n in 1:100){
		for (m in 1:100) {
			all.values[n,m] <- choose(n,m)
		}
	}

	sum(all.values > 10^6)
}

