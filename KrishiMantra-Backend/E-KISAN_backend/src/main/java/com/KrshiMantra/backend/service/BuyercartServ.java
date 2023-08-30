package com.KrshiMantra.backend.service;

import java.util.List;

import com.KrshiMantra.backend.entity.BuyerCart;


public interface BuyercartServ {
public List<BuyerCart>	getByServUserName(String username);
String deleteCartByUname(String username);
String addCartProduct(BuyerCart cart);
List<BuyerCart> getAll();
 void deletebyCartId(int cartid);


}
