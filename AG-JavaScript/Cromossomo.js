"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Cromossomo = void 0;
class Cromossomo {
    constructor(valor, estadoFinal) {
        this.valor = valor;
        this.aptidao = this.calcularAptidao(estadoFinal);
    }
    calcularAptidao(estadoFinal) {
        let nota = 0;
        for (let i = 0; i < estadoFinal.length; i++) {
            if (this.valor.includes(estadoFinal.charAt(i))) {
                nota += 5;
            }
            if (this.valor.charAt(i) == estadoFinal.charAt(i)) {
                nota += 50;
            }
        }
        return nota;
    }
}
exports.Cromossomo = Cromossomo;
