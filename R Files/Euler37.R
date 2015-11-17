library(numbers)

# Bit verbose but no need to check something you already know
number.of.digits <- c(rep(1,9),
                      rep(2,99-9),
                      rep(3,999-99),
                      rep(4,9999-999),
                      rep(5,99999-9999),
                      rep(6,999999-99999),
                      7)

# Remove left and right functions
removeLeft <- function(number.string) {
  number.string <- number.string[-length(number.string)]
  digits.left <- length(number.string)
  number <- as.numeric(paste0(number.string,collapse = ""))
  if(is.na(number) || number == 0) {
    is.prime <- F
  } else {
    is.prime <- primes[number]
  }
  list(number = number,string = number.string, length = digits.left, primecheck = is.prime)
}

removeRight <- function(number.string) {
  number.string <- number.string[-1]
  digits.left <- length(number.string)
  paste0(number.string,collapse = "")
  number <- as.numeric(paste0(number.string,collapse = ""))
  if(is.na(number) || number == 0) {
    is.prime <- F
    } else {
      is.prime <- primes[number]
    }
  list(number = number,string = number.string, length = digits.left, primecheck = is.prime)
}

# Check the truncatable primes
checkTruncatablePrime <- function(number){
  is.truncatable <- F
  
  # Do both directions
  for(firstMethod in c("left","right")){
    
    string.type <- strsplit(as.character(number),"")[[1]]
    
    # Choose first Method
    if (firstMethod == "left") {
      first <- removeLeft
      second <- removeRight
    } else {
      first <- removeRight
      second <- removeLeft
    }
    
    # We are trying to say when this isn't the case,
    # For then we will stop the process
    if (firstMethod == "left") {
      still.prime <- T
    }
    
    while(still.prime){
      # Check the first method
      result <- first(string.type)
      string.type <- result$string
      still.prime <- result$primecheck
      
      print(paste0("Number ",result$number," is prime: ",result$primecheck,"; Line 65; Method = ", firstMethod))
      
      # Check if the search can be stopped
      if (result$length < 2 || !still.prime) {
        break
      }
      
#       # Do the second method in the loop
#       result <- second(string.type)
#       string.type <- result$string
#       print(paste0("Number ",result$number," is prime: ",result$primecheck,"; Line 75; Method = ", firstMethod))
#       
#       still.prime <- result$primecheck
#       if(result$length < 2) break
    }
    
    # If still prime on second run
    if (firstMethod == "right" && still.prime) {
      is.truncatable <- T
    } else if (!still.prime) {
      break
    }
  }
  is.truncatable
}

output <- checkTruncatablePrime(10)

# Perform the actual process. Feel dirty using for loops in R, but fuck it this isn't too slow at all.
truncatable.primes <- NULL

range <- 1:1000000
primes <- isPrime(range)
result <- sapply(range[primes], checkTruncatablePrime)
range[primes][result]
# # Only stop when all 11 are found...
# while(length(truncatable.primes) < 11) {
#   # Attempt number if the 11 haven't been found the first time round
#   attempt <- 1
#   
#   # Create the parameters
#   # if (attempt == 1) {
#   range <- 1:300
#   primes <- isPrime(range)
#   #   } else {
#   #     range <- c(range,range + 1000000)
#   #     primes <- c(primes,isPrime(tail(range,1000000)))
#   #   }
#   
#   # Only consider the primes, silly to do otherwise
#   for(i in range[primes]) {
#     number <- strsplit(as.character(i),"")[[1]]
#     # print(number)
#     # Avoid single digit primes
#     # print(i)
#     
#     if(length(number) == 1) next
#     
#     
#     # Iterate over the two methods
#     for(firstMethod in c("left","right")){
#       if (firstMethod == "left") {
#         first <- removeLeft
#         second <- removeRight
#       } else {
#         first <- removeRight
#         second <- removeLeft
#       }
#       check <- c(F,F)
#       
#       # If you have been once over already and the previous was false
#       if (firstMethod == "rigth" && !check[1]) break
#       
#       # Check each number, avoid doing it more times than it has digits
#       number.of.digits <- 1:ceiling(length(number)/2)
#       for(iteration in number.of.digits) {
#         number <- as.numeric(first(number))
#         print(paste0(i," and first round: ", number))
#         if(is.na(number)) break
#         print(primes[number])
#         if (!primes[number]) break
#         number <- strsplit(as.character(number),"")
#         
#         if(length(number == 1) && primes[number] && firstMethod == "right") {
#           truncatable.primes[length(truncatable.primes) + 1] <- i
#           if (firstMethod == "left") {
#             check[1] <- T
#           } else {
#             check[2] <- F
#           }
#           
#         } else {
#           number <- as.numeric(second(number))
#           print(paste0(i," and second round: ", number))
#           if (is.na(number)) {
#             break
#           } else if (!primes[number]) {
#             break
#           }
#           if(iteration == max(number.of.digits) && primes[number] && firstMethod == "right") {
#             truncatable.primes[length(truncatable.primes) + 1] <- i
#             if (firstMethod == "left") {
#               check[1] <- T
#             } else {
#               check[2] <- F
#             }
#           }
#           
#           if (!check[1]) break
#           if (all(check)) truncatable.primes[length(truncatable.primes)+1] <- i
#         }
#       }
#     }
#   }
# }
# Print the answer, because what the hell.
print(paste0("The number of truncatable primes are: ",length(truncatable.primes)))
