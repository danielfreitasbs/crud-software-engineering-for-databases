package com.danielfreitasbs.softbd.agenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.danielfreitasbs.softbd.agenda.entity.Schedule;
import com.danielfreitasbs.softbd.agenda.service.ScheduleService;

@RestController
@RequestMapping(value = "/scheduler")
public class ScheduleResource {

	@Autowired
	private ScheduleService scheduleService;

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Schedule> insert(@RequestBody Schedule schedulePayload) {
		schedulePayload = scheduleService.insert(schedulePayload);

		return ResponseEntity.ok().body(schedulePayload);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Schedule> update(@RequestBody Schedule schedulePayload) {
		schedulePayload = scheduleService.update(schedulePayload);

		return ResponseEntity.ok().body(schedulePayload);
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Schedule>> findAll() {
		List<Schedule> collaborators = scheduleService.findAll();
		return ResponseEntity.ok().body(collaborators);
	}

	@RequestMapping(value = "/{code}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		scheduleService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
