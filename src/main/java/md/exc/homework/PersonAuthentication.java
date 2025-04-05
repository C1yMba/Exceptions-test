package md.exc.homework;

import java.util.function.Supplier;

public class PersonAuthentication {
    private static final String VERIFY_DATA = "^\\w+$";
    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 20;

    public static boolean checkAuthenticationData(String login, String password, String confirmPassword) throws Exception {
        validateLength(login, () -> new WrongLoginException("Недопустимая длина логина. Длина должна быть от " + MIN_LENGTH + " до " + MAX_LENGTH + " символов."));
        validatePattern(login, () -> new WrongLoginException("Логин может содержать только латинские буквы, цифры и знак подчеркивания."));

        validateLength(password, () -> new WrongPasswordException("Недопустимая длина пароля. Длина должна быть от " + MIN_LENGTH + " до " + MAX_LENGTH + " символов."));
        validatePattern(password, () -> new WrongPasswordException("Пароль может содержать только латинские буквы, цифры и знак подчеркивания."));

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Поля пароль и подтверждение пароля не совпадают!");
        }

        return true;
    }

    private static void validateLength(String value, Supplier<Exception> exceptionSupplier) throws Exception {
        if (value.length() < MIN_LENGTH || value.length() > MAX_LENGTH) {
            throw exceptionSupplier.get();
        }
    }

    private static void validatePattern(String value, Supplier<Exception> exceptionSupplier) throws Exception {
        if (!value.matches(VERIFY_DATA)) {
            throw exceptionSupplier.get();
        }
    }


}
