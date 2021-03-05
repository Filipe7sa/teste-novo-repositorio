package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enuns.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		Date moment = new Date(System.currentTimeMillis());
		
		System.out.println("Enter Cliente Data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		
		
		
		System.out.println("Enter order data:");
		System.out.print("Status: ");
		String status = sc.next();
		Order order = new Order(moment, OrderStatus.valueOf(status),
				new Client(name, email, birthDate));
		
		System.out.print("How many items to this order: ");
		int n = sc.nextInt();
		
		for(int i = 1; i <=n; i++) {
			System.out.println("Enter #" + i + " item data: ");
			
			System.out.print("Product name:" );
			String productName = sc.next();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			
			Product p = new Product(productName, productPrice);
			OrderItem orderItem = new OrderItem(quantity, productPrice, p);
			order.addOrderItem(orderItem);
			
		}
		
		System.out.println(order);
		
		
		
	}

}
