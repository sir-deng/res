package com.tencent.mm.plugin.wenote.model;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.a.g;
import com.tencent.mm.bh.a;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.kp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.plugin.wenote.model.a.e;
import com.tencent.mm.plugin.wenote.model.a.h;
import com.tencent.mm.plugin.wenote.model.a.i;
import com.tencent.mm.plugin.wenote.model.a.j;
import com.tencent.mm.plugin.wenote.model.a.k;
import com.tencent.mm.plugin.wenote.model.a.l;
import com.tencent.mm.plugin.wenote.model.a.m;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.o;
import com.tencent.mm.plugin.wenote.model.a.q;
import com.tencent.mm.plugin.wenote.model.a.r;
import com.tencent.mm.plugin.wenote.model.a.s;
import com.tencent.mm.plugin.wenote.model.a.t;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;

public abstract class d {
    public static String tWU = "";
    public static HashMap<String, JSONArray> tWV = new HashMap();
    public static boolean tWY = false;
    public static String tWZ = (a.Vn() + "/fav_fileicon_recording.png");
    private static String tXa = (a.Vn() + "/ofm_file_icon.png");
    private static String tXb = (a.Vn() + "/app_attach_file_icon_pic.png");
    public static String tXc = (a.Vn() + "/location_msg.png");
    public static String tXd = (a.Vn() + "/note_fav_not_support.png");
    public l tWN = null;
    public f tWO;
    public HashMap<String, v> tWP = new HashMap();
    public HashMap<String, String> tWQ = new HashMap();
    public HashMap<String, n> tWR = new HashMap();
    public String tWS = "WeNote_0";
    public String tWT = "";
    public boolean tWW = false;
    public vn tWX = new vn();

    public abstract void a(uz uzVar, String str);

    public abstract void aN(Context context, String str);

    public abstract void aO(Context context, String str);

    public abstract void aP(Context context, String str);

    public abstract String h(uz uzVar);

    public abstract String i(uz uzVar);

    public abstract void n(uz uzVar);

