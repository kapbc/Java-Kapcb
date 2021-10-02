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


        String s = switchMatch("1");
        System.out.println("s = " + s);
        String s1 = switchMatch("2");
        System.out.println("s1 = " + s1);
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

    private static String switchMatch(String value) {
        var num = switch (value) {
            case "1", "2" -> "工作";
            case "3" -> "休息1";
            case "4" -> "休息2";
            default -> throw new RuntimeException("aaaa");
        };
        return num;
    }
}
