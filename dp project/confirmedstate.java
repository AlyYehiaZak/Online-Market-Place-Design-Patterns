public class confirmedstate implements state {
    order o;
    public confirmedstate(order o) {
        this.o = o;
    }
    @Override
    public boolean checkitemAvailability() {
return true;
    }
    @Override
    public int calculatetotalamount() {
        int sum=0;
        for(item i:o.ordereditems){
             sum+=i.price;
        }
        return sum;
    }
    @Override
    public void cancelitem(item i) {
       return;
    }
}
