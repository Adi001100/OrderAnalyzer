package adamm.service;

import adamm.domain.Order;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderProcessor {
    private final List<Order> orders;

    public OrderProcessor(List<Order> orders) {
        this.orders = orders;
    }

    public Map<String, Double> calculateTotalSpent() {
        Map<String, Double> customerSpending = new HashMap<>();
        for (Order order : orders) {
            String customerName = order.getCustomer().name();
            customerSpending.put(customerName,
                    customerSpending.getOrDefault(customerName, 0.0) + order.getTotal());
        }
        return customerSpending;
    }

    public Map<String, Integer> calculateMostOrdersCity() {
        Map<String, Integer> cityOrders = new HashMap<>();
        for (Order order : orders) {
            String city = order.getCustomer().address().city();
            cityOrders.put(city, cityOrders.getOrDefault(city, 0) + 1);
        }
        return cityOrders;
    }
}
