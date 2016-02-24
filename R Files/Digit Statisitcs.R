generateSeriesBad <- function (a, n) {
	series <- rep(a,n)
	series <- mapply("^",series,1:n)
	getLast <- function(x) {n <- nchar(x); substring(x,n,n)}
	sapply(as.character(series),getLast)
	# series%%10
}
#
t <- 0
for (i in 1:9) {
	x <- generateSeriesBad(i,100)
	cat(paste0(generateSeriesBad(i,100), collapse = " "),"\n")
	t <- sum(x == 0)
}

# 1 always
# 2 4 8 6 repeated
# 3 9 7 1 repeated
# 6 4 repeated
# 5 always
# 6 always
# 7 9 3 1 repeated
# 8 4 2 6 repeated
# 9 1 repeated

patterns <- list(
	one = 1,
	two = c(2, 4, 8, 6),
	three = c(3, 9, 7, 1),
	four = c(6,4),
	five = 5,
	six = 6,
	seven = c(7,9,3,1),
	eight = c(8,4,2,6),
	nine = c(9,1))

repPattern <- function(a, totals, n) {
	rep <- length(patterns[[a]])
	total <- floor(n/rep)
	totals[patterns[[a]]] <- total
	remain <- n%%rep
	
	if(remain != 0) {
		totals[patterns[[a]][1:remain]] <- total + 1
	}
	
	totals
}

buildInputs <- function(string) {
	lapply(unlist(strsplit(string," ")),as.numeric)
}

generateSeries <- function (a, n) {
	totals <- rep(0,9)
	if (a == 1 || a == 5 || a == 6) {
		totals[a] <- n
	} else {
		totals <- repPattern(a = a, totals = totals, n = n)
	}
	totals
}

clean <- function (x) {
	x <- sapply(x, format, scientific = 20,simplify = T)
	indPaste <- function(x,y) {paste0(x,": ",y,", ")}
	output <- mapply(indPaste,1:8,x[-9])
	paste0("0: 0, ",paste0(append(output, paste0("9: ",x[9])), collapse =""))
}
cat(clean(do.call(generateSeries,buildInputs("2 8"))),"\n")
# for (i in 1:9) {
# 	cat(paste0(generateSeriesBad(i,100), collapse = " "),"\n")
# }
# for (i in 1:9) {
# 	cat(paste0(generateSeries(i,10^9), collapse = " "),"\n")
# }
