#' Euler 16
#'
#' Solves Euler 16
#'
#' @return Solution
#' @export
#'
#' @examples
#' euler16()
euler16 <- function() {
	options(scipen=999)
	sum(getDigitsStrSplit(2^1000))
}
