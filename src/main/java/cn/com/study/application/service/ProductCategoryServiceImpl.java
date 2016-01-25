package cn.com.study.application.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.com.study.application.mapper.ProductCategoryMapper;
import cn.com.study.application.model.ProductCategory;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {
	
	@Resource
	public ProductCategoryMapper productCategoryMapper;
	
	public ProductCategoryMapper getProductCategoryMapper() {
		return productCategoryMapper;
	}

	public void setProductCategoryMapper(ProductCategoryMapper productCategoryMapper) {
		this.productCategoryMapper = productCategoryMapper;
	}

	@Override
	public ProductCategory get(int id) {
		return productCategoryMapper.get(id);
	}

	@Override
	public void remove(ProductCategory t) {
	}

	@Override
	public void update(ProductCategory t) {
	}

	@Override
	public List<ProductCategory> getList() {
		return productCategoryMapper.getList();
	}

	@Override
	public void insert(ProductCategory t) {
		productCategoryMapper.insert(t);
	}

}
