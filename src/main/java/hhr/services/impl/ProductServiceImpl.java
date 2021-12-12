package hhr.services.impl;

import hhr.entity.Overtimes;
import hhr.entity.Product;
import hhr.repository.OvertimesRepository;
import hhr.repository.ProductRepository;
import hhr.services.OvertimesService;
import hhr.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;
    @Override
    public Product getByName(String overtime) {
        return productRepository.findByName(overtime);
    }

    @Override
    public Product getById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
