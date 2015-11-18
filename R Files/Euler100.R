# Euler 100
options(scipen = 999)

result <- c()
k.values <- c()
n <- 2
# total.one <- total.two <- 0

while(length(result) < 7) {

  z = 0.5*(n-n^2)
  b.one = (1-sqrt(1-4*z))*0.5
  b.two = (1+sqrt(1-4*z))*0.5
  
  if (b.two > 0 && b.two%%1 == 0) {
    result[length(result) + 1] <- b.two
    k.values[length(k.values) + 1] <- n
  } else if (b.one > 0 && b.one %% 1 == 0) {
    result[length(result) + 1] <- b.one
    k.values[length(k.values) + 1] <- n
  }
  
  n <- n + 1
}

results <- rbind(blue = result, red = k.values - result, total =  k.values)
check <- apply(results, 2, function (x) {(x[1]/x[3])*((x[1]-1)/(x[3]-1))})
results <- rbind(results,check)
results


t.over.b <- sapply(1:6,function (x) results["total",x]/results["blue",x +1])
inv.t <- sapply(1:6,function (x) 1/results["total",x])
inv.b <- sapply(1:6,function (x) 1/results["blue",x])
t.over.b - inv.t
