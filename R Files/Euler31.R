
twoPence <- function (amount) {
	(amount %/% 2) + 1
}

fivePence <- function(amount) {
	maximum.five <- (amount %/% 5)
	
	sum(sapply(amount - ((0:maximum.five)*5), twoPence))
}

tenPence <- function(amount) {
	maximum.ten <- (amount %/% 10)
	
	sum(sapply(amount - ((0:maximum.ten)*10), fivePence))
}

twentyPence <- function(amount) {
	maximum.twenty <- (amount %/% 20)
	
	sum(sapply(amount - ((0:maximum.twenty)*20), tenPence))
}

fiftyPence <- function(amount) {
	maximum.fifty <- (amount %/% 50)
	
	sum(sapply(amount - ((0:maximum.fifty)*50), twentyPence))
}

onePound <- function(amount) {
	maximum.pound <- (amount %/% 100)
	
	sum(sapply(amount - ((0:maximum.pound)*100), fiftyPence))
}

fiftyPence <- function(amount) {
	maximum.two.pound <- (amount %/% 200)
	
	sum(sapply(amount - ((0:maximum.two.pound)*200), onePound))
}

# This doesn't work, recursion is too deep.
# options(expressions = 10^5)
# sapply(1:100,onePound)

amount <- 200
total <- 0

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
total
			
			