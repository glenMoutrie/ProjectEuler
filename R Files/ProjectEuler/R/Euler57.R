update <- function(d.lag.1, d.lag.2) {
	(d.lag.1 * 2) + d.lag.2
}

denominatorSequence <- function(n, include.one = F) {
	output <- integer(n + 1)
	output[1] <- 1
	output[2] <- 2

	i <- 3

	while (i <= n + 1) {

		output[i] <- update(output[i-1],output[i-2])

		i <- i + 1

	}

	if (include.one) {

		return(output)

	} else {

		return(output[-1])

	}

}

numeratorSequence <- function(n) {
	denom <- denominatorSequence(n, T)
	output <- integer(n)
	j <- 1

	for(i in 2:(n + 1)) {
		output[j] <- denom[i] + denom[i - 1]
		j <- j + 1
	}

	output

}


n <- 10^3
d <- denominatorSequence(n)
n <- numeratorSequence(n)

sum(sapply(d,digits) < sapply(n,digits))
