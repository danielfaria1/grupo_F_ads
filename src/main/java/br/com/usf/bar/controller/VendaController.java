package br.com.usf.bar.controller;

import br.com.usf.bar.model.VendaModel;
import br.com.usf.bar.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VendaController {
    @Autowired
    VendaRepository vendaRepository;

    @RequestMapping("/vendas")
    public List<VendaModel> listVendas() {
        return vendaRepository.findAll();
    }

    @RequestMapping("/vendas/{id}")
    public VendaModel getVenda(@PathVariable Long  id) {
        return vendaRepository.findById(id).get();
    }

    @PostMapping("/vendas")
    public VendaModel insert(@RequestBody VendaModel Venda) {
        Venda.setId(null);
        return vendaRepository.save(Venda);
    }

    @PutMapping("/vendas/{id}")
    public VendaModel update(@PathVariable Long  id,@RequestBody VendaModel Venda) {
        Venda.setId(id);
        return vendaRepository.save(Venda);
    }

    @DeleteMapping("/vendas/{id}")
    public String delete(@PathVariable Long  id) {
        vendaRepository.deleteById(id);
        return "OK";
    }
}
