package com.starfit.goal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="goal")
public class Goal {
	public Goal() {
		super();
	}
	public Goal(Long id, String type, int stdPoint, int stdamount, int amount_min, int amount_max, String unit) {
		super();
		this.id = id;
		this.type = type;
		this.stdPoint = stdPoint;
		this.stdamount = stdamount;
		this.amount_min = amount_min;
		this.amount_max = amount_max;
		this.unit = unit;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id 는 ai pk이다.
	private Long  id 		; // 목표 아이디
	
	private String  type	; // 만보기, 따릉이, 심박동수
	private int stdPoint 	; // 기준 지급 포인트
	private int	stdamount	; // 기준 운동량
	private	int	amount_min	; // 하루 최소양
	private int amount_max	; // 하루 최대양
	private String unit		; // 단위.(보, km, 횟수)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getStdPoint() {
		return stdPoint;
	}
	public void setStdPoint(int stdPoint) {
		this.stdPoint = stdPoint;
	}
	public int getStdamount() {
		return stdamount;
	}
	public void setStdamount(int stdamount) {
		this.stdamount = stdamount;
	}
	public int getAmount_min() {
		return amount_min;
	}
	public void setAmount_min(int amount_min) {
		this.amount_min = amount_min;
	}
	public int getAmount_max() {
		return amount_max;
	}
	public void setAmount_max(int amount_max) {
		this.amount_max = amount_max;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
		

}
