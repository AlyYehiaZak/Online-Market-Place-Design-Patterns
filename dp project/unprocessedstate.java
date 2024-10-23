public class unprocessedstate implements state {
    order o;
    public unprocessedstate(order o) {
        this.o = o;
    }
    @Override
    public boolean checkitemAvailability() {
        boolean ret=true;
    if(!o.checkitemAvailability()){
        o.setCurrentstate(o.getPs());
        return !ret;
    }
    o.setCurrentstate(o.getCs());
    return ret;
    }
    @Override
    public int calculatetotalamount() {
     System.out.println("order is being processed");
     return 0;
    }
    @Override
    public void cancelitem(item i) {
       System.out.println("order is being processed");
       return;   
    } 
}