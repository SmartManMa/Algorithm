package test;
class X{
	  
    Y y=new Y();
    public X(){
    	
        System.out.print("X");
    }
}
class Y{
    public Y(){
        System.out.print("Y");
    }
}
public class InitOrder extends X{
    Y y=new Y();
    public InitOrder(){
        System.out.print("Z");
    }
    public static void main(String[] args) {
        new InitOrder();
    }
}