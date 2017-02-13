euler80 <- function() {
	estimates <- sapply(1:100,function (i) {newtonRaphson(f = function (x){x^2 - i}, fPrime = function(x){2*x}, max.iterations = 100, tolerance = 10^(-100))})
}

