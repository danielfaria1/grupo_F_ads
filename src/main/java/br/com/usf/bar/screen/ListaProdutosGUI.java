package br.com.usf.bar.screen;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.http.HttpClient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import br.com.usf.bar.conexao.Conexao;

import br.com.usf.bar.model.ProdutoModel;
import br.com.usf.bar.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.ui.Model;

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
        carregaTabela();

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame frame = new MainScreen("Tela Principal");
                frame.setVisible(true);
                dispose();
            }
        });
    }

//    public List<ProdutoModel> listar(){
//
//        List<ProdutoModel> listaProdutos = new ArrayList<>();
//
//        Connection con = Conexao.getConnection();
//        PreparedStatement pstm = null;
//        ResultSet rs = null;
//
//        try {
//            pstm = con.prepareStatement("select * from public.produto_model");
//            rs = pstm.executeQuery();
//
//            while(rs.next()){
//                ProdutoModel produto = new ProdutoModel();
//
//                produto.setId((long) rs.getInt("id"));
//                produto.setNome(rs.getString("nome"));
//                produto.setValor((double) rs.getInt("valor"));
//
//                listaProdutos.add(produto);
//            }
//        } catch (SQLException ErroSql) {
//            JOptionPane.showMessageDialog(null, "Erro ao listar dados " + ErroSql, "ERRO",
//                JOptionPane.ERROR);
//        }
//        finally {
//            Conexao.closeConnection(con, pstm, rs);
//        }
//
//        return listaProdutos;
//    }

    public void carregaTabela(){
        DefaultTableModel modelo = (DefaultTableModel) produtosTable.getModel();
        modelo.setNumRows(0);

        modelo.addColumn("id");
        modelo.addColumn("nome");
        modelo.addColumn("valor");

        produtosTable.getColumnModel().getColumn(0).setPreferredWidth(20);
        produtosTable.getColumnModel().getColumn(1).setPreferredWidth(80);
        produtosTable.getColumnModel().getColumn(2).setPreferredWidth(20);

        try{
            Connection con = Conexao.getConnection();
            PreparedStatement pstm;
            ResultSet rs;

            pstm = con.prepareStatement("select * from public.produto_model;");
            rs = pstm.executeQuery();

            while(rs.next()){
                modelo.addRow(new Object[]{
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3)
                });
            }

            Conexao.closeConnection(con, pstm, rs);

        } catch(Exception ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar a tabela de dados: " + ErroSql,
                    "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }
}
