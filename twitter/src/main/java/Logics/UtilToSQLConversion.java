package Logics;

import java.util.Date;

public class UtilToSQLConversion {

    public static java.sql.Timestamp init()
    {
        Date dateNow = new Date();
        Date dateExpire = new Date(dateNow.getYear(), dateNow.getMonth(), dateNow.getDate(), dateNow.getHours()+2, dateNow.getMinutes(), dateNow.getSeconds());

        return new java.sql.Timestamp(dateExpire.getTime());
    }
}
