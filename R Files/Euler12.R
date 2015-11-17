# Euler 12
# Ridiculous brute force version

quick.check <- 1
iteration <- 2

numberOfDivisors <- function (x) {
  i <- 1
  total <- 1
#   if (x %% 2 != 0) {
#     while (i <= 0.5*x) {
#       if (x%%i == 0) {
#         total <- total + 1
#       }
#       i <- i + 2
#     }
#   } else if (x %% 3 != 0){
#     while (i <= (0.5*x)) {
#       if (x%%i == 0) {
#         total <- total + 1
#       }
#       i <- i + 1
#       # Check again to skip the third
#       if (x%%i == 0) {
#         total <- total + 1
#       }
#       i <- i + 2
#     }
#   } else {
    while (i <= sqrt(x)) {
      if (x%%i == 0) {
        total <- total + 2
      }
      i <- i + 1
#     }
  }

  total
}

number.of.divisors <- 0
while(number.of.divisors <= 500) {
  quick.check <- iteration + quick.check
  iteration <- iteration + 1
  number.of.divisors <- numberOfDivisors(quick.check)
  print(paste0(quick.check,", the ",iteration,"th triangular # with ",number.of.divisors," divisors"))
}