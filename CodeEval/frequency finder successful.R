data <- suppressWarnings(read.table("Documents/ProjectEuler/CodeEval/frequency.txt"))

findFreq <- function(string) {
	data <- as.numeric(unlist(strsplit(string, " ")))
	cat(which.max(spec.pgram(data)$spec)*10,"\n")
}

plot.ts(t(data[1,]))
findf(t(data[1,]))
