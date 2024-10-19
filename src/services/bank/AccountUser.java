package services.bank;

public interface AccountUser {
    String createNewUser(String firstName, String lastName);
    AccountUserData[] getAllUsers();
}
