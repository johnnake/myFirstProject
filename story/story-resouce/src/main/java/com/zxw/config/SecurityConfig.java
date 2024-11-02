package com.zxw.config;

import com.zxw.filter.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //在内存中配置一个用户
//    @Bean
//    public UserDetailsService userDetailsService(){
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.withUsername("zs").password("123").authorities("p1","p2").build());
//        manager.createUser(User.withUsername("ls").password("123").authorities("p1").build());
//        return manager;
//    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //调整安全配置
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();//关闭csrf
        http.authorizeRequests().antMatchers("/res/res1").authenticated();
        http.authorizeRequests().antMatchers("/res/res2").hasAuthority("p2");
        http.authorizeRequests().antMatchers("/bill-admin/**").hasAuthority("custom");
        http.authorizeRequests().antMatchers("/category/**").hasAuthority("custom");
        http.authorizeRequests().antMatchers("/knowledge/**").hasAuthority("custom");
        //用户管理相关接口的权限控制
        http.authorizeRequests().antMatchers("/user/list").hasAuthority("admin");
        http.authorizeRequests().antMatchers("/user/updateUserType").hasAuthority("admin");
        http.authorizeRequests().antMatchers("/user/deleteUser").hasAuthority("admin");
        http.authorizeRequests().antMatchers("/res/**").permitAll();
        http.authorizeRequests().anyRequest().permitAll();

        http.exceptionHandling().authenticationEntryPoint(new NoLoginHandler()).accessDeniedHandler(new NoAuthHandler());
        //增加自定义的过滤器
        http.addFilterBefore(new TokenFilter(), UsernamePasswordAuthenticationFilter.class);
        //spring securituy 解决跨域
        http.cors().configurationSource(corsConfigurationSource());
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    private CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedHeader("Content-Type");
        corsConfiguration.addAllowedHeader("Authorize");
        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
        corsConfigurationSource.registerCorsConfiguration("/**",corsConfiguration);
        return corsConfigurationSource;
    }

}
