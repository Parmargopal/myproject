import java.lang.reflect.Array;
import java.util.Arrays;

public class Program11 {
    String sortString(String userString)
    {/*
     String s1=userString;
     char temp;
     int j;
     char[]  a=s1.toCharArray();
     int l=a.length;
     for (int i=0;i<l;i++)
     {
         for ( j=0:J<l;j++)
         {
             if(a[j]>a[i])
             {
                  temp=a[i];
                 a[i]=a[j];
                 a[j]=temp;
             }
         }
     }
     for (int i=0;i<=a.length;i++)
     {
         System.out.print(a[i]);

     }
     return new String(a);*/
       String s1=userString;
        char a[]=s1.toCharArray();
        Arrays.sort(a);
        return new String(a);

    }



    public static void main(String[] args) {
        Program11 p11=new Program11();
        System.out.println(p11.sortString("tejas"));
        System.out.println(p11.sortString("hello"));
        System.out.println(p11.sortString("test"));

    }
}
