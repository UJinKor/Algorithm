import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;

public class Main_Collection {
    public static void main(String[] args) throws IOException {
        Calendar today = Calendar.getInstance();
        int year = today.get(Calendar.YEAR);
        int month = today.get(Calendar.MONTH);
//        int year = 2020;
//        int month = 1;
        HashMap<Integer,Integer> mMap = new HashMap<>();
        for (int i = 0; i < 12; i++) {
            if(i==0&&i==2&&i==4&&i==6&&i==7&&i==9&&i==11){
                mMap.put(i,31);
            } else if(i == 1){
                if((year % 4 == 0) && (year % 100 != 0) || (year % 400) == 0){
                    mMap.put(i,29);
                } else{
                    mMap.put(i,28);
                }
            } else{
                mMap.put(i,30);
            }
        }
        int days = mMap.get(month);
        System.out.println(days+" days for "+year+"-"+(month+1));
    }
}
