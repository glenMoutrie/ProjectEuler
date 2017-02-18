#' Euler 30
#'
#' A slow brute force method of finding the result. Could probably write a version in
#' java which would be much faster.
#'
#' @param max.value Largest integer value to consider
#'
#' @return
#' @export
euler30 <- function (max.value = 10^6) {

	# finds the vlaue ofeach values fifth power and sums it
	sumPowerFive <- function(x) {
		sum(sapply(x,"^",5))
	}

	successful.values <- c()
	for(i in 2:max.value){

		# See if it is the sum to the power of five and add the value
		if(i == sumPowerFive(getDigits(i))){
			successful.values[length(successful.values) + 1] <- i
		}
	}

	sum(successful.values)
}

