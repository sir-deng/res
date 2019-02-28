package com.tencent.mm.plugin.game.d;

import android.content.Context;
import com.tencent.mm.R;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b {
    private static Map<String, List<String>> nCE = new HashMap();
    private static Map<String, List<String>> nCF = new HashMap();
    public static HashMap<Long, Long> nCG = new HashMap();
    public static HashMap<Long, String> nCH = new HashMap();

    public static String f(Context context, long j) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        long timeInMillis = gregorianCalendar.getTimeInMillis();
        if (nCG.containsKey(Long.valueOf(j))) {
            if (timeInMillis - ((Long) nCG.get(Long.valueOf(j))).longValue() >= 60000) {
                nCG.remove(Long.valueOf(j));
            } else if (nCH.containsKey(Long.valueOf(j))) {
                return (String) nCH.get(Long.valueOf(j));
            }
        }
        int i;
        String quantityString;
        if ((timeInMillis - j) / 3600000 == 0) {
            i = (int) ((timeInMillis - j) / 60000);
            if (i <= 0) {
                i = 1;
            }
            quantityString = context.getResources().getQuantityString(R.j.duF, i, new Object[]{Integer.valueOf(i)});
            nCH.put(Long.valueOf(j), quantityString);
            nCG.put(Long.valueOf(j), Long.valueOf(timeInMillis));
            return quantityString;
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis2 = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
            timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
            if (timeInMillis2 <= 0 || timeInMillis2 > 86400000) {
                i = (int) (((gregorianCalendar2.getTimeInMillis() + 86400000) - j) / 86400000);
                if (i <= 0) {
                    i = 1;
                }
                quantityString = context.getResources().getQuantityString(R.j.duG, i, new Object[]{Integer.valueOf(i)});
                nCH.put(Long.valueOf(j), quantityString);
                nCG.put(Long.valueOf(j), Long.valueOf(timeInMillis));
                return quantityString;
            }
            quantityString = context.getString(R.l.eji);
            nCH.put(Long.valueOf(j), quantityString);
            nCG.put(Long.valueOf(j), Long.valueOf(timeInMillis));
            return quantityString;
        }
        i = (int) ((timeInMillis - j) / 3600000);
        if (i <= 0) {
            i = 1;
        }
        quantityString = context.getResources().getQuantityString(R.j.duE, i, new Object[]{Integer.valueOf(i)});
        nCH.put(Long.valueOf(j), quantityString);
        nCG.put(Long.valueOf(j), Long.valueOf(timeInMillis));
        return quantityString;
    }
}
