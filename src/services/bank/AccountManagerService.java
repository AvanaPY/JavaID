package services.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class AccountManagerService implements AccountManager {

    private final HashMap<String, BankAccountData> bankAccountDataMap;
    private final HashMap<String, ArrayList<String>> userBankAccountMap;
    public AccountManagerService()
    {
        bankAccountDataMap = new HashMap<>();
        userBankAccountMap = new HashMap<>();
    }

    @Override
    public String createNewBankAccount(String userId) {
        var bankAccountId = UUID.randomUUID().toString();
        BankAccountData accountData = new BankAccountData(bankAccountId, userId);
        bankAccountDataMap.put(bankAccountId, accountData);
        associateBankAccountWithUser(userId, bankAccountId);
        return bankAccountId;
    }

    @Override
    public BankAccountData[] getBankAccountsByUserId(String userId) {
        if (!userBankAccountMap.containsKey(userId)) {
            return new BankAccountData[0];
        }
        ArrayList<String> userAccounts = userBankAccountMap.get(userId);
        BankAccountData[] accountUserData = new BankAccountData[userAccounts.size()];
        for(int i = 0; i < accountUserData.length; i++)
        {
            accountUserData[i] = getBankAccountById(userAccounts.get(i));
        }
        return accountUserData;
    }

    public BankAccountData getBankAccountById(String accountId) {
        if (!bankAccountDataMap.containsKey(accountId)) {
            return null;
        }
        return bankAccountDataMap.get(accountId);
    }

    private void associateBankAccountWithUser(String userId, String bankAccountId)
    {
        if(!userBankAccountMap.containsKey(userId)) {
            userBankAccountMap.put(userId, new ArrayList<>());
        }
        userBankAccountMap.get(userId).add(bankAccountId);
    }
}
