import psycopg2
from psycopg2 import sql


def insert(data):
# def insert():
    conn = psycopg2.connect(dbname='d7bp5n5harkeam', user='zsaycydkqempkt',
                            password='fefc1f87a6825208d6135194d342553f7cc19f1fdead7be92b16b9db49eea2b7', host='ec2-63-32-248-14.eu-west-1.compute.amazonaws.com')

    cursor = conn.cursor()
    conn.autocommit = True

    # insert = sql.SQL('INSERT INTO public.headlines(id, name, description, url) VALUES {}').format(sql.SQL(',').join(map(sql.Literal, data)))

    # for i in range(300, 3000):
    #     delete = sql.SQL(f'DELETE FROM public.headlines WHERE id={i}')
    #     cursor.execute(delete)

    # cursor.execute(insert)
    # cursor.execute('SELECT * FROM public.headlines')
    # records = cursor.fetchall()
    # print(records)

    cursor.close()
    conn.close()

insert()