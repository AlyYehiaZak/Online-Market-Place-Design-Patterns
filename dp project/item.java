import java.util.ArrayList;

public class item {
    boolean sale=false;
    private int itemID;
    private static int countitemID=0;
    public String itemname,description,imgpath;
    int stockQuantity,categoryID;
    public String getItemname() {
        return itemname;
    }
    public String getDescription() {
        return description;
    }
    public float getPrice() {
        return price;
    }
    float price=0;
    @Override
    public String toString() {
        return "item [sale=" + sale + ", itemID=" + itemID + ", itemname=" + itemname + ", description=" + description
                + ", imgpath=" + imgpath + ", stockQuantity=" + stockQuantity + ", categoryID=" + categoryID
                + ", price=" + price + ", feedbacks=" + feedbacks + "]";
    }

    public String saveas(){

        String totalfeedbacks  ="";

       for(feedback  ff:this.feedbacks){
        totalfeedbacks+=ff.getFeedbackID()+"\n"+ff.getFbuser().getUserID()+"\n"+ff.getComment()+"\n"+ff.getItem().getItemID()+"\n";
       }

        return this.sale +"\n"+ this.itemID+"\n"+this.itemname+"\n"+this.description+"\n"+this.imgpath
        +"\n"+this.stockQuantity+"\n"+this.categoryID+"\n"+this.price+"\n"+totalfeedbacks;
    }
    ArrayList<feedback> feedbacks=new ArrayList<feedback>();
    public item(String itemname, String description, int stockQuantity, int categoryID,float price) {
        this.itemID = countitemID++;
        this.itemname = itemname;
        this.description = description;
        this.stockQuantity = stockQuantity;
        this.categoryID = categoryID;
        this.price=price;
    }
    public int getItemID() {
        return itemID;
    }
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    public boolean checkStock(){
 return !(stockQuantity==0);
    }
    public boolean checkStock(int amount){
        if(stockQuantity>=amount){
            stockQuantity-=amount;
            return true;
        }
        else return false;
    }
    public void viewfeedback(){
        for(feedback f:feedbacks){
            System.out.println(f.getFbuser().getUsername()+": "+f.getComment());
        }
    }
}

