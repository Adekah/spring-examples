package com.adekah.api;

import com.adekah.entity.User;
import com.adekah.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserApi {

    private final UserRepository userRepository;

    // or we can use this  --->>  @RequiredArgsConstructor
    public UserApi(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostConstruct
    public void init() {
        User user = new User();
        user.setName("Huseyin");
        user.setSurname("Adeka");
        user.setAdress("Istanbul/Turkey");
        user.setBirthDate(Calendar.getInstance().getTime());
        user.setId("HSY0001");
        userRepository.save(user);
    }

    @GetMapping("/{search}")
    public ResponseEntity<List<User>> getUser(@PathVariable String search) {
        List<User> users = userRepository.findByNameLikeOrSurnameLike(search, search);
        return ResponseEntity.ok(users);
    }
}
