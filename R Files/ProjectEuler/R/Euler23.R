# Euler Twenty Fucking Three

factorFinder <- function(number) {
  
  # Create a bunch of meta shit
  end.point <- sqrt(number)
  divisor <- c()
  other.divisor <- c()
  is.proper <- F
  result <- c()
  
  # Finally get your arse around to doing something with them
  for(i in 1:end.point){
    divisor <- number%%i
    if(divisor == 0) {
      result[length(result) + 1] <- i
      
      # Make an efficiency saving by considering only  up to square points
      other.divisor <- number/i
      if(other.divisor!=i){
        result[length(result) + 1] <- other.divisor
      }
      
    }
  }
  
  # Return your shit.
  result
}

factorFinder(10^3)

sumOfProperDivisors <- function(number){
  sum(factorFinder(number)) - number
}

sumOfProperDivisors(12)

# Going through the process

# We know this from the question, now find the sum of proper divisors for each
range <- 1:28123
divisor.sums <- sapply(range,sumOfProperDivisors)
abundent <- mapply("<",range,divisor.sums)

# Find the sums of all abundent values
abundent.values <- range[abundent]
sum.of.sums <- sapply(abundent.values,
       function (x) {sapply(abundent.values,function (y) {x+y})})

# As it is a symmetric matrix
abundent.sums <- unique(sum.of.sums[upper.tri(sum.of.sums,diag = T)])

# The final result
sum(range[!(range %in% abundent.sums)])
