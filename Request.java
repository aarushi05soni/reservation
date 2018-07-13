import java.util.*;
public class Request {
    private Customer customer;
    private List<Day> days;
    List<Category> categories=new ArrayList<>();
    Request(Customer customer,List<Day> days)
    {
        this.customer=customer;
        this.days=days;
    }
    public List<Category> getCategories()
    {
        for(int i=0;i<days.size();i++)
        {
             categories.add(new Category(this.customer,days.get(i)));
        }
        return categories;
    }
}
