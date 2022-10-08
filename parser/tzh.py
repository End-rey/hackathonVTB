import unicodedata
from bs4 import BeautifulSoup
import requests


def parse_tzh(i: int):
    arr = []
    body = requests.get('https://journal.tinkoff.ru/flows/business-all/page/' + str(i)).content
    soup = BeautifulSoup(body, features="html.parser").find("div", class_="contentMain--Fii26")

    entry_titles = soup.find_all("a", class_="link--xmoGM")

    for entry in entry_titles:
        body1 = requests.get('https://journal.tinkoff.ru' + entry["href"]).content
        soup1 = BeautifulSoup(body1, "html.parser")
        des = ""
        divs = soup1.find("div", class_="article-body")
        if (divs is None):
            continue
        for strin in divs.find_all("p"):
            des += strin.text
        des = unicodedata.normalize("NFKD", des)
        des = des.replace('\xad', '')
        arr.append({"name": soup1.find("h1", class_="article-header__title").text, 
                    "description": des, "url": 'https://journal.tinkoff.ru' + entry["href"]})
    return arr


