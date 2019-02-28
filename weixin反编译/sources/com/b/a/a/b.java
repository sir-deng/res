package com.b.a.a;

import android.content.Context;
import com.tencent.rtmp.TXLiveConstants;
import java.util.ArrayList;
import java.util.Collections;

public class b {
    private static volatile Integer acg;

    public static int t(Context context) {
        int i = 2011;
        int i2 = -1;
        if (acg == null) {
            synchronized (b.class) {
                if (acg == null) {
                    long s = a.s(context);
                    if (s == -1) {
                        ArrayList arrayList = new ArrayList();
                        int hM = a.hM();
                        hM = hM <= 0 ? -1 : hM == 1 ? TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER : hM <= 3 ? 2011 : 2012;
                        b(arrayList, hM);
                        long hN = (long) a.hN();
                        hM = hN == -1 ? -1 : hN <= 528000 ? TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER : hN <= 620000 ? TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION : hN <= 1020000 ? 2010 : hN <= 1220000 ? 2011 : hN <= 1520000 ? 2012 : hN <= 2020000 ? 2013 : 2014;
                        b(arrayList, hM);
                        hN = a.s(context);
                        if (hN <= 0) {
                            i = -1;
                        } else if (hN <= 201326592) {
                            i = TXLiveConstants.PLAY_EVT_START_VIDEO_DECODER;
                        } else if (hN <= 304087040) {
                            i = TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION;
                        } else if (hN <= 536870912) {
                            i = 2010;
                        } else if (hN > 1073741824) {
                            i = hN <= 1610612736 ? 2012 : hN <= 2147483648L ? 2013 : 2014;
                        }
                        b(arrayList, i);
                        if (!arrayList.isEmpty()) {
                            Collections.sort(arrayList);
                            if ((arrayList.size() & 1) == 1) {
                                i2 = ((Integer) arrayList.get(arrayList.size() / 2)).intValue();
                            } else {
                                i = (arrayList.size() / 2) - 1;
                                i2 = ((((Integer) arrayList.get(i + 1)).intValue() - ((Integer) arrayList.get(i)).intValue()) / 2) + ((Integer) arrayList.get(i)).intValue();
                            }
                        }
                    } else {
                        i2 = s <= 805306368 ? a.hM() <= 1 ? TXLiveConstants.PLAY_EVT_CHANGE_RESOLUTION : 2010 : s <= 1073741824 ? a.hN() < 1300000 ? 2011 : 2012 : s <= 1610612736 ? a.hN() < 1800000 ? 2012 : 2013 : s <= 2147483648L ? 2013 : s <= 3221225472L ? 2014 : 2015;
                    }
                    acg = Integer.valueOf(i2);
                }
            }
        }
        return acg.intValue();
    }

    private static void b(ArrayList<Integer> arrayList, int i) {
        if (i != -1) {
            arrayList.add(Integer.valueOf(i));
        }
    }
}
