import java.util.ArrayList;
import java.util.Date;

public class sale {
   private int saleID;
   private static int countsaleID=0;
    private ArrayList<item> itemsforsale;
    private float discountPercentage;
   private Date startdate,enddate;
   private NotificationSender ns;
@Override
public String toString() {
    
    String itemsforsalelist="";
for(item i : this.itemsforsale){
    itemsforsalelist+=i.getItemname()+"\n";
}

return "New SALE:------>"+this.saleID+" "+itemsforsalelist+"\n"+"discount percentages for these items: "+
this.discountPercentage+"\n"+"Date Sale Started :"+this.startdate+"\n"+"Date Sale ends:"+this.enddate+"\n";

}
public String iterateitems(){
    String res=" ";
    for(item i:itemsforsale){
        res+=i.toString()+" ";
    }
    return res;
}
public sale(ArrayList<item> itemsforsale, float discountPercentage, Date startdate, Date enddate) {
    this.saleID = countsaleID++;
    this.itemsforsale = itemsforsale;
    this.discountPercentage = discountPercentage;
    this.startdate = startdate;
    this.enddate = enddate;
    applydiscount();
    ns=Database.getinstance().NotiSender;
}
public int getSaleID() {
    return saleID;
}
public void setSaleID(int saleID) {
    this.saleID = saleID;
}
public ArrayList<item> getItemsforsale() {
    return itemsforsale;
}
public void setItemsforsale(ArrayList<item> itemsforsale) {
    this.itemsforsale = itemsforsale;
}
public float getDiscountPercentage() {
    return discountPercentage;
}
public void setDiscountPercentage(float discountPercentage) {
    this.discountPercentage = discountPercentage;
}
public Date getStartdate() {
    return startdate;
}
public void setStartdate(Date startdate) {
    this.startdate = startdate;
}
public Date getEnddate() {
    return enddate;
}
public void setEnddate(Date enddate) {
    this.enddate = enddate;
}
public void applydiscount(){
for(item i:itemsforsale){
    i.price-=(i.price*(discountPercentage/100));
    i.sale=true;
}
}
public void discarddiscount(){
for(item i:itemsforsale){
    if(i.sale)
    i.price=(i.price/(1-(discountPercentage/100)));
}
}
public void notifyusers(){
    ns.notification(this.toString());
}
}
