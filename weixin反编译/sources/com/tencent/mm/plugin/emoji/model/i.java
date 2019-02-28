package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.content.IntentFilter;
import com.tencent.mm.ad.e;
import com.tencent.mm.bx.h.d;
import com.tencent.mm.plugin.emoji.b.c;
import com.tencent.mm.plugin.emoji.e.a;
import com.tencent.mm.plugin.emoji.e.b;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.h;
import com.tencent.mm.plugin.emoji.e.j;
import com.tencent.mm.plugin.emoji.e.l;
import com.tencent.mm.plugin.emoji.sync.BKGLoaderManager;
import com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2SingleRecommendView;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac;
import com.tencent.mm.pluginsdk.i.a.b.m;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.RecommendView;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.f;
import com.tencent.mm.storage.emotion.n;
import com.tencent.mm.storage.emotion.p;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.storage.w;
import com.tencent.mm.view.SmileyPanelImpl;
import com.tencent.mm.y.ap;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bq;
import java.util.HashMap;

public class i implements ap {
    private static HashMap<Integer, d> gyG;
    private d lDH;
    private a lDI;
    private g lDJ;
    private j lDK;
    private g lDL;
    private e lDM;
    private com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.d> lDN;
    private volatile h lDO;
    private volatile b lDP;
    private volatile l lDQ;
    private volatile j lDR;
    private com.tencent.mm.ap.a.a lDS;
    private c lDT;

    private static i aCe() {
        as.Hg();
        i iVar = (i) bq.ib("plugin.emoji");
        if (iVar == null) {
            synchronized (i.class) {
                if (iVar == null) {
                    iVar = new i();
                    as.Hg().a("plugin.emoji", iVar);
                }
            }
        }
        return iVar;
    }

