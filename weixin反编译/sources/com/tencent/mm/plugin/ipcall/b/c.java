package com.tencent.mm.plugin.ipcall.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.R;
import com.tencent.mm.at.a;
import com.tencent.mm.j.g;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.c.aiq;
import com.tencent.mm.protocal.c.azf;
import com.tencent.mm.protocal.c.buv;
import com.tencent.mm.protocal.c.buw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.y.as;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class c {
    public static buw Y(LinkedList<azf> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        buw buw = new buw();
        buw.xct = linkedList.size();
        buw.xcu = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            azf azf = (azf) it.next();
            buv buv = new buv();
            buv.wXY = DR(azf.wDa);
            buv.wMQ = azf.wMQ;
            buw.xcu.add(buv);
        }
        return buw;
    }

    private static int DR(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i = 0;
                int i2 = 0;
                while (i < address.length) {
                    int i3 = (address[i] & 255) | (i2 << 8);
                    i++;
                    i2 = i3;
                }
                x.d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", str, Integer.valueOf(i2));
                return i2;
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.IPCallUtil", e, "", new Object[0]);
        }
        return 0;
    }

    public static int aVt() {
        Context context = ad.getContext();
        if (ao.is2G(context)) {
            return 1;
        }
        if (ao.is3G(context)) {
            return 3;
        }
        if (ao.is4G(context)) {
            return 5;
        }
        if (ao.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public static String DS(String str) {
        return str.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
    }

    public static String sa(int i) {
        Context context = ad.getContext();
        switch (i) {
            case 1:
                return context.getString(R.l.erF);
            case 2:
                return context.getString(R.l.erF);
            case 6:
                return context.getString(R.l.erB);
            case 7:
                return context.getString(R.l.erC);
            default:
                return context.getString(R.l.erF);
        }
    }

    public static CharSequence h(Context context, long j) {
        return DateFormat.format(context.getString(R.l.ejd), j);
    }

    public static String ap(Context context, String str) {
        int i = 0;
        String[] stringArray = context.getResources().getStringArray(R.c.brb);
        List arrayList = new ArrayList();
        arrayList.add("");
        for (int i2 = i; i2 < stringArray.length; i2++) {
            arrayList.add(stringArray[i2]);
        }
        try {
            i = bi.getInt(str, 0);
        } catch (Exception e) {
        }
        if (i >= arrayList.size()) {
            return "";
        }
        return (String) arrayList.get(i);
    }

    public static String dD(long j) {
        Object obj = 1;
        Context context = ad.getContext();
        if ((dE(j) == 0 ? 1 : null) != null) {
            return new SimpleDateFormat("HH:mm", Locale.US).format(new Date(j));
        }
        if (dE(j) != -1) {
            obj = null;
        }
        if (obj != null) {
            return context.getString(R.l.eqM);
        }
        return new SimpleDateFormat("MM/dd", Locale.US).format(new Date(j));
    }

    private static long dE(long j) {
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(6, 1);
        long timeInMillis2 = instance.getTimeInMillis() - timeInMillis;
        return (j / timeInMillis2) - (Calendar.getInstance().getTimeInMillis() / timeInMillis2);
    }

    public static String dF(long j) {
        Context context = ad.getContext();
        if (((double) j) <= 60.0d) {
            return context.getString(R.l.eqR, new Object[]{String.valueOf(j)});
        }
        int i = (int) (((double) j) / 60.0d);
        if ((((double) j) / 60.0d) - ((double) i) > 0.0d) {
            i++;
        }
        return context.getString(R.l.eqQ, new Object[]{String.valueOf(i)});
    }

    public static boolean cY(Context context) {
        int i;
        if (d.bJa()) {
            i = R.l.epJ;
        } else if (d.bJb()) {
            i = R.l.epI;
        } else if (a.Qr()) {
            i = R.l.epH;
        } else if (com.tencent.mm.o.a.Bd()) {
            i = R.l.epE;
        } else {
            boolean z;
            if (q.a.viX == null || !q.a.viX.bFt()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                i = R.l.epH;
            } else {
                i = 0;
            }
        }
        if (i == 0) {
            return true;
        }
        h.h(context, i, R.l.dGZ);
        return false;
    }

    public static void c(MMActivity mMActivity, String str) {
        ((ClipboardManager) mMActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
    }

    public static String aVu() {
        String string = ad.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
        if (bi.oN(string)) {
            return a.aVr();
        }
        return string.replace("+", "");
    }

    public static boolean aVv() {
        return g.Af().getInt("WCOClosePurchaseEntranceSwitch", 0) != 0;
    }

    public static aiq aVw() {
        as.Hm();
        Object obj = com.tencent.mm.y.c.Db().get(w.a.USERINFO_IPCALL_ACCOUNT_CACHE_STRING, null);
        if (obj != null) {
            aiq aiq = new aiq();
            try {
                aiq.aH(bi.Wj(obj.toString()));
                x.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", aiq.wwB, aiq.nMr, aiq.fpg, aiq.nkL, aiq.wwC, aiq.wwD, aiq.wwE, aiq.wwF, aiq.wwM);
                return aiq;
            } catch (IOException e) {
                x.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", e.getMessage());
            }
        }
        return null;
    }
}
