result <- 0
spaces <- "  "
multiples <- 1:12
for(i in multiples) {
	for (j in multiples) {
		result <- i*j
		if(result < 10) {
			spaces <- "   "
		} else {
			spaces <- ifelse(result < 100, "  ", " ")
		}
		cat(paste0(spaces, result))
	}
	cat("\n")
}
