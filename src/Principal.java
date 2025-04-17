import br.com.alura.screemmer.modelos.Filme;
import br.com.alura.screemmer.modelos.Serie;

public class Principal {
    public static void main(String[] args) {

        // Tipo de referência
        Filme meuFilme = new Filme();
        meuFilme.setNome("O Poderoso Chefão");
        meuFilme.setAnoDeLancamento(1978);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("Total de avaliações: " + meuFilme.getTotalDeAvaliacao());
        //System.out.println(meuFilme.obterMedia());

        Serie lost = new Serie();
        lost.setEpisodiosPorTemporada(10);
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração para maratonar a série Lost: " + lost.getDuracaoEmMinutos());

    }
}