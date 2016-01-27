# Euler 81
target.matrix <- as.matrix(read.csv(file = "Downloads/p081_matrix.csv",header = F))

test.matrix <- matrix(c(131,201,630,537,805,673,96,803,699,732,234,342,746,497,524,103,965,422,121,37,18,150,111,956,331),5,5)

t <- test.matrix

sumEdge <- function(sum.matrix) {
	# Sum across the final column
	for (i in (nrow(sum.matrix) - 1):1){
		for (j in ncol(sum.matrix)){
			sum.matrix[i,j] <- sum.matrix[i,j] + sum.matrix[i + 1,j]
		}
		
	}
	
	# Sum across the final row
	for (i in nrow(sum.matrix)){
		for (j in (ncol(sum.matrix)-1):1){
			sum.matrix[i,j] <- sum.matrix[i,j] + sum.matrix[i,j + 1]
		}
	}
	
	sum.matrix
}

# Produces the differences needed to identify the diagonals of the matrix
getDiffs <- function(dimension) {
	end <- dimension - 1
	output <- list()
	for(i in 1:(((end)*2)-1)) {
		if(i <= end) {
			output[[length(output) + 1]] <- 1:i
		} else {
			output[[length(output) + 1]] <- (i-end + 1):end
		}
	}
	output
}

# Test case for getDiffs()
# getDiffs(5)

# Sum each of the non-edges in a tree like structure
sumMatrixInternal <- function(matrix) {
	sum.matrix <- matrix
	dimension <- ncol(matrix)
	
	differences <- getDiffs(dimension = dimension)
	
	addValues <- function(row,col) {
		row.id <- dimension - d[row]
		col.id <- dimension - d[col]
		# print( max(sum.matrix[row.id + 1,col.id],sum.matrix[row.id,col.id + 1]))
		sum.matrix[row.id,col.id] <<- min(sum.matrix[row.id + 1,col.id],sum.matrix[row.id,col.id + 1])
		sum.matrix
	}
	
	for(d in differences){
		# mapply(function(row,col) {print(c(dimension - d[row], dimension - d[col]))},1:length(d),length(d):1)
		mapply(addValues,1:length(d),length(d):1,matrix)
	}
	sum.matrix
}
sumMatrixInternal(sumEdge(t))

test <- provideRowDiagonals()

# greedyPathSum <- function(input.matrix) {
#   
#   # Parameters that are used
#   matrix.dimensions <- dim(input.matrix)
#   position.i <- 1
#   position.j <- 1
#   path.sum <- 0
#   path.route <- c()
#     
#     # First get to one of the edges
#     while(position.i < matrix.dimensions[1] && position.j < matrix.dimensions[2]){
#       
#       path.sum <- input.matrix[position.i,position.j]
#       path.route <- input.matrix[position.i,position.j]
#       
#       # Choose the next position
#       if(input.matrix[position.i, position.j + 1] > input.matrix[position.i + 1, position.j]){
#         position.i <- position.i + 1
#       } else {
#         position.j <- position.j + 1
#       }
#       
#       # Add sum
#       path.sum <- input.matrix[position.i,position.j] + path.sum
#       path.route <- c(path.route,input.matrix[position.i,position.j])
#       
#       
#     }
#     
#     # Then get the rest of the way
#     if(any(c(position.i,position.j) != matrix.dimensions)){
#       # Add the rest of the values
#       if(position.i < matrix.dimensions[1] && position.j == matrix.dimensions[2]) {
#        path.sum <- path.sum + sum(matrix[position.i:matrix.dimensions[2], position.j])
#        path.route <- c(path.route,matrix[position.i:matrix.dimensions[2], position.j])
#       } else {
#         path.sum <- path.sum + sum(matrix[position.i, position.j:matrix.dimensions[2]])
#         path.route <- c(path.route,matrix[position.i, position.j:matrix.dimensions[2]])
#       }
#     }
# 
#   
#   # Return the path sum
#   list(path.sum,path.route)
#   
# }
# 
# # greedyPathSum(target.matrix)
# greedyPathSum(test.matrix)

# Correct answer
# c(131,201,96,342,746,422,121,37,311)
# sum(c(131,201,96,342,746,422,121,37,311))
# cumsum(c(131,201,96,342,746,422,121,37,311))
