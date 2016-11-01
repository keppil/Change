package com.cgi.kata.change;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.util.Map;

import org.assertj.core.data.MapEntry;
import org.junit.Test;

public class ChangeGiverTest {

	@Test
	public void zero_sum_yields_no_change() throws Exception {
		Map<Denomination, Integer> change = new ChangeGiver().giveCorrectChange(0);
		assertThat(change).isEmpty();
	}

	@Test
	public void sum_equal_to_coin_of_value_one() throws Exception {
		Map<Denomination, Integer> change = new ChangeGiver().giveCorrectChange(1);
		assertThat(change).containsExactly(MapEntry.entry(Denomination.ONE, 1));
	}

	@Test
	public void sum_equal_to_coin_of_value_five() throws Exception {
		Map<Denomination, Integer> change = new ChangeGiver().giveCorrectChange(5);
		assertThat(change).containsExactly(MapEntry.entry(Denomination.FIVE, 1));
	}

	@Test
	public void sum_equal_to_coin_of_value_ten() throws Exception {
		Map<Denomination, Integer> change = new ChangeGiver().giveCorrectChange(10);
		assertThat(change).containsExactly(MapEntry.entry(Denomination.TEN, 1));
	}

	@Test
	public void sum_equal_to_three_coins_of_same_denomination() throws Exception {
		Map<Denomination, Integer> change = new ChangeGiver().giveCorrectChange(3);
		assertThat(change).containsExactly(MapEntry.entry(Denomination.ONE, 3));
	}

	@Test
	public void sum_equals_3000() throws Exception {
		Map<Denomination, Integer> change = new ChangeGiver().giveCorrectChange(3000);
		assertThat(change).containsExactly(MapEntry.entry(Denomination.TWO_HUNDRED, 15));
	}

	@Test
	public void sum_equals_347() throws Exception {
		Map<Denomination, Integer> change = new ChangeGiver().giveCorrectChange(347);
		assertThat(change).containsOnly(MapEntry.entry(Denomination.TWO_HUNDRED, 1),
				MapEntry.entry(Denomination.HUNDRED, 1), MapEntry.entry(Denomination.TWENTY, 2),
				MapEntry.entry(Denomination.FIVE, 1), MapEntry.entry(Denomination.ONE, 2));
	}
}
