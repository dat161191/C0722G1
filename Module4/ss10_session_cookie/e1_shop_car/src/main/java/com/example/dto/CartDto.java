package com.example.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto,Integer> productMap=new HashMap<>();
    public CartDto(){}

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }
    public void addProduct(ProductDto productDto){
        if (productMap.containsKey(productDto)){
            Integer currentValue=productMap.get(productDto);
            /**== Nếu key đã tồn tại thì tăng value lên +1 ==**/
            productMap.replace(productDto,currentValue + 1);
        }else {
            /*===Nếu key chưa tồn tại thì put value lên +1==*/
            productMap.put(productDto,1);
        }
    }

    public void pay() {
        productMap.clear();
    }
}
