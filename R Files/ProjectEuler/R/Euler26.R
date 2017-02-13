# Euler 26
fractions <- as.character(sapply(2:1000,function(x) {1/x}))
split.fractions <- lapply(fractions,strsplit,"")
split.fractions <- lapply(split.fractions, function(x) {x[[1]][-c(1,2)]})
fraction.length <- sapply(split.fractions,length)
longest <- split.fractions[fraction.length == max(fraction.length)]
