package infra.file;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArquivoTest {

    private Path path_diretorio_final_arquivos;

    @TempDir
    Path diretorioTemporario;
    private Path pathBase;

    @BeforeEach
    @AfterEach
    public void setUp() throws IOException {

        pathBase = Paths.get("/tmp");
//        pathBase = diretorioTemporario;

        path_diretorio_final_arquivos = pathBase.resolve(Paths.get(Arquivo.BASE_DIRETORIO_ARQUIVOS));
        if (Files.exists(path_diretorio_final_arquivos)) {
            Files.walk(path_diretorio_final_arquivos).sorted(Comparator.reverseOrder()).map(Path::toFile).forEach(File::delete);
            Files.deleteIfExists(path_diretorio_final_arquivos);
        }
    }

    @RepeatedTest(10)
    public void deve_salvar_arquivos_em_diretorios_diferentes_a_partir_do_id() throws IOException {


        conferir_se_arquivos_foram_criados(1);
        conferir_se_arquivos_foram_criados(2);
        conferir_se_arquivos_foram_criados(5);
        assertEquals(1, Files.list(path_diretorio_final_arquivos).count());

        conferir_se_arquivos_foram_criados(7);
        assertEquals(2, Files.list(path_diretorio_final_arquivos).count());

        conferir_se_arquivos_foram_criados(12);
        assertEquals(3, Files.list(path_diretorio_final_arquivos).count());


    }

    private void conferir_se_arquivos_foram_criados(int id) {
        Arquivo arquivo;
        arquivo = new Arquivo(id, "conta", "minha conta".getBytes(), pathBase).salvar();
        assertEquals("conta" + id, arquivo.getNome());
        assertTrue(arquivo.getCaminhoArquivo().getArquivo().toFile().exists());
        assertEquals("conta" + id, arquivo.getCaminhoArquivo().getArquivo().toFile().getName());
    }

}