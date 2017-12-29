package net.gellien.vavr

import io.vavr.collection.*
import spock.lang.Specification

import static org.hamcrest.CoreMatchers.equalTo
import static org.hamcrest.MatcherAssert.assertThat
import static org.hamcrest.core.IsCollectionContaining.hasItems


class ListSpecification extends Specification {
	
	void 'verify extraction of first list element'() {
		given: "a list of three elements"
		List<Integer> list1 = List.of(1, 2, 3);

		when: "extracting first element"
		List<Integer> result = list1.tail()

		then: "a new List with the two last elements is returned"
		assertThat(result.size(), equalTo(2))
		assertThat(result, hasItems(2,3))
	}
}