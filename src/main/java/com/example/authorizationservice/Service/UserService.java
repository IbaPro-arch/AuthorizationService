package com.example.authorizationservice.Service;

import com.example.authorizationservice.Entity.User;
import com.example.authorizationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


@Service
public class UserService implements UserDetailsService {

    @Autowired
     UserRepository userRepository;

    @Autowired
     PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException("User Not Found");
        }
        return new UserCustomDetails(user);
    }

    public User saveUser(@RequestBody User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if(userFromDb != null)

        {
            model.put("message", "User exists");
            return user;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Integer deleteBook(Integer id) {
        userRepository.deleteById(id);
        return id;
    }

    public List<User> allUsers() {
        return userRepository.findAll();
    }

}
