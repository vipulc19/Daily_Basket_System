package dailybasket;

public class InvalidRequestException extends RuntimeException{

    public InvalidRequestException(String str){
        super(str);
    }
}
