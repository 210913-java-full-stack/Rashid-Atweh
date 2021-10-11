package collections;

import java.security.PrivateKey;
import java.util.Arrays;

////////////////////////////////// THIS STUFF IS HINTS ABOUT IMPLEMENTING ARRAYLIST ////////////////////////////////////
//      At the core of your arraylist implementation there WILL BE A primitive array.
//    this works - our hack we avoid generics, instead using an array of Objects,
//     because all objects inherit eventually from Object class.
//    Object[] o = new Object[2];
//
//    this doesn't work, can't directly build an array of generics
//    E[] w = new E[2];
//
//    When we want to return our array, we would need to "cast" it like this "(Type) thing" we turn the thing into type.
//    public E[] getArray() {
//        return (E[]) o;
//    }
////////////////////////////////// THIS STUFF IS HINTS ABOUT IMPLEMENTING ARRAYLIST ////////////////////////////////////
public class MyArrayList<E>implements MyArrayListInterface<E>{
    int maxSize;
    private int size = 0;
    int i =5;
    //create new array
    private Object funds[] = new Object[i];

    public MyArrayList()
    {
    }

    @Override
    public int size() {

        return size;
    }

    @Override
    public void add(E e) {
        if(size >= funds.length){
            increaseSize();
        }
        funds[size++] = e;
    }

    @Override
    public void add(E e, int index) {
        if((size+1) >= funds.length)
        {
            increaseSize();
        }
        for(int i = size;i >= index;i--)
        {
            funds[i+1] = funds[i];
        }
        //insert given item at the index provided
        funds[index] = e;
        //increase the size for arrayList.
        size++;
    }

    @Override
    public E get(int index) {
        return (E) funds[index];
        //This is where we cast our Object as out generic E
    }

    @Override
    public void remove(int index) {
        for(int i=index;i<size;i++)
        {
            funds[i] = funds[i+1];
        }
        //decreasing current size because we removed an element.
        size--;

    }

    @Override
    public void clear() {
        initialize();
        //creating a new array with nothing in it, of the same size as our current one.

    }

    private void initialize(){
        Object newArray[] = new Object[size];
        //setting a copy of that new empty array to elements, effectively clearing all objects that were currently in elements.
        funds = Arrays.copyOf(newArray, size);
        size = 0;
    }

    @Override
    public int contains(E e) {
        //go through the elements, if one of them matches return the index it was at.
        for(int i=0;i<size;i++)
        {
            if(funds[i] == e)
            {
                return i;
            }
            else return -1;
        }

//        return -1;
        return 0;
        //write me

    }

    //We will need a growth method
    private void increaseSize() {
        //initialize a new array > than old double the size of the current array.
        int newSize = funds.length * 2;
        //copy current elements into an array of the bigger size and assign to elements.
        funds = Arrays.copyOf(funds, newSize);

    }
}

/* ill leave this stuff here so you still have your code.
 private int size;
    //public static ArrayList<Double> balances = new ArrayList<>();

    public static void AL(double[] args) throws SQLException {
        Connection conn = ConnectionManager.getConnection();
        String sql = "SELECT balance FROM balances b JOIN accounts_customers ac ON ac.account_id = b.account_id JOIN customers c ON c.customer_id = ac.customer_id WHERE uname= ? ";
        PreparedStatement prepareStmt = conn.prepareStatement(sql);
        prepareStmt.setString(1, Username.getUsername());
        ResultSet rs = prepareStmt.executeQuery(); //result set


        // Create an ArrayList object to hold doubles = decimal values
        while (rs.next()) {

                for(int i = 0; i<balances.size(); i++){
                    balances.add(rs);

                }
            System.out.println(balances);
        }
    }
 */