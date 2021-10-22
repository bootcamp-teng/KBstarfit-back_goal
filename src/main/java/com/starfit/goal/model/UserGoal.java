package com.starfit.goal.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity(name="userGoal")
@NoArgsConstructor
@Getter @Setter
public class UserGoal {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 는 ai pk이다.
	private Long id; // 회원당 목표 아이디
	private String title; // 회원 목표 이름.
	private Long goalId; // 목표 아이디
	private Long userId; // 회원 아이디	
	private LocalDateTime startDate; // 운동 시작 시기 체크
	private LocalDateTime endDate; // 운동 종료 시기 체크
	private int period; // 기간
	private String benefitCode; // 혜택 종류 체크( 0-포인트리, 1 - 적금, 2- 대출)
	private String statusCode; // 진행중인 상태 체크 (0-진행중, 1- 완료, 2- 포기)
	private int dayExerAmt; // 하루 운동량
}
