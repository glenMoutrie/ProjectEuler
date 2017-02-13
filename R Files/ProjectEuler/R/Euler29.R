aRange <- bRange <- 2:100
results <- NULL
for(a in aRange) {
  for(b in bRange) {
    results[length(results) + 1] <- a^b
  }
}
length(unique(results))