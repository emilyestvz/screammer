package br.com.alura.screemmer.excecao;

public class ErroDeConversaoException extends RuntimeException {

    private String mensagem;

    public ErroDeConversaoException(String s) {
        this.mensagem = mensagem;

    }

    @Override
    public String getMessage() {
        return mensagem;
    }
}
