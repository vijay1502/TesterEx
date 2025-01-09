package com.Trial2.TesterTrail.Repository;

import com.Trial2.TesterTrail.Domain.TestClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<TestClass,Long> {
}
