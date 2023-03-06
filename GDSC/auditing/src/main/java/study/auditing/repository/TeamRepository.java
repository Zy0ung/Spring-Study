package study.auditing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.auditing.entity.Team;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team,Long> {

    @Override
    Optional<Team> findById(Long id);
}