package com.learning.supermarket.freshmarket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.learning.supermarket.freshmarket.entity.UpComingProducts;
import com.learning.supermarket.freshmarket.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;
/*	@GetMapping("/upcoming-products")
	public  List<UpComingProducts> getAllProducts() {
		List<UpComingProducts> products = productService.getAllProducts();
		return products;
	}
	*/
	@GetMapping("/upcoming-products")
	public  ModelAndView getAllProductsUi() {
		List<UpComingProducts> products = productService.getAllProducts();
		ModelAndView mv = new ModelAndView();
		mv.addObject("AllProducts",products);
		mv.setViewName("upComingProducts");
		return mv;
	}

	@PostMapping("/admin/deleteProduct/{prdId}")
	public ModelAndView deleteProductId(@PathVariable("prdId") Integer prdId){
		List<UpComingProducts> products = productService.deleteProduct(Long.parseLong(prdId.toString()));

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/adminHome");
		mv.addObject("AllProducts",products);
		mv.addObject("userName", "welcome Admin");
		return mv;
	}
}
