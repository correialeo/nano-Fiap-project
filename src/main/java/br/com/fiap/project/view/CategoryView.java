package br.com.fiap.project.view;

import br.com.fiap.project.model.Category;
import br.com.fiap.project.repository.CategoryCollectionRepository;

import javax.swing.*;

public class CategoryView {
    static CategoryCollectionRepository repository;

   public static Category select(Category category) {
       Category ret = (Category) JOptionPane.showInputDialog(
               null, //componente pai - não temos, entao sera null
               "Choose one category",
               "Menu",
               JOptionPane.QUESTION_MESSAGE,
               null, //icone
               repository.findAll().toArray(), //n° da opção
               category == null ? 1 : category);

       return ret;
   }

   public void sucess(){
       JOptionPane.showMessageDialog(null,
               "Category added successfully");
   }
   public void sucess(Category category){
       JOptionPane.showMessageDialog(null, "Category " + category.getNome()
               + " added successfully");
   }
   public static Category form (Category category){

       String name = JOptionPane.showInputDialog(null,
               "Enter the name of the category",
               category != null ? category.getNome() : "");
       return new Category(name);
   }

}
