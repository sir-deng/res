package com.tencent.mm.modelfriend;

import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.ad.k;
import com.tencent.mm.bm.a;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.f.a.as;
import com.tencent.mm.f.a.hc;
import com.tencent.mm.f.a.ho;
import com.tencent.mm.f.a.j;
import com.tencent.mm.f.a.oz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.h;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.pluginsdk.q;
import com.tencent.mm.protocal.c.ady;
import com.tencent.mm.protocal.c.aph;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.bq;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class af implements ap {
    private static HashMap<Integer, d> gyG;
    private c hyN;
    private i hyO;
    private l hyP;
    private ac hyQ;
    private ae hyR;
    private r hyS;
    private p hyT;
    private e hyU = new e();
    private LinkedList<aph> hyV = null;
    private d hyW = new d();
    private f hyX = new f();
    private g hyY = new g();
    private c hyZ = new c<as>() {
        {
            this.xmG = as.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            as asVar = (as) bVar;
            if (asVar instanceof as) {
                asVar.fpL.foB = m.NW();
            }
            return false;
        }
    };
    private c hza = new c<ho>() {
        {
            this.xmG = ho.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ho hoVar = (ho) bVar;
            if (hoVar instanceof ho) {
                int i = hoVar.fyL.scene;
                k vVar = new v();
                ((ady) vVar.gLB.hnQ.hnY).sfa = i;
                com.tencent.mm.y.as.CN().a(vVar, 0);
            }
            return false;
        }
    };
    private c hzb = new c<hc>() {
        {
            this.xmG = hc.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            hc hcVar = (hc) bVar;
            if (hcVar instanceof hc) {
                String str = hcVar.fye.fyg;
                if (bi.oN(str)) {
                    x.e("MicroMsg.SubCoreFriend", "hy: mobile number is null");
                } else {
                    Cursor a = af.OJ().hiZ.a("select addr_upload2.username from addr_upload2 where addr_upload2.moblie = " + str, null, 2);
                    List linkedList = new LinkedList();
                    while (a.moveToNext()) {
                        linkedList.add(a.getString(0));
                    }
                    a.close();
                    x.i("MicroMsg.SubCoreFriend", "hy: username: %s", linkedList.size() == 0 ? "" : (String) linkedList.get(0));
                    hcVar.fyf.userName = str;
                }
            }
            return false;
        }
    };
    private c hzc = new c<oz>() {
        {
            this.xmG = oz.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            oz ozVar = (oz) bVar;
            Intent intent = ozVar.fHJ.intent;
            String str = ozVar.fHJ.username;
            if (intent == null || str == null || str.length() == 0) {
                x.e("MicroMsg.AccountSyncUtil", "setLocalQQMobile fail, intent = " + intent + ", username = " + str);
            } else {
                ad lf = af.OO().lf(str);
                if (lf != null) {
                    intent.putExtra("Contact_Uin", lf.hyC);
                    intent.putExtra("Contact_QQNick", lf.getDisplayName());
                }
                b kU = af.OJ().kU(str);
                if (kU != null) {
                    intent.putExtra("Contact_Mobile_MD5", kU.Nx());
                }
            }
            return false;
        }
    };
    private c hzd = new c<j>() {
        {
            this.xmG = j.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            a.CV(((j) bVar).fnT.scene);
            return false;
        }
    };

    private static af OI() {
        com.tencent.mm.y.as.Hg();
        af afVar = (af) bq.ib(af.class.getName());
        if (afVar != null) {
            return afVar;
        }
        Object afVar2 = new af();
        com.tencent.mm.y.as.Hg().a(af.class.getName(), afVar2);
        return afVar2;
    }

    public static c OJ() {
        g.Do().CA();
        if (OI().hyN == null) {
            af OI = OI();
            com.tencent.mm.y.as.Hm();
            OI.hyN = new c(com.tencent.mm.y.c.Fc());
        }
        return OI().hyN;
    }

    public static i OK() {
        g.Do().CA();
        if (OI().hyO == null) {
            af OI = OI();
            com.tencent.mm.y.as.Hm();
            OI.hyO = new i(com.tencent.mm.y.c.Fc());
        }
        return OI().hyO;
    }

    public static l OL() {
        g.Do().CA();
        if (OI().hyP == null) {
            af OI = OI();
            com.tencent.mm.y.as.Hm();
            OI.hyP = new l(com.tencent.mm.y.c.Fc());
        }
        return OI().hyP;
    }

    public static ac OM() {
        g.Do().CA();
        if (OI().hyQ == null) {
            af OI = OI();
            com.tencent.mm.y.as.Hm();
            OI.hyQ = new ac(com.tencent.mm.y.c.Fc());
        }
        return OI().hyQ;
    }

    public static r ON() {
        g.Do().CA();
        if (OI().hyS == null) {
            af OI = OI();
            com.tencent.mm.y.as.Hm();
            OI.hyS = new r(com.tencent.mm.y.c.Fc());
        }
        return OI().hyS;
    }

    public static ae OO() {
        g.Do().CA();
        if (OI().hyR == null) {
            af OI = OI();
            com.tencent.mm.y.as.Hm();
            OI.hyR = new ae(com.tencent.mm.y.c.Fc());
        }
        return OI().hyR;
    }

    public static void f(LinkedList<aph> linkedList) {
        g.Do().CA();
        OI().hyV = linkedList;
    }

    public static LinkedList<aph> OP() {
        g.Do().CA();
        return OI().hyV;
    }

    public static void OQ() {
        g.Do().CA();
        OI().hyV = null;
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.xmy.c(this.hzc);
        com.tencent.mm.sdk.b.a.xmy.c(this.hzd);
        com.tencent.mm.sdk.b.a.xmy.c(this.hzb);
        com.tencent.mm.sdk.b.a.xmy.c(this.hyW);
        com.tencent.mm.sdk.b.a.xmy.c(this.hyX);
        com.tencent.mm.sdk.b.a.xmy.c(this.hyY);
        com.tencent.mm.sdk.b.a.xmy.c(this.hyZ);
        com.tencent.mm.sdk.b.a.xmy.c(this.hza);
        com.tencent.mm.ad.d.c.b(Integer.valueOf(42), this.hyU);
        com.tencent.mm.ad.d.c.b(Integer.valueOf(66), this.hyU);
        this.hyV = null;
        q.a.vji = null;
    }

    public final void ge(int i) {
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("ADDR_UPLOAD_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return c.gLy;
            }
        });
        gyG.put(Integer.valueOf("FACE_BOOK_FIREND_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return i.gLy;
            }
        });
        gyG.put(Integer.valueOf("FRIEND_EXT_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return l.gLy;
            }
        });
        gyG.put(Integer.valueOf("QQ_GROUP_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return ac.gLy;
            }
        });
        gyG.put(Integer.valueOf("QQ_LIST_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return ae.gLy;
            }
        });
        gyG.put(Integer.valueOf("INVITEFRIENDOPEN_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return r.gLy;
            }
        });
        gyG.put(Integer.valueOf("GOOGLE_FRIEND_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return p.gLy;
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void bs(boolean z) {
        com.tencent.mm.ad.d.c.a(Integer.valueOf(42), this.hyU);
        com.tencent.mm.ad.d.c.a(Integer.valueOf(66), this.hyU);
        com.tencent.mm.sdk.b.a.xmy.b(this.hzc);
        com.tencent.mm.sdk.b.a.xmy.b(this.hzd);
        com.tencent.mm.sdk.b.a.xmy.b(this.hzb);
        com.tencent.mm.sdk.b.a.xmy.b(this.hyW);
        com.tencent.mm.sdk.b.a.xmy.b(this.hyX);
        com.tencent.mm.sdk.b.a.xmy.b(this.hyY);
        com.tencent.mm.sdk.b.a.xmy.b(this.hyZ);
        com.tencent.mm.sdk.b.a.xmy.b(this.hza);
        q.a.vji = OJ();
        ((m) g.k(m.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            public final boolean execute() {
                h aVar = new com.tencent.mm.p.a();
                ((m) g.k(m.class)).registerIndexStorage(aVar);
                aVar.create();
                com.tencent.mm.plugin.fts.a.j bVar = new com.tencent.mm.p.b();
                ((m) g.k(m.class)).registerNativeLogic(9, bVar);
                bVar.create();
                return true;
            }

            public final String getName() {
                return "InitFTSFriendPluginTask";
            }
        });
    }

    public final void bt(boolean z) {
    }

    public static p OR() {
        g.Do().CA();
        if (OI().hyT == null) {
            af OI = OI();
            com.tencent.mm.y.as.Hm();
            OI.hyT = new p(com.tencent.mm.y.c.Fc());
        }
        return OI().hyT;
    }
}
