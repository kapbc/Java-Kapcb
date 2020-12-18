package com.kapcb.ccc.test;

import com.kapcb.ccc.util.Constants;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <a>Title: EmailHandler </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/18 - 19:41
 */
public class EmailHandler {

    private static final Logger logger = Logger.getLogger(String.valueOf(EmailHandler.class),
            Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    /**
     * Test From score.txt Path:src/main/resource/score.txt
     *
     * @param args String[]
     */
    public static void main(String[] args) {
        Path path = Paths.get(Constants.COMMON_EMAIL_HANDLER_RESOURCES_PATH.getStringStatusCode());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(Constants.COMMON_TIME_FORMATTER_PATTERN_SECOND_NANO_24.getStringStatusCode());

        try (Stream<String> lines = Files.lines(path)) {

            Stream<UserScore> userScoreStream = lines.map(s -> s.split(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode())).
                    map(s -> new UserScore(Long.valueOf(s[0]),
                            s[1],
                            s[2],
                            s[3],
                            Integer.valueOf(s[4]),
                            Integer.valueOf(s[5]),
                            Integer.valueOf(s[6]),
                            LocalDateTime.parse(s[7], dateTimeFormatter)));

            List<String> result = userScoreStream
                    .filter(s -> isUpdateLastWeek(s.getLastUpdateDate()))
                    .filter(s -> isPositiveIntegralScore(s.getPrevWeekAddPoint(), s.getPrevWeekConsumerPoint()))
                    .map(UserScore::getFirstName)
                    .collect(Collectors.toList());

            logger.log(Level.INFO, "The Result That Should Be Send Email: " + result);
        } catch (IOException e) {
            logger.warning(Constants.COMMON_TRY_CATCH_EXCEPTION_MESSAGE.getStringStatusCode() + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Convert UserId
     *
     * @param id     long
     * @param target String
     * @return long
     */
    private long convertIdWithSuffix(long id, String target) {
        if (id < 0L) {
            return 0L;
        }
        long convertId = id;
        long operationNumber = 0L;
        switch (target) {
            case "400":
                operationNumber = -2300000000000L;
                break;
            case "170":
                operationNumber = 2300000000000L;
                break;
            case "600":
                operationNumber = -4000000000000L;
                break;
            default:
                break;
        }
        if (String.valueOf(id).startsWith(target)) {
            convertId = convertId + operationNumber;
        }
        return convertId;
    }

    /**
     * Condition Weather The Prev Week Updated Point Is Positive Integeral
     *
     * @param prevWeekAddPoint      Integer
     * @param prevWeekConsumerPoint Integer
     * @return boolean
     */
    private static boolean isPositiveIntegralScore(Integer prevWeekAddPoint, Integer prevWeekConsumerPoint) {
        if (Objects.equals(0, prevWeekAddPoint)) {
            return false;
        }
        return prevWeekAddPoint - prevWeekConsumerPoint > 0;
    }

    /**
     * Condition The LastUpdateDate Weather Is The Prev Week
     *
     * @param localDateTime LocalDateTime
     * @return boolean
     */
    private static boolean isUpdateLastWeek(LocalDateTime localDateTime) {
        Calendar calendar = Calendar.getInstance(Locale.CHINESE);
        calendar.add(Calendar.DAY_OF_YEAR, -7);
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        Date prevWeekMonday = calendar.getTime();
        Date lastUpdateDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        return lastUpdateDate.after(prevWeekMonday);
    }

    /**
     * Mapping The Static Sources File Score.txt For Test
     */
    private static class UserScore {
        private Long userId;
        private String firstName;
        private String secondName;
        private String emailAddress;
        private Integer totalPoints;
        private Integer prevWeekAddPoint;
        private Integer prevWeekConsumerPoint;
        private LocalDateTime lastUpdateDate;

        public UserScore() {
        }

        public UserScore(Long userId, String firstName,
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
    }
}
