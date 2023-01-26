package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private LocalDateTime moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> items = new ArrayList<>();
	
	public Order() {
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getMoment() {
		return moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss"));
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double total = 0;
		for (OrderItem i : items) {
			total += i.subTotal();
		}
		return total;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order moment: " + moment.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss")) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client + "\n");
		sb.append("Order items:\n");
		for (OrderItem oi : items) {
			sb.append(oi + "\n");
		}
		sb.append(String.format("Total price: $%.2f", total()));
		String string = sb.toString();
		return string;
	}
	
}
