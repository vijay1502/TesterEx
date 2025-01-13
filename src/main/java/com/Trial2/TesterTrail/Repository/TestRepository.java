package com.Trial2.TesterTrail.Repository;

import com.Trial2.TesterTrail.Domain.TestClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<TestClass,Long> {
    @Query("select a from TestClass a where a.nickName = :name")
    Optional<List<TestClass>> findByName(String name);
}
