# Euler 29
a <- 2:100
b <- 2:100
length(unique(as.vector(sapply(a, function(x){sapply(x,`^`,b)}))))
