package infra.file;

import java.nio.file.Path;

public class CaminhoArquivo {

    
    private Path diretorio;
    
    private Path arquivo;
    
    

    public CaminhoArquivo(Path diretorio, Path arquivo) {
        super();
        this.diretorio = diretorio;
        this.arquivo = arquivo;
    }

    public Path getDiretorio() {
        return diretorio;
    }

    public Path getArquivo() {
        return arquivo;
    }
    
    
    
}
