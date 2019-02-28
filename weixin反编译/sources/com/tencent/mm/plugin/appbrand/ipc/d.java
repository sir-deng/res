package com.tencent.mm.plugin.appbrand.ipc;

import android.os.Parcelable;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class d {
    private static final HashMap<String, MMToClientEvent> jeO = new HashMap();

    public static void a(MMToClientEvent mMToClientEvent) {
        x.i("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId:%s, MMToClientEvent.hash:%d", mMToClientEvent.appId, Integer.valueOf(mMToClientEvent.hashCode()));
        if (mMToClientEvent.appId == null) {
            x.e("MicroMsg.MMToClientEventCenter", "register MMToClientEvent.appId is null!!!");
            return;
        }
        synchronized (jeO) {
            if (jeO.get(mMToClientEvent.appId) == null) {
                jeO.put(mMToClientEvent.appId, mMToClientEvent);
            } else {
                x.d("MicroMsg.MMToClientEventCenter", "The CommonConfig is already exist!~ so replace it");
                jeO.remove(mMToClientEvent.appId);
                jeO.put(mMToClientEvent.appId, mMToClientEvent);
            }
        }
    }

    public static void b(MMToClientEvent mMToClientEvent) {
        x.i("MicroMsg.MMToClientEventCenter", "unregister MMToClientEvent.appId:%s", mMToClientEvent.appId);
        synchronized (jeO) {
            jeO.remove(mMToClientEvent.appId);
        }
    }

    public static void k(String str, int i, String str2) {
        MMToClientEvent mMToClientEvent;
        x.i("MicroMsg.MMToClientEventCenter", "notify appId:%s, type:%d, config:%s", str, Integer.valueOf(i), str2);
        synchronized (jeO) {
            mMToClientEvent = (MMToClientEvent) jeO.get(str);
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                mMToClientEvent.jeG = 3;
                mMToClientEvent.appId = str;
                mMToClientEvent.type = i;
                mMToClientEvent.fvi = str2;
                mMToClientEvent.afF();
            }
            return;
        }
        x.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    }

    public static void az(String str, int i) {
        MMToClientEvent mMToClientEvent;
        x.i("MicroMsg.MMToClientEventCenter", "notify unread:%d", Integer.valueOf(i));
        synchronized (jeO) {
            mMToClientEvent = (MMToClientEvent) jeO.get(str);
        }
        if (mMToClientEvent != null) {
            synchronized (mMToClientEvent) {
                mMToClientEvent.jeG = 4;
                mMToClientEvent.fof = i;
                mMToClientEvent.afF();
            }
            return;
        }
        x.e("MicroMsg.MMToClientEventCenter", "notify fail!!! The MMToClientEvent isn't exist!!!");
    }

    public static <T extends Parcelable> void a(T t) {
        MMToClientEvent mMToClientEvent;
        LinkedList linkedList = new LinkedList();
        synchronized (jeO) {
            for (MMToClientEvent mMToClientEvent2 : jeO.values()) {
                linkedList.add(mMToClientEvent2);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            mMToClientEvent2 = (MMToClientEvent) it.next();
            if (t != null) {
                synchronized (mMToClientEvent2) {
                    mMToClientEvent2.jeG = 5;
                    mMToClientEvent2.jeH = t.getClass().getName();
                    mMToClientEvent2.jeI = t;
                    mMToClientEvent2.afF();
                }
            }
        }
    }
}
