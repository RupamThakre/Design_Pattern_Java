public class NotificationService {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification notification = factory.createNotification("EMAIL");
        notification.notifyUser();  // Output: Sending an Email Notification

        Notification notification2 = factory.createNotification("SMS");
        notification2.notifyUser();  // Output: Sending an SMS Notification
    }
}
