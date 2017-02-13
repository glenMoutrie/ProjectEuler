#' Checks to see if a value in the unit interval
#'
#' If a value between 0 and 1 inclusive this will return a true booleon
#'
#' @param x A numeric value to check
#'
#' @return Boolean value
#' @export
unitValue <- function(x) {
	0 <= x && x <= 1
}

#' Splits a number into a string of digits
#'
#' @param number A number to convert to digits
#'
#' @return
#' @export
#'
#' @examples
stringDigits <- function(number){
	unlist(strsplit(as.character(number),""))
}

#' Get numerical digits of a number through strings
#'
#' This converts the number to a string, splitting the string then converting back to a number
#'
#' @param number Number to get numerical digits of
#'
#' @return Named array of digits
#' @export
#'
#' @examples
#' getDigitsStrSplit(123)
getDigitsStrSplit <- function(number) {
	sapply(stringDigits(number), as.numeric)
}

#' Compare two numbers digits
#'
#' If two numbers have the same digits this function will return a true statement
#'
#' Used in Euler 52
#'
#' @param first.number First numeric to compare
#' @param second.number Second numeric to compare
#'
#' @return Boolean
#' @export
#'
#' @examples
digitMatch <- function(first.number, second.number){
	all(stringDigits(first.number) %in% stringDigits(second.number)) && all(stringDigits(second.number) %in% stringDigits(first.number))
}
