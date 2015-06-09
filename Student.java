public class Student{

	
	
	
		 String first_name;
		
		 //methods not gets/sets
		
		 
		 public String getFirst_name() {
			return first_name;
		}	

		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}

		public String getMiddle_name() {
			return middle_name;
		}

		public void setMiddle_name(String middle_name) {
			this.middle_name = middle_name;
		}

		public String getLast_name() {
			return last_name;
		}

		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getAge() {
			return age;
		}

		public void setAge(String age) {
			this.age = age;
		}

		public String getBirth_day() {
			return birth_day;
		}

		public void setBirth_day(String birth_day) {
			this.birth_day = birth_day;
		}

		public String getBirth_month() {
			return birth_month;
		}

		public void setBirth_month(String birth_month) {
			this.birth_month = birth_month;
		}

		public String getGrade_start() {
			return grade_start;
		}

		public void setGrade_start(String grade_start) {
			this.grade_start = grade_start;
		}

		public String getGrade_current() {
			return grade_current;
		}

		public void setGrade_current(String grade_current) {
			this.grade_current = grade_current;
		}

		public String getBirth_year() {
			return birth_year;
		}

		public void setBirth_year(String birth_year) {
			this.birth_year = birth_year;
		}

		public String getHouse() {
			return house;
		}

		public void setHouse(String house) {
			this.house = house;
		}

		String middle_name;
		 String last_name;
		 String gender;
		 String age;
		 String birth_day;
		 String birth_month;
		 String grade_start;
		 String grade_current;
		 String birth_year;
		 String house;

		public Student(String a[]){	
			first_name = a[0];
			middle_name = a[1];
			last_name = a[2];
			gender = a[3];
			grade_start = a[4];
			grade_current = a[5];
			age = a[6];
			birth_day = a[7];
			birth_month = a[8];
			birth_year = a[9];
			house = a[10];
		}

		
		
		
	}
