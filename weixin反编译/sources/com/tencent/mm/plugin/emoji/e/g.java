package com.tencent.mm.plugin.emoji.e;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ay.f;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.plugin.emoji.ui.CustomSmileyPreviewUI;
import com.tencent.mm.plugin.emoji.ui.EmojiAddCustomDialogUI;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bkc;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.al;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.r;
import com.tencent.mm.storage.emotion.t;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.x.g.a;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class g implements d {
    public final EmojiInfo yI(String str) {
        return i.aCl().lCw.YB(str);
    }

    public final EmojiInfo c(EmojiInfo emojiInfo) {
        if (emojiInfo.field_catalog == EmojiGroupInfo.xIF && emojiInfo.field_type == EmojiInfo.xIO && emojiInfo.wl().length() > 0 && EmojiInfo.DN(bi.getInt(emojiInfo.wl(), 0))) {
            Cursor DR = i.aCl().lCw.DR(bi.getInt(emojiInfo.wl(), 0));
            if (DR != null && DR.getCount() > 1) {
                int eI = bi.eI(DR.getCount() - 1, 0);
                emojiInfo = new EmojiInfo();
                DR.moveToPosition(eI);
                emojiInfo.b(DR);
            }
            if (DR != null) {
                DR.close();
            }
        }
        return emojiInfo;
    }

    public final boolean a(Context context, EmojiInfo emojiInfo, int i, String str) {
        if (context == null) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. context is null");
            return false;
        } else if (emojiInfo == null) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "[cpan] save emoji failed. emoji is null");
            return false;
        } else {
            Intent intent = new Intent();
            intent.setClass(context, EmojiAddCustomDialogUI.class);
            intent.putExtra("extra_id", emojiInfo.Nx());
            intent.putExtra("extra_scence", i);
            intent.addFlags(65536);
            intent.putExtra("extra_username", str);
            context.startActivity(intent);
            return true;
        }
    }

    public final void a(Context context, au auVar) {
        if (context == null || auVar == null) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "context or msg is null");
            return;
        }
        aj XW = aj.XW(auVar.field_content);
        a fV = a.fV(auVar.field_content);
        if (fV == null) {
            fV = new a();
            fV.hcO = XW.frM;
        }
        EmojiInfo YB = i.aCl().lCw.YB(fV.hcO);
        long j;
        if (auVar.field_isSend == 1) {
            if (YB == null || !YB.clh()) {
                j = auVar.field_msgId;
                c(fV);
                return;
            }
            a(context, fV.hcO, fV.appId, fV.appName, auVar.field_msgSvrId, auVar.field_talker, auVar.field_content);
        } else if (YB == null || !YB.clh()) {
            j = auVar.field_msgId;
            c(fV);
        } else {
            a(context, YB.Nx(), fV.appId, fV.appName, auVar.field_msgSvrId, auVar.field_talker, auVar.field_content);
        }
    }

    public final boolean n(Context context, String str, String str2) {
        if (context == null) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: context is null");
            return false;
        } else if (bi.oN(str) || bi.oN(str2)) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: userName or imgPath is null");
            return false;
        } else {
            EmojiInfo YB = i.aCl().lCw.YB(str2);
            if (YB == null) {
                x.w("MicroMsg.emoji.EmojiMgrImpl", "sendEmoji: emoji not found, imgPath %s", str2);
                return false;
            }
            if (YB.field_type == EmojiInfo.xIR || YB.field_type == EmojiInfo.xIS) {
                WXMediaMessage wXMediaMessage = new WXMediaMessage();
                StringBuilder stringBuilder = new StringBuilder();
                as.Hm();
                String stringBuilder2 = stringBuilder.append(c.Fw()).append(YB.Nx()).toString();
                if (e.bO(stringBuilder2 + "_thumb")) {
                    wXMediaMessage.thumbData = e.d(stringBuilder2 + "_thumb", 0, e.bN(stringBuilder2 + "_thumb"));
                } else {
                    wXMediaMessage.setThumbImage(YB.fo(context));
                }
                wXMediaMessage.mediaObject = new WXEmojiObject(stringBuilder2);
                l.a(wXMediaMessage, YB.field_app_id, null, str, 0, YB.Nx());
            } else {
                EmojiInfo emojiInfo;
                if (YB.field_type == EmojiInfo.xIO) {
                    Cursor DR = EmojiInfo.DN(YB.field_catalog) ? i.aCl().lCw.DR(YB.field_catalog) : (YB.field_catalog == EmojiInfo.xIJ && YB.wl().length() > 0 && EmojiInfo.DN(bi.getInt(YB.wl(), 0))) ? i.aCl().lCw.DR(bi.getInt(YB.wl(), 0)) : null;
                    if (DR != null) {
                        int eI = bi.eI(DR.getCount() - 1, 0);
                        emojiInfo = new EmojiInfo();
                        DR.moveToPosition(eI);
                        emojiInfo.b(DR);
                        DR.close();
                        i.aCf().a(str, emojiInfo, null);
                    }
                }
                emojiInfo = YB;
                i.aCf().a(str, emojiInfo, null);
            }
            return true;
        }
    }

    public final void a(String str, EmojiInfo emojiInfo, au auVar) {
        if (emojiInfo != null || auVar != null) {
            if (emojiInfo == null) {
                emojiInfo = i.aCl().lCw.YB(auVar.field_imgPath);
            }
            i.aCf().a(str, emojiInfo, auVar);
        }
    }

    private static void a(Context context, String str, String str2, String str3, long j, String str4, String str5) {
        if (str.equals("-1")) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            return;
        }
        EmojiInfo YB = i.aCl().lCw.YB(str);
        if (YB == null) {
            x.e("MicroMsg.emoji.EmojiMgrImpl", "showEmoji fail cause md5 is no valid");
            return;
        }
        Intent intent = new Intent(context, CustomSmileyPreviewUI.class);
        intent.putExtra("custom_smiley_preview_md5", str);
        if (str2 != null) {
            intent.putExtra("custom_smiley_preview_appid", str2);
        } else {
            intent.putExtra("custom_smiley_preview_appid", YB.field_app_id);
        }
        intent.putExtra("custom_smiley_preview_appname", str3);
        intent.putExtra("msg_id", j);
        intent.putExtra("msg_content", str5);
        if (s.eX(str4)) {
            str4 = bb.hS(str5);
        }
        intent.putExtra("msg_sender", str4);
        context.startActivity(intent);
    }

    private static void c(a aVar) {
        i.aCo();
        if (aVar == null) {
            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "msg content is null");
            return;
        }
        String str = aVar.hcO;
        if (bi.oN(str)) {
            x.e("MicroMsg.emoji.EmojiAppMsgDownloadService", "md5 is null.");
            return;
        }
        EmojiInfo emojiInfo = new EmojiInfo();
        emojiInfo.field_md5 = str;
        emojiInfo.field_app_id = aVar.appId;
        emojiInfo.field_catalog = EmojiInfo.xIH;
        emojiInfo.field_size = aVar.hcM;
        emojiInfo.field_temp = 1;
        emojiInfo.field_state = EmojiInfo.xIX;
        i.aCl().lCw.o(emojiInfo);
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        as.CN().a(new com.tencent.mm.plugin.emoji.f.e(linkedList), 0);
        com.tencent.mm.plugin.emoji.model.c.bh(str, 0);
        x.d("MicroMsg.emoji.EmojiAppMsgDownloadService", "start change cdn url. md5:%s", str);
    }

    public final al cq(String str, String str2) {
        Map y = bj.y(str, "msg");
        if (y == null) {
            x.w("MicroMsg.emoji.EmojiMgrImpl", "get from xml, but attrs is null");
            return null;
        }
        al a = al.a(y, str2, str, "");
        if (a != null) {
            return a;
        }
        x.w("MicroMsg.emoji.EmojiMgrImpl", "parserEmojiXml error " + str);
        return null;
    }

    public final void d(EmojiInfo emojiInfo) {
        i.aCl().lCw.p(emojiInfo);
    }

    public final String yJ(String str) {
        return EmojiLogic.yJ(str);
    }

    public final String a(Context context, WXMediaMessage wXMediaMessage, String str) {
        return EmojiLogic.b(context, wXMediaMessage, str);
    }

    public final boolean a(String str, String str2, long j, String str3, com.tencent.mm.ad.d.a aVar) {
        boolean z = false;
        com.tencent.mm.plugin.emoji.model.d aCf = i.aCf();
        x.d("MicroMsg.emoji.EmojiMsgInfo", "parserEmojiXml " + str2);
        al a = al.a(bj.y(str2, "msg"), str, str2, str3);
        if (a == null) {
            x.i("MicroMsg.emoji.EmojiService", "prepareEmoji failed. emoji msg info is null.");
        } else {
            a.fGj = j;
            x.i("MicroMsg.emoji.EmojiService", "summerbadcr prepareEmoji msgSvrId[%d], stack[%s]", Long.valueOf(j), bi.chl());
            aCf.zd(a.frQ);
            if (!EmojiLogic.zc(n.aBV())) {
                z = true;
            }
            aCf.a(a, aVar, z);
        }
        return true;
    }

    public final List<EmojiInfo> yK(String str) {
        as.Hm();
        if (c.isSDCardAvailable()) {
            return (ArrayList) i.aCl().lCw.yK(str);
        }
        return new ArrayList();
    }

    public final String FJ() {
        return com.tencent.mm.kernel.g.Dq().gRT;
    }

    public final String yF(String str) {
        return i.aCg().yF(str);
    }

    public final boolean yL(String str) {
        return i.aCl().lCx.Yw(str);
    }

    public final ArrayList<String> yM(String str) {
        a aCg = i.aCg();
        if (!aCg.mInit) {
            aCg.aBu();
        }
        long currentTimeMillis = System.currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList();
        int aaF = h.aaF(str);
        if (aaF < aCg.lAK || aaF > aCg.lAL) {
            x.d("MicroMsg.emoji.EmojiDescNewMgr", "input text over checkout limit.");
            return null;
        }
        if (!(bi.oN(str) || aCg.lAP == null)) {
            String toLowerCase = str.toLowerCase();
            ArrayList arrayList3 = new ArrayList();
            if (aCg.lAO.containsKey(toLowerCase)) {
                arrayList3.addAll((Collection) aCg.lAN.get(aCg.lAO.get(toLowerCase)));
            } else {
                arrayList3.add(toLowerCase);
            }
            Iterator it = arrayList3.iterator();
            while (it.hasNext()) {
                ArrayList arrayList4 = (ArrayList) aCg.lAP.get((String) it.next());
                if (!(arrayList4 == null || arrayList4.isEmpty())) {
                    arrayList.addAll(arrayList4);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Collections.sort(arrayList, aCg.lAQ);
            for (int i = 0; i < arrayList.size(); i++) {
                arrayList2.add(((a) arrayList.get(i)).frM);
            }
        }
        x.d("MicroMsg.emoji.EmojiDescNewMgr", "cpan[check desc]User time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return arrayList2;
    }

    public final String yN(String str) {
        return EmojiLogic.yN(str);
    }

    public final String yO(String str) {
        return EmojiLogic.yO(str);
    }

    public final int yP(String str) {
        return EmojiLogic.yP(str);
    }

    public final String yQ(String str) {
        return EmojiLogic.yQ(str);
    }

    public final int e(EmojiInfo emojiInfo) {
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.xIL || String.valueOf(EmojiInfo.xIL).equals(emojiInfo.field_groupId)) {
                return R.g.bDj;
            }
            if (emojiInfo.field_catalog == EmojiInfo.xIM || String.valueOf(EmojiInfo.xIM).equals(emojiInfo.field_groupId)) {
                return R.g.bBI;
            }
        }
        return 0;
    }

    public final int[] f(EmojiInfo emojiInfo) {
        if (emojiInfo != null) {
            if (emojiInfo.field_catalog == EmojiInfo.xIL) {
                return new int[]{R.g.bDl, R.g.bDm, R.g.bDk};
            } else if (emojiInfo.field_catalog == EmojiInfo.xIM) {
                return new int[]{R.g.bBJ, R.g.bBK, R.g.bBL, R.g.bBM};
            }
        }
        return null;
    }

    public final byte[] a(EmojiInfo emojiInfo) {
        return e.aBy().a(emojiInfo);
    }

    public final void onDestroy() {
    }

    public final boolean aBB() {
        return n.aBT();
    }

    public final ArrayList<q> aBC() {
        return i.aCl().lCE.aBC();
    }

    public final ArrayList<String> aBD() {
        return i.aCl().lCE.aBD();
    }

    public final ArrayList<com.tencent.mm.storage.emotion.s> aBE() {
        return i.aCl().lCF.aBE();
    }

    public final boolean p(ArrayList<q> arrayList) {
        r rVar = i.aCl().lCE;
        if (arrayList.size() <= 0) {
            x.i("MicroMsg.emoji.NewSmileyInfoStorage", "insertSmileyInfoList failed. list is null.");
        } else {
            long dA;
            com.tencent.mm.bx.h hVar;
            if (rVar.gLA instanceof com.tencent.mm.bx.h) {
                com.tencent.mm.bx.h hVar2 = (com.tencent.mm.bx.h) rVar.gLA;
                dA = hVar2.dA(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                dA = -1;
                hVar = null;
            }
            rVar.gLA.delete("SmileyInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                rVar.b((com.tencent.mm.sdk.e.c) (q) it.next());
            }
            int i = -1;
            if (hVar != null) {
                i = hVar.fT(dA);
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean q(ArrayList<com.tencent.mm.storage.emotion.s> arrayList) {
        t tVar = i.aCl().lCF;
        if (arrayList.size() <= 0) {
            x.i("MicroMsg.emoji.SmileyPanelConfigInfoStorage", "insertSmileyConfigInfoList failed. list is null.");
        } else {
            long dA;
            com.tencent.mm.bx.h hVar;
            if (tVar.gLA instanceof com.tencent.mm.bx.h) {
                com.tencent.mm.bx.h hVar2 = (com.tencent.mm.bx.h) tVar.gLA;
                dA = hVar2.dA(Thread.currentThread().getId());
                hVar = hVar2;
            } else {
                dA = -1;
                hVar = null;
            }
            tVar.gLA.delete("SmileyPanelConfigInfo", null, null);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                tVar.b((com.tencent.mm.sdk.e.c) (com.tencent.mm.storage.emotion.s) it.next());
            }
            int i = -1;
            if (hVar != null) {
                i = hVar.fT(dA);
            }
            if (i >= 0) {
                return true;
            }
        }
        return false;
    }

    public final String cr(String str, String str2) {
        as.Hm();
        return EmojiLogic.I(c.Fw(), str, str2);
    }

    public final f aBF() {
        return i.aBN().aBF();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void yR(java.lang.String r13) {
        /*
        r12 = this;
        r2 = -1;
        r10 = 2;
        r5 = 37;
        r9 = 1;
        r3 = 0;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r13);
        if (r0 == 0) goto L_0x0015;
    L_0x000c:
        r0 = "MicroMsg.emoji.EmojiCommandMgr";
        r1 = "emoji command is null.";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
    L_0x0015:
        r0 = "sync";
        r0 = r0.equalsIgnoreCase(r13);
        if (r0 == 0) goto L_0x0080;
    L_0x001e:
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r1 = com.tencent.mm.storage.w.a.USERINFO_EMOJI_RECOVER_CUSTOM_EMOJI_BOOLEAN;
        r2 = java.lang.Boolean.valueOf(r9);
        r0.a(r1, r2);
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r1 = com.tencent.mm.storage.w.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN;
        r2 = java.lang.Boolean.valueOf(r9);
        r0.a(r1, r2);
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r1 = com.tencent.mm.storage.w.a.USERINFO_EMOJI_LAST_BATCH_EMOJI_DOWNLOAD_TIME_2_LONG;
        r4 = 0;
        r2 = java.lang.Long.valueOf(r4);
        r0.a(r1, r2);
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r1 = com.tencent.mm.storage.w.a.USERINFO_EMOJI_SYNC_STORE_EMOJI_DOWNLOAD_LONG;
        r4 = 0;
        r2 = java.lang.Long.valueOf(r4);
        r0.a(r1, r2);
        r0 = com.tencent.mm.y.as.CN();
        r1 = new com.tencent.mm.plugin.emoji.f.e;
        r1.<init>();
        r0.a(r1, r3);
        r0 = new com.tencent.mm.plugin.emoji.f.n;
        r1 = 8;
        r2 = 0;
        r4 = 15;
        r0.<init>(r1, r2, r4, r9);
        r1 = com.tencent.mm.y.as.CN();
        r1.a(r0, r3);
    L_0x007f:
        return;
    L_0x0080:
        r0 = "rcheart";
        r0 = r0.equalsIgnoreCase(r13);
        if (r0 == 0) goto L_0x0093;
    L_0x0089:
        r0 = com.tencent.mm.plugin.emoji.model.i.aCl();
        r0 = r0.lCx;
        r0.clg();
        goto L_0x007f;
    L_0x0093:
        r0 = "recover";
        r0 = r0.equalsIgnoreCase(r13);
        if (r0 == 0) goto L_0x00c9;
    L_0x009c:
        r0 = "MicroMsg.emoji.EmojiCommandMgr";
        r1 = "recover   begin";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = com.tencent.mm.plugin.emoji.model.i.aCl();
        r0 = r0.lCw;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r0.fm(r1);
        r0 = com.tencent.mm.plugin.emoji.model.i.aCl();
        r0 = r0.lCx;
        r1 = com.tencent.mm.sdk.platformtools.ad.getContext();
        r0.fm(r1);
        r0 = "MicroMsg.emoji.EmojiCommandMgr";
        r1 = "recover   end";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x007f;
    L_0x00c9:
        r0 = "clean";
        r0 = r0.equalsIgnoreCase(r13);
        if (r0 == 0) goto L_0x0104;
    L_0x00d2:
        r0 = "MicroMsg.emoji.EmojiCommandMgr";
        r1 = "begin clean";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = com.tencent.mm.plugin.emoji.e.d.aBx();
        com.tencent.mm.y.as.Hm();
        r1 = com.tencent.mm.y.c.Fw();
        r0.yH(r1);
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r1 = com.tencent.mm.storage.w.a.USERINFO_EMOJI_SYNC_CUSTOM_EMOJI_BATCH_DOWNLOAD_BOOLEAN;
        r2 = java.lang.Boolean.valueOf(r9);
        r0.a(r1, r2);
        r0 = "MicroMsg.emoji.EmojiCommandMgr";
        r1 = "end clean";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x007f;
    L_0x0104:
        r0 = "dump";
        r0 = r0.equalsIgnoreCase(r13);
        if (r0 == 0) goto L_0x01a5;
    L_0x010d:
        r0 = "MicroMsg.emoji.EmojiCommandMgr";
        r1 = "begin dump emoji db info:";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        r0 = com.tencent.mm.plugin.emoji.model.i.aCl();
        r0 = r0.lCx;
        r0 = r0.ckR();
        r0 = (java.util.ArrayList) r0;
        r1 = r0.size();
        if (r1 <= 0) goto L_0x0150;
    L_0x0128:
        r4 = r0.size();
        r2 = r3;
    L_0x012d:
        if (r2 >= r4) goto L_0x0150;
    L_0x012f:
        r1 = r0.get(r2);
        r1 = (com.tencent.mm.storage.emotion.EmojiGroupInfo) r1;
        r5 = "MicroMsg.emoji.EmojiCommandMgr";
        r6 = "i:%d group info:%s";
        r7 = new java.lang.Object[r10];
        r8 = java.lang.Integer.valueOf(r2);
        r7[r3] = r8;
        r1 = r1.toString();
        r7[r9] = r1;
        com.tencent.mm.sdk.platformtools.x.i(r5, r6, r7);
        r1 = r2 + 1;
        r2 = r1;
        goto L_0x012d;
    L_0x0150:
        r0 = 0;
        r1 = com.tencent.mm.plugin.emoji.model.i.aCl();	 Catch:{ Exception -> 0x0194, all -> 0x019b }
        r1 = r1.lCw;	 Catch:{ Exception -> 0x0194, all -> 0x019b }
        r0 = r1.Tq();	 Catch:{ Exception -> 0x0194, all -> 0x019b }
        if (r0 == 0) goto L_0x0184;
    L_0x015d:
        r1 = r0.moveToFirst();	 Catch:{ Exception -> 0x0194, all -> 0x0267 }
        if (r1 == 0) goto L_0x0184;
    L_0x0163:
        r1 = new com.tencent.mm.storage.emotion.EmojiInfo;	 Catch:{ Exception -> 0x0194, all -> 0x0267 }
        r1.<init>();	 Catch:{ Exception -> 0x0194, all -> 0x0267 }
        r1.b(r0);	 Catch:{ Exception -> 0x0194, all -> 0x0267 }
        r2 = "MicroMsg.emoji.EmojiCommandMgr";
        r3 = "emoji info:%s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ Exception -> 0x0194, all -> 0x0267 }
        r5 = 0;
        r1 = r1.toString();	 Catch:{ Exception -> 0x0194, all -> 0x0267 }
        r4[r5] = r1;	 Catch:{ Exception -> 0x0194, all -> 0x0267 }
        com.tencent.mm.sdk.platformtools.x.i(r2, r3, r4);	 Catch:{ Exception -> 0x0194, all -> 0x0267 }
        r1 = r0.moveToNext();	 Catch:{ Exception -> 0x0194, all -> 0x0267 }
        if (r1 != 0) goto L_0x0163;
    L_0x0184:
        if (r0 == 0) goto L_0x0189;
    L_0x0186:
        r0.close();
    L_0x0189:
        r0 = "MicroMsg.emoji.EmojiCommandMgr";
        r1 = "end dump emoji db info:";
        com.tencent.mm.sdk.platformtools.x.i(r0, r1);
        goto L_0x007f;
    L_0x0194:
        r1 = move-exception;
        if (r0 == 0) goto L_0x0189;
    L_0x0197:
        r0.close();
        goto L_0x0189;
    L_0x019b:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
    L_0x019f:
        if (r1 == 0) goto L_0x01a4;
    L_0x01a1:
        r1.close();
    L_0x01a4:
        throw r0;
    L_0x01a5:
        r0 = "config";
        r0 = r0.equalsIgnoreCase(r13);
        if (r0 == 0) goto L_0x0256;
    L_0x01ae:
        r0 = com.tencent.mm.pluginsdk.i.a.b.b.c.vnr;
        r0.e(r5, r9, r2, r3);
        r0 = com.tencent.mm.pluginsdk.i.a.b.b.c.vnr;
        r0.e(r5, r10, r2, r3);
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r1 = com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_EMOJI_INT;
        r2 = java.lang.Integer.valueOf(r3);
        r0.a(r1, r2);
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r1 = com.tencent.mm.storage.w.a.USERINFO_EMOJI_NEW_PANEL_INT;
        r2 = java.lang.Integer.valueOf(r3);
        r0.a(r1, r2);
        com.tencent.mm.y.as.Hm();
        r0 = com.tencent.mm.y.c.Db();
        r1 = com.tencent.mm.storage.w.a.USERINFO_EMOJI_EGG_INT;
        r2 = java.lang.Integer.valueOf(r3);
        r0.a(r1, r2);
        r0 = new com.tencent.mm.pluginsdk.i.a.b.m;
        r0.<init>(r5);
        r1 = com.tencent.mm.y.as.CN();
        r1.a(r0, r3);
        r0 = new com.tencent.mm.f.a.bc;
        r0.<init>();
        r1 = r0.fqf;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = com.tencent.mm.compatible.util.e.bnF;
        r2 = r2.append(r3);
        r3 = "CheckResUpdate/37.1.data.decompressed";
        r2 = r2.append(r3);
        r2 = r2.toString();
        r1.filePath = r2;
        r1 = r0.fqf;
        r1.fqg = r5;
        r1 = r0.fqf;
        r1.fqh = r9;
        r1 = new com.tencent.mm.f.a.bc;
        r1.<init>();
        r2 = r1.fqf;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r4 = com.tencent.mm.compatible.util.e.bnF;
        r3 = r3.append(r4);
        r4 = "CheckResUpdate/37.2.data.decompressed";
        r3 = r3.append(r4);
        r3 = r3.toString();
        r2.filePath = r3;
        r2 = r1.fqf;
        r2.fqg = r5;
        r2 = r1.fqf;
        r2.fqh = r10;
        r2 = com.tencent.mm.plugin.emoji.e.i.aBN();
        r2.a(r0, r9);
        r0 = com.tencent.mm.plugin.emoji.e.i.aBN();
        r0.b(r1, r9);
        goto L_0x007f;
    L_0x0256:
        r0 = "tuzki";
        r0 = r0.equalsIgnoreCase(r13);
        if (r0 == 0) goto L_0x007f;
    L_0x025f:
        com.tencent.mm.plugin.emoji.f.a.aCq();
        com.tencent.mm.plugin.emoji.f.a.aCr();
        goto L_0x007f;
    L_0x0267:
        r1 = move-exception;
        r11 = r1;
        r1 = r0;
        r0 = r11;
        goto L_0x019f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.emoji.e.g.yR(java.lang.String):void");
    }

    public final bkc aBG() {
        return i.aCl().lCz.aBG();
    }

    public final void a(bkc bkc) {
        i.aCl().lCz.b(bkc);
    }

    public final int aBH() {
        return i.aCl().lCw.lP(true);
    }

    public final int yS(String str) {
        return i.aCl().lCw.yS(str);
    }

    public final boolean a(EmojiGroupInfo emojiGroupInfo) {
        return i.aCl().lCx.c(emojiGroupInfo, "productID");
    }

    public final ArrayList<EmojiGroupInfo> aBI() {
        return i.aCl().aBI();
    }

    public final int aBJ() {
        return i.aCl().aBJ();
    }

    public final ArrayList<EmojiInfo> aBK() {
        return i.aCl().aBK();
    }

    public final ArrayList<EmojiInfo> yT(String str) {
        l aCl = i.aCl();
        if (l.lCM == null) {
            l.lCM = new HashMap();
        }
        if (l.lCJ) {
            l.lCM.clear();
            l.lCJ = false;
        }
        if (!l.lCM.containsKey(str)) {
            as.Hm();
            if (c.isSDCardAvailable()) {
                l.lCM.put(str, (ArrayList) aCl.lCw.yK(str));
            }
        }
        return (ArrayList) l.lCM.get(str);
    }

    public final com.tencent.mm.ap.a.a aBL() {
        return i.aBL();
    }

    public final void f(j.a aVar) {
        i.aCl().lCw.j(aVar);
    }

    public final void g(j.a aVar) {
        i.aCl().lCw.c(aVar);
    }

    public final void h(j.a aVar) {
        i.aCl().lCx.j(aVar);
    }

    public final void i(j.a aVar) {
        if (((com.tencent.mm.kernel.b.h) com.tencent.mm.kernel.g.Dn().CU()).DZ()) {
            i.aCl().lCx.c(aVar);
        }
    }

    public final boolean aBM() {
        return n.aBY();
    }
}
