package com.starfit.goal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@Getter	@Setter
@NoArgsConstructor
@Table(name="goal")
public class Goal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 는 ai pk이다.
	private Long  id 		; // 목표 아이디
	private String  exerType	; // 만보기, 따릉이, 심박동수
	private int stdPoint 	; // 기준 지급 포인트
	private int	stdExerAmt	; // 기준 운동량
	private	int	minExerAmt	; // 하루 최소양
	private int maxExerAmt	; // 하루 최대양
	private String exerUnit	; // 단위.(보, km, 횟수)
	private String useYn;
		

}
