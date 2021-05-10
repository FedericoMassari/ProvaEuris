package org.generation.italy.eurisTest.controller;

import org.generation.italy.eurisTest.dao.IDaoCosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/costs")
public class ControllerCosts {

	@Autowired
	private IDaoCosts dao;

	@GetMapping("/sumCost/{cost1}/{cost2}")
	public String sumCost(@PathVariable String cost1, @PathVariable String cost2) {
		return dao.sumCost(cost1, cost2);

	}

	@GetMapping("/subCost/{cost1}/{cost2}")
	public String subCost(@PathVariable String cost1, @PathVariable String cost2) {
		return dao.subCost(cost1, cost2);
	}

	@GetMapping("/multCost/{cost}/{multiplier}")
	public String multCost(@PathVariable String cost, @PathVariable int multiplier) {
		return dao.multCost(cost, multiplier);
	}

	@GetMapping("/divCost/{cost}/{divisor}")
	public String divCost(@PathVariable String cost, @PathVariable int divisor) {
		return dao.divCost(cost, divisor);

	}

}
