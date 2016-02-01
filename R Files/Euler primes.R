# Functions form numbers package

isPrime <- function (x) {
  if (is.null(x) || length(x) == 0) 
    stop("Argument 'x' must be a nonempty vector or matrix.")
  if (!is.numeric(x) || any(x < 0) || any(x != round(x))) 
    stop("All entries of 'x' must be nonnegative integers.")
  n <- length(x)
  X <- x[1:n]
  L <- logical(n)
  p <- Primes(ceiling(sqrt(max(x))))
  for (i in 1:n) {
    L[i] <- all(X[i]%%p[p < X[i]] != 0)
  }
  L[X == 1 | X == 0] <- FALSE
  dim(L) <- dim(x)
  return(L)
}

Primes <- function (n1 = 1, n2 = NULL) {
  if (is.null(n2)) 
    return(primeSieve(n1))
  if (!is.numeric(n1) || length(n1) != 1 || floor(n1) != ceiling(n1) || 
      n1 <= 0 || !is.numeric(n2) || length(n2) != 1 || floor(n2) != 
      ceiling(n2) || n2 <= 0) 
    stop("Arguments 'n1' and 'n2' must be integers.")
  if (n2 > 2^53 - 1) 
    stop("Upper bound 'n2' must be smaller than 2^53-1.")
  if (n1 > n2) 
    stop("Upper bound must be greater than lower bound.")
  if (n2 <= 1000) {
    P <- primeSieve(n2)
    return(P[P >= n1])
  }
  myPrimes <- primeSieve(floor(sqrt(n2)))
  N <- seq.int(n1, n2)
  n <- length(N)
  A <- numeric(n)
  if (n1 == 1) 
    A[1] <- -1
  for (p in myPrimes) {
    r <- n1%%p
    if (r == 0) {
      i <- 1
    }
    else {
      i <- p - r + 1
    }
    if (i <= n && N[i] == p) {
      i <- i + p
    }
    while (i <= n) {
      A[i] <- 1
      i <- i + p
    }
  }
  return(N[A == 0])
}

primeSieve <- function (n) {
  if (!is.numeric(n) || length(n) != 1 || floor(n) != ceiling(n) || 
      n < 1) 
    stop("Argument 'n' must be an integer number greater or equal 1.")
  if (n > 2^53 - 1) 
    stop("Argument 'n' must be smaller than 2^53 - 1.")
  if (n < 2) 
    return(c())
  p <- seq(1, n, by = 2)
  q <- length(p)
  p[1] <- 2
  if (n >= 9) {
    for (k in seq(3, sqrt(n), by = 2)) {
      if (p[(k + 1)/2] != 0) 
        p[seq((k * k + 1)/2, q, by = k)] <- 0
    }
  }
  p[p > 0]
}

# Sample code to read test cases

args <- commandArgs(trailingOnly=TRUE)
# test.cases <- strsplit(readLines(args[[1]], warn=FALSE), '\n')
test.cases <- list("2,10", "20,30")

split <- c()

for (test in test.cases) {
  if (length(test) > 0) {
    # ignore test if it is an empty line
    # 'test' represents the test case, do something with it
    split <- unlist(strsplit(test,","))
    
    cat(sum(isPrime(as.numeric(split[1]):as.numeric(split[2]))), "\n")
  }
}