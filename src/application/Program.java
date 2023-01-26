package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Client data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		LocalDate birthDate = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Client client = new Client(name, email, birthDate);
		sc.nextLine();
		System.out.println();
		
		System.out.println("Order data:");
		System.out.print("Status: ");
		String status = sc.nextLine();
		Order order = new Order(LocalDateTime.now(), OrderStatus.valueOf(status), client);
		System.out.print("Number of items: ");
		int n = sc.nextInt();
		System.out.println();
		
		for (int i=0; i<n; i++) {
			sc.nextLine();
			System.out.printf("Item #%d data:\n", i+1);
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Product amount: ");
			int amount = sc.nextInt();
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(amount, productPrice, product);
			order.addItem(item);
		}
		
		System.out.println("ORDER SUMMARY:");
		System.out.print(order);
		
		sc.close();
		
	}

}
