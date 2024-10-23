import java.util.ArrayList;


public class NotificationSender implements Observer {
    private ArrayList<user> observers;
    private static NotificationSender ns;
    
    public NotificationSender() {
        observers=new ArrayList<user>();
    }
    public static NotificationSender getinstance(ArrayList<user> a){
        if(ns==null){ns=new NotificationSender(a);}
         return ns;
    }
    private NotificationSender(ArrayList<user> observers) {
        this.observers = observers;
    }
    @Override
    public void notification(String s) {
        for(user u:observers){
            u.recievenotifications(s);
        }
    }
    public ArrayList<user> getObservers() {
        return observers;
    }
    public void setObservers(ArrayList<user> observers) {
        this.observers = observers;
    }
    public void subscribe(user u){
        observers.add(u);
       
    }
    public void unsubscribe(user u){
        observers.remove(u);
    }
}
