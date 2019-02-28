package com.tencent.mm.plugin.ipcall.a;

import android.database.Cursor;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.ipcall.a.g.b;
import com.tencent.mm.plugin.ipcall.a.g.c;
import com.tencent.mm.plugin.ipcall.a.g.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class a {
    private static a nHT = null;
    private boolean acS = false;
    private long endTime = -1;
    ag handler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            long currentTimeMillis = System.currentTimeMillis();
            d aUk = i.aUk();
            ArrayList<c> arrayList = (ArrayList) message.obj;
            if (arrayList != null && arrayList.size() > 0) {
                long dA = aUk.dA(Thread.currentThread().getId());
                x.i("MicroMsg.IPCallAddressStorage", "getContactIdMap start");
                Cursor a = aUk.gLA.a("IPCallAddressItem", new String[]{"contactId"}, null, null, null, null, null, 2);
                Map hashMap = new HashMap();
                if (a == null || !a.moveToFirst()) {
                    if (a != null) {
                        a.close();
                    }
                    x.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                    for (c cVar : arrayList) {
                        if (!hashMap.containsKey(cVar.field_contactId)) {
                            aUk.b((com.tencent.mm.sdk.e.c) cVar);
                        }
                    }
                    aUk.dB(dA);
                } else {
                    do {
                        String string = a.getString(0);
                        if (!hashMap.containsKey(string)) {
                            hashMap.put(string, Boolean.valueOf(true));
                        }
                    } while (a.moveToNext());
                    if (a != null) {
                        a.close();
                    }
                    x.i("MicroMsg.IPCallAddressStorage", "getContactIdMap end");
                    for (c cVar2 : arrayList) {
                        if (!hashMap.containsKey(cVar2.field_contactId)) {
                            aUk.b((com.tencent.mm.sdk.e.c) cVar2);
                        }
                    }
                    aUk.dB(dA);
                }
            }
            x.d("MicroMsg.IPCallAddressBookLoader", "batchInsert, used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            a.this.endTime = System.currentTimeMillis();
            x.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, used: %dms", Long.valueOf(a.this.endTime - a.this.startTime));
            a.this.acS = false;
            a.this.endTime = -1;
            a.this.startTime = -1;
            Iterator it = a.this.nHS.iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.akx();
                }
            }
            a.this.nHS.clear();
        }
    };
    public ArrayList<a> nHS = new ArrayList();
    private long startTime = -1;

    public interface a {
        void akx();
    }

    private a() {
    }

    public static a aTP() {
        if (nHT == null) {
            nHT = new a();
        }
        return nHT;
    }

    public final void a(a aVar, boolean z) {
        if (aVar != null) {
            this.nHS.add(aVar);
        }
        if (this.acS) {
            x.d("MicroMsg.IPCallAddressBookLoader", "loadAllAddressItem, isLoading is true, ignore");
            return;
        }
        this.startTime = System.currentTimeMillis();
        if (b.aUL().size() == 0 || !z) {
            x.d("MicroMsg.IPCallAddressBookLoader", "loadFromSystemAddressBook");
            long currentTimeMillis = System.currentTimeMillis();
            b bVar = new b();
            ArrayList aUK = b.aUK();
            x.d("MicroMsg.IPCallAddressBookLoader", "getAllAddressItemFromSystemPhoneBook, used %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
            Message obtainMessage = this.handler.obtainMessage();
            obtainMessage.obj = aUK;
            this.handler.sendMessage(obtainMessage);
            this.acS = true;
        }
    }
}
