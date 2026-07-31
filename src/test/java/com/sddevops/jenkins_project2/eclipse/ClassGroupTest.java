package com.sddevops.jenkins_project2.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.jupiter.api.Test;

class ClassGroupTest {

	@Test
	void testConstructor() {

		ClassGroup group = new ClassGroup(3);

		assertEquals(3, group.getCapacity());
		assertEquals(0, group.getSize());
		assertEquals(3, group.getStudents().length);
	}

	@Test
	void testAddStudent() {

		ClassGroup group = new ClassGroup(2);

		Student student = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		assertTrue(group.addStudent(student));

		assertEquals(1, group.getSize());
		assertSame(student, group.getStudents()[0]);
	}

	@Test
	void testAddStudentWhenFull() {

		ClassGroup group = new ClassGroup(1);

		Student student1 = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		Student student2 = new Student(2, "Bob", LocalDate.of(2025, Month.FEBRUARY, 1));

		assertTrue(group.addStudent(student1));
		assertFalse(group.addStudent(student2));

		assertEquals(1, group.getSize());
		assertSame(student1, group.getStudents()[0]);
	}

	@Test
	void testRemoveStudent() {

		ClassGroup group = new ClassGroup(3);

		Student student1 = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		Student student2 = new Student(2, "Bob", LocalDate.of(2025, Month.FEBRUARY, 1));

		group.addStudent(student1);
		group.addStudent(student2);

		assertTrue(group.removeStudent(1));

		assertEquals(1, group.getSize());
		assertSame(student2, group.getStudents()[0]);
	}

	@Test
	void testRemoveStudentNotFound() {

		ClassGroup group = new ClassGroup(2);

		Student student = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		group.addStudent(student);

		assertFalse(group.removeStudent(99));

		assertEquals(1, group.getSize());
	}

	@Test
	void testGetTheOldestStudent() {

		ClassGroup group = new ClassGroup(3);

		Student oldest = new Student(1, "Alice", LocalDate.of(2000, Month.JANUARY, 1));

		Student younger = new Student(2, "Bob", LocalDate.of(2005, Month.JUNE, 1));

		Student youngest = new Student(3, "Charlie", LocalDate.of(2010, Month.DECEMBER, 1));

		group.addStudent(youngest);
		group.addStudent(oldest);
		group.addStudent(younger);

		assertSame(oldest, group.getTheOldestStudent());
	}

	@Test
	void testGetTheOldestStudentWhenEmpty() {

		ClassGroup group = new ClassGroup(3);

		assertNull(group.getTheOldestStudent());
	}

	@Test
	void testRemoveOnlyStudent() {

		ClassGroup group = new ClassGroup(1);

		Student student = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		group.addStudent(student);

		assertTrue(group.removeStudent(1));

		assertEquals(0, group.getSize());
		assertNull(group.getStudents()[0]);
	}

	@Test
	void testGetOldestStudentSingleStudent() {

		ClassGroup group = new ClassGroup(2);

		Student student = new Student(1, "Alice", LocalDate.of(2020, Month.JANUARY, 1));

		group.addStudent(student);

		assertSame(student, group.getTheOldestStudent());
	}

}