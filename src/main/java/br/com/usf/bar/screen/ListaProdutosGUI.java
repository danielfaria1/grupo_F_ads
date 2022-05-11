package br.com.usf.bar.screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaProdutosGUI extends JFrame{
    private JTextField produtosSearch;
    private JTable produtosTable;
    private JButton botaoVoltar;
    private JPanel produtosScreen;

    public ListaProdutosGUI(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(produtosScreen);
        this.setSize(450, 400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MainScreen("Tela Principal");
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
