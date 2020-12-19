package com.kapcb.ccc.java.comparable;

import java.time.LocalDateTime;

/**
 * <a>Title: Person </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/19 - 20:09
 */
public class Person implements Comparable<Person> {
    private Long userId;
    private String firstName;
    private String secondName;
    private String emailAddress;
    private Integer totalPoints;
    private Integer prevWeekAddPoint;
    private Integer prevWeekConsumerPoint;
    private LocalDateTime lastUpdateDate;

    public Person() {
    }

    public Person(Long userId, String firstName,
                  String secondName, String emailAddress,
                  Integer totalPoints, Integer prevWeekAddPoint,
                  Integer prevWeekConsumerPoint, LocalDateTime lastUpdateDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.secondName = secondName;
        this.emailAddress = emailAddress;
        this.totalPoints = totalPoints;
        this.prevWeekAddPoint = prevWeekAddPoint;
        this.prevWeekConsumerPoint = prevWeekConsumerPoint;
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Integer getTotalPoints() {
        return totalPoints;
    }

    public void setTotalPoints(Integer totalPoints) {
        this.totalPoints = totalPoints;
    }

    public Integer getPrevWeekAddPoint() {
        return prevWeekAddPoint;
    }

    public void setPrevWeekAddPoint(Integer prevWeekAddPoint) {
        this.prevWeekAddPoint = prevWeekAddPoint;
    }

    public Integer getPrevWeekConsumerPoint() {
        return prevWeekConsumerPoint;
    }

    public void setPrevWeekConsumerPoint(Integer prevWeekConsumerPoint) {
        this.prevWeekConsumerPoint = prevWeekConsumerPoint;
    }

    public LocalDateTime getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDateTime lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    @Override
    public String toString() {
        return "UserScore{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", totalPoints=" + totalPoints +
                ", prevWeekAddPoint=" + prevWeekAddPoint +
                ", prevWeekConsumerPoint=" + prevWeekConsumerPoint +
                ", lastUpdateDate=" + lastUpdateDate +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        return this.getTotalPoints() - person.getTotalPoints() == 0 ? (int) (this.getUserId() - person.getUserId()) : this.getTotalPoints() - person.getTotalPoints();
    }
}
