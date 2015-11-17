###########################################
## Time Series Prediction 2.2.0 Features ##
###########################################

## Handle errors in estimation using tryCatch() and suppressWarnings()

## Better encapsulation when user specifies what forecast model to use
## Sort out the mess that is the parallel estimation, now includes parrallelisation of test forecast when model is selected.
## Pushes towards Holt-Winters for large datasets
## Include changes suggested in January 13th sprint meeting
## Perform multiple time series forecasts, and choose optimal based on forecast accuracy
## Provide rolling forecast accuaracy
## Allow the user to force the model selection (ie, choose ARIMA, ETS or HoltWinters)
## Output confidence intervals
## Use lubridate to detect periodicity (TO DO IN LATER ITERATION)
## Better method of outputting dates
## Robustness checks performed
## Parallel model selection
## Providing the data and the
## Use of data.table

## 2.1.0 NEW FEATURES
## Forecast comparison option

#######################
## R Studio preamble ##
#######################

# Install Packages
# library(iterators)
# library(foreach)
# library(snow)
# library(doParallel)
library(forecast)
library(xts)
library(lmtest)
library(data.table)


####################
# Data for testing #
####################

# Create imaginary large data set for testing
# library(lubridate)
# length <- 1500000
# period <- 24
# end <- Sys.time()
# start <- as.POSIXlt(end)-minutes(length)
# dates <- seq(start,end,length.out = length)
# values <- ((1.05*(1)*sin((1:length)/period)+rnorm(length,0,0.05))*((1:length)*(1/1000))+((1:length)*(1/1000))^1.5+10000)
# input.data <- data.frame(dates = dates,values = values)
# frequency <- (2*pi)*period
# write.csv(input.data,"Documents/Data/massivefakets.csv",row.names=F)
# # plot(dates,values,type = "l")
# # plot(dates,log(values),type = "l")

# Only needed for data
# library(MASS)

# External datasets
# input.data <- as.data.table(target[,c(2,3)])
# input.data <- fread("Documents/nytmax1900-2014clean.csv"); input.data[,DATE:= as.POSIXct(DATE)]
input.data <- data.table(dates=as.POSIXct(as.Date(time(AirPassengers))), values = as.vector(AirPassengers)); # input.data <- tail(input.data,10)
# input.data <- data.table(dates=as.POSIXct(as.Date(time(AirPassengers))), values = as.vector(AirPassengers)); input.data <- input.data[100:144]
# input.data <- data.table(dates=as.Date(time(deaths)),values =as.vector(deaths))
# input.data <- fread("Documents/Data/massivefakets.csv"); input.data[,dates:= as.POSIXct(dates)]
# input.data <- fread("Documents/Data/Airpassengers.csv"); input.data[,dates:= as.POSIXct(dates)]                                         #Airline Data
# input.data <- fread("Documents/Data/Airpassengers.csv"); input.data[,values:=log(values)]; input.data[,dates:= as.POSIXct(dates)] #Airline Data logged
# input.data <- fread("Documents/Data/weatherberkleyclean.csv"); input.data[,dates:= as.POSIXct(dates)]                   #Berkley weather analysis data
# input.data <- fread("Desktop/trends"); input.data[,Week:= as.POSIXct(Week)]                                                   #Google trends data
# input.data <- fread("Documents/Data/nytmax1900-2014clean.csv"); input.data[,DATE:=as.POSIXct(DATE)]                   #NY weather data
# input.data <- fread("Documents/Data/NYcabjanclean.csv"); input.data[,pickup_datetime:=as.POSIXct(pickup_datetime)]                         #NY january cab data
# input.data <- fread("Documents/Data/NYcabfebclean.csv"); input.data[,pickup_datetime:=as.POSIXct(pickup_datetime)]                           #NY febuary cab data




# Provide R plots
provide.r.plot <- T

################
## Parameters ##
################

# Mandatory
date.field <- 1
value.field <- 2


# Optional
confidence.intervals <- T

user.force.multiplicative <- "AUTO"
# user.force.multiplicative <- "MULTIPLICATIVE"
# user.force.multiplicative <- "ADDITIVE"

