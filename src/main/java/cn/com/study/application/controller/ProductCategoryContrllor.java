package cn.com.study.application.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.study.application.model.ProductCategory;
import cn.com.study.application.service.ProductCategoryService;

@Controller
public class ProductCategoryContrllor {
	
	@Resource
	private ProductCategoryService productCategoryService;

	public ProductCategoryService getProductCategoryService() {
		return productCategoryService;
	}

	public void setProductCategoryService(
			ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}
	
	@RequestMapping("/product/category")
	public String list(ModelMap model) {
		List<ProductCategory> list = productCategoryService.getList();
		model.put("list", list);
		return "/product/product_category_list";
	}
}