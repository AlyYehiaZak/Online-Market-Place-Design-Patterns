import java.util.Scanner;

public class info {
    Scanner s=new Scanner(System.in);
    String SSN,name,address,phone;
        public info(String sSN, String name, String address, String phone) {
        SSN = sSN;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String saveas(){
        return this.SSN+"\n"+this.name+"\n"+this.address+"\n"+this.phone+"\n";
    }
    public info() {
        }
    public String getSSN() {
        return SSN;
    }
    public void setSSN(String sSN) {
        SSN = sSN;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public info enterData(){
        String SSN,name,address,phone;
        System.out.println("enter your new SSN");
        SSN=s.nextLine();
        System.out.println("enter your new name");
        name=s.nextLine();
        System.out.println("enter your new address");
        address=s.nextLine();
        System.out.println("enter your new phone");
        phone=s.nextLine();
        return new info(SSN, name, address, phone);
    }
}
