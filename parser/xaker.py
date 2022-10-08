import unicodedata
from bs4 import BeautifulSoup
import requests


def parse_xaker(i: int):
    arr = []
    body = requests.get(
        'https://xakep.ru/category/news/page/' + str(i)).content
    soup = BeautifulSoup(body, features="html.parser").find(
        "div", class_="bdaia-blocks-container")
    entry_titles = soup.find_all("h3", class_="entry-title")
    print("n ", len(entry_titles))
    for entry in entry_titles:
        body1 = requests.get(entry.a['href']).content
        soup1 = BeautifulSoup(body1, "html.parser")
        des = ""
        divs = soup1.find("div", class_="bdaia-post-content can_read")
        if (divs is None):
            continue
        for strin in divs.find_all("p"):
            des += strin.get_text()
        des = unicodedata.normalize("NFKD", des)
        des = des.replace('\xad', '')
        arr.append({"name": soup1.find("h1", class_="post-title entry-title").text,
                     "description": des, "url": entry.a['href']})

    return arr
