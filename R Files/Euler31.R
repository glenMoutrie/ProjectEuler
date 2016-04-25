
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
# options(expressions = 10^5)
# sapply(1:100,onePound)

sum(seq(from = 0, to = 4, by = 2)) + 1
