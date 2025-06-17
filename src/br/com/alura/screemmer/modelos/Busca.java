package br.com.alura.screemmer.modelos;

import br.com.alura.screemmer.excecao.ErroDeConversaoException;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

public class Busca {
        private Scanner leitura = new Scanner(System.in);
        private ArrayList<Object> titulos = new ArrayList<>();

        public void executar() {
            String busca = "";

            while (!busca.equalsIgnoreCase("sair")) {
                System.out.println("\n✨ Digite o nome do filme ou série que deseja buscar (ou digite 'sair'): ");
                busca = leitura.nextLine();

                if (busca.equalsIgnoreCase("sair")) {
                    System.out.println(titulos);
                    System.out.println("✨ Saindo do programa...");
                    break;
                }

                String endereco = "https://www.omdbapi.com/?t=" + busca.replace(" ", "+") + "&apikey=6585022c";

                try {
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(endereco))
                            .build();

                    HttpResponse<String> response = client
                            .send(request, HttpResponse.BodyHandlers.ofString());

                    String json = response.body();
                    System.out.println(json);

                    Gson gson = new GsonBuilder()
                            .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                            .create();

                    TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
                    System.out.println(meuTituloOmdb);

                    Titulo meuTitulo = new Titulo(meuTituloOmdb);
                    System.out.println(meuTitulo);

                    titulos.add(meuTitulo);

                } catch (NumberFormatException e) {
                    System.out.println("Erro ao buscar: " + e.getMessage());
                } catch (IllegalArgumentException e) {
                    System.out.println("Erro de argumento na busca: " + e.getMessage());
                } catch (ErroDeConversaoException e) {
                    System.out.println(e.getMessage());
                } catch (IOException | InterruptedException e) {
                    System.out.println("Erro de comunicação com a API: " + e.getMessage());
                }
            }
        }
}
