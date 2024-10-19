package services.bank;

public class AccountUserData {
    public String firstName;
    public String lastName;
    public String Id;

    public AccountUserData(
            String firstName,
            String lastName,
            String Id)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.Id = Id;
    }

    public String FullName()
    {
        return firstName + " " + lastName;
    }
}
