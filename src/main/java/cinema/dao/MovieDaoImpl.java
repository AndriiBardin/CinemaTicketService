package cinema.dao;

import cinema.exception.DataBaseException;
import cinema.lib.Dao;
import cinema.model.movie.Movie;
import cinema.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

@Dao
public class MovieDaoImpl implements MovieDao {
    @Override
    public Movie add(Movie movie) throws DataBaseException {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Long itemId = (Long) session.save(movie);
            session.save(movie);
            transaction.commit();
            movie.setId(itemId);
            return movie;
        } catch (DataBaseException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataBaseException("Can't add movie entity");
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Movie> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Movie> getAllFilms = session.createQuery("from Movie", Movie.class);
            return getAllFilms.getResultList();
        } catch (DataBaseException e) {
            throw new DataBaseException("Can't get all movies");
        }
    }
}
