max <- 987654321

digits <- function(x) {
	rem <- x
	total <- 0
	while(rem >= 1) {
		rem <- rem/10
		total <- total + 1
	}
	total
}

isPalindrome <- function(x) {
	digits <- as.numeric(unlist(strsplit(as.character(x),"")))
	n <- length(digits)
	
	for (i in 1:n) {
		if(!i %in% digits) return(F)
	}
	
	return(T)
}

found <- F

while(!found) {
	max <- previousPrime(max)
	found <- isPalindrome(max)
}


print(found)
