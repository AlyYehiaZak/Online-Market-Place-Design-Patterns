public class feedback {
   private int feedbackID;
   private static int countfeedbackID=0;
    private user fbuser;
private String comment;
private item Item;
public feedback(user fbuser, String comment, item item) {
    this.feedbackID = countfeedbackID++;
    this.fbuser = fbuser;
    this.comment = comment;
    Item = item;
}
public int getFeedbackID() {
    return feedbackID;
}
public void setFeedbackID(int feedbackID) {
    this.feedbackID = feedbackID;
}
public user getFbuser() {
    return fbuser;
}
public void setFbuser(user fbuser) {
    this.fbuser = fbuser;
}
public String getComment() {
    return comment;
}
public void setComment(String comment) {
    this.comment = comment;
}
public item getItem() {
    return Item;
}
public void setItem(item item) {
    Item = item;
}

}
