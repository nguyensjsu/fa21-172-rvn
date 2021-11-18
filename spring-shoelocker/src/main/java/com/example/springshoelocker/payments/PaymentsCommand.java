package com.example.springshoelocker.payments;


import java.util.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import lombok.RequiredArgsConstructor;
import javax.validation.*;

@Entity
@Table(name="Payments")
@Data
@RequiredArgsConstructor
class PaymentsCommand {

    private @Id @GeneratedValue Long id;

    transient private String action ;
    private String firstname ;
    private String lastname ;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String cardnum;
    private String cardexpmon;
    private String cardexpyear;
    private String cardcvv;
    private String email;
    private String notes;

    private String orderNumber;
    private String transactionAmount;
    private String transactionCurrency;
    private String authId;
    private String authStatus;
    private String captureId;
    private String captureStatus;

    public String firstname(){return firstname;}
    public String lastname(){return lastname;}
    public String address(){return address;}   
    public String city(){return city;}
    public String state(){return state;}
    public String zip(){return zip;}
    public String phone(){return phone;}
    public String cardnum(){return cardnum;}
    public String cardexpyear(){return cardexpyear;}
    public String cardexpmon(){return cardexpmon;}
    public String cardcvv(){return cardcvv;}
    public String email(){return email;}
    public String notes(){return notes;}

    public void setOrderNumber(String s){orderNumber= s;}
    public void setTransactionAmount(String s){transactionAmount= s;}
    public void setTransactionCurrency(String s){transactionCurrency= s;}
    public void setAuthId(String s){authId= s;}
    public void setAuthStatus(String s){authStatus= s;}
    public void setCaptureId(String s){captureId= s;}
    public void setCaptureStatus(String s){captureStatus= s;}
}
