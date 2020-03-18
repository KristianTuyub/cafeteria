package com.fmat.uady.cafeteria.auth;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.fmat.uady.cafeteria.security.ApplicationUserRole.*;

@Repository("fake")
@RequiredArgsConstructor(onConstructor = @__(@Autowired)) // Autowired Constructor
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
            new ApplicationUser(
                    "das_siqueiros",
                    passwordEncoder.encode("1234"),
                    STUDENT.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),
            new ApplicationUser(
                    "ravi",
                    passwordEncoder.encode("1234"),
                    ADMIN_TRAINEE.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            ),
            new ApplicationUser(
                    "james_bond",
                    passwordEncoder.encode("007"),
                    ADMIN.getGrantedAuthorities(),
                    true,
                    true,
                    true,
                    true
            )
        );

        return applicationUsers;
    }
}
