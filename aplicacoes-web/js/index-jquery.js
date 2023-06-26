$(() => {
	//como saber que o formulário foi submetido?
	// motivação Jquery
	$('#formCadastro').submit(e => {
		e.preventDefault();

		let dados = $('#formCadastro').serializeArray();

		// console.log(dados);

		let aluno = transformarDadosParaAluno(dados);

		salvarAluno(aluno);
		$('#formCadastro')[0].reset();
	});

	$('#modalGenericaPorIframe').on('shown.bs.modal', function() {
		$('#iframeGenerico').attr('src', 'https://www.estrategiaconcursos.com.br/assinaturas/');
	});
	$('#modalGenericaPorIframe').on('hidden.bs.modal', function() {
		$('#iframeGenerico').attr('src', null);
	});

	$('#btnAprovado').click(e => {
		e.preventDefault();
		$('#modalGenericaPorIframe').modal('show');
	});

	carregarAlunosComAjax();
	// carregarAlunos();

	function carregarAlunosComAjax() {
		let xhr = new XMLHttpRequest();

		xhr.onreadystatechange = function() {
			console.log('mudando status' + xhr.readyState);
		};
		console.log('UNSENT', xhr.readyState); // readyState will be 0

		//async true
		xhr.open('GET', 'https://my-json-server.typicode.com/raphaellacerda/estrategia/alunos', true);
		console.log('OPENED', xhr.readyState); // readyState will be 1

		xhr.onprogress = function() {
			console.log('LOADING', xhr.readyState); // readyState will be 3
		};

		xhr.onload = function() {
			console.log('DONE - recebi resposta', xhr.readyState); // readyState will be 4
			// console.log(xhr.responseText);
			let alunos = JSON.parse(xhr.responseText);
			alunos.forEach(a => escreverAlunoNaTabela(a));
		};

		//string for post requests
		xhr.send(null);

		console.log('terminei de enviar');
	}

	async function carregarAlunos() {
		// $.get('https://my-json-server.typicode.com/raphaellacerda/estrategia/alunos').done(alunos => {
		// 	console.log(alunos);
		// 	alunos.forEach(a => escreverAlunoNaTabela(a));
		// });

		let alunos = await $.get('https://my-json-server.typicode.com/raphaellacerda/estrategia/alunos');
		alunos.forEach(a => escreverAlunoNaTabela(a));

	}

	function transformarDadosParaAluno(dados) {
		let aluno = {};
		aluno.id;
		aluno.cursos = [];
		dados.forEach(d => {transformarDadosParaAluno
			if (d['name'] === 'cursos') {
				aluno[d['name']].push({nome: d['value']});
			} else {
				aluno[d['name']] = d['value'];
			}
		});
		return aluno;
	}

	function salvarAluno(aluno) {
		console.log('salvando aluno ' + JSON.stringify(aluno));

		//salvando aluno com JQUERY
		$.post('http://localhost:8080/java-web/alunos', JSON.stringify(aluno)).done(
			alunoSalvo => {
				aluno.id = alunoSalvo.id;
				escreverAlunoNaTabela(aluno);
			}
		);
	}

	function escreverAlunoNaTabela(aluno) {
		let $linha = $('<tr>');

		$linha.append($('<td>').html(aluno.id));
		$linha.append($('<td>').html(aluno.nome));
		$linha.append($('<td>').html(aluno.dataNascimento));
		$linha.append($('<td>').html(aluno.estado));
		$linha.append($('<td>').html(aluno.cursos));
		$('#listaAlunos tbody').append($linha);
	}
});
