package com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.dao;

import com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.model.User;

// L'interfaccia è stata fatta per capire che con spring
// non c'è la necessità di avere classi che implementano metodi, alcuni già implementati da spring
// InMemoryUserDAO implementa i metodi dell'interfaccia

// UserService
public interface UserDAO {

    // Metodi crud: Create Read Update Delete
    public int addUser(User user);
    public User getUserById(int id);
    public int elementiDb();
    public void sostituisciElemento(int id, User user);
    public int updateUser(int id, User user);
    public int deleteUser(int id);
}
