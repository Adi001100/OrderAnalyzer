package adamm;

import adamm.domain.Order;
import adamm.service.OrderProcessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class OrderAnalyzerMain {


    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new File("src/main/resources/orders.json");
            List<Order> orders = Arrays.asList(objectMapper.readValue(file, Order[].class));

            OrderProcessor orderProcessor = new OrderProcessor(orders);

            Map<String, Double> totalSpent = orderProcessor.calculateTotalSpent();
            String maxSpentCustomer = Collections.max(totalSpent.entrySet(), Map.Entry.comparingByValue()).getKey();
            double maxSpentAmount = totalSpent.get(maxSpentCustomer);
            System.out.printf("The customer who spent the most is %s with a total spending of $%.2f %n", maxSpentCustomer, maxSpentAmount);

            Map<String, Integer> cityOrders = orderProcessor.calculateMostOrdersCity();
            String maxOrdersCity = Collections.max(cityOrders.entrySet(), Map.Entry.comparingByValue()).getKey();
            int maxOrdersCount = cityOrders.get(maxOrdersCity);
            System.out.printf("The city with the most orders is %s with %d orders %n", maxOrdersCity, maxOrdersCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}