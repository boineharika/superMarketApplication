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
	List<UpComingProducts> products = productRepository.findAll();
		return products;
		
	}
/*	public List<UpComingProducts> deleteProduct(long id) {
		Optional<UpComingProducts> removeProduct = productRepository.findById(id);
		UpComingProducts upComingProducts = removeProduct.get();
		upComingProducts.setStatus("Deactive");
		productRepository.save(upComingProducts);
		
		List<UpComingProducts> products = productRepository.findByStatus("Active");
		return products;
			
	}*/
	
	
	@PostMapping("/admin/deleteProduct/{prdId}")
	public ModelAndView deleteProductId(@PathVariable("prdId") long prdId){
		Optional<UpComingProducts> products = productRepository.findById(prdId);
		//List<UpComingProducts> products = productService.deleteProduct(Long.parseLong(prdId.toString()));

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/adminHome");
		mv.addObject("AllProducts",products);
		mv.addObject("userName", "welcome Admin");
		return mv;
	}

}
