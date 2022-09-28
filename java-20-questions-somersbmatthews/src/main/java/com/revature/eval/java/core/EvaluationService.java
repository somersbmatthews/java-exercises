package com.revature.eval.java.core;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.log4j.Logger;

public class EvaluationService {
	private static Logger logger = Logger.getLogger(EvaluationService.class);

	/**
	 * 1. Without using the StringBuilder or StringBuffer class, write a method that
	 * reverses a String. Example: reverse("example"); -> "elpmaxe"
	 * 
	 * @param string
	 * @return
	 */
	public String reverse(String string) {

		String base = "";

		for (int i = string.length() - 1; i >= 0; i--) {
			base += string.charAt(i);
		}

		return base;
	}

	/**
	 * 2. Convert a phrase to its acronym. Techies love their TLA (Three Letter
	 * Acronyms)! Help generate some jargon by writing a program that converts a
	 * long name like Portable Network Graphics to its acronym (PNG).
	 * 
	 * @param phrase
	 * @return
	 */
	public String acronym(String phrase) {
		// TODO Write an implementation for this method declaration
		String[] wordArray = phrase.split(" ");

		String acronym = "";

		for (String word : wordArray) {
			char firstLetter = word.charAt(0);
			acronym = acronym + Character.toUpperCase(firstLetter);
			if (word.contains("-")) {
				String[] splitWord = word.split("-");
				firstLetter = splitWord[1].charAt(0);
				acronym = acronym + Character.toUpperCase(firstLetter);
			}
		}

		System.out.println(acronym);

		return acronym;
	}

	/**
	 * 3. Determine if a triangle is equilateral, isosceles, or scalene. An
	 * equilateral triangle has all three sides the same length. An isosceles
	 * triangle has at least two sides the same length. (It is sometimes specified
	 * as having exactly two sides the same length, but for the purposes of this
	 * exercise we'll say at least two.) A scalene triangle has all sides of
	 * different lengths.
	 *
	 */
	static class Triangle {
		private double sideOne;
		private double sideTwo;
		private double sideThree;

		public Triangle() {
			super();
		}

		public Triangle(double sideOne, double sideTwo, double sideThree) {
			this();
			this.sideOne = sideOne;
			this.sideTwo = sideTwo;
			this.sideThree = sideThree;
		}

		public double getSideOne() {
			return sideOne;
		}

		public void setSideOne(double sideOne) {
			this.sideOne = sideOne;
		}

		public double getSideTwo() {
			return sideTwo;
		}

		public void setSideTwo(double sideTwo) {
			this.sideTwo = sideTwo;
		}

		public double getSideThree() {
			return sideThree;
		}

		public void setSideThree(double sideThree) {
			this.sideThree = sideThree;
		}

		public boolean isEquilateral() {
			// TODO Write an implementation for this method declaration
			return (sideOne == sideTwo && sideTwo == sideThree);
		}

		public boolean isIsosceles() {
			// TODO Write an implementation for this method declaration
			return ((sideOne == sideTwo || sideOne == sideThree)
					||
					(sideTwo == sideThree || sideTwo == sideOne));

		}

		public boolean isScalene() {
			// TODO Write an implementation for this method declaration
			return (sideOne != sideTwo && sideTwo != sideThree);

		}

	}

