package iuh.se.fit.dao;

import java.util.List;

import iuh.se.fit.entity.Sale;



public interface SaleDao {

    List<Sale> findAll();
}
