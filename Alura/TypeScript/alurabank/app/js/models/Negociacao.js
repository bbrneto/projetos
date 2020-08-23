class Negociacao {
    /*
        ########## Declaração verbosa ##########
    
        private _data: Date;
    
        private _quantidade: number;
    
        private _valor: number;
    
        constructor(data: Date, quantidade: number, valor: number) {
            // "_" é uma convenção no mundo JavaScript.
            this._data = data;
            this._quantidade = quantidade;
            this._valor = valor;
            // "_" indica que o atributo não pode ser acessado fora da classe.
        }
    */
    constructor(_data, _quantidade, _valor) {
        this._data = _data;
        this._quantidade = _quantidade;
        this._valor = _valor;
    }
    /*
        Os tipos string e number são literais e guardam um valor primitivo.
        Contudo, se tentarmos chamar algum método em variáveis declaradas com esses tipos,
        eles são empacotados automaticamente (auto-boxing) para String e Number respectivamente.
        TypeScript permite distinguir entre o tipo literal e o tipo objeto.
        Contudo, a boa prática é usarmos os tipos literais number e string,
        porque em JavaScript new String() e new Number() são raramente usados.
    */
    get data() {
        return this._data;
    }
    get quantidade() {
        return this._quantidade;
    }
    get valor() {
        return this._valor;
    }
    get volume() {
        return this._quantidade * this._valor;
    }
}
