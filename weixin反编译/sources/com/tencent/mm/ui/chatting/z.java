package com.tencent.mm.ui.chatting;

import android.app.Activity;
import android.os.Looper;
import android.os.Message;
import android.view.ViewStub;
import com.tencent.mm.R;
import com.tencent.mm.ay.d;
import com.tencent.mm.ay.e;
import com.tencent.mm.ay.f;
import com.tencent.mm.ay.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.i.a.b.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.as;
import com.tencent.mm.y.bb;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;
import java.util.Iterator;
import java.util.List;

public final class z {
    public List<au> kPq;
    public ag mHandler = new ag(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (z.this.kPq != null && as.Hp()) {
                x.d("MicroMsg.EggMgr", "post start egg");
                z.this.a(z.this.yFM, z.this.kPq);
            }
        }
    };
    public ChattingAnimFrame yFL = null;
    public Activity yFM;

    public final void a(Activity activity, List<au> list) {
        if (list != null) {
            for (au auVar : list) {
                Object obj;
                as.Hm();
                if (t.bz(t.d((Long) c.Db().get(68108, null))) * 1000 > 21600000) {
                    new ag().postDelayed(new Runnable() {
                        public final void run() {
                            if (as.Hp()) {
                                as.CN().a(new m(37), 0);
                                as.Hm();
                                c.Db().set(68108, Long.valueOf(t.Wx()));
                            }
                        }
                    }, 10000);
                }
                f aBF = ((com.tencent.mm.plugin.emoji.b.c) g.k(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().aBF();
                if (aBF == null) {
                    x.d("MicroMsg.EggMgr", "eggList is null");
                    obj = null;
                    continue;
                } else {
                    int Wx = (int) bi.Wx();
                    x.d("MicroMsg.EggMgr", "cursecond is %d, getEggList.size is %d", Integer.valueOf(Wx), Integer.valueOf(aBF.hLn.size()));
                    Iterator it = aBF.hLn.iterator();
                    while (it.hasNext()) {
                        d dVar = (d) it.next();
                        String str = dVar.hLh;
                        Object obj2 = null;
                        if (t.oN(str)) {
                            obj2 = 1;
                        } else {
                            for (String equals : str.split(",")) {
                                if (equals.equals(w.cfV())) {
                                    obj2 = 1;
                                    break;
                                }
                            }
                        }
                        if (obj2 != null) {
                            Iterator it2 = dVar.hLc.iterator();
                            while (it2.hasNext()) {
                                e eVar = (e) it2.next();
                                String str2 = eVar.hLm;
                                if (t.oN(str2)) {
                                    x.e("MicroMsg.EggMgr", "error egg keyWord");
                                } else {
                                    str = auVar.field_content;
                                    if (s.eX(auVar.field_talker)) {
                                        int hR = bb.hR(str);
                                        if (hR != -1) {
                                            str = str.substring(hR + 1).trim();
                                        }
                                    }
                                    if (al(str, str2, eVar.lang)) {
                                        if (this.yFL == null) {
                                            ViewStub viewStub = (ViewStub) activity.findViewById(R.h.cVY);
                                            if (viewStub != null) {
                                                viewStub.inflate();
                                            }
                                            this.yFL = (ChattingAnimFrame) activity.findViewById(R.h.bSO);
                                        }
                                        if (this.yFL == null) {
                                            x.e("MicroMsg.EggMgr", "AnimFrameView should not be null");
                                        } else if (dVar.hLf <= Wx && ((long) Wx) <= ((long) dVar.hLg) + 86400) {
                                            this.yFL.a(dVar);
                                            ah(dVar.hLe, auVar.field_isSend == 1);
                                            x.d("MicroMsg.EggMgr", "match keyWord[%s], time[%d - %d]", str2, Integer.valueOf(dVar.hLf), Integer.valueOf(dVar.hLg));
                                            obj = 1;
                                            continue;
                                        } else if (dVar.hLf == dVar.hLg && dVar.hLf == 0) {
                                            this.yFL.a(dVar);
                                            ah(dVar.hLe, auVar.field_isSend == 1);
                                            x.d("MicroMsg.EggMgr", "match keyWord[%s], time[0 - 0]", str2);
                                            obj = 1;
                                            continue;
                                        } else {
                                            x.d("MicroMsg.EggMgr", "match keyWord[%s], but not match time[%d - %d]", str2, Integer.valueOf(dVar.hLf), Integer.valueOf(dVar.hLg));
                                            obj = null;
                                            continue;
                                        }
                                    } else {
                                        continue;
                                    }
                                }
                            }
                            continue;
                        }
                    }
                    x.d("MicroMsg.EggMgr", "no match");
                    obj = null;
                    continue;
                }
                if (obj != null) {
                    return;
                }
            }
        }
    }

    private static boolean al(String str, String str2, String str3) {
        if (t.oN(str) || t.oN(str2) || ad.getContext() == null) {
            return false;
        }
        String toLowerCase = str.toLowerCase();
        int indexOf = toLowerCase.indexOf(str2.toLowerCase());
        if (indexOf == -1) {
            return false;
        }
        do {
            int i = indexOf;
            try {
                boolean z;
                if (i >= toLowerCase.length() - 1 || t.oN(str3)) {
                    z = true;
                } else {
                    if (i > 0 && toLowerCase.charAt(i - 1) >= 'a' && toLowerCase.charAt(i - 1) <= 'z') {
                        x.v("MicroMsg.EggMgr", "letter in the prefix");
                        String substring = str.substring(0, i);
                        indexOf = substring.lastIndexOf(47);
                        if (indexOf != -1) {
                            substring = substring.subSequence(indexOf, substring.length());
                            com.tencent.mm.bw.g.chT();
                            a WQ = com.tencent.mm.bw.f.chQ().WQ(substring);
                            substring = WQ != null ? WQ.text : null;
                            if (!t.oN(substring) && substring.length() + indexOf == i) {
                                x.v("MicroMsg.EggMgr", "letter in the prefix is smiley");
                                indexOf = -2;
                            }
                        }
                        if (indexOf != -2) {
                            z = false;
                            if (z && str2.length() + i < toLowerCase.length() && toLowerCase.charAt(str2.length() + i) >= 'a' && toLowerCase.charAt(str2.length() + i) <= 'z') {
                                x.v("MicroMsg.EggMgr", "letter in the suffix");
                                z = false;
                            }
                        }
                    }
                    z = true;
                    x.v("MicroMsg.EggMgr", "letter in the suffix");
                    z = false;
                }
                if (z) {
                    x.v("MicroMsg.EggMgr", "full match, matchPos = %s, TextLength = %s, keyLength = %s", Integer.valueOf(i), Integer.valueOf(toLowerCase.length()), Integer.valueOf(str2.length()));
                    return z;
                }
                indexOf = toLowerCase.indexOf(str2.toLowerCase(), i + 1);
            } catch (Throwable e) {
                x.v("MicroMsg.EggMgr", "Exception in isKeywordMatch, %s", e.getMessage());
                x.printErrStackTrace("MicroMsg.EggMgr", e, "", new Object[0]);
                return false;
            }
        } while (indexOf != -1);
        return false;
    }

    private static void ah(int i, boolean z) {
        try {
            h hVar;
            com.tencent.mm.ay.g gVar;
            int i2;
            StringBuilder stringBuilder;
            StringBuilder stringBuilder2 = new StringBuilder();
            as.Hm();
            byte[] e = com.tencent.mm.a.e.e(stringBuilder2.append(c.FI()).append("eggresult.rep").toString(), 0, -1);
            if (e != null) {
                x.d("MicroMsg.EggMgr", "data not null, parse it");
                hVar = (h) new h().aH(e);
            } else {
                x.d("MicroMsg.EggMgr", "data is null, new one");
                hVar = new h();
            }
            Iterator it = hVar.hLr.iterator();
            while (it.hasNext()) {
                gVar = (com.tencent.mm.ay.g) it.next();
                if (gVar.hLe == i) {
                    if (z) {
                        gVar.hLp++;
                    } else {
                        gVar.hLq++;
                    }
                    i2 = 1;
                    if (i2 == 0) {
                        gVar = new com.tencent.mm.ay.g();
                        gVar.hLe = i;
                        if (z) {
                            gVar.hLq = 1;
                        } else {
                            gVar.hLp = 1;
                        }
                        hVar.hLr.add(gVar);
                    }
                    e = hVar.toByteArray();
                    x.d("MicroMsg.EggMgr", "report list is %s, then save it", hVar.toString());
                    stringBuilder = new StringBuilder();
                    as.Hm();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.FI()).append("eggresult.rep").toString(), e, e.length);
                }
            }
            i2 = 0;
            if (i2 == 0) {
                gVar = new com.tencent.mm.ay.g();
                gVar.hLe = i;
                if (z) {
                    gVar.hLq = 1;
                } else {
                    gVar.hLp = 1;
                }
                hVar.hLr.add(gVar);
            }
            e = hVar.toByteArray();
            x.d("MicroMsg.EggMgr", "report list is %s, then save it", hVar.toString());
            stringBuilder = new StringBuilder();
            as.Hm();
            com.tencent.mm.a.e.b(stringBuilder.append(c.FI()).append("eggresult.rep").toString(), e, e.length);
        } catch (Throwable e2) {
            x.w("MicroMsg.EggMgr", "statistics crash : %s", e2.getLocalizedMessage());
            x.printErrStackTrace("MicroMsg.EggMgr", e2, "", new Object[0]);
        }
    }
}
