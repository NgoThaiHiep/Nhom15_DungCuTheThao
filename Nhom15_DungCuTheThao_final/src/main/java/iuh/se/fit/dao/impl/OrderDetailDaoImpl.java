package iuh.se.fit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iuh.se.fit.dao.OrderDetailDao;
import iuh.se.fit.entity.OrderDetail;


@Repository
@Transactional
public class OrderDetailDaoImpl implements OrderDetailDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void insert(OrderDetail orderDetail) {
        sessionFactory.getCurrentSession().save(orderDetail);

    }

    public void update(OrderDetail orderDetail) {
        // TODO Auto-generated method stub

    }

    public void delete(long orderDetailId) {
      
    }

    public List<OrderDetail> findAll(int pageIndex, int pageSize) {

        return null;
    }

    public List<OrderDetail> findByOrderId(long orderDetailId) {
        String sql = "SELECT i FROM OrderDetail i WHERE i.orders.orderId = " + orderDetailId;
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        return query.list();
    }

}
