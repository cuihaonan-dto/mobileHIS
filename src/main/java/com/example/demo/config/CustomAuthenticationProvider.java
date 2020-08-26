package com.example.demo.config;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import com.example.demo.model.UserExample;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.List;

/**
 * Creat by GG
 * Date on 2020/8/26  10:35 上午
 */
@Configuration
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired(required = false)
    UserMapper userMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getPrincipal().toString();
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);

        if (users == null || users.size() == 0) {
            throw new BadCredentialsException("查无此用户");
        }
        User user = users.get(0);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodePassword= bCryptPasswordEncoder.encode((String)authentication.getCredentials());

        if (user.getUsername() != null && bCryptPasswordEncoder.matches((String)authentication.getCredentials(),user.getPassword())) {
            Collection<? extends GrantedAuthority> authorities = AuthorityUtils.NO_AUTHORITIES;

            return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), authorities);
        } else {
            throw new BadCredentialsException("用户名或密码错误。");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
