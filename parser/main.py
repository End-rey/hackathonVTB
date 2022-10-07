from multiprocessing.dummy import Pool
from bs4 import BeautifulSoup
import requests
import multiprocessing
import time


def main():
    now1 = time.time()

    pool = multiprocessing.Pool(multiprocessing.cpu_count())

    pool.map(parse, range(1, 3))
    pool.close()


def parse(i: int):
    body = requests.get('https://xakep.ru/page/' + str(i)).content
    soup = BeautifulSoup(body, features="html.parser").find(
        "div", class_="bdaia-blocks-container")
    entry_titles = soup.find_all("h3", class_="entry-title")
    for j, entry in enumerate(entry_titles):
        body1 = requests.get(entry.a["href"]).content
        print('headline №', j, "page №", i)


if __name__ == "__main__":
    main()
