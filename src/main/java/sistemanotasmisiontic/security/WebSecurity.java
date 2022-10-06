package sistemanotasmisiontic.security;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import sistemanotasmisiontic.services.UserService;




@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public WebSecurity(
            UserService userService,
            BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userService = userService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;

    }

    @Override
    protected void configure (HttpSecurity http) throws Exception{
        http.cors().and().csrf().disable();

        http.authorizeHttpRequests().antMatchers(HttpMethod.POST,"/users").permitAll().anyRequest().authenticated();

         http.addFilter(getAuthenticationFilter())
                 .addFilter(new AuthorizationFilter(authenticationManager()))
                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        http.addFilter(getAuthentication())
                .addFilter(new AuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

    }
    @Override
    public void configure (AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder);
    }


    public AutheticationFilter getAuthenticationFilter() throws Exception {
        final AutheticationFilter autheticationFilter = new AutheticationFilter(authenticationManager());
        autheticationFilter.setFilterProcessesUrl(SecurityConstants.LOGIN_URL);
        return autheticationFilter;
    }

    public AutheticationFilter getAuthentication() throws Exception {
        final AutheticationFilter autheticationFilter = new AutheticationFilter(authenticationManager());
        autheticationFilter.setFilterProcessesUrl(SecurityConstants.STUDENT_URL);
        return autheticationFilter;
    }

}
