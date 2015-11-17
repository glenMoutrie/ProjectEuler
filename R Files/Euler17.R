# Convert to vernacular string
library("qdap")
all.numbers <- replace_number(1:1000)

# Remove spaces and hyphens (although it turns out no hyphens were used, but for completeness)
all.numbers.no.spaces <- gsub(" ","",all.numbers,fixed= T)
all.numbers.no.spaces <- gsub("-","",all.numbers.no.spaces,fixed=T)

# Calculate the total length, accounting for the lack of a use of 'and's in qdap function
length <- nchar(all.numbers.no.spaces)
sum(length)+3*99*9

