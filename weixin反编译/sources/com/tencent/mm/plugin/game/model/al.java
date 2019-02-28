package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.c.bv;
import com.tencent.mm.plugin.game.c.dj;
import com.tencent.mm.plugin.game.c.dv;
import com.tencent.mm.plugin.game.c.n;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView;
import com.tencent.mm.sdk.platformtools.x;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;

public final class al extends ad {
    public bv njD;
    public LinkedList<d> njE;
    public LinkedList<d> njF;
    private int nja;

    public al(a aVar, boolean z, int i) {
        this.nja = 0;
        if (aVar == null) {
            this.njD = new bv();
            return;
        }
        this.njD = (bv) aVar;
        this.nja = i;
        this.njE = aRx();
        this.njF = aRy();
        if (z) {
            SubCoreGameCenter.aRO().a("pb_library", aVar);
        }
        d.V(this.njE);
        d.V(this.njF);
    }

    public al(byte[] bArr) {
        this.nja = 0;
        this.njD = new bv();
        if (bArr != null && bArr.length != 0) {
            try {
                this.njD.aH(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataLibrary", "Parsing Failed: %s", e.getMessage());
            }
            this.njE = aRx();
            this.njF = aRy();
            d.V(this.njE);
            d.V(this.njF);
        }
    }

    private LinkedList<d> aRx() {
        LinkedList<d> linkedList = new LinkedList();
        if (this.njD.noo == null || this.njD.noo.npc == null || this.njD.noo.npc.npw == null) {
            return linkedList;
        }
        Iterator it = this.njD.noo.npc.npw.iterator();
        int i = 1;
        while (it.hasNext()) {
            dj djVar = (dj) it.next();
            d a = ad.a(djVar.nkO);
            if (a != null) {
                a.ngJ = djVar.nkO.nld;
                a.scene = 11;
                a.fGe = 1110;
                int i2 = i + 1;
                a.position = i;
                linkedList.add(a);
                i = i2;
            }
        }
        return linkedList;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.LinkedList<com.tencent.mm.plugin.game.model.d> aRy() {
        /*
        r8 = this;
        r3 = new java.util.LinkedList;
        r3.<init>();
        r0 = r8.njD;
        r0 = r0.nop;
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        r0 = r3;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r8.nja;
        r1 = r0 + 1;
        r0 = r8.nja;
        r0 = r0 / 15;
        r0 = r0 + 901;
        r2 = r8.njD;
        r2 = r2.nop;
        r5 = r2.iterator();
        r2 = r1;
        r1 = r0;
    L_0x0021:
        r0 = r5.hasNext();
        if (r0 == 0) goto L_0x007a;
    L_0x0027:
        r0 = r5.next();
        r0 = (com.tencent.mm.plugin.game.c.c) r0;
        r4 = 0;
        r6 = r0.kzz;
        switch(r6) {
            case 1: goto L_0x0046;
            case 2: goto L_0x0056;
            default: goto L_0x0033;
        };
    L_0x0033:
        r0 = r1;
        r1 = r2;
        r2 = r4;
    L_0x0036:
        if (r2 == 0) goto L_0x007c;
    L_0x0038:
        r4 = 11;
        r2.scene = r4;
        r4 = 1111; // 0x457 float:1.557E-42 double:5.49E-321;
        r2.fGe = r4;
        r3.add(r2);
        r2 = r1;
        r1 = r0;
        goto L_0x0021;
    L_0x0046:
        r0 = r0.nkO;
        r0 = com.tencent.mm.plugin.game.model.ad.a(r0);
        if (r0 == 0) goto L_0x0083;
    L_0x004e:
        r4 = r2 + 1;
        r0.position = r2;
        r2 = r0;
        r0 = r1;
        r1 = r4;
        goto L_0x0036;
    L_0x0056:
        r6 = r0.nkR;
        if (r6 == 0) goto L_0x0033;
    L_0x005a:
        r4 = r0.nkR;
        r4 = r4.nkO;
        r4 = com.tencent.mm.plugin.game.model.ad.a(r4);
        if (r4 == 0) goto L_0x007f;
    L_0x0064:
        r6 = 1;
        r4.type = r6;
        r6 = r0.nkR;
        r6 = r6.nkQ;
        r4.ngB = r6;
        r0 = r0.nkR;
        r0 = r0.nkP;
        r4.ngC = r0;
        r0 = r1 + 1;
        r4.position = r1;
        r1 = r2;
        r2 = r4;
        goto L_0x0036;
    L_0x007a:
        r0 = r3;
        goto L_0x000c;
    L_0x007c:
        r2 = r1;
        r1 = r0;
        goto L_0x0021;
    L_0x007f:
        r0 = r1;
        r1 = r2;
        r2 = r4;
        goto L_0x0036;
    L_0x0083:
        r7 = r0;
        r0 = r1;
        r1 = r2;
        r2 = r7;
        goto L_0x0036;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.game.model.al.aRy():java.util.LinkedList<com.tencent.mm.plugin.game.model.d>");
    }

    public final HashMap<Integer, String> aRz() {
        HashMap<Integer, String> linkedHashMap = new LinkedHashMap();
        if (this.njD.noo == null || this.njD.noo.npf == null) {
            return linkedHashMap;
        }
        Iterator it = this.njD.noo.npf.iterator();
        while (it.hasNext()) {
            dv dvVar = (dv) it.next();
            int i = dvVar.nom;
            linkedHashMap.put(Integer.valueOf(i), dvVar.nkW);
        }
        return linkedHashMap;
    }

    public final LinkedList<GameLibraryCategoriesView.a> aRA() {
        if (this.njD.noo == null || this.njD.noo.npd == null) {
            return null;
        }
        int i = 0;
        LinkedList<GameLibraryCategoriesView.a> linkedList = new LinkedList();
        Iterator it = this.njD.noo.npd.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return linkedList;
            }
            n nVar = (n) it.next();
            GameLibraryCategoriesView.a aVar = new GameLibraryCategoriesView.a();
            aVar.nxL = nVar.nlF;
            aVar.nxM = nVar.nkW;
            aVar.nxN = nVar.nkQ;
            aVar.iNr = nVar.nkV;
            i = i2 + 1;
            aVar.position = i;
            linkedList.add(aVar);
        }
    }
}
