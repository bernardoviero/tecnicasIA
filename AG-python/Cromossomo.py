class Cromossomo:
    def __init__(self, valor, estado_final):
        self.valor = valor
        self.aptidao = calcular_aptidao(estado_final)

    def calcular_aptidao(self, estado_final):
        for i in range(len(estado_final)):
            nota = 0
            if(estado_final[i] in self.valor):
                nota += 5
            if(self.valor[i] == estado_final[i]):
                nota += 50
        return nota
    
    def __eq__(self, other):
        if isinstance(other, Cromossomo):
            return self.valor == other.valor
        return False

    def __gt__(self,other):
        return self.aptidao <= other.aptidao

    def __str__(self):
        return "valor= " + str(self.valor) + ", aptidao = " + str(self.aptidao)