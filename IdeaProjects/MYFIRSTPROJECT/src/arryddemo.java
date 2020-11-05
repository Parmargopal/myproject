public class arryddemo {
    public static void main(String[] args) {
        int[] arry1 = new int[5];
        arry1[0]=23;
        arry1[1]=24;
        arry1[2]=25;
        arry1[3]=28;
        arry1[4]=27;
      /*  for (int i=0;i<arry1.length;i++)
        {
            System.out.println(arry1[i]);
        }*/

        int[] testarry= arry1;
        testarry[2]=83;
        
        for (int num: arry1) {
            System.out.println(num);
        }

    }
}
