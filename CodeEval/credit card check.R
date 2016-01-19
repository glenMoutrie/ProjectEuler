test <- "9999 9999 9999 9999"
index <- seq(1,16,2)

values <- as.numeric(unlist(strsplit(gsub(" ", "", test),"")))

check <- function(values, index = double) {
	if((sum(values[index]*2) + sum(values[-index]))%%10 == 0) {
		cat("Real")
	} else {
		cat("Fake")
	}
	cat("\n")
}
