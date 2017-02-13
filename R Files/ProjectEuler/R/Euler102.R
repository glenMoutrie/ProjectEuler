#' Solve Euler 102
#'
#' Solves Euler 102 given the triangles.txt data given in the problem. Finds the sum of triangles
#' where the origin point (0,0) is in the center of the triangle.
#'
#' @param src Problem text file
#'
#' @return Integer of the number of triangles satisfying the criteria
#' @export
euler102 <- function(src) {

	data <- as.matrix(fread(src))

	sum(mapply(insideTriangle,data[,1],data[,2],data[,3],data[,4],data[,5],data[,6]))

}


#' Check if a triangles area contains the origin
#'
#' Uses the Barycentric coordinate system to check that a point is inside a circle. Checks the origin
#' by default.
#'
#'
#' @param x1 X axis value of triangle corner 1
#' @param y1 Y axis value of triangle corner 1
#' @param x2 X axis value of triangle corner 2
#' @param y2 Y axis value of triangle corner 2
#' @param x3 X axis value of triangle corner 3
#' @param y3 Y axis value of triangle corner 3
#'
#'
#' @return Boolean, true if origin is inside triangle
#' @export
insideTriangle <- function(x1,y1,x2,y2,x3,y3, x = 0, y = 0) {

	# Calculate the denominator used for each Barycentric coordineate
  denominator <- (((y2 - y3) * (x1 - x3)) + ((x3 - x2) * (y1 - y3)))

  # Calculate points a and b
  a <- (((y2 - y3) * (x - x3)) + ((x3 - x2) * (y - y3)))/denominator
  b <- (((y3 - y1) * (x - x3)) + ((x1 - x3) * (y - y3)))/denominator

  # Calculate point c
  c <- 1 - a - b

	# Check all values are between zero and one
  all(sapply(c(a,b,c),unitValue))

}


