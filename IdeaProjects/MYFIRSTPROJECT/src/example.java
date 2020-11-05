public class example {
 public example(int a,int b)
 {
     a=a+b;
     b=a-b;
     a=a-b;
     System.out.println(a);
     System.out.println(b);
 }
    public static void main(String[] args) {
     example e1=new example(10,20);

    }
}
