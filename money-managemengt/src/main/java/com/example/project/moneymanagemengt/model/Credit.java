package com.example.project.moneymanagemengt.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Credit")
@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter @NoArgsConstructor
public class Credit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Name")
    private String name;
    @Column(name = "Amount")
    private  double amount;

    public Credit(String name, double amount) {
        this.name = name;
        this.amount = amount;
    }

//    public Credit(){
//
//    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }

//    @Override
//    public String toString() {
//        return "Credit{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", amount=" + amount +
//                '}';
//    }
}
