package com.learning.supermarket.freshmarket.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
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
	@GetMapping("/admin/updateProducts/")
	public ModelAndView getUpdateProduct() {
		ModelAndView mv = new ModelAndView();
		UpComingProducts upComingProducts = new UpComingProducts();
		//user.setUserName("xyz");
		mv.addObject("product", upComingProducts);
		mv.setViewName("admin/updateProducts");
		return mv;
	}
	
/*	//Without validation
    @PostMapping("/admin/updateProducts/")
	public ModelAndView updateProduct(UpComingProducts prd){
		UpComingProducts products = productService.addNewProduct(prd);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("admin/updateProducts");
		mv.addObject("product",products);
		mv.addObject("successMessage", "User has been registered successfully");
		return mv;
	}*/
	
	@PostMapping("/admin/updateProducts/")
	public ModelAndView updateProduct(@Valid UpComingProducts product, BindingResult bindingResult){
		ModelAndView mv = new ModelAndView();
       UpComingProducts products = productService.findByProductCode(product.getProductCode());
        if (products != null) {
            bindingResult.rejectValue("productCode", "error.prd","Product code already exits");
        }
        if (bindingResult.hasErrors()) {
        	//List<UpComingProducts> Allproducts = productService.getAllProducts();
            mv.setViewName("admin/updateProducts");
           // mv.addObject("product",Allproducts);
        } else {
        products = productService.addNewProduct(product);
		mv.addObject("successMessage", "Successfully updated products");
		mv.addObject("product",products);
		mv.addObject("product",new UpComingProducts());
		mv.setViewName("admin/updateProducts");
		List<UpComingProducts> Allproducts = productService.getAllProducts();

	}
        return mv;
	}
}
