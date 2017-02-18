#' Euler 37
#'
#' Finds the number of truncatable primes. Longest part is finding all primes below the max.value, this is only done
#' once and the primes are reused throughout.
#'
#' The code here isn't beautiful, but it gets the job done. I don't like the way I hand over the primes.
#'
#' @param max.value Maximum value to search over
#' @param verbose Prints information if true
#'
#' @return Integer values
#' @export
euler37 <- function(max.value = 1000000, verbose = F) {


	# Check the truncatable primes
	checkTruncatablePrime <- function(number, verbose){
		is.truncatable <- F

		# Do both directions
		for(firstMethod in c("left","right")){

			string.type <- strsplit(as.character(number),"")[[1]]

			# Choose first Method
			if (firstMethod == "left") {
				first <- removeLeft
				second <- removeRight
			} else {
				first <- removeRight
				second <- removeLeft
			}

			# We are trying to say when this isn't the case,
			# For then we will stop the process
			if (firstMethod == "left") {
				still.prime <- T
			}

			while(still.prime){

				# Check the first method
				result <- first(string.type)
				string.type <- result$string
				still.prime <- result$primecheck

				if (verbose) print(paste0("Number ",result$number," is prime: ",result$primecheck,"; Line 65; Method = ", firstMethod))

				# Check if the search can be stopped
				if (result$length < 2 || !still.prime) {
					break
				}

			}

			# If still prime on second run
			if (firstMethod == "right" && still.prime) {
				is.truncatable <- T
			} else if (!still.prime) {
				break
			}
		}
		is.truncatable
	}

	# Remove left and right functions
	removeLeft <- function(number.string) {
		number.string <- number.string[-length(number.string)]
		digits.left <- length(number.string)
		number <- as.numeric(paste0(number.string,collapse = ""))
		if(is.na(number) || number == 0) {
			is.prime <- F
		} else {
			is.prime <- primes[number]
		}
		list(number = number,string = number.string, length = digits.left, primecheck = is.prime)
	}

	removeRight <- function(number.string) {
		number.string <- number.string[-1]
		digits.left <- length(number.string)
		paste0(number.string,collapse = "")
		number <- as.numeric(paste0(number.string,collapse = ""))
		if(is.na(number) || number == 0) {
			is.prime <- F
		} else {
			is.prime <- primes[number]
		}
		list(number = number,string = number.string, length = digits.left, primecheck = is.prime)
	}

	range <- 1:max.value
	primes <- isPrime(range)
	result <- sapply(range[primes], checkTruncatablePrime, verbose = verbose)
	sum(range[primes][result])
}
