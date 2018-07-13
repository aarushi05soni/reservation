import java.util.*;

public class HotelService {
    List<Hotel> hotels=new ArrayList<>();
    HotelService(List<Hotel> hotels)
    {
        this.hotels=hotels;
    }

    public Hotel getCheapest(Request request)
    {
        Map<Integer,Hotel> hotelCost=new HashMap<>();
        List<Integer> totalCost=new ArrayList<>();
        List<Category> categories=request.getCategories();

        for(Hotel hotel:hotels)
        {
            hotelCost.put(hotel.getCostOf(categories),hotel);
            totalCost.add(hotel.getCostOf(categories));
        }
        Collections.sort(totalCost);
        return hotelCost.get(totalCost.get(0));
    }
}
