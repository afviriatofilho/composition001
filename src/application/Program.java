package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entities.Order;
import entities.Client;
import entities.enums.OrderStatus;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("CLIENT DATA:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		System.out.println("ORDER DATA:");
		sc.nextLine();
		System.out.print("Status: ");
		String status = sc.nextLine();
		System.out.print("Amount of items to be ordered: ");
		int n = sc.nextInt();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status), new Client(name, email, birthDate));
		
		for (int i=0; i<n; i++) {
			System.out.printf("ITEM #%d DATA: \n", i+1);
			sc.nextLine();
			System.out.print("Name: ");
			String pName = sc.nextLine();
			System.out.print("Price: U$");
			Double pPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer pQuantity = sc.nextInt();
			order.addItem(new OrderItem (pQuantity, pPrice, new Product(pName, pPrice)));
		}
		
		System.out.println("ORDER SUMMARY: ");
		System.out.print(order);
		
		sc.close();
		
	}

}
