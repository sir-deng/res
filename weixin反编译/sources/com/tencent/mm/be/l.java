package com.tencent.mm.be;

import android.database.Cursor;
import com.tencent.mm.bx.h;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.fm;
import com.tencent.mm.f.a.kl;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import java.util.HashMap;
import java.util.List;

public class l implements ap {
    private static HashMap<Integer, d> gyG;
    public static int[] hUV = new int[1000];
    public static int hUW = 0;
    private final int fgG = 0;
    private n hUN = new n();
    private g hUO;
    private c hUP;
    private d hUQ = new d();
    private i hUR;
    private k hUS;
    private final long hUT = 259200000;
    private final int hUU = 2;
    private c hUX = new c<fm>() {
        {
            this.xmG = fm.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            fm fmVar = (fm) bVar;
            int i = fmVar.fvE.fvG;
            String str = fmVar.fvE.talker;
            int i2 = fmVar.fvE.state;
            if (i == 1) {
                c TE = l.TE();
                b bVar2 = new b();
                bVar2.field_state = -1;
                Cursor a = TE.gLA.a(String.format("select %s from %s where %s = %s", new Object[]{"state", "fmessage_conversation", "talker", h.fg(str)}), null, 2);
                if (a.moveToFirst()) {
                    bVar2.b(a);
                }
                a.close();
                i2 = bVar2.field_state;
            } else if (i == 0) {
                if (i2 == 2) {
                    l.TE().T(str, 2);
                } else if (i2 == 1) {
                    l.TE().T(str, 1);
                } else {
                    l.TE().T(str, 0);
                }
            }
            fmVar.fvF.state = i2;
            return false;
        }
    };

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("LBSVERIFYMESSAGE_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return i.gLy;
            }
        });
        gyG.put(Integer.valueOf("SHAKEVERIFYMESSAGE_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return k.gLy;
            }
        });
        gyG.put(Integer.valueOf("VERIFY_CONTACT_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return m.gLy;
            }
        });
        gyG.put(Integer.valueOf("FMESSAGE_MSGINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return g.gLy;
            }
        });
        gyG.put(Integer.valueOf("FMESSAGE_CONVERSATION_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return c.gLy;
            }
        });
    }

    private static l TC() {
        as.Hg();
        l lVar = (l) bq.ib(l.class.getName());
        if (lVar != null) {
            return lVar;
        }
        Object lVar2 = new l();
        as.Hg().a(l.class.getName(), lVar2);
        return lVar2;
    }

    public static g TD() {
        g.Do().CA();
        if (TC().hUO == null) {
            l TC = TC();
            as.Hm();
            TC.hUO = new g(com.tencent.mm.y.c.Fc());
            TC().hUO.a(TE(), as.Dt().oFY.getLooper());
        }
        return TC().hUO;
    }

    public static c TE() {
        g.Do().CA();
        if (TC().hUP == null) {
            l TC = TC();
            as.Hm();
            TC.hUP = new c(com.tencent.mm.y.c.Fc());
        }
        return TC().hUP;
    }

    public static i TF() {
        g.Do().CA();
        if (TC().hUR == null) {
            l TC = TC();
            as.Hm();
            TC.hUR = new i(com.tencent.mm.y.c.Fc());
        }
        return TC().hUR;
    }

    public static k TG() {
        g.Do().CA();
        if (TC().hUS == null) {
            l TC = TC();
            as.Hm();
            TC.hUS = new k(com.tencent.mm.y.c.Fc());
        }
        return TC().hUS;
    }

    public final void onAccountRelease() {
        com.tencent.mm.ad.d.c.b(Integer.valueOf(37), this.hUN);
        com.tencent.mm.ad.d.c.b(Integer.valueOf(65), this.hUN);
        com.tencent.mm.ad.d.c.b(Integer.valueOf(40), this.hUQ);
        a.xmy.c(this.hUX);
        as.getNotification().xf();
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        com.tencent.mm.ad.d.c.a(Integer.valueOf(37), this.hUN);
        com.tencent.mm.ad.d.c.a(Integer.valueOf(65), this.hUN);
        com.tencent.mm.ad.d.c.a(Integer.valueOf(40), this.hUQ);
        a.xmy.b(this.hUX);
        int Ts = TE().Ts();
        long currentTimeMillis = System.currentTimeMillis();
        as.Hm();
        if (currentTimeMillis - bi.a((Long) com.tencent.mm.y.c.Db().get(340225, null), 0) > 259200000 && Ts > 0) {
            List Tt = TE().Tt();
            int size = Tt.size();
            String str = (String) Tt.get(0);
            Ts = 1;
            while (Ts < size) {
                String str2 = str + ", " + ((String) Tt.get(Ts));
                Ts++;
                str = str2;
            }
            b klVar = new kl();
            klVar.fCD.userName = null;
            klVar.fCD.bgo = str;
            klVar.fCD.type = 0;
            a.xmy.m(klVar);
            as.Hm();
            com.tencent.mm.y.c.Db().set(340225, Long.valueOf(System.currentTimeMillis()));
        }
    }

    public final void bt(boolean z) {
    }
}
