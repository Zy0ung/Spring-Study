package study.auditing.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.time.LocalDateTime;

@MappedSuperclass //진짜 상속관계는 아니고 속성을 데이터만 공유한다.
@Getter
public class JpaBaseEntity {

    @Column(updatable = false)  //createdDate는 변경 되면 안되기 때문에 @Column(updatable = false) ,db에 값이 변경되지 않음
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


    @PrePersist  // persist 하기전에 이벤트를 발생시킨다
    public void prePersist(){

        LocalDateTime now = LocalDateTime.now();
        createdDate = now;
        updatedDate = now;  //업데이트에도 now를 쓴이유는 데이터를 미리 넣어야 나중에 쿼리를 날리거나 할 때 null값 방지

    }

    @PreUpdate
    public void preUpdate(){
        updatedDate = LocalDateTime.now();

    }
}