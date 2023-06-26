import nltk

if __name__ == '__main__':
    print('ola')
    nltk.download()
    nltk.download('punkt')
    nltk.download('averaged_perceptron_tagger')

    sentence = """At eight o'clock on Thursday morning
    ... Arthur didn't feel very good."""

    tokens = nltk.word_tokenize(sentence)
    print(tokens)

    tagged = nltk.pos_tag(tokens)
    print(tagged)