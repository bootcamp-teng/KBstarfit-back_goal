package com.starfit.goal.service;

import java.util.List;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.starfit.goal.domain.GoalDomain;
import com.starfit.goal.domain.RestTemplateDomain;
import com.starfit.goal.domain.UserGoalDomain;
import com.starfit.goal.model.Goal;
import com.starfit.goal.model.UserGoal;

@Service
public class GoalService {
	@Autowired
	private GoalDomain goalDomain;
	@Autowired
	private UserGoalDomain userGoalDomain;
	@Autowired
	private RestTemplateDomain restTemplateDomain;
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

	public ResponseEntity<String> deleteUserGoal(Long id)  throws Exception{
		ResponseEntity<String> entity = userGoalDomain.deleteUserGoal(id);
		if (!entity.getStatusCode().equals(HttpStatus.OK)) {	
			return new ResponseEntity<String> ("진행중인 목표가 있는지 확인해주세요", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		ResponseEntity<String> result = restTemplateDomain.doRestTemplate(new JSONObject(), "/starfitexercise/v1/exercise/" + id.toString(), HttpMethod.DELETE);
		if (result.getStatusCode().isError()) {
			return new ResponseEntity<String> ("운동 기록 삭제 에러", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("삭제 완료 되었습니다.",HttpStatus.OK);
	}
}
	
//	public ResponseEntity <String > createTestGoals(int startGoalId, int goalCount) throws Exception { 
//		return goalDomain.createTestGoals(startGoalId, goalCount);
//	}
