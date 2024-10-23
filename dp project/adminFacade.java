import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class adminFacade {
   private admin a;
    public adminFacade(admin a) {
        this.a = a;
    }
    Scanner s=new Scanner(System.in);
    public void manageCategory(int choice){
        switch(choice){
            case 1:{
                String name;
                String iname,idescription;
                int stquantity,catID = category.counterID;
                float price;
                int number;
                ArrayList<item> itemadded=new ArrayList<item>();
                item ii;
                System.out.println("Enter the name of the category: ");
                name=s.nextLine();
                System.out.println("how many items do u want to add");
                number=s.nextInt();
                s.nextLine();
                for(int i=0;i<number;i++){
                    
                    System.out.println("Item "+(i+1)+" Name");
                    iname=s.nextLine();
                    System.out.println("Item "+(i+1)+" Description");
                    idescription=s.nextLine();
                    System.out.println("Item "+(i+1)+" Quantity");
                    stquantity=s.nextInt();
                    // System.out.println("Category Id");
                    // catID=s.nextInt();
                    System.out.println("Item "+(i+1)+" Price");
                    price=s.nextFloat();
                    s.nextLine();
                    ii=new item(iname, idescription, stquantity, catID, price);
                    itemadded.add(ii);
                }
                a.addcategory(name,itemadded);
            }
            break;
            case 2:
            {
                int id1,id2; 
                System.out.println("Enter Id of Category and Id of Item");
                id1=s.nextInt();
                id2=s.nextInt();
                a.updatecategory(id1,id2);
            }
            break;
            case 3:
            {
                int id;
                System.out.println("enter catID for category to be deleted");
                id=s.nextInt();
                a.deletecategory(id);
            }
        }
    }
    public void manageinventory(int x){
    switch(x){
            case 1:
                String name;
                String iname,idescription;
                int stquantity,catID;
                float price;
                int number;
                item ii;
                    System.out.println("Item Name");
                    iname=s.nextLine();
                    System.out.println("Item Description");
                    idescription=s.nextLine();
                    System.out.println("Item Quantity");
                    stquantity=s.nextInt();
                    System.out.println("Category Id");
                    catID=s.nextInt();
                    System.out.println("Item Price");
                    price=s.nextFloat();
                    s.nextLine();
                    ii=new item(iname, idescription, stquantity, catID, price);
                    a.addnewitem(ii);
            break;
            case 2:
            {
                float f;
                System.out.println("Enter the discount percentage");
                f=s.nextFloat();
                a.addnewsale(f);
            }
            break;
            case 3:
            {
                a.checkStock();
            }
    }
    }
    public void deleteuser(int id){
        user u=null;
        for(user it:Database.getinstance().users){
            if(it.getUserID()==id){
                u=it;
            }
        a.deleteuser(u);
    }
    }
}
