package com.starfit.goal.domain;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.starfit.goal.data.GoalRepository;
import com.starfit.goal.model.Goal;

@Service
public class GoalDomain {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private GoalRepository sampleGoalRepo;
	
	/*
	 * getGoalList: 목표 목록을 100개까지 리턴
	 */
	public ResponseEntity<List<Goal>> getGoalList() { 
		
		List<Goal> list = null;

		System.out.println(list);
		try {
			log.info("Start db select");
			list = sampleGoalRepo.findListByUseYn("Y");
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.debug("user counts :"+list.size());
		
		return new ResponseEntity<List<Goal>> (list, HttpStatus.OK);
	}
	
	/*
	 * getGoalById: goalId에 해당하는 목표정보 리턴 
	 */
	public ResponseEntity <Optional<Goal>> getGoalById(Long goalId) { 
		Optional<Goal> re = null;
		try {
			log.info("Start db select");
			re = sampleGoalRepo.findById(goalId);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Optional<Goal>> (re, HttpStatus.OK);
	}
	
	/*
	 * updateGoal: 목표 정보 변경 
	 */
	public ResponseEntity <String > updateGoal(Goal sampleGoal) throws Exception { 
		log.info("Start db update==>"+sampleGoal.getId());
		Goal re;
		Optional<Goal> entity = sampleGoalRepo.findById(sampleGoal.getId());
		if(entity.isPresent()) {
			entity.get().setId(sampleGoal.getId());
			entity.get().setMaxExerAmt(sampleGoal.getMaxExerAmt());
			entity.get().setMinExerAmt(sampleGoal.getMinExerAmt());
			entity.get().setStdExerAmt(sampleGoal.getStdExerAmt());
			entity.get().setStdPoint(sampleGoal.getStdPoint());
			entity.get().setExerType(sampleGoal.getExerType());
			entity.get().setExerUnit(sampleGoal.getExerUnit());
			re  = sampleGoalRepo.save(sampleGoal);
		}
		
		log.debug("result :"+ "update");
		
		return new ResponseEntity<String> ("update", HttpStatus.OK);
	}

	/*
	 * insertGoal: 목표 추가 
	 */
	public ResponseEntity <String > insertGoal(Goal sampleGoal) throws Exception { 
		log.info("Start db insert");
		Goal re  = sampleGoalRepo.save(sampleGoal);
		log.debug("result :"+ re);
		
		return new ResponseEntity<String> (re+"", HttpStatus.OK);
	}
	
	/*
	 *  deleteGoal: 목표 삭제 
	 */
	public ResponseEntity <String > deleteGoal(Long Id) throws Exception { 
		log.info("Start db insert");
		sampleGoalRepo.deleteById(Id);
		log.debug("result :"+ "delete");
		
		return new ResponseEntity<String> ("delete", HttpStatus.OK);
	}


}
