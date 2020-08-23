class Negociacoes {

    // Imutabilidade: permitir que apenas o objeto possa alterar seus atributos.
    private _negociacoes: Negociacao[] = [];

    adiciona(negociacao: Negociacao): void {
        this._negociacoes.push(negociacao);
    }

    // É boa prática indicar o retorno do método, pois ele não é obrigatório.
    paraArray(): Negociacao[] {
        // Programação defensiva: o método retorna uma cópia do array.
        return [].concat(this._negociacoes);
    }

}