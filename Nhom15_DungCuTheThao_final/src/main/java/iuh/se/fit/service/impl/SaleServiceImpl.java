/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuh.se.fit.service.impl;



import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.se.fit.dao.SaleDao;
import iuh.se.fit.entity.Sale;
import iuh.se.fit.model.SaleDTO;
import iuh.se.fit.service.SaleService;

/**
 *
 * @author NgocTri
 */

@Service
@Transactional
public class SaleServiceImpl implements SaleService{

    @Autowired
	private SaleDao saleDao;
	
    @Override
    public List<SaleDTO> findAll() {
        List<Sale> sales = saleDao.findAll();
		List<SaleDTO> saleDTOs = new ArrayList<>();
		for (Sale sale : sales) {
			SaleDTO saleDTO = new SaleDTO();
			saleDTO.setSaleId(sale.getSaleId());
			saleDTO.setPercent(sale.getPercent());
			saleDTOs.add(saleDTO);
		}
		return saleDTOs;
    }
    
}
