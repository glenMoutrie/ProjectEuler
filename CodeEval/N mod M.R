15 %% 0


myOwnMod <- function(n,m) {
	frac <- (n/m)
	cat((frac - floor(frac))*m, "\n")
}

stringMod <- function(string) {
	split <- as.numeric(unlist(strsplit(string,",")))
	myOwnMod(split[1],split[2])
}

stringMod("15,7")
