package pl.coderslab.charity.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(UserEntity userEntity) {
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        userEntity.setEnabled(1);
        Role userRole = roleRepository.findByName("ROLE_USER");
        userEntity.setRoles(new HashSet<>(Arrays.asList(userRole)));
        userRepository.save(userEntity);
    }

    @Override
    public UserEntity findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
