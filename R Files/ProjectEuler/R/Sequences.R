#' Estimate a triangular number
#'
#' @param n Which traingular number
#'
#' @return Triangular number
#' @export
#'
#' @examples
#' getTriangle(10)
getTriangle <- function(n) {
	n*(n + 1)/2
}

#' Estimate a pentagonal number
#'
#' @param n Which pentagonal number
#'
#' @return Pentagonal number
#' @export
#'
#' @examples
#' getPentagonal(10)
getPentagonal <- function(n) {
	n*(3*n-1)/2
}

#' Estimate a hexagonal number
#'
#' @param n Which hexagonal number
#'
#' @return Hexagonal number
#' @export
#'
#' @examples
#' getHexagonal(10)
getHexagonal <- function(n) {
	n*(2*n-1)
}
