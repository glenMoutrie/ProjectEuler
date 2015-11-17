library(numbers)
library(gtools)

# Find pandigital numbers in revers

possible.digits <- c("9","8","7","6","5","4","3","2","1","0")
checkPrime <- function(x) {
  num <- 0
  for(i in seq(9,1)){
    num <- num + x[i]*10^(10-i)
  }
  num
  # result <- isPrime(num/10)
  }
permutations <- permutations(n = 9, r = 9, v = 0:9)
permutations <- permutations[permutations[,9]%%2!=0,]

total <- nrow(permutations)
is.prime <- checkPrime(as.character(permutations[total,]))


results <- apply(permutations,1,checkPrime)
total <- length(results)
iteration <- 1
is.prime <- F
while(!is.prime) {
  is.prime <- isPrime(results[total - iteration])
  iteration <- iteration + 1
}
print(results[total - (iteration -1) ])

print(permutations[total - iteration,]

# Silly brute force method:
# primes <- isPrime(10^10)
