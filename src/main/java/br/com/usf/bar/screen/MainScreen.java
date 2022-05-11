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
        this.setSize(450, 400);
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
    }
}
