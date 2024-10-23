import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.crypto.Data;

public class user {
    Scanner s=new Scanner(System.in);
   private int userID;
   public static int tracker=0;
   private String username,password;
   private ArrayList<String> notifications;
   private info i;
   private creditcard CC;
   private shoppingcart cart=new shoppingcart(this);
   private ArrayList<order> orders;
   private info in=new info();
   private creditcard tmpcc=new creditcard();

   
public creditcard getCC() {
    return CC;
}

public info getI() {
    return i;
}

public user() {
}


public void setCart(shoppingcart cart) {
    this.cart = cart;
}

public user(String username, String password, info i, creditcard cC) {
    this.userID = tracker++;
    this.username = username;
    this.password = password;
    this.notifications = new ArrayList<String>();
    this.i = i;
    CC = cC;
    this.orders = new ArrayList<order>();
}
public shoppingcart getCart() {
    return cart;
}

public int getUserID() {
    return userID;
}
public void setUserID(int userID) {
    this.userID = userID;
}
public String getUsername() {
    return username;
}
public void setUsername(String username) {
    this.username = username;
}
public String getPassword() {
    return password;
}
public void setPassword(String password) {
    this.password = password;
}
public void register(){
    String username,password;
    System.out.println("enter your username");
    username=s.nextLine();
    System.out.println("enter your password");
    password=s.nextLine();
   
    i=in.enterData();
   CC=tmpcc.enterCC();
    user u=new user(username, password, i, CC);
    Database.getinstance().users.add(u);
    NotificationSender nf=NotificationSender.getinstance(null);
    nf.subscribe(u);
}
public static user login(String username,String password){
for(user u:Database.getinstance().users){
    if(u.username.equals(username) && u.password.equals(password)){
        System.out.println("Login Succedded");
        return u;
    }
}
System.out.println("username or password incorrect");
return null;
}
public void browsecategories(){
    for(category c:Database.getinstance().categories){
        System.out.println("Category Id :"+ c.getCategoryID()+' '+"Category Name :"+c.getCategoryName());
        System.out.println("Items in this category are :");
        for(item i:c.getItemsInCategory()){
            System.out.println("Item Name: "+i.itemname+" Item Description: "+i.description+" Item Price: "+i.price+" Item Stock: "+i.stockQuantity+" Item Has Sale: "+i.sale);
        }
    }
}
public void additemtocart(item i){
cart.items.add(i);
}
public void cancelOrder(order oo){
orders.remove(oo);
Database.getinstance().orders.remove(oo);
}
public void cancelitem(int id){
   cart.removeitem(id);
}
public void updatepersonalinfo(){
    i=in.enterData();
}

public void displayInfo(){
    System.out.println("SSN: "+i.SSN+" Name: "+i.name+" Address: "+i.address+" Phone: "+ i.phone);
}
public void addfeedback(int id,String comment){
    item temp=null;
    for(int i=0;i<Database.getinstance().categories.size();i++){
        for(int j=0;j<Database.getinstance().hm.get(i).size();j++){
            if(Database.getinstance().hm.get(i).get(j).getItemID()==id){
                temp=Database.getinstance().hm.get(i).get(j);
            }
        }
    }
    feedback f=new feedback(this, comment, temp);
    temp.feedbacks.add(f);
}
public void readnotifications(){
    if(notifications.size()!=0){
        for(String s:notifications){
        System.out.println(s);
        }
        notifications.clear();
    }else {
        System.out.println("No Notifications");
    }
}

  public void recievenotifications(String s){
    notifications.add(s);
}


public String saveas(){
    String totalorders = "";

    for(order o:this.orders){
        totalorders+=o.saveas();
    }


    return this.userID+"\n"+this.username+"\n"+this.password+this.i.saveas()+this.CC.saveas()+totalorders;

}
}
