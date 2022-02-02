package com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.dao;

import com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("dbUserDAO")
public interface DbUserDAO extends CrudRepository<User, Integer> {
}
