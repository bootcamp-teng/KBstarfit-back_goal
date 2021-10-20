package com.starfit.goal.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter	@Setter
public class GoalStatus {

	Long finalGoal;
	Long currentStep;
	Long goalRate;
}
