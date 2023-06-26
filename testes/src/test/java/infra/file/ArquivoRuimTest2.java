package infra.file;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ArquivoRuimTest2 {

    @TempDir
    Path basePath;
    Path path_diretorio_final_arquivos;


    @BeforeEach
    @AfterEach
    public void setUp() throws IOException {


        path_diretorio_final_arquivos = basePath.resolve(Paths.get(Arquivo.BASE_DIRETORIO_ARQUIVOS));
        if (Files.exists(path_diretorio_final_arquivos)) {
            Files.walk(path_diretorio_final_arquivos).sorted(Comparator.reverseOrder()).map(Path::toFile)
                    .forEach(File::delete);
            Files.deleteIfExists(path_diretorio_final_arquivos);
        }
    }


    @Test
    public void deve_salvar_arquivos_em_diretorios_segmentados_tendo_como_base_o_id() throws IOException {
        ArquivoRUIM arquivoRUIM1 = new ArquivoRUIM(1, "conta", "texto do meu arquivo".getBytes(), basePath);

        arquivoRUIM1.salvar();

        assertEquals("conta1", arquivoRUIM1.getNome());
        assertTrue(arquivoRUIM1.getCaminhoArquivo().getDiretorio().toFile().exists());
        assertEquals("1",arquivoRUIM1.getCaminhoArquivo().getDiretorio().toFile().getName());
        assertTrue(arquivoRUIM1.getCaminhoArquivo().getArquivo().toFile().exists());
        assertEquals("conta1", arquivoRUIM1.getCaminhoArquivo().getArquivo().toFile().getName());

        assertEquals(1, Files.list(path_diretorio_final_arquivos).count());

        ArquivoRUIM arquivoRUIM2 = new ArquivoRUIM(7, "conta", "texto do meu arquivo".getBytes(), basePath);

        arquivoRUIM2.salvar();
        assertEquals(2, Files.list(path_diretorio_final_arquivos).count());
        assertEquals("2",arquivoRUIM2.getCaminhoArquivo().getDiretorio().toFile().getName());


        ArquivoRUIM arquivoRUIM3 = new ArquivoRUIM(12, "conta", "texto do meu arquivo".getBytes(), basePath);

        arquivoRUIM3.salvar();
        assertEquals(3, Files.list(path_diretorio_final_arquivos).count());
        assertEquals("3",arquivoRUIM3.getCaminhoArquivo().getDiretorio().toFile().getName());

    }


}