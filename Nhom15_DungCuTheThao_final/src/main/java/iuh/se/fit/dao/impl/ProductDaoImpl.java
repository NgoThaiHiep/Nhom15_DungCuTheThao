package iuh.se.fit.dao.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.IOUtils;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iuh.se.fit.dao.ProductDao;
import iuh.se.fit.entity.Product;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void insert(Product product, InputStream inputStream) {
        try {
            Session session = sessionFactory.getCurrentSession();
            if (inputStream != null) {
                byte[] bytes = IOUtils.toByteArray(inputStream);
                Blob blob = Hibernate.getLobCreator(session).createBlob(bytes);
                product.setImage(blob);
            }
            session.save(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(Product product, InputStream inputStream) {
        try {
            Session session = sessionFactory.getCurrentSession();
            if (inputStream != null) {
                byte[] bytes = IOUtils.toByteArray(inputStream);
                Blob blob = Hibernate.getLobCreator(session).createBlob(bytes);
                product.setImage(blob);
            }
            session.merge(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(long productId) {
        Product product = findById(productId);
        sessionFactory.getCurrentSession().delete(product);
    }

    public Product findById(long productId) {
        return (Product) sessionFactory.getCurrentSession().get(Product.class, productId);
    }

    public List<Product> findAll(int pageIndex, int pageSize) {
        int first = pageIndex * pageSize;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Product.class).setFirstResult(first).setMaxResults(pageSize);
        return criteria.list();
    }

    public List<Product> findAllByCategoryId(long categoryId, int pageIndex, int pageSize) {
        String sql = "SELECT p FROM Product p WHERE p.category.categoryId = " + categoryId;
        int first = pageIndex * pageSize;
        Query query = sessionFactory.getCurrentSession().createQuery(sql).setFirstResult(first).setMaxResults(pageSize);
        return query.list();
    }

    @Override
    public List<Product> findAllProductByName(String name, int pageIndex, int pageSize) {
//        String sql = "SELECT p FROM Product p WHERE p.productName LIKE '%" + name + "%'";
//        int first = pageIndex * pageSize;
//        Query query = sessionFactory.getCurrentSession().createQuery(sql).setFirstResult(first).setMaxResults(pageSize);
//        return query.list();
        String sql = null;
        Query query = null;
        int first = pageIndex * pageSize;
        if (name != null && name.trim().length() > 0) {
            sql = "SELECT p FROM Product p WHERE lower(p.productName) LIKE :pcName";
            query = sessionFactory.getCurrentSession().createQuery(sql)
                    .setFirstResult(first)
                    .setMaxResults(pageSize)
                    .setParameter("pcName", "%" + name.toLowerCase() + "%");
        } else {
            sql = "SELECT p FROM Product p";
            query = sessionFactory.getCurrentSession().createQuery(sql)
                    .setFirstResult(first)
                    .setMaxResults(pageSize);
        }
        return query.getResultList();
    }

    public int count() {
        String sql = "SELECT COUNT(p) FROM Product p";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        int count = (Integer) query.uniqueResult();
        return (int) count;
    }

    public int countByProductName(String nameProduct) {
//      String sql = "SELECT COUNT(p) FROM Product p WHERE p.productName LIKE '%" + nameProduct + "%'";
//      Query query = sessionFactory.getCurrentSession().createQuery(sql);
//      long count = (long) query.uniqueResult();
//      return (int) count;
      String sql = null;
      Query query = null;
      long count = 0;
      if (nameProduct != null && nameProduct.trim().length() > 0) {
          sql = "SELECT COUNT(p) FROM Product p WHERE lower(p.productName) LIKE :pcName";
          query = sessionFactory.getCurrentSession().createQuery(sql).setParameter("pcName", "%" + nameProduct.toLowerCase() + "%");
          count = (long) query.uniqueResult();
      }else{
          sql = "SELECT COUNT(p) FROM Product p";
          query = sessionFactory.getCurrentSession().createQuery(sql);
          count = (long) query.uniqueResult();
      }
      return (int) count;
  }

    public int countByCategoryId(long categoryId) {
        String sql = "SELECT COUNT(p) FROM Product p where p.category.categoryId = " + categoryId;
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        long count = (long) query.uniqueResult();
        return (int) count;
    }

    public List<Product> hotProducts(int pageIndex, int pageSize) {
        String sql = "SELECT p FROM Product p ORDER BY p.sale.percent DESC";
        int first = pageIndex * pageSize;
        Query query = sessionFactory.getCurrentSession().createQuery(sql).setFirstResult(first).setMaxResults(pageSize);
        return query.list();
    }

    public List<Product> featuredProducts(int pageIndex, int pageSize) {
        String sql = "SELECT p FROM Product p ORDER BY p.price ASC";
        int first = pageIndex * pageSize;
        Query query = sessionFactory.getCurrentSession().createQuery(sql).setFirstResult(first).setMaxResults(pageSize);
        return query.list();
    }

    public int countBySearch(long categoryId, String pricing, double priceFrom, double priceTo, String text) {
        String sql = "SELECT COUNT(p) FROM Product p where p.category.categoryId = " + categoryId;

        if (pricing != null && !pricing.equals("default") && !pricing.equals("")) {
            sql += " and ((p.price - (p.price * p.sale.percent / 100)) >= " + priceFrom + " and (p.price - (p.price * p.sale.percent / 100)) <= " + priceTo + ")";
        }

        if (text != null) {
            sql += " and p.productName like '%" + text + "%'";
        }
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        long count = (long) query.uniqueResult();
        return (int) count;
    }

    @Override
    public List<Product> search(long categoryId, String pricing, double priceFrom,
            double priceTo, String sort, String text, int pageIndex, int pageSize) {
        String sql = "SELECT p FROM Product p WHERE p.category.categoryId = " + categoryId;
        if (pricing != null && !pricing.equals("default") && !pricing.equals("")) {
            sql += " and ((p.price - (p.price * p.sale.percent / 100)) >= " + priceFrom + " and (p.price - (p.price * p.sale.percent / 100)) <= " + priceTo + ")";
        }

        if (text != null) {
            sql += " and p.productName like '%" + text + "%'";
        }

        if (sort != null && !sort.equals("default")) {
            sql += " ORDER BY (p.price - (p.price * p.sale.percent / 100)) " + sort;
        }

        int first = pageIndex * pageSize;
        Query query = sessionFactory.getCurrentSession().createQuery(sql).setFirstResult(first).setMaxResults(pageSize);
        return query.list();
    }
}
