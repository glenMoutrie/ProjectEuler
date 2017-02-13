start <- proc.time()
skip <- seq(2,1001,2)
# skip <- seq(2,5,2)
numbers <- 1
for (i in skip) {
	numbers <- append(numbers, seq(from = tail(numbers, 1) + i, by = i, length.out = 4))
}
cat("Result: ",sum(numbers),"\n")
print(proc.time() - start)
