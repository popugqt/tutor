public class App {
    public static void main(String[] args) {
        List list = new List();
        
        System.out.println(List.getCount());
        
        List list2 = new List();

        System.out.println(list2.getCount());
    }
}

class List {
    private int arg1; 
    private int arg2; 
    private int arg3; 
    private int arg4;
    private static int count = 0;

    public List() {
        count++;
    }

    public int getArg1() {
        return arg1;
    }

    public void setArg1(int newArg1) {
        arg1 = newArg1;
    }

    public static int getCount() {
        return count;
    }
}