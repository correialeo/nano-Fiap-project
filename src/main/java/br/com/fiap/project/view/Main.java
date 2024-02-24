package br.com.fiap.project.view;

import br.com.fiap.project.model.Category;
import br.com.fiap.project.model.Product;
import br.com.fiap.project.repository.CategoryCollectionRepository;
import br.com.fiap.project.repository.ProductCollectionRepository;
import br.com.fiap.project.view.CategoryView;
import br.com.fiap.project.view.OptionView;
import br.com.fiap.project.view.Option;
import br.com.fiap.project.view.ProductView;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Option option = null;

        do {
            option = OptionView.select();

            switch (option){
                case REGISTER_CATEGORY -> registerCategory();

                case REGISTER_PRODUCT -> registerProduct();

                case MODIFY_PRODUCT -> modifyProduct();

                case VIEW_PRODUCT_BY_ID -> viewByID();

                case VIEW_PRODUCT_BY_CATEGORY -> viewByCategory();

                case END_SYSTEM -> finishSystem();

                default -> System.out.println("Not found");
                
            }
        } while (option != Option.END_SYSTEM);
    }

    private static void finishSystem() {
        System.exit(0);
    }

    private static void viewByCategory() {
        Category category = CategoryView.select(null);
        List<Product> products = ProductCollectionRepository.findByCategoria(category);
        if (products.isEmpty()){
            JOptionPane.showMessageDialog(null, "Not found");
        } else {
            products.forEach(ProductView::show);
            products.forEach(System.out::println);
        }
    }

    private static void viewByID() {
        Long id = 0L;
        do {
            try {
                id = Long.parseLong(JOptionPane.showInputDialog(null, "Enter ID product"));
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "ID not found");
            }
        }while (id <= 0);
        Product product = ProductCollectionRepository.findById(id);
        if (product != null){
            ProductView.show(product);
        }else  {
            JOptionPane.showMessageDialog(null, "Product not found");
        }
    }

    private static void modifyProduct() {
        ProductView productView = new ProductView();
        Product product = productView.select(null);
        productView.update(product);

    }

    private static void registerProduct() {
        ProductView view = new ProductView();
        Product product = view.form(new Product());
        ProductCollectionRepository.save(product);
        view.sucess(product);
    }

    private static void registerCategory() {
        CategoryView view = new CategoryView();
        Category category = view.form(new Category());
        CategoryCollectionRepository.save(category);
        view.sucess(category);
    }
}