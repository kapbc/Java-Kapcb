package com.kapcb.ccc.java.json;

import java.time.LocalDateTime;

/**
 * <a>Title: StringConvertToJson </a>
 * <a>Author: kapcb <a>
 * <a>Description：<a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/18-14:55
 */
public class StringConvertToJson {

    public static void main(String[] args) {
        LocalDateTime birthday = LocalDateTime.of(2020, 12, 18, 15, 21, 30, 200);
        LocalDateTime createTime = LocalDateTime.of(2020, 11, 15, 13, 24, 45, 154);
        LocalDateTime updateTime = LocalDateTime.of(2016, 4, 13, 13, 45, 12, 12);
        Person kapcb = new Person("kapcb", "123456", 123456789L, birthday, createTime, updateTime);

    }

    private static class Person {
        private String username;
        private String password;
        private Long userId;
        private LocalDateTime birthday;
        private LocalDateTime createTime;
        private LocalDateTime updateTime;

        public Person() {
        }

        public Person(String username, String password, Long userId, LocalDateTime birthday, LocalDateTime createTime, LocalDateTime updateTime) {
            this.username = username;
            this.password = password;
            this.userId = userId;
            this.birthday = birthday;
            this.createTime = createTime;
            this.updateTime = updateTime;
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

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public LocalDateTime getBirthday() {
            return birthday;
        }

        public void setBirthday(LocalDateTime birthday) {
            this.birthday = birthday;
        }

        public LocalDateTime getCreateTime() {
            return createTime;
        }

        public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
        }

        public LocalDateTime getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
        }

        @Override
        public String toString() {
            return "Person: [username= " + this.username +
                    ", password= " + this.password +
                    ". userId= " + this.userId +
                    ", birthday=" + this.birthday +
                    ", createTime=" + this.createTime +
                    ", updateTime=" + this.updateTime +
                    " ]";
        }
    }
}
