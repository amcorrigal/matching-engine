package com.mcorrigal.matchingEngine.factories;

import com.mcorrigal.matchingEngine.order.BuyOrder;
import com.mcorrigal.matchingEngine.order.SellOrder;
import com.mcorrigal.matchingEngine.order.interfaces.Order;
import com.mcorrigal.matchingEngine.order.orderProperties.OrderId;
import com.mcorrigal.matchingEngine.order.orderProperties.OrderSide;
import com.mcorrigal.matchingEngine.order.orderProperties.OrderType;
import com.mcorrigal.matchingEngine.order.orderProperties.Price;
import com.mcorrigal.matchingEngine.order.orderProperties.Quantity;

public class OrderFactory {
	
	public static Order newLimit(String id, String side, String price, String quantity) {
		if (OrderSide.valueOf(side.toUpperCase()).equals(OrderSide.BUY)) {
			return newLimitBuy(id, price, quantity);
		} else {
			return newLimitSell(id, price, quantity);
		}
	}
	
	public static BuyOrder newLimitBuy(String id, String price, String quantity) {
		return newLimitBuy(
				OrderId.create(id), 
				Price.create(price), 
				Quantity.create(quantity));
	}

	public static SellOrder newLimitSell(String id, String price, String quantity) {
		return newLimitSell(
				OrderId.create(id), 
				Price.create(price), 
				Quantity.create(quantity));
	}
	
	public static BuyOrder newLimitBuy(OrderId id, Price price, Quantity quantity) {
		return new BuyOrder(
				id,
                OrderType.LIMIT,
				price, 
				quantity);
	}

	public static SellOrder newLimitSell(OrderId id, Price price, Quantity quantity) {
		return new SellOrder(
				id,
                OrderType.LIMIT,
				price, 
				quantity);
	}

}
