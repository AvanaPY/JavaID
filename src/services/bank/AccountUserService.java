package services.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountUserService implements AccountUser{
    private final List<AccountUserData> userData;
    public AccountUserService()
    {
        this.userData = new ArrayList<>();
    }

    @Override
    public String createNewUser(String firstName, String lastName) {
        var Id = UUID.randomUUID().toString();
        var newUser = new AccountUserData(firstName, lastName, Id);
        userData.add(newUser);
        return newUser.Id;
    }

    @Override
    public AccountUserData[] getAllUsers() {
        return  userData.toArray(new AccountUserData[0]);
    }
}
