data <- as.list(read.csv("Downloads/p079_keylog.csv",header = F)[,1])

split <- function (x) {
	t(as.matrix(as.numeric(unlist(strsplit(as.character(x),"")))))
}

# Numbers in code
numbers <- unique(unlist(lapply(data, split)))

# Row is observation, row is order
split.data <- do.call(rbind,lapply(data, split))

# Numbers that appear in each row
unique.in.position <- apply(split.data,2,unique)

existsInCol <- function(col,other.col) {
	sapply(col, function (x) {x %in% other.col})
}

checkExistenceInOtherColumns <- function (col.num, data) {
	apply(data[,-col.num],2,existsInCol,data[col.num])
}

checkExistenceInOtherColumns(1,unique.in.position)