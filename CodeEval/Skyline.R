inputs <- list("(1,2,3);(2,4,6);(4,5,5);(7,3,11);(9,2,14);(13,7,15);(14,3,17)",
							 "(2,22,3);(6,12,10);(15,6,21)",
							 "(1,2,6);(9,23,22);(22,6,24);(8,14,19);(23,12,30)")

# Function converts the string in the format provided and converts it to a data frame of numerics
stringToDataFrame <- function(integers) {
	data.frame(index = integers[1]:integers[3], height = integers[2])
}

# Creates a list of data frames of the height values and the range they cover
getCordinates <- function(string.input) {
	rbind(c(0,0),do.call(args = lapply(sapply(unlist(strsplit(string.input,"\\;")),
															 function (x) {lapply(strsplit(gsub(x = gsub(x = x,pattern = "\\(",replacement = ""),pattern = "\\)",replacement = ""),",")
															 										 ,as.numeric)}),
												stringToDataFrame), what = rbind))
}

getCordinates(inputs[[1]])

# Creates a data frame finding the largest possible values at each integer
createOutput <- function(cleaned.data) {
	start <- min(cleaned.data[,1])
	range <- start:max(cleaned.data[,1])
	output <- c()
	for(i in range) {output[length(output) + 1] <- max(cleaned.data[which(cleaned.data[,1] == i),2])}
	data.frame(length = range, height = output, changed = c(0,diff(output)))
}
output <- createOutput(getCordinates(inputs[[1]]))

# output
# first.diff <- diff(c(0,output))!=0
# (1:17)[first.diff != 0 || diff((1:17)[first.diff]) == 1]
# plot(1:17,as.numeric(strsplit(output," ")[[1]]))

createSkyScraper <- function(full.series){
  output <- c()
	for(i in 1:nrow(full.series)) {
	  if(full.series[i,3]==0){
	    next
	  } else if (full.series[i,3] > 0) {
	    output[length(output) + 1] <- full.series[i,1]
	    output[length(output) + 1] <- full.series[i,2]
	  } else {
	    output[length(output) + 1] <- full.series[i - 1,1]
	    output[length(output) + 1] <- full.series[i,2]
	  }
	}
  output
}
createSkyScraper(output)

outputs <- list("1 2 2 4 4 5 5 4 6 0 7 3 11 2 13 7 15 3 17 0",
								"2 22 3 0 6 12 10 0 15 6 21 0",
								"1 2 6 0 8 14 9 23 22 6 23 12 30 0")


#    length height changed Next (uses following value.)
# 0       0      0   FALSE F
# 1       1      2    TRUE T
# 2       2      4    TRUE T
# 3       3      4   FALSE F
# 4       4      5    TRUE T
# 5       5      5   FALSE T    N
# 6       6      4    TRUE T    N
# 7       7      3    TRUE T
# 8       8      3   FALSE F
# 9       9      3   FALSE F
# 10     10      3   FALSE F
# 11     11      3   FALSE T    N
# 12     12      2    TRUE F
# 13     13      7    TRUE T
# 14     14      7   FALSE F
# 15     15      7   FALSE T    N
# 16     16      3    TRUE F
# 17     17      3   FALSE T    N
# 18     18      2   FALSE T

# 1 2
# 2 4
# 4 5
# 5 4
# 6 0
# 7 3
# 11 2
# 13 7
# 15 3
# 17 0

