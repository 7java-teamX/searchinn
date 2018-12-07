package model;

import dao.PlanDAO;

public class PlanEditLogic {
	public void update(Plan plan) {
		PlanDAO dao = new PlanDAO();
		dao.update(plan);
	}
}
