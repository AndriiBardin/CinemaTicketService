package cinema.dao.impl;

import cinema.dao.MovieSessionDao;
import cinema.exception.DataBaseException;
import cinema.model.MovieSession;
import java.time.LocalDate;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl implements MovieSessionDao {
    private final SessionFactory sessionFactory;

    public MovieSessionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public MovieSession add(MovieSession movieSession) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(movieSession);
            transaction.commit();
            return movieSession;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBaseException("Can't add movie session entity " + movieSession, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<MovieSession> getAvailable(Long movieId, LocalDate date) {
        try (Session session = sessionFactory.openSession()) {
            Query<MovieSession> query = session.createQuery("from MovieSession ms "
                            + "inner join fetch ms.movie m "
                            + "where m.id = :movieId "
                            + "and DATE_FORMAT(ms.date,'%Y-%m-%d') = :date",
                    MovieSession.class);
            query.setParameter("movieId", movieId);
            query.setParameter("date", date.toString());
            return query.getResultList();
        } catch (Exception e) {
            throw new DataBaseException("Cannot find movie session with movie id " + movieId
                    + " and date " + date, e);
        }
    }
}
