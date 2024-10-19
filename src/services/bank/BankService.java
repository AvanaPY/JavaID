package services.bank;

import developer.Developer;

public class BankService implements Bank {
    private final AccountUser accountUserService;
    private final AccountManager accountManagerService;
    public BankService(
            AccountUser accountUserService,
            AccountManager accountManagerService) {
        this.accountUserService = accountUserService;
        this.accountManagerService = accountManagerService;
    }

    @Override
    public void createInitialUsers() {
        String userA = accountUserService.createNewUser("Avery", "NotSoCool");
        Developer.DebugMessage("Made a new user: " + userA);
        String userB = accountUserService.createNewUser("Avery", "VeryCool");
        Developer.DebugMessage("Made a new user: " + userB);
        String userC = accountUserService.createNewUser("Avana", "The Coolest");
        Developer.DebugMessage("Made a new user: " + userC);
    }

    @Override
    public void openBankAccountForAllUsers() {
        for(AccountUserData userData : accountUserService.getAllUsers()) {
            var Id = accountManagerService.createNewBankAccount(userData.Id);
            Developer.DebugMessage("Made a new bank account with Id " + Id + " for user " + userData.Id + " ");
        }
    }

    @Override
    public void displayUserAccountStatus() {
        for(AccountUserData userData : accountUserService.getAllUsers()) {
            System.out.println("User: " + userData.FullName());
            for(BankAccountData accountData : accountManagerService.getBankAccountsByUserId(userData.Id)) {
                System.out.println("  Account: " + accountData.Id);
                System.out.println("    Money: €" + accountData.money);
                System.out.println("    Owner: " + accountData.ownerId);
            }
        }
    }

    @Override
    public void makeEveryoneRich() {
        for(AccountUserData userData : accountUserService.getAllUsers()) {
            for(BankAccountData accountData : accountManagerService.getBankAccountsByUserId(userData.Id)) {
                accountData.AddMoney(2000000);
            }
        }
    }
}