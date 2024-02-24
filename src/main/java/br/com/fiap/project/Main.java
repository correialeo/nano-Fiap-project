package br.com.fiap.project;

import br.com.fiap.project.model.Categoria;
import br.com.fiap.project.model.Product;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        Categoria categoria = new Categoria(1L, "Eletrônicos");

        Product product = new Product();
        product.setId(1L).setNome("Kindle").setDecricao("e-reader")
                .setCategoria(categoria)
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(800);

        System.out.println("Categoria: " + categoria);
        System.out.println("Produto: "+ product);
    }
}