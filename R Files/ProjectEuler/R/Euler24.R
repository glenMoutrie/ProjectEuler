# Euler 24
possible.digits <- 0:9
permutation <- 0
iteration <- 0
next.permutation <- 0
digit <- 0
number <- c()

while(length(number)<10){
  each.digit.permutation <- next.permutation <- factorial(9-length(number))
  digit <- length(number) + 1
  
  for(iteration in possible.digits) {
    number[digit] <- iteration
    permutation <- permutation + each.digit.permutation
    print(paste0("Number: ",paste0(number,collapse = ""),", Permutation: ", permutation))
    if(permutation >= 10^6) {
      possible.digits <- possible.digits[-which(possible.digits%in%iteration)]
      permutation <- permutation - each.digit.permutation
      break
    }
  }
  
}

message(number)