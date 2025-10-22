package com.codegym.Musix.service;

import com.codegym.HibernateUtil;
import com.codegym.Musix.model.Song;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class SongService {
    public void saveSong(Song song) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(song);
        tx.commit();
        session.close();
    }

    public List<Song> getAllSongs() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Song> list = session.createQuery("from Song", Song.class).list();
        session.close();
        return list;
    }

    public Song getSongById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Song song = session.get(Song.class, id);
        session.close();
        return song;
    }

    public void updateSong(Song song) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(song);
        tx.commit();
        session.close();
    }

    public void deleteSong(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        Song song = session.get(Song.class, id);
        if (song != null) session.delete(song);
        tx.commit();
        session.close();
    }
}

