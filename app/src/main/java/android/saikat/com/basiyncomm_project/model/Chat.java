package android.saikat.com.basiyncomm_project.model;

/**
 * Created by trisys on 15/7/18.
 */

public class Chat {
    private String message;
    private String time;
    private String message_type;
    private String message_user;

    public String getMessage_user() {
        return message_user;
    }

    public void setMessage_user(String message_user) {
        this.message_user = message_user;
    }

    public Chat(String message, String time, String message_type,String message_user) {
        this.message = message;
        this.time = time;
        this.message_type = message_type;
        this.message_user=message_user;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMessage_type() {
        return message_type;
    }

    public void setMessage_type(String message_type) {
        this.message_type = message_type;
    }
}
