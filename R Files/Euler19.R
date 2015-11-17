library(lubridate)
start <- as.Date("1901-01-01")
end <- as.Date("2000-12-01")
all.days <- seq(start,end,by="day")
sundays <- rep(1:7,length.out=length(all.days))==6
first.day <- day(all.days)==1
sum(sundays & first.day)