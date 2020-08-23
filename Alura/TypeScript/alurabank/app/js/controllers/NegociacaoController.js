class NegociacaoController {
    constructor() {
        // O TypeScript infere o tipo do atributo por meio do objeto instanciado.
        this._negociacoes = new Negociacoes();
        this._negociacoesView = new NegociacoesView('#negociacoesView');
        this._mensagemView = new MensagemView('#mensagemView');
        // Casting é a conversão explícita de um tipo mais genérico para um tipo mais específico.
        this._inputData = document.querySelector('#data');
        // document.querySelector() retorna "Element", que é um tipo mais genérico.
        this._inputQuantidade = document.querySelector('#quantidade');
        // "HTMLInputElement" é um tipo mais específico.
        this._inputValor = document.querySelector('#valor');
        // Use casting quando não houver dúvidas em relação ao tipo esperado.
        /*
            Para facilitar, sempre responda esta pergunta: Todo Element é um HTMLInputElement?
            - Sim: casting implícito
            - Não: casting explícito
        */
        this._negociacoesView.update(this._negociacoes);
    }
    adiciona(event) {
        event.preventDefault();
        const negociacao = new Negociacao(new Date(this._inputData.value.replace(/-/g, ',')), parseInt(this._inputQuantidade.value), parseFloat(this._inputValor.value));
        this._negociacoes.adiciona(negociacao);
        this._mensagemView.update('Negociação adicionada com sucesso!');
        this._negociacoesView.update(this._negociacoes);
    }
}
