formatInput <- function(string) {
	as.numeric(unlist(strsplit(string, ",")))
}

maxCrossSubArray <- function(array, min = 1, mid = floor(length(array)/2), max = length(array)) {
	if(min == max) {
		return(list(total = array[min], left = min, max = max))
	}
	
	ifelse(mid == 0, 1, mid)
	
	# Find the maximum sum on the left hand side
	left.sum <- -Inf
	sum <- 0
	for (i in mid:min) {
		sum <- sum + array[i]
		if (sum > left.sum) {
			left.sum <- sum
			max.left <- i
		}
	}
	
	# Find the maximum sum on the left hand side
	right.sum <- -Inf
	sum <- 0
	for (j in (mid + 1):max) {
		sum <- sum + array[j]
		if (sum > right.sum) {
			right.sum <- sum
			max.right <- j
		}
	}
	
	list(total = sum(right.sum + left.sum), left = max.left, right = max.right)
}

findMaximumSubarray <- function(array, min = 1, max = length(array)) {
	if (min == max) {
		# Instance of only one array
		return(total = list(total = array[min], left = min, right = max))
		
	} else {
		# Recursively estimate
		mid <- floor((min + max)/2)
		mid <- ifelse(mid == 0, 1, mid)
		
		# Find the comparisons
		left <- findMaximumSubarray(array = array, min, mid)
		right <- findMaximumSubarray(array = array,min =  mid + 1,max =  max)
		cross <- maxCrossSubArray(array = array,min = min,mid =  mid,max =  max)
		
		if (left$total >= right$total && left$total >= cross$total) {
			return(left)
		} else if(right$total >= left$total && right$total >= cross$total) {
			return(right)
		} else {
			return(cross)
		}
	}
}

test <- sample(-10:10,size =  10)
test
maxCrossSubArray(test)
cat(findMaximumSubarray(test)$total, "\n")