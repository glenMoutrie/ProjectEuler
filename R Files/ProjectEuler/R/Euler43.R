threeDigitViables <- function (div.by) {
	seq(0,999,div.by)
}

targets <- c(2,3,5,7,11,13,17)

lapply(targets, threeDigitViables)
