"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const Cromossomo_1 = require("./Cromossomo");
const Util_1 = require("./Util");
class AG {
    static gerarPopulacao(tamanhoPopulacao, estadoFinal) {
        const populacao = [];
        for (let i = 0; i < tamanhoPopulacao; i++) {
            populacao.push(new Cromossomo_1.Cromossomo(Util_1.Util.gerarPalavra(estadoFinal.length), estadoFinal));
        }
        return populacao;
    }
    static ordenar(populacao) {
        populacao.sort((a, b) => b.aptidao - a.aptidao);
    }
    static exibir(populacao) {
        populacao.forEach((cromossomo, index) => {
            console.log(`Cromossomo ${index + 1}: ${cromossomo.valor} - ${cromossomo.aptidao}`);
        });
    }
    static selecionarPorTorneio(populacao, novaPopulacao, taxaSelecao) {
        const qtdSelecionados = Math.floor((taxaSelecao / 100) * populacao.length);
        novaPopulacao.push(populacao[0]); // Elitismo
        for (let i = 1; i <= qtdSelecionados; i++) {
            const torneio = [];
            while (torneio.length < 3) {
                const randomIndex = Math.floor(Math.random() * populacao.length);
                if (!torneio.includes(populacao[randomIndex])) {
                    torneio.push(populacao[randomIndex]);
                }
            }
            torneio.sort((a, b) => b.aptidao - a.aptidao);
            novaPopulacao.push(torneio[0]);
        }
    }
    static reproduzir(populacao, novaPopulacao, taxaReproducao, estadoFinal) {
        const qtdReproduzidos = Math.floor((taxaReproducao / 100) * populacao.length);
        for (let i = 0; i < qtdReproduzidos; i += 2) {
            const pai = populacao[Math.floor(Math.random() * populacao.length)];
            const mae = populacao[Math.floor(Math.random() * populacao.length)];
            const pontoCorte = Math.floor(Math.random() * estadoFinal.length);
            const filho1 = pai.valor.substring(0, pontoCorte) + mae.valor.substring(pontoCorte);
            const filho2 = mae.valor.substring(0, pontoCorte) + pai.valor.substring(pontoCorte);
            novaPopulacao.push(new Cromossomo_1.Cromossomo(filho1, estadoFinal));
            novaPopulacao.push(new Cromossomo_1.Cromossomo(filho2, estadoFinal));
        }
        while (novaPopulacao.length > populacao.length) {
            novaPopulacao.pop(); // Remove excess individuals
        }
    }
    static mutar(populacao, taxaMutacao, estadoFinal) {
        const qtdMutantes = Math.floor((taxaMutacao / 100) * populacao.length);
        for (let i = 0; i < qtdMutantes; i++) {
            const indexMutante = Math.floor(Math.random() * populacao.length);
            const mutante = populacao[indexMutante];
            let valorMutado = mutante.valor;
            const posicaoMutacao = Math.floor(Math.random() * estadoFinal.length);
            const novoCaracter = Util_1.Util.letras.charAt(Math.floor(Math.random() * Util_1.Util.tamanho));
            valorMutado = valorMutado.substr(0, posicaoMutacao) + novoCaracter + valorMutado.substr(posicaoMutacao + 1);
            populacao[indexMutante] = new Cromossomo_1.Cromossomo(valorMutado, estadoFinal);
        }
    }
    static main() {
        const tamanhoPopulacao = 1000;
        const estadoFinal = "paralelepipedo";
        const taxaSelecao = 30;
        const taxaReproducao = 70;
        const taxaMutacao = 7;
        const qtdGeracoes = 1000;
        let populacao = AG.gerarPopulacao(tamanhoPopulacao, estadoFinal);
        AG.ordenar(populacao);
        console.log("Geração 1:");
        AG.exibir(populacao);
        for (let geracao = 2; geracao <= qtdGeracoes; geracao++) {
            const novaPopulacao = [];
            AG.selecionarPorTorneio(populacao, novaPopulacao, taxaSelecao);
            AG.reproduzir(populacao, novaPopulacao, taxaReproducao, estadoFinal);
            AG.mutar(novaPopulacao, taxaMutacao, estadoFinal);
            populacao = [...novaPopulacao];
            AG.ordenar(populacao);
            console.log(`\n\nGeração ${geracao}:`);
            AG.exibir(populacao);
        }
    }
}
AG.main();
