package biblioteca;

import org.biblioteca.biblioteca.Biblioteca;
import org.biblioteca.livro.Livro;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BibliotecaTest {

    List<Livro> listaDeLivros;

    private Biblioteca biblioteca;

    @BeforeEach
    void setup() {
        this.listaDeLivros = StubBiblioteca.gerarArrayDeLivros();
        biblioteca = new Biblioteca(listaDeLivros);
    }

    @Test
    @DisplayName("Cadastrar livro")
    void deveCadastrar() {
        Livro livros = new Livro(5L, "O Senhor dos Anéis", "J.R.R. Tolkien", "1954");
        boolean resposta = this.biblioteca.addLivro(livros);

        assertTrue(resposta);
    }

    @Test
    @DisplayName("Não deve cadastrar livro")
    void deveFalharAoCadastrar() {
        Livro livros = new Livro(1L, "O Senhor dos Anéis", "J.R.R. Tolkien", "1954");
        boolean resposta = this.biblioteca.addLivro(livros);

        assertFalse(resposta);
    }

    @Test
    @DisplayName("Deve encontrar livro por título")
    void deveRetornarListaDeLivrosPorTituloComSucesso() {
        String titulo = this.listaDeLivros.get(0).getTitulo();

        List<Livro> resposta = this.biblioteca.listarLivrosPorTitulo(titulo);

        assertEquals(1, resposta.size());

        assertEquals(titulo, resposta.get(0).getTitulo());
    }

    @Test
    @DisplayName("Deve retornar uma lista de livros vazia ao buscar livros por título")
    void deveRetornarListaVaziaPorTitulo() {
        String titulo = "titulo inexistente";

        List<Livro> resposta = this.biblioteca.listarLivrosPorTitulo(titulo);

        assertEquals(0, resposta.size());
    }

    @Test
    @DisplayName("Deve encontrar livro por autor")
    void deveRetornarListaDeLivrosPorAutorComSucesso() {
        String autor = this.listaDeLivros.get(0).getAutor();

        List<Livro> resposta = this.biblioteca.listarLivrosPorAutor(autor);

        assertEquals(2, resposta.size());

        assertEquals(autor, resposta.get(0).getAutor());

        assertEquals(autor, resposta.get(1).getAutor());
    }

    @Test
    @DisplayName("Deve retornar uma lista de livros vazia ao buscar livros por autor")
    void deveRetornarListaVaziaPorAutor() {
        String autor = "autor inexistente";

        List<Livro> resposta = this.biblioteca.listarLivrosPorAutor(autor);

        assertEquals(0, resposta.size());
    }

    @Test
    @DisplayName("Deve encontrar livro por ano de publicação")
    void deveRetornarListaDeLivrosPorAnoDePublicacaoComSucesso() {

        String anoDePublicacao = this.listaDeLivros.get(0).getAnoDePublicacao();

        List<Livro> resposta = this.biblioteca.listarLivrosPorAnoDePublicacao(anoDePublicacao);

        assertEquals(1, resposta.size());

        for (Livro livro : resposta) {
            assertEquals(anoDePublicacao, livro.getAnoDePublicacao());
        }
    }

    @Test
    @DisplayName("Deve retornar uma lista de livros vazia ao buscar livros por ano de publicação")
    void deveRetornarListaVaziaPorAnoDePublicacao() {
        String anoDePublicacao = "500 a.c";

        List<Livro> resposta = this.biblioteca.listarLivrosPorAnoDePublicacao(anoDePublicacao);

        assertEquals(0, resposta.size());
    }

    @Test
    @DisplayName("Deve remover livro por id")
    void deveRemoverLivro() {
        Long id = 1L;

        boolean resposta = this.biblioteca.removerLivro(id);

        assertTrue(resposta);
    }

    @Test
    @DisplayName("Não deve remover livro por id")
    void naoDeveRemoverLivro() {
        Long id = 7L;

        boolean resposta = this.biblioteca.removerLivro(id);

        assertFalse(resposta);
    }

}
