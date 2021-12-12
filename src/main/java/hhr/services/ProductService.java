package hhr.services;

import hhr.entity.Pay;
import hhr.entity.Product;

import java.util.List;

public interface ProductService {
    Product getByName(String product);
    Product getById(int id);
    List<Product> getAll();
}
