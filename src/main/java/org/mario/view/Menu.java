package org.mario.view;

import org.mario.model.Contato;

import javax.swing.*;
import java.util.Comparator;
import java.util.List;

public class Menu {
    private JTable JTabela;
    private JPanel panel1;
    private JScrollBar scrollBar1;

    public static void preencherTabela(List<Contato> contatos){
        JTable tabela;
        contatos = contatos.stream().sorted(Comparator.comparing(Contato::getId)).toList();
        Object[][] dados = new Object[contatos.size()][4];
        for(int i = 0; i < contatos.size(); i++){
            dados[i][0] = contatos.get(i).getId();
            dados[i][1] = contatos.get(i).getNome();
            dados[i][2] = contatos.get(i).getEmail();
            dados[i][3] = contatos.get(i).getFone();
        }
        Object[] colunas = {"ID", "Nome", "Email", "Fone"};
        tabela = new JTable(dados, colunas);
        JScrollPane scroll = new JScrollPane(tabela);
        JFrame frame = new JFrame("Contatos");
        frame.add(scroll);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(500, 200);
        frame.setVisible(true);

    }
}
