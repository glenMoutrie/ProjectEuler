#' Euler 23
#'
#' This is a fairly brute forshish solution. This is due to the factor finder, which
#' should be made to be more efficient. Nonetheless the computation time involved is
#' 44 seconds.
#'
#' @return
#' @export
euler23 <- function() {

	# We know this from the question, now find the sum of proper divisors for each
	range <- 1:28123
	divisor.sums <- sapply(range,sumOfProperDivisors)
	abundent <- mapply("<",range,divisor.sums)

	# Find the sums of all abundent values
	abundent.values <- range[abundent]
	sum.of.sums <- sapply(abundent.values,
												function (x) {sapply(abundent.values,function (y) {x+y})})

	# As it is a symmetric matrix
	abundent.sums <- unique(sum.of.sums[upper.tri(sum.of.sums,diag = T)])

	# The final result
	sum(range[!(range %in% abundent.sums)])
}

sumOfProperDivisors <- function(number){
	sum(factorFinder(number)) - number
}
