package Com.Comcast.Generic.WebDriverUtility;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.Random; 




public class JavaUtility {
	public int getRandomNumber()
	{
		Random random=new Random();
		int randomnumber=random.nextInt(1000);
		return randomnumber;
	}
	public String getTimeTamp()
	{
		String time=new Date().toString().replace(" ","_").replace(":","_");
	return time;
	}

	public String getSystemDate()
	{
		Date dateObj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(dateObj);
		return date;
	}
	// can bw pass "- or +" days----------------
	/*public String getRequiredDate(int days)
	{
		Date dateObj=new Date();

		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-DD");
	Calendar cal=sdf.getCalendar();
	cal.add(cal.DAY_OF_MONTH,days);
		String reqDate=sdf.format(cal.getTime());
		return reqDate;*/
		

 
    public String getReqDate(int days) {
		//Date dateObj=new Date();

        Calendar cal = Calendar.getInstance(); // Get Calendar instance with current date
        cal.add(Calendar.DAY_OF_MONTH,days); // Add days to current date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String reqDate = sdf.format(cal.getTime());
        return reqDate;
    
}


}
