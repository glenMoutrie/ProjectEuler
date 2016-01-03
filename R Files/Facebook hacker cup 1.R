decapitalize <- function (str, ...) {
  n <- length(str)
  if (n == 0L) {
    return(str)
  }
  nas <- is.na(str)
  idxs <- which(nas)
  if (length(idxs) == n) {
    return(str)
  }
  res <- character(length = n)
  if (length(idxs) > 0L) {
    res[idxs] <- NA_character_
  }
  idxs <- which(!nas)
  if (length(idxs) > 0L) {
    t <- str[idxs]
    first <- substring(t, first = 1L, last = 1L)
    tail <- substring(t, first = 2L)
    first <- tolower(first)
    res[idxs] <- paste(first, tail, sep = "")
  }
  res
}
string <- "Sometimes test cases are hard to make up."
sentence <- table(unlist(strsplit(decapitalize(string),"")))
sentence <- sentence[names(sentence) %in% letters]
sentence <- sentence[order(sentence)]
sum((27-length(sentence)):26*sentence)

# letterValue <- function(letter) {
#   values <- 1:26
#   names(values) <- letters
#   tryCatch(value <- values[letter],
#            error = function(e){value <- 0})
#   if(is.na(value)){
#     value <- 0
#   }
#   return(value)
# }
# 
# sum(sapply(sentence,letterValue))
