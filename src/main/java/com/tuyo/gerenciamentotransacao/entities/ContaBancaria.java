package com.tuyo.gerenciamentotransacao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contabanco") // usado quando o nome do Database é diferente do Objeto/Classe
public class ContaBancaria {
    @Id
    private int accno;
    @Column(name = "firstname") // usado quando o nome da coluna é diferente do que está no Database
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    private int bal;

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getBal() {
        return bal;
    }

    public void setBal(int bal) {
        this.bal = bal;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "accno=" + accno +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bal=" + bal +
                '}';
    }
}
