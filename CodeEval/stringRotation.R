stringRotation <- function(input) {
	split <- unlist(strsplit(input,","))
	check <- paste0(split[2], split[2])
	cat(ifelse(grepl(split[1],check),"True","False"),"\n")
}
stringRotation("Hello,lloHe")
