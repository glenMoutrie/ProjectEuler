#' Checks to see if a value in the unit interval
#'
#' If a value between 0 and 1 inclusive this will return a true booleon
#'
#' @param x A numeric value to check
#'
#' @return Boolean value
#' @export
unitValue <- function(x) {
	0 <= x && x <= 1
}

#' Splits a number into a string of digits
#'
#' @param number A number to convert to digits
#'
#' @return
#' @export
#'
#' @examples
stringDigits <- function(number){
	unlist(strsplit(as.character(number),""))
}

#' Get numerical digits of a number through strings
#'
#' This converts the number to a string, splitting the string then converting back to a number
#'
#' @param number Number to get numerical digits of
#'
#' @return Named array of digits
#' @export
#'
#' @examples
#' getDigitsStrSplit(123)
getDigitsStrSplit <- function(number) {
	sapply(stringDigits(number), as.numeric)
}

#' Compare two numbers digits
#'
#' If two numbers have the same digits this function will return a true statement
#'
#' Used in Euler 52
#'
#' @param first.number First numeric to compare
#' @param second.number Second numeric to compare
#'
#' @return Boolean
#' @export
#'
#' @examples
digitMatch <- function(first.number, second.number) {
	all(stringDigits(first.number) %in% stringDigits(second.number)) && all(stringDigits(second.number) %in% stringDigits(first.number))
}


#' Find a hidden arithmetic sequence
#'
#' Given a sequence of sorted numbers this function will see if there are combinations of numbers
#' which can form an arithmetic sequence. The first found sequence will be returned.
#'
#' Used in Euler 49
#'
#' @param x Vector of numbers
#' @param seq.length Minimum sequence length
#'
#' @return
#' @export
#'
#' @examples
#' findArithmeticSeq(c(5,1,6,9,2,3,4,5,6,7,8,9), 3)
findArithmeticSeq <- function(x, seq.length = 3) {

	# Quick asserts
	if (seq.length <= 2) stop("seq.length must be greater than 2")
	if (!is.numeric(x)) stop("x must be numeric")
	if (length(x) <= 2) stop("The length of x must be greater or equal to 2")

	# Set key parameters
	n <- length(x)
	count <- 0
	start <- 1

	# Loop to find the start of the sequence
	while (count < seq.length && start < n) {

		# Loop to find a matching sequence
		for (i in (start + 1):n) {

			# Find the difference
			step <- x[i] - x[start]

			# Need positive integer steps
			if (step < 1) next

			# Generate the sequence
			exp.seq <- seq(x[start], x[n] + 1,step)

			# See if the expected values match the collection of numbers
			matches <- x %in% exp.seq

			# Calculate the var of differences, and check of NA's
			var.of.diff <- var(diff(x[matches]))
			if (is.na(var.of.diff)) next

			# Assert that the matches themselves are an arithmetic sequence
			if (sum(matches) == seq.length && var.of.diff == 0) {
				count <- sum(matches)
				break
			}

		}

		# See if a sufficient sequence has been found
		if (count == seq.length) {
			return(x[matches])
		}

		# Increment the starting index
		start <- start + 1

	}

	# If there is no sequence return null
	NULL

}

#' Get the number of digits in a number
#'
#' Will return the number of digits in a number
#'
#' @param x Positive integer
#'
#' @return
#' @export
#'
#' @examples
#' digits(123)
digits <- function(x) {
	rem <- x
	total <- 0
	while(rem >= 1) {
		rem <- rem/10
		total <- total + 1
	}
	total
}

#' Get the digits of a number
#'
#' Returns a numeric vector of an integers digits.
#'
#' @param x An integer
#'
#' @return An integer array
#' @export
#'
#' @examples
#' getDigits(123)
getDigits <- function(x) {
	digits <- c()
	while (x >= 1) {
		digits <- append(x %% 10, digits)
		x <- floor(x/10)
	}

	digits

}

