package com.tencent.mm.bw;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.SpannableString;
import android.util.SparseArray;
import com.tencent.mm.api.c;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.m.a.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class b extends c {
    public static final String xsI = (e.hbu + "app_font");
    public static final String xsJ = (xsI + File.separator + "color_emoji");
    private static final boolean xsK = (VERSION.SDK_INT < 19);
    private static b xsL;
    private LinkedList<c> kak;
    private Context mContext = ad.getContext();
    private int xsM = 0;
    private int xsN;
    private int xsO;
    private int xsP;
    public long xsQ = 0;
    private a xsR = new a();
    private SparseArray<c> xsS = new SparseArray();
    public SparseArray<c> xsT = new SparseArray();
    private SparseArray<c> xsU = new SparseArray();
    private SparseArray<SparseArray<c>> xsV = new SparseArray();
    private SparseArray<String> xsW = null;
    private aa<Integer, Bitmap> xsX = new aa(200);
    private boolean xsY = false;
    private LinkedList<d> xsZ;
    private final Factory xta = new Factory() {
        public final Spannable newSpannable(CharSequence charSequence) {
            return new SpannableString(charSequence);
        }
    };

    private class a {
        int end;
        int start;
        c xtc;
        boolean xtd = false;

        public a(c cVar, int i, int i2, boolean z) {
            this.xtc = cVar;
            this.start = i;
            this.end = i2;
            this.xtd = z;
        }
    }

    private b() {
        if (com.tencent.mm.a.e.bO(xsJ)) {
            x.i("MicroMsg.EmojiHelper", "emoji color file exist.");
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            chL();
            k.A(this.mContext, "color_emoji", xsJ);
            x.d("MicroMsg.EmojiHelper", "copyColorEmojiFile. use time:%d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        init();
        if (com.tencent.mm.bu.a.ez(this.mContext)) {
            this.xsM = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 4);
        } else {
            this.xsM = com.tencent.mm.bu.a.fromDPToPix(this.mContext, 2);
        }
    }

    public static b chK() {
        if (xsL == null) {
            synchronized (b.class) {
                xsL = new b();
            }
        }
        return xsL;
    }

    public static void chL() {
        File file = new File(xsI);
        if (file.isFile()) {
            file.delete();
        }
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    public final void init() {
        Throwable e;
        InputStream inputStream = null;
        InputStream fileInputStream;
        DataInputStream dataInputStream;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            fileInputStream = new FileInputStream(new File(xsJ));
            try {
                dataInputStream = new DataInputStream(fileInputStream);
                try {
                    this.xsP = dataInputStream.readInt();
                    this.xsQ = dataInputStream.readLong();
                    this.xsN = dataInputStream.readInt();
                    this.xsO = ((this.xsN + 4) + 8) + 4;
                    byte[] bArr = new byte[this.xsN];
                    dataInputStream.read(bArr);
                    this.xsR.aH(bArr);
                    chM();
                    this.xsY = true;
                    x.i("MicroMsg.EmojiHelper", "init time %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    try {
                        dataInputStream.close();
                        fileInputStream.close();
                    } catch (Throwable e2) {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                    }
                } catch (Exception e3) {
                    e2 = e3;
                    inputStream = fileInputStream;
                    try {
                        x.printErrStackTrace("MicroMsg.EmojiHelper", e2, "", new Object[0]);
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e22) {
                                x.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                                return;
                            }
                        }
                        if (inputStream == null) {
                            inputStream.close();
                        }
                    } catch (Throwable th) {
                        e22 = th;
                        fileInputStream = inputStream;
                        if (dataInputStream != null) {
                            try {
                                dataInputStream.close();
                            } catch (Throwable e4) {
                                x.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                                throw e22;
                            }
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw e22;
                    }
                } catch (Throwable th2) {
                    e22 = th2;
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e22;
                }
            } catch (Exception e5) {
                e22 = e5;
                dataInputStream = null;
                inputStream = fileInputStream;
                x.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (inputStream == null) {
                    inputStream.close();
                }
            } catch (Throwable th3) {
                e22 = th3;
                dataInputStream = null;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e22;
            }
        } catch (Exception e6) {
            e22 = e6;
            dataInputStream = null;
            x.printErrStackTrace("MicroMsg.EmojiHelper", e22, "", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream == null) {
                inputStream.close();
            }
        } catch (Throwable th4) {
            e22 = th4;
            dataInputStream = null;
            fileInputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e22;
        }
    }

    public static long WM(String str) {
        Throwable e;
        InputStream inputStream;
        DataInputStream dataInputStream = null;
        InputStream fileInputStream;
        try {
            DataInputStream dataInputStream2;
            fileInputStream = new FileInputStream(new File(str));
            try {
                dataInputStream2 = new DataInputStream(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                inputStream = fileInputStream;
                try {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                            return 0;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    e3 = th;
                    fileInputStream = inputStream;
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                            throw e3;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e3;
                }
            } catch (Throwable th2) {
                e3 = th2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
            try {
                dataInputStream2.readInt();
                long readLong = dataInputStream2.readLong();
                try {
                    dataInputStream2.close();
                    fileInputStream.close();
                    return readLong;
                } catch (Throwable e5) {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e5, "", new Object[0]);
                    return readLong;
                }
            } catch (IOException e6) {
                e3 = e6;
                dataInputStream = dataInputStream2;
                inputStream = fileInputStream;
            } catch (Throwable th3) {
                e3 = th3;
                dataInputStream = dataInputStream2;
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
        } catch (IOException e7) {
            e3 = e7;
            inputStream = null;
            x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return 0;
        } catch (Throwable th4) {
            e3 = th4;
            fileInputStream = null;
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e3;
        }
    }

    public static int WN(String str) {
        DataInputStream dataInputStream;
        Throwable e;
        InputStream inputStream;
        DataInputStream dataInputStream2 = null;
        InputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(new File(str));
            try {
                dataInputStream = new DataInputStream(fileInputStream);
            } catch (IOException e2) {
                e = e2;
                dataInputStream = null;
                inputStream = fileInputStream;
                try {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
                    if (dataInputStream != null) {
                        try {
                            dataInputStream.close();
                        } catch (Throwable e3) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
                            return 0;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    return 0;
                } catch (Throwable th) {
                    e3 = th;
                    fileInputStream = inputStream;
                    dataInputStream2 = dataInputStream;
                    if (dataInputStream2 != null) {
                        try {
                            dataInputStream2.close();
                        } catch (Throwable e4) {
                            x.printErrStackTrace("MicroMsg.EmojiHelper", e4, "", new Object[0]);
                            throw e3;
                        }
                    }
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    throw e3;
                }
            } catch (Throwable th2) {
                e3 = th2;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
            try {
                int readInt = dataInputStream.readInt();
                try {
                    dataInputStream.close();
                    fileInputStream.close();
                    return readInt;
                } catch (Throwable e42) {
                    x.printErrStackTrace("MicroMsg.EmojiHelper", e42, "", new Object[0]);
                    return readInt;
                }
            } catch (IOException e5) {
                e3 = e5;
                inputStream = fileInputStream;
            } catch (Throwable th3) {
                e3 = th3;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                throw e3;
            }
        } catch (IOException e6) {
            e3 = e6;
            dataInputStream = null;
            x.printErrStackTrace("MicroMsg.EmojiHelper", e3, "", new Object[0]);
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            return 0;
        } catch (Throwable th4) {
            e3 = th4;
            fileInputStream = null;
            if (dataInputStream2 != null) {
                dataInputStream2.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw e3;
        }
    }

    public final SpannableString a(SpannableString spannableString, int i, PInt pInt) {
        return (SpannableString) a(spannableString, i, pInt, this.xta);
    }

    public final Spannable a(Spannable spannable, int i, PInt pInt, Factory factory) {
        if (spannable == null || spannable.length() == 0) {
            return spannable;
        }
        String obj = spannable.toString();
        List<a> linkedList = new LinkedList();
        int length = obj.length();
        int charCount;
        for (int i2 = 0; i2 < length; i2 = charCount) {
            int codePointAt;
            int codePointAt2 = obj.codePointAt(i2);
            charCount = i2 + Character.charCount(codePointAt2);
            if (charCount < length) {
                codePointAt = obj.codePointAt(charCount);
            } else {
                codePointAt = 0;
            }
            c DD = chK().DD(codePointAt2);
            if (DD != null) {
                linkedList.add(new a(DD, i2, i2 + 1, true));
            } else {
                DD = chK().eK(codePointAt2, codePointAt);
                if (DD != null) {
                    int charCount2;
                    if (DD.xtf != 0 || (127995 <= codePointAt && codePointAt <= 127999)) {
                        charCount2 = charCount + Character.charCount(codePointAt);
                    } else {
                        charCount2 = charCount;
                    }
                    linkedList.add(new a(DD, i2, charCount2, false));
                    charCount = charCount2;
                }
            }
            if (linkedList.size() >= pInt.value) {
                break;
            }
        }
        if (linkedList.size() == 0) {
            return spannable;
        }
        Spannable newSpannable;
        if (xsK) {
            StringBuilder stringBuilder = new StringBuilder(obj);
            for (a aVar : linkedList) {
                if (!aVar.xtd) {
                    if (aVar.xtc.xtg == 0 || aVar.end - aVar.start != 1) {
                        stringBuilder.replace(aVar.start, aVar.end, "....".substring(0, aVar.end - aVar.start));
                    } else {
                        stringBuilder.replace(aVar.start, aVar.end, String.valueOf((char) aVar.xtc.xtg));
                    }
                }
            }
            newSpannable = factory.newSpannable(stringBuilder.toString());
        } else {
            newSpannable = spannable;
        }
        for (a aVar2 : linkedList) {
            a(newSpannable, chK().a(aVar2.xtc), aVar2.start, aVar2.end, i);
        }
        pInt.value -= linkedList.size();
        return newSpannable;
    }

    public static boolean WO(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        String str2 = str.toString();
        int length = str2.length();
        int i = 0;
        while (i < length) {
            int codePointAt = str2.codePointAt(i);
            int charCount = Character.charCount(codePointAt) + i;
            if (charCount < length) {
                i = str2.codePointAt(charCount);
            } else {
                i = 0;
            }
            if (chK().DD(codePointAt) != null) {
                return true;
            }
            if (chK().eK(codePointAt, i) != null) {
                return true;
            }
            i = charCount;
        }
        return false;
    }

    public final String WP(String str) {
        if (bi.oN(str)) {
            return str;
        }
        String d;
        int i;
        if (this.xsW == null) {
            Context context = ad.getContext();
            d = w.d(context.getSharedPreferences(ad.cgf(), 0));
            String[] stringArray = d.equals("zh_CN") ? context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.lOu) : (d.equals("zh_TW") || d.equals("zh_HK")) ? context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.lOw) : context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.lOv);
            String[] stringArray2 = context.getResources().getStringArray(com.tencent.mm.plugin.m.a.a.lOt);
            this.xsW = new SparseArray();
            i = 0;
            while (i < stringArray2.length && i < stringArray.length) {
                this.xsW.put(stringArray2[i].charAt(0), stringArray[i]);
                i++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        i = 0;
        while (i < length) {
            int codePointAt;
            int codePointAt2 = str.codePointAt(i);
            i += Character.charCount(codePointAt2);
            if (i < length) {
                codePointAt = str.codePointAt(i);
            } else {
                codePointAt = 0;
            }
            c DD = chK().DD(codePointAt2);
            if (DD != null) {
                d = (String) this.xsW.get(DD.xtg);
                if (d != null) {
                    stringBuilder.append(d);
                } else {
                    stringBuilder.append(this.mContext.getString(h.dES));
                }
            } else {
                DD = chK().eK(codePointAt2, codePointAt);
                if (DD != null) {
                    if (DD.xtf != 0) {
                        i = Character.charCount(codePointAt) + i;
                    }
                    d = (String) this.xsW.get(DD.xtg);
                    if (d != null) {
                        stringBuilder.append(d);
                    } else {
                        stringBuilder.append(this.mContext.getString(h.dES));
                    }
                } else {
                    stringBuilder.appendCodePoint(codePointAt2);
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String fE(String str, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = str.length();
        int i = 0;
        while (i < length) {
            int codePointAt;
            int codePointAt2 = str.codePointAt(i);
            i += Character.charCount(codePointAt2);
            if (i < length) {
                codePointAt = str.codePointAt(i);
            } else {
                codePointAt = 0;
            }
            if (chK().DD(codePointAt2) != null) {
                stringBuilder.append(str2);
            } else {
                c eK = chK().eK(codePointAt2, codePointAt);
                if (eK != null) {
                    if (eK.xtf != 0) {
                        codePointAt = Character.charCount(codePointAt) + i;
                    } else {
                        codePointAt = i;
                    }
                    stringBuilder.append(str2);
                    i = codePointAt;
                } else {
                    stringBuilder.appendCodePoint(codePointAt2);
                }
            }
        }
        return stringBuilder.toString();
    }

    public final void a(Spannable spannable, Drawable drawable, int i, int i2, int i3) {
        try {
            drawable.setBounds(0, 0, (int) (((float) i3) * 1.3f), (int) (((float) i3) * 1.3f));
            com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(drawable, 1);
            eVar.zCd = this.xsM;
            spannable.setSpan(eVar, i, i2, 33);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
        }
    }

    public final c eK(int i, int i2) {
        if (this.xsZ == null || this.xsZ.isEmpty() || this.xsY) {
            this.xsZ = new LinkedList(this.xsR.xsG);
            this.xsY = false;
        }
        if (this.xsZ == null || this.xsZ.isEmpty()) {
            return null;
        }
        Iterator it = this.xsZ.iterator();
        boolean z = false;
        while (it.hasNext()) {
            boolean z2;
            d dVar = (d) it.next();
            if (i < dVar.tdE || i > dVar.max) {
                z2 = z;
            } else {
                z2 = true;
            }
            z = z2;
        }
        if (!z) {
            return null;
        }
        SparseArray sparseArray = (SparseArray) this.xsV.get(i);
        if (sparseArray == null) {
            return null;
        }
        if (sparseArray.size() != 1 || sparseArray.get(0) == null) {
            return (c) sparseArray.get(i2);
        }
        return (c) sparseArray.get(0);
    }

    public final c DD(int i) {
        if (i < 57345 || i > 58679) {
            return null;
        }
        return (c) this.xsS.get(i);
    }

    public final Drawable mx(int i) {
        return a((c) this.xsU.get(i));
    }

    public final Drawable a(c cVar) {
        if (cVar == null) {
            x.i("MicroMsg.EmojiHelper", "Emoji Item is null.");
            return null;
        }
        try {
            Bitmap bitmap = (Bitmap) this.xsX.get(Integer.valueOf(cVar.hna));
            if (bitmap != null && !bitmap.isRecycled()) {
                return new BitmapDrawable(ad.getContext().getResources(), bitmap);
            }
            byte[] d = com.tencent.mm.a.e.d(xsJ, cVar.hna + this.xsO, cVar.size);
            Options options = new Options();
            options.inPreferredConfig = Config.RGB_565;
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(d, 0, d.length, options);
            if (decodeByteArray != null) {
                decodeByteArray.setDensity(240);
                this.xsX.put(Integer.valueOf(cVar.hna), decodeByteArray);
                return new BitmapDrawable(ad.getContext().getResources(), decodeByteArray);
            }
            String str = "MicroMsg.EmojiHelper";
            String str2 = "bitmap is null. decode byte array failed. size:%d data length:%d";
            Object[] objArr = new Object[2];
            objArr[0] = Integer.valueOf(cVar.size);
            objArr[1] = Integer.valueOf(d == null ? 0 : d.length);
            x.i(str, str2, objArr);
            return null;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.EmojiHelper", e, "", new Object[0]);
        }
    }

    private void chM() {
        this.kak = new LinkedList(this.xsR.xsH);
        if (this.kak == null || this.kak.isEmpty()) {
            x.i("MicroMsg.EmojiHelper", "initIndex failed. items is empty.");
            return;
        }
        Iterator it = this.kak.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.xte != 0) {
                SparseArray sparseArray = (SparseArray) this.xsV.get(cVar.xte);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    this.xsV.append(cVar.xte, sparseArray);
                }
                sparseArray.put(cVar.xtf, cVar);
                if (cVar.xtg != 0) {
                    this.xsS.append(cVar.xtg, cVar);
                }
                if (cVar.xth != -1) {
                    this.xsT.append(cVar.xth, cVar);
                }
            } else {
                this.xsU.append(cVar.xti, cVar);
            }
        }
    }

    public static int chN() {
        return 1;
    }
}
