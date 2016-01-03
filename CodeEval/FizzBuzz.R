test.cases <- strsplit(readLines(args[[1]], warn=FALSE), '\n')[[1]]

# Create a function that checks if F, B, FB or just return the number
fizzBuzz <- function(number, divisor.one, divisor.two) {
  # Initially assume neither fizz or buzz
  output <- number
  
  # Create checks so they don't need to be done multiple times
  fizz <- number%%divisor.one == 0
  buzz <- number%%divisor.two == 0
  
  # Alter as needed
  if(fizz && buzz){
    output <- "FB"
  } else if  (fizz) {
    output <- "F"
  } else if (buzz) {
    output <- "B"
  }
  
  output
}

# Perform fizzbuzz row by row
fizzBuzzOutput <- function (x) {
  X <- x[1,]
  Y <- x[2,]
  apply(matrix(1:x[3,],x[3,],1),1,function(y) {fizzBuzz(y,X,Y)})
}

for (test in test.cases) {
  if (length(test) > 0) {
    refomatted.data <- sapply(strsplit(x = test,split = " "),as.numeric)
    output <- fizzBuzzOutput(refomatted.data)
    
    cat(output)
    # ignore test if it is an empty line
    # 'test' represents the test case, do something with it
  }
}