#' Bind digits to number
#'
#' Given a numeric vector of digits this function will return the number
#'
#' @param x Numeric vector
#'
#' @return Number
#' @export
#'
#' @examples
#' bindDigits(c(1,2,3,4))
bindDigits <- function(x) {
	output <- 0
	multiple <- 1

	for (i in rev(x)) {
		output <- output + (multiple*i)
		multiple <- multiple*10
	}

	output
}

#' Check if integer is palindrom
#'
#' Checks if an integer is a palindrome
#'
#' @param x Integer number
#'
#' @return Boolean
#' @export
#'
#' @examples
#' isPalindrome(1234)
#' isPalindrome(12344)
isPalindrome <- function(x) {

	# Split number and get digits
	digits <- as.numeric(unlist(strsplit(as.character(x),"")))
	n <- length(digits)

	# Check all digits are there
	for (i in 1:n) {
		if(!i %in% digits) return(F)
	}

	# Return true if test passes
	return(T)
}

#' Get next lexicographical permutation of list
#'
#' Given a list, this function can iteratively find every permutation of the list in
#' lexicographic order.
#'
#' @param x Numeric vector
#' @param direction "UP" or "DOWN"
#' @param find.all For internal use in allPermutations
#'
#' @return Numeric Vector
#' @export
#'
#' @examples
#' permutate(c(1,2,3), "UP")
#' permutate(permutate(c(1,2,3), "UP"))
permutate <- function(x, direction = "UP", find.all = F) {

	# Basic setup
	up <- direction == "UP"
	n <- length(x)
	k <- NULL
	l <- NULL

	# Comparing function
	compare <- ifelse(up, `<`, `>`)


	# Quick checks
	if (n < 1) stop("x must be longer than 1")

	# Find K
	for (i in (n-1):1) {
		if (compare(x[i], x[i + 1])) {
			k <- i
			break
		}
	}

	if (is.null(k) && !find.all){
		stop("No further perumtations")
	} else if (is.null(k)) {
		return(NULL)
	}

	# Find l
	for (i in n:1) {
		if (compare(x[k], x[i])) {
			l <- i
			break
		}
	}

	# Make the update
	holder <- x[l]
	x[l] <- x[k]
	x[k] <- holder

	to.rev <- (k + 1):n

	if (length(to.rev) > 0) x[to.rev] <- x[rev(to.rev)]

	x
}

#' Get all digit permutations of a number
#'
#' This function finds all digit permutations of a number in lexicographical order. That
#' order is defined by direction. Note that this is done incrementally, so \code{allPermutations(1234,"DOWN")}
#' will only return 1234.
#'
#' @param x Number whos digits permutations should be found
#' @param direction Direction of permutation
#'
#' @return
#' @export
#'
#' @examples
allPermutations <- function(x, direction = "UP") {
	output <- c()

	getNext <- function(x) {
		x <- permutate(getDigits(x),find.all = T, direction = direction)
		if (is.null(x)) return(x)
		bindDigits(x)
	}

	while (!is.null(x)) {
		output <- append(output, x)
		x <- getNext(x)
	}

	output

}

#' Calculate the sum of viable divisors
#'
#' This function tallys the sum of divisors for a number.
#'
#' @param x Integer
#'
#' @return
#' @export
#'
#' @examples
#' sumOfDivisors(25)
sumOfDivisors <- function(x) {
	sum <- 0
	i <- 1
	for(i in 1:(0.5*x)) {
		if(x%%i == 0) {
			sum <- sum + i
		}
	}
	sum
}

#' Find factors of a number
#'
#' This function returns the factors of an integer
#'
#' @param number Integer
#'
#' @return
#' @export
#'
#' @examples
#' factorFinder(10^3)
factorFinder <- function(number) {

	# Create a bunch of meta shit
	end.point <- sqrt(number)
	divisor <- c()
	other.divisor <- c()
	is.proper <- F
	result <- c()

	# Finally get your arse around to doing something with them
	for(i in 1:end.point){
		divisor <- number%%i
		if(divisor == 0) {
			result[length(result) + 1] <- i

			# Make an efficiency saving by considering only  up to square points
			other.divisor <- number/i
			if(other.divisor!=i){
				result[length(result) + 1] <- other.divisor
			}

		}
	}

	# Return your shit.
	result
}
