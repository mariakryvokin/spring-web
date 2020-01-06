package app.services;

import app.models.User;
import app.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> saveAll(Iterable<User> users) {
        return userRepository.saveAll(users);
    }

    public boolean exists(User user){
        return userRepository.exists(Example.of(user));
    }

    public int countBookedTickets(long userId){
        return userRepository.countBookedTickets(userId);
    }

    public void remove(Long userId){
        userRepository.deleteById(userId);
    }

    public User getById(Long userId){
        return userRepository.getOne(userId);
    }

    public User getUserByEmail(String email){
        return userRepository.getUserByEmail(email);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
