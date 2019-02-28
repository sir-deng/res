package com.tencent.mm.bw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.q;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

public final class f {
    public static Pattern xtA;
    private static final Comparator<a> xtB = new Comparator<a>() {
        public final /* synthetic */ int compare(Object obj, Object obj2) {
            a aVar = (a) obj;
            a aVar2 = (a) obj2;
            if (aVar == null && aVar2 == null) {
                return 0;
            }
            if (aVar == null || bi.oN(aVar.text)) {
                return 1;
            }
            return (aVar2 == null || bi.oN(aVar2.text)) ? -1 : aVar.text.compareTo(aVar2.text);
        }
    };
    private static volatile f xtp = null;
    public String[] xtq = null;
    public String[] xtr = null;
    public String[] xts = null;
    public String[] xtt = null;
    public String[] xtu = null;
    public String[] xtv = null;
    public ArrayList<q> xtw;
    private a[] xtx = null;
    private HashMap<String, q> xty = new HashMap();
    private SparseArray<String> xtz = new SparseArray();

    static class a {
        public String name;
        public int pos;
        public String text;

        a() {
        }

        a(int i, String str, String str2) {
            this.pos = i;
            this.text = str;
            this.name = str2;
        }
    }

    private f(Context context) {
        long currentTimeMillis = System.currentTimeMillis();
        this.xtq = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.lOx);
        this.xtr = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.lOA);
        this.xts = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.lOy);
        this.xtt = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.lOC);
        this.xtu = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.lOz);
        this.xtv = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.lOB);
        chR();
        x.d("MicroMsg.QQSmileyManager", "QQSmileyManager use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public static f chQ() {
        if (xtp == null) {
            synchronized (f.class) {
                if (xtp == null) {
                    xtp = new f(ad.getContext());
                }
            }
        }
        return xtp;
    }

    private synchronized int chR() {
        int i = 0;
        synchronized (this) {
            if (this.xtq == null || this.xts == null || this.xtq.length != this.xts.length) {
                x.i("MicroMsg.QQSmileyManager", "read smiley array failed.");
                if (this.xtw != null) {
                    this.xtx = new a[this.xtw.size()];
                }
            } else {
                int length = this.xtq.length;
                if (this.xtw != null) {
                    this.xtx = new a[((this.xtw.size() + length) * 6)];
                } else {
                    this.xtx = new a[(length * 6)];
                }
                int i2 = 0;
                while (i2 < length) {
                    String str = this.xtq[i2];
                    String str2 = this.xts[i2];
                    String str3 = (this.xtr == null || this.xtr.length <= i2) ? "" : this.xtr[i2];
                    String str4 = (this.xtt == null || this.xtt.length <= i2) ? "" : this.xtt[i2];
                    String str5 = (this.xtu == null || this.xtu.length <= i2) ? "" : this.xtu[i2];
                    String str6 = (this.xtv == null || this.xtv.length <= i2) ? "" : this.xtv[i2];
                    q qVar = new q(str, str3, str2, str4, str5, str6, i2);
                    this.xtx[(i2 * 6) + 0] = new a(i2, str, "");
                    this.xtx[(i2 * 6) + 1] = new a(i2, str2, "");
                    this.xtx[(i2 * 6) + 2] = new a(i2, str3, "");
                    this.xtx[(i2 * 6) + 3] = new a(i2, str4, "");
                    this.xtx[(i2 * 6) + 4] = new a(i2, str5, "");
                    this.xtx[(i2 * 6) + 5] = new a(i2, str6, "");
                    this.xty.put(str, qVar);
                    this.xtz.put(qVar.field_eggIndex, qVar.field_key);
                    i2++;
                }
                i = length;
            }
            if (this.xtw == null || this.xtw.isEmpty()) {
                Arrays.sort(this.xtx, xtB);
            }
        }
        return i;
    }

    public final int chS() {
        long currentTimeMillis = System.currentTimeMillis();
        this.xty.clear();
        this.xtz.clear();
        this.xtw = ((PluginEmoji) g.k(PluginEmoji.class)).getEmojiMgr().aBC();
        int chR = chR();
        if (this.xtw == null || this.xtw.isEmpty()) {
            x.i("MicroMsg.QQSmileyManager", "newSmileys list is null.");
            chR = -1;
        } else {
            Iterator it = this.xtw.iterator();
            while (true) {
                int i = chR;
                if (!it.hasNext()) {
                    break;
                }
                q qVar = (q) it.next();
                this.xty.put(qVar.field_key, qVar);
                this.xtz.put(qVar.field_eggIndex, qVar.field_key);
                this.xtx[(i * 6) + 0] = new a(-1, qVar.field_key, qVar.field_fileName);
                if (bi.oN(qVar.field_cnValue) || "null".equalsIgnoreCase(qVar.field_cnValue)) {
                    this.xtx[(i * 6) + 1] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.xtx[(i * 6) + 1] = new a(-1, qVar.field_cnValue, qVar.field_fileName);
                }
                if (bi.oN(qVar.field_qqValue) || "null".equalsIgnoreCase(qVar.field_qqValue)) {
                    this.xtx[(i * 6) + 2] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.xtx[(i * 6) + 2] = new a(-1, qVar.field_qqValue, qVar.field_fileName);
                }
                if (bi.oN(qVar.field_twValue) || "null".equalsIgnoreCase(qVar.field_twValue)) {
                    this.xtx[(i * 6) + 3] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.xtx[(i * 6) + 3] = new a(-1, qVar.field_twValue, qVar.field_fileName);
                }
                if (bi.oN(qVar.field_enValue) || "null".equalsIgnoreCase(qVar.field_enValue)) {
                    this.xtx[(i * 6) + 4] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.xtx[(i * 6) + 4] = new a(-1, qVar.field_enValue, qVar.field_fileName);
                }
                if (bi.oN(qVar.field_thValue) || "null".equalsIgnoreCase(qVar.field_thValue)) {
                    this.xtx[(i * 6) + 5] = new a(-1, qVar.field_key, qVar.field_fileName);
                } else {
                    this.xtx[(i * 6) + 5] = new a(-1, qVar.field_thValue, qVar.field_fileName);
                }
                chR = i + 1;
            }
            chR = 0;
        }
        Arrays.sort(this.xtx, xtB);
        x.i("MicroMsg.QQSmileyManager", "updateSmiley end use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        return chR;
    }

    public final String fF(String str, String str2) {
        int i = 0;
        int length = str.length();
        StringBuilder stringBuilder = new StringBuilder(length);
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '/' || charAt == '[') {
                a WQ = WQ(str.substring(i));
                if (WQ != null) {
                    stringBuilder.append(str2);
                    i += WQ.text.length();
                }
            }
            stringBuilder.append(charAt);
            i++;
        }
        return stringBuilder.toString();
    }

    public final a WQ(String str) {
        a[] aVarArr = chQ().xtx;
        if (aVarArr != null) {
            int binarySearch = Arrays.binarySearch(this.xtx, new a(0, str, ""), xtB);
            if (binarySearch < 0) {
                binarySearch = (-binarySearch) - 2;
            }
            if (binarySearch >= 0 && str.startsWith(this.xtx[binarySearch].text)) {
                return aVarArr[binarySearch];
            }
        }
        return null;
    }

    public final SpannableString a(SpannableString spannableString, int i, int i2) {
        if (spannableString != null && spannableString.length() != 0) {
            String spannableString2 = spannableString.toString();
            int i3 = 0;
            int i4 = -1;
            while (true) {
                i4 = spannableString2.indexOf(47, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
            while (true) {
                i4 = spannableString2.indexOf(91, i4 + 1);
                if (i4 != -1) {
                    if (i4 < spannableString2.length() - 1) {
                        if (i3 >= i2) {
                            break;
                        } else if (a(i4, spannableString, i)) {
                            i3++;
                        }
                    }
                } else {
                    break;
                }
            }
        }
        return spannableString;
    }

    private boolean a(int i, SpannableString spannableString, int i2) {
        a WQ = WQ(spannableString.subSequence(i, spannableString.length()));
        if (WQ == null) {
            return false;
        }
        int i3 = WQ.pos;
        Drawable mx = i3 >= 0 ? b.chK().mx(i3) : WR(WQ.name);
        if (mx == null || i > spannableString.length() || WQ.text.length() + i > spannableString.length()) {
            x.i("MicroMsg.QQSmileyManager", "spanQQSmileyIcon failed. drawable not found. smiley:%s", WQ.toString());
            return false;
        }
        b.chK().a(spannableString, mx, i, i + WQ.text.length(), i2);
        return true;
    }

    static Drawable WR(String str) {
        Throwable e;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(com.tencent.mm.aj.a.No() + "/" + str);
            try {
                Options options = new Options();
                options.inPreferredConfig = Config.RGB_565;
                Bitmap decodeStream = BitmapFactory.decodeStream(fileInputStream, null, options);
                if (decodeStream == null) {
                    x.i("MicroMsg.QQSmileyManager", "getQQSmileyDrawable bitmap is null.");
                }
                Drawable bitmapDrawable = new BitmapDrawable(ad.getContext().getResources(), decodeStream);
                try {
                    fileInputStream.close();
                    return bitmapDrawable;
                } catch (Throwable e2) {
                    x.i("MicroMsg.QQSmileyManager", bi.i(e2));
                    return bitmapDrawable;
                }
            } catch (FileNotFoundException e3) {
                e = e3;
                try {
                    x.i("MicroMsg.QQSmileyManager", bi.i(e));
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e4) {
                            x.i("MicroMsg.QQSmileyManager", bi.i(e4));
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e4 = th;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable e22) {
                            x.i("MicroMsg.QQSmileyManager", bi.i(e22));
                        }
                    }
                    throw e4;
                }
            }
        } catch (FileNotFoundException e5) {
            e4 = e5;
            fileInputStream = null;
            x.i("MicroMsg.QQSmileyManager", bi.i(e4));
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return null;
        } catch (Throwable th2) {
            e4 = th2;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e4;
        }
    }

    public final q WS(String str) {
        if (this.xty != null && this.xty.containsKey(str)) {
            return (q) this.xty.get(str);
        }
        x.i("MicroMsg.QQSmileyManager", "getSmileyInfo failed. smiley map no contains key:%s", str);
        return null;
    }
}
