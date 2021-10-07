package collections;

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
public class MyArrayList<E> implements MyListInterface<E>{
    int size;
    int maxSize;
    Object[] array;


    public MyArrayList() {
        initialize();
//        maxSize = 2;
//        size = 0;
//        array = new Object[maxSize];
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E e) {
//write me
    }

    @Override
    public void add(E e, int index) {

//write me

    }

    @Override
    public E get(int index) {
        //write me

        //return (E)array[0];//not actually valid, just a hint. This is where we need to cast our Object as out generic E
        return null;
    }

    @Override
    public void remove(int index) {
//write me

    }

    @Override
    public void clear() {
        initialize();
//        maxSize = 2;
//        size = 0;
//        array = new Object[maxSize];
    }

    private void initialize(){
        maxSize = 2;
        size = 0;
        array = new Object[maxSize];
    }

    @Override
    public int contains(E e) {
        return 0;
        //write me

    }

    //We will need a growth method
    private void growArray() {
        //initialize a new array > than old - lets do x2 max size.
        //copy the old array into the new array
        //set the array reference to the new array - discarding the old one for garbage collection
        //update max size with the new array size.


        /* This is a manual copy by looping and copying each element. We can also just use Arrays.copyOf(), which under the good does the same thing.
        Object[] temp = new Object[maxSize];
        for (int i = 0; i < size; i++) {
            temp[i] = array[i];
        }
        */

        maxSize *= 2;
        array = Arrays.copyOf(array, maxSize);

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


