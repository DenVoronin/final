package hhr.services;

import hhr.entity.Pay;

import java.util.List;

public interface PayService {
    Pay getByName(String pay);
    Pay getById(int id);
    List<Pay> getAll();
}
