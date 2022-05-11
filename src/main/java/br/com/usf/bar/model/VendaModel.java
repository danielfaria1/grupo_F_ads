package br.com.usf.bar.model;


import javax.persistence.*;
import java.util.Set;

@Entity
public class VendaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToMany
    Set<ProdutoModel> hasProduto;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Set<ProdutoModel> getHasProduto() {
        return hasProduto;
    }

    public void setHasProduto(Set<ProdutoModel> hasProduto) {
        this.hasProduto = hasProduto;
    }
}