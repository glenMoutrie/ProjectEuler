# start.time <- proc.time()
# target <- 13195
# 
# 
# # Find the factors for the target.
# factor.check <- function(x) {
#   target%%x==0
# }
# candidates <- 1:(target/2)
# factors <- candidates[sapply(1:(target/2),factor.check)]
# 
# # Find the prime factors
# prime.number.check <- function (x) {
#   possible.factors <- 2:(x-1)
#   all(sapply(possible.factors,function(y) {!x%%y==0}))
# }
# max(factors[sapply(factors,prime.number.check)])
# end.time <- proc.time()
# ###
# # Memory efficient
# ##
# start.time <- proc.time()
# target <- 600851475143
# target <- 13195
# largest.factor <- NULL
# find.largest.factor <- function(x) {
#   remainder <- 1
#   i <- 1
#   while(!remainder==0) {
#     remainder <- x%%i
#     if (remainder==0) {
#       largest.factor <<- x/i
#     } else {
#       i <- i + 1
#     }
#  
#   }
# }
# find.largest.factor(target)
# prime.factor <- 1
# i <- largest.factor
# while(i>=0 & prime.factor==1) {
#   if(target%%i==0) {
#     x <- 2
#     while(i%%x != 0 && x < i) {
#       x <- x+1
#     }
#     if (x==i && prime.factor <= i){
#       prime.factor <- i
#     }
#   }
#   i <- i-1
# }
# prime.factor
# end.time <- proc.time()

## Even better way, maybe write this in Java as it runs fast as hell!!!!
require(numbers)
max(primeFactors(600851475143))
