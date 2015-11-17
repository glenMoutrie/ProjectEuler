# Euler 52
digits <- function(number){
  strsplit(as.character(number),"")[[1]]
}

digitMatch <- function(first.number, second.number){
  all(digits(first.number) %in% digits(second.number)) && all(digits(second.number) %in% digits(first.number))
}

match <- F
number <- 0

while(!match){
  number <- number + 1
  for(x in 2:6){
    if(!digitMatch(number,x*number)){
      break
    } else if (x == 6) {
      match <- T
    }
  }
}

print(number)
