
countTotal <- function(value, sumator) {
  sum <- 0
  if (sumator == 1) return(1)
  for (i in sumator:1) {
    if(value - i == 0) {
      sum <- sum + 1
    } else if(value - i > 0) {
      sum <- sum + countTotal(value - i, i)
    }
  }
  
  return(sum)
}

partitions <- rep(NA, 101)
totalSumations <- function(n) {
 
  if(n %in% c(0)) return(1)
  if(n < 0) return(0)
  
  if (!n %in% partitions) {
    k <- 1:(n + 1)
    k <- sapply(k, function(x) {
      ((-1)^(x+1))*(totalSumations(n-(x*(3*x-1)*0.5)+(totalSumations(n-(x*(3*x+1)*0.5)))))
     })
    
    partitions[n] = sum(k)
    
  }
# k <- 1:(n + 1)
# k <- sapply(k, function(x) {
#   ((-1)^(x+1))*(totalSumations(n-(x*(3*x-1)*0.5)+(totalSumations(n-(x*(3*x+1)*0.5)))))
#  })
 
 return(sum(k))
}
totalSumations(5)

countTotal(100,99)

partitions <- function(n) {
  seq <- 1:n
  seq <- sapply(seq,function(x) {1/(1-x)})
}


for(i in 2:20) cat(i, ": ", totalSumations(i),"\n")
for(i in 2:20) cat(i, ": ", totalSumations(i)/(i+1),"\n")


total <- 0
for (four in seq(from = 5, to = 0, by = -4)) {
  for (three in seq(from = four, to =0, by = -3)) {
    for (two in seq(from = three, to =0, by = -2)) {
      cat(four, three, two, "\n")
        total <- total + 1
    }
  }
}

print(total)

library(partitions)
P(100) - 1