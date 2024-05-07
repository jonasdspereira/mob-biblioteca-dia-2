package org.biblioteca.biblioteca;

import org.biblioteca.livro.Livro;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public Biblioteca(List<Livro> livros) {
        this.livros = livros;
    }

    public Biblioteca () {
    }

    public boolean addLivro(Livro livro) {
        if (livros.contains(livro)) {
            return false;
        }
        livros.add(livro);
        return true;
    }

    public List<Livro> listarLivrosPorTitulo(String titulo) {
        List<Livro> achouLivro = new ArrayList<>();
        for (Livro livro: livros) {
            if(livro.getTitulo().equals(titulo)) {
                achouLivro.add(livro);
            }
        }
        return achouLivro;
    }

    public List<Livro> listarLivrosPorAutor(String autor) {
        List<Livro> achouLivro = new ArrayList<>();
        for (Livro livro: livros) {
            if(livro.getAutor().equals(autor)) {
                achouLivro.add(livro);
            }
        }
        return achouLivro;
    }

    public List<Livro> listarLivrosPorAnoDePublicacao(String anoDePublicacao) {
        List<Livro> achouLivro = new ArrayList<>();
        for (Livro livro: livros) {
            if(livro.getAnoDePublicacao().equals(anoDePublicacao)) {
                achouLivro.add(livro);
            }
        }
        return achouLivro;
    }

    public boolean removerLivro(Long id) {
        for (Livro livro : livros) {
            if (livro.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}
