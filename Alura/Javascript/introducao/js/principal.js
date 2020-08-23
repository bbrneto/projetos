/*A variável document aponta para uma representação em memória do HTML (arquivo físico), também conhecida como DOM.*/
console.log(document);

var element = document.querySelector(".titulo");//Boa prática: utilizar seletores CSS.
console.log(element);//Objeto

var content = element.textContent;
console.log(content);//Valor

element.textContent = "Aparecida Nutricionista";
//Com Javascript, podemos manipular o DOM, ou seja, aquilo que o navegador renderizou. O arquivo HTML fica inalterado.



//Cálculo do IMC
var trPaciente = document.querySelector("#primeiro-paciente");
var tdPeso = trPaciente.querySelector(".info-peso");
var tdAltura = trPaciente.querySelector(".info-altura");
var tdImc = trPaciente.querySelector(".info-imc");

var peso = tdPeso.textContent;
var altura = tdAltura.textContent;

var pesoEhValido = true;

if (peso <= 0 || peso >= 1000) {
  pesoEhValido = false;

  tdImc.textContent = "Peso inválido";
}

var alturaEhValida = true;

if (altura <= 0 || altura >= 3.00) {
  alturaEhValida = false;

  tdImc.textContent = "Altura inválida";
}

if (pesoEhValido && alturaEhValida) {
  var imc = peso / (altura * altura);// Por padrão, a execução é da esquerda para a direita.
  console.log("IMC: " + imc);

  tdImc.textContent = imc;
}
