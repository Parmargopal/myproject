public class Program5 {
    int getCount(char number) {


        int flag = 0;
        String str="01223334494456699999";

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == number) {
                flag++;
            }
        }
        return flag;
    }

    public static void main(String args[]) {
        Program5 p5=new Program5();
        int[] a = new int[20];
        int index=0;

        for(int i=48;i<=57 ; i++)
        {
            a[index++] = p5.getCount((char)i);

        }

        for(int k=0;k<=9;k++){
            System.out.print(k +":" );

            for(int j=0;j<a[k]; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }


}
