# Sample code to read test cases

# args <- commandArgs(trailingOnly=TRUE)
# test.cases <- strsplit(readLines(args[[1]], warn=FALSE), '\n')
sentences <- list()

# test.cases <- list("2",
#                    "Hello World",
#                    "CodeEval",
#                    "Quick Fox",
#                    "A",
#                    "San Francisco")

test.cases <- list("lunchtime. construction",
                   "time suburb circa update been CADW, They the pointed early it the and nearby reference",
"Fire') time existence. was with nearby was associated listed",
"1853 was J. and, in every listed Adam Welsh in urinals, warp. ",
"J. Year to",
"bikers pointed existence. reference many",
"the",
"an time from lunchtime. and been the ironworks They not total the the was The")

print.num <- as.numeric(test.cases[[1]]) - 1
for (test in test.cases[-1]) {
  if (length(test) > 0) {
    # ignore test if it is an empty line
    # 'test' represents the test case, do something with it
    sentences[[length(sentences) + 1]] <- test
  }
}
order <- rank(sapply(sentences,nchar),ties.method = "first")
sentences <- sentences[order]
for(i in length(sentences):(length(sentences) - print.num)) {cat(sentences[[i]]); cat("\n")}

