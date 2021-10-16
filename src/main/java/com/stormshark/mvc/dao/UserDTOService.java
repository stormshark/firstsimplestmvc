package com.stormshark.mvc.dao;

import com.stormshark.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository("Mysql")
public class UserDTOService implements UserDao {

    private final JdbcTemplate jdbcTemplate;
    @Autowired
    public UserDTOService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User createAUser(User user) {
        final String mySqlCreate = "INSERT INTO USER_DEF (id,name,last_name,code,email,birthdate) VALUES (?,?,?,?,?,?)";
        try {
            jdbcTemplate.update(mySqlCreate,
                    UUID.randomUUID(), user.getName(), user.getLastname(), user.getCode(), user.getEmail(), user.getBirthdate());
        } catch (Exception e) {
            System.out.println("could not insert into DB.");
        }

        return user;
    }

    @Override
    public List<User> listAllUsers() {
        final String mySqlSelect = "SELECT id, name,last_name,code,email,birthdate FROM USER_DEF";
        return jdbcTemplate.query(mySqlSelect,(resultSet, i) -> {
            UUID id = UUID.fromString(resultSet.getString("id"));
            String name = resultSet.getString("name");
            String lastname = resultSet.getString("last_name");
            String code = resultSet.getString("code");
            String email = resultSet.getString("email");
            Date birthdate = resultSet.getDate("birthdate");
            return new User(id,name,lastname,code,email,birthdate);
        });
    }

    @Override
    public User UpdateAUser(UUID UserId, User user) {
        return null;
    }

    @Override
    public void deleteAUSer(UUID UserId) {

    }

    @Override
    public User getAnUserById(UUID UserId) {
        return new User(UUID.randomUUID(),"hardCode1", "outliers","asd","email",Date.from(Instant.now()));
    }
}
