package br.com.store.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String productName;
	private BigDecimal value;
	private LocalDate deliveryDate;
	private String linkProduct;
	private String imageProduct;
	private String description;
	
	@Enumerated(EnumType.STRING)
	private PurchaseStatusEnum status;
		
	public PurchaseStatusEnum getStatus() {
		return status;
	}
	public void setStatus(PurchaseStatusEnum status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getLinkProduct() {
		return linkProduct;
	}
	public void setLinkProduct(String linkProduct) {
		this.linkProduct = linkProduct;
	}
	public String getImageProduct() {
		return imageProduct;
	}
	public void setImageProduct(String imageProduct) {
		this.imageProduct = imageProduct;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
