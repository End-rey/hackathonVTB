import yake

text = ''
f = open('text1.txt', 'r', encoding='utf-8')
for j in f:
    text = j

extractor = yake.KeywordExtractor(

    lan="ru",  # язык
    n=4,  # максимальное количество слов в фразе
    dedupLim=0.3,  # порог похожести слов
    top=30  # количество ключевых слов
)

print(extractor.extract_keywords(text))
