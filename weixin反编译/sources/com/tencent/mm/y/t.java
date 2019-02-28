package com.tencent.mm.y;

import android.database.Cursor;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class t {
    private static final List<a> hhc = new ArrayList();

    public interface a {
        boolean a(String str, String str2, PInt pInt);
    }

    public static int hy(String str) {
        return a(str, null);
    }

    public static int a(String str, List<String> list) {
        if (g.Do().CF()) {
            int i;
            long Wz = bi.Wz();
            Cursor r = ((h) g.h(h.class)).Fk().r(str, list);
            long Wz2 = bi.Wz();
            if (r == null || r.getCount() <= 0) {
                i = 0;
            } else {
                r.moveToFirst();
                i = r.getInt(0);
            }
            if (r != null) {
                r.close();
            }
            x.d("MicroMsg.ConversationLogic", "unreadcheck unRead getTotalUnread %d", Integer.valueOf(i));
            if (i <= 0) {
                i = 0;
            } else {
                Cursor XO = ((h) g.h(h.class)).Fk().XO(str);
                if (XO == null) {
                    x.w("MicroMsg.ConversationLogic", "cursor is null, return");
                    x.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(bi.bB(Wz2)));
                } else {
                    XO.moveToFirst();
                    while (!XO.isAfterLast()) {
                        int i2;
                        ag Xv = ((h) g.h(h.class)).Ff().Xv(XO.getString(0));
                        if (Xv == null || Xv.fXi != 0) {
                            i2 = i;
                        } else {
                            i2 = i - XO.getInt(1);
                            x.d("MicroMsg.ConversationLogic", "unreadcheck chatroom mute %s, unRead %d,", Xv.field_username, Integer.valueOf(i2));
                        }
                        XO.moveToNext();
                        i = i2;
                    }
                    x.i("MicroMsg.ConversationLogic", "unreadcheck  result talker count is %d", Integer.valueOf(i));
                    XO.close();
                    x.i("MicroMsg.ConversationLogic", "unreadcheck get count use %d ms", Long.valueOf(bi.bB(Wz2)));
                    i = Math.max(0, i);
                }
            }
            r.close();
            x.i("MicroMsg.ConversationLogic", "get count with black list use %d ms", Long.valueOf(bi.bB(Wz)));
            return i;
        }
        x.w("MicroMsg.ConversationLogic", "get total unread with black list, but has not set uin");
        return 0;
    }

    public static int M(String str, String str2) {
        if (g.Do().CF()) {
            int i;
            Cursor fJ = ((h) g.h(h.class)).Fk().fJ(str, str2);
            if (fJ == null || fJ.getCount() <= 0) {
                i = 0;
            } else {
                fJ.moveToFirst();
                i = fJ.getInt(0);
            }
            if (fJ == null) {
                return i;
            }
            fJ.close();
            return i;
        }
        x.w("MicroMsg.ConversationLogic", "get total unread, but has not set uin");
        return 0;
    }

    public static int hz(String str) {
        if (g.Do().CF()) {
            int i;
            long Wz = bi.Wz();
            Cursor s = ((h) g.h(h.class)).Fk().s(str, null);
            if (s.getCount() > 0) {
                s.moveToFirst();
                i = s.getInt(0);
            } else {
                i = 0;
            }
            s.close();
            if (i <= 0) {
                return 0;
            }
            s = ((h) g.h(h.class)).Fk().XO(str);
            if (s == null) {
                x.w("MicroMsg.ConversationLogic", "cursor is null, return");
                x.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(bi.bB(Wz)));
                return i;
            }
            s.moveToFirst();
            while (!s.isAfterLast()) {
                ag Xv = ((h) g.h(h.class)).Ff().Xv(s.getString(0));
                int i2 = (Xv == null || Xv.fXi != 0) ? i : i - 1;
                s.moveToNext();
                i = i2;
            }
            x.i("MicroMsg.ConversationLogic", "result talker count is %d", Integer.valueOf(i));
            s.close();
            x.i("MicroMsg.ConversationLogic", "get count use %d ms", Long.valueOf(bi.bB(Wz)));
            return Math.max(0, i);
        }
        x.w("MicroMsg.ConversationLogic", "get Total Unread Talker, but has not set uin");
        return 0;
    }

    public static List<String> G(String str, int i) {
        List<String> list = null;
        if (g.Do().CF()) {
            Cursor de = ((h) g.h(h.class)).Fk().de(str, -1);
            if (de.moveToNext()) {
                ArrayList arrayList = new ArrayList();
                do {
                    x.d("MicroMsg.ConversationLogic", "jacks need notify talker display name: %s", de.getString(0));
                    arrayList.add(de.getString(0));
                } while (de.moveToNext());
                list = arrayList;
            }
            de.close();
            if (list != null) {
                de = ((h) g.h(h.class)).Fk().XO(str);
                if (de != null) {
                    de.moveToFirst();
                    while (!de.isAfterLast()) {
                        ag Xv = ((h) g.h(h.class)).Ff().Xv(de.getString(0));
                        if (Xv != null && Xv.fXi == 0) {
                            x.d("MicroMsg.ConversationLogic", "jacks need mute notify:  %s", Xv.AW());
                            list.remove(Xv.AW());
                        }
                        de.moveToNext();
                    }
                    de.close();
                }
            }
        } else {
            x.w("MicroMsg.ConversationLogic", "get Total Unread Talker T, but has not set uin");
        }
        return list;
    }

    public static int N(String str, String str2) {
        if (bi.oN(str)) {
            return 0;
        }
        if ("notification_messages".equals(str)) {
            return 8;
        }
        if (str2 != null && str2.endsWith("@chatroom")) {
            return 2;
        }
        boolean z;
        int i;
        PInt pInt = new PInt();
        synchronized (hhc) {
            int i2 = 0;
            z = false;
            while (i2 < hhc.size()) {
                boolean a;
                a aVar = (a) hhc.get(i2);
                if (aVar != null) {
                    a = aVar.a(str, str2, pInt);
                    if (a) {
                        z = a;
                        i = pInt.value;
                        break;
                    }
                } else {
                    a = z;
                }
                i2++;
                z = a;
            }
            i = 0;
        }
        if (z) {
            return i;
        }
        return 1;
    }

    public static void a(a aVar) {
        Assert.assertNotNull(aVar);
        synchronized (hhc) {
            hhc.add(aVar);
        }
    }
}
