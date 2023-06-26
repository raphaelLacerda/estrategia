//buscar dados no servidor?
//AJAX!
// JavaScript
// XmlHttpRequest

var xhr = new XMLHttpRequest();

xhr.onreadystatechange = function(){

    console.log('Estado atual: ' +xhr.readyState);
}

xhr.onprogress = function(){
    console.log('carregando');
}

xhr.onload = function(){

    console.log('resposta chegou ');
    console.log(JSON.parse(xhr.responseText));
}

console.log('abrindo conexao servidor');

xhr.open('GET', 'https://my-json-server.typicode.com/raphaellacerda/estrategia/alunos', false);

console.log('terminei de abrir conexao com servidor');

console.log('enviando requisicao');
xhr.send(null);
console.log('terminei de enviar requisicao');