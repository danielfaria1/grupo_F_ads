package br.com.usf.bar.screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen extends JFrame {
    private JButton botaListaP;
    private JButton botaoCadastrarV;
    private JPanel mainScreen;

    public MainScreen(String title){
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainScreen);
        this.setSize(550, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        botaListaP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new ListaProdutosGUI("Lista de produtos");
                frame.setVisible(true);
                dispose();
            }
        });
        botaoCadastrarV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new CadastraVenda("Cadastrar venda");
                frame.setVisible(true);
                dispose();
            }
        });
    }
}
