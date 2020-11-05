public class sshort {
    void selction(int a[])
    {
        int i,j;
        for(i=0;i<(a.length)-1;i++)
        {
            for(j=i+1;j<a.length;j++)
            {
                if (a[i]>a[j])
                {
                    int temp=a[j];
                    a[j]=a[i];
                    a[i]=temp;
                }
            }
        }
    }
    void print(int a[])
    {
        for(int i=0;i<a.length;i++)
        {
            System.out.println(a[i]+" ");
        }
    }
    public static void main(String[] args) {
        sshort s1=new sshort();
        int a[]={10,20,5,14,6};
         s1.selction(a);
         System.out.println("selection short");
         s1.print(a
         );
    }
}
