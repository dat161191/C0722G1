package com.example.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    private Map.Entry<ProductDto, Integer> selectItemInCart(ProductDto productDto) {
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId() == productDto.getId()) {
                return entry;
            }
        }
        return null;
    }

    private boolean checkItemInCart(ProductDto product) {
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            if (entry.getKey().getId() == product.getId()) {
                return true;
            }
        }
        return false;
    }

    public void addProduct(ProductDto productDto) {
        if (!checkItemInCart(productDto)) {
            productMap.put(productDto, 1);
        } else {
            Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
            Integer newQuantity = itemEntry.getValue() + 1;
            productMap.replace(itemEntry.getKey(), newQuantity);
        }
    }

    public void subProduct(ProductDto productDto) {
        if (checkItemInCart(productDto)) {
            Map.Entry<ProductDto, Integer> itemEntry = selectItemInCart(productDto);
            if (itemEntry.getValue() > 1) {
                Integer newQuantity = itemEntry.getValue() - 1;
                productMap.replace(itemEntry.getKey(), newQuantity);
            } else {
                productMap.remove(itemEntry.getKey());
            }
        }
    }

    public Integer countProductQuantity() {
        Integer productQuantity = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity() {
        return productMap.size();
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * entry.getValue();
        }
        return payment;
    }

    public void pay(){
        productMap.clear();
    }

}
