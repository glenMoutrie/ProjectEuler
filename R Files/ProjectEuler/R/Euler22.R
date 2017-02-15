#' Euler 22
#'
#' Solves the names scores problem given a names text file
#'
#' @param src Location of the text file, comma deliminated.
#'
#' @return
#' @export
#'
#' @examples
euler22 <- function(src = "~/Documents/Data/p022_names.txt") {
	# Import data (actually comes in as column names)
	x <- fread(src)
	x <- names(x)

	# Create letter scores
	letter.scores <- 1:length(LETTERS)
	names(letter.scores) <- LETTERS

	# Apply letter scores
	x <- sapply(x,function(y){strsplit(y,split = "")})
	x <- lapply(x,function (y) {sum(letter.scores[y])})

	# Score by the names order
	order.score <- 1:length(x)
	names(order.score) <- sort(names(x))

	# Multiply and find the maximum
	results <- sapply(names(x),function (y) {x[[y]]*order.score[y]})

	sum(results)
}
