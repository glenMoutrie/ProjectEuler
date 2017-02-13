#' Euler 52
#'
#' Returns the solution for Euler 52, which is the smallest number x such that
#' x, 2x, 3x, 4x, 5x, and 6x have the same digits
#'
#' @return Number which solves Euler 52
#' @export
#'
#' @examples
#' euler52()
euler52 <- function() {
	match <- F
	number <- 0

	while(!match){
		number <- number + 1
		for(x in 2:6){

			if(!digitMatch(number,x*number)){
				break
			} else if (x == 6) {
				match <- T
			}
		}
	}

	number
}

