# Euler 81
target.matrix <- as.matrix(read.csv(file = "Downloads/p081_matrix.csv",header = F))

test.matrix <- matrix(c(131,201,630,537,805,673,96,803,699,732,234,342,746,497,524,103,965,422,121,37,18,150,111,956,331),5,5)

greedyPathSum <- function(input.matrix) {
  
  # Parameters that are used
  matrix.dimensions <- dim(input.matrix)
  position.i <- 1
  position.j <- 1
  path.sum <- 0
  path.route <- c()
    
    # First get to one of the edges
    while(position.i < matrix.dimensions[1] && position.j < matrix.dimensions[2]){
      
      path.sum <- input.matrix[position.i,position.j]
      path.route <- input.matrix[position.i,position.j]
      
      # Choose the next position
      if(input.matrix[position.i, position.j + 1] > input.matrix[position.i + 1, position.j]){
        position.i <- position.i + 1
      } else {
        position.j <- position.j + 1
      }
      
      # Add sum
      path.sum <- input.matrix[position.i,position.j] + path.sum
      path.route <- c(path.route,input.matrix[position.i,position.j])
      
      
    }
    
    # Then get the rest of the way
    if(any(c(position.i,position.j) != matrix.dimensions)){
      # Add the rest of the values
      if(position.i < matrix.dimensions[1] && position.j == matrix.dimensions[2]) {
       path.sum <- path.sum + sum(matrix[position.i:matrix.dimensions[2], position.j])
       path.route <- c(path.route,matrix[position.i:matrix.dimensions[2], position.j])
      } else {
        path.sum <- path.sum + sum(matrix[position.i, position.j:matrix.dimensions[2]])
        path.route <- c(path.route,matrix[position.i, position.j:matrix.dimensions[2]])
      }
    }

  
  # Return the path sum
  list(path.sum,path.route)
  
}

# greedyPathSum(target.matrix)
greedyPathSum(test.matrix)

# Correct answer
c(131,201,96,342,746,422,121,37,311)
sum(c(131,201,96,342,746,422,121,37,311))
cumsum(c(131,201,96,342,746,422,121,37,311))
