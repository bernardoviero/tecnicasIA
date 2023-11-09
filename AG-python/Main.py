from AG import AG  

tamanho_populacao = int(input("Tamanho população: "))
estado_final = int(input("Estado final: "))
taxa_selecao = int(input("Taxa selecao (20 a 40%): "))
taxa_reproducao = 100 - taxa_selecao
taxa_mutacao = int(input("Taxa mutação (5 a 10%): "))
qtd_geracoes = int(input("Quantidade gerações "))
populacao = []
nova_populacao = []

AG.gerar_populacao(populacao, tamanho_populacao, estado_final)
AG.exibir(populacao)

for i in range(qtd_geracoes):
    # selecionar_torneio(populacao, nova_populacao, taxa_selecao)

    # reproduzir(populacao, nova_populacao, taxa_reproducao, estado_final)

    if i % (len(populacao) / taxa_mutacao) == 0:
        AG.mutar(nova_populacao, estado_final)
    
    populacao.clear()
    populacao.copy(nova_populacao)
    nova_populacao.clear()

    print("Geracao: "+(i+1))
    AG.exibir()
