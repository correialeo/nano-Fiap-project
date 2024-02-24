package br.com.fiap.project.view;

import javax.swing.*;

public class OptionView {
    public static Option select(){
        Option ret = (Option) JOptionPane.showInputDialog(
                null, //componente pai - não temos, entao sera null
                "Choose one option",
                "Menu",
                JOptionPane.QUESTION_MESSAGE,
                null, //icone
                Option.values(), //n° da opção
                Option.REGISTER_PRODUCT);

        return ret != null ? ret : Option.END_SYSTEM;

    }
}
