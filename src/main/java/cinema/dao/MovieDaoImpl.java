package cinema.dao;

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
    public Movie add(Movie movie) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Long itemId = (Long) session.save(movie);
            transaction.commit();
            movie.setId(itemId);
            return movie;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't add movie entity ", e);
        }
    }

    @Override
    public List<Movie> getAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<Movie> getAllFilms = session.createQuery("from Movie", Movie.class);
            return getAllFilms.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Can't get all movies", e);
        }
    }
}
