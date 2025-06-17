package br.com.alura.screemmer.principal;

import br.com.alura.screemmer.calculos.CalculadoraDeTempo;
import br.com.alura.screemmer.calculos.FiltroRecomendacao;
import br.com.alura.screemmer.modelos.Episodio;
import br.com.alura.screemmer.modelos.Filme;
import br.com.alura.screemmer.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {

        // Tipo de referência
        Filme meuFilme = new Filme("As Branquelas", 1978);
//        meuFilme.setAnoDeLancamento(1978);
//        meuFilme.setDuracaoEmMinutos(180);
//
//        meuFilme.exibeFichaTecnica();
//        meuFilme.avalia(8);
//        meuFilme.avalia(5);
//        meuFilme.avalia(10);
//
//        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacao());
        //System.out.println(meuFilme.obterMedia());

        Serie lost = new Serie("Lost", 2000);
//        lost.setEpisodiosPorTemporada(10);
//        lost.setTemporadas(10);
//        lost.setEpisodiosPorTemporada(10);
//        lost.setMinutosPorEpisodio(50);
//        System.out.println("Duração para maratonar a série Lost: " + lost.getDuracaoEmMinutos());

        Filme outroFilme = new Filme("outrofilme", 2024);
        outroFilme.setAnoDeLancamento(2002);
        outroFilme.setDuracaoEmMinutos(140);

        CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        System.out.println(calculadora.getTempoTotal());

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);


        Filme filmeDaEmy = new Filme("Fififi", 2025);
        filmeDaEmy.setDuracaoEmMinutos(200);
        //filmeDaEmy.setNome("Fififi");
        filmeDaEmy.avalia(10);

        ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDaEmy);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);
        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println(listaDeFilmes);
        System.out.println(listaDeFilmes.get(0).toString());

    }
}