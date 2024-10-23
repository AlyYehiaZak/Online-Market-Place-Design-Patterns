import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

public class Database {
    ArrayList<category> categories=new ArrayList<category>();
    ArrayList<order> orders=new ArrayList<order>();
    ArrayList<sale> sales=new ArrayList<sale>();
    ArrayList<user> users=new ArrayList<user>();
    ArrayList<user> subscribers=new ArrayList<user>();
    NotificationSender NotiSender=NotificationSender.getinstance(subscribers);
    HashMap<Integer,ArrayList<item>> hm=new HashMap<Integer,ArrayList<item>>();
    private Database(){}
    private static Database b;
    public static Database getinstance(){
        if(b==null){
            b=new Database();
        }
        return b;
    }
    public ArrayList<category> getCategories() {
        return categories;
    }
    public void setCategories(ArrayList<category> categories) {
        this.categories = categories;
    }
    public ArrayList<order> getOrders() {
        return orders;
    }
    public void setOrders(ArrayList<order> orders) {
        this.orders = orders;
    }
    public ArrayList<sale> getSales() {
        return sales;
    }
    public void setSales(ArrayList<sale> sales) {
        this.sales = sales;
    }
    public ArrayList<user> getUsers() {
        return users;
    }
    public void setUsers(ArrayList<user> users) {
        this.users = users;
    }
    public void addCategory(category c){
        categories.add(c);
        hm.put(c.getCategoryID(),c.getItemsInCategory());
    }
    public void deletecategory(int id){
        hm.remove(id);
        categories.remove(categories.get(id));
    }
    public void updatecategory(int id1,int id2){
        ArrayList<item> v=hm.get(id1);
        item v2=v.get(id2);
        Scanner s=new Scanner(System.in);
        String question;
        String descriptionupdate,nameupdate;
        System.out.println("Enter (description) or (name) to update Item");
        question=s.nextLine();
        if(question.equals("description")){
            System.out.println("Enter New Description");
            descriptionupdate=s.nextLine();
            v2.description=descriptionupdate;
        }
        else{
            System.out.println("Enter New Name");
            nameupdate=s.nextLine();
            v2.itemname=nameupdate;
        }
    }
    public void addnewitem(item i){
    for(category c:categories){
        if(i.categoryID==c.getCategoryID()){
            c.getItemsInCategory().add(i);
            System.out.println("Item added!");
            hm.get(i.categoryID).add(i);
            return;
        }
    }
    System.out.println("Category Invalid");
    }
    public boolean checkstock(){
        for(category c:categories){
for(item i:c.getItemsInCategory()){
    if(i.checkStock()==false){
        return false;
    }
}
        }
        return true;
    }
    public void addsaleforitem(ArrayList<item> items,float percentage){
for(item i:items){
    sale s=new sale(items, percentage, null, null);
    s.notifyusers();
    sales.add(s);
}
    }
    public void deleteuser(user u){
        System.out.println("User Removed");
        users.remove(u);
    } 
    public void showorders(){
        for(order o:orders){
            System.out.println(o.toString());
        }
    }


    public void savechanges(){
        try{

            FileWriter writeitemdata = new FileWriter("F:/new projects/dp project/data files/iteminfo.txt");


            for(category c:b.categories){

    for(item i: c.getItemsInCategory()){
writeitemdata.append(i.saveas());
    }
}
writeitemdata.close();
    

FileWriter writecatdata = new FileWriter("F:/new projects/dp project/data files/catinfo.txt");
for(category c: categories){
    writecatdata.append(c.saveas());
}
writecatdata.close();


FileWriter saveorders = new FileWriter("F:/new projects/dp project/data files/iordersinfo.txt");
for(order o :orders){
    saveorders.append(o.saveas());
}

saveorders.close();

}
catch(IOException e){
    System.out.println("IOException occured");
}

}

}
