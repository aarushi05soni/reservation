import java.util.*;
public class Hotel {
    private int rating;
    private String hotelName;
    private Map<Category,Integer> priceCard;

    Hotel(String name,Map<Category,Integer> priceCard,int rating)
    {
        this.hotelName=name;
        this.priceCard=priceCard;
        this.rating=rating;
    }

    public int getRating()
    {
        return rating;
    }
    public Map<Category,Integer> getPrice()
    {
        return priceCard;
    }
    public String getName()
    {
        return hotelName;
    }
    int getCostOf(List<Category> categories)
    {
        int totalAmount=0;
        //System.out.println(categories.size());
        for(int i=0;i<categories.size();i++)
        {
            totalAmount+=priceCard.get(categories.get(i));
        }
        //System.out.println(totalAmount);
        return totalAmount;
    }
}