forecast.model <- "AUTO"
# forecast.model <- "ARIMA"
# forecast.model <- "STLM"
# forecast.model <- "HOLTWINTERS"

# forecast.length <- "WEEK"
# forecast.length <- "QUARTER"
# forecast.length <- "BIANNUAL"
forecast.length <- "ANNUAL"
# forecast.length <- "SPECIFY"
# forecast.length <- "OTHER"

predict.to.date <- "2020-03-25 00:00:00"
prediction.length <- 36

provide.test <- T

frequency <- NULL

#####################
## Start the clock ##
#####################

ptm <- proc.time()

##################################################################################################################
#### Everything from here to the next line of "#"'s is for omniscope input. Needs to be in clean presentation ####
##################################################################################################################

# These values are used throughout. Worth creating now.
seconds.by.period <- list(year = 365.2425*60*60*24,
biannual = 180*60*60*24,
quarter = 365.2425*60*60*24/4,
month = 365.2425*60*60*24/12,
week = 60*60*24*7,
day = 60*60*24,
hour = 60*60,
minute = 60)

# Modified version of periodicity funciton (more accuracy, also doesn't manipulate the frequency if the peridocity is a minute)
periodicity.Omni <- function (x, ...)
{
if (timeBased(x) || !is.xts(x))
x <- try.xts(x, error = "'x' needs to be timeBased or xtsible")
p <- median(diff(.index(x)))
if (is.na(p))
stop("can not calculate periodicity of 1 observation")

if (p < seconds.by.period$minute) {
units <- "secs"
scale <- "seconds"
label <- 1
posix.length <- 1
}
else if (p < seconds.by.period$hour) {
units <- "mins"
scale <- "minute"
label <- 60
posix.length <- seconds.by.period$minute
}
else if (p < seconds.by.period$day) {
units <- "hours"
scale <- "hourly"
label <- "hour"
posix.length <- seconds.by.period$hour
}
else if (p == seconds.by.period$day) {
scale <- "daily"
label <- "day"
posix.length <- seconds.by.period$day
}
else if (p <= seconds.by.period$week) {
scale <- "weekly"
label <- "week"
posix.length <- seconds.by.period$week
}
else if (p <= 31*60*60*24) { #Better to have a higher value in this instance
scale <- "monthly"
label <- "month"
posix.length <- seconds.by.period$month
}
else if (p <= seconds.by.period$quarter) {
scale <- "quarterly"
label <- "quarter"
posix.length <- seconds.by.period$quarter

} else if (p <= seconds.by.period$year) {
units <- "yearly"
scale <- "year"
posix.length <- seconds.by.period$year

} else {
units <- NA
scale <- NA
label <- p
posix.length <- p
}
structure(list(difftime = structure(p, units = units, class = "difftime"),
frequency = p, posix.length = posix.length, start = start(x), end = end(x), units = units,
scale = scale, label = label), class = "periodicity")
}

# Check the users set model and seasonality settings (enum conversion)
auto.detect.model <- forecast.model=="AUTO"
use.stlm <- forecast.model=="STLM"
use.arima <- forecast.model=="ARIMA"
use.holt <- forecast.model=="HOLTWINTERS"
check.seasonality <- user.force.multiplicative=="AUTO"

# Handle the lack of dates, if they are provided then create a smart guess at the series frequency.
dates.provided <- !is.null(date.field)


