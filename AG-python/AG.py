from Cromossomo import Cromossomo
from Util import Util

class Ag:
    @staticmethod
    def gerarPopulacao(populacao, tamanho_populacao, estado_final):
        for i in range(tamanho_populacao):
            populacao.append(Cromossomo(Util.gerar_palavra(len(estado_final))))
    
    @staticmethod
    def exibir(populacao):
        for i in range(len(populacao)):
            print("Cromossomo: ",i)
    
    def selecionarPorTorneio(populacao, novaPopulacao, taxaSelecao):
        