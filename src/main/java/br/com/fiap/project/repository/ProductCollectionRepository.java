package br.com.fiap.project.repository;

import br.com.fiap.project.model.Category;
import br.com.fiap.project.model.Product;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class ProductCollectionRepository {
    private static List<Product> products;

    static {

        products = new Vector<>();
        Product smartphones = new Product();
        smartphones.setNome("iPhone 14 PRO MAX")
                .setDecricao("Smartphone of ultimate generation by Apple")
                .setCategoria(CategoryCollectionRepository.findById(2L))
                .setDataDeCadastro(LocalDateTime.now())
                .setPreco(12000);

        save(smartphones);
    }

    public static Product save(Product product) {
        if (!products.contains(product)){
            product.setId((long)products.size() + 1);
            products.add(product);
            return product;
        } else {
            JOptionPane.showMessageDialog(null, "Product already exist!");
            return null;
        }
    }

    public static List<Product> findAll(){
        return products;
    }

    public static Product findById(Long id){
        return products.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Product> findByCategoria(Category category){
        return products.stream()
                .filter(x -> x.getCategoria().equals(category))
                .toList();
    }

}
