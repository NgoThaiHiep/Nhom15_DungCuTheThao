package iuh.se.fit.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iuh.se.fit.dao.OrderDao;
import iuh.se.fit.entity.Order;

@Repository
@Transactional
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void insert(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    public void update(Order order) {
        sessionFactory.getCurrentSession().merge(order);
    }

    @Override
    public void delete(long orderId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Order> findAll(int pageIndex, int pageSize) {
        String sql = "SELECT o FROM Order o ORDER BY o.purchaseDate DESC";
        int first = pageIndex * pageSize;
        Query query = sessionFactory.getCurrentSession().createQuery(sql).setFirstResult(first).setMaxResults(pageSize);
        return query.list();
    }

    public List<Order> findByBuyer(long userId) {
        String sql = "SELECT o FROM Order o WHERE o.user.userId = " + userId + " ORDER BY o.user.userId DESC";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        return query.list();
    }

    public int count() {
        String sql = "SELECT COUNT(o) FROM Order o";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        long count = (Long) query.uniqueResult();
        System.out.println("com.runningman.dao.impl.OrderDaoImpl.count()=====" + count);
        return (int) count;
    }

    public double sumRevenue(){
        String sql = "SELECT SUM(o.totalPrice) FROM Order o";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        double sum = (double) query.uniqueResult();
        return sum;
    }
    
    public Order findById(long orderId) {
        return (Order) sessionFactory.getCurrentSession().get(Order.class, orderId);
    }
}
