public class Student implements Comparable<Student> {

        private String studentName;
        private String collegeName;
        private String grade;

        public Student(String studentName, String collegeName, String grade) {
            this.studentName = studentName;
            this.collegeName = collegeName;
            this.grade = grade;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public String getStudentName() {
            return studentName;
        }

        public void setStudentName(String studentName) {
            this.studentName = studentName;
        }

        public String getCollegeName() {
            return collegeName;
        }

        public void setCollegeName(String collegeName) {
            this.collegeName = collegeName;
        }





    @Override
    public int compareTo(Student student) {
           Student st=(Student)student;
        return this.getStudentName().compareTo(st.getStudentName());
    }
}


