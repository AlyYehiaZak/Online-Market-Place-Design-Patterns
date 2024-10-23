import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.crypto.Data;

public class shoppingcart {
 ArrayList<item> items=new ArrayList<item>();
 ArrayList<Integer> quantities=new ArrayList<Integer>();
 user u;
 
 public ArrayList<Integer> getQuantities() {
    return quantities;
}
public shoppingcart(user u) {
    this.u = u;
    u.setCart(this);
}
public void additem(int id,int quantity){
    item temp=null;
    for(int i=0;i<Database.getinstance().categories.size();i++){
        for(int j=0;j<Database.getinstance().hm.get(i).size();j++){
            if(Database.getinstance().hm.get(i).get(j).getItemID()==id){
                temp=Database.getinstance().hm.get(i).get(j);
            }
        }
    }

    if(quantity>temp.stockQuantity){
        System.out.println("Not enought items available");
    }else {
        if(!items.contains(temp)){
        items.add(temp);
        quantities.add(quantity);
        System.out.println("Item Added to Cart");
        temp.stockQuantity -= quantity;
    }
    else{
      int wantedindex=items.indexOf(temp);
      int tmp=0;
      tmp=quantities.get(wantedindex);
      tmp+=quantity;
      quantities.set(wantedindex, tmp);
      System.out.println("Item Added to Cart");
    }
    }
 }
 public void removeitem(int id){

    item temp=null;
    for(int i=0;i<Database.getinstance().categories.size();i++){
        for(int j=0;j<Database.getinstance().hm.get(i).size();j++){
            if(Database.getinstance().hm.get(i).get(j).getItemID()==id){
                temp=Database.getinstance().hm.get(i).get(j);
            }
        }
    }
    int wantedindex=items.indexOf(temp);
    quantities.remove(wantedindex);
    items.remove(wantedindex);

 }
public ArrayList<item> getItems() {
    return items;
}
public void setItems(ArrayList<item> items) {
    this.items = items;
}
public order createorder(){
    order o=new order(this.u, null, items, null);
    Database.getinstance().orders.add(o);
    return o;
}

public void showCart(){
    for(int i=0;i<items.size();i++){
        System.out.println("Item Id: "+ items.get(i).getItemID()+" Item Name: "+items.get(i).itemname+" Quanitity: "+quantities.get(i)+" Item Price: "+items.get(i).price);
    }
}
}
