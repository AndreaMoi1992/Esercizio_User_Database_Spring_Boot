package com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.repository;

import com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.model.User;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDatabase {
    static Map<Integer, User> users= new HashMap<>();
    public static int lastIndex=0;

    public static int addUser(User user){
        user.setId(++lastIndex);
        users.put(user.getId(), user);
        return 1;
    }

    public static User getUserById(int id) {
        return users.get(id);
    }

    public static void sostituisciParametro(int id, User user){
        users.replace(id, user);
    }

    public static int numeroElementiDb(){
        return users.size();
    }

    public static int updateUser(int id, User user) {
        user.setId(id);
        users.put(id, user);
        return 1;
    }

    public static int deleteUser(int id) {
        users.remove(id);
        return 1;
    }
}
