input <- as.matrix(read.csv("Documents/java/ProjectEuler/input11.csv",sep = " ",header = F))
colnames(input) <- NULL

largest.so.far <- 0

otherDiagonal <- function(x) {
  first <- x[4,1]
  second <- x[3,2]
  third <- x[2,3]
  fourth <- x[1,4]
  result <- c(first,second,third,fourth)
  return(result)
}

for(i in 0:16) {
  for(j in 0:16) {
    
    largest.so.far <- max(prod(input[1+i,1:4+j]),largest.so.far)
    
    largest.so.far <- max(prod(diag(input[1:4+i,1:4+j])),largest.so.far)
    largest.so.far <- max(prod(otherDiagonal(input[1:4+i,1:4+j])),largest.so.far)
    
    if (i == 16) {
      largest.so.far <- max(prod(input[2+i,1:4+j]),largest.so.far)
      largest.so.far <- max(prod(input[3+i,1:4+j]),largest.so.far)
      largest.so.far <- max(prod(input[4+i,1:4+j]),largest.so.far)
    }
    
    if (j == 16) {
      largest.so.far <- max(prod(input[1:4+i,2+j]),largest.so.far)
      largest.so.far <- max(prod(input[1:4+i,3+j]),largest.so.far)
      largest.so.far <- max(prod(input[1:4+i,4+j]),largest.so.far)
    }
  }
}

print(largest.so.far)
