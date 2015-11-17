# Generate Fibonacci sequence
output <- 1:2
final.term <- tail(output,1)

while(final.term <= 4*10^6) {
  next.index <- length(output)
  output[next.index+1] <- sum(output[next.index-1],output[next.index])
  final.term <- tail(output,1)
}

# Take the sum for all even numbers
sum(output[output%%2==0])
