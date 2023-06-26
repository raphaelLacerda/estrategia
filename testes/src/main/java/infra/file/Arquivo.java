package infra.file;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Arquivo {
    private static final int QUANTIDADE_MAXIMA_ARQUIVOS_NO_DIRETORIO = 5;
    public static final String BASE_DIRETORIO_ARQUIVOS = "arquivos/contas";

    private final Path basePath;
    private Integer id;
    private String nome;
    private byte[] dados;
    private CaminhoArquivo caminhoArquivo;

    public Arquivo(Integer id, String nome, byte[] dados, Path base) {
        this.id = id;
        this.nome = nome + id;
        this.dados = dados;
        basePath = base;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public byte[] getDados() {
        return dados;
    }

    public CaminhoArquivo getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public Arquivo salvar() {

        this.caminhoArquivo = montarCaminhoDoArquivo();

        try {
            Files.createDirectories(caminhoArquivo.getDiretorio());
            java.nio.file.Files.copy(new ByteArrayInputStream(dados), caminhoArquivo.getArquivo(),
                    StandardCopyOption.REPLACE_EXISTING);
            return this;
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    private CaminhoArquivo montarCaminhoDoArquivo() {

        //        if (id == null) {
        //            throw new IllegalStateException("caminho para arquivo não pode ser montado pois ele é nulo");
        //        }
        //        String diretorio = null;
        //        if (id <= QUANTIDADE_MAXIMA_ARQUIVOS_NO_DIRETORIO) {
        //            diretorio = BASE + "/1";
        //        } else {
        //            int i = 2;
        //            boolean achouDiretorio = false;
        //            while (!achouDiretorio) {
        //
        //                if (id <= (i * QUANTIDADE_MAXIMA_ARQUIVOS_NO_DIRETORIO)) {
        //                    diretorio = BASE + "/"+i;
        //                    achouDiretorio = true;
        //                }
        //                i++;
        //            }
        //        }


        String diretorioAsString = BASE_DIRETORIO_ARQUIVOS + "/" +
                new BigDecimal(id).divide(new BigDecimal(QUANTIDADE_MAXIMA_ARQUIVOS_NO_DIRETORIO), RoundingMode.CEILING)
                        .toBigInteger();

        Path diretorioAsPath = basePath.resolve(diretorioAsString);
        Path arquivo = diretorioAsPath.resolve(nome);

        return new CaminhoArquivo(diretorioAsPath, arquivo);
    }

}
