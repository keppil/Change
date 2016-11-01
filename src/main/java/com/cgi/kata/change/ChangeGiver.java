package com.cgi.kata.change;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class ChangeGiver {

	List<Denomination> denominations = Stream.of(Denomination.values())
			.sorted(comparingInt(Denomination::getValue).reversed()).collect(toList());

	public Map<Denomination, Integer> giveCorrectChange(int sum) {
		int changeGiven = 0;
		Map<Denomination, Integer> change = new HashMap<>();
		for (Denomination denomination : denominations) {
			int numberOfThisDenom = Math.floorDiv(sum - changeGiven, denomination.getValue());
			if (numberOfThisDenom > 0) {
				change.put(denomination, numberOfThisDenom);
			}
			changeGiven += numberOfThisDenom * denomination.getValue();
		}
		return change;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("skriv in en summa");
		String sum = s.nextLine();
		ChangeGiver changeGiver = new ChangeGiver();
		Map<Denomination, Integer> change = changeGiver.giveCorrectChange(Integer.valueOf(sum));
		System.out.println(change);
	}
}
