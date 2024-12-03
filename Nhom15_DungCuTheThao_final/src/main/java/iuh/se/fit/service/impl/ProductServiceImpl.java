package iuh.se.fit.service.impl;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.se.fit.dao.ProductDao;
import iuh.se.fit.entity.Product;
import iuh.se.fit.entity.ProductCategory;
import iuh.se.fit.entity.Sale;
import iuh.se.fit.model.ProductCategoryDTO;
import iuh.se.fit.model.ProductDTO;
import iuh.se.fit.model.SaleDTO;
import iuh.se.fit.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private SessionFactory sessionFactory;

    
    @Override
    public void insert(Product product, InputStream inputStream) {
        productDao.insert(product, inputStream);
    }
    
//    @Override
//    public void insert(ProductDTO productDTO, InputStream inputStream) {
//        Product product = new Product();
//        ProductCategory category = new ProductCategory();
//        category.setCategoryId(productDTO.getCategoryDTO().getCategoryId());
//        Sale sale = new Sale();
//        sale.setSaleId(productDTO.getSaleDTO().getSaleId());
//        product.setProductId(productDTO.getProductId());
//        product.setProductName(productDTO.getProductName());
////		product.setImage(productDTO.getImage());
//        product.setDescription(productDTO.getDescription());
//        product.setPrice(productDTO.getPrice());
//        product.setProductQuantity(productDTO.getProductQuantity());
//        product.setSale(sale);
//        product.setCategory(category);
//
//        productDao.insert(product, inputStream);
//    }

    @Override
    public void update(ProductDTO productDTO, InputStream inputStream) {
        Product product = new Product();
        ProductCategory category = new ProductCategory();
        category.setCategoryId(productDTO.getCategoryDTO().getCategoryId());
        Sale sale = new Sale();
        sale.setSaleId(productDTO.getSaleDTO().getSaleId());
        product.setProductId(productDTO.getProductId());
        product.setProductName(productDTO.getProductName());
//        product.setImage(productDTO.getImage());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setProductQuantity(productDTO.getProductQuantity());
        product.setSale(sale);
        product.setCategory(category);

        productDao.update(product, inputStream);
    }

    @Override
    public void delete(long productId) {
        productDao.delete(productId);
    }

    public List<ProductDTO> hotProducts(int pageIndex, int pageSize) {
        List<Product> products = productDao.hotProducts(pageIndex, pageSize);
        List<ProductDTO> productDTOs = new ArrayList<ProductDTO>();
        for (Product p : products) {
            SaleDTO saleDTO = new SaleDTO();

            saleDTO.setSaleId(p.getSale().getSaleId());
            saleDTO.setPercent(p.getSale().getPercent());

            ProductCategoryDTO productCategoryDTO = new ProductCategoryDTO();

            productCategoryDTO.setCategoryId(p.getCategory().getCategoryId());
            productCategoryDTO.setCategoryName(p.getCategory().getCategoryName());

            ProductDTO productDTO = new ProductDTO();

            productDTO.setProductId(p.getProductId());
            productDTO.setProductName(p.getProductName());

            Blob blob = p.getImage();
            if (blob != null) {
                InputStream inputStream;
                try {
                    inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    productDTO.setImage(base64Image);
                } catch (Exception ex) {
                    Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            productDTO.setDescription(p.getDescription());
            productDTO.setPrice(p.getPrice());
            productDTO.setProductQuantity(p.getProductQuantity());
            productDTO.setSaleDTO(saleDTO);
            productDTO.setCategoryDTO(productCategoryDTO);

            productDTOs.add(productDTO);
        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> featuredProducts(int pageIndex, int pageSize) {
        List<Product> products = productDao.featuredProducts(pageIndex, pageSize);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            SaleDTO saleDTO = new SaleDTO();

            saleDTO.setSaleId(product.getSale().getSaleId());
            saleDTO.setPercent(product.getSale().getPercent());

            ProductCategoryDTO categoryDTO = new ProductCategoryDTO();

            categoryDTO.setCategoryId(product.getCategory().getCategoryId());
            categoryDTO.setCategoryName(product.getCategory().getCategoryName());

            ProductDTO productDTO = new ProductDTO();

            productDTO.setProductId(product.getProductId());
            productDTO.setProductName(product.getProductName());

            Blob blob = product.getImage();
            if (blob != null) {
                InputStream inputStream;
                try {
                    inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    productDTO.setImage(base64Image);
                } catch (Exception ex) {
                    Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice());
            productDTO.setProductQuantity(product.getProductQuantity());
            productDTO.setSaleDTO(saleDTO);
            productDTO.setCategoryDTO(categoryDTO);

            productDTOs.add(productDTO);

        }
        return productDTOs;
    }

    @Override
    public ProductDTO findById(long productId) {
        Product product = productDao.findById(productId);
        SaleDTO saleDTO = new SaleDTO();

        saleDTO.setSaleId(product.getSale().getSaleId());
        saleDTO.setPercent(product.getSale().getPercent());

        ProductCategoryDTO categoryDTO = new ProductCategoryDTO();

        categoryDTO.setCategoryId(product.getCategory().getCategoryId());
        categoryDTO.setCategoryName(product.getCategory().getCategoryName());

        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId(product.getProductId());
        productDTO.setProductName(product.getProductName());

        Blob blob = product.getImage();
        if (blob != null) {
            InputStream inputStream;
            try {
                inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;

                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                productDTO.setImage(base64Image);
            } catch (Exception ex) {
                Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setProductQuantity(product.getProductQuantity());
        productDTO.setSaleDTO(saleDTO);
        productDTO.setCategoryDTO(categoryDTO);

        return productDTO;
    }

    @Override
    public List<ProductDTO> findAllByCategoryId(long categoryId, int pageIndex, int pagesize) {
        List<Product> products = productDao.findAllByCategoryId(categoryId, pageIndex, pagesize);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            SaleDTO saleDTO = new SaleDTO();

            saleDTO.setSaleId(product.getSale().getSaleId());
            saleDTO.setPercent(product.getSale().getPercent());

            ProductCategoryDTO categoryDTO = new ProductCategoryDTO();

            categoryDTO.setCategoryId(product.getCategory().getCategoryId());
            categoryDTO.setCategoryName(product.getCategory().getCategoryName());

            ProductDTO productDTO = new ProductDTO();

            productDTO.setProductId(product.getProductId());
            productDTO.setProductName(product.getProductName());

            Blob blob = product.getImage();
            if (blob != null) {
                InputStream inputStream;
                try {
                    inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    productDTO.setImage(base64Image);
                } catch (Exception ex) {
                    Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice());
            productDTO.setProductQuantity(product.getProductQuantity());
            productDTO.setSaleDTO(saleDTO);
            productDTO.setCategoryDTO(categoryDTO);

            productDTOs.add(productDTO);

        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> findAll(int pageIndex, int pageSize) {
        List<Product> products = productDao.findAll(pageIndex, pageSize);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            SaleDTO saleDTO = new SaleDTO();

            saleDTO.setSaleId(product.getSale().getSaleId());
            saleDTO.setPercent(product.getSale().getPercent());

            ProductCategoryDTO categoryDTO = new ProductCategoryDTO();

            categoryDTO.setCategoryId(product.getCategory().getCategoryId());
            categoryDTO.setCategoryName(product.getCategory().getCategoryName());

            ProductDTO productDTO = new ProductDTO();

            productDTO.setProductId(product.getProductId());
            productDTO.setProductName(product.getProductName());

            Blob blob = product.getImage();
            if (blob != null) {
                InputStream inputStream;
                try {
                    inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    productDTO.setImage(base64Image);
                } catch (Exception ex) {
                    Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice());
            productDTO.setProductQuantity(product.getProductQuantity());
            productDTO.setSaleDTO(saleDTO);
            productDTO.setCategoryDTO(categoryDTO);

            productDTOs.add(productDTO);

        }
        return productDTOs;
    }

    @Override
    public List<ProductDTO> findAllProductByName(String name, int pageIndex, int pageSize) {
        List<Product> products = productDao.findAllProductByName(name, pageIndex, pageSize);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            SaleDTO saleDTO = new SaleDTO();

            saleDTO.setSaleId(product.getSale().getSaleId());
            saleDTO.setPercent(product.getSale().getPercent());

            ProductCategoryDTO categoryDTO = new ProductCategoryDTO();

            categoryDTO.setCategoryId(product.getCategory().getCategoryId());
            categoryDTO.setCategoryName(product.getCategory().getCategoryName());

            ProductDTO productDTO = new ProductDTO();

            productDTO.setProductId(product.getProductId());
            productDTO.setProductName(product.getProductName());

            Blob blob = product.getImage();
            if (blob != null) {
                InputStream inputStream;
                try {
                    inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    productDTO.setImage(base64Image);
                } catch (Exception ex) {
                    Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice());
            productDTO.setProductQuantity(product.getProductQuantity());
            productDTO.setSaleDTO(saleDTO);
            productDTO.setCategoryDTO(categoryDTO);

            productDTOs.add(productDTO);
        }
        return productDTOs;
    }
    
    @Override
    public List<ProductDTO> search(long categoryId, String pricing, double priceFrom, double priceTo, String sort, String text, int pageIndex, int pageSize) {
        List<Product> products = productDao.search(categoryId, pricing, priceFrom, priceTo, sort, text, pageIndex, pageSize);
        List<ProductDTO> productDTOs = new ArrayList<>();
        for (Product product : products) {
            SaleDTO saleDTO = new SaleDTO();

            saleDTO.setSaleId(product.getSale().getSaleId());
            saleDTO.setPercent(product.getSale().getPercent());

            ProductCategoryDTO categoryDTO = new ProductCategoryDTO();

            categoryDTO.setCategoryId(product.getCategory().getCategoryId());
            categoryDTO.setCategoryName(product.getCategory().getCategoryName());

            ProductDTO productDTO = new ProductDTO();

            productDTO.setProductId(product.getProductId());
            productDTO.setProductName(product.getProductName());

            Blob blob = product.getImage();
            if (blob != null) {
                InputStream inputStream;
                try {
                    inputStream = blob.getBinaryStream();
                    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                    byte[] buffer = new byte[4096];
                    int bytesRead = -1;

                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                    byte[] imageBytes = outputStream.toByteArray();
                    String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                    productDTO.setImage(base64Image);
                } catch (Exception ex) {
                    Logger.getLogger(ProductServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            productDTO.setDescription(product.getDescription());
            productDTO.setPrice(product.getPrice());
            productDTO.setProductQuantity(product.getProductQuantity());
            productDTO.setSaleDTO(saleDTO);
            productDTO.setCategoryDTO(categoryDTO);

            productDTOs.add(productDTO);

        }
        return productDTOs;
    }

    @Override
    public int countBySearch(long categoryId, String pricing, double priceFrom, double priceTo, String text) {
        return productDao.countBySearch(categoryId, pricing, priceFrom, priceTo, text);
    }

    @Override
    public int countByProductName(String name) {
        return productDao.countByProductName(name);
    }
    
    @Override
    public int countByCategoryId(long categoryId) {
        String sql = "SELECT COUNT(p) FROM Product p where p.category.categoryId = " + categoryId;
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        long count = (long) query.uniqueResult();
        return (int) count;
    }

    @Override
    public int count() {
        String sql = "SELECT COUNT(p) FROM Product p";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        long count = (long) query.uniqueResult();
        return (int) count;
    }
}