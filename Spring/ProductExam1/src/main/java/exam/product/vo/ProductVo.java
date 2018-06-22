package exam.product.vo;

import java.util.Date;

//제품정보를 가지고 있는 Value Object, DTO(Data Transfer Object)
public class ProductVo {
	private String id;
	private String name;
	private int price;
	private Date registerDate;
	
	public ProductVo()
	{
	}
	
	public ProductVo(String id, String name, int price, Date registerDate) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.registerDate = registerDate;
	}
	
	public ProductVo(String id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	@Override
	public String toString() {
		return "제품정보 [id=" + id + ", name=" + name + ", price=" + price + ", registerDate=" + registerDate + "]";
	}
	
	
}
