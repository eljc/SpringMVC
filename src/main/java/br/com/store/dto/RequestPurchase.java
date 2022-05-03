package br.com.store.dto;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import br.com.store.model.Purchase;
import br.com.store.model.PurchaseStatusEnum;

public class RequestPurchase {
	
	@NotBlank 
	private String name;
	
	@NotBlank
	private String url;
	
	@NotBlank
	private String image;
	private String description;
	
	public RequestPurchase(@NotBlank String name, @NotBlank String url, @NotBlank String image, String description) {
		super();
		this.name = name;
		this.url = url;
		this.image = image;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Purchase toOrder() {
		Purchase order = new Purchase();
		order.setProductName(name);
		order.setDescription(description);
		order.setImageProduct(image);
		order.setLinkProduct(url);
		order.setStatus(PurchaseStatusEnum.WAITHING);
		order.setDeliveryDate(LocalDate.now());
		return order;
	}

}