if(dates.provided) {
# Rename fields (required when using data.table)
setnames(input.data,c(date.field,value.field),c("dates","values"))

# Number of observations, this is used frequently throughout
length.observed <- length(input.data[,values])

# Coerse to time series format
input.data <- input.data[order(dates)]

# Find time interval (observations per year)
years <- year(input.data[,dates])
xts.object <- xts(input.data[,values],order.by=input.data[,dates])
period <- periodicity.Omni(xts.object)
period.length <- period$posix.length

# Set up the frequency and lower the frequency if the observed data is too short
if (is.null(frequency)) {
frequency <- round((365*60*60*24)/period.length)
if (length.observed/frequency <= 2) {
i <- 1
while(length.observed/frequency <= 2 && i<=length(seconds.by.period)) {
frequency <- round(seconds.by.period[[i]]/period.length)
i <- i + 1
}
if (length.observed/frequency <= 2) {
stop("Failed to find an effective frequency period using dates. Consider entering a manual frequency.")
}
}
}

} else {
# Rename fields (required when using data.table)
setnames(input.data,value.field,"values")

# Number of observations, this is used frequently throughout
length.observed <- length(input.data[,values])

# Create a fake set of dates (cleaner than creating two methods of creating ts.objects)
if (is.null(frequency)) {
stop("Failed to find an effective frequency period using dates. Consider entering a manual frequency.")
}
input.data[,dates:=seq(ISOdate(1910,1,1), ISOdate(1910,1,1)+(length.observed-1), "sec")]
years <- year(input.data[,dates])
message("Recommendation: Providing dates can help provide more accurate forecasts.")
}

