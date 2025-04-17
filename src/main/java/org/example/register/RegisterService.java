package org.example.register;


import org.example.User;
import org.example.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private UserRepository userRepository;
    private BCryptPasswordEncoder passwordEncoder;

    public RegisterService(UserRepository userRepository,BCryptPasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

   public User registerUser(User user){
        validateEmail(user.getEmail());
        encryptPassword(user.getPassword(),user);

        return user;
    }

   void validateEmail(String email){
        if(userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("Email already exists");
        }
    }


   void encryptPassword(String password,User user){
       String hashedPassword = passwordEncoder.encode(password);
       user.setPassword(hashedPassword);
    }
}
