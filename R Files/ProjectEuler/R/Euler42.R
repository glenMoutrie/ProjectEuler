#' Euler 42
#'
#' Given a series of words, a numeric value for each will be assinged and each
#' triangular value will be added together
#'
#' @param src CSV file containing the words
#'
#' @return Integer value
#' @export
euler42 <- function(src = "~/Downloads/p042_words.csv") {

	# Import the words
	words <- as.vector(t(suppressWarnings(read.csv(src,header = F))))

	# Funtion which assigns the value for the letter
	letterValue <- function(letter) {
		output <- which(LETTERS == letter)
		if (length(output) == 0) {
			output <- which(letters == letter)
		}
		output
	}

	# Splits the word into letters
	splitWord <- function(word) {
		unlist(strsplit(word, ""))
	}

	# Calculates the word value
	wordValue <- function(word) {
		sum(sapply(splitWord(word), letterValue))
	}

	# Find the word numbers
	test <- sapply(words, wordValue)

	# Generate viable traingular numbers
	triangular <- generateTriangularNumbers(max(test))

	# Find the number of words which are triangular
	sum(test %in% triangular)
}