	/**
	 * 4. Given a word, compute the scrabble score for that word.
	 * 
	 * --Letter Values-- Letter Value A, E, I, O, U, L, N, R, S, T = 1; D, G = 2; B,
	 * C, M, P = 3; F, H, V, W, Y = 4; K = 5; J, X = 8; Q, Z = 10; Examples
	 * "cabbage" should be scored as worth 14 points:
	 * 
	 * 3 points for C, 1 point for A, twice 3 points for B, twice 2 points for G, 1
	 * point for E And to total:
	 * 
	 * 3 + 2*1 + 2*3 + 2 + 1 = 3 + 2 + 6 + 3 = 5 + 9 = 14
	 * 
	 * @param string
	 * @return
	 */
	public int getScrabbleScore(String string) {

		String[] onePointsLetters = { "A", "E", "I", "O", "U", "L", "N", "R", "S", "T" };
		String[] twoPointsLetters = { "D", "G" };
		String[] threePointsLetters = { "B", "C", "M", "P" };
		String[] fourPointsLetters = { "F", "H", "V", "W", "Y" };
		String[] fivePointsLetters = { "K" };
		String[] eightPointsLetters = { "J", "X" };
		String[] tenPointsLetters = { "Q", "Z" };

		List<String> onePointsLettersList = Arrays.asList(onePointsLetters);
		List<String> twoPointsLettersList = Arrays.asList(twoPointsLetters);
		List<String> threePointsLettersList = Arrays.asList(threePointsLetters);
		List<String> fourPointsLettersList = Arrays.asList(fourPointsLetters);
		List<String> fivePointsLettersList = Arrays.asList(fivePointsLetters);
		List<String> eightPointsLettersList = Arrays.asList(eightPointsLetters);
		List<String> tenPointsLettersList = Arrays.asList(tenPointsLetters);
		// TODO Write an implementation for this method declaration
		string = string.toUpperCase();
		String[] stringArray = string.split("");
		int score = 0;
		for (String letter : stringArray) {

			if (onePointsLettersList.contains(letter)) {
				score += 1;
			} else if (twoPointsLettersList.contains(letter)) {
				score += 2;
			} else if (threePointsLettersList.contains(letter)) {
				score += 3;
			} else if (fourPointsLettersList.contains(letter)) {
				score += 4;
			} else if (fivePointsLettersList.contains(letter)) {
				score += 5;
			} else if (eightPointsLettersList.contains(letter)) {
				score += 8;
			} else if (tenPointsLettersList.contains(letter)) {
				score += 10;
			}
		}
		return score;
	}

	/**
	 * 5. Clean up user-entered phone numbers so that they can be sent SMS messages.
	 * 
	 * The North American Numbering Plan (NANP) is a telephone numbering system used
	 * by many countries in North America like the United States, Canada or Bermuda.
	 * All NANP-countries share the same international country code: 1.
	 * 
	 * NANP numbers are ten-digit numbers consisting of a three-digit Numbering Plan
	 * Area code, commonly known as area code, followed by a seven-digit local
	 * number. The first three digits of the local number represent the exchange
	 * code, followed by the unique four-digit number which is the subscriber
	 * number.
	 * 
	 * The format is usually represented as
	 * 
	 * 1 (NXX)-NXX-XXXX where N is any digit from 2 through 9 and X is any digit
	 * from 0 through 9.
	 * 
	 * Your task is to clean up differently formatted telephone numbers by removing
	 * punctuation and the country code (1) if present.
	 * 
	 * For example, the inputs
	 * 
	 * +1 (613)-995-0253 613-995-0253 1 613 995 0253 613.995.0253 should all produce
	 * the output
	 * 
	 * 6139950253
	 * 
	 * Note: As this exercise only deals with telephone numbers used in
	 * NANP-countries, only 1 is considered a valid country code.
	 */
	public String cleanPhoneNumber(String string) {
		String[] removeArray = new String[] { "\\s", "\\(", "\\)", "\\+", "\\.", "\\-" };
		String numberWithoutBadStrings = string;
		for (String remove : removeArray) {
			numberWithoutBadStrings = numberWithoutBadStrings.replaceAll(remove, "");
		}

		if (numberWithoutBadStrings.length() > 11)
			throw new IllegalArgumentException("number cannot have more than 11 characters");

		if (!numberWithoutBadStrings.matches("^[0-9]+$"))
			throw new IllegalArgumentException("Number cannot have non numeric");

		if (numberWithoutBadStrings.charAt(0) != '1') {
			return numberWithoutBadStrings.replaceFirst("1", "");
		} else {
			return numberWithoutBadStrings;
		}

	}

	/**
	 * 6. Given a phrase, count the occurrences of each word in that phrase.
	 * 
	 * For example for the input "olly olly in come free" olly: 2 in: 1 come: 1
	 * free: 1
	 * 
	 * @param string
	 * @return
	 */
	public Map<String, Integer> wordCount(String string) {
		String[] stringArray = new String[] { string };
		if (string.contains(" "))
			stringArray = string.split(" ");
		if (string.contains(","))
			stringArray = string.split(",");
		if (string.contains("\n")) {
			String stringWithoutLineBreaks = string.replaceAll("\n", "");
			stringArray = stringWithoutLineBreaks.split(",");
		}

		HashMap<String, Integer> hmap = new HashMap<String, Integer>();

		for (String word : stringArray) {
			if (hmap.containsKey(word)) {
				hmap.put(word, (hmap.get(word) + 1));
			} else {
				hmap.put(word, 1);
			}
		}

		return hmap;
	}

