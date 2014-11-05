package com.prizy.pricer.rule;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collections;
import java.util.List;


public class ProductIdealPriceRuleImpl implements ProductIdealPriceRule {

    @Override
    public BigDecimal calculateProductIdealPrice(List<BigDecimal> priceList) {
        if(priceList == null || priceList.isEmpty()){
            return BigDecimal.ZERO;
        }
        BigDecimal sum = BigDecimal.ZERO;
        int divisorNumber;
        if(priceList.size() <= 4){
            return calculateAveragePrice(priceList);
        }else{
            Collections.sort(priceList);
            int index = 2;//starting 2
            while(index < (priceList.size()-2)){ //last 2
                sum = sum.add(priceList.get(index++));
            }
            divisorNumber = index-2;
        }
        BigDecimal idealPrice = sum.divide(new BigDecimal(divisorNumber), 2, RoundingMode.HALF_UP);
        return idealPrice.setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal calculateAveragePrice(List<BigDecimal> priceList){
        if(priceList == null || priceList.isEmpty()){
            return BigDecimal.ZERO;
        }
        BigDecimal sum = BigDecimal.ZERO;
        for(BigDecimal p : priceList){
            sum = sum.add(p);
        }
        BigDecimal idealPrice = sum.divide(new BigDecimal(priceList.size()), 2, RoundingMode.HALF_UP);
        return idealPrice.setScale(2, RoundingMode.HALF_UP);
    }


    public BigDecimal calculateLowestPrice(List<BigDecimal> priceList){
        if(priceList == null || priceList.isEmpty()){
            return BigDecimal.ZERO;
        }
        Collections.sort(priceList);
        return priceList.get(0);
    }

    public BigDecimal calculateHighestPrice(List<BigDecimal> priceList){
        if(priceList == null || priceList.isEmpty()){
            return BigDecimal.ZERO;
        }
        Collections.sort(priceList);
        return priceList.get(priceList.size()-1);
    }
}

