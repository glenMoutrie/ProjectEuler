library(data.table)
words <- as.vector(t(read.csv("Downloads/p042_words.csv",header = F)))

letterValue <- function(letter) {
	output <- which(LETTERS == letter)
	if (length(output) == 0) {
		output <- which(letters == letter)
	}
	output
}

splitWord <- function(word) {
	unlist(strsplit(word, ""))
}

wordValue <- function(word) {
	sum(sapply(splitWord(word), letterValue))
}

generateTriangularNumbers <- function (max) {
	output <- 1
	n <- 1
	while (tail(output,1) < max) {
		output <- append(output, (0.5*n*(n+1)))
		n <- n + 1
	}
	output
}

test <- sapply(words, wordValue)

triangular <- generateTriangularNumbers(max(test))
sum(test %in% triangular)