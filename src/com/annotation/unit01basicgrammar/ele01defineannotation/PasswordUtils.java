package com.annotation.unit01basicgrammar.ele01defineannotation;

import java.util.List;

/**
 * 目前注解存在但是并不会有什么效果，需要unit02中讲到的注解处理器
 */
public class PasswordUtils {

    @UseCase(id = 47, description = "密码必须包含至少一个数字")
    public boolean validatePassword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }

    @UseCase(id = 49, description = "新密码不能与之前的任何一个相同")
    public Boolean checkForNewPassword(List<String> prevPasswords, String Password) {
        return !prevPasswords.contains(Password);
    }

}
