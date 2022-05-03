package br.com.store.mvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.store.dto.RequestPurchase;
import br.com.store.model.Purchase;
import br.com.store.repository.PurchaseRepository;

@Controller
@RequestMapping("purchase")
public class PurchaseController {
	
	@Autowired
	private PurchaseRepository orderRepository;

	@GetMapping("form") 
	public String form(RequestPurchase requestPurchase) {
		return "purchase/form";
	}
	
	@PostMapping("new")
	public String newOrder(@Valid RequestPurchase requestPurchase, BindingResult result) {
		if(result.hasErrors()) {
			return "purchase/form";
		}
		
		Purchase order = requestPurchase.toOrder();
		orderRepository.save(order);
		
		return "redirect:/home";
	}

}
