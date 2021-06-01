package com.danielfreitasbs.agendavacinacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielfreitasbs.agendavacinacao.entity.Schedule;
import com.danielfreitasbs.agendavacinacao.service.ScheduleService;

@RestController
@RequestMapping(value = "/scheduler")
public class ScheduleController {

	@Autowired
	private ScheduleService scheduleService;

	@PostMapping
	public ResponseEntity<Schedule> insert(@RequestBody Schedule schedulePayload) {
		schedulePayload = scheduleService.insert(schedulePayload);

		return ResponseEntity.ok().body(schedulePayload);
	}

	@PutMapping
	public ResponseEntity<Schedule> update(@RequestBody Schedule schedulePayload) {
		schedulePayload = scheduleService.update(schedulePayload);

		return ResponseEntity.ok().body(schedulePayload);
	}

	@GetMapping
	public ResponseEntity<List<Schedule>> findAll() {
		List<Schedule> collaborators = scheduleService.findAll();
		return ResponseEntity.ok().body(collaborators);
	}

	@DeleteMapping(path = "/{code}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		scheduleService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
