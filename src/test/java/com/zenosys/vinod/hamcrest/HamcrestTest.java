/**
 * 
 */
package com.zenosys.vinod.hamcrest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.isA;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * This class represents Hamcrest Testing Examples
 * 
 * @author Vinod Pillai - vinodthebest@gmail.com
 * @version
 */
@RunWith(MockitoJUnitRunner.class)
public class HamcrestTest {

	@Test
	public void boolean_Value_Using_Is() {

		boolean a = false;
		boolean b = false;
		// Equals Check
		assertThat(a, is(b));
		assertThat(a, equalTo(b));
		assertThat(a, is(equals(b)));

		// Data Type checking
		assertThat(a, isA(Boolean.class));

		// Instance of
		assertThat(a, instanceOf(Boolean.class));

		b = true;
		// Not Equals
		assertThat(a, is(not(equalTo(b))));

	}

	@Test
	public void list_Value_Using_Contains() {
		List<Integer> list = Arrays.asList(5, 2, 4);

		assertThat(list, hasSize(3));

		assertThat(list, containsInAnyOrder(2, 5, 4));
		assertThat(list, everyItem(greaterThan(1)));

	}

	@Test
	public void array_Value_Testing() {

		Integer[] value = new Integer[] { 10, 20, 30, 40, 50 };
		assertThat(value, arrayWithSize(5));
		assertThat(value, arrayContaining(10, 20, 30, 40, 50));
		// All values matching required
		assertThat(value, arrayContainingInAnyOrder(20, 30, 40, 50, 10));
	}

	@Test
	public void bean_Value_Testing() {

		Todo todo1 = new Todo(1, "Vikas", "Description", 2010);
		assertThat(todo1, hasProperty("description"));

		assertThat(todo1, hasProperty("name", equalTo("Vikas")));

		Todo todo2 = new Todo(1, "Vikas", "Description", 2010);
		assertThat(todo1, samePropertyValuesAs(todo2));

	}

	@Test
	public void string_Value_Testing() {
		String value1 = "";

		assertThat(value1, isEmptyString());

		String value2 = null;
		assertThat(value2, isEmptyOrNullString());
	}



	@Spy
	List list = new LinkedList();
	@Test
	public void spy_Testing() {
		// Impossible: real method is called so spy.get(0) throws
		// IndexOutOfBoundsException (the list is yet empty)
		//when(list.get(0)).thenReturn("foo");
		doReturn("foo").when(list).get(0);
	}
}
