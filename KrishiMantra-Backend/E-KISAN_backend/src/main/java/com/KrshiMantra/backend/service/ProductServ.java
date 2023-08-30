package com.KrshiMantra.backend.service;

import java.util.List;

import com.KrshiMantra.backend.entity.Farmer;
import com.KrshiMantra.backend.entity.Product;

public interface ProductServ {
String addcrop(Product product);
void UpdateProduct(double quantity,double expectedPrice,String crop,int fid);
void deleteproduct( int fid  ,String crop);
List<Product> findproduct(String crop);
double getQuantity(int fid,String crop);
List<Product> getAllproducts();
void deleteproductById(Farmer farmer);
List<Product>  findMyProduct(Farmer farmer);
double availableQuantity(int fid, String crop);
void deleteQuantityCompletly(int fid, String crop);
void deductQuantity(int fid, double quantityRemains, String crop);

}
