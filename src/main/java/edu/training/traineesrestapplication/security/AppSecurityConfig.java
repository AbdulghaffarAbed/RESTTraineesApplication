package edu.training.traineesrestapplication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


import static edu.training.traineesrestapplication.security.AppUserRole.ADMIN;
import static edu.training.traineesrestapplication.security.AppUserRole.TRAINER;

/**
 * This class used to configure the used URL
 * And to specify users and password for each one to use them in the authentication to log in to the app.
 * There are two users : AbdulghaffarAbed as Admin role and wisamAssi as Trainer role
 * @EnableGlobalMethodSecurity used To enable @PreAuthorize in controller instead of using multi antMatcher methods
 * We can delete @Configuration because of the using of @EnableWebSecurity annotation
 * Swagger enabled to display a json documentation contains API information
 * To access Swagger json doc. URL: http://localhost:8080/v3/api-docs
 * To access Swagger UI URL: http://localhost:8080/swagger-ui/
 */


@Configuration
@EnableWebSecurity
@EnableSwagger2
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AppSecurityConfig extends WebSecurityConfigurerAdapter {

    // Define a reference from PasswordEncoder interface which is used to encode a row of password
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AppSecurityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Configure method used to define attributes for the used http
     * Because Of our service used with non-browser clients we disable CSRF protection because we did not send
     * CSRF token generated by the server with each client request
     * antMatcher used to display web page for all users without having to log in
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "index", "/css/*", "/js/*")  // Enable all users to see the index.html page
                .permitAll()
                .anyRequest() // Enable accepting any request sends by the client
                .authenticated() // Enable authentication which done by the ID token
                .and()
                .formLogin();   // Enable form base instead of basic Auth.
        //               .httpBasic(); // to use basic authentication instead of form base authentication
    }

    /**
     * To retrieve users from database
     *
     * @return users saved in the memory after define them as UserDetails
     */


    @Override
    @Bean
    protected UserDetailsService userDetailsService() {

        UserDetails abdulghaffarAbed = User.builder().username("abdulghaffarAbed")
                .password(passwordEncoder.encode("1234"))
                .authorities(ADMIN.getGrantedAuthorities())
                .build();

        UserDetails wisam = User.builder().username("wisamAssi")
                .password(passwordEncoder.encode("wisam1234"))
                .authorities(TRAINER.getGrantedAuthorities())
                .build();


        return new InMemoryUserDetailsManager(
                abdulghaffarAbed,
                wisam
        );
    }

}