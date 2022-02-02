package com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.dao;

import com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.model.User;
import com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.repository.InMemoryDatabase;
import org.springframework.stereotype.Repository;

@Repository("firstUserDAO")
public class InMemoryUserDAO implements UserDAO{

    @Override
    public int addUser(User user) {
        return InMemoryDatabase.addUser(user);
    }

    @Override
    public User getUserById(int id) {
        return InMemoryDatabase.getUserById(id);
    }

    @Override
    public int elementiDb() {
        return InMemoryDatabase.numeroElementiDb();
    }

    @Override
    public void sostituisciElemento(int id, User user){
        InMemoryDatabase.sostituisciParametro(id, user);
    }

    @Override
    public int updateUser(int id, User user){
        return InMemoryDatabase.updateUser(id, user);
    }
    @Override
    public int deleteUser(int id){
        return InMemoryDatabase.deleteUser(id);
    }
}
