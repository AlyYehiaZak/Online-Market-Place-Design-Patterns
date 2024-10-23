import java.util.Scanner;

public class pendingstate implements state {
    order o;
    public pendingstate(order o) {
        this.o = o;
    }
    @Override
    public boolean checkitemAvailability() {
        System.out.println("items missing: ");
    for(item i:o.missingitems){
        int wantedindex=o.getU().getCart().items.indexOf(i);
        System.out.println(o.getU().getCart().quantities.get(wantedindex)-i.stockQuantity+" items are missing of type "+i.itemname);
    }
    System.out.println("do u want to continue the order without the missing items?(y/n)");
Scanner s =new Scanner(System.in);
String c=s.nextLine();
if(c.equals("y")){
    o.setCurrentstate(o.getCs());
    for(item i:o.missingitems){
        int wantedindex=o.getU().getCart().items.indexOf(i);
        o.getU().getCart().quantities.remove(wantedindex);
        cancelitem(i);
    }
    return true;
}else{
    o.setCurrentstate(o.getPs());
    return false;
}
    }
    @Override
    public int calculatetotalamount() {
     System.out.println("order pending");
     return 0;
    }
    @Override
    public void cancelitem(item i) {
     o.ordereditems.remove(i);
    }
}
