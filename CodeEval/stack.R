stackOutput <- function(input) {
	split <- unlist(strsplit(input, " "))
	print <- seq(length(split), by = -2, length.out = floor(length(split)/2) + 1)
	cat(paste0(split[print],collapse = " "), "\n")
}

stackOutput("1 2 3 4")
stackOutput("10 -2 3 4")
stackOutput("-99 19 -46 42 -85 -23 -74 30 67 -15 24 26 26 75 49 -39 -18 11 22 77 -28 -76 -19 -69 56 -69 90 -64 10 -55 40 -41 -23 83 -26 23 -30 33 15 89 -98 61 68 87 97 65 -25 -30 78 86 40 44 -56 17 50 -90 -40 64 44 4 -53 -77 -81 -27 39 -5 39 -29 -82 -40 -56 -29 90 -28 -50 -76 -53 -74 -2 33 -85 88 -62 17 100 97 -50 -97 0 -37 -68 63 -20 -49 43")