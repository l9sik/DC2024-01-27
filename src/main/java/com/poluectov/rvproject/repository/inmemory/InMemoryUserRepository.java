package com.poluectov.rvproject.repository.inmemory;

import com.poluectov.rvproject.dto.user.UserRequestTo;
import com.poluectov.rvproject.model.User;
import com.poluectov.rvproject.repository.UserRepository;
import com.poluectov.rvproject.utils.dtoconverter.DtoConverter;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class InMemoryUserRepository extends InMemoryRepository<User, UserRequestTo> implements UserRepository {

    public InMemoryUserRepository(DtoConverter<UserRequestTo, User> convert) {
        super(convert);
    }
}
