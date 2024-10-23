import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.crypto.Data;

public class order implements orderinterface {
int orderID;
private static int countorderID=0;
user u;
LocalDate orderDate;
ArrayList<item> ordereditems=new ArrayList<item>();
double totalamount=0;
LocalDate deliveryDate;
pendingstate ps;
confirmedstate cs;
unprocessedstate us;
state currentstate;

ArrayList<item> missingitems;
int itemcount;

    public order(user u, LocalDate orderDate, ArrayList<item> ordereditems, LocalDate deliveryDate) {
    this.orderID = countorderID++;
    this.u = u;
    this.orderDate = orderDate;
    this.ordereditems = ordereditems;
    this.totalamount = calculatetotalamount();
    this.deliveryDate = deliveryDate;
    this.ps = new pendingstate(this);;
    this.cs = new confirmedstate(this);
    this.us = new unprocessedstate(this);
    this.currentstate = us;
    this.missingitems = new ArrayList<item>();
    this.itemcount = ordereditems.size();
}

    @Override
    public String toString() {
        return "order [orderID=" + orderID + ", u=" + u + ", orderDate=" + orderDate + ", ordereditems=" + ordereditems
                + ", totalamount=" + totalamount + ", deliveryDate=" + deliveryDate + ", ps=" + ps + ", cs=" + cs
                + ", us=" + us + ", currentstate=" + currentstate + ", missingitems=" + missingitems + ", itemcount="
                + itemcount + "]";
    }


public String saveas(){

    String statestr="";
    String ordereditemsstr = "";
    String missingitemsstr="";

    for(item i:this.ordereditems){
ordereditemsstr+=i.saveas();
    }

    for(item i:this.missingitems){
        missingitemsstr+=i.saveas();
    }

if(this.currentstate instanceof unprocessedstate){
    statestr = "unprocessed state";}

else if(this.currentstate instanceof pendingstate){
    statestr = "pending state";
 } else if(this.currentstate instanceof confirmedstate){
    statestr = "confirmed state";
 }




return this.orderID+"\n"+this.orderDate+"\n"+ordereditemsstr+"\n"+this.totalamount+"\n"+
this.deliveryDate+"\n"+statestr+"\n"+missingitemsstr+"\n"+this.itemcount+"\n";

}

    public int getOrderID() {
    return orderID;
}

public void setOrderID(int orderID) {
    this.orderID = orderID;
}

public user getU() {
    return u;
}

public void setU(user u) {
    this.u = u;
}

public LocalDate getOrderDate() {
    return orderDate;
}

public void setOrderDate(LocalDate orderDate) {
    this.orderDate = orderDate;
}

public ArrayList<item> getOrdereditems() {
    return ordereditems;
}

public void setOrdereditems(ArrayList<item> ordereditems) {
    this.ordereditems = ordereditems;
}

public double getTotalamount() {
    return totalamount;
}

public void setTotalamount(float totalamount) {
    this.totalamount = totalamount;
}

public LocalDate getDeliveryDate() {
    return deliveryDate;
}

public void setDeliveryDate(LocalDate deliveryDate) {
    this.deliveryDate = deliveryDate;
}

public pendingstate getPs() {
    return ps;
}

public void setPs(pendingstate ps) {
    this.ps = ps;
}

public confirmedstate getCs() {
    return cs;
}

public void setCs(confirmedstate cs) {
    this.cs = cs;
}

public unprocessedstate getUs() {
    return us;
}

public void setUs(unprocessedstate us) {
    this.us = us;
}

public state getCurrentstate() {
    return currentstate;
}

public void setCurrentstate(state currentstate) {
    this.currentstate = currentstate;
}

public int getItemcount() {
    return itemcount;
}

public void setItemcount(int itemcount) {
    this.itemcount = itemcount;
}

    @Override
    public boolean checkitemAvailability() {
        boolean miss=true;
        boolean ch=true;
     for(item i:ordereditems){
        int cur=u.getCart().items.indexOf(i);
        if(!i.checkStock(u.getCart().quantities.get(cur))){
            setCurrentstate(ps);
            missingitems.add(i);
            miss=false;
            ch=false;
        }
     }
     if(ch)
     setCurrentstate(cs);
     return miss;
    }

    @Override
    public int calculatetotalamount() {
        int sum=0;
    for(item i:ordereditems){
        int wantedindex=ordereditems.indexOf(i);
         sum+=i.price*u.getCart().quantities.get(wantedindex);
    }
    return sum;
    }
    @Override
    public void cancelitem(item i) {
        if(ordereditems.contains(i)){
      ordereditems.remove(i);
        }
    }
    
}
