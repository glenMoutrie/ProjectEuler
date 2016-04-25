getTriangle <- function(n) {
	n*(n + 1)/2
}

getPentagonal <- function(n) {
	n*(3*n-1)/2
}

getHexagonal <- function(n) {
	n*(2*n-1)
}

range <- 1:100000

tri <- sapply(range, getTriangle)
pent <- sapply(range, getPentagonal)
hex <- sapply(range, getHexagonal)

sapply(which(tri %in% pent & tri %in% hex), getTriangle)
