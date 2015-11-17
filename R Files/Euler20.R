## ONE LINER BIATCH
require("gmp")
sum(lapply(strsplit(as.character(factorialZ(100)),""),as.numeric)[[1]])


# sum(lapply(strsplit("93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000",""),as.numeric)[[1]])
# java.result <- 93326215443944152681699238856266700490715968264381621468592963895217599993229915608941463976156518286253697920827223758251185210916864000000000000000000000000
# sum(lapply(strsplit(as.character(java.result),""),as.numeric)[[1]])
# 
# estimation.error <- function (x) {prod(seq(1:x))-factorial(x)}
# results <-sapply(1:100,estimation.error)
# plot(log(sapply(1:100,estimation.error)),type="l")
# results == 0
# 
# library(gmp)
# numbers <- 1:10
# for(i in 2:10) {
#   if(i=2){
#     2
#   }
# }