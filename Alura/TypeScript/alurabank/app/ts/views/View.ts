// Uma classe abstrata não pode ser instanciada.
// Não faz sentido instanciar esta classe, já que apenas as filhas definem o método template.
abstract class View<T> {

    private _elemento: Element;

    constructor(seletor: string) {
        this._elemento = document.querySelector(seletor);
    }

    update(model: T): void {
        this._elemento.innerHTML = this.template(model);
    }

    // Um método abstrato avisa ao programador que ele deve ser implementado (em tempo de compilação).
    abstract template(model: T): string;

}