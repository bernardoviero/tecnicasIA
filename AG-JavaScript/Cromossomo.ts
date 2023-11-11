export class Cromossomo {
    public valor: string;
    public aptidao: number;

    constructor(valor: string, estadoFinal: string) {
        this.valor = valor;
        this.aptidao = this.calcularAptidao(estadoFinal);
    }

    private calcularAptidao(estadoFinal: string): number {
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