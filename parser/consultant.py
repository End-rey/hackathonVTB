import unicodedata
from bs4 import BeautifulSoup
import requests


def parse_consulant(i: int):
    arr = []
    body = requests.get(
        'http://www.consultant.ru/legalnews/?page=' + str(i)).content
    soup = BeautifulSoup(body, features="html.parser").find(
        "div", class_="listing-news__list")

    entry_titles = soup.find_all("a", class_="listing-news__item-title")

    for entry in entry_titles:
        body1 = requests.get('http://www.consultant.ru' +
                             entry["href"]).content
        soup1 = BeautifulSoup(body1, "html.parser")
        des = ""
        divs = soup1.find("div", class_="news-page__text")
        if (divs is None):
            continue
        for strin in divs.find_all("p"):
            des += strin.text
        des = unicodedata.normalize("NFKD", des)
        des = des.replace('\xad', '')
        arr.append({"name": soup1.find("h1", class_="news-page__title").text,
                    "description": des, "url": 'http://www.consultant.ru' + entry["href"]})
    return arr

