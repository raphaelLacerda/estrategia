<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Plataforma Estratégia Concursos</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- <link href="css/style.css" rel="stylesheet"> -->
    <!-- <link href="css/estilo.css" rel="stylesheet">  -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
        integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous">
    </script>

    <!-- <script src="js/index-jquery.js"></script> -->

</head>

<body>
    <header class="mx-auto" style="width: 200px;">
        <div class="card text-center" style="width: 18rem;">
            <img src="img/coruja.png" alt="Coruja social do estratégia">
            <figcaption>Sistema de Cadastro de aluno</figcaption>
            <div class="card-body">
                <h5 class="card-title">Estratética concursos</h5>
                <p class="card-text">Quer passar em concurso? Conheça nossa equipe</p>
                <button id="btnAprovado" class="btn btn-warning">Quero ser aprovado!</button>
            </div>
        </div>
    </header>
    <main class="container-fluid">
        <div class="card mt-5">
            <div class="card-body">
                <label for="formCadastro">Cadastro</label>
                <form id="formCadastro" action="cadastro/alunos" method="POST">
                    <div class="row">
                        <div class="form-group col-sm">
                            <label for="nome">Nome:</label>
                            <input class="form-control" type="text" id="nome" name="nome" required autofocus>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm">
                            <label for="email">Email:</label>
                            <input class="form-control" type="email" id="email" name="email">
                        </div>
                        <div class="form-group col-sm">
                            <label for="dataNascimento">DataNascimento</label>
                            <input class="form-control" type="date" id="dataNascimento" name="dataNascimento">
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-4">
                            <label for="cidade">Estado</label>
                            <select class="form-control" id="estado" name="estado">
                                <option>Acre</option>
                                <option>DF</option>
                                <option>Minas</option>
                                <option>São Paulo</option>
                                <option>Rio de Janeiro</option>
                            </select>
                        </div>
                        <div class="form-group col-sm-4">
                            <label for="email">Cartão</label>
                            <input class="form-control" type="number" id="numero" name="numero">
                        </div>
                        <div class="form-group col-sm-4">
                            <label for="dataNascimento">Vencimento</label>
                            <input class="form-control" type="month" id="vencimento" name="vencimento">
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="">Cursos Escolhidos</label>
                        <div class="form-check  col-sm">
                            <input class="form-check-input" type="checkbox" name="cursos" value="informatica ">
                            <label class="form-check-label" for="exampleCheck1">Informática</label>
                        </div>
                        <div class="form-check  col-sm">
                            <input class="form-check-input" type="checkbox" name="cursos"
                                value="direito-administrativo ">
                            <label class="form-check-label" for="exampleCheck1">Direito Administrativo</label>
                        </div>
                        <div class="form-check  col-sm">
                            <input class="form-check-input" type="checkbox" name="cursos"
                                value="direito-constitucional ">
                            <label class="form-check-label" for="exampleCheck1">Direito Constitucional</label>
                        </div>
                    </div>


                    <div class="form-group">
                        <label for="">Receber news letter?</label>
                        <div class="form-check form-check-inline ml-2">
                            <input class="form-check-input" type="radio" value="sim" name="news" checked>
                            <label class="form-check-label" for="">Sim</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" value="nao" name="news">
                            <label class="form-check-label" for="">Não</label>
                        </div>
                    </div>
                    <div class="form-group col-sm">
                        <input class="form-control btn btn-primary" type="submit" value="Salvar">
                    </div>
                </form>
            </div>
        </div>

    </main>
    <!-- Footer -->
    <footer class="page-footer font-small blue pt-4">

        <!-- Footer Links -->
        <div class="container-fluid text-center text-md-left">

            <!-- Grid row -->
            <div class="row">

                <!-- Grid column -->
                <div class="col-md-6 mt-md-0 mt-3">

                    <!-- Content -->
                    <h5 class="text-uppercase">Estratégia concursos</h5>
                    <p>Faça sua assinatura ilimitada</p>

                </div>
                <!-- Grid column -->

                <hr class="clearfix w-100 d-md-none pb-3">

                <!-- Grid column -->
                <div class="col-md-3 mb-md-0 mb-3">

                    <!-- Links -->
                    <h5 class="text-uppercase">Assinatura</h5>

                    <ul class="list-unstyled">
                        <li>
                            <a href="https://www.estrategiaconcursos.com.br/assinaturas/">Assine aqui</a>
                        </li>
                    </ul>

                </div>
                <!-- Grid column -->

                <!-- Grid column -->
                <div class="col-md-3 mb-md-0 mb-3">

                    <!-- Links -->
                    <h5 class="text-uppercase">Blog</h5>

                    <ul class="list-unstyled">
                        <li>
                            <a href="https://www.estrategiaconcursos.com.br/blog/">Últimos posts</a>
                        </li>
                    </ul>

                </div>
                <!-- Grid column -->

            </div>
            <!-- Grid row -->

        </div>
        <!-- Footer Links -->

        <!-- Copyright -->
        <div class="footer-copyright text-center py-3">© 2019 Copyright:
            <a href="https://github.com/raphaellacerda">Raphael Lacerda</a>
        </div>
        <!-- Copyright -->

    </footer>
    <!-- Footer -->

    <div id="modalGenericaPorIframe" class="modal-fullscreen modal fade" tabindex="-1" role="dialog">
        <div class="modal-dialog modal-xl">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="embed-responsive embed-responsive-16by9">
                        <iframe id="iframeGenerico" src="" allowfullscreen></iframe>
                    </div>
                </div>
            </div>
        </div>
    </div>

</body>


</html>