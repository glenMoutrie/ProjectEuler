#' Euler 21
#'
#' Finds the sum of amicable numbers under the target number
#'
#' @param target 10000 by default
#'
#' @return
#' @export
euler21 <- function(target = 10000) {

	sum.all.under <- lapply(1:target,sumOfDivisors)
	amicable.number <- rep(F,target)

	for(x in seq_along(sum.all.under)) {
		if(!amicable.number[x] && x != sum.all.under[[x]]) {
			amicable.number[x] <- tryCatch(sum.all.under[[sum.all.under[[x]]]]==x,
																		 error = function(e){F})
			if(amicable.number[x]) {
				amicable.number[sum.all.under[[x]]] <- T
			}
		}
	}

	sum(seq_along(sum.all.under)[amicable.number])

}
