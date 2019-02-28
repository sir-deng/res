package com.tencent.mm.y.b;

import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class b {
    private boolean hka = false;
    public ArrayList<a> mListeners = new ArrayList();

    public interface a {
        void IC();
    }

    public enum b {
        Main,
        Chatting
    }

    public static String Is() {
        as.Hm();
        return (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) "");
    }

    public static String It() {
        as.Hm();
        return (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_URL_STRING_SYNC, (Object) "");
    }

    public static boolean Iu() {
        as.Hm();
        return ((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
    }

    public static String Iv() {
        as.Hm();
        return (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_WORDING_STRING_SYNC, (Object) "");
    }

    public static String Iw() {
        as.Hm();
        return (String) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_URL_STRING_SYNC, (Object) "");
    }

    public static boolean Ix() {
        as.Hm();
        return ((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
    }

    private static boolean Iy() {
        as.Hm();
        return ((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
    }

    private static boolean Iz() {
        as.Hm();
        return ((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
    }

    public final void p(Map<String, String> map) {
        if (map != null) {
            g.pWK.a(633, 3, 1, false);
            Object oM = bi.oM((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.url"));
            Object oM2 = bi.oM((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.wording"));
            long j = bi.getLong((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.duration"), 0);
            boolean z = bi.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.autotrigger"), 0) == 1;
            boolean z2 = bi.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.mainframe.closable"), 0) == 1;
            Object oM3 = bi.oM((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.url"));
            Object oM4 = bi.oM((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.wording"));
            long j2 = bi.getLong((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.duration"), 0);
            boolean z3 = bi.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.autotrigger"), 0) == 1;
            boolean z4 = bi.getInt((String) map.get(".sysmsg.banner.monitorbanner_n.chatting.closable"), 0) == 1;
            if (!bi.oN(oM2) || !bi.oN(oM4)) {
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_WORDING_STRING_SYNC, oM4);
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_URL_STRING_SYNC, oM3);
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(j2));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(z4));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(z3));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_WORDING_STRING_SYNC, oM2);
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_URL_STRING_SYNC, oM);
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(j));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_CLOSABLE_BOOLEAN_SYNC, Boolean.valueOf(z2));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(z));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(bi.Wx()));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false));
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.valueOf(false));
                as.Hm();
                c.Db().lO(true);
                IA();
            }
        }
    }

    public static boolean a(b bVar) {
        long longValue;
        boolean booleanValue;
        boolean Iy;
        String Iv;
        x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: is checking monitor banner scene: %s", bVar);
        long Wx = bi.Wx();
        as.Hm();
        long longValue2 = ((Long) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(-1))).longValue();
        if (bVar == b.Chatting) {
            as.Hm();
            longValue = ((Long) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0))).longValue();
            as.Hm();
            booleanValue = ((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
            Iy = Iy();
            Iv = Iv();
        } else {
            as.Hm();
            longValue = ((Long) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0))).longValue();
            as.Hm();
            booleanValue = ((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
            as.Hm();
            Iy = ((Boolean) c.Db().get(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_AUTOTRIGGER_BOOLEAN_SYNC, Boolean.valueOf(false))).booleanValue();
            Iv = Is();
        }
        if (bi.oN(Iv)) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not get wording");
            return false;
        } else if (booleanValue) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: not check trigger and already closed");
            return false;
        } else if (longValue2 < 0) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: no msg occurs");
            return false;
        } else if (Iy && !Iz()) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: should check triggered but not triggered");
            return false;
        } else if (longValue == -1) {
            x.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: should always show");
            return true;
        } else if (longValue2 + longValue > Wx) {
            x.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: still in show time. show banner");
            return true;
        } else {
            x.i("MicroMsg.ChattingMonitoredBannerStorage", "hy: expired.");
            return false;
        }
    }

    private void IA() {
        synchronized (b.class) {
            Iterator it = this.mListeners.iterator();
            while (it.hasNext()) {
                ((a) it.next()).IC();
            }
        }
    }

    public final void IB() {
        if (!Iz()) {
            x.d("MicroMsg.ChattingMonitoredBannerStorage", "hy: monitored illegal set text. mark now as the start time ");
            as.Hm();
            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MONITOR_BANNER_MSG_COME_TIME_TICKS_LONG_SYNC, Long.valueOf(bi.Wx()));
            as.Hm();
            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MONITOR_IS_TRIGGERED_BOOLEAN_SYNC, Boolean.valueOf(true));
            IA();
        }
    }

    public final void b(b bVar) {
        if (bVar == b.Main) {
            as.Hm();
            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false));
        } else {
            as.Hm();
            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(false));
        }
        IA();
    }

    public final void c(b bVar) {
        if (bVar == b.Main) {
            as.Hm();
            c.Db().a(com.tencent.mm.storage.w.a.USERINFO_MAIN_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0));
        } else if (bVar != b.Chatting) {
            return;
        } else {
            if (Iy()) {
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_BANNER_CLOSED_BOOLEAN_SYNC, Boolean.valueOf(true));
            } else {
                as.Hm();
                c.Db().a(com.tencent.mm.storage.w.a.USERINFO_CHATTING_MONITOR_MAIN_INTERVAL_LONG_SYNC, Long.valueOf(0));
            }
        }
        IA();
    }
}
