package br.com.alura.screemmer.calculos;
import br.com.alura.screemmer.modelos.Titulo;

public class CalculadoraDeTempo {
    private int tempoTotal = 0;

    public int getTempoTotal() {
        return tempoTotal;
    }

//    public void inclui(Filme f){
//        tempoTotal += f.getDuracaoEmMinutos();
//    }
//
//    public void inclui(Serie s){
//        tempoTotal += f.getDuracaoEmMinutos();
//    }

    public void inclui(Titulo titulo){
        this.tempoTotal += titulo.getDuracaoEmMinutos();
    }
}
