import { NgModule } from '@angular/core';
import { PhotoComponent } from './photo/photo.component';

@NgModule({
    declarations: [ PhotoComponent ],// Privado, ou seja, os componentes declarados vão se enxergar dentro do módulo.
    exports: [ PhotoComponent ]// Público, ou seja, apenas os componentes exportos poderão ser vistos fora do módulo.
})
export class PhotosModule {

}