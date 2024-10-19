import dicontainer.DiContainer;
import dicontainer.RegisterType;
import services.bank.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("java.version"));
        DiContainer container = new DiContainer();
        container.Register(AccountUser.class, AccountUserService.class, RegisterType.Singleton);
        container.Register(AccountManager.class, AccountManagerService.class, RegisterType.Singleton);
        container.Register(Bank.class, BankService.class, RegisterType.Singleton);

        var bank = container.ResolveInstance(Bank.class);
        bank.createInitialUsers();
        bank.openBankAccountForAllUsers();
        bank.openBankAccountForAllUsers();
        bank.makeEveryoneRich();
        bank.displayUserAccountStatus();
        System.out.println(bank);
    }
}