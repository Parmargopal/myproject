import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapwithList {

    public Map<String, List<String>> getCollegeData(List<Student> studentList) {

        Map<String, List<String>> studentListMap = new LinkedHashMap<>();

        for (Student student : studentList) {
            if (studentListMap.containsKey(student.getCollegeName())) {
                List<String> names = studentListMap.get(student.getCollegeName());
                names.add(student.getStudentName());
                List<String> sortedList = names.stream()
                        .sorted()
                        .collect(Collectors.toList());
                studentListMap.replace(student.getCollegeName(), sortedList);

            } else {
                List<String> studentNames = new ArrayList<>();
                studentNames.add(student.getStudentName());
                studentListMap.put(student.getCollegeName(), studentNames);
            }

        }
        return studentListMap;
    }
}

