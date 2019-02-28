package com.tencent.mm.booter.notification.queue;

import android.os.Build.VERSION;
import android.support.v4.app.ag;
import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public final class b implements Iterable<NotificationItem> {
    public NotificationQueue gBV;
    public a gBW;
    public int mark;

    private static final class a {
        private static final b gBX = new b();
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static final b xp() {
        return a.gBX;
    }

    private b() {
        this.mark = -1;
        this.gBV = new NotificationQueue();
        this.gBW = new a();
        restore();
    }

    public final void restore() {
        this.gBV.restore();
        this.gBW.restore();
    }

    public final int size() {
        NotificationQueue notificationQueue = this.gBV;
        if (notificationQueue.gBU == null) {
            notificationQueue.restore();
        }
        return notificationQueue.gBU.size();
    }

    public final NotificationItem xq() {
        for (int i = 0; i < size(); i++) {
            NotificationQueue notificationQueue = this.gBV;
            if (notificationQueue.gBU == null) {
                notificationQueue.restore();
            }
            NotificationItem notificationItem = (NotificationItem) notificationQueue.gBU.get(i);
            if (notificationItem.gBM) {
                if (this.gBW.aV(notificationItem.id)) {
                    x.d("MicroMsg.NotificationAppMsgQueue", "remove: [%s]", notificationItem.toString());
                }
                this.gBV.c(notificationItem);
                return notificationItem;
            }
        }
        return null;
    }

    public final void remove(int i) {
        this.gBW.aV(i);
        NotificationItem fr = this.gBV.fr(i);
        if (fr != null) {
            fr.clear();
        }
    }

    public final Queue<Integer> xr() {
        Queue<Integer> linkedList = new LinkedList();
        for (int i = 4097; i < 4102; i++) {
            linkedList.add(Integer.valueOf(i));
        }
        linkedList.addAll(xs());
        return linkedList;
    }

    private Queue<Integer> xs() {
        Queue<Integer> linkedList = new LinkedList();
        Queue<NotificationItem> linkedList2 = new LinkedList();
        NotificationQueue notificationQueue = this.gBV;
        if (notificationQueue.gBU == null) {
            notificationQueue.restore();
        }
        linkedList2.addAll(notificationQueue.gBU);
        for (NotificationItem notificationItem : linkedList2) {
            if (notificationItem.gBM) {
                linkedList.add(Integer.valueOf(notificationItem.id));
                x.d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(notificationItem.id));
            }
        }
        linkedList2.clear();
        Queue<com.tencent.mm.booter.notification.queue.a.a> linkedList3 = new LinkedList();
        a aVar = this.gBW;
        if (aVar.gBR == null) {
            aVar.restore();
        }
        linkedList3.addAll(aVar.gBR);
        for (com.tencent.mm.booter.notification.queue.a.a aVar2 : linkedList3) {
            if (aVar2.gBM) {
                linkedList.add(Integer.valueOf(aVar2.gBS));
                x.d("MicroMsg.Notification.Queue", "remove allcustom: %d", Integer.valueOf(aVar2.gBS));
            }
        }
        linkedList3.clear();
        return linkedList;
    }

    public final int getId(String str) {
        if (t.oN(str)) {
            return -1;
        }
        Iterator it = this.gBW.iterator();
        while (it.hasNext()) {
            com.tencent.mm.booter.notification.queue.a.a aVar = (com.tencent.mm.booter.notification.queue.a.a) it.next();
            if (aVar.userName.equals(str)) {
                return aVar.gBS;
            }
        }
        return -1;
    }

    public final void cancel(int i) {
        a(ag.j(ad.getContext()), i);
    }

    public final void a(ag agVar, int i) {
        ag.ta.a(agVar.sX, null, i);
        if (VERSION.SDK_INT <= 19) {
            agVar.a(new a(agVar.mContext.getPackageName(), i, null));
        }
        remove(i);
    }

    public final int et(String str) {
        int id = getId(str);
        return id > 0 ? id : aZ(true);
    }

    public final int aZ(boolean z) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "";
        Iterator it = this.gBW.iterator();
        while (true) {
            str = str2;
            if (!it.hasNext()) {
                break;
            }
            str2 = str + ((com.tencent.mm.booter.notification.queue.a.a) it.next()).gBS + ",";
        }
        int i = z ? 4097 : 4102;
        while (str.contains(String.valueOf(i))) {
            i++;
        }
        if (i >= 4102 && z) {
            i = 4097;
        }
        x.d("MicroMsg.Notification.Queue", "create id spend: %d, id: %d, isCustomControl: %B", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Integer.valueOf(i), Boolean.valueOf(z));
        return i;
    }

    public final Iterator<NotificationItem> iterator() {
        NotificationQueue notificationQueue = this.gBV;
        if (notificationQueue.gBU == null) {
            notificationQueue.restore();
        }
        return notificationQueue.gBU.iterator();
    }
}
