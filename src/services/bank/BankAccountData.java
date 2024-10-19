package services.bank;

public class BankAccountData {
    public String Id;
    public String ownerId;
    public double money;

    public BankAccountData(String Id, String owner)
    {
        this.Id = Id;
        ownerId = owner;
        money = 0.0;
    }

    public void AddMoney(double m)
    {
        if(m < 0)
            return;
        money += m;
    }

    public void RemoveMoney(double m) throws Exception
    {
        if(m > money)
            throw new Exception("Not enough money");
        money -= m;
    }
}
