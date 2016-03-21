findSquareSums <- function(total) {
	cap <- ceiling(sqrt(total))
	diff <- integer()
	positive.results <- list()

	z <- 1
	next.candidate <- 1
	candidates <- c()

	while(next.candidate < total) {

		candidates <- append(candidates, next.candidate)
		z <- z + 1
		next.candidate <- z^2
	}
	print(candidates)

	# Find first possible power
	for (i in candidates) {
		first.power <- sqrt(i)
		diff <- total - first.power

		# Find second possible power
		for(j in candidates[candidates < diff]) {
			second.power <- j^2
			if(first.power + second.power == total) {
				positive.results <- append(positive.results, list(sort(c(i,j))))
				break
			}
		}
	}

	unique(positive.results)
}

findSquareSums(1)
cat(length(findSquareSums(as.numeric("2147483647"))), "\n")
cat(length(findSquareSums(as.numeric("25"))), "\n")
