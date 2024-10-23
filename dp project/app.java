import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;


public class app {
  public static boolean check=true;
  public static boolean check2=true;
  public static boolean check5=true;
    static boolean adminUser=false;
    static admin Admin=new admin("admin", "admin123");
    static adminFacade AdminFacade=new adminFacade(Admin);
    static user u2;
    static shoppingcart myCart=null;
    static order myOrder=null;
    static NotificationSender nf=new NotificationSender();

  public static void loginPage(){
        
        System.out.println("**********************Welcome To Our Store ********************************");
      while(check){
        Scanner s=new Scanner(System.in);
        System.out.println("Press 1 for registration 2 for login 3 to close program");
        int choice=s.nextInt();
        switch (choice) {
        case 1:
          user u=new user();
          u.register();
          //nf.subscribe(u);
          System.out.println("Registration Completed You can login In");
          break;

        case 2:
        Scanner s2=new Scanner(System.in);
          String Username,Password;
          System.out.println("Enter Username");
          Username=s2.nextLine();
          System.out.println("Enter Password");
          Password=s2.nextLine();
          if(Username.equals("admin")&& Password.equals("admin123")){
             adminUser=true;
             check=false;
            //adminPage();
            break;
          }else 
          {
            u2=user.login(Username, Password);
            if(u2==null){

            }else{
              myCart=new shoppingcart(u2);
              check=false;
            }
            break;
          }
      case 3:
      return ;
        default:
          System.out.println("Invalid Input");
      }
      }
      }

      public static void adminPage(){
          Scanner s3=new Scanner(System.in);
        
      if(adminUser){
        System.out.println("***********Welcome Admin*************");
        while(check2){
          System.out.println("Press (1) to add Category (2) to Update Category (3) to Delete Category (4) to add item (5) to add sale (6) to deleteUser (7) to show Orders (8) to check stock (9) to logout");
          int choice2=s3.nextInt();
          switch (choice2) {
            case 1:
              AdminFacade.manageCategory(1);
              break;
            
            case 2:
              AdminFacade.manageCategory(2);
              break;

              case 3:
                AdminFacade.manageCategory(3);
              break;

              case 4:
                AdminFacade.manageinventory(1);
              break;

              case 5:
                AdminFacade.manageinventory(2);
              break;

              case 6:
                System.out.println("Enter Id of user to delete");
                Scanner s10=new Scanner(System.in);
                int cho=s10.nextInt();
                AdminFacade.deleteuser(cho);
              break;

              case 7:
                Admin.showorders();
              break;

              case 8:
                AdminFacade.manageinventory(3);
              break;

              case 9:
              loginPage();
              check2=false;
              break;
          
            default:
            System.out.println("Invalid Choice");
              break;
          }
        }
      }
      }

      public static void userPage(){
        
        Scanner s4=new Scanner(System.in);
       

        while(check5){
          System.out.println("Press (1) to browse Categories (2) to add item to cart (3) to create order (4) to Cancel Order (5) to remove item from cart (6) to view your cart (7) to update personal info (8) to view personal info (9) to add feedback to item (10) to view feedbacks (11) to view notifications (12) to logout (13) to close program");
          int choice3=s4.nextInt();
          switch (choice3) {
            case 1:
              u2.browsecategories();
              break;
            case 2:
              System.out.println("Enter Item Id then quantity");
              Scanner s5=new Scanner(System.in);
              Scanner s11=new Scanner(System.in);
              int itemm=s5.nextInt();
              int quan=s11.nextInt();
              myCart.additem(itemm, quan);
              break;
            case 3:
              myOrder=myCart.createorder();
              System.out.println("Order Created");
              break;
            case 4:
              myOrder=null;
              System.out.println("Order Deleted");
              break;
            case 5:
              System.out.println("Enter Id of item to remove from cart");
              Scanner s12=new Scanner(System.in);
              int num=s12.nextInt();
              myCart.removeitem(num);
              break;
            case 6:
              myCart.showCart();
              break;
            case 7:
              u2.updatepersonalinfo();
              break;
            case 8:
              u2.displayInfo();
              break;
            case 9:
              System.out.println("Enter item id of item you want to feedback");
              Scanner s13=new Scanner(System.in);
              int id=s13.nextInt();
              System.out.println("Write your feedback");
              Scanner s14=new Scanner(System.in);
              String temp=s14.nextLine();
              u2.addfeedback(id, temp);
              System.out.println("Thanks for Giving your feedback");
              break;
            case 10:
              System.out.println("Enter item id");
              Scanner s15=new Scanner(System.in);
              int i=s15.nextInt();
              item tempp=null;
              for(int l=0;l<Database.getinstance().categories.size();l++){
                  for(int m=0;m<Database.getinstance().hm.get(i).size();m++){
                      if(Database.getinstance().hm.get(l).get(m).getItemID()==i){
                          tempp=Database.getinstance().hm.get(l).get(m);
                      }
                      }
                  }
              tempp.viewfeedback();
              break;
            case 11:
              u2.readnotifications();
              break;
            case 12:
                loginPage();
                check5=false;
              break;
          case 13:

          return;
            default:
            System.out.println("Invalid Choice");
              break;
          }
        }

      }
    public static void main(String[] args) { 
 
      loginPage();
      adminPage();


      userPage();

      Database.getinstance().savechanges();

}
}


