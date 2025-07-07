package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "productos")

public class producto {

	@Id
	@Column (name = "product_code", nullable = false)
	private Integer product_code = 0;
	
	@Column (name = "name",  nullable = false)
	private String product_name;
	
	public producto () {}
	
	public producto(Integer product_code, String product_name) {
		this.product_code = product_code;
		this.product_name = product_name;
	}

	public Integer getProduct_code() {
		return product_code;
	}

	public void setProduct_code(Integer product_code) {
		this.product_code = product_code;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	
	
}
