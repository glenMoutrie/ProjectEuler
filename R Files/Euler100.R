# Euler 100
options(scipen = 999)

result <- c()
n <- 10^6
# total.one <- total.two <- 0

while(length(result) < 6) {

  z = 0.5*(n-n^2)
  b.one = (1-sqrt(1-4*z))*0.5
  b.two = (1+sqrt(1-4*z))*0.5
  
  if (b.two > 0 && b.two%%1 == 0) {
    result[length(result) + 1] <- b.two
  } else if (b.one > 0 && b.one %% 1 == 0) {
    result[length(result) + 1] <- b.one
  }
  

  
  n <- n + 1
}

result