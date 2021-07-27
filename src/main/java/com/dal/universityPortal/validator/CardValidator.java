package com.dal.universityPortal.validator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CardValidator implements Validator<String> {
    @Override
    public boolean isValid(String cardNumber) {
        /*
        *   Visa : 13 or 16 digits, starting with 4.
            MasterCard : 16 digits, starting with 51 through 55.
            Discover : 16 digits, starting with 6011 or 65.
            American Express : 15 digits, starting with 34 or 37.
            Diners Club : 14 digits, starting with 300 through 305, 36, or 38.
            JCB : 15 digits, starting with 2131 or 1800, or 16 digits starting with 35.
            *
            * Used Luhn algorithm
            * Algorithm: https://en.wikipedia.org/wiki/Luhn_algorithm
        * */
        List<String> cardNumberList = new ArrayList<String>();
        cardNumberList.add(cardNumber);
        String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" +
                "(?<mastercard>5[1-5][0-9]{14})|" +
                "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" +
                "(?<amex>3[47][0-9]{13})|" +
                "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" +
                "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";
        Pattern pattern = Pattern.compile(regex);
        System.out.println("lisy" + cardNumberList);
        for (String cardNum : cardNumberList){
        cardNumber = cardNumber.replace("-", "");
        System.out.println("no" + cardNumber);
        Matcher match = pattern.matcher(cardNumber);
        if (match.matches()) {
            System.out.println("length" + cardNumber.length());
            int[] arrayCardNumber = new int[cardNumber.length()];
            for (int i = 0; i < cardNumber.length(); i++) {
                arrayCardNumber[i] = Integer.parseInt(cardNumber.substring(i, i + 1));
            }
            System.out.println("old " + Arrays.toString(arrayCardNumber));
            for (int i = arrayCardNumber.length - 2; i >= 0; i = i - 2) {
                int j = arrayCardNumber[i];
                System.out.println(" I : " + i);
                System.out.println(" J : " + j);

                j = j * 2;
                if (j > 9) {
                    j = j % 10 + 1;
                }System.out.println(" J1 : " + j);
                arrayCardNumber[i] = j;
            }
            System.out.println("new " + Arrays.toString(arrayCardNumber));
            int sum = 0;
            for (int i = 0; i < arrayCardNumber.length; i++) {
                sum += arrayCardNumber[i];
            }
            System.out.println(sum);
            if (sum % 10 == 0) {
                return true;
            }
        }
        }
        return false;

    }

    @Override
    public String getErrorMessage() {
        return "Not valid card!";
    }
}
