package cinema.dao.impl;

import cinema.dao.OrderDao;
import cinema.exception.DataBaseException;
import cinema.model.Order;
import cinema.model.User;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDaoImpl implements OrderDao {
    private final SessionFactory sessionFactory;

    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Order add(Order order) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(order);
            transaction.commit();
            return order;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBaseException("Can't add order entity " + order, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Order> getOrderHistory(User user) {
        try (Session session = sessionFactory.openSession()) {
            Query<Order> getOrderHistory = session.createQuery("select distinct o "
                    + "from Order o join fetch o.tickets where o.user =: user", Order.class);
            getOrderHistory.setParameter("user", user);
            return getOrderHistory.getResultList();
        } catch (Exception e) {
            throw new DataBaseException("Can't get order history of user " + user, e);
        }
    }
}
