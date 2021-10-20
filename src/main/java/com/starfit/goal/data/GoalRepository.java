package com.starfit.goal.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.starfit.goal.model.Goal;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Long> {
	/**
	 * 목표 정보 가져오기 
	 * @return
	 * @throws Exception
	 */
//	List<Goal> findList() throws Exception;	
	
	/**
	 * 아이디로 목표 정보 확인하기
	 * @param goalId
	 * @return
	 * @throws Exception
	 */	
	
	/**
	 * 목표 정보 변경하
	 * @param sampleGoal
	 * @return
	 * @throws Exception
	 *///	UserGoal findById(String userGoalId) throws Exception;
	
}
