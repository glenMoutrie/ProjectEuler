#' Euler 39
#'
#' Finds the larest number of pythagorean triples for a single perimeter value less then
#' a given value.
#'
#' @param max.value Largest perimeter to consider
#'
#' @return Numeric result
#' @export
#'
#' @examples
euler39 <- function(max.value = 1000) {
	# Generate all possible integer values of a and c
	n <- expand.grid(1:max.value,1:max.value)

	# Generate feasible p values
	p.values <- mapply(getTrianglePerimeter,n[,1],n[,2])

	# Remove non-integer values and values above 1000
	p.values <- p.values[p.values%%1 == 0 & p.values < 1000]

	# The result
	as.numeric(names(which.max(table(p.values))))
}

