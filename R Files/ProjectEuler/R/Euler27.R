# Use this range initially, but note we may have to check for primes above the range.
range <- 1:1000
primes <- isPrime(1:10^5)

# As b must be prime, and assuming only possible to have positive integer primes...
# This lowers the number of possible b values to 168. YAY!
possibleB <- range[primes[1:1000]]
possibleA <- sort(c(-range,0,range))

max.consecutive <- maxA <- maxB <- 0

# Iterate through B
for(bValue in possibleB) {
  for (aValue in possibleA) {
    consecutive <- 1
    result <- 1 + aValue + bValue
    
    # Iterate through N values until it isn't prime
    while(result != 0 && primes[abs(result)]) {
      # print(paste0("On iteration ", consecutive, " with a resulting value ", result))
      consecutive <- consecutive + 1
      result <- (consecutive^2) + (consecutive*aValue) + bValue
      # print(result)
    }
    
    # If this is the largest number of consecutive primes
    if(consecutive - 1 > max.consecutive) {
      max.consecutive <- consecutive - 1
      maxA <- aValue
      maxB <- bValue
      # print(paste0("The longest sequence is ",max.consecutive,
                   # " from a = ", maxA," and b = ", maxB))
    }
  }
}
maxA*maxB
