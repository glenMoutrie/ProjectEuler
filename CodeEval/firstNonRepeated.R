firstNonRep <- function(input) {
	split <- unlist(strsplit(input, ""))
	repeated <- names(which(table(split) > 1))
	if(length(repeated) >= 1) {
		split <- split[!split%in%repeated]
	}
	cat(split[1],"\n")
}
firstNonRep("yellow")
firstNonRep("cat")
firstNonRep("tooth")