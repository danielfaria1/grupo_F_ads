package br.com.usf.bar.repository;

import br.com.usf.bar.model.ProdutoModel;
import br.com.usf.bar.model.VendaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<VendaModel, Long> {

}
