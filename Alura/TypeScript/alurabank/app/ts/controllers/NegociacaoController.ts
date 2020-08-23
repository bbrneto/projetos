class NegociacaoController {
/*
    any é um tipo implícito.
    any é o tipo adotado quando não houver tipo.
    private _inputValor;     =>     private _inputValor: any;
*/    
    private _inputData: HTMLInputElement;

    private _inputQuantidade: HTMLInputElement;

    private _inputValor: HTMLInputElement;

    // O TypeScript infere o tipo do atributo por meio do objeto instanciado.
    private _negociacoes = new Negociacoes();

    private _negociacoesView = new NegociacoesView('#negociacoesView');

    private _mensagemView = new MensagemView('#mensagemView');

    constructor() {
        // Casting é a conversão explícita de um tipo mais genérico para um tipo mais específico.
        this._inputData = <HTMLInputElement>document.querySelector('#data');

        // document.querySelector() retorna "Element", que é um tipo mais genérico.
        this._inputQuantidade = <HTMLInputElement>document.querySelector('#quantidade');

        // "HTMLInputElement" é um tipo mais específico.
        this._inputValor = <HTMLInputElement>document.querySelector('#valor');

        // Use casting quando não houver dúvidas em relação ao tipo esperado.
        /* 
            Para facilitar, sempre responda esta pergunta: Todo Element é um HTMLInputElement?
            - Sim: casting implícito
            - Não: casting explícito
        */
        this._negociacoesView.update(this._negociacoes);
    }

    adiciona(event: Event) {
        event.preventDefault();

        const negociacao = new Negociacao(
            new Date(this._inputData.value.replace(/-/g, ',')),
            parseInt(this._inputQuantidade.value),
            parseFloat(this._inputValor.value)
        );

        this._negociacoes.adiciona(negociacao);

        this._mensagemView.update('Negociação adicionada com sucesso!');
        this._negociacoesView.update(this._negociacoes);
    }

}