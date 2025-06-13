package br.com.alura.screemmer.modelos;
import br.com.alura.screemmer.calculos.Classificavel;

// Herança da super classe Titulo e implementando a interface Classificavél
public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome, int anoDeLancamento) {
        super(nome, anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) (obterMedia() / 2);
    }

    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " - " + this.getAnoDeLancamento();
    }
}
