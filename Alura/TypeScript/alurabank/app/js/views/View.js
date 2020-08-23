// Uma classe abstrata não pode ser instanciada.
// Não faz sentido instanciar esta classe, já que apenas as filhas definem o método template.
class View {
    constructor(seletor) {
        this._elemento = document.querySelector(seletor);
    }
    update(model) {
        this._elemento.innerHTML = this.template(model);
    }
}