# If dates have been provided, calculate the forecast length
if (forecast.length != "OTHER") {
if(!dates.provided) {
# Tell the user that it is not possible to use a vernacular forecast length if dates aren't provided.
message("If not date field is provided the forecast length must be specified by the user. To do so select 'Other'
on the drop down menu, a default of 20 periods was forecasted")
prediction.length <- 20
} else {
# Convert from vernacular to period
if (forecast.length=="WEEK") {
seconds.ahead <- seconds.by.period$week
} else if (forecast.length=="QUARTER") {
seconds.ahead <- seconds.by.period$quarter
} else if (forecast.length=="BIANNUAL") {
seconds.ahead <- seconds.by.period$biannual
} else if (forecast.length=="ANNUAL") {
seconds.ahead <- seconds.by.period$year
} else if (forecast.length=="SPECIFY") {
target <- as.POSIXct(predict.to.date)
#Needs to be multiplied as lubridate converts difference to days
seconds.ahead <- as.numeric(target - tail(input.data[,dates],1))*24*60*60
}
prediction.length <- ceiling(seconds.ahead/period.length)
}
} else {
# Check that the user has actually provided a prediction length
if(is.null(prediction.length)) {
message("The number of observations to forecast has not been specified, reverting
to a default forecast length of 20 observations.")
prediction.length <- 20
}
}

# Start date used for the creation of the ts object
start.date <- c(min(years), as.POSIXlt(min(input.data[,dates]),origin ="1970-01-01")$mon+1)

# Put into a time series format and test to see if logs should be taken
if (!check.seasonality) {
# Check if the user has forced multiplicative
take.logs <- user.force.multiplicative=="MULTIPLICATIVE"

if (!take.logs) {
# TS object can be calculated at this point
time.series <- ts(input.data[,values], start=start.date, frequency=frequency)
}

} else if (check.seasonality && length.observed/frequency > 2) {
# Perform STL to get residuals that will be used in a Heteroskedasity test
time.series <- ts(input.data[,values], start = start.date, frequency = frequency)
stl <- stl(time.series, s.window = frequency)
het.test.stat <- bptest(formula(as.vector(time.series) ~ -1 + stl$time.series[,1] + stl$time.series[,2]))
take.logs <- (het.test.stat$p.value < 0.95) && min(input.data[,values]) > 0

} else {
time.series <- ts(input.data[,values], start = start.date, frequency = frequency)
take.logs <- F
}

# Take logs if needed, and create TS object with new values
if (take.logs) {
input.data[,values := log(values)]
time.series <- ts(input.data[,values], start=start.date, frequency=frequency)
}

# Choose data to test forecast over
truncated.observations <- length.observed-prediction.length
if (truncated.observations<(0.5*length.observed)) {
truncated.observations <- floor(0.5*length.observed)
}
start.date.observed <- c(years[truncated.observations+1],
as.POSIXlt(input.data[truncated.observations+1,dates],origin ="1970-01-01")$mon+1)

# Dealing with high frequency which slows down auto.arima. Decide to avoid auto.arima here if necessary.
drop.arima <- F # Note that the variable will need to be created at this level.
if((auto.detect.model || use.arima) || (frequency >=52 || length.observed >= 10^5 ) ) {
# Function to decrease the frequency of arima
decrease.frequency <- function(frequency) {
x <- frequency

if (x==52) {
x <- 4

} else if (x==365) { # From daily to weekly season
x <- 7

} else if (x == 24*365) { # From hourly to daily season
x <- 24

} else if (x == 60*24*365) {# From minutes to hourly season
x <- 60

} else if (x == 60*60*24*365) {# From seconds to minute season
x <- 60

} else  if (x >= 300){# Eliminate season
x <- 1
}
x
}

# Create time series especially for arima
frequency.arima <- decrease.frequency(frequency)
if(frequency==1 || (length.observed >= 10^5 && !auto.detect.model)) {
drop.arima <- T
if(use.arima==T) {
stop("The frequency found for the data is too high to perform ARIMA, please select a different model")
}
} else {
time.series.arima <- ts(input.data[,values], start=start.date, frequency=frequency.arima)
truncated.data.arima <- ts(input.data[1:truncated.observations,values], start=start.date, frequency=frequency.arima)
observed.data.arima <- ts(input.data[(truncated.observations+1):length.observed,values],
start = start.date.observed,
frequency = frequency.arima)
}
}

# Format the data accordingly, note that it needs to be as a ts object for some models
truncated.data <- ts(input.data[1:truncated.observations,values], start=start.date, frequency=frequency)
observed.data <- ts(input.data[(truncated.observations+1):length.observed,values],
start=start.date.observed,
frequency=frequency)
test.forecast.length <- length.observed-truncated.observations

# Get rid of this and all parallel for now...
# # Set up cluster
# closeAllConnections()
# cores <- detectCores()
# if (cores == 1) {
#   registerDoSEQ()
# } else {
#   cl <- makeSOCKcluster(cores) # snow
#   registerDoParallel(cl)
# }

# Create the funciton to calculate the mean average percentage error
calculate.mape <- function(forecast,observed){
mean(abs(apply(cbind(forecast,observed),1,function(v){(v[1]-v[2])/v[2]})))
}

# Set up functions for the calculation process depending on the users model specification
do.forecast <- function(test,model,ts,td,t.forecast.length, observed, calc.mape, forecast.method) {

# Select the forecasting model
if (forecast.method == "arima") {
forecast.model <- forecast:::auto.arima
} else if (forecast.method == "stlm") {
forecast.model <- forecast:::stlm
} else if (forecast.method == "holt") {
forecast.model <- stats:::HoltWinters
}

# If both a test and model are needed.
if(test && !model) {
fore.data <- forecast:::forecast(suppressWarnings(forecast.model(td)),h=t.forecast.length)
acc <- calc.mape(as.vector(fore.data$mean),as.vector(observed))
output <- list(fore.data = fore.data,acc = acc)

# Otherwise just provide the forecast
} else if(!test && model) {
output <- list(actual.forecast=suppressMessages(forecast.model(ts)))

# For the instance where the user has specified a model and asks for the test as well. (Paralell here)
} else if(test && model) {
#     Again temporarily
#     both.models <- list(test = td, actual = ts)) %dopar% ({suppressWarnings(forecast.model(x))})
both.models <- lapply(list(test = td, actual = ts),function(x){suppressWarnings(forecast.model(x))})
fore.data <- forecast:::forecast(both.models[[1]],h=t.forecast.length)
fore.model <- both.models[[2]]
acc <- calc.mape(as.vector(fore.data$mean),as.vector(observed))
output <- list(fore.data = fore.data,actual.forecast=fore.model,acc = acc)
}
output
}



if(auto.detect.model) {
if (drop.arima) {
models.to.use <- c("stlm","holt")
} else {
models.to.use <- c("arima","stlm","holt")
}
n <- length(models.to.use)
#   truncated.models <- (foreach(selected.model=models.to.use) %dopar% ({
#     prediction <- do.forecast(test=T,model=F,ts = time.series, td = truncated.data,
# t.forecast.length=test.forecast.length, observed = observed.data, calc.mape = calculate.mape, forecast.method = selected.model)
#   }))
truncated.models <- lapply(models.to.use, function (selected.model){
prediction <- do.forecast(test=T,model=F,ts = time.series, td = truncated.data,
t.forecast.length=test.forecast.length, observed = observed.data, calc.mape = calculate.mape, forecast.method = selected.model)
})
names(truncated.models) <- models.to.use
accuracies <- sapply(truncated.models,function(x){x[[2]]})
best.model <- names(which(accuracies==min(accuracies)))

#   Bad way of putting 10 lines of code into two... (and the results are ever so slightly different)
#   test <- eval(parse(text = paste0("truncated.models$",best.model,"[[1]]")))
#   model <- eval(parse(text = paste0("do.",best.model,"(F,T,time.series,truncated.data,test.forecast.length,observed.data,calculate.mape)")))

if(best.model == "arima") {
test <- truncated.models$arima[[1]]
model <- do.forecast(F,T,time.series.arima,
truncated.data.arima,test.forecast.length,observed.data,calculate.mape,best.model)[[1]]
} else if (best.model=="stlm") {
test <- truncated.models$stlm[[1]]
model <- do.forecast(F,T,time.series,
truncated.data,test.forecast.length,observed.data,calculate.mape,best.model)[[1]]
} else {
test <- truncated.models$holt[[1]]
model <- do.forecast(F,T,time.series,
truncated.data,test.forecast.length,observed.data,calculate.mape,best.model)[[1]]
}
} else {
if (use.arima) {
model.output <- do.forecast(provide.test,T,time.series.arima,
truncated.data.arima,test.forecast.length,observed.data,calculate.mape,"arima")
model <- model.output$actual.forecast
if(provide.test) {
test <- model.output$fore.data
acc.test <- model.output$acc
}
} else if (use.holt) {
model.output <- do.forecast(provide.test,T,time.series,
truncated.data,test.forecast.length,observed.data,calculate.mape,"holt")
model <- model.output$actual.forecast
if(provide.test) {
test <- model.output$fore.data
acc.test <- model.output$acc
}
} else {
model.output <- do.forecast(provide.test,T,time.series,
truncated.data,test.forecast.length,observed.data,calculate.mape,"stlm")
model <- model.output$actual.forecast
if(provide.test) {
test <- model.output$fore.data
acc.test <- model.output$acc
}
}}
# Get rid of test for the block
# stopCluster(cl)

# Perform the prediction get out relevant forecast data
prediction <- forecast(model, h=prediction.length)
if(dates.provided) {
dates <- seq(from = tail(input.data[,dates],1), by = period$label, length.out = prediction.length+1)[-1]
}

# Format the data depending on how logs have been taken
if(take.logs) {
method <- exp
} else {
method <- c
}

values <- method(c(input.data[,values], prediction$mean))
upper95 <- method(c(rep(NA,length.observed), prediction$upper[,2]))
lower95 <- method(c(rep(NA,length.observed),  prediction$lower[,2]))
upper80 <- method(c(rep(NA,length.observed), prediction$upper[,1]))
lower80 <- method(c(rep(NA,length.observed), prediction$lower[,1]))


# Obtain the data on the forcast accuracy
if (provide.test) {
values.test <- method(c(as.vector(truncated.data), test$mean, rep(NA,prediction.length)))
upper95.test <- method(c(rep(NA,truncated.observations), test$upper[,2], rep(NA,prediction.length)))
lower95.test <- method(c(rep(NA,truncated.observations),  test$lower[,2], rep(NA,prediction.length)))
upper80.test <- method(c(rep(NA,truncated.observations), test$upper[,1], rep(NA,prediction.length)))
lower80.test <- method(c(rep(NA,truncated.observations), test$lower[,1], rep(NA,prediction.length)))
} else {
values.test <- upper95.test <- lower95.test <- upper80.test <- lower80.test <- rep(NA,lenght.out=prediction.length+length.observed)
}

# Output the data as a single data frame, merging the input data with the forecast data.
output.data <- data.frame(
# Adding the forecasted values
values = values,
# Indicator for forecasted data and date index
forecast = c(seq(0,0,length.out=length.observed),
seq(1,1,length.out = prediction.length)))

if (dates.provided) {
output.data$dates <- c(input.data[,dates], dates)
}

if (provide.test) {
output.data$values.test <- values.test
}

if(confidence.intervals) {
output.data$values <- values
output.data$upper95 <- upper95
output.data$lower95 <- lower95
output.data$upper80 <- upper80
output.data$lower80 <- lower80
}
# Adding the test values
if(confidence.intervals && provide.test) {
output.data$values.test <- values.test
output.data$upper95.test <- upper95.test
output.data$lower95.test <- lower95.test
output.data$upper80.test <- upper80.test
output.data$lower80.test <- lower80.test
}


# Provide a message for the user about the forecast method used and the test error

if(use.stlm) {
pred <- "STLM"
} else if (use.arima) {
pred <- "ARIMA"
} else if (use.holt) {
pred <- "Holt Winters"
} else if (auto.detect.model) {
if (best.model == "holt") {
pred <- "Holt Winters"
} else if (best.model == "arima") {
pred <- "ARIMA"
} else {
pred <- "STLM"
}
}

info.for.user <- paste0("The prediction method used for the forecast was ",pred)
if (auto.detect.model) {
info.for.user2 <- paste0("The test forecast performed had an average error of ",round(min(accuracies)*100,digits=2),"%")
} else if (provide.test) {
info.for.user2 <- paste0("The test forecast performed had an average error of ",round(acc.test*100,digits=2),"%")
} else {
info.for.user2 <- paste0("Test forecast was not performed")
}

message(paste0(info.for.user,". ",info.for.user2,"."))
##################################################################################################################
#### Everything from here to the next line of "#"'s is for omniscope input. Needs to be in clean presentation ####
##################################################################################################################

# Stop clock
time <- proc.time() - ptm
#
if (provide.r.plot) {
# Plot output.data to check the results
pred <- as.character(model$call)[1]
if(is.na(pred)) {
pred <- "STLM"
}

title <- paste0("Prediction using ",pred)
if (auto.detect.model) {
title2 <- paste0("Test forecast with an average error of ",round(min(accuracies)*100,digits=2),"%")
} else if (provide.test) {
title2 <- paste0("Test forecast with an average error of ",round(acc.test*100,digits=2),"%")
} else {
title2 <- paste0("Test forecast was not performed")
}


par(mfrow=c(2,1))
plot(output.data$upper95,type="l",lty=2,main=title,ylab="Output Data", xlab="Time", xaxt = "n",
ylim=c(min(output.data$values),max(na.omit(output.data$upper95))))
if(dates.provided) {
axis.POSIXct(side=1,output.data$dates)
}
lines(output.data$values,lty=1)
lines(output.data$lower95,lty=2)
lines(output.data$lower80,lty=2, col="red")
lines(output.data$upper80,lty=2, col="red")
abline(v=length.observed)

plot(output.data$upper95.test,type="l",lty=2,main=title2,ylab="Output Data", xlab="Time", xaxt = "n",
ylim=c(min(output.data$values),max(na.omit(output.data$upper95))))
if(dates.provided) {
axis.POSIXct(side=1,output.data$dates[1:length.observed])
}
lines(output.data$values.test,lty=1)
lines(output.data$lower95.test,lty=2)
lines(output.data$lower80.test,lty=2, col="red")
lines(output.data$upper80.test,lty=2, col="red")
lines(output.data$values[1:length.observed],lty=4,lwd=2,col="blue")
abline(v=length.observed)
abline(v=truncated.observations)
par(mfrow=c(1,1))

# plot.ts(cbind(output.data$values,output.data$upper95,output.data$lower95)[48900:49002,])
#
#   plot(tail(output.data$upper,400),type="l",lty=2,main=title,ylab="Output Data", xlab="Time", xaxt = "n",ylim=c(-4,4))
#   axis.POSIXct(side=1,tail(output.data$dates,400))
#   lines(tail(output.data$values,400),lty=1)
#   lines(tail(output.data$lower,400),lty=2)
#
#   plot(tail(output.data$values,500),type="l",ylim=c(65000,74000))
#   lines(tail(output.data$upper,500),lty=2)
#   lines(tail(output.data$lower,500),lty=2)
}
print(time)