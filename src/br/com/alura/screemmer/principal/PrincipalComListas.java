package br.com.alura.screemmer.principal;
import br.com.alura.screemmer.modelos.Filme;
import br.com.alura.screemmer.modelos.Serie;
import br.com.alura.screemmer.modelos.Titulo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {
        public static void main(String[] args) {
        Filme meuFilme = new Filme("As Branquelas", 1978);
        meuFilme.avalia(9);
        Filme outroFilme = new Filme("outrofilme", 2024);
        outroFilme.avalia(5);
        Filme filmeDaEmy = new Filme("Fififi", 2025);
        filmeDaEmy.avalia(8);
        Serie lost = new Serie("Lost", 2000);
        lost.avalia(8);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDaEmy);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item: lista){
            System.out.println(item.getNome());
                if (item instanceof Filme filme && filme.getClassificacao() > 2){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Sandler");
        buscaPorArtista.add("Demi Lovato");
        buscaPorArtista.add("Miley Cyrus");

        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);

        Collections.sort(lista);
        System.out.println("Lista ordenada: " + lista);

        // Ordenando por Titutlo e Ano
        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("Ordenando por ano: " + lista);


    }
}
