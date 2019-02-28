package com.tencent.mm.bv;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mm.a.a;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class e {
    private static final List<String> xjX = Arrays.asList(new String[]{"zh_CN"});
    private static e xjY;
    private static f xjZ;
    private static b xka;
    private static d xkb;
    private static String xkc = "";
    private static boolean xkd = false;
    private static boolean xke = true;
    private static ArrayList<Integer> xkf = new ArrayList();

    public static e ceN() {
        e eVar;
        synchronized (e.class) {
            if (xjY == null) {
                xjY = new e();
            }
            eVar = xjY;
        }
        return eVar;
    }

    private e() {
    }

    private static void clean() {
        if (xjZ != null) {
            f fVar = xjZ;
            if (fVar.xkg != null) {
                fVar.xkg.clear();
            }
            if (fVar.xkh != null) {
                fVar.xkh = null;
            }
        }
        if (xka != null) {
            b bVar = xka;
            if (bVar.xjQ != null) {
                bVar.xjQ.clear();
            }
            if (bVar.kCs != null) {
                bVar.kCs = null;
            }
        }
        if (xkb != null) {
            d dVar = xkb;
            if (dVar.xjV != null) {
                dVar.xjV.clear();
            }
            if (dVar.kCs != null) {
                dVar.kCs = null;
            }
        }
    }

    public static e eD(Context context) {
        return bg(context, w.d(context.getSharedPreferences(ad.cgf(), 0)));
    }

    public static e bg(Context context, String str) {
        Throwable e;
        InputStream inputStream;
        Locale locale;
        String locale2;
        boolean z;
        Throwable th;
        if (context.getResources() == null) {
            x.e("MicroMsg.language.StringResouces", "the resource is null! why?");
            return null;
        }
        AssetManager assets = context.getAssets();
        if (assets != null) {
            ceN();
            x.i("MicroMsg.language.StringResouces", "[cpan] start to init string encrypt StringID List");
            if (xkf == null) {
                xkf = new ArrayList();
            }
            xkf.clear();
            long currentTimeMillis = System.currentTimeMillis();
            DataInputStream dataInputStream = null;
            InputStream open;
            DataInputStream dataInputStream2;
            try {
                open = assets.open("estrings/encrypt.mmstrid");
                try {
                    dataInputStream2 = new DataInputStream(open);
                    try {
                        x.d("MicroMsg.language.StringResouces", "encrypt string id size %d", Integer.valueOf(dataInputStream2.readInt()));
                        for (int i = 0; i < r6.intValue(); i++) {
                            xkf.add(Integer.valueOf(dataInputStream2.readInt()));
                            x.d("MicroMsg.language.StringResouces", "encrypt string id is %d", r7);
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable e2) {
                                x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e2));
                            }
                        }
                        try {
                            dataInputStream2.close();
                        } catch (Throwable e3) {
                            x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e3));
                        }
                    } catch (IOException e4) {
                        inputStream = open;
                        try {
                            x.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e22) {
                                    x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e22));
                                }
                            }
                            if (dataInputStream2 != null) {
                                try {
                                    dataInputStream2.close();
                                } catch (Throwable e32) {
                                    x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e32));
                                }
                            }
                            x.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                            if (assets != null) {
                                ceN();
                                if (xke) {
                                    if (!bi.oN(str)) {
                                    }
                                    locale = Locale.getDefault();
                                    w.a(context, locale);
                                    locale2 = locale.toString();
                                    ceN();
                                    z = xjX.contains(locale2);
                                    xkd = z;
                                    if (z) {
                                        ceN();
                                        a(assets, locale2);
                                        return ceN();
                                    }
                                    clean();
                                    xkc = locale2;
                                    return null;
                                }
                            }
                            return null;
                        } catch (Throwable th2) {
                            th = th2;
                            open = inputStream;
                            dataInputStream = dataInputStream2;
                            e32 = th;
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable th22) {
                                    x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(th22));
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Throwable e222) {
                                    x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e222));
                                }
                            }
                            throw e32;
                        }
                    } catch (Throwable e2222) {
                        th = e2222;
                        dataInputStream = dataInputStream2;
                        e32 = th;
                        if (open != null) {
                            open.close();
                        }
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        throw e32;
                    }
                } catch (IOException e5) {
                    dataInputStream2 = null;
                    inputStream = open;
                    x.w("MicroMsg.language.StringResouces", "[cpan] initEncryptStringIDList faild .");
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataInputStream2 != null) {
                        dataInputStream2.close();
                    }
                    x.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
                    if (assets != null) {
                        ceN();
                        if (xke) {
                            if (bi.oN(str)) {
                            }
                            locale = Locale.getDefault();
                            w.a(context, locale);
                            locale2 = locale.toString();
                            ceN();
                            if (xjX.contains(locale2)) {
                            }
                            xkd = z;
                            if (z) {
                                clean();
                                xkc = locale2;
                                return null;
                            }
                            ceN();
                            a(assets, locale2);
                            return ceN();
                        }
                    }
                    return null;
                } catch (Throwable th3) {
                    e32 = th3;
                    if (open != null) {
                        open.close();
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    throw e32;
                }
            } catch (IOException e6) {
                inputStream = null;
                dataInputStream2 = null;
            } catch (Throwable th222) {
                th = th222;
                open = null;
                e32 = th;
                if (open != null) {
                    open.close();
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw e32;
            }
            x.i("MicroMsg.language.StringResouces", "[cpan] finish init encrypt StringID List:" + (System.currentTimeMillis() - currentTimeMillis));
        }
        if (assets != null) {
            ceN();
            if (xke) {
                if (bi.oN(str) || str.equalsIgnoreCase("language_default")) {
                    locale = Locale.getDefault();
                    w.a(context, locale);
                } else {
                    locale = w.VC(str);
                }
                locale2 = locale.toString();
                ceN();
                if (xjX.contains(locale2)) {
                }
                xkd = z;
                if (z) {
                    ceN();
                    a(assets, locale2);
                    return ceN();
                }
                clean();
                xkc = locale2;
                return null;
            }
        }
        return null;
    }

    private static void a(AssetManager assetManager, String str) {
        Throwable e;
        InputStream inputStream;
        if (bi.oN(str)) {
            x.w("MicroMsg.language.StringResouces", "local is null.");
        } else if (str.equals(xkc)) {
            x.i("MicroMsg.language.StringResouces", "local no change. local is :%s", str);
        } else {
            int indexOf = str.indexOf("_");
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("zh")) {
                    x.d("MicroMsg.language.StringResouces", "local is :%s temp local is :%s", str, substring);
                    str = substring;
                }
            }
            clean();
            xkc = str;
            x.i("MicroMsg.language.StringResouces", "[cpan] start to init string resource");
            long currentTimeMillis = System.currentTimeMillis();
            InputStream open;
            DataInputStream dataInputStream;
            try {
                open = assetManager.open("strings/" + str + ".mmstr");
                try {
                    dataInputStream = new DataInputStream(open);
                    try {
                        int i;
                        dataInputStream.readInt();
                        dataInputStream.readInt();
                        int readInt = dataInputStream.readInt();
                        x.i("MicroMsg.language.StringResouces", "string count" + readInt);
                        SparseIntArray sparseIntArray = new SparseIntArray(readInt);
                        int readInt2 = dataInputStream.readInt();
                        indexOf = 0;
                        for (i = 0; i < readInt; i++) {
                            readInt2 += dataInputStream.readShort();
                            sparseIntArray.append(readInt2, indexOf);
                            indexOf += dataInputStream.readShort();
                        }
                        xjZ = f.a(sparseIntArray, dataInputStream, indexOf);
                        readInt = dataInputStream.readInt();
                        x.i("MicroMsg.language.StringResouces", "plurals string count:%d", Integer.valueOf(readInt));
                        if (readInt > 0) {
                            SparseArray sparseArray = new SparseArray(readInt);
                            readInt2 = dataInputStream.readInt();
                            i = 0;
                            for (indexOf = 0; indexOf < readInt; indexOf++) {
                                readInt2 += dataInputStream.readInt();
                                i += a(dataInputStream, sparseArray, readInt2, i);
                            }
                            xka = b.a(sparseArray, dataInputStream, i);
                        }
                        int readInt3 = dataInputStream.readInt();
                        indexOf = dataInputStream.readInt();
                        x.i("MicroMsg.language.StringResouces", "string array count：%d", Integer.valueOf(readInt3));
                        if (readInt3 > 0) {
                            SparseArray sparseArray2 = new SparseArray(readInt3);
                            i = 0;
                            readInt = 0;
                            while (readInt < readInt3) {
                                readInt2 = dataInputStream.readInt() + indexOf;
                                int readInt4 = dataInputStream.readInt();
                                int[] iArr = new int[readInt4];
                                for (indexOf = 0; indexOf < readInt4; indexOf++) {
                                    iArr[indexOf] = i;
                                    i += dataInputStream.readShort();
                                }
                                sparseArray2.append(readInt2, new a(readInt2, iArr));
                                readInt++;
                                indexOf = readInt2;
                            }
                            xkb = d.b(sparseArray2, dataInputStream, i);
                        }
                        if (open != null) {
                            try {
                                open.close();
                            } catch (Throwable e2) {
                                x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e2));
                            }
                        }
                        try {
                            dataInputStream.close();
                        } catch (Throwable e22) {
                            x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e22));
                        }
                    } catch (IOException e3) {
                        e22 = e3;
                        inputStream = open;
                        try {
                            x.printErrStackTrace("MicroMsg.language.StringResouces", e22, "[cpan] local :%s file can not be find. use default.", str);
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable e222) {
                                    x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e222));
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Throwable e2222) {
                                    x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e2222));
                                }
                            }
                            x.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
                        } catch (Throwable th) {
                            e2222 = th;
                            open = inputStream;
                            if (open != null) {
                                try {
                                    open.close();
                                } catch (Throwable e4) {
                                    x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e4));
                                }
                            }
                            if (dataInputStream != null) {
                                try {
                                    dataInputStream.close();
                                } catch (Throwable e5) {
                                    x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e5));
                                }
                            }
                            throw e2222;
                        }
                    } catch (Throwable th2) {
                        e2222 = th2;
                        if (open != null) {
                            open.close();
                        }
                        if (dataInputStream != null) {
                            dataInputStream.close();
                        }
                        throw e2222;
                    }
                } catch (IOException e6) {
                    e2222 = e6;
                    dataInputStream = null;
                    inputStream = open;
                    x.printErrStackTrace("MicroMsg.language.StringResouces", e2222, "[cpan] local :%s file can not be find. use default.", str);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    x.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
                } catch (Throwable th3) {
                    e2222 = th3;
                    dataInputStream = null;
                    if (open != null) {
                        open.close();
                    }
                    if (dataInputStream != null) {
                        dataInputStream.close();
                    }
                    throw e2222;
                }
            } catch (IOException e7) {
                e2222 = e7;
                inputStream = null;
                dataInputStream = null;
            } catch (Throwable th4) {
                e2222 = th4;
                open = null;
                dataInputStream = null;
                if (open != null) {
                    open.close();
                }
                if (dataInputStream != null) {
                    dataInputStream.close();
                }
                throw e2222;
            }
            x.i("MicroMsg.language.StringResouces", "[cpan] finish init string resource user time:" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public static boolean ceO() {
        if (!(xke && xkd)) {
            boolean z = (xkf == null || xkf.isEmpty()) ? false : true;
            if (!z) {
                return false;
            }
        }
        return true;
    }

    public static boolean ceM() {
        return xke;
    }

    public static String getString(int i) {
        if (xjZ == null) {
            return null;
        }
        return xjZ.getString(i);
    }

    public static String getQuantityString(int i, int i2) {
        if (xka == null) {
            return null;
        }
        return xka.getQuantityString(i, i2, new Object[0]);
    }

    public static String getQuantityString(int i, int i2, Object... objArr) {
        if (xka == null) {
            return null;
        }
        return xka.getQuantityString(i, i2, objArr);
    }

    public static String[] getStringArray(int i) {
        int i2 = 0;
        if (xkb == null) {
            return null;
        }
        d dVar = xkb;
        int indexOfKey = dVar.xjV.indexOfKey(i);
        if (indexOfKey < 0) {
            return null;
        }
        String[] strArr;
        int length = indexOfKey < dVar.xjV.size() + -1 ? ((a) dVar.xjV.valueAt(indexOfKey + 1)).xjW[0] : dVar.kCs.length;
        a aVar = (a) dVar.xjV.valueAt(indexOfKey);
        indexOfKey = aVar.xjW.length;
        if (indexOfKey > 0) {
            String[] strArr2 = new String[indexOfKey];
            while (i2 < indexOfKey) {
                if (i2 < indexOfKey - 1) {
                    strArr2[i2] = new String(dVar.kCs, aVar.xjW[i2], aVar.xjW[i2 + 1] - aVar.xjW[i2]);
                } else {
                    strArr2[i2] = new String(dVar.kCs, aVar.xjW[i2], length - aVar.xjW[i2]);
                }
                i2++;
            }
            strArr = strArr2;
        } else {
            strArr = null;
        }
        return strArr;
    }

    private static int a(DataInputStream dataInputStream, SparseArray<a> sparseArray, int i, int i2) {
        try {
            byte readByte = dataInputStream.readByte();
            if (readByte < (byte) 0) {
                return 0;
            }
            int[] iArr = new int[readByte];
            int[] iArr2 = new int[readByte];
            int i3 = 0;
            for (byte b = (byte) 0; b < readByte; b++) {
                iArr[b] = dataInputStream.readByte();
                iArr2[b] = i2;
                short readShort = dataInputStream.readShort();
                i3 += readShort;
                i2 += readShort;
            }
            sparseArray.append(i, new a(i, iArr, iArr2));
            return i3;
        } catch (Throwable e) {
            x.e("MicroMsg.language.StringResouces", "exception:%s", bi.i(e));
            return 0;
        }
    }

    public static CharSequence e(int i, CharSequence charSequence) {
        if (charSequence == null || xkf == null || xkf.isEmpty() || !xkf.contains(Integer.valueOf(i))) {
            return charSequence;
        }
        return a.u(charSequence.toString(), g.s("lucky".getBytes()).substring(0, 16));
    }
}
