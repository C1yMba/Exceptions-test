package md.exc.homework;

public class WrongPasswordException extends Exception{
    public WrongPasswordException(String s) {
        super(s);
    }
}
