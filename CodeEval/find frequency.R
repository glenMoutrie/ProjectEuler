input <- read.csv("Documents/ProjectEuler/CodeEval/frequency.txt",header = F)
input <- sapply(input,as.character)

cleaned <- as.data.frame(apply(input,1, function (x) {as.numeric(unlist(strsplit(x," ")))}))
test <- sapply(cleaned, function (x) {which(rank(fft(x))==1)})
