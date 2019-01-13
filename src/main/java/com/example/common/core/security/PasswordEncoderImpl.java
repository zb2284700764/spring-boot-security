package com.example.common.core.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 自定义密码加密策略实现类
 * 暂时还没用
 */
public class PasswordEncoderImpl implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (encodedPassword != null && encodedPassword.length() > 0) {
            return rawPassword.equals(encodedPassword);
        }
        return false;
    }
}
