test <- "A quick brown fox jumps over the lazy dog"
test <- "A slow yellow fox crawls under the przoactive dog"
tryCatch({
	excluded <- letters[!sapply(sapply(letters,grep,test),length)>0]
	if(length(excluded) == 0){
		cat("NULL")
	} else {
		cat(paste0(excluded,collapse = ""))
	}
}, error = function(e) {cat(test)})
cat("\n")