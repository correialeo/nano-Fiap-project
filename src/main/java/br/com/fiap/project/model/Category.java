package br.com.fiap.project.model;

import br.com.fiap.project.view.CategoryView;

import java.util.Objects;

public class Category {

    public br.com.fiap.project.view.CategoryView CategoryView;
    private Long id;
    private String nome;

    public Category(){

    }

    public Category(String nome) {
        this.nome = nome;
    }

    public Category(Long id, String nome) {
        this.setId(id);
        this.setNome(nome);
    }

    public Long getId() {
        return id;
    }

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Category setNome(String nome) {
        this.nome = nome;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category categoria = (Category) o;
        return Objects.equals(nome, categoria.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return nome.toUpperCase();
    }
}
