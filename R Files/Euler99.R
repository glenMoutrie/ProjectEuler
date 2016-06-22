library(data.table)
system.time({data <- fread("Downloads/p099_base_exp.csv")
data[, total := V2*log(V1)]
which.max(data[,total])
})