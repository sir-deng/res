package com.tencent.mm.plugin.auto.a;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.support.v4.app.ah;
import android.support.v4.app.z;
import android.support.v4.app.z.g;
import com.tencent.mm.R;
import com.tencent.mm.f.a.sr;
import com.tencent.mm.f.a.v;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.j.f;
import com.tencent.mm.pluginsdk.b.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.r;
import com.tencent.mm.y.s;
import java.util.List;

public final class a {
    c knY = new c<v>() {
        {
            this.xmG = v.class.getName().hashCode();
        }

        private static boolean a(v vVar) {
            if (vVar instanceof v) {
                try {
                    g gVar;
                    com.tencent.mm.f.a.v.a aVar = vVar.foG;
                    String str = vVar.foG.username;
                    String str2 = vVar.foG.title;
                    if (a.aoJ()) {
                        PendingIntent broadcast = PendingIntent.getBroadcast(ad.getContext(), str.hashCode(), new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_HEARD_MESSAGE").putExtra("key_username", str), 134217728);
                        PendingIntent broadcast2 = PendingIntent.getBroadcast(ad.getContext(), str.hashCode(), new Intent().addFlags(32).setAction("com.tencent.mm.permission.MM_AUTO_REPLY_MESSAGE").putExtra("key_username", str), 134217728);
                        android.support.v4.app.ah.a aVar2 = new android.support.v4.app.ah.a("key_voice_reply_text");
                        aVar2.tl = ad.getContext().getString(R.l.dGF);
                        ah ahVar = new ah(aVar2.tk, aVar2.tl, aVar2.tm, aVar2.tn, aVar2.mExtras, (byte) 0);
                        android.support.v4.app.z.f.a.a aVar3 = new android.support.v4.app.z.f.a.a(str2);
                        aVar3.sD = broadcast;
                        aVar3.sB = ahVar;
                        aVar3.sC = broadcast2;
                        int eV = f.eV(str);
                        if (eV > 10) {
                            eV = 10;
                        }
                        as.Hm();
                        List by = com.tencent.mm.y.c.Fh().by(str, eV);
                        for (int size = by.size() - 1; size >= 0; size--) {
                            int hR;
                            String trim;
                            Object obj;
                            Object string;
                            au auVar = (au) by.get(size);
                            if (s.eX(auVar.field_talker)) {
                                String str3 = auVar.field_talker;
                                hR = bb.hR(auVar.field_content);
                                if (hR != -1) {
                                    trim = auVar.field_content.substring(0, hR).trim();
                                    if (trim != null && trim.length() > 0) {
                                        str3 = trim;
                                    }
                                }
                                as.Hm();
                                ag Xv = com.tencent.mm.y.c.Ff().Xv(str3);
                                trim = r.a(Xv, str3);
                                if (s.eX(str3) && (Xv.field_username.equals(trim) || bi.oN(trim))) {
                                    trim = ad.getContext().getString(R.l.dSY);
                                }
                                obj = trim;
                            } else {
                                obj = null;
                            }
                            if (auVar.cjT()) {
                                string = ad.getContext().getString(R.l.ezb);
                            } else if (auVar.cjV()) {
                                if (!s.eX(auVar.field_talker) || auVar.field_isSend == 1) {
                                    string = auVar.field_content;
                                } else {
                                    hR = bb.hR(auVar.field_content);
                                    string = hR != -1 ? auVar.field_content.substring(hR + 1).trim() : auVar.field_content;
                                }
                            } else if (auVar.cjL()) {
                                string = ad.getContext().getString(R.l.ezx);
                            } else if (auVar.cjW()) {
                                string = ad.getContext().getString(R.l.ezw);
                            } else if (auVar.cjX()) {
                                string = ad.getContext().getString(R.l.ezt);
                            } else {
                                if (auVar.aNJ()) {
                                    com.tencent.mm.x.g.a fV = com.tencent.mm.x.g.a.fV(auVar.field_content);
                                    if (fV != null) {
                                        switch (fV.type) {
                                            case 2:
                                                string = String.format(ad.getContext().getString(R.l.ezb), new Object[0]);
                                                break;
                                            case 3:
                                                string = String.format(ad.getContext().getString(R.l.eyP), new Object[]{bi.aD(fV.title, "")});
                                                break;
                                            case 4:
                                                string = String.format(ad.getContext().getString(R.l.eyT), new Object[]{bi.aD(fV.title, "")});
                                                break;
                                            case 5:
                                                string = String.format(ad.getContext().getString(R.l.eyM), new Object[]{bi.aD(fV.title, "")});
                                                break;
                                            case 6:
                                                string = String.format(ad.getContext().getString(R.l.eyL), new Object[]{bi.aD(fV.title, "")});
                                                break;
                                            case 8:
                                                string = String.format(ad.getContext().getString(R.l.eyX), new Object[]{bi.aD(fV.title, "")});
                                                break;
                                            case 10:
                                                string = String.format(ad.getContext().getString(R.l.eyQ), new Object[]{bi.aD(fV.title, "")});
                                                break;
                                            case 13:
                                                string = String.format(ad.getContext().getString(R.l.eyO), new Object[]{bi.aD(fV.title, "")});
                                                break;
                                            case 15:
                                                string = String.format(ad.getContext().getString(R.l.eyK), new Object[]{bi.aD(fV.title, "")});
                                                break;
                                            case 16:
                                                string = String.format(ad.getContext().getString(R.l.eyW), new Object[]{bi.aD(fV.title, "")});
                                                break;
                                            case 19:
                                                string = String.format(ad.getContext().getString(R.l.eyR), new Object[]{bi.aD(fV.title, "")});
                                                break;
                                            case 20:
                                                string = String.format(ad.getContext().getString(R.l.eyS), new Object[]{bi.aD(fV.title, "")});
                                                break;
                                            case 24:
                                                string = ad.getContext().getString(R.l.ehl);
                                                break;
                                        }
                                    }
                                } else if (auVar.cjY()) {
                                    String string2 = ad.getContext().getString(R.l.eyY);
                                    d emojiMgr = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr();
                                    if (emojiMgr != null) {
                                        EmojiInfo yI = emojiMgr.yI(auVar.field_imgPath);
                                        string = (yI == null || bi.oN(emojiMgr.yF(yI.Nx()))) ? ad.getContext().getString(R.l.eyY) : "[" + emojiMgr.yF(yI.Nx()) + "]";
                                    } else {
                                        trim = string2;
                                    }
                                } else if (auVar.aNL()) {
                                    string = ad.getContext().getString(R.l.ezc);
                                } else if (auVar.cjP() || auVar.cjQ()) {
                                    if (!auVar.field_content.equals(au.xHB)) {
                                        trim = auVar.field_content;
                                        b srVar = new sr();
                                        srVar.fLl.fvG = 1;
                                        srVar.fLl.content = trim;
                                        com.tencent.mm.sdk.b.a.xmy.m(srVar);
                                        if ((srVar.fLm.type == 3 ? 1 : null) == null) {
                                            string = ad.getContext().getString(R.l.ezy);
                                        }
                                    }
                                    string = ad.getContext().getString(R.l.ezz);
                                } else if (auVar.cjU()) {
                                    as.Hm();
                                    com.tencent.mm.storage.au.a Fq = com.tencent.mm.y.c.Fh().Fq(auVar.field_content);
                                    string = String.format(ad.getContext().getString(R.l.eyW), new Object[]{Fq.getDisplayName()});
                                } else if (auVar.getType() == -1879048186) {
                                    string = ad.getContext().getString(R.l.eyN);
                                }
                                trim = null;
                            }
                            if (string == null) {
                                string = ad.getContext().getString(R.l.ezu);
                            }
                            if (obj != null) {
                                string = String.format("%s: %s", new Object[]{obj, string});
                            }
                            aVar3.sH.add(string);
                            if (size == 0) {
                                aVar3.sF = auVar.field_createTime;
                            }
                        }
                        z.f fVar = new z.f();
                        fVar.sz = new android.support.v4.app.z.f.a((String[]) aVar3.sH.toArray(new String[aVar3.sH.size()]), aVar3.sB, aVar3.sC, aVar3.sD, new String[]{aVar3.sI}, aVar3.sF);
                        Object gVar2 = fVar;
                    } else {
                        gVar2 = null;
                    }
                    aVar.foH = gVar2;
                } catch (Throwable th) {
                    x.printErrStackTrace("MicroMsg.auto.AutoLogic", th, "", new Object[0]);
                }
            }
            return false;
        }
    };

    static boolean aoJ() {
        boolean z;
        try {
            ad.getContext().getPackageManager().getPackageInfo("com.google.android.projection.gearhead", 1);
            z = true;
        } catch (NameNotFoundException e) {
            z = false;
        }
        x.i("MicroMsg.auto.AutoLogic", "isInstallAutoApp %b", Boolean.valueOf(z));
        return z;
    }
}
