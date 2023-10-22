package com.projektcwiczeniowy.Shop;

import com.projektcwiczeniowy.Shop.model.Item;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS )
@Getter
public class Cart {
    private List<CartItem> cartItems = new ArrayList<>();
    private int counter = 0;
    private BigDecimal sum = BigDecimal.ZERO;

    public void addItem(Item item) {
        boolean notFound = true;

        for(CartItem ci: cartItems) {
            if(ci.getItem().getId().equals(item.getId())){
                notFound = false;
                ci.increaseCounter();
                calculatePriceAndCounter();
                break;
            }
        }

        if(notFound) {
            cartItems.add(new CartItem(item));
            calculatePriceAndCounter();
        }
    }
    public void removeItem (Item item){
        for(CartItem ci: cartItems){
            if(ci.getItem().getId().equals(item.getId())) {
                ci.decreaseCounter();
                if(ci.hasZeroItems()) {
                    cartItems.remove(ci);
                }
                calculatePriceAndCounter();
                break;
            }
        }
    }

    private void calculatePriceAndCounter() {
        int tempCounter = 0;
        BigDecimal tempPrice = BigDecimal.ZERO;

        for(CartItem ci: cartItems){
            tempCounter += ci.getCounter();
            tempPrice = tempPrice.add(ci.getPrice());
        }
        this.counter = tempCounter;
        this.sum = tempPrice;
    }
}
