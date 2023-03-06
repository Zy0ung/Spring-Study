package study.auditing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.auditing.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member,Long> {


    @Override
    Optional<Member> findById(Long id);
}