// package com.example.demo.security;

// import org.springframework.security.core.userdetails.*;
// import java.util.*;

// public class CustomUserDetailsService implements UserDetailsService {

//     private final Map<String, Map<String, Object>> users = new HashMap<>();
//     private long id = 1;

//     public Map<String, Object> registerUser(String name, String email,
//                                             String password, String role) {
//         Map<String, Object> u = new HashMap<>();
//         u.put("userId", id++);
//         u.put("email", email);
//         u.put("password", password);
//         u.put("role", role);
//         users.put(email, u);
//         return u;
//     }

//     @Override
//     public UserDetails loadUserByUsername(String username) {
//         if (!users.containsKey(username))
//             throw new UsernameNotFoundException("User not found");
//         return User.withUsername(username)
//                 .password("N/A")
//                 .authorities(Collections.emptyList())
//                 .build();
//     }
// }
package com.example.demo.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class CustomUserDetailsService implements UserDetailsService {

    private final Map<String, UserDetails> users = new HashMap<>();
    private final Map<String, Map<String, Object>> userMeta = new HashMap<>();
    private final AtomicLong idGen = new AtomicLong(1);

    public Map<String, Object> registerUser(
            String name,
            String email,
            String password,
            String role) {

        Long id = idGen.getAndIncrement();

        UserDetails user = User.builder()
                .username(email)
                .password(password)
                .roles(role)
                .build();

        users.put(email, user);

        Map<String, Object> meta = new HashMap<>();
        meta.put("userId", id);
        meta.put("role", role);

        userMeta.put(email, meta);
        return meta;
    }

    @Override
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {

        if (!users.containsKey(username)) {
            throw new UsernameNotFoundException("User not found");
        }
        return users.get(username);
    }
}
