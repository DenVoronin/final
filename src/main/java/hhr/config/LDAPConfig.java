package hhr.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class LDAPConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
    @Value("${ldap.urls}")
    private String ldapUrls;

    @Value("${ldap.base.dn}")
    private String ldapBaseDn;

    @Value("${ldap.username}")
    private String ldapSecurityPrincipal;

    @Value("${ldap.password}")
    private String ldapPrincipalPassword;

    @Value("${ldap.user.dn.pattern}")
    private String ldapUserDnPattern;

    @Override

        protected void configure(HttpSecurity http) throws Exception {
            http
                     .authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin()
                    .and()
                    .cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                    .and()
                    .csrf()
                    .disable();


        }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .ldapAuthentication()
                .contextSource()
                .url(ldapUrls +"/" +ldapBaseDn)
                .managerDn(ldapSecurityPrincipal)
                .managerPassword(ldapPrincipalPassword)
               .and()
                .userDnPatterns(ldapUserDnPattern);
    }
}
