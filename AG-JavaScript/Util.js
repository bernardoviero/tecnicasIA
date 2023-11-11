"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Util = void 0;
class Util {
    static gerarPalavra(n) {
        let palavra = '';
        for (let i = 0; i < n; i++) {
            palavra += Util.letras.charAt(Math.floor(Math.random() * Util.tamanho));
        }
        return palavra;
    }
}
exports.Util = Util;
Util.letras = "abcdefghijklmnopqrstuvxwyz";
Util.tamanho = Util.letras.length;
