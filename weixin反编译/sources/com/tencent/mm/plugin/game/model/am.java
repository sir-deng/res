package com.tencent.mm.plugin.game.model;

import com.tencent.mm.bp.a;
import com.tencent.mm.plugin.game.c.av;
import com.tencent.mm.plugin.game.c.aw;
import com.tencent.mm.plugin.game.c.ay;
import com.tencent.mm.plugin.game.c.bt;
import com.tencent.mm.plugin.game.c.cr;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class am extends ad {
    public bt njG;
    private boolean njm;
    public LinkedList<d> njn;
    public HashMap<String, Integer> njo;

    public am(a aVar) {
        this.njo = new HashMap();
        if (aVar == null) {
            this.njG = new bt();
            return;
        }
        this.njG = (bt) aVar;
        this.njm = true;
        Xc();
    }

    public am(byte[] bArr) {
        this.njo = new HashMap();
        this.njG = new bt();
        if (bArr != null && bArr.length != 0) {
            try {
                this.njG.aH(bArr);
            } catch (IOException e) {
                x.e("MicroMsg.GamePBDataOverSea", "Parsing Failed: %s", e.getMessage());
            }
            this.njm = false;
            Xc();
        }
    }

    private void Xc() {
        LinkedList linkedList;
        LinkedList linkedList2 = new LinkedList();
        if (this.njG.nnP == null || this.njG.nnP.nlu == null) {
            linkedList = linkedList2;
        } else {
            Iterator it = this.njG.nnP.nlu.iterator();
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
        if (this.njm) {
            d.V(this.njn);
            aRw();
            SubCoreGameCenter.aRQ().init(ad.getContext());
        }
    }

    private void aRw() {
        this.njo = new HashMap();
        if (this.njG.nnT != null && this.njG.nnT.noW != null) {
            Iterator it = this.njG.nnT.noW.iterator();
            while (it.hasNext()) {
                cr crVar = (cr) it.next();
                d a = ad.a(crVar.nkO);
                if (a != null) {
                    this.njo.put(a.field_appId, Integer.valueOf(a.versionCode));
                    f Sk = an.biT().Sk(a.field_appId);
                    if (Sk != null) {
                        Sk.cQ(crVar.noY);
                        if (!an.biT().a(Sk, new String[0])) {
                            x.e("MicroMsg.GamePBDataOverSea", "Store rank info failed, AppID: %s", Sk.field_appId);
                        }
                    }
                }
            }
        }
    }

    public final ay aRs() {
        return this.njG != null ? this.njG.nnO : null;
    }
}
