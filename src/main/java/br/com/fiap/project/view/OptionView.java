package br.com.fiap.project.view;

import javax.swing.*;

public class MainOption {
    public static Option select(){
        Option option = (Option) JOptionPane.showInputDialog(
                null, //componente pai - não temos, entao sera null
                "Choose one option",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, //icone
                Option.values(), //n° da opção
                Option.REGISTER_PRODUCT);

        return option != null ? option : Option.END_SYSTEM;

    }
}
