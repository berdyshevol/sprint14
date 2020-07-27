package com.softserve.edu;


import com.softserve.edu.model.*;
import com.softserve.edu.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.ConstraintViolationException;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;


@SpringBootApplication
public class Application implements CommandLineRunner {

	UserService userService;
	MarathonService marathonService;
	private final SprintService sprintService;
	private final TaskService taskService;
	private final ProgressService progressService;

	public Application(UserService userService, MarathonService marathonService, SprintService sprintService, TaskService taskService, ProgressService progressService) {
		this.userService = userService;
		this.marathonService = marathonService;
		this.sprintService = sprintService;
		this.taskService = taskService;
		this.progressService = progressService;
	}

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("----------------------------Running Spring Boot Application");
//		try{
//			for (int i=0; i < 50; i++) {
//				User user = new User();
//				user.setPassword("qwertyQwerty6^");
//				user.setRole(User.Role.TRAINEE);
//				user.setFirstName("TraineeName" + i);
//				user.setLastName("TraineeSurname" + i);
//				user.setEmail("trainee" + i + "@user.com");
//				userService.createOrUpdateUser(user);
//				System.out.println("Done " + i );
//			}
//		}
//		catch (ConstraintViolationException e){
//			System.out.println(e.getMessage());
//		}
//
//		User user = userService.getUserById(1L);
//		user.setPassword("newNewPassword");
//
//		User user = new User();
//        user.setPassword("qwertyQwerty6^");
//        user.setRole(User.Role.TRAINEE);
//        user.setFirstName("Name");
//        user.setLastName("");
//        user.setEmail("User@dh.com");
//		userService.createOrUpdateUser(user);
//
//
//
//
//
//
        List<User> users = userService.getAll();
//        System.out.println("------USERS----\n"+users);
//        //logger.info("User id 2 -> {}", user.get());
//
//        Marathon marathon1 = new Marathon();
//        marathon1.setTitle("1-st marathon");
//        Set<User> userSet = new LinkedHashSet<>();
//        userSet.add(users.get(0));
////        marathon.setMentors(userSet);
//        marathonService.createOrUpdate(marathon1);

//		Marathon marathon2 = new Marathon();
//		marathon2.setTitle("2-d marathon");
//		marathonService.createOrUpdate(marathon2);

//		Marathon marathon3 = new Marathon();
//		marathon3.setTitle("3-d marathon");
//		marathonService.createOrUpdate(marathon3);

//		Marathon marathon4 = new Marathon();
//		marathon4.setTitle("4-th marathon");
//		marathonService.createOrUpdate(marathon4);

//        //marathonService.deleteMarathonById(2L);
		List<Marathon> marathons = marathonService.getAll();
		if (marathons.size() == 4) System.out.println("+++++++++++++++");
		else System.out.println("---------------");
		System.out.println(marathons.get(0).getTitle());
//		       marathon = marathons.get(0);
//        //System.out.println(marathons);
//
//        //System.out.println(userService.getAllByRole("mentor"));
//		       User mentor = userService.getAllByRole("trainee").get(6);

//        Marathon m = marathonService.getMarathonById(1L);

//		      userService.addUserToMarathon(mentor, m);
//        //Set<User> mentors = marathon.getMentors();
//        //mentors.add(mentor);
//        //marathonService.createOrUpdate(m);
//        //System.out.println(marathonService.getAllMentors(marathon));
//        //userService.addUserToMarathon(mentor, marathon);
//        Sprint sprint = new Sprint();
//		sprint.setTitle("Second sprint");
//		sprint.setStartDate(LocalDate.of(2020, 07, 23));
//		sprint.setEndDate(LocalDate.of(2020, 07, 25));
//		sprintService.addSprintToMarathon(sprint, m);
//       sprint = sprintService.getSprintById(1L);
 //       Task task = new Task();
//		task.setTitle("First task for first sprint");
//		       taskService.addTaskToSprint(task, sprint);
//		task = taskService.getTaskById(2L);
//		User user = userService.getUserById(26L);
//        progressService.addTaskForStudent(task, user);
//	Progress progress = progressService.getProgressById(1L);
//        progress.setStatus(Progress.TaskStatus.PENDING);
//		System.out.println("!!!"+progressService.setStatus(Progress.TaskStatus.PENDING, progress));
//
//		System.out.println(progressService.allProgressByUserIdAndSprintId(26L, 1L));

	}
}