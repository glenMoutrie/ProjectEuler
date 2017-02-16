#' Euler 49
#'
#' Finds the sequences which are 4 digits long, share the same digits, are prime and are
#' an arithmetic sequence.
#'
#' @return
#' @export
euler49 <- function() {

	# Get possible digits accounting for the possiblility of repeated digits
	possible.dig <- combn(floor(seq(1,9.9,0.25)),4)
	possible.dig <- split(t(possible.dig), 1:ncol(possible.dig))

	# Remove unique values
	possible.dig <- lapply(possible.dig, sort)
	possible.dig <- unique(possible.dig)

	# Convert to numbers
	possible.dig <- lapply(possible.dig, bindDigits)

	# Get possible sequences of digits
	sequences <- lapply(possible.dig, allPermutations)

	# Get all prime values
	primes <- lapply(sequences, isPrime)
	primes <- mapply(function(values, primes) {values[primes]}, values = sequences, primes = primes)
	primes <- primes[sapply(primes, length) > 0]

	# Find the arithmetic sequences and return them
	primes <- primes[sapply(primes, length) > 2]
	differences <- lapply(primes,findArithmeticSeq, seq.length = 3)
	differences[!sapply(differences, is.null)]

}

