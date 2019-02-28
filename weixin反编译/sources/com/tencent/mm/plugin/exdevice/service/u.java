package com.tencent.mm.plugin.exdevice.service;

import com.tencent.mm.plugin.exdevice.model.c;

public final class u {
    private static u lVY = null;
    private c lVZ;
    private f lWa;

    private static u aFr() {
        if (lVY == null) {
            lVY = new u();
        }
        return lVY;
    }

    public static f aFs() {
        if (aFr().lWa == null) {
            aFr().lWa = new f();
        }
        return aFr().lWa;
    }

    public static void a(m mVar) {
        aFt().lQh = mVar;
    }

    public static c aFt() {
        if (aFr().lVZ == null) {
            u aFr = aFr();
            if (c.lQg == null) {
                c.lQg = new c();
            }
            aFr.lVZ = c.lQg;
        }
        return aFr().lVZ;
    }
}
