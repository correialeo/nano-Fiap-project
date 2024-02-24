package br.com.fiap.project.repository;

import br.com.fiap.project.model.Category;
import br.com.fiap.project.model.Product;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class CategoryCollectionRepository {
    private static List<Category> categories;

    static {
        categories = new Vector<>();

        Category electronics = new Category(1L, "Electronics");
        Category smartphones = new Category(2L, "Smartphones");
        Category books = new Category(3L, "Books");

        categories.add(electronics);
        categories.add(smartphones);
        categories.add(books);
    }

    public static List<Category> findAll(){
        return categories;
    }

    public static Category findById(Long id){
        return categories.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static List<Category> findByName(String name){
        return categories.stream()
                .filter(x -> x.getNome().equalsIgnoreCase(name))
                .toList();
    }

    public static Category save(Category category){
        if (!categories.contains(category)){
            category.setId((long) categories.size() + 1);
            categories.add(category);
            return category;
        } else {
            JOptionPane.showMessageDialog(null, "Category already exist!");
            return null;
        }
    }

}
