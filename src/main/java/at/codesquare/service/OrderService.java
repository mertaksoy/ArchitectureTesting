package at.codesquare.service;

import at.codesquare.annotation.Service;
import at.codesquare.entity.Order;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderService {

    List<Order> getOrders() {
        return Arrays.asList(new Order(1), new Order(2));
    }
}
