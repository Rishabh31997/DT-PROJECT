package com.mainproject.backend01.models;

import javax.persistence.*;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int productId;
	
	
	private String productName;
	private double price;
	private String description;
	private int quantity;
	private String is_active;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Category category;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	private Supplier supplier;

	@Transient
	MultipartFile pimage;
	
	private String imgName;
	
	
	
	public Product() {
		super();
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Category getCat() {
		return category;
	}

	public void setCat(Category cat) {
		this.category = cat;
	}

	public Supplier getSupp() {
		return supplier;
	}

	public void setSupp(Supplier supp) {
		this.supplier = supp;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}
	

	public String getIs_active() {
		return is_active;
	}

	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}
	
	

	public MultipartFile getPimage() {
		return pimage;
	}

	public void setPimage(MultipartFile pimage) {
		this.pimage = pimage;
	}

	public String getImgName() {
		return imgName;
	}

	public void setImgName(String imgName) {
		this.imgName = imgName;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName="
				+ productName + ", price=" + price + ", description="
				+ description + ", quantity=" + quantity + ", category="
				+ category + ", supplier=" + supplier + "]";
	}
	
	
	
	
	 
	 
}
