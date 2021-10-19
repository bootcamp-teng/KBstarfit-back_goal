package com.starfit.goal.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.starfit.goal.model.Goal;
import com.starfit.goal.model.UserGoal;
import com.starfit.goal.service.GoalService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Goal API")
@RestController
public class GoalController {
	@Autowired
	private GoalService goalService;
	
	@GetMapping("/v1/goals")	
	@ApiOperation(value="목표 정보 가져오기", notes="목표 정보를 제공합니다. ")
	public ResponseEntity<List<Goal>> getGoalList() { 
		return goalService.getGoalList();
	}
	
	@GetMapping("/v1/goal/{goalId}")
	@ApiOperation(value="아이디로 목표 상세 정보 가져오기 ")
	public ResponseEntity <Optional<Goal>> getGoalById(
				@PathVariable (name="goalId", required = true) Long goalId
			) { 
		return goalService.getGoalById(goalId);
	}
	
	@PutMapping("/v1/goal/{goalId}")
	@ApiOperation(value="목표 정보 변경하기 ")
	public ResponseEntity <String > updateGoal(
			@RequestBody Goal sampleGoal
		) throws Exception { 
		
		return goalService.updateGoal(sampleGoal);
	}
	
	@PostMapping("/v1/goal")
	@ApiOperation(value="목표 정보 등록하기 ")
	public ResponseEntity <String > insertGoal(
			@RequestBody Goal sampleGoal
		) throws Exception { 
		
		return goalService.insertGoal(sampleGoal);
	}
	
	@DeleteMapping("/v1/goal/{goalId}")
	@ApiOperation(value="목표 정보 삭제하기 ")
	public ResponseEntity <String > deleteGoal(
			@PathVariable(name="goalId",required = true ) Long goalId
		) throws Exception { 
		
		return goalService.deleteGoal(goalId);
	}
	
	@GetMapping("/v1/usergoalsbyid/{userId}")
	@ApiOperation(value="사용자 진행 목표 조회하기")
	public ResponseEntity <List<UserGoal>> getUserGoalList(
				@PathVariable(name="userId", required = true) String userId
			) throws Exception {
		return goalService.getUserGoalList(userId);
	}
	
	@GetMapping("/v1/usergoal/{userGoalId}")
	@ApiOperation(value = "진행 목표 상세 조회")
	public ResponseEntity <Optional<UserGoal>> getUserGoal(
			@PathVariable(name="userGoalId", required = true) Long userGoalId
		) throws Exception {
	return goalService.getUserGoal(userGoalId);
	}
	
	@PostMapping("/v1/usergoal")
	@ApiOperation(value="사용자 진행 목표 추가하기")
	public ResponseEntity<String> insertUserGoal(
			@RequestBody UserGoal userGoal
			) throws Exception {
			return goalService.insertUserGoal(userGoal);
	}
	
	@PutMapping("/v1/usergoal")
	@ApiOperation(value="사용자 진행 목표 수정하기")
	public ResponseEntity<String> updateUserGoal(
			@RequestBody UserGoal userGoal
			) throws Exception{
		return goalService.updateUserGoal(userGoal);
	}
//	@GetMapping("/createtestusers/{startUserId}/{userCount}")
//	@ApiOperation(value="테스트 사용자를 userCount명 등록하기 ")
//	public ResponseEntity <String > createTestUsers(
//			@PathVariable (name="startUserId", required = true) int startUserId,
//			@PathVariable (name="userCount", required = true) int userCount
//		) throws Exception { 
//		
//		return userService.createTestUsers(startUserId, userCount);
//	}	
}
