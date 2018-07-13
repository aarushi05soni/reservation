import org.junit.*;

import java.util.*;
import org.junit.Assert.*;

import static org.junit.Assert.assertEquals;

public class Testing {
    HotelService hotelService;
    @Before
    public void initialize()
    {
        List<Hotel> hotels=new ArrayList<Hotel>();
        Map<Category,Integer> priceCard;
        priceCard=new HashMap<>();
        priceCard.put(new Category(Customer.REGULAR,Day.WEEKDAY),110);
        priceCard.put(new Category(Customer.REGULAR,Day.WEEKEND),90);
        priceCard.put(new Category(Customer.REWARDS,Day.WEEKDAY),80);
        priceCard.put(new Category(Customer.REWARDS,Day.WEEKEND),80);
        hotels.add(new Hotel("LakeWood",priceCard,3));
        priceCard=new HashMap<>();
        priceCard.put(new Category(Customer.REGULAR,Day.WEEKDAY),160);
        priceCard.put(new Category(Customer.REGULAR,Day.WEEKEND),60);
        priceCard.put(new Category(Customer.REWARDS,Day.WEEKDAY),110);
        priceCard.put(new Category(Customer.REWARDS,Day.WEEKEND),50);
        hotels.add(new Hotel("BridgeWood",priceCard,4));
        priceCard=new HashMap<>();
        priceCard.put(new Category(Customer.REGULAR,Day.WEEKDAY),220);
        priceCard.put(new Category(Customer.REGULAR,Day.WEEKEND),150);
        priceCard.put(new Category(Customer.REWARDS,Day.WEEKDAY),100);
        priceCard.put(new Category(Customer.REWARDS,Day.WEEKEND),40);
        hotels.add(new Hotel("RidgeWood",priceCard,5));
        hotelService=new HotelService(hotels);
    }

    @Test
    public void test()
    {
        ClientInput input=new ClientInput();
        Hotel output=input.getHotel("Rewards:26mar2018(thurs),27mar2018(fri),28mar2018(sat)",hotelService);
        //System.out.println(output.getName()+" "+output.getRating());
        assertEquals("RidgeWood",output.getName());
    }
}
