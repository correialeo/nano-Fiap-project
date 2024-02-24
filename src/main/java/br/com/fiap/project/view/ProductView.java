package br.com.fiap.project.view;

import br.com.fiap.project.model.Category;
import br.com.fiap.project.model.Product;
import br.com.fiap.project.repository.ProductCollectionRepository;

import javax.swing.*;
import java.time.LocalDateTime;

public class ProductView {

    static ProductCollectionRepository product;
    public static Product select(Product product){

        Product ret = (Product) JOptionPane.showInputDialog(
                null,
                "Choose a one product",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null,
                ProductCollectionRepository.findAll().toArray(),
                product == null ? 1 : product);

        return ret;
    }

    public void sucess(){
        JOptionPane.showMessageDialog(null, "Product added successfully");
    }
    public static void sucess(Product product){
        JOptionPane.showMessageDialog(null, "Product " + product.getNome()
                + " added successfully");
    }

    public static Product form (Product product){ //captura de entrada de dados
        Category c = null;

        do{
            c = CategoryView.select(product.getCategoria()); //enquanto category for null, o programa continuara perguntando a categoria
        }while (c == null);

        String name = "";
        do {
            name = JOptionPane.showInputDialog(null, "Enter product name", product.getNome());
                                                    // enquanto nome for em branco, o programa continuara perguntando e
                                                    // se for menor de 3 letras, ele roda dnv
            if (name.length() < 3){
                JOptionPane.showMessageDialog(null,
                        "The product must contain at least 3 letters");
            }
        } while (name.equals(""));

        String description = "";
        do {
            description = JOptionPane.showInputDialog(null,
                    "Enter the description of the "+ name, product.getDecricao());
            if (description.length() < 10){
                JOptionPane.showMessageDialog(null,
                        "The description of product must contain at least 10 letters");
            }
        }while (description.equals(""));

        double price = 0;
        do{
            try{
                price = Double.parseDouble(JOptionPane.showInputDialog(null, //transf o joption pane em double
                        "Enter the price of product",
                        product.getPreco()));
            }catch (NumberFormatException e){              //tratando uma possivel exceção
                price = 0;
            }
        if (price <= 0)
            JOptionPane.showMessageDialog(null,
                    "Price not valid");

        }while (price <= 0);           //se preço menor/igual a zero, programa repete pro user informar o preco

        Product ret = product;
        ret.setCategoria(c).
                setNome(name)
                .setDecricao(description)
                .setPreco(price)
                .setDataDeCadastro(LocalDateTime.now());

        return ret;
    }

    public static void update(Product product){
        Category category = null;

        do {
            category = CategoryView.select(product.getCategoria());
            product.setCategoria(category);
        } while (category == null);

        String name = "";
        do {
            name = JOptionPane.showInputDialog("Name of de product: ", product.getNome());

            if (name.length() < 3)
                JOptionPane.showMessageDialog(null,
                        "The product must contain at least 3 letters");

                product.setNome(name);

        } while (name.equals(""));

        String description = "";
        do {
            description = JOptionPane.showInputDialog("Description of the product: ",
                    product.getDecricao());

            if (description.length() < 10)
                JOptionPane.showMessageDialog(null,
                        "The description of product must contain at least 10 letters");

            product.setDecricao(description);

        } while (description.equals(""));

        double price = 0;
        do{
            try {
            price = Double.parseDouble(JOptionPane.showInputDialog("Price of the product: ",
                    product.getPreco()));
            } catch (NumberFormatException e){
                price = 0;
            }

            if (price <= 0)
                JOptionPane.showMessageDialog(null, "Price not supported");

                product.setPreco(price);

        } while (price <= 0);

        sucess(product);
        show(product);
    }

    public static void show(Product p){
        System.out.println(p);
        String pToString = String.format("PRODUCT: " + p.getNome() +
                System.lineSeparator() + "DESCRIPTION: " + p.getDecricao() +
                System.lineSeparator() + "CATEGORY: " + p.getCategoria().toString() +
                System.lineSeparator() + "PRICE: %,.2f", p.getPreco());
        JOptionPane.showMessageDialog(null, pToString);
    }

}
