
import java.util.ArrayList;
import java.util.List;

public class BerlinClockTest {
 
	 public void getBerlinTime(String time) {
	    	int hhTimePart=Integer.parseInt(time.substring(0,2));
	    	int mmTimePart=Integer.parseInt(time.substring(3,5));
	    	int ssTimePart=Integer.parseInt(time.substring(6,8));
	                System.out.println(displaySS(ssTimePart));
	                System.out.println(displayPrimaryHH(hhTimePart));
	                System.out.println(displaySecondaryHH(hhTimePart));
	                System.out.println(displayPrimaryMM(mmTimePart));
	                System.out.println(displaySecondaryMM(mmTimePart));
	    }
	 
 
    protected String displaySS(int ss) {
    	if (ss%2== 0) 
            return "Y";
            else 
            return "O";
    }
 
    String displayPrimaryHH(int hh){
    	int tempHH=(hh-(hh%5))/5;
    	return getLamps(4,"Y",tempHH);  	
    }
    
    String displaySecondaryHH(int hh){
    	int tempHH=hh%5;
    	return getLamps(4,"Y",tempHH);    	
    }
    String displayPrimaryMM(int mm){
    	String ss="";
    	int tempHH=(mm-(mm%5))/5;
    	ss=getLamps(11,"Y",tempHH);
    	return ss.replace("YYY", "YYR");    	
    }
    String displaySecondaryMM(int mm){
    	int tempHH=mm%5;
    	return getLamps(4,"Y",tempHH);  	
    }
    String getLamps(int maxSign,String c,int onSign){
    	String s="";
    	for(int i=0;i<onSign;i++){
    		s=s.concat(c);
    	}
    	for(int i=0;i<maxSign-onSign;i++){
    		s=s.concat("O");
    	}
    	return s;
    }
public static void main(String[] args) {
		BerlinClockTest b=new BerlinClockTest();
		b.getBerlinTime("23:33:33");
	}

 
}
