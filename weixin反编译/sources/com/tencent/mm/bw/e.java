package com.tencent.mm.bw;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import com.tencent.mm.f.a.he;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.m.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.q;
import com.tencent.mm.storage.emotion.s;
import java.util.ArrayList;

public class e {
    private static e xtj = null;
    private String[] xtk;
    private String[] xtl;
    private String[] xtm;
    private ArrayList<s> xtn = new ArrayList();
    private SparseArray<s> xto = new SparseArray();

    public e(Context context) {
        this.xtk = context.getResources().getStringArray(a.bqU);
        this.xtl = context.getResources().getStringArray(a.bqV);
        this.xtm = context.getResources().getStringArray(a.iuR);
        this.xtn.clear();
        this.xto.clear();
        chO();
    }

    private void chO() {
        int i = 0;
        if (this.xtk != null && this.xtl != null) {
            int length = this.xtk.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                s sVar = new s(i3, this.xtk[i2]);
                this.xtn.add(sVar);
                this.xto.put(i3, sVar);
                i2++;
                i3++;
            }
            i2 = this.xtl.length;
            while (i < i2) {
                s sVar2 = new s(i3, this.xtl[i]);
                this.xtn.add(sVar2);
                this.xto.put(i3, sVar2);
                i++;
                i3++;
            }
        }
    }

    public int anS() {
        x.d("MicroMsg.MergerSmileyManager", "updateSmileyPanelInfo");
        this.xtn.clear();
        ArrayList aBE = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().aBE();
        if (aBE == null || aBE.isEmpty()) {
            chO();
            x.i("MicroMsg.MergerSmileyManager", "smiley panel list is null.");
            return -1;
        }
        ArrayList aBD = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().aBD();
        int size = aBE.size();
        int i = 0;
        int i2 = 0;
        while (i < size) {
            int i3;
            s sVar = (s) aBE.get(i);
            String str = sVar.field_key;
            if (!str.startsWith("[") || aBD.contains(str)) {
                this.xtn.add(sVar);
                this.xto.put(i2, sVar);
                i3 = i2 + 1;
            } else {
                x.i("MicroMsg.MergerSmileyManager", "no smiley info. key:%s", str);
                i3 = i2;
            }
            i++;
            i2 = i3;
        }
        return 0;
    }

    public int anT() {
        return this.xtn == null ? 0 : this.xtn.size();
    }

    public static e chP() {
        if (xtj == null) {
            synchronized (e.class) {
                xtj = new e(ad.getContext());
            }
        }
        return xtj;
    }

    public Drawable mx(int i) {
        if (this.xto == null) {
            x.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley panel map is null.");
            return null;
        }
        s sVar = (s) this.xto.get(i);
        if (sVar == null) {
            x.i("MicroMsg.MergerSmileyManager", "getSmileyDrawable smiley info is null.");
            return null;
        }
        Drawable mx;
        q WS = f.chQ().WS(sVar.field_key);
        int i2;
        if (WS != null) {
            f.chQ();
            i2 = WS.field_position;
            mx = i2 >= 0 ? b.chK().mx(i2) : f.WR(WS.field_fileName);
        } else {
            c cVar;
            b chK = b.chK();
            String str = sVar.field_key;
            if (bi.oN(str)) {
                x.i("MicroMsg.EmojiHelper", "getEmoji item failed. key is null.");
                cVar = null;
            } else {
                i2 = str.codePointAt(0);
                cVar = chK.DD(i2) != null ? chK.DD(i2) : chK.eK(i2, 0);
            }
            mx = b.chK().a(cVar);
        }
        return mx;
    }

    public String getText(int i) {
        if (i < 0) {
            x.w("MicroMsg.MergerSmileyManager", "get text, error index");
            return "";
        }
        s sVar = (s) this.xtn.get(i);
        if (sVar == null) {
            return "";
        }
        q WS = f.chQ().WS(sVar.field_key);
        if (WS != null) {
            if (w.cfS() && !bi.oN(WS.field_cnValue)) {
                return WS.field_cnValue;
            }
            if (w.cfT() && !bi.oN(WS.field_twValue)) {
                return WS.field_twValue;
            }
        }
        return sVar.field_key;
    }

    public String mz(int i) {
        if (i < 0) {
            x.w("MicroMsg.MergerSmileyManager", "get text, error index");
            return "";
        }
        s sVar = (s) this.xtn.get(i);
        if (sVar != null) {
            return sVar.field_key;
        }
        return "";
    }

    public String my(int i) {
        if (i < 0) {
            x.w("MicroMsg.MergerSmileyManager", "get emoji text, error index down");
            return "";
        }
        b heVar = new he();
        com.tencent.mm.sdk.b.a.xmy.m(heVar);
        if ((heVar.fyk.frO == 1 ? 1 : 0) == 0) {
            return chP().xtl[i];
        }
        String[] split = chP().xtl[i].split(" ");
        char[] toChars = Character.toChars(Integer.decode(split[0]).intValue());
        char[] toChars2 = Character.toChars(Integer.decode(split[1]).intValue());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(toChars);
        stringBuilder.append(toChars2);
        return stringBuilder.toString();
    }
}
