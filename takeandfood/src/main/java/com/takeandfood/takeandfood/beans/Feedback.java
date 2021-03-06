package com.takeandfood.takeandfood.beans;/*
 * @project takeandfood
 * @author vladislav on 4/21/20
 */

import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.StringJoiner;

@Entity
@Audited
@Table(name = "FEEDBACK")
public class Feedback {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private Person person;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "TEXT")
    private String text;

    @OneToOne
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    public Feedback() {}

    public Long getId() {
        return id;
    }
    public Person getPerson() {
        return person;
    }
    public Date getDate() {
        return date;
    }
    public String getText() {
        return text;
    }
    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setPerson(Person user) {
        this.person = user;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setText(String text) {
        this.text = text;
    }
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Feedback.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("user=" + person)
                .add("date='" + date + "'")
                .add("text='" + text + "'")
                .add("restaurant='" + restaurant + "'")
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return getId().equals(feedback.getId()) &&
                getPerson().equals(feedback.getPerson()) &&
                getDate().equals(feedback.getDate()) &&
                getText().equals(feedback.getText()) &&
                getRestaurant().equals(feedback.restaurant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPerson(), getDate(), getText(), getRestaurant());
    }
}
