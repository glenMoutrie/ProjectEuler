#' Euler 13
#'
#' Solves the large number sum given a csv of each of the values
#'
#' @param src Location of csv
#'
#' @return Solution as string
#' @export
euler13 <- function(src = "~/Documents/java/ProjectEuler/input13.csv") {
	numbers <- read.csv(src,header = F)
	substr(format(sum(numbers),scientific = F), 0, 10)
}

