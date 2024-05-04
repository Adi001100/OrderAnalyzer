package adamm.domain;

import lombok.Data;

@Data
public class Order {

    private String _id;
    private String date;
    private double total;
    private Customer customer;

    public void setTotal(String total) {
        this.total = Double.parseDouble(total.replaceAll("[^\\d.]", ""));
    }
}
