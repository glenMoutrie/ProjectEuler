stringPermutations <- function(input) {
	
	x <- nchar(input)
	comb <- expand.grid(data.frame(matrix(rep(1:x,x),x,x)))
	comb <- comb[!apply(comb,1,function(x) any(duplicated(x))),]
	
	split <- unlist(strsplit(input,""))
	
	getPermutation <- function (x) {
		paste0(unlist(strsplit(input,""))[x], collapse = "")
	}
	
	string.permutations <- apply(comb, 1, getPermutation)
	paste0(sort(string.permutations), collapse = ",")
	
}

stringPermutations("hat")
stringPermutations("abc")
stringPermutations("6Zu")
