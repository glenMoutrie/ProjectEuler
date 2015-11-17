# Euler 30
splitNumber <- function(x) {
  as.numeric(strsplit(as.character(x),"")[[1]])
}

sumPowerFive <- function(x) {
  sum(sapply(x,"^",5))
}

successful.values <- c()
for(i in 2:10^6){
  if(i == sumPowerFive(splitNumber(i))){
    successful.values[length(successful.values) + 1] <- i
  }
}

cat("Result: ", sum(successful.values))
