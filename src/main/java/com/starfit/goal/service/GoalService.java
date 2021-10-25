package com.starfit.goal.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.starfit.goal.domain.GoalDomain;
import com.starfit.goal.domain.UserGoalDomain;
import com.starfit.goal.model.Goal;
import com.starfit.goal.model.UserGoal;

@Service
public class GoalService {
	@Autowired
	private GoalDomain goalDomain;
	@Autowired
	private UserGoalDomain userGoalDomain;
//	
//	@Autowired
//	private TestDomain testDomain;
	
	public ResponseEntity <List<Goal>> getGoalList() { 
		return goalDomain.getGoalList();
	}
	
	public ResponseEntity <Optional<Goal>> getGoalById(Long goalId) { 
		return goalDomain.getGoalById(goalId);
	}
	
	public ResponseEntity <String > updateGoal(Goal sampleGoal) throws Exception {
		return goalDomain.updateGoal(sampleGoal);
	}
	
	public ResponseEntity <String > insertGoal(Goal sampleGoal) throws Exception { 
		return goalDomain.insertGoal(sampleGoal);		
	}

	public ResponseEntity <String > deleteGoal(Long goalId) throws Exception { 
		return goalDomain.deleteGoal(goalId);
	}

	public ResponseEntity<String> insertUserGoal(UserGoal userGoal) throws Exception {
		return userGoalDomain.insertUserGoal(userGoal);
	}

	public ResponseEntity<String> updateUserGoal( UserGoal userGoal) throws Exception {
		return userGoalDomain.updateUserGoal(userGoal);
	}

	public ResponseEntity<List<UserGoal>> getUserGoalList(Long userId) throws Exception {
		return userGoalDomain.getUserGoalList(userId);
	}

	public ResponseEntity<Optional<UserGoal>> getUserGoal(Long userGoalId) throws Exception {
		return userGoalDomain.getUserGoal(userGoalId);
	}
	
//	public ResponseEntity <String > createTestGoals(int startGoalId, int goalCount) throws Exception { 
//		return goalDomain.createTestGoals(startGoalId, goalCount);
//	}
}
