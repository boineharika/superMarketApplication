package com.learning.supermarket.freshmarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.learning.supermarket.freshmarket.entity.UpComingProducts;
import com.learning.supermarket.freshmarket.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	public List<UpComingProducts>  getAllProducts(){
	List<UpComingProducts> products = productRepository.findByStatus("Active");
		return products;
		
	}
	public UpComingProducts addProduct(UpComingProducts product) {
		UpComingProducts newProduct = productRepository.save(product);
		return newProduct;
	}
	
	public List<UpComingProducts> deleteProduct(long id) {
		Optional<UpComingProducts> removeProduct = productRepository.findById(id);
		UpComingProducts upComingProducts = removeProduct.get();
		upComingProducts.setStatus("Deactive");
		productRepository.save(upComingProducts);
		
		List<UpComingProducts> products = productRepository.findByStatus("Active");
		return products;
			
	}
	

}
