package com.starfit.goal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name="userGoal")
public class UserGoal {
	public UserGoal() {
		super();
	}
	public UserGoal(Long id, String title, String goalId, String userId, LocalDateTime startDate,
			LocalDateTime endDate, int period, String benefitCode, String statusCode) {
		super();
		this.id = id;
		this.title = title;
		this.goalId = goalId;
		this.userId = userId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.period = period;
		this.benefitCode = benefitCode;
		this.statusCode = statusCode;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 는 ai pk이다.
	private Long id; // 회원당 목표 아이디
	private String title; // 회원 목표 이름.
	private String goalId; // 목표 아이디
	private String userId; // 회원 아이디	
	private LocalDateTime startDate; // 운동 시작 시기 체크
	private LocalDateTime endDate; // 운동 종료 시기 체크
	private int period; // 기간
	private String benefitCode; // 혜택 종류 체크( 0-포인트리, 1 - 적금, 2- 대출)
	private String statusCode; // 진행중인 상태 체크 (0-진행중, 1- 완료, 2- 포기)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGoalId() {
		return goalId;
	}
	public void setGoalId(String goalId) {
		this.goalId = goalId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public LocalDateTime getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}
	public LocalDateTime getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDateTime endDate) {
		this.endDate = endDate;
	}
	public int getPeriod() {
		return period;
	}
	public void setPeriod(int period) {
		this.period = period;
	}
	public String getBenefitCode() {
		return benefitCode;
	}
	public void setBenefitCode(String benefitCode) {
		this.benefitCode = benefitCode;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	

}
