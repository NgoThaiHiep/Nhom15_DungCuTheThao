package iuh.se.fit.dao.impl;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.IOUtils;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iuh.se.fit.dao.UserDao;
import iuh.se.fit.entity.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void insert(User user, InputStream avatar) {
        try {
            Session session = sessionFactory.getCurrentSession();
            if (avatar != null) {
                byte[] bytes = IOUtils.toByteArray(avatar);
                Blob blob = Hibernate.getLobCreator(session).createBlob(bytes);
                user.setAvatar(blob);
            }
            session.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update(User user, InputStream avatar) {
        try {
            Session session = sessionFactory.getCurrentSession();

            if (avatar != null) {
                byte[] bytes = IOUtils.toByteArray(avatar);
                Blob blob = Hibernate.getLobCreator(session).createBlob(bytes);
                user.setAvatar(blob);
            }
            session.merge(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(long userId) {
        User user = findById(userId);
        sessionFactory.getCurrentSession().delete(user);
    }

    public User findById(long userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }

    public List<User> findAll(int pageIndex, int pageSize) {
        int first = pageIndex * pageSize;
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class).setFirstResult(first).setMaxResults(pageSize);
        return criteria.list();
    }

    public User findByEmailOrPhoneAndPassword(String email, String password, boolean verity) {
        String sql = "SELECT u FROM User u WHERE (u.email = '" + email + "' or u.phone = '" + email + "') and u.password = '" + password + "'";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        return (User) query.uniqueResult();
    }

    public User loadUserByUsername(String taiKhoan) {
        String sql = "SELECT u FROM User u WHERE (u.email = '" + taiKhoan + "' or u.phone = '" + taiKhoan + "')" + " and u.verify = true";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        return (User) query.uniqueResult();
    }

    public User findByEmail(String email) {
        String sql = "SELECT u FROM User u WHERE u.email = '" + email + "'";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        return (User) query.uniqueResult();
    }

    public int count() {
        String sql = "SELECT count(u) FROM User u";
        Query query = sessionFactory.getCurrentSession().createQuery(sql);
        long count =  (long) query.uniqueResult();
        return (int) count;
    }
}
