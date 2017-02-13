
# As we know that b^2 = sqrt(a^2 + b^2) we know that
# p = a + b + c = a + c + sqrt(a^2 + c^2). The function below will
# generate all of the possible p values given a and c.
getP <- function(a, c) {
	a + c + sqrt((a^2) + (c^2))
}

# Generate all possible integer values of a and c
n <- expand.grid(1:1000,1:1000)

# Generate feasible p values
p.values <- mapply(getP,n[,1],n[,2])

# Remove non-integer values and values above 1000
p.values <- p.values[p.values%%1 == 0 & p.values < 1000]

# The result
which.max(table(p.values))
