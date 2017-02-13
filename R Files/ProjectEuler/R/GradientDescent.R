#' Newton Raphson estimation
#'
#' Estimates a value given its location, function and first derivative.
#'
#' Allows the accuracy to be specified along with max iterations.
#'
#' Used in Euler 80
#'
#' @param x0 Starting value
#' @param f Function
#' @param fPrime First derivate
#' @param tolerance Tolerance (defaults to 10^-7)
#' @param epsilon Minimum step size
#' @param max.iterations Max iterator
#'
#' @return Estimated value
#' @export
#'
#' @examples
#' sapply(1:10,function (i) {newtonRaphson(f = function (x){x^2 - i},
#' fPrime = function(x){2*x},
#' max.iterations = 100,
#' tolerance = 10^(-100))})
newtonRaphson <- function(x0 = 1, f, fPrime, tolerance = 10^(-7), epsilon = 10^(-14),
													max.iterations = 20){
	solution.found <- F

	for(i in 1:max.iterations) {
		y <- f(x0)
		y.prime <- fPrime(x0)

		# Ensure you don't divide by too small of a number
		if(abs(y.prime) < epsilon) {
			# Denominator is too small
			break
		}

		# Do newton's computation
		x1 <- x0 - (y/y.prime)

		# If the result is within the desired tolerance
		if (abs(x1 - x0) <= tolerance*abs(x1)){
			solution.found <- T
			break
		}

		x0 <- x1
	}

	if(solution.found) {
		message("Succesful estimation")
	} else {
		message("Sucks to be you. No convergence.")
	}

	return(x0)
}
