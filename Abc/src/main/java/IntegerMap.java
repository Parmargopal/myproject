import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerMap {


        Map<String, Integer> stringIntegerMap = new HashMap<>();

        public Map<String, Integer> getCount(List<Student> studentList) {
            for (Student student : studentList) {
                if (stringIntegerMap.containsKey(student.getCollegeName())) {
                    int val = stringIntegerMap.get(student.getCollegeName());
                    stringIntegerMap.replace(student.getCollegeName(), ++val);
                } else {
                    stringIntegerMap.put(student.getCollegeName(), 1);
                }
            }
            return stringIntegerMap;
        }
    }


