package com.dal.universityPortal.service;

import com.dal.universityPortal.model.Payment;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidatorServiceImpl implements CardValidatorService {
    @Override
    public Boolean isValid(Payment payment) throws SQLException {
        /*
        *   Visa : 13 or 16 digits, starting with 4.
            MasterCard : 16 digits, starting with 51 through 55.
            Discover : 16 digits, starting with 6011 or 65.
            American Express : 15 digits, starting with 34 or 37.
            Diners Club : 14 digits, starting with 300 through 305, 36, or 38.
            JCB : 15 digits, starting with 2131 or 1800, or 16 digits starting with 35.
        * */
        String cardNumber = payment.getCardNumber();
        List<String> cardNumberList = new ArrayList<String>();
        cardNumberList.add(cardNumber);
        String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
                "(?<mastercard>5[1-5][0-9]{14})|" +
                "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
                "(?<amex>3[47][0-9]{13})|" +
                "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
                "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
        Pattern pattern = Pattern.compile(regex);
        for (String cardNum : cardNumberList){
            cardNum = cardNum.replace("-","");
            Matcher match = pattern.matcher(cardNum);
            if(match.matches()) {
                int[] arrayCardNumber = new int[cardNumber.length()];
                for (int i = 0; i < cardNumber.length(); i++) {
                    arrayCardNumber[i] = Integer.parseInt(cardNumber.substring(i, i + 1));
                }
                for (int i = arrayCardNumber.length - 2; i >= 0; i = i - 2) {
                    int j = arrayCardNumber[i];
                    j = j * 2;
                    if (j > 9) {
                        j = j % 10 + 1;
                    }
                    arrayCardNumber[i] = j;
                }
                int sum = 0;
                for (int i = 0; i < arrayCardNumber.length; i++) {
                    sum += arrayCardNumber[i];
                }
                if (sum % 10 == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
