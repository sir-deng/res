package com.tencent.mm.booter.notification.queue;

import com.tencent.mm.booter.notification.NotificationItem;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.sdk.platformtools.x;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class a implements Serializable, Iterable<a> {
    LinkedList<a> gBR;

    public static class a implements Serializable {
        public long frh = -1;
        public boolean gBM = false;
        public int gBS;
        public int gBT = 0;
        public int gBu;
        public String userName = "";

        public a(int i, long j, String str, int i2, boolean z, int i3) {
            a(i, j, str, i2, z, i3);
        }

        public a(int i, boolean z) {
            this.gBS = i;
            this.gBM = z;
        }

        public final void a(int i, long j, String str, int i2, boolean z, int i3) {
            this.gBS = i;
            this.frh = j;
            this.userName = str;
            this.gBu = i2;
            this.gBM = z;
            this.gBT = i3;
        }

        public final String toString() {
            return this.userName + " id:" + this.frh + " unReadCount:" + this.gBu + "　notificationId:" + this.gBS;
        }
    }

    public final String toString() {
        String str = "";
        Iterator it = this.gBR.iterator();
        while (true) {
            String str2 = str;
            if (!it.hasNext()) {
                return str2;
            }
            str = str2 + ((a) it.next()).toString() + ";  ";
        }
    }

    public final synchronized void restore() {
        try {
            this.gBR = (LinkedList) c.eu(com.tencent.mm.j.a.zt().getString("com.tencent.preference.notification.key.queue", ""));
            if (this.gBR == null) {
                this.gBR = new LinkedList();
            }
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
            if (this.gBR == null) {
                this.gBR = new LinkedList();
            }
        } catch (Throwable th) {
            if (this.gBR == null) {
                this.gBR = new LinkedList();
            }
        }
        x.i("MicroMsg.NotificationAppMsgQueue", "restore size:%d, %s", Integer.valueOf(this.gBR.size()), toString());
    }

    private synchronized void save() {
        if (this.gBR != null) {
            x.d("MicroMsg.NotificationAppMsgQueue", "save: size: %d", Integer.valueOf(this.gBR.size()));
            if (this.gBR.isEmpty()) {
                com.tencent.mm.j.a.zt().edit().putString("com.tencent.preference.notification.key.queue", "").apply();
                x.i("MicroMsg.NotificationAppMsgQueue", "reset size:%d, %s", Integer.valueOf(this.gBR.size()), toString());
            } else {
                try {
                    com.tencent.mm.j.a.zt().edit().putString("com.tencent.preference.notification.key.queue", c.a(new LinkedList(this.gBR))).apply();
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.NotificationAppMsgQueue", e, "", new Object[0]);
                }
                x.i("MicroMsg.NotificationAppMsgQueue", "save size:%d, %s", Integer.valueOf(this.gBR.size()), toString());
            }
        }
    }

    public final synchronized void b(NotificationItem notificationItem) {
        Object obj = 1;
        synchronized (this) {
            if (notificationItem != null) {
                if (this.gBR == null) {
                    restore();
                }
                aV(notificationItem.id);
                if (!notificationItem.gBM || t.oN(notificationItem.gBJ)) {
                    this.gBR.add(new a(notificationItem.id, notificationItem.gBM));
                    x.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
                } else {
                    Iterator it = this.gBR.iterator();
                    while (it.hasNext()) {
                        Object obj2;
                        a aVar = (a) it.next();
                        if (aVar.userName.equals(notificationItem.gBJ)) {
                            aVar.a(notificationItem.id, notificationItem.gBK, notificationItem.gBJ, notificationItem.gBL, notificationItem.gBM, notificationItem.gBN);
                            obj2 = null;
                        } else {
                            obj2 = obj;
                        }
                        obj = obj2;
                    }
                    if (obj != null) {
                        this.gBR.add(new a(notificationItem.id, notificationItem.gBK, notificationItem.gBJ, notificationItem.gBL, notificationItem.gBM, notificationItem.gBN));
                        x.d("MicroMsg.NotificationAppMsgQueue", "add: [%s]", notificationItem.toString());
                    }
                }
                save();
            }
        }
    }

    public final synchronized List<Integer> fq(int i) {
        List<Integer> arrayList;
        if (this.gBR == null) {
            restore();
        }
        arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!((aVar.gBT & i) == 0 || arrayList.contains(Integer.valueOf(aVar.gBS)))) {
                arrayList.add(Integer.valueOf(aVar.gBS));
            }
        }
        return arrayList;
    }

    public final synchronized boolean aV(int i) {
        boolean z;
        if (i == -1) {
            z = false;
        } else {
            if (this.gBR == null) {
                restore();
            }
            LinkedList linkedList = new LinkedList();
            Iterator it = this.gBR.iterator();
            Object obj = null;
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar.gBS != i) {
                    linkedList.add(aVar);
                } else {
                    obj = 1;
                }
            }
            if (obj != null) {
                this.gBR = linkedList;
                save();
                z = true;
            } else {
                z = false;
            }
        }
        return z;
    }

    public final synchronized boolean es(String str) {
        boolean z;
        x.i("MicroMsg.NotificationAppMsgQueue", "remove username: %s", str);
        if (t.oN(str)) {
            z = false;
        } else {
            if (this.gBR == null) {
                restore();
            }
            Iterator it = this.gBR.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (str.equals(aVar.userName)) {
                    this.gBR.remove(aVar);
                    save();
                    z = true;
                    break;
                }
            }
            z = false;
        }
        return z;
    }

    public final Iterator<a> iterator() {
        if (this.gBR == null) {
            restore();
        }
        return this.gBR.iterator();
    }
}
