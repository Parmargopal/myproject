import java.util.HashMap;

public class hashmapdemo{
    public static void main(String[] args) {
        HashMap<String,String> hm= new HashMap<String, String>();
        hm.put("105","gopal");
        hm.put("106","gopal");
        hm.put("103","gopal");
        hm.put("106","lalo");
        System.out.println(hm);
        System.out.println(hm.size());
        System.out.println(hm.isEmpty());
        System.out.println(hm.containsKey("105"));
        set s=hm.keySet();

    }
}
