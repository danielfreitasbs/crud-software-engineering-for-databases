package com.danielfreitasbs.softbd.agenda.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.danielfreitasbs.softbd.agenda.entity.Schedule;
import com.danielfreitasbs.softbd.agenda.exception.ObjectNotFoundException;
import com.danielfreitasbs.softbd.agenda.repository.ScheduleRepository;

@Service
public class ScheduleService {

	@Autowired
	private ScheduleRepository scheduleRepo;

	public Schedule insert(Schedule schedule) {
		schedule.setCode(null);
		return scheduleRepo.save(schedule);
	}

	public List<Schedule> findAll() {
		List<Schedule> schedulers = scheduleRepo.findAll();
		return schedulers;
	}

	public void delete(Integer id) {
		find(id);
		scheduleRepo.deleteById(id);
	}

	public Schedule find(Integer id) {
		Optional<Schedule> collaborator = scheduleRepo.findById(id);
		return collaborator.orElseThrow(() -> new ObjectNotFoundException("Agendamento não encontrado"));
	}

	public Schedule update(Schedule schedulePayload) {
		return scheduleRepo.save(schedulePayload);
	}
}
