package com.KrshiMantra.backend.service;

import java.util.List;

import com.KrshiMantra.backend.entity.Order;

public interface OrderServ {
	List< Order> getBuyerOrder(int bid);
List< Order> getFarmerOrder(int fid);

public int changeStatus( int oid);
String addOrder(Order order);
List<Order> getUnapprovedOrders(int bid);
List<Order> getBuyerOrder();
void deleteBuyerOrder(int bid);
}
