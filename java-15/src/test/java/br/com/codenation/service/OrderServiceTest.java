package br.com.codenation.service;

import br.com.codenation.model.OrderItem;
import br.com.codenation.model.Product;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class OrderServiceTest {

    private OrderService orderService = new OrderServiceImpl();

    @Test
    public void testCalculateOrderValue() {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(1l, 3l));
        items.add(new OrderItem(2l, 2l));
        assertNotNull(this.orderService.calculateOrderValue(items));
    }

    @Test
    public void testFindProductsById() {
        Set<Product> products = this.orderService.findProductsById(Arrays.asList(1l, 2l, 3l, 4l, 5l));
        assertNotNull(products.size());
    }

    @Test
    public void testCalculateMultipleOrders() {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(1l, 3l));
        items.add(new OrderItem(2l, 2l));
        List<OrderItem> items2 = new ArrayList<>();
        items.add(new OrderItem(1l, 3l));
        items.add(new OrderItem(2l, 2l));
        List<OrderItem> items3 = new ArrayList<>();
        items.add(new OrderItem(1l, 3l));
        items.add(new OrderItem(2l, 2l));
        assertNotNull(this.orderService.calculateMultipleOrders(Arrays.asList(items, items2, items3)));
    }

    @Test
    public void testGroupProducts() {
        Map<Boolean, List<Product>> groupedProducts = this.orderService.groupProductsBySale(Arrays.asList(1l, 2l, 12l));
        assertNotNull(groupedProducts.get(true));
        assertNotNull(groupedProducts.get(false));
    }

    @Test
    public void testCalculateOrderValueWhenOnlyIsSaleFalse() {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(1l, 1l));
        items.add(new OrderItem(2l, 1l));
        items.add(new OrderItem(3l, 1l));

        Double total = this.orderService.calculateOrderValue(items);
        assertEquals(330, total.intValue());
    }

    @Test
    public void testCalculateOrderValueWhenOnlyIsSaleFalseWithQuantity() {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(1l, 2l));
        items.add(new OrderItem(2l, 1l));
        items.add(new OrderItem(3l, 3l));

        Double total = this.orderService.calculateOrderValue(items);
        assertEquals(580, total.intValue());
    }

    @Test
    public void testCalculateOrderValueWhenOnlyIsSaleTrue() {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(15l, 1l));
        items.add(new OrderItem(17l, 1l));

        Double total = this.orderService.calculateOrderValue(items);
        assertEquals(156, total.intValue());
    }

    @Test
    public void testCalculateOrderValueWhenOnlyHasSaleTrueAndSaleFalse() {
        List<OrderItem> items = new ArrayList<>();
        items.add(new OrderItem(1l, 1l));
        items.add(new OrderItem(15l, 1l));

        Double total = this.orderService.calculateOrderValue(items);
        assertEquals(327, total.intValue());
    }



}
