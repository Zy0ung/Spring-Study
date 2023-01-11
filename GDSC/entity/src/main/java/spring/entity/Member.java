package spring.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
//@Table(name = " ")
public class Member {

    @Id
    private Long id;
    @Column(name = "name")
    private String username;
    private int age;

    public Member() {
    }

    public Member(Long id, String username, int age) {
        this.id = id;
        this.username = username;
        this.age = age;
    }

}