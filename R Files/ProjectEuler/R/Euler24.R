#' Euler 24
#'
#' @param possible.digits
#' @param target.permutation
#' @param verbose
#'
#' @return
#' @export
euler24 <- function(possible.digits = 0:9, target.permutation = 10^6, verbose = F) {

	# Paramters needed
	permutation <- 0 # Which lexicographical permutation
	iteration <- 0 # Which iteration on digit
	digit <- 0
	number <- c()

	# Iterate over each possible size of digit
	while(length(number)<10){

		# The number of permutations for each lexicographical iteration of this digit
		each.digit.permutation <- factorial(9-length(number))

		# Updating the size of the digit
		digit <- length(number) + 1

		# Iterate through the lexicographical order
		for(iteration in possible.digits) {
			number[digit] <- iteration
			permutation <- permutation + each.digit.permutation

			# Print meesage
			if (verbose) {
				print(paste0("Number: ",paste0(number,collapse = ""),", Permutation: ", permutation))
			}

			# If the permutation is higher than the target permutation, iterate back and break loop
			if(permutation >= target.permutation) {
				possible.digits <- possible.digits[-which(possible.digits%in%iteration)]
				permutation <- permutation - each.digit.permutation
				break
			}
		}

	}

	# Bind the array of digits
	bindDigits(number)
}
