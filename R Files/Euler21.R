sumOfDivisors <- function(x) {
  sum <- 0
  i <- 1
  for(i in 1:(0.5*x)) {
    if(x%%i == 0) {
      sum <- sum + i
    }
  }
  sum
}

sum.all.under <- lapply(1:10000,sumOfDivisors)
amicable.number <- rep(F,10000)

for(x in seq_along(sum.all.under)) {
  if(!amicable.number[x] && x != sum.all.under[[x]]) {
    amicable.number[x] <- tryCatch(sum.all.under[[sum.all.under[[x]]]]==x,
                                   error = function(e){F})
    if(amicable.number[x]) {
      amicable.number[sum.all.under[[x]]] <- T
    }
  }
}

sum(seq_along(sum.all.under)[amicable.number])}