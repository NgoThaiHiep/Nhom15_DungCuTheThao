/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.controller.admin;


import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import iuh.se.fit.entity.Product;
import iuh.se.fit.entity.ProductCategory;
import iuh.se.fit.entity.Sale;
import iuh.se.fit.model.ProductCategoryDTO;
import iuh.se.fit.model.ProductDTO;
import iuh.se.fit.model.SaleDTO;
import iuh.se.fit.service.ProductCategoryService;
import iuh.se.fit.service.ProductService;
import iuh.se.fit.service.SaleService;

/**
 *
 * @author NgocTri
 */
@Controller
@RequestMapping(value = "/admin")
public class ProductAdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private ProductCategoryService categoryService;
    // Create new product

    @GetMapping(value = "/product-create")
    public String insert(HttpServletRequest request, Model theModel) {
        Product product = new Product();

        theModel.addAttribute(product);
        request.setAttribute("categories", categoryService.findAll());
        request.setAttribute("sales", saleService.findAll());
        return "admin/product/createNewProduct";
    }

    //Insert product
    @PostMapping(value = "/product-create")
    public String
            insertPost(HttpServletRequest request, @RequestParam("imageFile") MultipartFile photo) throws IOException, ServletException {

        long categoryId = Long.parseLong(request.getParameter("categoryId"));
        String productName = request.getParameter("productName");
        String description
                = request.getParameter("description");
        double price
                = Double.parseDouble(request.getParameter("price"));
        int quantity
                = Integer.parseInt(request.getParameter("quantity"));
        long saleId
                = Long.parseLong(request.getParameter("saleId"));

        InputStream inputStream = photo.getInputStream();

        ProductCategory category = new ProductCategory();
        category.setCategoryId(categoryId);

        Sale sale = new Sale();
        sale.setSaleId(saleId);

        Product product = new Product(productName, price, quantity, description,
                category, sale);

        productService.insert(product, inputStream);
        return "redirect:../admin/product-list";
    }

    @GetMapping(value = "/product-update")
    public String update(HttpServletRequest request, @RequestParam(name = "productId") long productId) {
        request.setAttribute("product", productService.findById(productId));
        request.setAttribute("sales", saleService.findAll());
        request.setAttribute("categories", categoryService.findAll());
        return "admin/product/updateProduct";
    }

    //Update product
    @PostMapping(value = "/product-update")
    public String update(HttpServletRequest request,
            @RequestParam(name = "newPrice", required = false) String newPrice,
            @RequestParam(name = "imageFile", required = false) MultipartFile imageFile) throws IOException {
        long productId = Long.parseLong(request.getParameter("productId"));
        long categoryId = Long.parseLong(request.getParameter("categoryId"));
        long saleId = Long.parseLong(request.getParameter("saleId"));
        float oldprice = Float.parseFloat(request.getParameter("oldPrice"));
        String productName = request.getParameter("productName");
        String description = request.getParameter("description");
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        SaleDTO saleDTO = new SaleDTO();
        saleDTO.setSaleId(saleId);
        ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
        categoryDTO.setCategoryId(categoryId);
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productId);
        productDTO.setSaleDTO(saleDTO);
        productDTO.setCategoryDTO(categoryDTO);
        productDTO.setProductName(productName);
        productDTO.setDescription(description);
        productDTO.setProductQuantity(quantity);
        if (newPrice == null || newPrice.equals("")) {
            productDTO.setPrice(oldprice);
        } else {
            productDTO.setPrice(Float.parseFloat(newPrice));
        }

        InputStream inputStream = imageFile.getInputStream();

        productService.update(productDTO, inputStream);
        return "redirect:/admin/product-list";
    }

//    @PostMapping(value = "/product-create")
//    public String insertPost(HttpServletRequest request, @RequestParam(name = "categoryId") long categoryId,
//            @RequestParam(name = "productName") String productName,
//            @RequestParam(name = "description") String description,
//            @RequestParam(name = "price") float price,
//            @RequestParam(name = "quantity") int quantity,
//            @RequestParam(name = "saleId") long saleId,
//            @RequestParam(name = "imageFile") MultipartFile imageFile) throws IOException, ServletException {
//        ProductCategoryDTO categoryDTO = new ProductCategoryDTO();
//        categoryDTO.setCategoryId(categoryId);
//        SaleDTO saleDTO = new SaleDTO();
//        saleDTO.setSaleId(saleId);
//
//        ProductDTO productDTO = new ProductDTO();
//        productDTO.setCategoryDTO(categoryDTO);
//        productDTO.setSaleDTO(saleDTO);
//        productDTO.setProductName(productName);
//        productDTO.setDescription(description);
//        productDTO.setPrice(price);
//        productDTO.setProductQuantity(quantity);
//
//        InputStream inputStream = imageFile.getInputStream();
//
//        productService.insert(productDTO, inputStream);
//        return "redirect:../admin/product-list";
//
//    }
    // Show all product
    @GetMapping(value = "/product-list")
    public String findAll(HttpServletRequest request, HttpSession session) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        int pageIndex = 0;
        int pageSize = 5;

        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }
        int totalPage = 0;
        int count = productService.count();
        if (count % pageSize == 0) {
            totalPage = count / pageSize;
        } else {
            totalPage = count / pageSize + 1;
        }
        session.setAttribute("countProduct", count);
        request.setAttribute("categories", categoryService.findAll());
        request.setAttribute("totalProducts", count);
        request.setAttribute("default", "default");
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("products", productService.findAll(pageIndex, pageSize));
        return "admin/product/listProduct";
    }
    // Delete Product

    @GetMapping(value = "/product-delete")
    public String delete(HttpServletRequest request) {
        String[] productIds = request.getParameterValues("productId");
        for (String productId : productIds) {
            productService.delete(Long.parseLong(productId));
        }
        return "redirect:../admin/product-list";
    }

    // Hiển thị tất cả sản phẩm theo loại
    @GetMapping(value = "/product-list-by-category")
    public String findAllByCategory(HttpServletRequest request, @RequestParam(name = "categoryId") long categoryId) {
        int pageIndex = 0;
        int pageSize = 5;

        if (request.getParameter("pageIndex") != null) {
            pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        }
        int totalPage = 0;
        int count = productService.countByCategoryId(categoryId);
        if (count % pageSize == 0) {
            totalPage = count / pageSize;
        } else {
            totalPage = count / pageSize + 1;
        }

        request.setAttribute("categories", categoryService.findAll());
        request.setAttribute("totalProducts", productService.count());
        request.setAttribute("categoryId", categoryId);
        request.setAttribute("pageIndex", pageIndex);
        request.setAttribute("totalPage", totalPage);
        request.setAttribute("products", productService.findAllByCategoryId(categoryId, pageIndex, pageSize));
        return "admin/product/listProductByCategory";
    }

}
