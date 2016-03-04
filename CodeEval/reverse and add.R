test <- "195"

rotate <- function(start){
	n <- nchar(as.character(start))
	rotate <- 0
	for(i in n:1){
		diff <- start%%10
		start <- floor(start/10)
		rotate <- rotate + diff*10^(i-1)
	}
	rotate
}
sumRotate <- function(num) {
	rotate(num) + num
}
isPalindrome <- function(num) {
	string <- unlist(strsplit(as.character(num),""))
	n <- length(string)
	output <- T
	for(i in 1:n) {
		output <- string[i] == string[n + 1 - i]
		if(!output) break
	}
	output
}
findPalindrome <- function(value){
	iterations <- 0
	is.palindrome <- isPalindrome(value)
	while(!is.palindrome || iterations == 50) {
		value <- sumRotate(value)
		is.palindrome <- isPalindrome(value)
		iterations <- iterations + 1
	}
	cat(paste0(iterations," ",as.character(value)))
}

for(i in 1:10000) {findPalindrome(i); cat("\n")}
