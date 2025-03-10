package web.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import web.model.User;


import java.util.List;


@Repository
        //@Service
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.getCurrentSession();
        List<User> allUsers = session.createQuery("from User",User.class).getResultList();
        return allUsers;
    }

    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class,id);
        return user;
    }

    @Override
    public void deleteUser(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("delete from User where id=:userId");
        query.setParameter("userId",id);
        query.executeUpdate();
    }


//    public UserDaoImpl(){
//
//        users.add(new User("Vasya","Ivanov","hgfd@mail.ru"));
//        users.add(new User("Ivan","Sidorov","hdfgfd@mail.ru"));
//        users.add(new User("Petr","Petrov","hgqqqqqqfd@mail.ru"));
//    }
//
//    public List<User> getAllUsers(){
//        return users;
//    }
}
