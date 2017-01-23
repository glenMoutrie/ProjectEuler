import numpy
from collections import Counter
from bs4 import BeautifulSoup
import urllib
from functools import reduce
import pandas
from sklearn.cluster import KMeans



###############################################################
## Grabbing each of the URLs for each of the prime ministers ##
###############################################################

# Download the url and put it into beautiful soup
html_doc = urllib.urlopen("https://en.wikipedia.org/wiki/List_of_Prime_Ministers_of_the_United_Kingdom_by_tenure")
soup = BeautifulSoup(html_doc, 'html.parser')

# Find the table of prime ministers
soup = soup.find("table", {"class" : "wikitable sortable"});

# This is where we will put the URL's
targetURLs = {}

# Iterate over each column of table of PM's
for row in soup.findAll("tr"):
    cols = row.findAll("td")

    # Title will have 0 rows, everything else should have 6
    if len(cols) == 6:

        link = cols[1].find("a")

        # Grab the second column of every row
        targetURLs[link.getText()] = "https://en.wikipedia.org" + str(link["href"])

###############################################
## Get information about each prime minister ##
###############################################

# Scraper function
def scrapePM(url):

    # Open the relevant URL and create a beautiful soup
    html_PM = urllib.urlopen(url)
    soupPM = BeautifulSoup(html_PM, "html.parser")

    # Find all of the links on the page
    links = soupPM.find_all("a", href = True)

    # Create the topics array
    topics = []

    # Go through every link
    for i in links:

        # We need to catch UnicodeEncodeErrors
        try:
            # Get the link target and convert to a string
            link = str(i["href"])

            # We are only interested in links to other pages, these usually start with wiki
            if link.startswith("/wiki/"):

                # Remove the /wiki/ part of the URL
                link = link[6:]

                # We don't want any of these file types. If it doesn't start with this, then add to topics
                if not link.startswith(("File:","Wikipedia:","Special:","Portal:","Help:", "Talk:","Category:")):
                    topics.append(str(link))

        # If there is a UnicodeEncodeError, say what the nature of the error was and print the link
        except UnicodeEncodeError:
            print(str(UnicodeEncodeError.message) + "\n" + str(link))

    # Return the topics
    return topics

####################################
## Clean up the data for analysis ##
####################################

pmTopics = {}

for pm in targetURLs.keys()[:2]:
    pmLinks = scrapePM(targetURLs[pm])
    pmTopics[pm] = Counter(pmLinks)

keyWords = reduce(lambda a,b: a | b, pmTopics.values()).most_common(1000)

print pmTopics[targetURLs.keys()[0]]["fakeName"]
print keyWords[0]

data = []

for pm in targetURLs.keys()[:2]:

    counts = []
    for i in keyWords:
        counts.append(pmTopics[pm][i])
    data.append((pm, counts))



data = pandas.DataFrame.from_items(data, orient = "index", columns = keyWords)

fit = KMeans(n_clusters = 4).fit(data)

# for i in scrapePM(targetURLs["David Cameron"]): print i