package com.example.finalprojectrpo.service;

import com.example.finalprojectrpo.model.Permission;
import com.example.finalprojectrpo.model.User;
import com.example.finalprojectrpo.repository.PermissionRepository;
import com.example.finalprojectrpo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service

public class MyService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private PermissionRepository permissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User check = userRepository.findByEmail(username);
        if (Objects.nonNull(check)) {
            return check;
        }
        throw new UsernameNotFoundException("user not found");
    }

    public void regitr(User user) {
        User check = userRepository.findByEmail(user.getEmail());
        if (check == null){
            List<Permission> permissions = List.of(permissionRepository.findByName("ROLE_ADMIN"));
            user.setPermissions(permissions);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        }
    }
}
