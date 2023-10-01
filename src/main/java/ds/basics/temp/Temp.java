package ds.basics.temp;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

class RoomType{
    String name;
    String code;

public RoomType(String name, String code){
    this.name = name;
    this.code = code;
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
public class Temp {

    public static void main(String[] args) {
        List<RoomType> roomTypes = new ArrayList<RoomType>();
        roomTypes.add(new RoomType("King", "KNG"));
        roomTypes.add(new RoomType("Queen", "QS"));
        roomTypes.add(new RoomType("Deluxe", "DL"));
        roomTypes.add(new RoomType("Super", "SP"));

        String room1 = roomTypes.stream()
              .filter(roomType -> roomType.getCode().equalsIgnoreCase("KS")).findAny()
              .map(RoomType::getCode).orElse(null);

        String room2 = roomTypes.stream()
              .filter(roomType -> roomType.getCode().equalsIgnoreCase("KNG")).findAny()
              .map(RoomType::getCode).orElse(null);

        System.out.println(room1==null);
        System.out.println(room2==null);

        StringBuilder i = new StringBuilder();
        System.out.println("I:"+i.toString());
        String n =null, a="a",b="null", c="c";
        //String s = StringUtils.joinn.concat(a).concat(b).concat(c);
        String s = StringUtils.join(n,a,b,c);
        System.out.println(s);

        BigDecimal value1 = new BigDecimal(0);
        BigDecimal value2 = new BigDecimal(2.00);
        BigDecimal value3 = new BigDecimal(12.3);

        System.out.println(value1.setScale(2));
        System.out.println(value2.setScale(2));
        System.out.println(value3.setScale(2,BigDecimal.ROUND_HALF_UP));
        /*int count = 0;
        while(1==1){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                System.out.println("TEST");
            count++;
        }*/

        Calendar hourly = Calendar.getInstance();
        hourly.setTime(new Date());
        hourly.add(Calendar.HOUR, -1); // clean up time
        Date hourlyCutOffTime = hourly.getTime();

        Calendar weekly = Calendar.getInstance();
        weekly.setTime(new Date());
        weekly.add(Calendar.DATE, -7); // clean up time
        Date weeklyCutOffTime = weekly.getTime();

        System.out.println(hourlyCutOffTime);
        System.out.println(weeklyCutOffTime);
        System.out.println(LocalDateTime.now().minusHours(10).getHour());


    }
}
