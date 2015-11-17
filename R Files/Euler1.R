check <- function(i){
  if(i%%3==0) {
    T
  } else if (i%%5==0) {
    T
  } else {
    F
  }
}

numbers <- 1:999
sum(numbers[sapply(1:999,check)])