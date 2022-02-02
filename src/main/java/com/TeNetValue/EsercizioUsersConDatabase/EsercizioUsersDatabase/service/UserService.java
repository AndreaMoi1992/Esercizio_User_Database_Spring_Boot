package com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.service;

import com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.dao.DbUserDAO;
import com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.dao.UserDAO;
import com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    //UserDAO userDAO;
    DbUserDAO userDAO;

    @Autowired
    public UserService(@Qualifier("dbUserDAO") DbUserDAO userDAO){
        this.userDAO=userDAO;
    }

    public String addUser(User user){
        User result =userDAO.save(user);
        if(result!=null){
            return"Utente salvato correttamente";
        }
        return "Errore nel salvataggio dell'urente";
    }


    // Optional controlla se l'oggetto c'è o è nullo
    public Optional<User> getUser(int id){
        return userDAO.findById(id);
    }

    //public int numeroUtenti(){
    //    return userDAO.elementiDb();
    //}

    public Iterable<User> allUsers() {
        return userDAO.findAll();
    }

    public String updateUser(int id, User user) {
        user.setId(id);
        User result=userDAO.save(user);
        if(result!=null){
            return "Utente aggiornato correttamente";
        }else{
            return "Errore nell'aggiornamento dell'utente";
        }
    }

    public String deleteUser(int id) {
        Optional<User> userRecuperato=userDAO.findById(id);
        if(!userRecuperato.isPresent()){
            return "Utente non recuperato";
        }else{
            userDAO.delete(userRecuperato.get());
            return "Utente eliminato correttamente";
        }
    }
}
