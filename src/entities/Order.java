package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enuns.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> orderItem = new ArrayList<>();
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	private static SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

	
	private Client client;
	
	public Order() {
	}
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	
	public List getOrderItem() {
		return orderItem;
	}
	
	public void addOrderItem(OrderItem orderItem) {
		this.orderItem.add(orderItem);
	}
	
	public void removeOrderItem(OrderItem orderItem) {
		this.orderItem.remove(orderItem);
	}
	
	public double total() {
		double sum = 0;
		for(OrderItem o : orderItem) {
			sum += o.subTotal();
		}
		
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("ORDER SUMMARY:\n");
		sb.append("Order moment: " + sdf.format(moment) + "\n");
		sb.append("Order status: " + status + "\n");
		sb.append("Client: " + client.getName() + 
				" (" + sdf1.format(client.getBirthDate()) +
				") - " + client.getEmail() + "\n");
		sb.append("Order Items: \n");
		for(OrderItem o : orderItem) {
			sb.append(o.getProduct().getName() + ", $");
			sb.append(String.format("%.2f", o.getPrice()) + ", ");
			sb.append("Quantity: " + o.getQuantity() + ", ");
			sb.append("Subtotal: $" + String.format("%.2f", o.subTotal())+"\n");
		}
		sb.append("Total price: $" + String.format("%.2f", total()));
		
		return sb.toString();
	}
}
