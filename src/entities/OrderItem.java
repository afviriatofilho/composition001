package entities;

public class OrderItem {

	private Integer amount;
	private Double price;
	private Product product;
	
	public OrderItem() {
	}

	public OrderItem(Integer amount, Double price, Product product) {
		this.amount = amount;
		this.price = price;
		this.product = product;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double subTotal() {
		return price * amount;
	}
	
	public String toString() {
		return String.format("%s, Amount: %d, Subtotal: $%.2f", product, amount, subTotal());
	}
	
}
