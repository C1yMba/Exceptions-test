package md.exc.homework;

import static md.exc.homework.PersonAuthentication.checkAuthenticationData;

public class Main {
    public static void main(String[] args) {
        try {
            if (checkAuthenticationData("abdsssbs1", "ccdcdccd1", "ccdcdccd1")) {
                System.out.println("Регистрация прошла успешно");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}