package com.kapcb.ccc.pattern.build;

import java.time.LocalDateTime;

/**
 * <a>Title: User </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2021/2/7-14:23
 */
public class User {

    private Long userId;
    private String email;
    private String username;
    private String password;
    private LocalDateTime birthday;

    public User() {
    }

    public User(Builder builder) {
        this.userId = builder.userId;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.birthday = builder.birthday;
    }

    public static class Builder {
        private Long userId;
        private String email;
        private String username;
        private String password;
        private LocalDateTime birthday;

        public Builder() {
        }

        public User.Builder username(String username) {
            this.username = username;
            return this;
        }

        public User.Builder password(String password) {
            this.password = password;
            return this;
        }

        public User.Builder email(String email) {
            this.email = email;
            return this;
        }

        public User.Builder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public User.Builder birthday(LocalDateTime birthday) {
            this.birthday = birthday;
            return this;
        }

        public User build() {
            return new User(this);
        }

    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
