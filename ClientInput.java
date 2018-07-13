import java.util.ArrayList;
import java.util.List;

public class ClientInput {
    public List<Day> getDays(String input)
    {
        List<String> al=new ArrayList<String>();
        int begin=0;
        int end=0;
        for(int i=0;i<input.length();i++)
        {
            if (input.charAt(i) == '(')
            {
                int j=i+1;
                String day="";
                while(input.charAt(j)!=')')
                {
                    day=day+input.charAt(j);
                    j++;
                }
                al.add(day);
            }
        }
        List<Day> days=getDayType(al);
        return days;
    }

    public List<Day> getDayType(List<String> al)
    {
        List<Day> dayType=new ArrayList<>();
        for (int i=0;i<al.size();i++)
        {
            if (al.get(i).equals("mon") || al.get(i).equals("tues") || al.get(i).equals("wed") || al.get(i).equals("thurs") || al.get(i).equals("fri")) {
                dayType.add(Day.WEEKDAY);
            }
            else
            {
                dayType.add(Day.WEEKEND);
            }
        }
        return dayType;
    }

    public String getType(String input)
    {
        String type="";
        for(int i=0;i<input.length();i++)
        {
            if(input.charAt(i)==':')
                type=input.substring(0,i);
        }
        return type;
    }
    public Hotel getHotel(String input,HotelService hotelService)
    {
        List<Day> days=new ArrayList<Day>();
        String type=getType(input);
        days=getDays(input);
        Customer customer=Customer.valueOf(type.toUpperCase());
        Request request=new Request(customer,days);
        //System.out.println(type);
        Hotel cheapest=hotelService.getCheapest(request);
        //System.out.println(cheapest.getName());
        return cheapest;
    }
}
