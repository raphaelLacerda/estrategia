package infra.broker;

import java.util.Objects;

public class Mensagem {
    private String conteudo;
    private String destinatario;


    public Mensagem(String conteudo, String destinatario) {
        this.conteudo = conteudo;
        this.destinatario = destinatario;
    }

    public String getConteudo() {
        return conteudo;
    }

    public String getDestinatario() {
        return destinatario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mensagem mensagem = (Mensagem) o;
        return Objects.equals(conteudo, mensagem.conteudo) && Objects.equals(destinatario, mensagem.destinatario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(conteudo, destinatario);
    }
}
