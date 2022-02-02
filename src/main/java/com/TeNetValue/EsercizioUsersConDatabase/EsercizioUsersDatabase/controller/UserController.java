package com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.controller;

import com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.model.User;
import com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.repository.InMemoryDatabase;
import com.TeNetValue.EsercizioUsersConDatabase.EsercizioUsersDatabase.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping("/{id}")
    public Optional<User> getUserByid(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    // recupero tutti gli utenti, da fare con una get
    // update user putMapping(aggiornando il parametro e dati di aggiornamento
    //allUsers - GET
    @GetMapping("/")
    public Iterable<User> allUsers() {
        return userService.allUsers();
    }

    @PutMapping("/modifica/{user}")
    public String sostituisciParametro(@PathVariable("user") User user){
        int id=user.getId();
        InMemoryDatabase.sostituisciParametro(id,user);
        return "elemento con id: "+id+" sostituito";
    }

    @PutMapping("/{id}")
    public String updateUser(@PathVariable("id") int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }

}
