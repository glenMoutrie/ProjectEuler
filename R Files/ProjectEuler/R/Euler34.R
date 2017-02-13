## Euler 34
# 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
# Find the sum of all numbers which are equal to the sum of the factorial of their digits.
# Note: as 1! = 1 and 2! = 2 are not sums they are not included.

splitNumber <- function(original) {
  string <- strsplit(as.character(original),split = "")[[1]]
  output <- as.numeric(string)
  output
}

# Find the limit for which there can no longer be any solutions
n <- 1:100
largest.possible.number <- sapply(n,function(x) {as.numeric(paste0(rep("9",length.out = x),collapse = ""))})
largest.possible.sum <- n*factorial(9)
possible <- largest.possible.number < largest.possible.sum

# Find solutions given limit
results <- sapply(3:10^(sum(possible)), function (i){
  if(sum(factorial(splitNumber(i))) == i) {
    result <- i
  } else {
    result <- 0
  }
})

# Produce the results
sum(results)