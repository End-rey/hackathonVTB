from operator import contains
import unicodedata
from bs4 import BeautifulSoup
import requests


def parse_cossa(i: int):
    url = f'https://www.cossa.ru/152/?PAGEN_{i}=1&CODE=152'
    print(url)
    arr = []
    body = requests.get(url).content
    soup = BeautifulSoup(body, features="html.parser").find(
        "div", class_="articles_list")
    entry_titles = soup.find_all("a", class_="article__title")
    for entry in entry_titles:
        print(entry['href'])
        if ("https://www.cossa.ru" in entry['href']):
            body1 = requests.get(entry['href']).content
        elif ("trends/" in entry['href']):
            body1 = requests.get('https://www.cossa.ru' + entry['href']).content
        else:
            
            continue
        soup1 = BeautifulSoup(body1, "html.parser")
        des = ""
        divs = soup1.find("div", class_="main")
        if (divs is None):
            continue
        for strin in divs.find_all("p"):
            des += strin.get_text().strip()
        des = unicodedata.normalize("NFKD", des)
        des = des.replace('\xad', '')
        arr.append({"name": soup1.find("div", class_="intro").find('h1').text,
                     "description": des, "url": 'https://www.cossa.ru' + entry['href']})

    return arr
