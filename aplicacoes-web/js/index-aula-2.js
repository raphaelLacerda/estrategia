


async function buscar(){
    let alunos = await $.get('https://my-json-server.typicode.com/raphaellacerda/estrategia/alunos');
    console.log(alunos);
    for (let index = 0; index < alunos.length; index++) {
        const aluno = alunos[index];
        escreverAlunoNaTabela(aluno);
    }
}
buscar();


$('#formCadastro').submit(function(event){

    event.preventDefault();

    let dados = $(this).serializeArray();

    let aluno = transformarDadosParaAluno(dados);
    

    $.post('https://my-json-server.typicode.com/raphaellacerda/estrategia/alunos', aluno, function(alunoCadastrado){

        console.log(alunoCadastrado);
        escreverAlunoNaTabela(alunoCadastrado);
    })
})



function transformarDadosParaAluno(dados) {
    let aluno = {};
    aluno.id;
    aluno.cursos = [];
    dados.forEach(d => {transformarDadosParaAluno
        if (d['name'] === 'cursos') {
            aluno[d['name']].push(d['value']);
        } else {
            aluno[d['name']] = d['value'];
        }
    });
    return aluno;
}


function escreverAlunoNaTabela(aluno){
    let $linha = $('<tr>').attr('id', 'aluno'+aluno.id);
    $linha.append($('<td>').html(aluno.id));
    $linha.append($('<td>').html(aluno.nome));
    $linha.append($('<td>').html(aluno.dataNascimento));
    $linha.append($('<td>').html(aluno.estado));
    $linha.append($('<td>').html(aluno.cursos));

    $('#listaAlunos tbody').append($linha);
}