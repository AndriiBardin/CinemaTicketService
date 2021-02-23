package cinema.dao.impl;

import cinema.dao.RoleDao;
import cinema.exception.DataBaseException;
import cinema.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl implements RoleDao {
    private final SessionFactory sessionFactory;

    public RoleDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Role role) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(role);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBaseException("Can't add role " + role, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = sessionFactory.openSession()) {
            Query<Role> findByEmail = session
                    .createQuery("from Role where roleName = :roleName", Role.class);
            findByEmail.setParameter("roleName", Role.RoleName.valueOf(roleName));
            return findByEmail.uniqueResultOptional();
        } catch (RuntimeException e) {
            throw new DataBaseException("No user role with name " + roleName, e);
        }
    }
}
