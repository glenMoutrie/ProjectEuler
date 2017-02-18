#' Euler 3
#'
#' Finds the largest prime factor of a number. Uses primeFactors from the numbers
#' package so it is cheating a little.
#'
#' @param value Integer value to find prime factors of
#'
#' @return
#' @export
euler3 <- function(value = 600851475143) {
	max(primeFactors(600851475143))
}

