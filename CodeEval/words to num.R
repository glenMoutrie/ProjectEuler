words <- list(preamble = "negative",
							digits = c("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"),
							teens = c("ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"),
							deciles = c("twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"),
							multiples = c("hundred", "thousand", "million"))

stringValue <- function(input) {
	if(length(input) == 1) {
		test <- which(c(words$digits, words$teens, words$deciles, words$multiples) == input)
		if(test <= 10) {
			value <- test - 1
		} else if (test <= 20) {
			value <- ((0:9) + 10)[test - 10]
		} else if (test <= 28) {
			value <- ((2:9)*10)[test - 20]
		} else {
			value <- 10^(c(2,3,6))[test - 28]
		}
	} else {
		cat("Try Harder", "\n")
	}
}

toNumber <- function(string) {
	split <- unlist(strsplit(string, " "))
	
	multiply.neg <- 1
	value <- 0
	
	# Super easy
	if(length(split) == 1) {
		value <- stringValue(split)
		
	} else if (length(split) >= 2) {
		
		# Check for negative numbers
		if (split[1] == words$preamble) {
			multiply.neg <- -1
			split <- split[-1]
		}
		
		if (length(split) == 1) {
			value <- stringValue(split)
			
			# Now for the tricky bit
		} else if (length(split) >= 2) {
			
			# Check the 1-19 which can only be at the end
			if (tail(split,1) %in% unlist(words[2:4])) {
				
				value <- value + stringValue(tail(split,1))
				split <- split[-length(split)]
				
				# Check the penultimate has no deciles, only posible if the last value is 1-9
				if(tail(split,1) %in% c(words[[4]])) {
					value <- value + stringValue(tail(split,1))
					split <- split[-length(split)]
				}
			}
			
			# Now iterate over the remaing values (can only be in digits and multiples)
			if(length(split) > 0) {
				
				# Create variables now (gives speedups)
				of.interest <- c()
				multiple <- c()
				to.add <- c()
				
				# Loop until we have been through all of split
				while(length(split) > 0) {
					
					# Take the last two values (this is robust if there is only one left)
					of.interest <- tail(split,2)
					multiple <- 1
					
					if (length(of.interest) == 2) {
						# Get the value of the hundered value
						to.add <- stringValue(of.interest[2])
						split <- split[-length(split)]
						
						# Check it doesn't need to be multiplied by a digit
						if(of.interest[1] %in% unlist(words[2:5])) {
							multiple <- stringValue(of.interest[1])
							split <- split[-length(split)]
						}
					} else {
						to.add <- stringValue(of.interest)
						split <- split[-length(split)]
					}
					
					value <- value + (to.add*multiple)
				}
			}
			
		}
	}
	
	value <- multiply.neg*value
	
	return(format(value, sci = 10))
}

# Testing ground
for(i in unlist(words[c(2,3,4,5)])) cat(toNumber(i),"\n")
for(i in c("negative two","nine million hundred thousand three hundred twenty two")) cat(toNumber(i),"\n")