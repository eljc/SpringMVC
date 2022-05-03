package br.com.store.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.store.model.Purchase;
import br.com.store.model.PurchaseStatusEnum;
import br.com.store.repository.PurchaseRepository;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private PurchaseRepository repository;
	
	@GetMapping()
	public String home(Model model) {
		List<Purchase> order = repository.findAll();
		model.addAttribute("purchases", order);
		return "home"; 
	}
	
	@GetMapping("/{status}")
	public String porStatus(@PathVariable("status") String status, Model model) {
		List<Purchase> orderes = repository.findByStatus(PurchaseStatusEnum.valueOf(status.toUpperCase()));
		model.addAttribute("purchases", orderes);
		model.addAttribute("status", status);
		return "home"; 
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onError() {
		return "redirect:/home";
	}
	
}