    public final void cw(List<uz> list) {
        ArrayList Rx;
        Throwable e;
        v vVar = new v();
        List list2 = null;
        for (uz uzVar : list) {
            n nVar = new n();
            nVar.tYn = uzVar.wkP;
            if (uzVar.bjS == 1) {
                nVar.tYn = "-1";
            }
            String h;
            if (!bi.oN(nVar.tYn)) {
                if (!nVar.tYn.equals("WeNoteHtmlFile")) {
                    if (!nVar.tYn.equals("-1")) {
                        int i = bi.getInt(nVar.tYn.substring(7), 0);
                        int i2 = bi.getInt(this.tWS.substring(7), 0);
                        this.tWS = "WeNote_" + (i2 > i ? String.valueOf(i2) : String.valueOf(i));
                    }
                    nVar.mBr = uzVar.mBr;
                    String h2;
                    String str;
                    switch (uzVar.bjS) {
                        case 1:
                            if (!bi.oN(uzVar.desc)) {
                                s sVar;
                                if (vVar.tYG.size() > 0 && vVar.tYG.get(vVar.tYG.size() - 1) != null && ((n) vVar.tYG.get(vVar.tYG.size() - 1)).tYn.equals("-1")) {
                                    sVar = (s) vVar.tYG.get(vVar.tYG.size() - 1);
                                    sVar.content += uzVar.desc;
                                    break;
                                }
                                sVar = new h();
                                sVar.tYn = nVar.tYn;
                                sVar.content = uzVar.desc;
                                vVar.tYG.add(sVar);
                                break;
                            }
                            break;
                            break;
                        case 2:
                            o eVar = new e();
                            eVar.tYn = nVar.tYn;
                            eVar.type = 2;
                            eVar.mBr = nVar.mBr;
                            eVar.tYm = uzVar;
                            h2 = h(uzVar);
                            if (!bi.oN(h2)) {
                                str = h2 + "_bigthumb";
                                String i3 = i(uzVar);
                                if (!com.tencent.mm.a.e.bO(i3)) {
                                    a(uzVar, i3);
                                }
                                if (com.tencent.mm.a.e.bO(h2)) {
                                    eVar.tYo = true;
                                    c.fi(h2, str);
                                } else {
                                    n(uzVar);
                                    eVar.tYo = false;
                                    this.tWQ.put(uzVar.mBr, nVar.tYn);
                                }
                                eVar.fCV = str;
                                eVar.tYp = h2;
                                vVar.tYG.add(eVar);
                                this.tWR.put(nVar.tYn, eVar);
                                break;
                            }
                            break;
                        case 3:
                            u kVar = new k();
                            kVar.tYn = nVar.tYn;
                            kVar.type = 4;
                            kVar.mBr = nVar.mBr;
                            kVar.tYm = uzVar;
                            h2 = h(uzVar);
                            if (bi.oN(h2) || !com.tencent.mm.a.e.bO(h2)) {
                                n(uzVar);
                                kVar.tYo = false;
                                kVar.tYE = ad.getContext().getString(R.l.ehm);
                                this.tWQ.put(uzVar.mBr, nVar.tYn);
                            } else {
                                kVar.tYo = true;
                                kVar.tYl = tWZ;
                                kVar.length = uzVar.duration;
                            }
                            kVar.fCV = h2;
                            kVar.tYD = f.s(ad.getContext(), (int) f.bw((long) uzVar.duration));
                            kVar.fwt = uzVar.duration;
                            b fwVar = new fw();
                            fwVar.fwl.type = 17;
                            fwVar.fwl.fwn = uzVar;
                            com.tencent.mm.sdk.b.a.xmy.m(fwVar);
                            kVar.fws = fwVar.fwm.ret;
                            kVar.tYd = uzVar.wkc;
                            vVar.tYG.add(kVar);
                            this.tWR.put(nVar.tYn, kVar);
                            break;
                        case 4:
                            j jVar = new j();
                            jVar.tYn = nVar.tYn;
                            jVar.type = 6;
                            jVar.mBr = nVar.mBr;
                            jVar.tYm = uzVar;
                            jVar.fwx = i(uzVar);
                            str = h(uzVar);
                            jVar.fCV = str;
                            if (!(bi.oN(jVar.fwx) || com.tencent.mm.a.e.bO(jVar.fwx))) {
                                if (com.tencent.mm.a.e.bO(str)) {
                                    Bitmap RX = com.tencent.mm.pluginsdk.model.c.RX(str);
                                    if (RX != null) {
                                        try {
                                            x.i("MicroMsg.WNNoteBase", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                            com.tencent.mm.pluginsdk.k.e.a(RX, CompressFormat.JPEG, jVar.fwx);
                                        } catch (Throwable e2) {
                                            x.printErrStackTrace("MicroMsg.WNNoteBase", e2, "", new Object[0]);
                                        }
                                    }
                                } else {
                                    a(uzVar, jVar.fwx);
                                    this.tWQ.put(uzVar.mBr + "_t", nVar.tYn);
                                }
                            }
                            if (bi.oN(str) || !com.tencent.mm.a.e.bO(str)) {
                                jVar.tYo = false;
                                this.tWQ.put(uzVar.mBr, nVar.tYn);
                            } else {
                                jVar.tYo = true;
                            }
                            vVar.tYG.add(jVar);
                            this.tWR.put(nVar.tYn, jVar);
                            break;
                        case 6:
                            q qVar = new q();
                            qVar.fAo = (float) uzVar.wkH.wld.lat;
                            qVar.hDw = (float) uzVar.wkH.wld.lng;
                            qVar.fAq = uzVar.wkH.wld.fAq;
                            qVar.tYy = uzVar.wkH.wld.label;
                            qVar.tYz = uzVar.wkH.wld.fEp;
                            qVar.tYA = uzVar.wkP;
                            r fVar = new com.tencent.mm.plugin.wenote.model.a.f();
                            fVar.tYn = nVar.tYn;
                            fVar.type = 3;
                            fVar.mBr = nVar.mBr;
                            fVar.tYm = uzVar;
                            fVar.tYo = true;
                            fVar.nYL = qVar.tYz;
                            fVar.hzf = qVar.tYy;
                            fVar.lat = (double) qVar.fAo;
                            fVar.lng = (double) qVar.hDw;
                            fVar.tYB = (double) qVar.fAq;
                            fVar.fCV = "";
                            vVar.tYG.add(fVar);
                            this.tWR.put(nVar.tYn, fVar);
                            break;
                        case 8:
                            t cVar = new com.tencent.mm.plugin.wenote.model.a.c();
                            cVar.tYn = nVar.tYn;
                            cVar.type = 5;
                            cVar.mBr = nVar.mBr;
                            cVar.tYm = uzVar;
                            h2 = h(uzVar);
                            if (bi.oN(h2) || !com.tencent.mm.a.e.bO(h2)) {
                                cVar.tYo = false;
                                this.tWQ.put(uzVar.mBr, nVar.tYn);
                            } else {
                                cVar.tYo = true;
                                cVar.fCV = h2;
                            }
                            cVar.tYl = h.Rr(uzVar.wkc);
                            cVar.title = uzVar.title;
                            cVar.content = uzVar.desc;
                            cVar.tYd = uzVar.wkc;
                            if (bi.oN(cVar.content)) {
                                cVar.content = f.ah((float) uzVar.wki);
                            }
                            vVar.tYG.add(cVar);
                            this.tWR.put(nVar.tYn, cVar);
                            break;
                        default:
                            if (uzVar.bjS <= 0) {
                                break;
                            }
                            m iVar = new i();
                            iVar.tYn = nVar.tYn;
                            iVar.type = 0;
                            iVar.mBr = nVar.mBr;
                            iVar.tYm = uzVar;
                            String h3 = h(uzVar);
                            iVar.tYo = true;
                            iVar.fCV = h3;
                            iVar.tYl = tXd;
                            iVar.title = ad.getContext().getResources().getString(R.l.egA);
                            iVar.content = ad.getContext().getResources().getString(R.l.egj);
                            vVar.tYG.add(iVar);
                            this.tWR.put(nVar.tYn, iVar);
                            break;
                    }
                }
                h = h(uzVar);
                List Rx2;
                if (bi.oN(h) || !com.tencent.mm.a.e.bO(h)) {
                    n(uzVar);
                    vVar.tYH = true;
                    x.i("MicroMsg.WNNoteBase", "local html file not exist,download htmlfile,dataid: %s", uzVar.mBr);
                    this.tWQ.put(uzVar.mBr, nVar.tYn);
                    Rx2 = list2;
                } else {
                    try {
                        vVar.tYF = c.RE(h);
                        Rx2 = com.tencent.mm.plugin.wenote.b.b.Rx(vVar.tYF);
                        try {
                            x.i("MicroMsg.WNNoteBase", "local html file exist,dataid: %s", uzVar.mBr);
                            tWV.containsKey(vVar.tYF);
                        } catch (Exception e3) {
                            e = e3;
                            x.printErrStackTrace("MicroMsg.WNNoteBase", e, "", new Object[0]);
                            x.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(bi.oN(uzVar.wjN)), Boolean.valueOf(bi.oN(uzVar.wjP)));
                            list2 = Rx2;
                        }
                    } catch (Throwable e22) {
                        Throwable th = e22;
                        Rx2 = list2;
                        e = th;
                    }
                }
                x.i("MicroMsg.WNNoteBase", "dealWNNoteInfo,WeNoteHtmlFile, cdnurl is null :%B, cdnkey is null : %B ", Boolean.valueOf(bi.oN(uzVar.wjN)), Boolean.valueOf(bi.oN(uzVar.wjP)));
                list2 = Rx2;
            } else {
                x.e("MicroMsg.WNNoteBase", "Note: DataItem.htmlid is null");
                h = h(uzVar);
                if (bi.oN(h) || !com.tencent.mm.a.e.bO(h)) {
                    n(uzVar);
                    return;
                } else {
                    f.s(this.tWN.fCW, h);
                    return;
                }
            }
        }
        if (list2 != null && list2.size() > 0) {
            h.a(vVar.tYG, list2, true);
        }
        if (this.tWN.frh == -1) {
            this.tWP.put(Long.toString(this.tWN.fCW), vVar);
        } else {
            this.tWP.put(Long.toString(this.tWN.frh), vVar);
        }
    }

