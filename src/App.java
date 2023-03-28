import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {

        // fazer uma conexao HTTP e buscar os top 250 filmes
        String url = "https://imdb-api.com/en/API/Top250Movies/k_g4cqb3vn";
        // String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";(url da
        // nasa fora do ar);
        // URI endereco = URI.create(url);
        // var client = HttpClient.newHttpClient();
        // var request = HttpRequest.newBuilder(endereco).GET().build();
        // HttpResponse<String> response = client.send(request,
        // BodyHandlers.ofString());
        // String body = response.body();
        // System.out.println(body);
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        // extrair(parciar os dados) só os dados que interessam(titulo, posterfilme,
        // classificacao) - extrator conteudo

        // var parser = new JsonParser();
        // List<Map<String, String>> listaDeConteudos = parser.parse(json);

        // exibir e manipular os dados.

        ExtratorDeConteudoIMDB extrator = new ExtratorDeConteudoIMDB();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);

        var geradora = new GeradoraDeFigurinhas();

        // for (Map<String, String> filme : listaDeFilmes) {
        for (int i = 0; i < 12; i++) {
            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeArquivo = "saida/" + conteudo.getTitulo() + ".png";

            geradora.cria(inputStream, nomeArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }

    }
}
