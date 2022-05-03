package br.com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.store.model.Purchase;
import br.com.store.model.PurchaseStatusEnum;

@Component
public interface PurchaseRepository extends JpaRepository<Purchase, Long>{
		
	List<Purchase> findByStatus(PurchaseStatusEnum status);

}