	/**
	 * 7. Implement a binary search algorithm.
	 * 
	 * Searching a sorted collection is a common task. A dictionary is a sorted list
	 * of word definitions. Given a word, one can find its definition. A telephone
	 * book is a sorted list of people's names, addresses, and telephone numbers.
	 * Knowing someone's name allows one to quickly find their telephone number and
	 * address.
	 * 
	 * If the list to be searched contains more than a few items (a dozen, say) a
	 * binary search will require far fewer comparisons than a linear search, but it
	 * imposes the requirement that the list be sorted.
	 * 
	 * In computer science, a binary search or half-interval search algorithm finds
	 * the position of a specified input value (the search "key") within an array
	 * sorted by key value.
	 * 
	 * In each step, the algorithm compares the search key value with the key value
	 * of the middle element of the array.
	 * 
	 * If the keys match, then a matching element has been found and its index, or
	 * position, is returned.
	 * 
	 * Otherwise, if the search key is less than the middle element's key, then the
	 * algorithm repeats its action on the sub-array to the left of the middle
	 * element or, if the search key is greater, on the sub-array to the right.
	 * 
	 * If the remaining array to be searched is empty, then the key cannot be found
	 * in the array and a special "not found" indication is returned.
	 * 
	 * A binary search halves the number of items to check with each iteration, so
	 * locating an item (or determining its absence) takes logarithmic time. A
	 * binary search is a dichotomic divide and conquer search algorithm.
	 * 
	 */
	static class BinarySearch<T extends Comparable<T>> {
		private List<T> sortedList;

		public int indexOf(T t) {

			int length = sortedList.size();
			int result = binarySearch(sortedList, 0, length - 1, t);

			// return result;
			return result;
		}

		public BinarySearch(List<T> sortedList) {
			super();
			this.sortedList = sortedList;
		}

		public List<T> getSortedList() {
			return sortedList;
		}

		public void setSortedList(List<T> sortedList) {
			this.sortedList = sortedList;
		}

		private <T extends Comparable<T>> int binarySearch(List<T> list, int l, int r, T t) {

			if (r >= l) {
				// find the middle
				int mid = l + (r - l) / 2;

				// if the element is at the middle
				int result = list.get(mid).compareTo(t);
				String resultStr = Integer.toString(result);
				logger.info("after comparing " + list.get(mid) + " to " + t);
				logger.info("result is " + resultStr);

				if (result < 0) {
					return binarySearch(list, mid + 1, r, t);
				} else if (result == 0) {
					return mid;
				} else if (result > 0) {
					return binarySearch(list, l, mid - 1, t);
				}

			}
			return -1;

		}

	}

	/**
	 * 8. Implement a program that translates from English to Pig Latin.
	 * 
	 * Pig Latin is a made-up children's language that's intended to be confusing.
	 * It obeys a few simple rules (below), but when it's spoken quickly it's really
	 * difficult for non-children (and non-native speakers) to understand.
	 * 
	 * Rule 1: If a word begins with a vowel sound, add an "ay" sound to the end of
	 * the word. Rule 2: If a word begins with a consonant sound, move it to the end
	 * of the word, and then add an "ay" sound to the end of the word. There are a
	 * few more rules for edge cases, and there are regional variants too.
	 * 
	 * See http://en.wikipedia.org/wiki/Pig_latin for more details.
	 * 
	 * @param string
	 * @return
	 */
	public String toPigLatin(String string) {
		String[] wordArray = string.split(" ");
		String result = "";
		for (String word : wordArray) {
			String pigLatin = translateWordToPigLatin(word);

			result = result + (result.length() == 0 ? "" : " ") + pigLatin;
		}
		return result;
	}

