package estruturadados;

public class CampoDeBatalha {

    private String coluna;
    private int linha;

    public CampoDeBatalha(String coluna, int linha) {
        this.coluna = coluna;
        this.linha = linha;
    }

    public String getColuna() {
        return coluna;
    }

    public int getLinha() {
        return linha;
    }
}
