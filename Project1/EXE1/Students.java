package Project1.EXE1;

import java.util.Set;


public class Students {
    public boolean validateGrades(double vathmos_exetasis, double vathmos_ergastiriou) {
        if (vathmos_exetasis < 0 || vathmos_exetasis > 10) {
            System.out.println("Invalid exam grade: " + vathmos_exetasis + ". It must be between 0 and 10.");
            System.exit(1); // Terminate the program due to invalid grades
            return false;
        }
        if (vathmos_ergastiriou < 0 || vathmos_ergastiriou > 10) {
            System.out.println("Invalid lab grade: " + vathmos_ergastiriou + ". It must be between 0 and 10.");
            System.exit(1); // Terminate the program due to invalid grades
            return false;
        }
        return true; // Όλοι οι βαθμοί είναι έγκυροι
    }
        private String name; 
        private int arth_mitrvou;
        private double vathmos_exetasis;
        private double vathmos_ergastiriou;
        private double telikos_vathmos;
    
        public String GetName(){return name;}
        public void SetName(String name){this.name = name;}
        public int GetArthMitrvou(){return arth_mitrvou;}
        public void SetArthMitrvou(int arth_mitrvou){this.arth_mitrvou = arth_mitrvou;}
        public double GetVathmosExetasis(){return vathmos_exetasis;}
        public void SetVathmosExetasis(double vathmos_exetasis){this.vathmos_exetasis = vathmos_exetasis;validateGrades(vathmos_exetasis, vathmos_exetasis);}
        public double GetVathmosErgastiriou(){return vathmos_ergastiriou;}
        public void SetVathmosErgastiriou(double vathmos_ergastiriou){this.vathmos_ergastiriou = vathmos_ergastiriou;validateGrades(vathmos_ergastiriou, vathmos_ergastiriou);}
        public double GetTelikosVathmos(){return telikos_vathmos;}
        public void SetTelikosVathmos(double calculated_telikos_vathmos){this.telikos_vathmos = calculated_telikos_vathmos;}
        
        public double TelikosVathmos(double vathmos_exetasis, double vathmos_ergastiriou){
            double calculated_telikos_vathmos = (0.3 * vathmos_exetasis + 0.7 * vathmos_ergastiriou);
            if (calculated_telikos_vathmos < 5) {
                System.out.println("O/H " + name + " με ΑΜ: "+ arth_mitrvou +" αποτυγχανει με τελικο βαθμό: "+ calculated_telikos_vathmos);
            }else{
                System.out.println("O/H " + name + " με ΑΜ: "+ arth_mitrvou +" προβιβαζεται με τελικο βαθμό: "+ calculated_telikos_vathmos);
            }
            SetTelikosVathmos( calculated_telikos_vathmos);
            return calculated_telikos_vathmos;
        }
}
