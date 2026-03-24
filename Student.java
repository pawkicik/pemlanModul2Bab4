// Modul 2 Bab 4

public class Student {

    private String name;
    private String address;
    private int age;
    private double mathGrade;
    private double englishGrade;
    private double scienceGrade;

    private static int count = 0;


        public Student(){
            name = "";
            address = "";
            age = 0;
            count++;
                        } 

        public Student(String n, String a, int ag){
            name = n;
            address = a;
            age = ag;
            count++;
                        }

        public Student(String n, String a, int ag, double math, double english, double science){
            name = n;
            address= a;
            age = ag;
            mathGrade = math;
            englishGrade = english;
            scienceGrade = science;
            count++;
        }

        public void setName(String n){name = n;}
        public void setAddress(String a){ address = a;}
        public void setAge(int ag){age = ag;}
        public void setMath(double math){ mathGrade = math;}
        public void setEnglish(double english){ englishGrade = english;}
        public void setScience(double science){ scienceGrade = science;}

        public void jumlahObjek(){
            System.out.println("Total objek yang telah dibuat: " + count );
        }
        
        private double getAverage(){ 
            double result = 0;
            result = (mathGrade+scienceGrade+englishGrade)/3; 
            return result;
        }

        public boolean statusAkhir(){
            return getAverage() >= 61;
        }

        public void displayMessage(){
        System.out.println("Siswa dengan nama "+name);
        System.out.println("beramalat di "+address);    
        System.out.println("berumur "+age);
        System.out.println("mempunyai    nilai    rata    rata "+getAverage());

        if (statusAkhir()){
            System.out.println("Status: LOLOS");
        } else {
            System.out.println("Status: REMIDI");
        }
        System.out.println("===================");
        
    } 
}
