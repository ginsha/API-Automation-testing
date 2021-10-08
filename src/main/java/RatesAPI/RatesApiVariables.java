package RatesAPI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class RatesApiVariables {

	public RatesApiVariables() {
		// TODO Auto-generated constructor stub
	}
	private static final String baseUrl = "http://api.exchangeratesapi.io/v1/";
	private static final String key = "e87949a1410705ce92d40844b95568ca";
	private static String futureDate;
	private static String historicalDate;

	
	 public static String getBaseUrl()
	  {
	  return baseUrl;
	  }
	  public static String getKey()
	  {
	  return key;
	  }

		 public static String getYesterday()
		  {
		  return historicalDate;
		  }
		  public static String getFuture()
		  {
		  return futureDate;
		  }
		  
	  public static String yesterday() {

			Calendar cal = Calendar.getInstance();

			cal.add(Calendar.DATE, -1);

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			historicalDate = dateFormat.format(cal.getTime());

			System.out.println("Yesterday's date = " + historicalDate);
			return historicalDate;
		}

		public static String future() {

			Calendar cal = Calendar.getInstance();

			cal.add(Calendar.DATE, +1);

			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			// get formatted date
			futureDate = dateFormat.format(cal.getTime());

			System.out.println("future date's date = " + futureDate);
			return futureDate;
		}



}