    public final void b(kp kpVar) {
        if (kpVar.fCH == null) {
            x.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, opertionevent.data is null, retutn");
            return;
        }
        String str = kpVar.fCH.fCJ;
        n nVar = (n) this.tWR.get(str);
        if (nVar == null) {
            x.e("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is null, retutn");
            return;
        }
        x.i("MicroMsg.WNNoteBase", "setWNNativeCallbackOnClick, mEditorIdToDataItem.get(localEditorId) is %d", Integer.valueOf(nVar.type));
        switch (nVar.type) {
            case 2:
                aP(kpVar.fCH.context, str);
                return;
            case 3:
                aO(kpVar.fCH.context, str);
                return;
            case 5:
                aN(kpVar.fCH.context, str);
                return;
            case 6:
                Context context = kpVar.fCH.context;
                j jVar = (j) this.tWR.get(str);
                if (!bi.oN(jVar.fCV)) {
                    if (!com.tencent.mm.a.e.bO(jVar.fCV)) {
                        uz Rm = Rm(jVar.mBr);
                        if (Rm == null) {
                            x.e("MicroMsg.WNNoteBase", "goToVideoPlay, favData is null");
                            return;
                        }
                        n(Rm);
                    }
                    Intent intent = new Intent();
                    intent.putExtra("key_detail_fav_path", jVar.fCV);
                    intent.putExtra("key_detail_fav_thumb_path", jVar.fwx);
                    intent.putExtra("key_detail_fav_video_duration", jVar.duration);
                    intent.putExtra("key_detail_data_id", jVar.mBr);
                    intent.putExtra("key_detail_statExtStr", "");
                    intent.putExtra("key_detail_fav_video_show_download_status", true);
                    com.tencent.mm.bl.d.b(context, "favorite", ".ui.detail.FavoriteVideoPlayUI", intent, 1);
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.protocal.c.vn a(java.lang.String r11, java.util.List<com.tencent.mm.plugin.wenote.model.a.n> r12, com.tencent.mm.protocal.c.uz r13) {
        /*
        r7 = new java.util.LinkedList;
        r7.<init>();
        r8 = new com.tencent.mm.protocal.c.vn;
        r8.<init>();
        if (r13 == 0) goto L_0x002b;
    L_0x000c:
        r7.add(r13);
    L_0x000f:
        r9 = r12.iterator();
    L_0x0013:
        r0 = r9.hasNext();
        if (r0 == 0) goto L_0x01f6;
    L_0x0019:
        r6 = r9.next();
        r6 = (com.tencent.mm.plugin.wenote.model.a.n) r6;
        if (r6 == 0) goto L_0x0013;
    L_0x0021:
        r0 = r6.tYm;
        if (r0 == 0) goto L_0x0071;
    L_0x0025:
        r0 = r6.tYm;
        r7.add(r0);
        goto L_0x0013;
    L_0x002b:
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r11);
        if (r0 != 0) goto L_0x000f;
    L_0x0031:
        r0 = r11.length();
        if (r0 <= 0) goto L_0x000f;
    L_0x0037:
        r0 = com.tencent.mm.bh.a.Vq();
        r1 = new com.tencent.mm.protocal.c.uz;
        r1.<init>();
        r2 = 8;
        r1.Dc(r2);
        r2 = "WeNoteHtmlFile";
        r1.Us(r2);
        r2 = 1;
        r1.lA(r2);
        r2 = com.tencent.mm.a.e.bN(r0);
        r2 = (long) r2;
        r1.fx(r2);
        r2 = ".htm";
        r1.Uf(r2);
        r7.add(r1);
        r2 = com.tencent.mm.plugin.wenote.model.f.o(r1);
        r3 = com.tencent.mm.modelsfs.FileOp.bO(r2);
        if (r3 != 0) goto L_0x006d;
    L_0x006a:
        com.tencent.mm.modelsfs.FileOp.x(r0, r2);
    L_0x006d:
        r1.Uj(r2);
        goto L_0x000f;
    L_0x0071:
        r10 = new com.tencent.mm.protocal.c.uz;
        r10.<init>();
        r0 = new com.tencent.mm.protocal.c.va;
        r0.<init>();
        r1 = new com.tencent.mm.protocal.c.vb;
        r1.<init>();
        r2 = 6;
        r1.Dg(r2);
        r0.c(r1);
        r10.a(r0);
        r0 = r6.type;
        switch(r0) {
            case 1: goto L_0x01a0;
            case 2: goto L_0x0099;
            case 3: goto L_0x00e1;
            case 4: goto L_0x0142;
            case 5: goto L_0x011b;
            case 6: goto L_0x016f;
            default: goto L_0x008f;
        };
    L_0x008f:
        r0 = r6.tYn;
        r10.Us(r0);
        r7.add(r10);
        goto L_0x0013;
    L_0x0099:
        r0 = 2;
        r10.Dc(r0);
        r1 = r6;
        r1 = (com.tencent.mm.plugin.wenote.model.a.o) r1;
        r0 = r1.tYp;
        r10.Uj(r0);
        r2 = r6;
        r2 = (com.tencent.mm.plugin.wenote.model.a.o) r2;
        r2 = r2.mBr;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r2);
        if (r2 != 0) goto L_0x00bf;
    L_0x00b0:
        r0 = r6.mBr;
        r10.Ui(r0);
        r0 = r1.fCV;
        r10.Uk(r0);
    L_0x00ba:
        r0 = 2;
        r10.Dc(r0);
        goto L_0x008f;
    L_0x00bf:
        r1 = r1.toString();
        r1 = com.tencent.mm.plugin.wenote.model.f.Rn(r1);
        r10.Ui(r1);
        r1 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r2 = 150; // 0x96 float:2.1E-43 double:7.4E-322;
        r3 = android.graphics.Bitmap.CompressFormat.JPEG;
        r4 = 90;
        r5 = com.tencent.mm.plugin.wenote.model.f.i(r10);
        com.tencent.mm.sdk.platformtools.d.b(r0, r1, r2, r3, r4, r5);
        r0 = com.tencent.mm.plugin.wenote.model.f.i(r10);
        r10.Uk(r0);
        goto L_0x00ba;
    L_0x00e1:
        r0 = 6;
        r10.Dc(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.r) r0;
        r1 = r6.mBr;
        r10.Ui(r1);
        r1 = new com.tencent.mm.protocal.c.vg;
        r1.<init>();
        r2 = r0.hzf;
        r1.UE(r2);
        r2 = r0.lat;
        r1.s(r2);
        r2 = r0.lng;
        r1.r(r2);
        r2 = r0.tYB;
        r2 = (int) r2;
        r1.Dh(r2);
        r0 = r0.nYL;
        r1.UF(r0);
        r0 = 1;
        r10.lz(r0);
        r0 = 1;
        r10.lA(r0);
        r0 = r10.wkH;
        r0.a(r1);
        goto L_0x008f;
    L_0x011b:
        r0 = 8;
        r10.Dc(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.t) r0;
        r1 = r6.mBr;
        r10.Ui(r1);
        r1 = r0.fCV;
        r10.Uj(r1);
        r1 = 1;
        r10.lA(r1);
        r1 = r0.title;
        r10.TV(r1);
        r1 = r0.content;
        r10.TW(r1);
        r0 = r0.tYd;
        r10.Uf(r0);
        goto L_0x008f;
    L_0x0142:
        r0 = 3;
        r10.Dc(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.u) r0;
        r1 = r6.mBr;
        r10.Ui(r1);
        r1 = r0.fCV;
        r2 = com.tencent.mm.sdk.platformtools.bi.oN(r1);
        if (r2 != 0) goto L_0x0013;
    L_0x0156:
        r2 = r1.length();
        if (r2 == 0) goto L_0x0013;
    L_0x015c:
        r10.Uj(r1);
        r1 = r0.length;
        r10.Db(r1);
        r1 = 1;
        r10.lA(r1);
        r0 = r0.tYd;
        r10.Uf(r0);
        goto L_0x008f;
    L_0x016f:
        r0 = 4;
        r10.Dc(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.j) r0;
        r1 = r6.mBr;
        r10.Ui(r1);
        r1 = r0.fCV;
        r10.Uj(r1);
        r1 = r0.fwx;
        r10.Uk(r1);
        r1 = r0.fCV;
        r1 = com.tencent.mm.plugin.sight.base.d.JX(r1);
        if (r1 == 0) goto L_0x019b;
    L_0x018d:
        r1 = r1.btk();
        r10.Db(r1);
    L_0x0194:
        r0 = r0.tYd;
        r10.Uf(r0);
        goto L_0x008f;
    L_0x019b:
        r1 = 1;
        r10.Db(r1);
        goto L_0x0194;
    L_0x01a0:
        r0 = tWY;
        if (r0 != 0) goto L_0x01b9;
    L_0x01a4:
        r0 = com.tencent.mm.plugin.report.service.g.pWK;
        r1 = 14547; // 0x38d3 float:2.0385E-41 double:7.187E-320;
        r2 = 1;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = 6;
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r0.h(r1, r2);
        r0 = 1;
        tWY = r0;
    L_0x01b9:
        r0 = 1;
        r10.Dc(r0);
        r0 = 1;
        r10.lz(r0);
        r0 = 1;
        r10.lA(r0);
        r0 = r6;
        r0 = (com.tencent.mm.plugin.wenote.model.a.h) r0;
        r1 = r6.mBr;
        r10.Ui(r1);
        r0 = r0.content;
        r0 = com.tencent.mm.plugin.wenote.b.b.Ry(r0);
        r10.TW(r0);
        r0 = r10.desc;
        r0 = com.tencent.mm.sdk.platformtools.bi.oN(r0);
        if (r0 != 0) goto L_0x008f;
    L_0x01de:
        r0 = r10.desc;
        r0 = r0.length();
        r1 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        if (r0 <= r1) goto L_0x008f;
    L_0x01e8:
        r0 = r10.desc;
        r1 = 0;
        r2 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r0 = r0.substring(r1, r2);
        r10.TW(r0);
        goto L_0x008f;
    L_0x01f6:
        a(r7, r12);
        r8.aw(r7);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.wenote.model.d.a(java.lang.String, java.util.List, com.tencent.mm.protocal.c.uz):com.tencent.mm.protocal.c.vn");
    }

    private static void a(LinkedList<uz> linkedList, List<n> list) {
        x.i("MicroMsg.WNNoteBase", "do WNNoteBase.setExtraInfo");
        if (linkedList.size() > 0) {
            int size = linkedList.size();
            int i = 0;
            while (i < size) {
                uz uzVar = (uz) linkedList.get(i);
                if (i > 0 && bi.oN(uzVar.wjN)) {
                    uzVar.Ui(f.Rn(uzVar.toString()));
                    n nVar = null;
                    if (i - 1 >= 0 && i - 1 < list.size() && list.size() > 0) {
                        nVar = (n) list.get(i - 1);
                    }
                    if (!(nVar == null || nVar.tYn == null || !nVar.tYn.equals(uzVar.wkP))) {
                        nVar.mBr = uzVar.mBr;
                    }
                }
                if (i <= 0 || bi.oN(uzVar.wjN) || bi.oN(uzVar.wjP)) {
                    String bV;
                    String bW;
                    x.i("MicroMsg.WNNoteBase", "datalist.get[%d].type = %d", Integer.valueOf(i), Integer.valueOf(uzVar.bjS));
                    String str = uzVar.wkl;
                    if (FileOp.bO(str)) {
                        x.i("MicroMsg.WNNoteBase", "datapath exist,pathname:%s", str);
                        bV = g.bV(str);
                        bW = g.bW(str);
                        uzVar.Ug(bV);
                        uzVar.Uh(bW);
                        uzVar.fx(new File(str).length());
                        bV = f.o(uzVar);
                        boolean bO = FileOp.bO(bV);
                        if (!(str.equals(bV) || bO || uzVar.wkP.equals("WeNoteHtmlFile"))) {
                            FileOp.x(str, bV);
                        }
                    } else {
                        x.e("MicroMsg.WNNoteBase", "datapath not exist, %s not exist!", str);
                    }
                    str = uzVar.wkn;
                    if (FileOp.bO(str)) {
                        x.i("MicroMsg.WNNoteBase", "thumbPath exist,pathname:%s", str);
                        bV = g.bV(str);
                        bW = g.bW(str);
                        uzVar.Ul(bV);
                        uzVar.Um(bW);
                        uzVar.fy(new File(str).length());
                        String i2 = f.i(uzVar);
                        if (!(str.equals(i2) || FileOp.bO(i2))) {
                            FileOp.x(str, i2);
                        }
                    } else {
                        x.e("MicroMsg.WNNoteBase", "thumbPath not exist, pathname:%s", str);
                    }
                } else {
                    uzVar.lz(true);
                    uzVar.lA(true);
                }
                i++;
            }
        }
    }

    public void Rl(String str) {
    }

    public final uz Rm(String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, dataId is null");
            return null;
        }
        String str2 = (String) this.tWQ.get(str);
        if (bi.oN(str2)) {
            x.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find editorId by dataId: %s", str);
            return null;
        }
        n nVar = (n) this.tWR.get(str2);
        if (nVar != null) {
            return nVar.tYm;
        }
        x.e("MicroMsg.WNNoteBase", "getFavDataItemByDataId, can not find item by editorId: %s", str2);
        return null;
    }

    public String bWB() {
        return "";
    }
}
