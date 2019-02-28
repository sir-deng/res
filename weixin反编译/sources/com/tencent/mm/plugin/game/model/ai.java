package com.tencent.mm.plugin.game.model;

import com.tencent.mm.plugin.game.c.an;
import com.tencent.mm.plugin.game.c.av;
import com.tencent.mm.plugin.game.c.aw;
import com.tencent.mm.plugin.game.c.ay;
import com.tencent.mm.plugin.game.c.bj;
import com.tencent.mm.plugin.game.c.cp;
import com.tencent.mm.plugin.game.c.cr;
import com.tencent.mm.plugin.game.c.da;
import com.tencent.mm.plugin.game.c.dd;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class ai extends ad {
    public bj njl;
    private boolean njm;
    public LinkedList<d> njn;
    public HashMap<String, Integer> njo;
    public a njp;

    public static class a {
        public LinkedList<a> njq = new LinkedList();
        public da njr;

        public static class a {
            public d njs;
            public LinkedList<an> njt;
        }
    }

    public ai(com.tencent.mm.bp.a aVar) {
        this.njo = new HashMap();
        if (aVar == null) {
            this.njl = new bj();
            return;
        }
        this.njl = (bj) aVar;
        this.njm = true;
        Xc();
    }

    public ai(byte[] bArr) {
        this.njo = new HashMap();
        this.njl = new bj();
        if (bArr != null && bArr.length != 0) {
            try {
                this.njl.aH(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataIndex", "Parsing Failed: %s", e.getMessage());
            }
            this.njm = false;
            Xc();
        }
    }

    private void Xc() {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        if (this.njl.nnP == null || this.njl.nnP.nlu == null) {
            linkedList = linkedList2;
        } else {
            Iterator it = this.njl.nnP.nlu.iterator();
            int i = 1;
            while (it.hasNext()) {
                av avVar = (av) it.next();
                if (avVar.nkO != null) {
                    d a = ad.a(avVar.nkO);
                    if (a != null) {
                        if (avVar.nkO.nli == null) {
                            a.ngQ = ap.CD(avVar.nlr);
                        } else if (avVar.nkO.nli.nkW == null || avVar.nkO.nli.npa == null) {
                            a.ngQ = ap.CD(avVar.nlr);
                        } else {
                            a.ngM = avVar.nkO.nli.nkW;
                            a.ngN = avVar.nkO.nli.npa;
                            a.ngQ = ap.M(avVar.nlr, "label", a.ngM);
                        }
                        if (avVar.nmY != null) {
                            Iterator it2 = avVar.nmY.iterator();
                            while (it2.hasNext()) {
                                aw awVar = (aw) it2.next();
                                if (awVar != null) {
                                    if (awVar.nmZ == null || awVar.nmZ.size() == 0) {
                                        a.ngH.add("");
                                    } else {
                                        StringBuilder stringBuilder = new StringBuilder();
                                        int i2 = 0;
                                        while (true) {
                                            int i3 = i2;
                                            if (i3 >= awVar.nmZ.size()) {
                                                break;
                                            }
                                            as.Hm();
                                            com.tencent.mm.storage.x Xv = c.Ff().Xv((String) awVar.nmZ.get(i3));
                                            if (Xv == null || Xv.gKO == 0) {
                                                stringBuilder.append((String) awVar.nmZ.get(i3));
                                            } else {
                                                stringBuilder.append(Xv.AX());
                                            }
                                            if (i3 < awVar.nmZ.size() - 1) {
                                                stringBuilder.append("、");
                                            }
                                            i2 = i3 + 1;
                                        }
                                        stringBuilder.append(" ");
                                        a.ngH.add(stringBuilder.toString());
                                    }
                                    a.ngH.add(awVar.nlZ);
                                }
                            }
                        }
                        a.scene = 10;
                        a.fGe = 1004;
                        int i4 = i + 1;
                        a.position = i;
                        linkedList2.add(a);
                        i = i4;
                    }
                }
            }
            linkedList = linkedList2;
        }
        this.njn = linkedList;
        this.njp = aRu();
        if (this.njm) {
            d.V(this.njn);
            if (!(this.njp == null || bi.cC(this.njp.njq))) {
                LinkedList linkedList3 = new LinkedList();
                Iterator it3 = this.njp.njq.iterator();
                while (it3.hasNext()) {
                    linkedList3.add(((a) it3.next()).njs);
                }
                d.V(linkedList3);
            }
            aRw();
            SubCoreGameCenter.aRQ().init(ad.getContext());
        }
    }

    public final ay aRs() {
        return this.njl != null ? this.njl.nnO : null;
    }

    public final cp aRt() {
        return this.njl != null ? this.njl.nnU : null;
    }

    private a aRu() {
        if (this.njl.nnS == null || bi.cC(this.njl.nnS.nlu)) {
            return null;
        }
        a aVar = new a();
        Iterator it = this.njl.nnS.nlu.iterator();
        int i = 0;
        while (it.hasNext()) {
            dd ddVar = (dd) it.next();
            d a = ad.a(ddVar.nkO);
            if (a != null) {
                a.ngO = ddVar.nkL;
                a.scene = 10;
                a.fGe = 1002;
                i++;
                a.position = i;
                a aVar2 = new a();
                aVar2.njs = a;
                aVar2.njt = ddVar.npm;
                aVar.njq.add(aVar2);
            }
        }
        aVar.njr = this.njl.nnS.nmC;
        return aVar;
    }

    public final LinkedList<d> aRv() {
        LinkedList<d> linkedList = new LinkedList();
        if (this.njl.nnT == null || this.njl.nnT.noW == null) {
            return linkedList;
        }
        Iterator it = this.njl.nnT.noW.iterator();
        while (it.hasNext()) {
            cr crVar = (cr) it.next();
            if (crVar != null) {
                d a = ad.a(crVar.nkO);
                if (a != null) {
                    a.cQ(crVar.noY);
                    linkedList.addFirst(a);
                }
            }
        }
        return linkedList;
    }

    private void aRw() {
        this.njo = new HashMap();
        if (this.njl.nnT != null && this.njl.nnT.noW != null) {
            Iterator it = this.njl.nnT.noW.iterator();
            while (it.hasNext()) {
                cr crVar = (cr) it.next();
                d a = ad.a(crVar.nkO);
                if (a != null) {
                    this.njo.put(a.field_appId, Integer.valueOf(a.versionCode));
                    f Sk = com.tencent.mm.pluginsdk.model.app.an.biT().Sk(a.field_appId);
                    if (Sk != null) {
                        Sk.cQ(crVar.noY);
                        if (!com.tencent.mm.pluginsdk.model.app.an.biT().a(Sk, new String[0])) {
                            x.e("MicroMsg.GamePBDataIndex", "Store rank info failed, AppID: %s", Sk.field_appId);
                        }
                    }
                }
            }
        }
    }
}
