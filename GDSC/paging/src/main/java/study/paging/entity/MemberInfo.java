package study.paging.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberInfo {

    @Id
    @GeneratedValue
    @Column(name = "memeber_info_id")
    private Long id;

    private String address;

    public MemberInfo(String address) {
        this.address = address;
    }
}