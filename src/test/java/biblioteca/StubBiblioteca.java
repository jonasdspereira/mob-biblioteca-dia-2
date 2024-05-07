package biblioteca;

import org.biblioteca.livro.Livro;

import java.util.ArrayList;
import java.util.List;

public class StubBiblioteca {
    public static List<Livro> gerarArrayDeLivros() {
        List<Livro> livros = new ArrayList<>();
        livros.add(new Livro(1L, "O Senhor dos Anéis", "J.R.R. Tolkien", "1954"));
        livros.add(new Livro(2L, "Harry Potter e a Pedra Filosofal", "J.K. Rowling", "1997"));
        livros.add(new Livro(3L, "1984", "George Orwell", "1949"));
        livros.add(new Livro(4L, "O Hobbit", "J.R.R. Tolkien", "1937"));
        return livros;
    }
}
