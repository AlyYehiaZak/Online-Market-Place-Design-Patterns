import java.util.ArrayList;
import java.util.Scanner;


public class admin {
    private int adminID;
    private static int countID=0;
    private String adminname,adminpassword;
    Scanner s=new Scanner(System.in);
    Scanner s2=new Scanner(System.in);
    Scanner s3=new Scanner(System.in);
    Database database=Database.getinstance();
    public admin(String adminname, String adminpassword) {
        this.adminID = countID++;
        this.adminname = adminname;
        this.adminpassword = adminpassword;
    }
    public int getAdminID() {
        return adminID;
    }
    public void setAdminID(int adminID) {
        this.adminID = adminID;
    }
    public String getAdminname() {
        return adminname;
    }
    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }
    public String getAdminpassword() {
        return adminpassword;
    }
    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }
    public void addcategory(String categoryName, ArrayList<item> itemsInCategory){
category cat=new category(categoryName, itemsInCategory);
database.addCategory(cat);
    }
    public void deletecategory(int id){
        database.deletecategory(id);
    }
    public void updatecategory(int id1,int id2){
database.updatecategory(id1, id2);
    }
    public void addnewitem(item i){
        database.addnewitem(i);
    }
    public void checkStock(){
        if(database.checkstock()){
            System.out.println("all available");
        }
        else{
            System.out.println("items missing");
        }
    }
    public void addnewsale(float price){
        int number,catID,itemId;
        ArrayList<item> itemss=new ArrayList<item>();
        System.out.println("how many items do u want to put up for sale");
        number=s.nextInt();
        for(int i=0;i<number;i++){
            System.out.println("(provide catID,itemID)");
        catID=s2.nextInt();
        itemId=s3.nextInt();
        for(item it:Database.getinstance().hm.get(catID)){
            if(it.getItemID()==itemId){
                itemss.add(it);

            }
        }
        } database.addsaleforitem(itemss,price);
       
    }
    public void deleteuser(user u){
        database.deleteuser(u);
    }
    public void showorders(){
        database.showorders();
    }
}
