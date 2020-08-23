import { Component, Input } from '@angular/core';

@Component({// Caracteriza um componente no Angular
    selector: 'ap-photo',
    templateUrl: 'photo.component.html'
})
export class PhotoComponent {

    // Permite que o componente receba valores externos quando usado na forma declarativa
    // no template de outros componentes.
    @Input()// Inbound property
    url = '';
    
    @Input()// Propriedade de entrada
    description = '';
  
}