# Find all primes under a million
largest.number <- 10^6
range <- 1:(1*largest.number)
primes <- isPrime(range)

# Find the cumulative sum of all primes
cumulative.sum <- cumsum(as.numeric(range[primes]))
refined <- cumulative.sum < (largest.number)
cumulative.sum <- cumulative.sum[refined]

# This is the largest possible consectutive prime sum under a million.
# This however is not the solution...
largest.sequence <- length(cumulative.sum)
number.of.primes <- sum(primes)

# This total will be replaced by anything that is found above it
max.total <- 0
final.target <- NULL

for(i in order(1:largest.sequence,decreasing = T)) {
  for(j in 1:(number.of.primes - largest.sequence + 1)) {
    target <-( (1:i)+(j-1))
    print(target)
    if(length(target) == 1) break
    new.total <- sum(range[primes][target])
    print(paste0("New total is : ",new.total))
    if (new.total > largest.number) {
      break
    } else if (primes[new.total] && new.total>max.total) {
        max.total <- new.total
        final.target <- target
        stop(paste0("New maximum total is: ",max.total))
    }
  }
}

# cumulative.sum[primes[cumulative.sum]]
# 
# total <- 0
# index <- 1
# new.total <- total + range[primes][index]
# 
# 
# while(new.total < 1*10^6) {
#   total <- new.total
#   index <- index + 1
#   new.total <- total + range[primes][index]
#   if (new.total < 1*10^6 && primes[new.total]){ answer <- new.total}
#   if (!is.na(primes[new.total]) && !primes[new.total]){ next}
# }