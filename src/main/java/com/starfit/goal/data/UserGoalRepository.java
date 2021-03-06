package com.starfit.goal.data;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starfit.goal.model.UserGoal;

@Repository
public interface UserGoalRepository extends JpaRepository<UserGoal, Long> {
	List<UserGoal> findByuserId(Long userId, Sort sort);
}
