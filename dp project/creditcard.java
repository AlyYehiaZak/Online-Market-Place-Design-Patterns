import java.util.Date;
import java.util.Scanner;
public class creditcard {
    Scanner s=new Scanner(System.in);
    String cardNumber;
    float balance=0;
    Date expirationDate;
    public creditcard(String cardNumber, float balance, Date expirationDate) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.expirationDate = expirationDate;
    }
    public creditcard() {
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    public float getBalance() {
        return balance;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public Date getExpirationDate() {
        return expirationDate;
    }
    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
    public creditcard enterCC(){
        String cardnumber;
        float balance;
        System.out.println("enter your creditcard number");
        cardnumber=s.nextLine();
        System.out.println("enter your balance");
        balance=s.nextFloat();
        return new creditcard(cardNumber,balance ,null);
    }

    public String saveas(){
        return this.cardNumber+"\n"+this.balance+"\n"+this.expirationDate+"\n";
    }
}
