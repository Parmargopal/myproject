import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NestedMap {

    public Map<String, Map<String, Integer>> getCollegeData(List<Student> studentList) {

        Map<String, Map<String, Integer>> collegeMap = new HashMap<>();
        int count = 1;
        for (Student student : studentList) {
            if (collegeMap.containsKey(student.getCollegeName())) {
                Map<String, Integer> gradeMap = collegeMap.get(student.getCollegeName());

                if (gradeMap.containsKey(student.getGrade())) {
                    gradeMap.replace(student.getGrade(), ++count);
                } else {
                    gradeMap.put(student.getGrade(), 1);
                }
            }
            else {
                Map<String, Integer> gradeMap = new HashMap<>();
                if (student.getGrade() == "A") {
                    gradeMap.put("A", 1);
                } else if (student.getGrade() == "B") {
                    gradeMap.put("B", 1);
                } else {
                    gradeMap.put("C", 1);
                }

                collegeMap.put(student.getCollegeName(), gradeMap);
            }
        }

        return collegeMap;
    }
}
