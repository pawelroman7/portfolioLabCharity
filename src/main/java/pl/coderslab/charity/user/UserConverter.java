package pl.coderslab.charity.user;

import org.springframework.core.convert.converter.Converter;

public class UserConverter implements Converter<String, UserEntity> {
    @Override
    public UserEntity convert(String s) {
        return null;
    }
}
