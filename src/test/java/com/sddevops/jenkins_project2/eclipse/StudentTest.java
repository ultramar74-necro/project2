package com.sddevops.jenkins_project2.eclipse;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;

class StudentTest {

	@Test
	void testConstructorWithoutFriend() {

		Student student = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		assertEquals(1, student.getId());
		assertEquals("Alice", student.getName());
		assertEquals(LocalDate.of(2025, Month.JANUARY, 1), student.getBirthday());
		assertNull(student.getFriend());
	}

	@Test
	void testConstructorWithFriend() {

		Student friend = new Student(2, "Bob", LocalDate.of(2024, Month.MAY, 10));

		Student student = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1), friend);

		assertEquals(1, student.getId());
		assertEquals("Alice", student.getName());
		assertEquals(LocalDate.of(2025, Month.JANUARY, 1), student.getBirthday());
		assertSame(friend, student.getFriend());
	}

	@Test
	void testSetters() {

		Student student = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		Student friend = new Student(2, "Bob", LocalDate.of(2024, Month.MAY, 10));

		student.setId(100);
		student.setName("Charlie");
		student.setBirthday(LocalDate.of(2020, Month.JUNE, 15));
		student.setFriend(friend);

		assertEquals(100, student.getId());
		assertEquals("Charlie", student.getName());
		assertEquals(LocalDate.of(2020, Month.JUNE, 15), student.getBirthday());
		assertSame(friend, student.getFriend());
	}

	@Test
	void testEquals() {

		Student student1 = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		Student student2 = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		Student student3 = new Student(2, "Bob", LocalDate.of(2025, Month.JANUARY, 1));

		assertEquals(student1, student2);
		assertNotEquals(student1, student3);
	}

	@Test
	void testHashCode() {

		Student student1 = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		Student student2 = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		assertEquals(student1.hashCode(), student2.hashCode());
	}

	@Test
	void testCompareByName() {

		Student alice = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		Student bob = new Student(2, "Bob", LocalDate.of(2025, Month.JANUARY, 1));

		assertTrue(Student.compareByName.compare(alice, bob) < 0);
		assertTrue(Student.compareByName.compare(bob, alice) > 0);
	}

	@Test
	void testCompareByBirthday() {

		Student older = new Student(1, "Alice", LocalDate.of(2000, Month.JANUARY, 1));

		Student younger = new Student(2, "Bob", LocalDate.of(2005, Month.JANUARY, 1));

		assertTrue(Student.compareByBirthday.compare(older, younger) < 0);
		assertTrue(Student.compareByBirthday.compare(younger, older) > 0);
	}

	@Test
	void testToString() {

		Student student = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		String text = student.toString();

		assertTrue(text.contains("Alice"));
		assertTrue(text.contains("1"));
		assertTrue(text.contains("no best friend"));
	}

	@Test
	void testAssignRandomUsername() {

		Student student = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		Random random = new Random(123);

		student.assignRandomUsername(random);

		assertNotNull(student.getName());
		assertNotEquals("Alice", student.getName());
		assertTrue(student.getName().length() >= 5);
		assertTrue(student.getName().length() <= 10);
	}

	@Test
	void testAssignRandomUsernameUsingMockito() {

		Student student = new Student(1, "Alice", LocalDate.of(2025, Month.JANUARY, 1));

		Random random = mock(Random.class);

		when(random.nextInt(6)).thenReturn(0); // username length = 5
		when(random.nextInt(63)).thenReturn(0); // always choose first character

		student.assignRandomUsername(random);

		assertEquals("AAAAA", student.getName());

		verify(random).nextInt(6);
		verify(random, times(5)).nextInt(63);
	}
}