
public class Conteudo {

    private final String titulo;

    private final String urlImagem;

    public Conteudo(String titulo, String urlImagem) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        // this sempre do objeto pegando o parametro.
    }

    public String getTitulo() {
        return titulo;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

}
