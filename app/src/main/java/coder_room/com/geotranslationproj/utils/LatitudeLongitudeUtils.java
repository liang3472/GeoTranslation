package coder_room.com.geotranslationproj.utils;

import android.content.Context;

import java.math.BigDecimal;

import coder_room.com.geotranslationproj.R;

/**
 * Created by Administrator on 2015/5/27.
 * 经纬度转换工具
 */
public class LatitudeLongitudeUtils {

    /**
     * 维度
     */
    public final static int LATITUDE = 0x00;
    /**
     * 经度
     */
    public final static int LONGITUDE = 0x01;
    //将小数转换为度分秒
    public static String convertToSexagesimal(Context context, double num, int type){
        //获取整数部分
        int angle=(int)Math.floor(Math.abs(num));
        double temp=getdPoint(Math.abs(num))*60;
        //获取整数部分
        int minute=(int)Math.floor(temp);
        int second=(int)Math.floor(getdPoint(temp)*60);
        StringBuilder sb = new StringBuilder(12);
        if(num<0){
            if(type == LATITUDE){
                sb.append(context.getString(R.string.south));
                sb.append(context.getString(R.string.latitude));
                fillNum(context, angle, minute, second, sb);
            }else{
                sb.append(context.getString(R.string.west));
                sb.append(context.getString(R.string.longitude));
                fillNum(context, angle, minute, second, sb);
            }
            return sb.toString();
        }

        if(type == LATITUDE){
            sb.append(context.getString(R.string.north));
            sb.append(context.getString(R.string.latitude));
            fillNum(context, angle, minute, second, sb);
        }else{
            sb.append(context.getString(R.string.east));
            sb.append(context.getString(R.string.longitude));
            fillNum(context, angle, minute, second, sb);
        }
        return sb.toString();
    }

    private static void fillNum(Context context, int du, int fen, int miao, StringBuilder sb) {
        sb.append(du);
        sb.append(context.getString(R.string.degree));
        sb.append(fen);
        sb.append(context.getString(R.string.minute));
        sb.append(miao);
        sb.append(context.getString(R.string.second));
    }

    //获取小数部分
    private static double getdPoint(double num){
        double d = num;
        int fInt = (int) d;
        BigDecimal b1 = new BigDecimal(Double.toString(d));
        BigDecimal b2 = new BigDecimal(Integer.toString(fInt));
        double dPoint = b1.subtract(b2).floatValue();
        return dPoint;
    }
}
