result <- 0
spaces <- "  "
multiples <- 1:12
for(i in multiples) {
  for (j in multiples) {
    result <- i*j
    if(result == 1){
      for(x in 1) cat("\t")
      } else if (result < 10) {
      spaces <- "   "
    } else {
      spaces <- ifelse(result < 100, "  ", " ")
    }
    cat(spaces, result)
  }
  cat("\n")
}