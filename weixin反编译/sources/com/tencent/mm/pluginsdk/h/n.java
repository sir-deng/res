package com.tencent.mm.pluginsdk.h;

import android.content.Context;
import android.text.format.DateFormat;
import android.text.format.Time;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.rtmp.sharp.jni.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public final class n {
    private static long vmA;
    private static boolean vmB = false;
    private static final Locale vmC = w.VC(w.cfV());
    private static final boolean vmD = w.cfS();

    public static String ak(String str, long j) {
        return new SimpleDateFormat(str).format(new Date(1000 * j));
    }

    public static String S(Context context, int i) {
        long j = 1000 * ((long) i);
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            return "";
        }
        GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
        long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return p(context, timeInMillis) + ";" + al(context.getString(h.lus), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 86400000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(h.eji) + " " + p(context, timeInMillis) + ";" + al(context.getString(h.lus), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() - 172800000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(h.luu) + " " + p(context, timeInMillis) + ";" + al(context.getString(h.lus), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 86400000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(h.ejh) + " " + p(context, timeInMillis) + ";" + al(context.getString(h.lus), j);
        }
        timeInMillis = j - (gregorianCalendar2.getTimeInMillis() + 172800000);
        if (timeInMillis >= 0 && timeInMillis < 86400000) {
            return context.getString(h.ejf) + " " + p(context, timeInMillis) + ";" + al(context.getString(h.lus), j);
        }
        gregorianCalendar2 = new GregorianCalendar();
        gregorianCalendar2.setTimeInMillis(j);
        int i2 = gregorianCalendar2.get(11);
        if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) == gregorianCalendar2.get(3)) {
            return T(context, gregorianCalendar2.get(7)) + " " + U(context, i2) + ";" + al(context.getString(h.lus), j);
        } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1) && gregorianCalendar.get(3) + 1 == gregorianCalendar2.get(3)) {
            String string;
            int i3 = gregorianCalendar2.get(7);
            StringBuilder stringBuilder = new StringBuilder();
            switch (i3) {
                case 1:
                    string = context.getString(h.luy);
                    break;
                case 2:
                    string = context.getString(h.luw);
                    break;
                case 3:
                    string = context.getString(h.luA);
                    break;
                case 4:
                    string = context.getString(h.luB);
                    break;
                case 5:
                    string = context.getString(h.luz);
                    break;
                case 6:
                    string = context.getString(h.luv);
                    break;
                case 7:
                    string = context.getString(h.lux);
                    break;
                default:
                    string = "";
                    break;
            }
            return stringBuilder.append(string).append(" ").append(U(context, i2)).append(";").append(al(context.getString(h.lus), j)).toString();
        } else if (gregorianCalendar.get(1) == gregorianCalendar2.get(1)) {
            return DateFormat.format(context.getString(h.eiJ), j) + " " + U(context, i2) + ";" + al(context.getString(h.lus), j);
        } else {
            return DateFormat.format(context.getString(h.eiX), j) + " " + U(context, i2) + ";" + al(context.getString(h.lus), j);
        }
    }

    public static String al(String str, long j) {
        String charSequence = DateFormat.format(str, j).toString();
        if (bi.oN(charSequence)) {
            return "";
        }
        charSequence = charSequence.trim();
        if (charSequence.startsWith("0")) {
            return charSequence.substring(1);
        }
        return charSequence;
    }

    public static String T(Context context, int i) {
        switch (i) {
            case 1:
                return context.getString(h.luF);
            case 2:
                return context.getString(h.luD);
            case 3:
                return context.getString(h.luH);
            case 4:
                return context.getString(h.luI);
            case 5:
                return context.getString(h.luG);
            case 6:
                return context.getString(h.luC);
            case 7:
                return context.getString(h.luE);
            default:
                return "";
        }
    }

    public static CharSequence n(Context context, long j) {
        return context.getString(h.luK) + DateFormat.format(context.getString(h.luJ), j);
    }

    public static CharSequence o(Context context, long j) {
        return context.getString(h.luL) + DateFormat.format(context.getString(h.luJ), j);
    }

    private static CharSequence U(Context context, int i) {
        if (i < 0) {
            return "";
        }
        if (((long) i) < 6) {
            return context.getString(h.lun);
        }
        if (((long) i) < 12) {
            return context.getString(h.luq);
        }
        if (((long) i) < 13) {
            return context.getString(h.lur);
        }
        if (((long) i) < 18) {
            return context.getString(h.lul);
        }
        return context.getString(h.luo);
    }

    public static CharSequence p(Context context, long j) {
        if (j < 0) {
            return "";
        }
        if (j < 21600000) {
            return context.getString(h.lun);
        }
        if (j < 43200000) {
            return context.getString(h.luq);
        }
        if (j < 46800000) {
            return context.getString(h.lur);
        }
        if (j < 64800000) {
            return context.getString(h.lul);
        }
        return context.getString(h.luo);
    }

    public static boolean bZK() {
        if (System.currentTimeMillis() - vmA > 30000) {
            vmB = DateFormat.is24HourFormat(ad.getContext());
        }
        return vmB;
    }

    public static CharSequence c(Context context, long j, boolean z) {
        CharSequence charSequence;
        if (!vmD) {
            Locale locale = vmC;
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            if (j < 3600000) {
                return "";
            }
            GregorianCalendar gregorianCalendar2 = new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5));
            long timeInMillis = j - gregorianCalendar2.getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                long timeInMillis2 = (j - gregorianCalendar2.getTimeInMillis()) + 86400000;
                if (timeInMillis2 > 0 && timeInMillis2 <= 86400000) {
                    return z ? context.getString(h.eji) : context.getString(h.eji) + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
                } else {
                    gregorianCalendar2 = new GregorianCalendar();
                    gregorianCalendar2.setTimeInMillis(j);
                    if (gregorianCalendar.get(1) != gregorianCalendar2.get(1) || gregorianCalendar.get(3) != gregorianCalendar2.get(3)) {
                        return gregorianCalendar.get(1) == gregorianCalendar2.get(1) ? z ? java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j)) : java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j)) : z ? java.text.DateFormat.getDateInstance(3, locale).format(Long.valueOf(j)) : java.text.DateFormat.getDateTimeInstance(3, 3, locale).format(Long.valueOf(j));
                    } else {
                        charSequence = new SimpleDateFormat(QLog.TAG_REPORTLEVEL_USER, locale).format(Long.valueOf(j));
                        if (z) {
                            return charSequence;
                        }
                        return charSequence + " " + java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
                    }
                }
            }
            return java.text.DateFormat.getTimeInstance(3, locale).format(Long.valueOf(j));
        } else if (j < 3600000) {
            return "";
        } else {
            Time time = new Time();
            Time time2 = new Time();
            time.set(j);
            time2.setToNow();
            if (time.year == time2.year && time.yearDay == time2.yearDay) {
                if (bZK()) {
                    return m.a(context.getString(h.ejd), time);
                }
                return U(context, time.hour) + m.a(context.getString(h.lus), time);
            } else if (time.year == time2.year && time2.yearDay - time.yearDay == 1) {
                boolean bZK = bZK();
                if (z) {
                    return context.getString(h.eji);
                }
                Object a;
                StringBuilder append = new StringBuilder().append(context.getString(h.eji)).append(" ");
                if (bZK) {
                    a = m.a(context.getString(h.ejd), time);
                } else {
                    a = U(context, time.hour) + m.a(context.getString(h.lus), time);
                }
                return append.append(a).toString();
            } else if (time.year == time2.year && time.getWeekNumber() == time2.getWeekNumber()) {
                charSequence = m.a("E ", time);
                if (z) {
                    return charSequence;
                }
                return charSequence + m.a(context.getString(h.lut), time);
            } else if (time.year == time2.year) {
                if (z) {
                    return m.a(context.getString(h.eiJ), time);
                }
                return m.a(context.getString(h.lum, new Object[]{p(context, ((long) time.hour) * 3600000)}).toString(), time);
            } else if (z) {
                return m.a(context.getString(h.eiX), time);
            } else {
                return m.a(context.getString(h.lup, new Object[]{p(context, ((long) time.hour) * 3600000)}).toString(), time);
            }
        }
    }
}
