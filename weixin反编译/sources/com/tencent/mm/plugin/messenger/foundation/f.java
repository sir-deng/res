package com.tencent.mm.plugin.messenger.foundation;

import com.tencent.mm.cc.c;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelmulti.l;
import com.tencent.mm.modelmulti.s;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.messenger.foundation.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.p;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.plugin.report.d;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.protocal.c.ot;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements com.tencent.mm.plugin.zero.a.f {
    private r ouo;

    static class b implements Runnable {
        private String TAG;
        private final s hHy;
        private final LinkedList<ot> mwu;
        private int oup;

        public b(String str, s sVar, LinkedList<ot> linkedList) {
            this.TAG = str;
            this.hHy = sVar;
            this.mwu = linkedList;
        }

        public final void run() {
            if (this.hHy != null) {
                int i = this.hHy.hJv;
                if (i != 3) {
                    if (!this.hHy.hJu) {
                        if (!(i == 1 || i == 2 || i == 8)) {
                            return;
                        }
                    }
                    return;
                }
                this.oup = 0;
                Iterator it = this.mwu.iterator();
                while (it.hasNext()) {
                    ot otVar = (ot) it.next();
                    byte[] a = n.a(otVar.weu);
                    if (otVar.wet == 5) {
                        try {
                            String bet = ((bx) new bx().aH(a)).vNM.toString();
                            ag Xv = ((h) g.h(h.class)).Ff().Xv(bet);
                            if (bet.endsWith("@chatroom") && Xv.fXi == 0) {
                                this.oup++;
                            }
                        } catch (IOException e) {
                            x.e(this.TAG, "muteroom idkeyStat: docmd: parse from protobuf to addmsg error, " + e.getMessage());
                        }
                    }
                }
                if (this.oup > 0) {
                    if (this.oup <= 5) {
                        d.pVE.a(202, (long) this.oup, 1, false);
                    } else if (this.oup <= 10) {
                        d.pVE.a(202, 6, 1, false);
                    } else if (this.oup <= 15) {
                        d.pVE.a(202, 7, 1, false);
                    } else if (this.oup <= 20) {
                        d.pVE.a(202, 8, 1, false);
                    } else {
                        d.pVE.a(202, 9, 1, false);
                    }
                    x.i(this.TAG, "muteroom idkeyStat:muteroomNotNotifyNum = " + this.oup);
                    switch (i) {
                        case 1:
                            d.pVE.a(202, 11, 1, false);
                            break;
                        case 2:
                            d.pVE.a(202, 12, 1, false);
                            break;
                        case 3:
                            d.pVE.a(202, 10, 1, false);
                            break;
                        case 8:
                            d.pVE.a(202, 13, 1, false);
                            break;
                    }
                    x.i(this.TAG, "muteroom idkeyStat:aiScene = " + i);
                }
            }
        }
    }

    private static class a implements r {
        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void arL() {
        }

        public final void a(au auVar, bx bxVar) {
        }
    }

    public final void bw(Object obj) {
        c aZP = com.tencent.mm.plugin.messenger.foundation.a.s.aZP();
        if (aZP != null) {
            this.ouo = (r) aZP.get();
        }
        if (this.ouo == null) {
            this.ouo = new a();
        }
        if (obj instanceof l) {
            ((h) g.h(h.class)).aZO().EZ(((l) obj).TAG);
        } else if (obj instanceof String) {
            if (obj.equals("NetSceneInit")) {
                ((h) g.h(h.class)).aZO().EZ((String) obj);
            }
        } else if (obj instanceof com.tencent.mm.modelmulti.r.c) {
            ((h) g.h(h.class)).aZO().EZ(obj.toString());
        }
    }

    public final void a(ot otVar, byte[] bArr, boolean z) {
        p sL = com.tencent.mm.plugin.messenger.foundation.a.p.a.sL(otVar.wet);
        if (sL != null) {
            try {
                sL.a(otVar, bArr, z, this.ouo);
                return;
            } catch (IOException e) {
                x.e("MicroMsg.SyncDoCmdExtensions", "docmd: parse protobuf error, " + e.getMessage());
                throw new RuntimeException("docmd: parse protobuf error");
            }
        }
        x.w("MicroMsg.SyncDoCmdExtensions", "SyncDoCmdExtension for cmd id [%s] is null.", Integer.valueOf(otVar.wet));
    }

    public final void bx(Object obj) {
        if (obj instanceof l) {
            this.ouo.arL();
            ((h) g.h(h.class)).aZO().Fa(((l) obj).TAG);
            ah Dt = g.Dt();
            String str = ((l) obj).TAG;
            s sVar = ((l) obj).hHy;
            l lVar = (l) obj;
            LinkedList linkedList = (lVar.hHG == null || lVar.hHG.vID.vYH == null) ? null : lVar.hHG.vID.vYH.kyB;
            Dt.F(new b(str, sVar, linkedList));
        } else if ((obj instanceof String) && obj.equals("NetSceneInit")) {
            this.ouo.arL();
            ((h) g.h(h.class)).aZO().Fa((String) obj);
        } else if (obj instanceof com.tencent.mm.modelmulti.r.c) {
            this.ouo.arL();
            ((h) g.h(h.class)).aZO().Fa(obj.toString());
        }
    }

    public final void by(Object obj) {
        if (obj instanceof l) {
            ((h) g.h(h.class)).aZO().Fa(((l) obj).TAG);
        }
    }
}
