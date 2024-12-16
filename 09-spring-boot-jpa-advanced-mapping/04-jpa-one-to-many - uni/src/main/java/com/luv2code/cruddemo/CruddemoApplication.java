package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.AppDAO;
import com.luv2code.cruddemo.dao.AppDAOImpl;
import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.entity.Review;
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
				//createInstructor(appDAO);
				//findInstructor(appDAO);
				//deleteInstructor(appDAO);
				//findInstructorDetail(appDAO);
				//deleteInstructorDetail(appDAO);
				//createInstructorWithCourses(appDAO);
				//findInstructorWithCourses(appDAO);
				//findCoursesForInstructor(appDAO);
				//findInstructorWithCoursesJoinFetch(appDAO);
				//updateInstructor(appDAO);
				//updateCourse(appDAO);
				//deleteInstructor(appDAO);
				//deleteCourse(appDAO);
               //createCourseAndReviews(appDAO);
				//retrieveCourseAndReviews(appDAO);
				deleteCourseAndReviews(appDAO);
			};
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



