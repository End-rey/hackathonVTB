import os
import psycopg2
DATABASE_URL = 'postgres://zsaycydkqempkt:fefc1f87a6825208d6135194d342553f7cc19f1fdead7be92b16b9db49eea2b7@ec2-63-32-248-14.eu-west-1.compute.amazonaws.com:5432/d7bp5n5harkeam'
conn = psycopg2.connect(DATABASE_URL, sslmode='require')

cur = conn.cursor()
print(conn.get_dsn_parameters(),'\n')
cur.execute("SELECT version();")
# Получить результат
record = cur.fetchone()
print("Вы подключены к - ", record, "\n")