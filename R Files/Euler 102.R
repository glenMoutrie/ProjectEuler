library(data.table)
data <- as.matrix(fread("Downloads/p102_triangles.csv"))

# Useses the Barycentric coordinate system. Assumes coordinate is (0,0)
insideTriangle <- function (x1,y1,x2,y2,x3,y3) {
  denominator <- (((y2-y3)*(x1-x3)) + ((x3-x2)*(y1-y3)))
  a <- (((y2-y3)*(-x3)) + ((x3-x2)*(-y3)))/denominator
  b <- (((y3-y1)*(-x3)) + ((x1-x3)*(-y3)))/denominator
  c <- 1 - a - b
  
  unitValue <- function (x) {
    0 <= x && x <= 1
  }
  
  all(sapply(c(a,b,c),unitValue))
  
}

system.time(sum(mapply(insideTriangle,data[,1],data[,2],data[,3],data[,4],data[,5],data[,6])))