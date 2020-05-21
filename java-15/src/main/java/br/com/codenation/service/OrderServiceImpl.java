package br.com.codenation.service;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import br.com.codenation.repository.ProductRepository;
import br.com.codenation.repository.ProductRepositoryImpl;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService {

    private ProductRepository productRepository = new ProductRepositoryImpl();

    /**
     * Calculate the sum of all OrderItems
     */
    @Override
    public Double calculateOrderValue(List<OrderItem> items) {

        return items.stream()
                .mapToDouble(orderItem ->
                {
                    Product product = productRepository.findById(orderItem.getProductId()).orElse(null);
                    if (product != null) {
                        return (orderItem.getQuantity()
                                * product.getValue())
                                * (product.getIsSale() ? 0.8 : 1);
                    }
                    return 0;

                }).sum();

    }

    /**
     * Map from idProduct List to Product Set
     */
    @Override
    public Set<Product> findProductsById(List<Long> ids) {
        return ids.stream()
                .map(productId -> productRepository.findById(productId).orElse(null))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    /**
     * Calculate the sum of all Orders(List<OrderIten>)
     */
    @Override
    public Double calculateMultipleOrders(List<List<OrderItem>> orders) {
        return orders.stream()
                .mapToDouble(this::calculateOrderValue).sum();
    }

    /**
     * Group products using isSale attribute as the map key
     */
    @Override
    public Map<Boolean, List<Product>> groupProductsBySale(List<Long> productIds) {
        Map<Boolean, List<Product>> booleanListMap = findProductsById(productIds).stream()
                .collect(Collectors.groupingBy(Product::getIsSale));

        return findProductsById(productIds).stream()
                .collect(Collectors.groupingBy(Product::getIsSale));
    }

}