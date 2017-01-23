import numpy
from bs4 import BeautifulSoup
import pandas
import sklearn
import urllib

html_doc = urllib.urlopen("https://en.wikipedia.org/wiki/List_of_Prime_Ministers_of_the_United_Kingdom_by_tenure")

soup = BeautifulSoup(html_doc, 'html.parser')

soup = soup.find_all("a");

for x in soup:
    print x