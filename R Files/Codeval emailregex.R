checkEmail <- function(input) {
	
	# Acceptable local carachters
	local.char <- "\\!\\#\\$\\%\\&'*\\+\\-\\/\\=\\?\\^\\_\\`\\{\\|\\}\\~A-Za-z\\d"
	
	# Regex components
	local <- paste0("^[", local.char,"]+(.[", local.char,"]+)*")
	domain <- "([A-Za-z](.[A-Za-z]+)*)+(.[A-Za-z]+)?(.[A-Za-z]+)$"
	
	# Create the expression
	reg.exp <- paste0(local,"@",domain)
	
	# Catch it
	grepl(pattern = reg.exp, x = input, perl = T)
}

# "\!\#\$\%\&\'\*\+\-\/\=\?\^\_\`\{\|\}\~\.{1}"

checkEmail("glen.1.1out..rie@g.m.a.i.l.com")
checkEmail("glenmoutrie@gmail.co.org")
checkEmail("afas")
