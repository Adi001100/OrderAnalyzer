package adamm.domain;

public record Customer(String name,
                       String phone,
                       String mail,
                       Address address) {
}
