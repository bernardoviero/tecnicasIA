export class Util {
    public static letras = "abcdefghijklmnopqrstuvxwyz";
    public static tamanho = Util.letras.length;

    public static gerarPalavra(n: number): string {
        let palavra = '';
        for (let i = 0; i < n; i++) {
            palavra += Util.letras.charAt(Math.floor(Math.random() * Util.tamanho));
        }
        return palavra;
    }
}