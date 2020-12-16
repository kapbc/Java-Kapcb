package com.kapcb.ccc.java.stream.test;

import com.kapcb.ccc.util.Constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * <a>Title: StringSpiltTest </a>
 * <a>Author: kapcb <a>
 * <a>Description: <a>
 *
 * @author kapcb
 * @version 1.0.0
 * @date 2020/12/16 - 20:14
 */
public class StringSpiltTest {

    private static final Logger logger = Logger.getLogger(String.valueOf(StringSpiltTest.class), Constants.COMMON_LOGGER_RESOURCE_BUNDLE.getStringStatusCode());

    public static void main(String[] args) {

        String address = "chenchengcheng@163.com,eircccallroot@163.com";
        Email email = Stream.of(address).map(s -> s.split(",")).map(e -> new Email(e[0], e[1])).findAny().orElseThrow(IllegalArgumentException::new);
        System.out.println(email);

        String testAddress = "eircccallroot@yeah.net";
        Email email1 = getEmail(testAddress);
        System.out.println("email1 = " + email1);
        String property = null;
        try (InputStream inputStream = new FileInputStream(Constants.COMMON_LOG_MESSAGE_PROPERTIES_RESOURCES_PATH.getStringStatusCode());) {
            Properties properties = new Properties();
            properties.load(inputStream);
            property = properties.getProperty("kapcb.stream.email.test");
        } catch (IOException e) {
            logger.warning(Constants.COMMON_TRY_CATCH_EXCEPTION_INFO.getStringStatusCode() + e + Constants.COMMON_TRY_CATCH_EXCEPTION_MESSAGE + e.getMessage());
            e.printStackTrace();
        }

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String result = property.replaceAll("\\{YYYYMMdd\\}", simpleDateFormat.format(new Date()));
        System.out.println("result = " + result);



    }

    private static Email getEmail(String address) {
        if (address.contains(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode())) {
            return Stream.of(address).map(s -> s.split(Constants.COMMON_STRING_SPLIT_COMMA.getStringStatusCode())).map(e -> new Email(e[0], e[1])).findAny().orElseThrow(IllegalArgumentException::new);
        }
        return new Email(address, address);
    }

    private static class Email {
        private String address;
        private String realAddress;

        public Email() {
        }

        public Email(String address, String realAddress) {
            this.address = address;
            this.realAddress = realAddress;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getRealAddress() {
            return realAddress;
        }

        public void setRealAddress(String realAddress) {
            this.realAddress = realAddress;
        }

        @Override
        public String toString() {
            return "Email: [address= " + this.address + " ,realAddress= " + this.realAddress + " ]";
        }
    }
}
