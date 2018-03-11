package test;
class Two{
    Byte x;
}
public class PassO{
    public static void main(String[] args){
        PassO p=new PassO();
        p.start();
        System.out.println(func ());
    }
    void start(){
        Two t=new Two();
        System.out.print(t.x+" ");
        Two t2=fix(t);
        System.out.print(t.x+" " +t2.x);
    }
    Two fix(Two tt){
        tt.x=42;
        return tt;
    }
    public static int func (){
        try{
            return 1;
        }catch (Exception e){
            return 2;
        }finally{
            return 3;
        }
    }
}