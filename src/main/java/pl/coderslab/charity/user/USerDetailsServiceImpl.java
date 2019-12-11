package pl.coderslab.charity.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class USerDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public USerDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity userEntity = userService.findByUserEmail(email);
        if(userEntity == null) {
            throw new UsernameNotFoundException(email);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role : userEntity.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(userEntity.getEmail(), userEntity.getPassword(), grantedAuthorities);
    }
}
