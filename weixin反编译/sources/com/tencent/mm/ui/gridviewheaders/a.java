package com.tencent.mm.ui.gridviewheaders;

import android.content.Context;
import com.tencent.mm.v.a.k;
import java.util.Calendar;
import java.util.Date;

public class a {
    private static a znE;
    private long znB = Calendar.getInstance().getTimeInMillis();
    private long znC;
    private long znD;

    public static a cyc() {
        if (znE == null) {
            synchronized (a.class) {
                znE = new a();
            }
        }
        return znE;
    }

    private a() {
        Calendar instance = Calendar.getInstance();
        instance.set(7, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.znC = instance.getTimeInMillis();
        instance = Calendar.getInstance();
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        this.znD = instance.getTimeInMillis();
    }

    public final long b(Date date) {
        if (date.getTime() >= this.znC) {
            return Long.MAX_VALUE;
        }
        if (date.getTime() >= this.znD) {
            return 9223372036854775806L;
        }
        return (long) ((date.getYear() * 100) + date.getMonth());
    }

    public static long gs(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance.getTimeInMillis();
    }

    public final String a(Date date, Context context) {
        if (date.getTime() >= this.znC) {
            return context.getString(k.haw);
        }
        if (date.getTime() >= this.znD) {
            return context.getString(k.hav);
        }
        return String.format("%d/%d", new Object[]{Integer.valueOf(date.getYear() + 1900), Integer.valueOf(date.getMonth() + 1)});
    }
}
