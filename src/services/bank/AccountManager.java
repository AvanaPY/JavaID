package services.bank;

public interface AccountManager {
    String createNewBankAccount(String userId);
    BankAccountData[] getBankAccountsByUserId(String userId);
    BankAccountData getBankAccountById(String accountId);
}