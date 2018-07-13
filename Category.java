public class Category {
    private Customer customer;
    private Day day;
    Category(Customer customer,Day day)
    {
        this.customer=customer;
        this.day=day;
    }
    public Customer getCustomer()
    {
        return customer;
    }
    public Day getDay()
    {
        return day;
    }

    @Override
    public boolean equals(Object obj) {
        Category category=(Category) obj;
        if(category.getCustomer().toString().equals(this.getCustomer().toString()))
        {
            if(category.getDay().toString().equals(this.getDay().toString()))
            {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result=17;
        result=31*result+this.customer.hashCode();
        result=31*result+this.day.hashCode();
        return result;
    }
}
