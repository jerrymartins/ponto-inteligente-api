package com.kazale.pontointeligente.api.repositories;

import java.util.List;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.kazale.pontointeligente.api.entities.Lancamento;

@Transactional(readOnly=true)
@NamedQueries({
	@NamedQuery(name="LancamentoRepository.findByFuncionarioId",
			query="SELECT lanc FROM lancamento WHERE lanc.funcioanrio.id= :funcionarioId")
})
public interface LancamentoRepository {
	
	List<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId);
	
	Page<Lancamento> findByFuncionarioId(@Param("funcionarioId") Long funcionarioId, Pageable pageable);
}
