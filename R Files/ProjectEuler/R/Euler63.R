# Euler 63

digitCount <- function(number) {
  x <- number %/% 10
  if (number != Inf) {
    count <- 1
    while (x != 0){
      x <- x %/% 10
      count <- count + 1
    }
  } else {
    count <- NaN
  }
  count
}

range.powers <- 1:50
range.input <- 1:1000

powers <- sapply(range.input,function (x) {sapply(range.powers,function (y) {x^y})})
count <- apply(powers,2,function (x) {sapply(x,digitCount)})  
equal <- matrix(nrow = dim(count)[1], ncol = dim(count)[2])
for (i in range.powers) {
  equal[i,] <- sapply(count[i,], function (x) {x == range.powers[i]})
}
sum(equal)
