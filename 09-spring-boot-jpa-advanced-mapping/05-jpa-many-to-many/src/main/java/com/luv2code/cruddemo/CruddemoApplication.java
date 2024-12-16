package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.dao.AppDAOImpl;
import com.luv2code.cruddemo.entity.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);}


		@Bean
		public CommandLineRunner commandLineRunner (AppDAO appDAO){
			return runner -> {
            // createCourseAndStudents(appDAO);
				//findCourseAndStudents(appDAO);
				//findStudentAndCourses(appDAO);
              // addMoreCoursesForStudent(appDAO);
				//deleteCourse(appDAO);
				deleteStudent(appDAO);

			};
		}

	private void deleteStudent(AppDAO appDAO) {

		int theId=1;
		System.out.println("deleting student id "+theId);
		appDAO.deleteStudentById(theId);
		System.out.println("done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
            int theId=2;
			Student tempStudent=appDAO.findStudentAndCoursesByStudentId(2);

Course tempCourse1=new Course("rubick'cube - how to speed cube");
		Course tempCourse2=new Course("Attari 2600 - Game developement");
		tempStudent.addCourse(tempCourse1);
		tempStudent.addCourse(tempCourse2);
		System.out.println("saving student "+tempStudent)
		;
		System.out.println("associated courses "+tempStudent.getCourses());
		appDAO.update(tempStudent);
		System.out.println("done!");


	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int theId=2;
		Student tempStudent=appDAO.findStudentAndCoursesByStudentId(theId);
		System.out.println("Loaded student: "+ tempStudent);
		System.out.println("Courses:"+tempStudent.getCourses());
		System.out.println("done!");

	}

	private void findCourseAndStudents(AppDAO appDAO) {
	int theId=10;
	Course tempCourse=appDAO.findCourseAndStudentByCourseId(theId);
		System.out.println("loaded course: "+tempCourse);
		System.out.println("Students:" +tempCourse.getStudents());
		System.out.println("done");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course tempCourse=new Course("Pacmanc- how to score one million points");

		Student tempStudent1=new Student("john","doe","john@luv2code.com");
		Student tempStudent2=new Student("mary","public","mary@luv2code.com");
		 tempCourse.addStudent(tempStudent1);
		 tempCourse.addStudent(tempStudent2);
		 appDAO.save(tempCourse);
		System.out.println("done");

	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		System.out.println("deleting course id: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("done");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		Course tempCourse=appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		System.out.println("done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {

		//create a course
		Course tempCourse=new Course("pacman- how to score one million Points");

		//add some reviews
		tempCourse.addReview(new Review("great course ... loved it"));
		tempCourse.addReview(new Review("cool course ... loved it"));
		tempCourse.addReview(new Review("what a dumb course, you are an idiot "));
		//save the course

		System.out.println("saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());

        appDAO.save(tempCourse);
	}

	private void deleteCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("deleting course id: "+theId);
		appDAO.deleteCourseById(theId);
		System.out.println("Done!");


	}

	private void updateCourse(AppDAO appDAO) {
		int theId=10;
		System.out.println("Finding course id:"+theId);
		Course tempCourse=appDAO.findCourseById(theId);
		System.out.println("updating course id:"+theId);
		tempCourse.setTitle("Enjoy the simple things");
		appDAO.update(tempCourse);
		System.out.println("Done !");


	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id : "+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("UPDATING instructor id:" +theId);
		tempInstructor.setLastName("TESTER");
		appDAO.update(tempInstructor);

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
    int theId=1;
		System.out.println("finding instructor id" +theId);
		Instructor tempInstructor=appDAO.findInstructorByIdJoinFetch(theId);

		System.out.println("temInstructor: "+tempInstructor );
		System.out.println("the associated courses :"+tempInstructor.getCourses());
		System.out.println("done!");

	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("finding instructor id:"+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		//find courses for instructor
		System.out.println("finding courses  for instructor id:" +theId);
		List<Course> COURSES=appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(COURSES);
		System.out.println("the associated courses :"+tempInstructor.getCourses());
		System.out.println("Done");

	}

	private void findInstructorWithCourses(AppDAO appDAO) {

		int theId=1;
		System.out.println("finding instructor id:"+theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		System.out.println("done");


	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=new Instructor("susan","public","susan.public@luv2code.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.luv2code.com/youtube",
				"Video games"          );
		tempInstructor.setInstructorDetail(tempInstructorDetail);
		Course tempCourse1=new Course("Air Guitar-the ultimate guide");
		Course tempCourse2=new Course("the pinball masterclass");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		System.out.println("saving instructor: "+tempInstructor);
		System.out.println("the courses:"+tempInstructor.getCourses() );
		appDAO.save(tempInstructor);


	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=3;
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=2;
		InstructorDetail templInstructorDetail=appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetail: "+ templInstructorDetail);
		Instructor tempInstructor=templInstructorDetail.getInstructor();
		System.out.println("the Instructor associated: "+tempInstructor);

	}

	private void deleteInstructor(AppDAO appDAO) {
     int theId=1;
		System.out.println("deleting instructor id"+theId);
		appDAO.deleteInstructorById(theId);
		System.out.println("done!");

	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		System.out.println("Finding instructor id : " +theId);
		Instructor tempInstructor=appDAO.findInstructorById(theId);
		System.out.println("tempInstructor"+tempInstructor);
		System.out.println("the associate instructordetails only :"+tempInstructor.getInstructorDetail());

	}

	private void createInstructor(AppDAO appDAO) {

		/*Instructor tempInstructor=new Instructor("Chad","Darby","darby@luv2code.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.luv2code.com/youtube",
				                                                                "Luv 2 code !!!!"          );*/

		Instructor tempInstructor=new Instructor("madhu","patel","madhu@luv2code.com");
		InstructorDetail tempInstructorDetail=new InstructorDetail("http://www.luv2code.com/youtube",
				"Guitar"          );
	 tempInstructor.setInstructorDetail(tempInstructorDetail);

	 // save the instructor
		System.out.println("saving instructor :"+tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");



	}
}



