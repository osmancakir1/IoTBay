package uts.isd.model;
import java.io.Serializable;

public class Payment implements Serializable {
    private String cardNumber;
    private String userEmail;
    private String cardExpiry;
    private String cardCVC;
    
    public Payment(String cardNumber, String userEmail, String cardExpiry, String cardCVC) {
        this.cardNumber = cardNumber;
        this.userEmail = userEmail;
        this.cardExpiry = cardExpiry;
        this.cardCVC = cardCVC; 
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCardExpiry() {
        return cardExpiry;
    }

    public void setCardExpiry(String cardExpiry) {
        this.cardExpiry = cardExpiry;
    }

    public String getCardCVC() {
        return cardCVC;
    }

    public void setCardCVC(String cardCVC) {
        this.cardCVC = cardCVC;
    }
    
    
}