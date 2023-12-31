import random

class Util:
    letras = "abcdefghijklmnopqrstuvxwyz"
    tamanho = len(letras)

    @classmethod
    def gerarPalavra(cls, n):
        palavra = []
        for _ in range(n):
            palavra.append(cls.letras[random.randint(0, cls.tamanho - 1)])
        return ''.join(palavra)