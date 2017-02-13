#' Euler 19
#'
#' Solves Euler 19 using the lubridate package. This effectively acts as a counter of Sundays
#' that fall on the first day of the month
#'
#' @param start Start date
#' @param end End date
#'
#' @return Total Sundays on the First of the month
#' @export
euler19 <- function(start = as.Date("1901-01-01"), end = as.Date("2000-12-01")) {

	# Create sequence of days
	all.days <- seq(start,end, by="day")

	# Check for sundays
	sundays <- rep(1:7,length.out=length(all.days)) == 6

	# Check for first day of the month
	first.day <- day(all.days) == 1

	# Sum the total
	sum(sundays & first.day)

}
