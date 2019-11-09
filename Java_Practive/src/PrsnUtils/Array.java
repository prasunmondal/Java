package PrsnUtils;

public class Array {
	
	public static void printArray(int[] array) {
		int i=0;
		System.out.print("[");
		for(i=0; i<array.length-1; i++) {
			System.out.print(array[i] + ", ");
		}System.out.println(array[i] + "]");
	}

	public void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


class Test<T, U> 
{ 
    T obj1;  // An object of type T 
    U obj2;  // An object of type U 
  
    // constructor 
    Test(T obj1, U obj2) 
    { 
        this.obj1 = obj1; 
        this.obj2 = obj2; 
    } 
  
    // To print objects of T and U 
    public void print() 
    { 
        System.out.println(obj1); 
        System.out.println(obj2); 
    } 
}