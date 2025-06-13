package br.com.alura.screemmer.principal;

import br.com.alura.screemmer.modelos.Titulo;
import br.com.alura.screemmer.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite o nome do filme ou série que deseja buscar: ");
        var busca = leitura.nextLine();

        String endereco = "https://www.omdbapi.com/?t=" + busca + "&apikey=6585022c";

        try {
            // Exemplo de uso do HttpClient para fazer uma requisição HTTP
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco)) // Buscando a informação da API
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Exibindo o corpo da resposta
            String json = response.body();
            System.out.println(json);

            // Convertendo o JSON para um objeto TituloOmdb
            // Gson gson = new Gson(); // Usando o Gson padrão
            // Para usar o Gson com nomes de campos em CamelCase
            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .create();

            TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
            System.out.println(meuTituloOmdb);

            //try {
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);

        } catch (NumberFormatException e) {
            System.out.println("Erro ao buscar: " + e.getMessage());
            return;
        } catch (IllegalArgumentException e){
            System.out.println("Erro de argumento na busca: " + e.getMessage());

        }


    }
}
