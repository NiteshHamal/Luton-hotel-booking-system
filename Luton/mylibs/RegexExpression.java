package mylibs;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExpression {
	
	public boolean Name(String st) {
		boolean result = false;

		String regex = "^[a-z]([-']?[a-z]+)*( [a-z]([-']?[a-z]+)*)+$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	
	
	public boolean Address(String st) {
		boolean result = false;

		String regex = "[A-Z]{1}[a-z]{1,10}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	
	public boolean Phone(String st) {
		boolean result = false;
		
		String regex = "^[9]{1}[678]{1}[0-9]{8}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	
	public boolean CreditCard(String st) {
		boolean result = false;
		
		String regex = "[0-9]{16}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}

	public boolean UserName(String st) {
		boolean result = false;
		
		String regex = "^[A-Z]{1}[a-z]{2,10}[0-9\\_\\.]{1,20}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	
	public boolean Password(String st) {
		boolean result = false;
		
		String regex = "^[A-Za-z0-9@%$!#]{4,10}";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(st);
		result = m.matches();

		return result;
	}
	
	
}
