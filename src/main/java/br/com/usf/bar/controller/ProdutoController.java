package br.com.usf.bar.controller;

import br.com.usf.bar.model.ProdutoModel;
import br.com.usf.bar.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {
    @Autowired
    ProdutoRepository produtoRepository;

    @RequestMapping("/produtos")
    public List<ProdutoModel> listProdutos() {
        return produtoRepository.findAll();
    }

    @RequestMapping("/produtos/{id}")
    public ProdutoModel getProduto(@PathVariable Long  id) {
        return produtoRepository.findById(id).get();
    }

    @PostMapping("/produtos")
    public ProdutoModel insert(@RequestBody ProdutoModel produto) {
        produto.setId(null);
        return produtoRepository.save(produto);
    }

    @PutMapping("/produtos/{id}")
    public ProdutoModel update(@PathVariable Long  id,@RequestBody ProdutoModel produto) {
        produto.setId(id);
        return produtoRepository.save(produto);
    }

    @DeleteMapping("/produtos/{id}")
    public String delete(@PathVariable Long  id) {
        produtoRepository.deleteById(id);
        return "OK";
    }
}
