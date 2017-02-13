library(numbers)

range <- 1:(1*10^6)

# Create the parameters
# range <- 1:1000
primes <- isPrime(range)
circular.primes <- NULL

# Bit verbose but no need to check something you already know
number.of.digits <- c(rep(1,9),
                      rep(2,99-9),
                      rep(3,999-99),
                      rep(4,9999-999),
                      rep(5,99999-9999),
                      rep(6,999999-99999),
                      7)

# Will use this inside the loop
nextCircularNumber <- function(number, number.of.digits) {
  # Split the number up
  split.number <- strsplit((as.character(number)),split = "")[[1]]
  
  # Handle the instance where there is a 0 at the start of the circular number
  if(length(split.number)<number.of.digits) {
    split.number <- c(rep("0",number.of.digits-length(split.number)),split.number)
  }
  
  # Put the number back together and return it as a numeric type
  split.number <- c(tail(split.number,length(split.number)-1),split.number[1])
  result <- as.numeric(paste(split.number,collapse = ""))
  result
}

# Perform the actual process. Feel dirty using for loops in R, but fuck it this isn't too slow at all.
for(i in range) {
  if(primes[i]) {
    check <- 1
    if (number.of.digits[i] == 1) {
      circular.primes[length(circular.primes)+1] <- i
      next
    }
    next.number <- i
    while(check <= number.of.digits[i]) {
      next.number <- nextCircularNumber(number = next.number,number.of.digits = number.of.digits[i])
      if (!primes[next.number]) {
        break
      } else if (check + 1 == number.of.digits[i]) {
        circular.primes[length(circular.primes)+1] <- i
      }
      check <- check + 1
    }
  }
}

# Print the answer, because what the hell.
print(paste0("The number of circular primes are: ",length(circular.primes)))
