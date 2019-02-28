package com.tencent.mm.af.a;

import android.database.Cursor;
import com.tencent.mm.f.b.w;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.e.k;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends i<w> {
    public static final String[] gLy = new String[]{i.a(f.gKN, "BizChatMyUserInfo")};
    private e gLA;
    private final k<a, b> hpN = new k<a, b>() {
        protected final /* bridge */ /* synthetic */ void p(Object obj, Object obj2) {
        }
    };

    public interface a {

        public static class b {
            public String fsi;
            public int hsM;
            public f hsN;
        }

        public enum a {
            ;

            static {
                hsI = 1;
                hsJ = 2;
                hsK = 3;
                hsL = new int[]{hsI, hsJ, hsK};
            }
        }
    }

    public g(e eVar) {
        super(eVar, f.gKN, "BizChatMyUserInfo", null);
        this.gLA = eVar;
        eVar.fD("BizChatMyUserInfo", "CREATE INDEX IF NOT EXISTS bizChatbrandUserNameIndex ON BizChatMyUserInfo ( brandUserName )");
    }

    public final f ky(String str) {
        if (bi.oN(str)) {
            x.w("MicroMsg.BizChatMyUserInfoStorage", "get： wrong argument");
            return null;
        }
        c fVar = new f();
        fVar.field_brandUserName = str;
        super.b(fVar, new String[0]);
        return fVar;
    }

    public final boolean kz(String str) {
        boolean z = false;
        if (bi.oN(str)) {
            x.w("MicroMsg.BizChatMyUserInfoStorage", "delete wrong argument");
        } else {
            c fVar = new f();
            fVar.field_brandUserName = str;
            z = super.a(fVar, "brandUserName");
            if (z) {
                b bVar = new b();
                bVar.fsi = fVar.field_brandUserName;
                bVar.hsM = a.hsJ;
                bVar.hsN = fVar;
                this.hpN.cb(bVar);
                this.hpN.doNotify();
            }
        }
        return z;
    }

    public final boolean a(f fVar) {
        x.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert");
        boolean b = super.b((c) fVar);
        if (b) {
            b bVar = new b();
            bVar.fsi = fVar.field_brandUserName;
            bVar.hsM = a.hsI;
            bVar.hsN = fVar;
            this.hpN.cb(bVar);
            this.hpN.doNotify();
        } else {
            x.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage insert fail");
        }
        return b;
    }

    public final boolean b(f fVar) {
        x.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update");
        if (fVar == null) {
            x.w("MicroMsg.BizChatMyUserInfoStorage", "update wrong argument");
            return false;
        }
        boolean a = super.a(fVar);
        if (a) {
            b bVar = new b();
            bVar.fsi = fVar.field_brandUserName;
            bVar.hsM = a.hsK;
            bVar.hsN = fVar;
            this.hpN.cb(bVar);
            this.hpN.doNotify();
            return a;
        }
        x.w("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage update fail");
        return a;
    }

    public final int getCount() {
        int i = 0;
        x.d("MicroMsg.BizChatMyUserInfoStorage", "BizChatMyUserInfoStorage getCount");
        Cursor a = this.gLA.a("SELECT COUNT(*) FROM BizChatMyUserInfo", null, 2);
        if (a.moveToFirst()) {
            i = a.getInt(0);
        }
        a.close();
        return i;
    }
}
