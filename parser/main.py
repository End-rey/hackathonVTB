import multiprocessing
from xaker import parse_xaker
from tzh import parse_tzh
from cossa import parse_cossa
from consultant import parse_consulant
from database import insert


def main():
    pool = multiprocessing.Pool(multiprocessing.cpu_count())

    # a = pool.map(parse_xaker, range(1, 67))
    # b = pool.map(parse_tzh, range(1, 37))
    a = pool.map(parse_cossa, range(1, 65))
    b = pool.map(parse_consulant, range(1, 400))

    

    i = 3512
    data = []
    for arr in a:
        for headline in arr:
            data.append((i, headline['name'], headline['description'], headline['url']))
            i += 1
    for arr in b:
        for headline in arr:
            data.append((i, headline['name'], headline['description'], headline['url']))
            i += 1

    insert(data)

    pool.close()


if __name__ == "__main__":
    main()
