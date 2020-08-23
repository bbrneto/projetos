class Negociacoes {
    constructor() {
        // Imutabilidade: permitir que apenas o objeto possa alterar seus atributos.
        this._negociacoes = [];
    }
    adiciona(negociacao) {
        this._negociacoes.push(negociacao);
    }
    // É boa prática indicar o retorno do método, pois ele não é obrigatório.
    paraArray() {
        // Programação defensiva: o método retorna uma cópia do array.
        return [].concat(this._negociacoes);
    }
}
