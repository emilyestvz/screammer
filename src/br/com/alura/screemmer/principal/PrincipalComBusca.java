package br.com.alura.screemmer.principal;

import br.com.alura.screemmer.modelos.Busca;
import java.io.IOException;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Busca busca = new Busca();
        busca.executar();
    }
}