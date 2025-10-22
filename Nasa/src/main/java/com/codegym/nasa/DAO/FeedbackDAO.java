package com.codegym.nasa.DAO;


import com.codegym.nasa.model.Feedback;
import com.codegym.nasa.until.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.time.LocalDate;
import java.util.List;

public class FeedbackDAO {
    public void save(Feedback fb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(fb);
        tx.commit();
        session.close();
    }

    public List<Feedback> getTodayFeedbacks() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Feedback> list = session.createQuery(
                        "from Feedback f where f.createdDate = :today", Feedback.class)
                .setParameter("today", LocalDate.now())
                .list();
        session.close();
        return list;
    }

    public void like(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Feedback fb = session.get(Feedback.class, id);
        if (fb != null) {
            fb.setLikes(fb.getLikes() + 1);
            session.update(fb);
        }
        tx.commit();
        session.close();
    }
}