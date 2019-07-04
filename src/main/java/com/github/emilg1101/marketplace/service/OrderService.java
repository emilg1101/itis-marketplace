package com.github.emilg1101.marketplace.service;

import com.github.emilg1101.marketplace.data.entity.Address;
import com.github.emilg1101.marketplace.data.entity.Order;
import com.github.emilg1101.marketplace.data.entity.Product;
import com.github.emilg1101.marketplace.data.entity.User;
import com.github.emilg1101.marketplace.data.repository.AddressRepository;
import com.github.emilg1101.marketplace.data.repository.OrderRepository;
import com.github.emilg1101.marketplace.data.repository.ProductRepository;
import com.github.emilg1101.marketplace.model.form.OrderForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AddressRepository addressRepository;

    public Order order(OrderForm form, User user) {
        Optional<Product> productCandidate = productRepository.findById(form.getProductId());
        Optional<Address> addressCandidate = addressRepository.findById(form.getAddressId());

        if (productCandidate.isPresent() && addressCandidate.isPresent()) {
            Order order = Order.builder()
                    .user(user)
                    .status("process")
                    .product(productCandidate.get())
                    .address(addressCandidate.get())
                    .quantity(form.getQuantity())
                    .total(form.getQuantity() * productCandidate.get().getPrice())
                    .orderTime(Date.from(Instant.now()))
                    .build();
            return orderRepository.save(order);
        }
        throw new EntityNotFoundException();
    }

    public Order cancel(long orderId, User user) {
        Optional<Order> orderCandidate = orderRepository.findById(orderId);

        if (orderCandidate.isPresent()) {
            Order order = orderCandidate.get();
            if (order.getUser().getId().equals(user.getId())) {
                order.setStatus("canceled");
                return orderRepository.save(order);
            }
        }
        throw new EntityNotFoundException();
    }
}
