<<<<<<< HEAD
from sudoku import Sudoku

nome_arquivo_sudoku = "sudoku.txt"  # Nome do arquivo com o cenário Sudoku inicial.
solucao = Sudoku()

if solucao.popular_do_arquivo(nome_arquivo_sudoku):
    solucao.exibir_sudoku("Arquivo de cenário localizado!")

    if solucao.resolve_sudoku(0):  # Aqui é correto usar `resolve_sudoku` em vez de `resolver_sudoku`.
        solucao.exibir_sudoku("\n\nCenário resolvido com sucesso!")
    else:
        print("Cenário não resolvido! A configuração inicial do Sudoku está complexa!")

else:
    print("Arquivo não localizado")
=======
from sudoku import Sudoku

nome_arquivo_sudoku = "sudoku.txt"  # Nome do arquivo com o cenário Sudoku inicial.
solucao = Sudoku()

if solucao.popular_do_arquivo(nome_arquivo_sudoku):
    solucao.exibir_sudoku("Arquivo de cenário localizado!")

    if solucao.resolve_sudoku(0):  # Aqui é correto usar `resolve_sudoku` em vez de `resolver_sudoku`.
        solucao.exibir_sudoku("\n\nCenário resolvido com sucesso!")
    else:
        print("Cenário não resolvido! A configuração inicial do Sudoku está complexa!")

else:
    print("Arquivo não localizado")
>>>>>>> c73c95ec7f70588d01a1c7a6414899cddfd0eeba
