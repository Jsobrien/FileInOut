
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class DaltonStudents{

	
	@SuppressWarnings("resource")
	/**
	 * CS3A Data
	 * @author jackobrien
	 * @throws FileNotFoundException
	 */
	public static void main (String []args) throws FileNotFoundException{
		//list
		ArrayList<Student> list = new ArrayList<Student>();
		Scanner scan2 = new Scanner(System.in);



		//fileout
		File fileout = new File("/Users/student/Desktop/output.html");   //output location



		try {
			// if file doesnt exists, then create it



			FileWriter fw = new FileWriter(fileout);

			BufferedWriter bw = new BufferedWriter(fw);



			if (!fileout.exists()) {

				fileout.createNewFile();
				
			}


			BufferedReader file;

			file = new BufferedReader(new FileReader("/Users/Student/Desktop/all_students_jan.csv"));


			//dec
			Scanner scan;
			scan = new Scanner(file);
			String record;
			String[] record_split;
			//while loop
			while(scan.hasNextLine()){
				record = scan.nextLine();
				record_split = record.split(",");
				Student st = new Student(record_split);
				list.add(st);
			}//while
			list.remove(1);
			list.remove(2);



while(true){
			
			//Initial Options
			System.out.println("Hello, I will be helping you go through the database of the students in the school. What would you like to find?");
			System.out.println("Obtain a certain student's information - Enter 1");
			System.out.println("Find all twins - Enter 2");
			System.out.println("Find all students with the same birth month - Enter 3");
			System.out.println("Find all students in a specific house - Enter 4");
			System.out.println("Sort students alphabetically by last name - Enter 5");
			System.out.println("Total number of male students and total number of female students - Enter 6");
			System.out.println("Number of 4th graders vs number 5th grade students - Enter 7");
			System.out.println("All students born in a certain year - Enter 8");
			System.out.println("Top ten most common names - Enter 9");
			System.out.println("Students organized by grade - Enter 10");
			System.out.println("I don't want to do anything. - Enter 11");

			int checker = scan2.nextInt();
			
			//specific student by last name
			if(checker == 1){
				System.out.println("What student would you like to get?"); 
				String b = scan2.next();
				getStudent(list,b,bw);
				//students that were born in a certain month
			}else if(checker == 2){
				getTwins(list,bw);
			}else if(checker == 3){
				System.out.println("Please enter the number of the month you would like?");
				String c = scan2.next();
				getSameMonth(list,c,bw); 
				//gets the a specific house
			}else if(checker == 4){
				System.out.println("Please enter the house you would like to get");
				String d = scan2.next();
				getHouse(list,d,bw); 	
			}else if(checker == 5){
				getLastAlpha(list,bw);
				//gets number of female students vs number of male students
			}else if(checker == 6){
				getGenderTotal(list,bw);
				//gets number of 4th graders vs number of kindergarteners
			}else if(checker == 7){
				getGrade(list,bw);
				//the list of students born in a certain year
			}else if(checker == 8){

				System.out.println("Please enter the year the students were born in that you would like to get");
				String e = scan2.next();
				getSameYear(list,e,bw); 	
				//Students organized by grade
			}else if(checker == 9){
				getPopularNames(list,bw);
			}
			else if(checker == 10){
				getGradeOrdered(list,bw);

			}


			System.out.println("Done!");
			bw.flush();
		}
			
			


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}



	}

	/**
	 * prints the all people with a given last name
	 * @param a
	 * @param b
	 * @param bw
	 * @throws IOException
	 */
	public static void getStudent(ArrayList<Student> a, String b, BufferedWriter bw) throws IOException{
		for(int ii = 0; ii < a.size(); ii++) {
			if(((Student) a.get(ii)).getLast_name().equalsIgnoreCase(b)){
				bw.write(((Student) a.get(ii)).getFirst_name() + " " + ((Student) a.get(ii)).getLast_name() + " " + ((Student) a.get(ii)).getHouse() + "<br>");

			}
		}
	}
	/**
	 * prints all people born in the given month
	 * @param a
	 * @param c
	 * @param bw
	 * @throws IOException
	 */
	public static void getSameMonth(ArrayList<Student> a, String c, BufferedWriter bw) throws IOException{
		for(int ii = 0; ii < 930; ii++) {
			if(((Student) a.get(ii)).getBirth_month().equalsIgnoreCase(c)){
				bw.write(((Student) a.get(ii)).getFirst_name() + " " + ((Student) a.get(ii)).getLast_name() + " " + ((Student) a.get(ii)).getHouse() + "<br>");
			}
		}
	}
	
	/**
	 * prints all people from the given house
	 * @param a
	 * @param d
	 * @param bw
	 * @throws IOException
	 */
	public static void getHouse(ArrayList<Student> a, String d, BufferedWriter bw) throws IOException{
		for(int ii = 0; ii < a.size(); ii++) {
			if(((Student) a.get(ii)).getHouse().contains(d)){
				String s = ((Student) a.get(ii)).getFirst_name() + " " + ((Student) a.get(ii)).getLast_name() + " " + ((Student) a.get(ii)).getHouse() + "<br>";
				bw.write(s);	

			}
		}
	}
	/**
	 *prints all people from the given year
	 * @param a
	 * @param e
	 * @param bw
	 * @throws IOException
	 */
	public static void getSameYear(ArrayList<Student> a, String e, BufferedWriter bw) throws IOException{
		for(int ii = 0; ii < 930; ii++) {
			if(((Student) a.get(ii)).getBirth_year().equalsIgnoreCase(e)){
				bw.write(((Student) a.get(ii)).getFirst_name() + " " + ((Student) a.get(ii)).getLast_name() + " " + ((Student) a.get(ii)).getHouse() + "<br>");





			}
		}
	}
	/**
	 * prints the gender total of each gender
	 * @param a
	 * @param bw
	 * @throws IOException
	 */
	public static void getGenderTotal(ArrayList<Student> a, BufferedWriter bw) throws IOException{

		int m = 0;
		int f = 0;

		for(int ii = 0; ii < a.size(); ii++) {
			if(((Student) a.get(ii)).getGender().equalsIgnoreCase("F")) f++;
			else m++;		
		} bw.write("Number of female students: " + f + "<br>" + " Number of male students: " + m);	

		m = 0;
		f = 0;



	}
	/**
	 * gets the number of fourth and fifth graders
	 * @param a
	 * @param bw
	 * @throws IOException
	 */
	public static void getGrade(ArrayList<Student> a, BufferedWriter bw) throws IOException{
		int four = 0;
		int five = 0;
		for(int ii = 0; ii < a.size(); ii++) {
			if(((Student) a.get(ii)).getGrade_current().equalsIgnoreCase("5")) five++;
			else if(((Student) a.get(ii)).getGrade_current().equalsIgnoreCase("4")) four++;		



		}

		bw.write("Number of fith grade students: " + five + "<br>" + " Number of fourth grade students: " + four);	

		five = 0;
		four = 0;

		bw.flush();
	}
	/**
	 * prints the people in order of grade
	 * @param a
	 * @param bw
	 * @throws IOException
	 */
	public static void getGradeOrdered(ArrayList<Student> a, BufferedWriter bw) throws IOException{	
		for(int ii  = 4; ii < 12;ii++){

			bw.write("<font size = 20>" + " Grade" + (ii+1) + "<br></font>");
			for(int aa  = 0; aa < a.size(); aa++){



				if(((Student) a.get(aa)).getGrade_current().equals(Integer.toString(ii))){
					bw.write(((Student) a.get(aa)).getFirst_name() + " " + ((Student) a.get(aa)).getLast_name() + " " + ((Student) a.get(aa)).getHouse() + "<br>");

				}
			}
		}
	}	

	/**
	 * gets the top ten most popular names
	 * @param a
	 * @param bw
	 * @throws IOException
	 */
	public static void getPopularNames(ArrayList<Student> a, BufferedWriter bw) throws IOException{
		int holdBigPointer = 0;
		int largest;
		int[] nameNum = new int[392];
		String[] nameString = new String[392];
		for(int ll = 0; ll < nameNum.length; ll++){
			nameNum[ll] = 0; 
		}
		ArrayList<String> name = new ArrayList<String>(); 
		for (int i = 0; i < a.size(); i++) {
			name.add(a.get(i).getFirst_name());
		}
		Collections.sort(name);
		String holdName = name.get(1);
		int holdNum = 0;
		int pointer = 0; 
		for(int ii = 2; ii < name.size()-2; ii++){
			if(name.get(ii).equals(holdName)) holdNum++;
			else{ 
				nameNum[pointer] = holdNum;
				nameString[pointer] = holdName;
				pointer++;
				holdName = name.get(ii+1);	
				holdNum = 0;
			}	
		}
		for(int oo = 0; oo < 10; oo ++){
			largest =0;
			for(int uu = 0; uu < nameNum.length; uu++){
				if(nameNum[uu] > largest){
					largest = nameNum[uu];  holdBigPointer = uu;
				}
			}
			bw.write((oo+1) + ". " + nameString[holdBigPointer] + "<br>");
			nameNum[holdBigPointer] = 0;
		}
	}	
	/**
	 * gets all twins
	 * @param a
	 * @param bw
	 * @throws IOException
	 */
	public static void getTwins(ArrayList<Student> a, BufferedWriter bw) throws IOException{
		ArrayList<Student> list2 = a;
		int size = list2.size();
		for (int ii = 0; ii < size;ii++){
			for(int i = 0; i < size;i++){
				if(list2.get(ii).getBirth_day().equals(list2.get(i).getBirth_day()) && 
						list2.get(ii).getBirth_month().equals(list2.get(i).getBirth_month()) &&
						list2.get(ii).getBirth_year().equals(list2.get(i).getBirth_year()) && 
						list2.get(ii).getLast_name().equals(list2.get(i).getLast_name()) && i != ii){



					//gets info
					bw.write(a.get(i).getFirst_name() + " " + a.get(i).getLast_name() + " & " + a.get(ii).getFirst_name() + " " + a.get(ii).getLast_name() + "<br>");
					//removes from list
					list2.get(i).setLast_name(Integer.toString(i));
					list2.get(ii).setLast_name(Integer.toString(ii));
					size= size -2;



				}
			}
		}




	}
	/**
	 * puts the student in alphabetical order by last name
	 * @param a
	 * @param bw
	 * @throws IOException
	 */
	public static void getLastAlpha(ArrayList<Student> a, BufferedWriter bw) throws IOException{
		ArrayList<String> ln = new ArrayList<String>(); 
		for (int i = 0; i < a.size(); i++) {
			ln.add(a.get(i).getLast_name() + " " +  a.get(i).getFirst_name());
		}
		Collections.sort(ln);
		for (int ii = 0; ii < ln.size(); ii++) {
			bw.write(ln.get(ii) + "<br>");
		}
	}	
}//class


