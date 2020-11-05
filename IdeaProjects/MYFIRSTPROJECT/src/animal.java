public class animal {

    private String pass,username;

    public void setpass(String pass)
    {
        this.pass=pass;
    }
    public String getpass()
    {
        return pass;
    }
    public void setUsername(String username)
    {
        this.username=username;
    }
    public String getUsername()
    {
        return username;
    }
    /*void display()
    {

    }*/
    public static void main(String[] args) {
        animal a= new animal();
        a.setpass("gopal");
        a.setUsername("gopal123");
        String a1=a.getpass();
        String a2=a.getUsername();
        System.out.println(a1);
        System.out.println(a2);
        System.out.println(a2);

    }
}
