package com.tencent.mm.plugin.location.model;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.plugin.location.a.a;
import com.tencent.mm.plugin.location.a.b;
import com.tencent.mm.pluginsdk.q.q;
import com.tencent.mm.pluginsdk.q.r;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class p implements r {
    private List<q> avD = new LinkedList();
    private ag handler;
    private b nXH;
    private final String path;

    public p() {
        File file = new File(l.aWe());
        if (!file.exists()) {
            file.mkdirs();
        }
        this.path = l.aWe() + "trackroominfolist.info";
        this.handler = new ag(Looper.getMainLooper());
        if (this.nXH != null) {
            return;
        }
        if (e.bO(this.path)) {
            try {
                this.nXH = (b) new b().aH(e.e(this.path, 0, -1));
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
                this.nXH = new b();
                return;
            }
        }
        this.nXH = new b();
    }

    public final synchronized void a(q qVar) {
        this.avD.add(qVar);
    }

    public final synchronized void b(q qVar) {
        this.avD.remove(qVar);
    }

    public final synchronized LinkedList<String> Eg(String str) {
        LinkedList<String> linkedList;
        Iterator it = this.nXH.nWb.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                linkedList = (LinkedList) aVar.fBS.clone();
                break;
            }
        }
        linkedList = new LinkedList();
        return linkedList;
    }

    public final synchronized a Eh(String str) {
        a aVar;
        Iterator it = this.nXH.nWb.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                break;
            }
        }
        aVar = null;
        return aVar;
    }

    public final synchronized void a(String str, LinkedList<String> linkedList, double d, double d2, String str2, String str3, String str4) {
        LinkedList linkedList2;
        a aVar;
        if (linkedList2 == null) {
            linkedList2 = new LinkedList();
        }
        x.i("MicroMsg.TrackRoomListMgr", "updateList talk: %s,  size: %d %f %f", str, Integer.valueOf(linkedList2.size()), Double.valueOf(d), Double.valueOf(d2));
        LinkedList linkedList3 = (LinkedList) linkedList2.clone();
        boolean isEmpty = linkedList3.isEmpty();
        Iterator it = this.nXH.nWb.iterator();
        while (it.hasNext()) {
            aVar = (a) it.next();
            if (aVar.username.equals(str)) {
                if (isEmpty) {
                    this.nXH.nWb.remove(aVar);
                } else {
                    aVar.fBS = linkedList3;
                    aVar.nWa = str2;
                    aVar.latitude = d;
                    aVar.longitude = d2;
                }
                aWp();
                O(str, str3, str4);
            }
        }
        if (!isEmpty) {
            aVar = new a();
            aVar.username = str;
            aVar.fBS = linkedList3;
            aVar.nWa = str2;
            aVar.latitude = d;
            aVar.longitude = d2;
            this.nXH.nWb.add(aVar);
        }
        aWp();
        O(str, str3, str4);
    }

    private void O(String str, String str2, String str3) {
        for (final q qVar : this.avD) {
            final String str4 = str;
            final String str5 = str2;
            final String str6 = str3;
            this.handler.post(new Runnable() {
                public final void run() {
                    qVar.RQ(str4);
                }
            });
        }
    }

    private boolean aWp() {
        x.d("MicroMsg.TrackRoomListMgr", "infoFile infolist size %d", Integer.valueOf(this.nXH.nWb.size()));
        if (this.nXH.nWb.isEmpty()) {
            com.tencent.mm.loader.stub.b.deleteFile(this.path);
            return true;
        }
        try {
            byte[] toByteArray = this.nXH.toByteArray();
            e.b(this.path, toByteArray, toByteArray.length);
            return true;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TrackRoomListMgr", e, "", new Object[0]);
            return false;
        }
    }

    public final boolean Ei(String str) {
        return Eg(str).size() > 0;
    }

    public final boolean aWq() {
        Iterator it = this.nXH.nWb.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            x.d("MicroMsg.TrackRoomListMgr", "info :" + aVar.fBS.size());
            Iterator it2 = aVar.fBS.iterator();
            while (it2.hasNext()) {
                String str = (String) it2.next();
                x.d("MicroMsg.TrackRoomListMgr", "member :" + str);
                if (str.equals(com.tencent.mm.y.q.FY())) {
                    x.i("MicroMsg.TrackRoomListMgr", "now is sharing location..");
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean dl(String str, String str2) {
        return Eg(str).contains(str2);
    }

    public final String aWr() {
        if (this.nXH != null) {
            return this.nXH.nWc;
        }
        return "";
    }

    public final void Ej(String str) {
        if (this.nXH != null) {
            this.nXH.nWc = str;
        }
        aWp();
    }
}
