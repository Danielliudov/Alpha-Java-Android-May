package com.minkov.services;

import com.minkov.models.Category;
import com.minkov.models.Product;
import com.minkov.services.base.ProductsService;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ProductsServiceImpl implements ProductsService {
    private static List<Product> products;

    static {
        products = new ArrayList<>();
    }

    @Override
    public List<Product> listAllProducts() {
        return products;
    }

    @Override
    public List<Product> search(Predicate<Product> predicate) {
        // TODO: code here
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(Category category) {
        // TODO: code here
        return null;
    }

    @Override
    public void addCategoryToProduct(Product product, Category category) {
        // TODO: code here
    }

    @Override
    public Product findById(int id) {
        // TODO: code here
        return null;
    }

    @Override
    public Product createProduct(String productName, double productPrice, List<Category> categories) {
        // TODO: code here
        return null;
    }
}
