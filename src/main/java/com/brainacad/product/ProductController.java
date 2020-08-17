package com.brainacad.product;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("catalog/products")
public class ProductController {

    ProductRepository productRepository;
    @GetMapping("list")
    ModelAndView list() {
        Map<String,Object> res = new HashMap<>();
        res.put("products",this.productRepository.findAll());
        return new ModelAndView("catalog/products/list",
                res,
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    ModelAndView getById(@PathVariable UUID id) {

        Map<String,Object> res = new HashMap<>();
        res.put("product",this.productRepository.findById(id));
        return new ModelAndView("catalog/products/list",
                res,
                HttpStatus.OK);
    }

}
