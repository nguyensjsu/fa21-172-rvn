package com.example.springmysql;

import lombok.*;
import javax.persistence.*;
import javax.validation.*;
import java.util.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity
@Table(name="Catalog")
@Data
@RequiredArgsConstructor
public class Catalog {

    private @Id @GeneratedValue Long id;

    private String shoe1;
    private String shoe2;
    private String shoe3;
    private int price;
    private int count;

    public String shoe1() { return shoe1; }
    public String shoe2() { return shoe2; }
    public String shoe3() { return shoe3; }


    public String individualCost(String item, String count) {
        int intCount = Integer.parseInt(count);
        if (item == "shoe1") {
            intCount *= 40;
        } else if (item == "shoe2") {
            intCount *= 50;
        } else if (item == "shoe3") {
            intCount *= 30;
        }
        return Integer.toString(intCount);
    }

    public String totalCost() {
        int shoe1cost = Integer.parseInt(individualCost("shoe1", shoe1()));
        int shoe2cost = Integer.parseInt(individualCost("shoe2", shoe2()));
        int shoe3cost = Integer.parseInt(individualCost("shoe3", shoe3()));
        return Integer.toString(shoe1cost + shoe2cost + shoe3cost);
    }

}