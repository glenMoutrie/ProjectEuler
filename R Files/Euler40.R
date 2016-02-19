start <- proc.time()
text <- paste(1:(10^6), collapse = "")
index <- c(1,10,10^(1:6))
result <- c()

for(i in index){
	result <- append(result,as.numeric(substring(text,i,i)))
}
print(prod(result))
proc.time() - start
