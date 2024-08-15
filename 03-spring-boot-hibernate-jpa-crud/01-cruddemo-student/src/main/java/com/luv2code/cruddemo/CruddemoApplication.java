package com.luv2code.cruddemo;

import com.luv2code.cruddemo.DAO.StudentDao;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
		return runner->{
		//createStudent(studentDao);
			createMultipleStudents(studentDao);
			//readStudent(studentDao);
			//queryForStudents(studentDao);
			//queryForStudentsByLastName(studentDao);
			//updateStudent(studentDao);
			//deleteStudent(studentDao);
			//deleteAllStudents(studentDao);

		};

}

	private void deleteAllStudents(StudentDao studentDao) {
		System.out.println("delete all students");
		int numRowsDeleted=studentDao.deleteAll();
		System.out.println("DELETED ROW COUNT"+numRowsDeleted);


	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId=3;
		System.out.println("deleting student id"+studentId);
		studentDao.delete(studentId);
	}

	private void updateStudent(StudentDao studentDao) {
int studentId=1;
		System.out.println("Getting student with id"+studentId);
		Student myStudent=studentDao.findById(studentId);
		System.out.println("updating student");
		myStudent.setFirstName("Scooby");
		studentDao.update(myStudent);

		System.out.println("updated student"+myStudent);

	}

	private void queryForStudentsByLastName(StudentDao studentDao) {

		List<Student> thestudents=studentDao.findByLastName("duck");
		for(Student student :thestudents){
		System.out.println(student);}
	}

	private void queryForStudents(StudentDao studentDao) {
		List<Student> theStudents=studentDao.findAll();
		for(Student temStudent: theStudents){
			System.out.println(temStudent);
		}


	}

	private void readStudent(StudentDao studentDao) {
		System.out.println("Creating new student object");
		Student tempStudent=new Student("daffy","duck","daffy@luv2code.com");
		System.out.println("saving the student");
		studentDao.save(tempStudent);
		int theId=tempStudent.getId();
		System.out.println("saved student.Generated id:"+theId);
		System.out.println("retrieving student with id:"+ theId);
		Student myStudent=studentDao.findById(theId);
		System.out.println("Found the student :"+myStudent);

	}

	private void createMultipleStudents(StudentDao studentDao) {
		System.out.println("creating 3 student object");
		Student tempStudent1=new Student("john","doe","john@luv2code.com");
		Student tempStudent2=new Student("Mary","doe","mary@luv2code.com");
		Student tempStudent3=new Student("sofia","doe","sofia@luv2code.com");
		System.out.println("saving the students");
		studentDao.save(tempStudent1);
		studentDao.save(tempStudent2);
		studentDao.save(tempStudent3);



	}

	private void createStudent(StudentDao studentDao) {

		// create the student object
		System.out.println("creating new student object");
		Student tempStudent=new Student("PAUL","doe","paul@luv2code.com");

		// save the student object
		System.out.println("saving the student");
		studentDao.save(tempStudent);
		// display id of the saved student
		System.out.println("saved student.Generated id: "+tempStudent.getId());

	}

}
