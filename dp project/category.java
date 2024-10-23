import java.util.ArrayList;

public class category {
   private int categoryID;
   private String categoryName;
   public static int counterID=0;
   private ArrayList<item> ItemsInCategory;


public category(String categoryName, ArrayList<item> itemsInCategory) {
    
    this.categoryName = categoryName;
    ItemsInCategory = itemsInCategory;
    this.categoryID = counterID++;
}
public int getCategoryID() {
    return categoryID;
}
public void setCategoryID(int categoryID) {
    this.categoryID = categoryID;
}
public String getCategoryName() {
    return categoryName;
}
public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
}
public ArrayList<item> getItemsInCategory() {
    return ItemsInCategory;
}
public void setItemsInCategory(ArrayList<item> itemsInCategory) {
    ItemsInCategory = itemsInCategory;
}

public String saveas(){
    String listids ="";

    for(item i:this.ItemsInCategory){
        listids+=i.getItemID() +"\n";
    }

    return this.categoryID+"\n"+this.categoryName+"\n"+listids;
}
   
}
