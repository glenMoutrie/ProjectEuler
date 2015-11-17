Primes
function (n1 = 1, n2 = NULL) 
{
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
  
  # Returns primes for the first sqrt(n2) terms, all of which that are below n1 will not
  # be needed.
  myPrimes <- primeSieve(floor(sqrt(n2)))
  N <- seq.int(n1, n2)
  n <- length(N)
  
  # A numeric vector that will be used to subset N which will be a vector of n 0's
  A <- numeric(n)
  
  # Drop one if starting form 1
  if (n1 == 1) 
    A[1] <- -1
  
  
  for (p in myPrimes) {
    r <- n1%%p
    
    # This will be true if the n1 is divisible by the prime 
    if (r == 0) {
      i <- 1
    }
    
    # See if the 
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