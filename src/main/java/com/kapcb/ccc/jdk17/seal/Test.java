package com.kapcb.ccc.jdk17.seal;


/**
 * <a>Title: Test </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Test <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/10/2 10:12
 */
public class Test {

    public static <person> void main(String[] args) {
        Coder mike = new Coder("Mike", "111111");
        String password = mike.password();
        System.out.println("password = " + password);
        String username = mike.username();
        System.out.println("username = " + username);
        mike.setEmail("eircccallroot@yeah.net");
        System.out.println("email = " + mike.email());

        match(new Soldier());

    }

    private static <T> void match(T t) {
        if ((t instanceof Soldier soldier) && (2 > 1)) {
            String logMessage = """
                    Hello All,
                    I'm a soldier!
                    Thanks All!
                    """;
            System.out.println(logMessage);
            soldier.run("""
                    I am a soldier, I can run!
                    """);
        } else if (t instanceof Student student) {

        }
    }
}
