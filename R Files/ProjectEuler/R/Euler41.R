# library(numbers)
pandigital.numbers <- matrix(NA,nrow = sum(factorial(1:9)),ncol = 9)
index.number <- c()
# primes <- isPrime(1:987654321)
previous.factorial <- 1
pandigital.numbers[1,1] <- 1

for(i in 2:9) {
  range <- 1:factorial(i)+sum(factorial(1:(i-1)))

  i[]

}
