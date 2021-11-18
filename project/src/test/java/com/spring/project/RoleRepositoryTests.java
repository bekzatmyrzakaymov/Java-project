package com.spring.project;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import com.spring.project.model.Role;
import com.spring.project.repo.RoleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
    @Autowired private RoleRepository repo;

    @Test
    public void testCreateRoles() {
        Role user = new Role("User");
        Role admin = new Role("Admin");
        Role customer = new Role("Customer");

     repo.save(user);
     repo.save(admin);
     repo.save(customer);

        List<Role> listRoles = repo.findAll();

        assertThat(listRoles.size()).isEqualTo(3);
    }
}
