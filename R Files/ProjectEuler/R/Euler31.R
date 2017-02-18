#' Euler 31
#'
#' Finds the total amount of ways a quantity of british pounds can be paid in coins
#'
#' @param amount Quantity to be paid in pence
#'
#' @return Number of ways the amount can be paid
#' @export
euler31 <- function(amount = 200) {

	# Total ways to pay amount
	total <- 0

	# Iterate over each coin and until remaining value is zero
	for (two.pounds in seq(from = amount, to = 0, by = -200)) {
		for (pound in seq(from = two.pounds, to = 0, by = -100)) {
			for (fifty in seq(from = pound, to = 0, by = -50)) {
				for (twenty in seq(from = fifty, to = 0, by = -20)) {
					for (ten in seq(from = twenty, to = 0, by = -10)) {
						for (five in seq(from = ten, to = 0, by = -5)) {
							for (two in seq(from = five, to = 0, by = -2)) {total <- total + 1}
						}
					}
				}
			}
		}
	}

	# Return result
	total
}