	static String translateWordToPigLatin(String string) {
		int len = string.length();
		int index = -1;
		for (int i = 0; i < len; i++) {
			if (string.charAt(i) == 'q' && string.charAt(i + 1) == 'u') {
				index = i + 2;
				break;
			}
			if (isVowel(string.charAt(i))) {
				index = i;
				break;
			}
		}

		// Pig Latin is possible only if vowels
		// is present
		if (index == -1)
			return "-1";

		return string.substring(index) +
				string.substring(0, index) + "ay";
	}

	static boolean isVowel(char c) {
		return (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' ||
				c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}

	/**
	 * 9. An Armstrong number is a number that is the sum of its own digits each
	 * raised to the power of the number of digits.
	 * 
	 * For example:
	 * 
	 * 9 is an Armstrong number, because 9 = 9^1 = 9 10 is not an Armstrong number,
	 * because 10 != 1^2 + 0^2 = 2 153 is an Armstrong number, because: 153 = 1^3 +
	 * 5^3 + 3^3 = 1 + 125 + 27 = 153 154 is not an Armstrong number, because: 154
	 * != 1^3 + 5^3 + 4^3 = 1 + 125 + 64 = 190 Write some code to determine whether
	 * a number is an Armstrong number.
	 * 
	 * @param input
	 * @return
	 */
	public boolean isArmstrongNumber(int input) {

		return isArmstrong(input);
	}

	int power(int x, long y) {
		if (y == 0)
			return 1;
		if (y % 2 == 0)
			return power(x, y / 2) * power(x, y / 2);
		return x * power(x, y / 2) * power(x, y / 2);
	}

	/* Function to calculate order of the number */
	int order(int x) {
		int n = 0;
		while (x != 0) {
			n++;
			x = x / 10;
		}
		return n;
	}

	// Function to check whether the given number is
	// Armstrong number or not
	boolean isArmstrong(int x) {
		// Calling order function
		int n = order(x);
		int temp = x, sum = 0;
		while (temp != 0) {
			int r = temp % 10;
			sum = sum + power(r, n);
			temp = temp / 10;
		}

		// If satisfies Armstrong condition
		return (sum == x);
	}

	/**
	 * 10. Compute the prime factors of a given natural number.
	 * 
	 * A prime number is only evenly divisible by itself and 1.
	 * 
	 * Note that 1 is not a prime number.
	 * 
	 * @param l
	 * @return
	 */
	public List<Long> calculatePrimeFactorsOf(long l) {
		// TODO Write an implementation for this method declaration
		return primeFactors(l);
	}

	public static List<Long> primeFactors(long n) {
		List<Long> results = new ArrayList<>();
		// Print the number of 2s that divide n
		while (n % 2 == 0) {
			results.add(2L);
			n /= 2;
		}

		// n must be odd at this point. So we can
		// skip one element (Note i = i +2)
		for (int i = 3; i <= Math.sqrt(n); i += 2) {
			// While i divides n, print i and divide n
			while (n % i == 0) {
				Long l = Long.valueOf(i);
				results.add(l);
				n /= i;
			}
		}

		// This condition is to handle the case when
		// n is a prime number greater than 2
		if (n > 2) {
			Long l = Long.valueOf(n);
			results.add(l);
		}

		return results;
	}

	/**
	 * 11. Create an implementation of the rotational cipher, also sometimes called
	 * the Caesar cipher.
	 * 
	 * The Caesar cipher is a simple shift cipher that relies on transposing all the
	 * letters in the alphabet using an integer key between 0 and 26. Using a key of
	 * 0 or 26 will always yield the same output due to modular arithmetic. The
	 * letter is shifted for as many values as the value of the key.
	 * 
	 * The general notation for rotational ciphers is ROT + <key>. The most commonly
	 * used rotational cipher is ROT13.
	 * 
	 * A ROT13 on the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: nopqrstuvwxyzabcdefghijklm It is
	 * stronger than the Atbash cipher because it has 27 possible keys, and 25
	 * usable keys.
	 * 
	 * Ciphertext is written out in the same formatting as the input including
	 * spaces and punctuation.
	 * 
	 * Examples: ROT5 omg gives trl ROT0 c gives c ROT26 Cool gives Cool ROT13 The
	 * quick brown fox jumps over the lazy dog. gives Gur dhvpx oebja sbk whzcf bire
	 * gur ynml qbt. ROT13 Gur dhvpx oebja sbk whzcf bire gur ynml qbt. gives The
	 * quick brown fox jumps over the lazy dog.
	 */
	static class RotationalCipher {

		private int key;

		public RotationalCipher(int key) {
			super();
			this.key = key;
		}

		// public String rotate(String string) {
		// StringBuilder result = new StringBuilder();
		// for (char character : string.toCharArray()) {
		// if (Character.isDigit(character)) {
		// result.append(character);
		// } else if (!Character.isLetter(character) && character != ' ') {
		// result.append(character);
		// } else if (character != ' ') {
		// int originalAlphabetPosition = character - 'a';
		// int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
		// char newCharacter = (char) ('a' + newAlphabetPosition);
		// result.append(newCharacter);
		// } else {
		// result.append(character);
		// }
		// }
		// return result.toString();
		// }

		public String rotate(String text) {
			StringBuffer result = new StringBuffer();

			for (int i = 0; i < text.length(); i++) {
				if (text.charAt(i) == ' ') {
					result.append(' ');
				} else if (!Character.isLetter(text.charAt(i)) && text.charAt(i) != ' ') {

					result.append(text.charAt(i));

				} else if (Character.isDigit(text.charAt(i))) {
					result.append(text.charAt(i));
				} else if (Character.isUpperCase(text.charAt(i))) {
					char ch = (char) (((int) text.charAt(i) +
							key - 65) % 26 + 65);
					result.append(ch);
				} else {
					char ch = (char) (((int) text.charAt(i) +
							key - 97) % 26 + 97);
					result.append(ch);
				}
			}
			return result.toString();
		}

	}

	/**
	 * 12. Given a number n, determine what the nth prime is.
	 * 
	 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see
	 * that the 6th prime is 13.
	 * 
	 * If your language provides methods in the standard library to deal with prime
	 * numbers, pretend they don't exist and implement them yourself.
	 * 
	 * @param i
	 * @return
	 */
	public int calculateNthPrime(int i) {
		return getNthPrime(i);
	}

	// initializing the max value
	static int MAX_SIZE = 1000005;

	// To store all prime numbers
	static ArrayList<Integer> primes = new ArrayList<Integer>();

	// Function to generate N prime numbers
	// using Sieve of Eratosthenes
	static int getNthPrime(int n) {

		if (n == 0)
			throw new IllegalArgumentException("Prime can't be 0");

		if (n == 1) {
			return 2;
		}

		n = n - 1;

		boolean[] IsPrime = new boolean[MAX_SIZE];

		for (int i = 0; i < MAX_SIZE; i++)
			IsPrime[i] = true;

		for (int p = 2; p * p < MAX_SIZE; p++) {
			// If IsPrime[p] is not changed,
			// then it is a prime
			if (IsPrime[p] == true) {
				// Update all multiples of p greater than or
				// equal to the square of it
				// numbers which are multiple of p and are
				// less than p^2 are already been marked.
				for (int i = p * p; i < MAX_SIZE; i += p)
					IsPrime[i] = false;
			}
		}

		// Store all prime numbers
		for (int p = 2; p < MAX_SIZE; p++)
			if (IsPrime[p] == true)
				primes.add(p);

		return primes.get(n);
	}

	/**
	 * 13 & 14. Create an implementation of the atbash cipher, an ancient encryption
	 * system created in the Middle East.
	 * 
	 * The Atbash cipher is a simple substitution cipher that relies on transposing
	 * all the letters in the alphabet such that the resulting alphabet is
	 * backwards. The first letter is replaced with the last letter, the second with
	 * the second-last, and so on.
	 * 
	 * An Atbash cipher for the Latin alphabet would be as follows:
	 * 
	 * Plain: abcdefghijklmnopqrstuvwxyz Cipher: zyxwvutsrqponmlkjihgfedcba It is a
	 * very weak cipher because it only has one possible key, and it is a simple
	 * monoalphabetic substitution cipher. However, this may not have been an issue
	 * in the cipher's time.
	 * 
	 * Ciphertext is written out in groups of fixed length, the traditional group
	 * size being 5 letters, and punctuation is excluded. This is to make it harder
	 * to guess things based on word boundaries.
	 * 
	 * Examples Encoding test gives gvhg Decoding gvhg gives test Decoding gsvjf
	 * rxpyi ldmul cqfnk hlevi gsvoz abwlt gives thequickbrownfoxjumpsoverthelazydog
	 *
	 */

	static class AtbashCipher {

		/**
		 * Question 13
		 * 
		 * @param string
		 * @return
		 */
		public static String encode(String string) {

			return encrypt(string);
		}

		/**
		 * Question 14
		 * 
		 * @param string
		 * @return
		 */
		public static String decode(String string) {

			return decrypt(string);
		}

		private static String encrypt(String plaintext) {
			String ciphertext = "";
			plaintext = removeUnwantedChars(plaintext.toLowerCase());
			for (char c : plaintext.toCharArray()) {
				if (Character.isLetter(c)) {
					ciphertext += (char) ('a' + ('z' - c));
				} else {
					ciphertext += c;
				}
			}
			return getSubStrings(ciphertext).trim();
		}

		private static String decrypt(String ciphertext) {
			String plaintext = "";
			ciphertext = removeUnwantedChars(ciphertext.toLowerCase());
			for (char c : ciphertext.toCharArray()) {
				if (Character.isLetter(c)) {
					plaintext += (char) ('z' + ('a' - c));
				} else {
					plaintext += c;
				}
			}
			return plaintext;
		}

		private static String getSubStrings(String input) {
			String out = "";
			for (int i = 0; i < input.length(); i += 5) {
				if (i + 5 <= input.length()) {
					out += (input.substring(i, i + 5) + " ");
				} else {
					out += (input.substring(i) + " ");
				}
			}
			return out;
		}

		private static String removeUnwantedChars(String input) {
			String out = "";
			for (char c : input.toCharArray()) {
				if (Character.isLetterOrDigit(c)) {
					out += c;
				}
			}
			return out;
		}

	}

	/**
	 * 15. The ISBN-10 verification process is used to validate book identification
	 * numbers. These normally contain dashes and look like: 3-598-21508-8
	 * 
	 * ISBN The ISBN-10 format is 9 digits (0 to 9) plus one check character (either
	 * a digit or an X only). In the case the check character is an X, this
	 * represents the value '10'. These may be communicated with or without hyphens,
	 * and can be checked for their validity by the following formula:
	 * 
	 * (x1 * 10 + x2 * 9 + x3 * 8 + x4 * 7 + x5 * 6 + x6 * 5 + x7 * 4 + x8 * 3 + x9
	 * * 2 + x10 * 1) mod 11 == 0 If the result is 0, then it is a valid ISBN-10,
	 * otherwise it is invalid.
	 * 
	 * Example Let's take the ISBN-10 3-598-21508-8. We plug it in to the formula,
	 * and get:
	 * 
	 * (3 * 10 + 5 * 9 + 9 * 8 + 8 * 7 + 2 * 6 + 1 * 5 + 5 * 4 + 0 * 3 + 8 * 2 + 8 *
	 * 1) mod 11 == 0 Since the result is 0, this proves that our ISBN is valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isValidIsbn(String string) {

		return isISBN(string);
	}

	public static boolean isISBN(String number) {

		// declare variable
		int length = 0;

		// remove all hyphens
		number = number.replace("-", "");
		// remove all spaces
		number = number.replace(" ", "");

		// check result string is a number or not
		try {
			// except for the case where
			// ISBN-10 ends with X or x
			char ch = number.charAt(9);
			ch = Character.toUpperCase(ch);
			if (ch != 'X') {
				// don't store, only check
				Long.parseLong(number);
			}
		} catch (NumberFormatException nfe) {
			// not a number
			return false;
		}

		// find length
		length = number.length();

		if (length == 10)
			return isISBN10(number);

		return false;
	}

	private static boolean isISBN10(String number) {

		// declare variables
		int sum = 0;
		int digit = 0;
		char ch = '\0';

		// add upto 9th digit
		for (int i = 1; i <= 9; i++) {
			ch = number.charAt(i - 1);
			digit = Character.getNumericValue(ch);
			sum += (i * digit);
		}

		// last digit
		ch = number.charAt(9);
		ch = Character.toUpperCase(ch);
		if (ch == 'X')
			sum += (10 * 10);
		else {
			digit = Character.getNumericValue(ch);
			sum += (digit * 10);
		}

		// check sum
		if (sum % 11 == 0)
			return true;

		return false;
	}

	/**
	 * 16. Determine if a sentence is a pangram. A pangram (Greek: παν γράμμα, pan
	 * gramma, "every letter") is a sentence using every letter of the alphabet at
	 * least once. The best known English pangram is:
	 * 
	 * The quick brown fox jumps over the lazy dog.
	 * 
	 * The alphabet used consists of ASCII letters a to z, inclusive, and is case
	 * insensitive. Input will not contain non-ASCII symbols.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isPangram(String string) {
		// TODO Write an implementation for this method declaration
		return allLetter(string);
	}

	public static boolean allLetter(String str) {
		// Converting the given string
		// into lowercase
		str = str.toLowerCase();

		boolean allLetterPresent = true;

		// Loop over each character itself
		for (char ch = 'a'; ch <= 'z'; ch++) {

			// Check if the string does not
			// contains all the letters
			if (!str.contains(String.valueOf(ch))) {
				allLetterPresent = false;
				break;
			}
		}

		// Check if all letter present then
		// print "Yes", else print "No"
		if (allLetterPresent)
			return true;
		else
			return false;
	}

	/**
	 * 17. Calculate the moment when someone has lived for 10^9 seconds.
	 * 
	 * A gigasecond is 109 (1,000,000,000) seconds.
	 * 
	 * @param birth
	 * @return
	 */
	public Temporal getGigasecondDate(Temporal birth) {
		// Duration gigaSecond = Duration.ofSeconds(1_000_000_000);
		long seconds = 1_000_000_000;
		Duration duration = Duration.ofSeconds(seconds);
		// Duration gigaSecond = Duration.ofMinutes(minutes);
		// Duration gigaSecondMinutes = (gigaSecond);
		// LocalDateTime time = LocalDateTime.of(temporal)
		// time.plusSeconds((long) Math.pow(10, 9));

		// Temporal newTime = temporal.plus(seconds);
		if (birth.getClass() == LocalDateTime.class) {
			return birth.plus(duration);
		}
		LocalDateTime birthDateTime = LocalDateTime.of((LocalDate) birth, LocalTime.MIDNIGHT);
		// // ZoneId zone = ZoneId.of("America/Chicago");
		// // ZoneOffset zoneOffset = zone.getRules().getOffset(LocalDateTime.now());

		// // LocalDate time = (LocalDate) temporal;
		// long epochTime = time.toEpochDay();

		// // LocalDateTime newTime = LocalDateTime.ofEpochSecond(seconds, 0,
		// zoneOffset);

		// long newEpochTime = epochTime + seconds;

		return birthDateTime.plus(duration);
	}

	/**
	 * 18. Given a number, find the sum of all the unique multiples of particular
	 * numbers up to but not including that number.
	 * 
	 * If we list all the natural numbers below 20 that are multiples of 3 or 5, we
	 * get 3, 5, 6, 9, 10, 12, 15, and 18.
	 * 
	 * The sum of these multiples is 78.
	 * 
	 * @param i
	 * @param set
	 * @return
	 */
	public int getSumOfMultiples(int i, int[] set) {
		if (set.length == 1) {
			return findSum(i, set[0]);
		} else if (set.length == 2) {
			return findSum(i, set[0], set[1]);
		} else if (set.length == 3) {
			return findSum(i, set[0], set[1], set[2]);
		}

		return -1;
	}

	static int findSum(int n, int a, int b, int c) {
		int sum = 0;
		for (int i = 0; i < n; i++)

			// If i is a multiple of a or b
			if (i % a == 0 || i % b == 0 || i % c == 0)
				sum += i;

		return sum;
	}

	static int findSum(int n, int a, int b) {
		int sum = 0;
		for (int i = 0; i < n; i++)

			// If i is a multiple of a or b
			if (i % a == 0 || i % b == 0)
				sum += i;

		return sum;
	}

	static int findSum(int n, int a) {
		int sum = 0;
		for (int i = 0; i < n; i++)

			// If i is a multiple of a or b
			if (i % a == 0)
				sum += i;

		return sum;
	}

	/**
	 * 19. Given a number determine whether or not it is valid per the Luhn formula.
	 * 
	 * The Luhn algorithm is a simple checksum formula used to validate a variety of
	 * identification numbers, such as credit card numbers and Canadian Social
	 * Insurance Numbers.
	 * 
	 * The task is to check if a given string is valid.
	 * 
	 * Validating a Number Strings of length 1 or less are not valid. Spaces are
	 * allowed in the input, but they should be stripped before checking. All other
	 * non-digit characters are disallowed.
	 * 
	 * Example 1: valid credit card number 1 4539 1488 0343 6467 The first step of
	 * the Luhn algorithm is to double every second digit, starting from the right.
	 * We will be doubling
	 * 
	 * 4_3_ 1_8_ 0_4_ 6_6_ If doubling the number results in a number greater than 9
	 * then subtract 9 from the product. The results of our doubling:
	 * 
	 * 8569 2478 0383 3437 Then sum all of the digits:
	 * 
	 * 8+5+6+9+2+4+7+8+0+3+8+3+3+4+3+7 = 80 If the sum is evenly divisible by 10,
	 * then the number is valid. This number is valid!
	 * 
	 * Example 2: invalid credit card number 1 8273 1232 7352 0569 Double the second
	 * digits, starting from the right
	 * 
	 * 7253 2262 5312 0539 Sum the digits
	 * 
	 * 7+2+5+3+2+2+6+2+5+3+1+2+0+5+3+9 = 57 57 is not evenly divisible by 10, so
	 * this number is not valid.
	 * 
	 * @param string
	 * @return
	 */
	public boolean isLuhnValid(String string) {
		String strWithoutSpaces = string.replaceAll("\\s", "");
		// String withoutCharacters = strWithoutSpaces.replaceAll("[^\\d.]", "");
		// String withoutHyphens = withoutCharacters.replaceAll("-", "");
		// TODO Write an implementation for this method declaration
		return checkLuhn(strWithoutSpaces);
	}

	static boolean checkLuhn(String cardNo) {
		int nDigits = cardNo.length();

		int nSum = 0;
		boolean isSecond = false;
		for (int i = nDigits - 1; i >= 0; i--) {

			int d = cardNo.charAt(i) - '0';

			if (isSecond == true)
				d = d * 2;

			// We add two digits to handle
			// cases that make two digits
			// after doubling
			nSum += d / 10;
			nSum += d % 10;

			isSecond = !isSecond;
		}
		return (nSum % 10 == 0);
	}

	/**
	 * 20. Parse and evaluate simple math word problems returning the answer as an
	 * integer.
	 * 
	 * Add two numbers together.
	 * 
	 * What is 5 plus 13?
	 * 
	 * 18
	 * 
	 * Now, perform the other three operations.
	 * 
	 * What is 7 minus 5?
	 * 
	 * 2
	 * 
	 * What is 6 multiplied by 4?
	 * 
	 * 24
	 * 
	 * What is 25 divided by 5?
	 * 
	 * 5
	 * 
	 * @param string
	 * @return
	 */
	public int solveWordProblem(String string) {

		List<String> integerList = findIntegers(string);
		List<Integer> nums = new ArrayList<Integer>();
		for (String strNum : integerList) {
			nums.add(Integer.parseInt(strNum));
		}
		if (string.contains("plus")) {
			return nums.get(0) + nums.get(1);
		}
		if (string.contains("minus")) {
			return nums.get(0) - nums.get(1);
		}
		if (string.contains("multiplied")) {
			return nums.get(0) * nums.get(1);
		}
		if (string.contains("divided")) {
			return nums.get(0) / nums.get(1);
		}

		return 0;
	}

	List<String> findIntegers(String stringToSearch) {
		Pattern integerPattern = Pattern.compile("-?\\d+");
		Matcher matcher = integerPattern.matcher(stringToSearch);

		List<String> integerList = new ArrayList<>();
		while (matcher.find()) {
			integerList.add(matcher.group());
		}

		return integerList;
	}

}
