import java.util.UUID;
public class Account implements AccountManagement{
    private  String userRole;
    private  UUID accountID;
    private String username;
    private String password;

    @Override
    public boolean validatePassword(String enteredPassword) {
        return enteredPassword.length()>=4;
    }

    @Override
    public  void changeUsername(String newUsername) {
        setUsername(newUsername);
        System.out.println("username changed to "+ getUsername()+ " successfully!");
    }

    @Override
    public void changePassword(String newPassword) {
        setPassword(newPassword);
        System.out.println("password changed successfully!");
    }

    public Account(String user,String username, String password) {
        this.userRole = user;
        this.accountID = UUID.randomUUID();
        this.username = username;
        if(validatePassword(password)) this.password = password; else System.out.println("password is invalid!");
    }
    // Getter and Setter
    public UUID getAccountID() {
        return accountID;
    }

    public void setAccountID(UUID accountID) {
        this.accountID = accountID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    // Getter and Setter
}
