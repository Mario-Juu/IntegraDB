package org.mario.view;

import org.mario.controller.ContatoController;
import org.mario.model.Contato;

import javax.swing.*;
import java.util.InputMismatchException;

public class AddContato {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton enviarButton;
    private JButton verTodosButton;
    private JPanel Jp;

    public AddContato() {
        enviarButton.addActionListener(e -> {
            try{
            Contato contato = new Contato();
            contato.setNome(textField1.getText());
            contato.setEmail(textField2.getText());
            contato.setFone(textField3.getText());
            ContatoController cc = new ContatoController();
            cc.create(contato);
            textField1.setText("");
            textField2.setText("");
            textField3.setText("");
            JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
            } catch (InputMismatchException ex){
                JOptionPane.showMessageDialog(null, "Erro ao adicionar contato: " + ex.getMessage());
            }
        });
        verTodosButton.addActionListener(e -> {
            Menu.preencherTabela(new ContatoController().getAll());

        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("AddContato");
        frame.setContentPane(new AddContato().Jp);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.pack();
        frame.setVisible(true);
    }
}
