package com.starfit.goal.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.starfit.goal.data.UserGoalRepository;
import com.starfit.goal.model.UserGoal;

@Service
public class UserGoalDomain {
	
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserGoalRepository sampleUserGoalRepo;
	
	public ResponseEntity<String> insertUserGoal(UserGoal userGoal) throws Exception {
		List<UserGoal> userGoalList = getUserGoalList(userGoal.getUserId()).getBody();
		Boolean currFlg = userGoalList.stream().anyMatch(userGoalH -> userGoalH.getStatusCode().equals("0"));
		if(currFlg) throw new ResponseStatusException(HttpStatus.CREATED, "진행중인 목표가 존재합니다"); 
		
		log.info("Start db insert");
		
		LocalDateTime startDate = LocalDateTime.now(); 
		LocalDateTime endDate = startDate.plusDays(userGoal.getPeriod());
		userGoal.setStartDate(startDate);
		userGoal.setEndDate(endDate);
		userGoal.setStatusCode("0");
		UserGoal re  = sampleUserGoalRepo.save(userGoal);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}

	public ResponseEntity<String> updateUserGoal(UserGoal userGoal) throws Exception {
		log.info("Start db update==>"+userGoal.getId());
		Optional<UserGoal> entity = sampleUserGoalRepo.findById(userGoal.getId());
		
		if(entity.isPresent()) {
			entity.get().setBenefitCode(userGoal.getBenefitCode());
			entity.get().setEndDate(userGoal.getEndDate());
			entity.get().setGoalId(userGoal.getGoalId());
			entity.get().setPeriod(userGoal.getPeriod());
			entity.get().setStartDate(userGoal.getStartDate());
			entity.get().setStatusCode(userGoal.getStatusCode());
			entity.get().setTitle(userGoal.getTitle());
			entity.get().setUserId(userGoal.getUserId());
			
			UserGoal re  = sampleUserGoalRepo.save(userGoal);
		}

		
		log.debug("result :"+ entity);
		
		return new ResponseEntity<String> (entity+"", HttpStatus.OK);
	}

	public ResponseEntity<List<UserGoal>> getUserGoalList(Long userId) {
		List<UserGoal> re = null;
		try {
			log.info("Start db select");
			re = sampleUserGoalRepo.findByuserId(userId, Sort.by(Sort.Direction.ASC, "statusCode"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<List<UserGoal>> (re, HttpStatus.OK);
	}

	public ResponseEntity<Optional<UserGoal>> getUserGoal(Long userGoalId) throws Exception {
		Optional<UserGoal> re = null;
		try {
			log.info("Start db select");
			re = sampleUserGoalRepo.findById(userGoalId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Optional<UserGoal>> (re, HttpStatus.OK);
	}
}
