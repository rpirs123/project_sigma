package org.example.register;


import org.example.User;
import org.example.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private UserRepository userRepository;

    public RegisterService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
        validateEmail(user.getEmail());

        return user;
    }

   void validateEmail(String email){
        if(userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("Email already exists");
        }
    }
}
