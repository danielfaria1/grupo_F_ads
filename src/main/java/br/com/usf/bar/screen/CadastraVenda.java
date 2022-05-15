package br.com.usf.bar.screen;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastraVenda extends JFrame {
    private JButton botaoVoltar;
    private JPanel cadastraScreen;
    private JTextField dataText;
    private JTextField textHora;
    private JSpinner spinner1;
    private JComboBox comboBox1;

    public CadastraVenda(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(cadastraScreen);
        this.setSize(550, 500);
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
