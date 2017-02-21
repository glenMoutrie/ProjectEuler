#' Euler 92
#'
#' Attempt at euler 92
#'
#' @export
euler92 <- function() {
	# library(parallel)

	squareDigitSum <- function(x) {
		digits <- as.numeric(unlist(strsplit(as.character(x),"")))
		sum(sapply(digits,"^",2))
	}

	loopSquareSequence <- function(start) {

		next.value <- start
		result <- start

		while (!next.value %in% c(1,89)) {
			next.value <- squareDigitSum(tail(result,1))
			result <- append(result, next.value)
		}

		result
	}

	# sequences <- mclapply(1:10^7, loopSquareSequence)
	sequences <- lapply(1:10^7, loopSquareSequence)
	sum(sapply(sequences, tail, 1) == 1)

	# loopSquareSequence(44)
	# loopSquareSequence(85)
}
