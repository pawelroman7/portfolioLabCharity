package pl.coderslab.charity.user;

public interface UserService {

    void saveUser(UserEntity userEntity);
    UserEntity findByUserEmail(String email);
}
