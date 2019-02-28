package com.tencent.mm.plugin.wenote.a;

import com.tencent.mm.a.e;
import com.tencent.mm.f.a.kq;
import com.tencent.mm.plugin.fav.a.i;
import com.tencent.mm.plugin.wenote.b.b;
import com.tencent.mm.plugin.wenote.model.a.n;
import com.tencent.mm.plugin.wenote.model.a.u;
import com.tencent.mm.plugin.wenote.model.a.v;
import com.tencent.mm.plugin.wenote.model.d;
import com.tencent.mm.plugin.wenote.model.f;
import com.tencent.mm.plugin.wenote.model.nativenote.manager.c.AnonymousClass2;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import java.util.ArrayList;
import java.util.Iterator;

public final class c implements i, com.tencent.mm.plugin.record.a.c {
    public final void a(com.tencent.mm.plugin.fav.a.c cVar) {
        if (cVar.field_type != 18) {
            x.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "Not Note CDN onCdnStatusChanged %d", Long.valueOf(cVar.field_favLocalId));
            return;
        }
        if (cVar.field_status == 3 && e.bO(cVar.field_path) && cVar.field_path.endsWith("..htm")) {
            f.s(cVar.field_favLocalId, cVar.field_path);
        }
        com.tencent.mm.plugin.wenote.model.e eVar = new com.tencent.mm.plugin.wenote.model.e();
        eVar.field_favLocalId = cVar.field_favLocalId;
        eVar.field_dataId = cVar.field_dataId;
        eVar.field_status = cVar.field_status;
        eVar.field_offset = cVar.field_offset;
        eVar.field_totalLen = cVar.field_totalLen;
        eVar.field_path = cVar.field_path;
        a(eVar);
    }

    public final void a(int i, com.tencent.mm.plugin.record.a.f fVar) {
        com.tencent.mm.plugin.wenote.model.e eVar = new com.tencent.mm.plugin.wenote.model.e();
        eVar.field_localId = fVar.field_localId;
        eVar.field_dataId = fVar.field_dataId;
        eVar.field_status = fVar.field_status;
        eVar.field_offset = fVar.field_offset;
        eVar.field_totalLen = fVar.field_totalLen;
        eVar.field_path = fVar.field_path;
        a(eVar);
    }

    private static void a(com.tencent.mm.plugin.wenote.model.e eVar) {
        int i = 0;
        d dVar = com.tencent.mm.plugin.wenote.model.c.bWA().tWL;
        if (dVar != null) {
            int i2 = (eVar.field_status == 3 || eVar.field_status == 2) ? true : 0;
            if (i2 != 0 && e.bO(eVar.field_path)) {
                String str = (String) dVar.tWQ.get(eVar.field_dataId);
                if (!bi.oN(str)) {
                    x.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "on cdn status change,editorId[%s]", str);
                    if (!eVar.field_dataId.endsWith("_t") || dVar.tWR.get(str) == null) {
                        if (str.equals("WeNoteHtmlFile")) {
                            v vVar;
                            x.d("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote:webview reload");
                            if (dVar.tWN.fCW == -1) {
                                vVar = (v) dVar.tWP.get(Long.toString(dVar.tWN.frh));
                            } else {
                                vVar = (v) dVar.tWP.get(Long.toString(dVar.tWN.fCW));
                            }
                            if (vVar != null) {
                                try {
                                    vVar.tYF = com.tencent.mm.plugin.wenote.b.c.RE(eVar.field_path);
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c bXc = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc();
                                    str = vVar.tYF;
                                    if (!(bi.oN(str) || bXc.jXe == null)) {
                                        ArrayList Rx = b.Rx(str);
                                        if (Rx != null && Rx.size() > 0) {
                                            synchronized (bXc) {
                                                try {
                                                    x.i("MicroMsg.Note.NoteDataManager", "updateDataByHtml, mHasInitDataListFinish :％B", Boolean.valueOf(bXc.tZh));
                                                    as.Dt().g(new AnonymousClass2(Rx), bXc.tZh ? 500 : 1000);
                                                } catch (Exception e) {
                                                    x.e("MicroMsg.Note.NoteDataManager", "updateDataByHtml exception,%s", e.toString());
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.Note.WNNoteFavCdnChangedListener", e2, "", new Object[0]);
                                }
                            } else {
                                return;
                            }
                        } else if (dVar.tWQ.containsValue("WeNoteHtmlFile")) {
                            v vVar2;
                            if (dVar.tWN.fCW == -1) {
                                vVar2 = (v) dVar.tWP.get(Long.toString(dVar.tWN.frh));
                            } else {
                                vVar2 = (v) dVar.tWP.get(Long.toString(dVar.tWN.fCW));
                            }
                            if (vVar2 != null && vVar2.tYG != null) {
                                Iterator it = vVar2.tYG.iterator();
                                while (it.hasNext()) {
                                    com.tencent.mm.plugin.wenote.model.a.b bVar = (n) it.next();
                                    if (bVar.tYn.equals(str)) {
                                        bVar.tYo = true;
                                        if (bVar.type == 4) {
                                            u uVar = (u) bVar;
                                            uVar.tYl = d.tWZ;
                                            uz Rm = dVar.Rm(eVar.field_dataId);
                                            if (Rm == null) {
                                                x.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                            } else {
                                                i = Rm.duration;
                                            }
                                            uVar.length = (int) f.bw((long) i);
                                            uVar.tYD = f.s(ad.getContext(), uVar.length);
                                        } else if (bVar.getType() == 2) {
                                            com.tencent.mm.plugin.wenote.b.c.fi(eVar.field_path, ((n) dVar.tWR.get(str)).fCV);
                                        } else {
                                            bVar.fCV = eVar.field_path;
                                        }
                                        com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(str, bVar);
                                    }
                                }
                            } else {
                                return;
                            }
                        } else {
                            com.tencent.mm.sdk.b.b kqVar = new kq();
                            kqVar.fCS.fCJ = str;
                            kqVar.fCS.fCV = eVar.field_path;
                            kqVar.fCS.type = 1;
                            kqVar.fCS.fCN = ((n) dVar.tWR.get(str)).type;
                            if (com.tencent.mm.pluginsdk.model.c.vjO && kqVar.fCS.fCN != 4) {
                                if (kqVar.fCS.fCN != 2) {
                                    ((n) dVar.tWR.get(str)).fCV = eVar.field_path;
                                } else {
                                    com.tencent.mm.plugin.wenote.b.c.fi(eVar.field_path, ((n) dVar.tWR.get(str)).fCV);
                                }
                                ((n) dVar.tWR.get(str)).tYo = true;
                                com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(str, (com.tencent.mm.plugin.wenote.model.a.b) dVar.tWR.get(str));
                            }
                            if (5 != kqVar.fCS.fCN) {
                                if (kqVar.fCS.fCN == 4) {
                                    int i3;
                                    uz Rm2 = dVar.Rm(eVar.field_dataId);
                                    if (Rm2 == null) {
                                        x.e("MicroMsg.Note.WNNoteFavCdnChangedListener", "favData is null");
                                        i3 = 0;
                                    } else {
                                        i3 = Rm2.duration;
                                    }
                                    kqVar.fCS.fwt = i3;
                                    ((n) dVar.tWR.get(str)).fCV = eVar.field_path;
                                    ((n) dVar.tWR.get(str)).tYo = true;
                                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(str, (com.tencent.mm.plugin.wenote.model.a.b) dVar.tWR.get(str));
                                }
                                x.i("MicroMsg.Note.WNNoteFavCdnChangedListener", "WNNote: publish insertevnet:%s,%s", kqVar.fCS.fCJ, kqVar.fCS.fCV);
                                if (!com.tencent.mm.pluginsdk.model.c.vjO) {
                                    a.xmy.m(kqVar);
                                }
                            } else {
                                return;
                            }
                        }
                        dVar.tWQ.remove(eVar.field_dataId);
                        return;
                    }
                    if (((n) dVar.tWR.get(str)).getType() == 2) {
                        ((n) dVar.tWR.get(str)).fCV = eVar.field_path;
                    }
                    com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().a(str, (com.tencent.mm.plugin.wenote.model.a.b) dVar.tWR.get(str));
                    dVar.tWQ.remove(eVar.field_dataId);
                    return;
                }
                return;
            }
            return;
        }
        return;
    }
}
