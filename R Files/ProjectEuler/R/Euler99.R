#' Euler 99
#'
#' Solves euler 99, finding the largest exponent given a series
#' of exponents and values in a csv.
#'
#' @param src CSV location
#'
#' @export
euler99 <- function(src = "~/Downloads/p099_base_exp.csv") {
	data <- fread(src)
	data[, total := V2*log(V1)]
	which.max(data[,total])
}