    public static com.tencent.mm.ap.a.a aBL() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aCe().lDS == null) {
            com.tencent.mm.ap.a.a.b.a aVar = new com.tencent.mm.ap.a.a.b.a(ad.getContext());
            aVar.hFb = new com.tencent.mm.plugin.emoji.d.a();
            aVar.hEZ = new com.tencent.mm.view.d.a();
            com.tencent.mm.ap.a.a.b PP = aVar.PP();
            aCe().lDS = new com.tencent.mm.ap.a.a(PP);
        }
        return aCe().lDS;
    }

    public static d aCf() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aCe().lDH == null) {
            aCe().lDH = new d();
        }
        return aCe().lDH;
    }

    public static a aCg() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aCe().lDI == null) {
            aCe().lDI = new a();
        }
        return aCe().lDI;
    }

    public static g aCh() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aCe().lDJ == null) {
            aCe().lDJ = new g();
        }
        return aCe().lDJ;
    }

    public static com.tencent.mm.plugin.emoji.sync.a<com.tencent.mm.plugin.emoji.sync.d> aCi() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aCe().lDN == null) {
            aCe().lDN = new com.tencent.mm.plugin.emoji.sync.a();
        }
        return aCe().lDN;
    }

    private static synchronized h aCj() {
        h hVar;
        synchronized (i.class) {
            com.tencent.mm.kernel.g.Do().CA();
            if (aCe().lDO == null) {
                aCe().lDO = new h();
            }
            hVar = aCe().lDO;
        }
        return hVar;
    }

    private static b aCk() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aCe().lDP == null) {
            aCe().lDP = new b();
        }
        return aCe().lDP;
    }

    public static l aCl() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aCe().lDQ == null) {
            aCe().lDQ = new l();
        }
        return aCe().lDQ;
    }

    public static j aCm() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aCe().lDR == null) {
            aCe().lDR = new j();
        }
        return aCe().lDR;
    }

    public final void onAccountRelease() {
        h aCj = aCj();
        as.getSysCmdMsgExtension().b("emotionstore", aCj.lBu, true);
        as.getSysCmdMsgExtension().b("NewRecommendEmotion", aCj.lBv, true);
        as.getSysCmdMsgExtension().b("EmojiBackup", aCj.lBw, true);
        as.getSysCmdMsgExtension().b("EmotionBackup", aCj.lBw, true);
        b aCk = aCk();
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lAS);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lAW);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lAX);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lAY);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lAZ);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lBa);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lBb);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lBc);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lBd);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lAT);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lAU);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lBe);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lBf);
        com.tencent.mm.sdk.b.a.xmy.c(aCk.lAV);
        l aCl = aCl();
        aCl.lCw.j(aCl.lCP);
        aCl.lCx.j(aCl.lCN);
        aCl.lCy.j(aCl.lCO);
        com.tencent.mm.sdk.b.a.xmy.c(aCl.lCQ);
        if (l.lCL != null) {
            l.lCL.clear();
            l.lCL = null;
        }
        if (l.lCM != null) {
            l.lCM.clear();
            l.lCM = null;
        }
        aCg().clear();
        ((c) com.tencent.mm.kernel.g.k(c.class)).removeEmojiMgr();
        e aCf = aCf();
        as.CN().b((int) ac.CTRL_BYTE, aCf);
        aCf.lDf.clear();
        aCf.lDd.clear();
        aCf.lDi.clear();
        j aCm = aCm();
        aCm.lCe = null;
        if (aCm.lCf != null) {
            aCm.lCf.clear();
        }
        BKGLoaderManager bKGLoaderManager = aCi().lFb;
        x.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg detach");
        if (bKGLoaderManager.lFy != null) {
            bKGLoaderManager.lFy.clear();
        }
        if (bKGLoaderManager.lFz != null) {
            bKGLoaderManager.lFz.clear();
        }
        if (bKGLoaderManager.lFA != null) {
            bKGLoaderManager.lFA.clear();
        }
        bKGLoaderManager.lFo = false;
        com.tencent.mm.sdk.b.a.xmy.c(bKGLoaderManager.lFG);
        com.tencent.mm.sdk.b.a.xmy.c(bKGLoaderManager.lFH);
        if (bKGLoaderManager.lFC != null) {
            ad.getContext().unregisterReceiver(bKGLoaderManager.lFC);
            bKGLoaderManager.lFC = null;
        }
        if (this.lDK != null) {
            j jVar = this.lDK;
            com.tencent.mm.sdk.b.a.xmy.c(jVar.lDY);
            com.tencent.mm.sdk.b.a.xmy.c(jVar.lDZ);
        }
        if (this.lDL != null) {
            g gVar = this.lDL;
            gVar.lDs.clear();
            aCf().lDh = null;
            gVar.lDt.dead();
        }
        if (this.lDS != null) {
            this.lDS.detach();
        }
        as.CN().b(697, aCo());
    }

    static {
        HashMap hashMap = new HashMap();
        gyG = hashMap;
        hashMap.put(Integer.valueOf("EMOJIINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.storage.emotion.d.gLy;
            }
        });
        gyG.put(Integer.valueOf("EMOJIGROUPINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.storage.emotion.a.gLy;
            }
        });
        gyG.put(Integer.valueOf("EMOJIINFODESC_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.storage.emotion.c.gLy;
            }
        });
        gyG.put(Integer.valueOf("EMOTIONDETAIL_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.storage.emotion.j.gLy;
            }
        });
        gyG.put(Integer.valueOf("GETEMOTIONLISTCACHE_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return p.gLy;
            }
        });
        gyG.put(Integer.valueOf("EmotionRewardINFO_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.storage.emotion.l.gLy;
            }
        });
        gyG.put(Integer.valueOf("EmotionDesignerInfoStorage_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return com.tencent.mm.storage.emotion.h.gLy;
            }
        });
        gyG.put(Integer.valueOf("EmotionRewardTipStorage_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return n.gLy;
            }
        });
        gyG.put(Integer.valueOf("SmileyInfoStorage_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return r.gLy;
            }
        });
        gyG.put(Integer.valueOf("SmileyPanelConfigInfoStorage_TABLE".hashCode()), new d() {
            public final String[] wn() {
                return t.gLy;
            }
        });
        gyG.put(Integer.valueOf("EmojiDescMapStorage".hashCode()), new d() {
            public final String[] wn() {
                return f.gLy;
            }
        });
        gyG.put(Integer.valueOf("DELETE".hashCode()), new d() {
            public final String[] wn() {
                return new String[]{"DROP TABLE IF EXISTS EmotionDetail ", "DROP TABLE IF EXISTS EmojiSummaryInfo", "DROP TABLE IF EXISTS RewardMagicInfo"};
            }
        });
    }

    public final HashMap<Integer, d> Bu() {
        return gyG;
    }

    public final void ge(int i) {
    }

    public final void bs(boolean z) {
        x.i("MicroMsg.emoji.SubCoreEmoji", "[onAccountPostReset]");
        com.tencent.mm.pluginsdk.ui.chat.e.vxZ = new com.tencent.mm.pluginsdk.ui.chat.e.b() {
            public final ChatFooterPanel cw(Context context) {
                return new SmileyPanelImpl(context);
            }
        };
        com.tencent.mm.pluginsdk.ui.chat.e.vya = new com.tencent.mm.pluginsdk.ui.chat.e.a() {
            public final /* synthetic */ RecommendView h(Context context, boolean z) {
                return new EmojiStoreV2SingleRecommendView(context, z);
            }
        };
        ((c) com.tencent.mm.kernel.g.k(c.class)).setEmojiMgr();
        h aCj = aCj();
        as.getSysCmdMsgExtension().a("emotionstore", aCj.lBu, true);
        as.getSysCmdMsgExtension().a("NewRecommendEmotion", aCj.lBv, true);
        as.getSysCmdMsgExtension().a("EmojiBackup", aCj.lBw, true);
        as.getSysCmdMsgExtension().a("EmotionBackup", aCj.lBw, true);
        b aCk = aCk();
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lAS);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lAW);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lAX);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lAY);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lAZ);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lBa);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lBb);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lBc);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lBd);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lAT);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lAU);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lBe);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lBf);
        com.tencent.mm.sdk.b.a.xmy.b(aCk.lAV);
        l aCl = aCl();
        aCl.lCw.c(aCl.lCP);
        aCl.lCx.c(aCl.lCN);
        aCl.lCy.c(aCl.lCO);
        com.tencent.mm.sdk.b.a.xmy.b(aCl.lCQ);
        aCg();
        j aCm = aCm();
        String value = com.tencent.mm.j.g.Af().getValue("EmotionRewardTipsLimit");
        if (!bi.oN(value)) {
            x.i("MicroMsg.emoji.EmojiRewardTipMgr", "updateConfig dynamic config %s", value);
            String[] split = value.split(",");
            if (split != null && split.length == 3) {
                aCm.lCc = bi.getInt(split[0], 0) == 0 ? 863913600000L : ((long) bi.getInt(split[0], 0)) * 86400000;
                aCm.lCd = bi.getInt(split[1], 20) - 1;
                aCm.kLd = bi.getInt(split[2], 80) - 1;
            }
        }
        boolean aBS = com.tencent.mm.plugin.emoji.e.n.aBS();
        as.Hm();
        boolean z2 = aBS && ((Boolean) com.tencent.mm.y.c.Db().get(w.a.USERINFO_EMOJI_REWARD_TIP_ENABLE_BOOLEAN, Boolean.valueOf(true))).booleanValue();
        aCm.lCb = z2;
        x.i("MicroMsg.emoji.EmojiRewardTipMgr", "init RewardTipMgr RewardTipEnable:%b isEnableRewardTip:%b isTipsEnable:%b", Boolean.valueOf(aCm.lCb), Boolean.valueOf(aBS), Boolean.valueOf(r4));
        as.Dt().F(new Runnable() {
            /* JADX WARNING: inconsistent code. */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void run() {
                /*
                r5 = this;
                r0 = com.tencent.mm.plugin.emoji.e.j.this;
                r0 = r0.lCb;
                if (r0 == 0) goto L_0x004b;
            L_0x0006:
                r0 = com.tencent.mm.plugin.emoji.e.j.this;
                r1 = com.tencent.mm.plugin.emoji.model.i.aCl();
                r1 = r1.lCD;
                if (r1 == 0) goto L_0x001c;
            L_0x0010:
                r1 = com.tencent.mm.plugin.emoji.model.i.aCl();
                r1 = r1.lCD;
                r1 = r1.clz();
                r0.lCe = r1;
            L_0x001c:
                r0 = com.tencent.mm.plugin.emoji.e.j.this;
                r1 = 0;
                r2 = com.tencent.mm.plugin.emoji.model.i.aCl();	 Catch:{ Exception -> 0x004c }
                r2 = r2.lCD;	 Catch:{ Exception -> 0x004c }
                r1 = r2.Tq();	 Catch:{ Exception -> 0x004c }
                if (r1 == 0) goto L_0x0046;
            L_0x002b:
                r2 = r1.moveToFirst();	 Catch:{ Exception -> 0x004c }
                if (r2 == 0) goto L_0x0046;
            L_0x0031:
                r2 = new com.tencent.mm.storage.emotion.m;	 Catch:{ Exception -> 0x004c }
                r2.<init>();	 Catch:{ Exception -> 0x004c }
                r2.b(r1);	 Catch:{ Exception -> 0x004c }
                r3 = r0.lCf;	 Catch:{ Exception -> 0x004c }
                r4 = r2.field_prodcutID;	 Catch:{ Exception -> 0x004c }
                r3.put(r4, r2);	 Catch:{ Exception -> 0x004c }
                r2 = r1.moveToNext();	 Catch:{ Exception -> 0x004c }
                if (r2 != 0) goto L_0x0031;
            L_0x0046:
                if (r1 == 0) goto L_0x004b;
            L_0x0048:
                r1.close();
            L_0x004b:
                return;
            L_0x004c:
                r0 = move-exception;
                r2 = "MicroMsg.emoji.EmojiRewardTipMgr";
                r0 = com.tencent.mm.sdk.platformtools.bi.i(r0);	 Catch:{ all -> 0x005d }
                com.tencent.mm.sdk.platformtools.x.w(r2, r0);	 Catch:{ all -> 0x005d }
                if (r1 == 0) goto L_0x004b;
            L_0x0059:
                r1.close();
                goto L_0x004b;
            L_0x005d:
                r0 = move-exception;
                if (r1 == 0) goto L_0x0063;
            L_0x0060:
                r1.close();
            L_0x0063:
                throw r0;
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.e.j.1.run():void");
            }
        });
        BKGLoaderManager bKGLoaderManager = aCi().lFb;
        x.d("MicroMsg.BKGLoader.BKGLoaderManager", "bkg attach");
        com.tencent.mm.sdk.b.a.xmy.b(bKGLoaderManager.lFG);
        com.tencent.mm.sdk.b.a.xmy.b(bKGLoaderManager.lFH);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        bKGLoaderManager.lFC = new ConnectivityReceiver();
        ad.getContext().registerReceiver(bKGLoaderManager.lFC, intentFilter);
        x.i("MicroMsg.emoji.SubCoreEmoji", "[oneliang]initCore");
        aCl().aBQ();
        this.lDK = new j();
        this.lDL = new g();
        com.tencent.mm.aj.a.bN(z);
        as.CN().a(697, aCo());
        int chS = com.tencent.mm.bw.f.chQ().chS();
        int anS = com.tencent.mm.bw.e.chP().anS();
        if (chS < 0) {
            as.Hm();
            if (((Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0))).intValue() > 0) {
                c.vnr.e(37, 1, -1, false);
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_EMOJI_NEW_EMOJI_INT, Integer.valueOf(0));
                as.CN().a(new m(37), 0);
                com.tencent.mm.plugin.report.service.g.pWK.a(165, 10, 1, false);
            }
        }
        if (anS < 0) {
            as.Hm();
            if (((Integer) com.tencent.mm.y.c.Db().get(w.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0))).intValue() > 0) {
                c.vnr.e(37, 2, -1, false);
                as.Hm();
                com.tencent.mm.y.c.Db().a(w.a.USERINFO_EMOJI_NEW_PANEL_INT, Integer.valueOf(0));
                as.CN().a(new m(37), 0);
                com.tencent.mm.plugin.report.service.g.pWK.a(165, 11, 1, false);
            }
        }
    }

    public final void bt(boolean z) {
    }

    public static e aCn() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aCe().lDM == null) {
            aCe().lDM = new e();
        }
        return aCe().lDM;
    }

    public static c aCo() {
        com.tencent.mm.kernel.g.Do().CA();
        if (aCe().lDT == null) {
            aCe().lDT = new c();
        }
        return aCe().lDT;
    }
}
