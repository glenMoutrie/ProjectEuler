# Creature of habit
library(data.table)

# Import data (actually comes in as column names)
x <- fread("Documents/Data/p022_names.txt")
x <- names(x)

# Create letter scores
letter.scores <- 1:length(LETTERS)
names(letter.scores) <- LETTERS

# Apply letter scores
x <- sapply(x,function(y){strsplit(y,split = "")})
x <- lapply(x,function (y) {sum(letter.scores[y])})

# Score by the names order
order.score <- 1:length(x)
names(order.score) <- sort(names(x))

# Multiply and find the maximum
results <- sapply(names(x),function (y) {x[[y]]*order.score[y]})

sum(results)
