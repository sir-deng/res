package com.tencent.mm.storage.emotion;

import android.database.Cursor;
import com.tencent.mm.bx.g;
import com.tencent.mm.bx.g.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;

public final class t extends i<s> implements a {
    public static final String[] gLy = new String[]{i.a(s.gKN, "SmileyPanelConfigInfo")};
    private static final String[] xJl = new String[]{"position", "key"};
    public e gLA;

    public t(e eVar) {
        this(eVar, s.gKN, "SmileyPanelConfigInfo");
    }

    private t(e eVar, c.a aVar, String str) {
        super(eVar, aVar, str, null);
        this.gLA = eVar;
    }

    public final int a(g gVar) {
        if (gVar != null) {
            this.gLA = gVar;
        }
        return 0;
    }

    public final ArrayList<s> aBE() {
        Throwable e;
        ArrayList<s> arrayList = new ArrayList();
        Cursor a;
        try {
            a = this.gLA.a("SmileyPanelConfigInfo", xJl, null, null, null, null, null, 2);
            if (a != null) {
                try {
                    if (a.moveToFirst()) {
                        do {
                            s sVar = new s();
                            sVar.b(a);
                            arrayList.add(sVar);
                        } while (a.moveToNext());
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        x.e("MicroMsg.emoji.SmileyPanelConfigInfoStorage", bi.i(e));
                        if (a != null) {
                            a.close();
                        }
                        return arrayList;
                    } catch (Throwable th) {
                        e = th;
                        if (a != null) {
                            a.close();
                        }
                        throw e;
                    }
                }
            }
            if (a != null) {
                a.close();
            }
        } catch (Exception e3) {
            e = e3;
            a = null;
        } catch (Throwable th2) {
            e = th2;
            a = null;
            if (a != null) {
                a.close();
            }
            throw e;
        }
        return arrayList;
    }
}
