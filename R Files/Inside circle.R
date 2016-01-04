input <- list("Center: (2.12, -3.48); Radius: 17.22; Point: (16.21, -5)",
              "Center: (5.05, -11); Radius: 21.2; Point: (-31, -45)",
              "Center: (-9.86, 1.95); Radius: 47.28; Point: (6.03, -6.42)")
insideCircle <- function(cordinate.string) {
  if (length(cordinate.string) > 0) {
    initial.split <- strsplit(strsplit(cordinate.string,split = ";")[[1]],": ")
    output <- lapply(seq_along(initial.split),
                     function(x) {
                       if (x == 2) {
                         as.numeric(initial.split[[x]][2])
                       } else {
                       	sapply(unlist(strsplit(initial.split[[x]][2],split = ",")),
                       				 function (x) {as.numeric(gsub("\\)","",gsub("\\(","",x)))})
                       }
                     })
    if (sqrt(crossprod(output[[1]] - output[[3]])) < output[[2]]) {
      cat("true")
    } else {cat("false")}
    cat("\n")
  }
  rm(list = ls(envir = environment()))
}
output <- lapply(input,insideCircle)
# rm(list = ls(all.names = T))

# Sample code to read test cases

args <- commandArgs(trailingOnly=TRUE)
test.cases <- strsplit(readLines(args[[1]], warn=FALSE), '\n')
rm(args)
insideCircle <- function(cordinate.string) {
	if (length(cordinate.string) > 0) {
		initial.split <- strsplit(strsplit(cordinate.string,split = ";")[[1]],": ")
		output <- lapply(seq_along(initial.split),
										 function(x) {
										 	if (x == 2) {
										 		as.numeric(initial.split[[x]][2])
										 	} else {
										 		sapply(unlist(strsplit(initial.split[[x]][2],split = ",")),
										 					 function (x) {as.numeric(gsub("\\)","",gsub("\\(","",x)))})
										 	}
										 })
		if (sqrt(crossprod(output[[1]] - output[[3]])) < output[[2]]) {
			cat("true")
		} else {cat("false")}
		cat("\n")
	}
}
for (test in test.cases) {
  if (length(test) > 0) {
    # ignore test if it is an empty line
    # 'test' represents the test case, do something with it
    insideCircle(test)
  }
}
rm(test.cases)
