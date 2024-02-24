package br.com.fiap.project.model;
import java.time.LocalDateTime;
import java.util.Objects;

public class Product {

    private Long id;
    private String nome;
    private String decricao;
    private double preco;
    private LocalDateTime dataDeCadastro;
    private Category categoria;

    public Product() {
    }

    public Product(Long id, String nome, String decricao, double preco, LocalDateTime dataDeCadastro, Category categoria) {
        this.setId(id);
        this.setNome(nome);
        this.setDecricao(decricao);
        this.setPreco(preco);
        this.setDataDeCadastro(dataDeCadastro);
        this.setCategoria(categoria);
    }

    public Product(String nome, String decricao, double preco, LocalDateTime dataDeCadastro, Category categoria) {
        this.setNome(nome);
        this.setDecricao(decricao);
        this.setPreco(preco);
        this.setDataDeCadastro(dataDeCadastro);
        this.setCategoria(categoria);
    }

    public Long getId() {
        return id;
    }

    public Product setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Product setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDecricao() {
        return decricao;
    }

    public Product setDecricao(String decricao) {
        this.decricao = decricao;
        return this;
    }

    public double getPreco() {
        return preco;
    }

    public Product setPreco(double preco) {
        this.preco = preco;
        return this;
    }

    public LocalDateTime getDataDeCadastro() {
        return dataDeCadastro;
    }

    public Product setDataDeCadastro(LocalDateTime dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
        return this;
    }

    public Category getCategoria() {
        return categoria;
    }

    public Product setCategoria(Category categoria) {
        this.categoria = categoria;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(nome, product.nome);
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
