import tensorflow as tf
from summa import keywords
import nltk
from nltk.corpus import stopwords
nltk.download ("stopwords")
stops = list(set(stopwords.words("russian")))
f = open('text1.txt','r',encoding='utf-8')
for j in f:
    text = j
# print(text)
text_clean = ''
for i in text.split():
    if i not in stops:
        text_clean += i + " "
print(keywords.keywords (text_clean, language = "russian").split("\n"))
