package com.tencent.mm.plugin.emoji.model;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.text.TextUtils;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.ap.a.c.i;
import com.tencent.mm.ap.o;
import com.tencent.mm.modelcontrol.b;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.emoji.e.f;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.c.acc;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class EmojiLogic {
    public static final String lDc = File.separator;

    public static native boolean extractForeground(int[] iArr, int i, int i2);

    public static native boolean gifToMMAni(byte[] bArr, PByteArray pByteArray, int i);

    public static int al(byte[] bArr) {
        if (bArr == null || bArr.length < 4) {
            return EmojiInfo.xID;
        }
        if (bArr[1] == (byte) 80 && bArr[2] == (byte) 78 && bArr[3] == (byte) 71) {
            return EmojiInfo.xIO;
        }
        if (bArr[0] == (byte) 71 && bArr[1] == (byte) 73 && bArr[2] == (byte) 70) {
            return EmojiInfo.xIP;
        }
        if (bArr[6] == (byte) 74 && bArr[7] == (byte) 70 && bArr[8] == (byte) 73 && bArr[9] == (byte) 70) {
            return EmojiInfo.xIQ;
        }
        return EmojiInfo.xID;
    }

    public static String yJ(String str) {
        String str2 = null;
        if (!bi.oN(str)) {
            int bN = e.bN(str);
            if (bN > 0) {
                byte[] d = e.d(str, 0, bN);
                str2 = g.s(d);
                if (!(str2 == null && d == null)) {
                    as.Hm();
                    e.b(c.Fw() + str2, d, d.length);
                    if (p.bq(d)) {
                        i.aCl().lCw.a(str2, "", EmojiInfo.xIH, EmojiInfo.xIP, d.length, "", "");
                    } else {
                        i.aCl().lCw.a(str2, "", EmojiInfo.xIH, EmojiInfo.xIO, d.length, "", "");
                    }
                }
            }
        }
        return str2;
    }

    public static String b(Context context, WXMediaMessage wXMediaMessage, String str) {
        if (wXMediaMessage.getType() != 8) {
            return null;
        }
        WXEmojiObject wXEmojiObject = (WXEmojiObject) wXMediaMessage.mediaObject;
        if (!bi.by(wXEmojiObject.emojiData)) {
            x.d("MicroMsg.emoji.EmojiLogic", " fileData:" + wXEmojiObject.emojiData.length);
            String s = g.s(wXEmojiObject.emojiData);
            a(context, wXMediaMessage.thumbData, s, wXEmojiObject.emojiData, str);
            return s;
        } else if (bi.oN(wXEmojiObject.emojiPath)) {
            return null;
        } else {
            int bN = e.bN(wXEmojiObject.emojiPath);
            if (bN <= 0) {
                return null;
            }
            byte[] d = e.d(wXEmojiObject.emojiPath, 0, bN);
            String s2 = g.s(d);
            a(context, wXMediaMessage.thumbData, s2, d, str);
            return s2;
        }
    }

    private static void a(Context context, byte[] bArr, String str, byte[] bArr2, String str2) {
        if (str != null || bArr2 != null) {
            EmojiInfo a;
            as.Hm();
            String Fw = c.Fw();
            e.b(Fw + str, bArr2, bArr2.length);
            if (p.bq(bArr2)) {
                a = i.aCl().lCw.a(str, "", EmojiInfo.xIH, EmojiInfo.xIR, bArr2.length, str2, "");
            } else {
                a = i.aCl().lCw.a(str, "", EmojiInfo.xIH, EmojiInfo.xIS, bArr2.length, str2, "");
            }
            a(context, bArr, str, Fw, a);
        }
    }

    public static void a(Context context, byte[] bArr, String str, String str2, EmojiInfo emojiInfo) {
        Bitmap fo;
        Bitmap bitmap;
        if (bArr == null) {
            String str3 = "MicroMsg.emoji.EmojiLogic";
            String str4 = "insertEmoji: thumb is null, emojiInfo is null ? %B";
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(emojiInfo == null);
            x.d(str3, str4, objArr);
            if (emojiInfo != null) {
                fo = emojiInfo.fo(context);
            } else {
                return;
            }
        }
        fo = d.bn(bArr);
        if (fo == null || (fo.getWidth() <= 300 && fo.getHeight() <= 300)) {
            bitmap = fo;
        } else {
            int width = fo.getWidth();
            int height = fo.getHeight();
            x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg width:%d height:%d", Integer.valueOf(width), Integer.valueOf(height));
            if (width > height) {
                float f = ((float) height) / ((float) width);
                height = 300;
                width = (int) (f * 300.0f);
            } else {
                float f2 = ((float) width) / ((float) height);
                width = 300;
                height = (int) (f2 * 300.0f);
            }
            x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg new width:%d new height:%d", Integer.valueOf(height), Integer.valueOf(width));
            bitmap = d.a(fo, width, height, false, true);
        }
        if (bitmap != null) {
            try {
                if (bitmap.getByteCount() > WXMediaMessage.THUMB_LENGTH_LIMIT) {
                    d.a(bitmap, 80, CompressFormat.JPEG, str2 + str + "_thumb", true);
                    x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is over size. save as jpg. size :%d", Integer.valueOf(bitmap.getByteCount()));
                    return;
                }
                d.a(bitmap, 100, CompressFormat.PNG, str2 + str + "_thumb", true);
                x.i("MicroMsg.emoji.EmojiLogic", "cpan app msg bitmap is in normal size. sav as png. size :%d", Integer.valueOf(bitmap.getByteCount()));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.emoji.EmojiLogic", e, "insertEmoji Error", new Object[0]);
            }
        }
    }

    public static EmojiInfo a(String str, String str2, i iVar) {
        as.Hm();
        if (c.isSDCardAvailable()) {
            EmojiInfo a = a(str, 4, str2, true);
            if (a == null) {
                o.PG().a(str2, null, f.b(str, str2, new Object[0]), iVar);
                x.i("MicroMsg.emoji.EmojiLogic", "[cpan] get emoji info, try to load image:%s", str2);
            }
            return a;
        } else if (ad.getContext() == null || ad.getContext().getResources() == null) {
            return null;
        } else {
            new EmojiInfo().field_type = EmojiInfo.xIO;
            return null;
        }
    }

    public static EmojiInfo a(String str, int i, String str2, boolean z) {
        int i2 = 0;
        if (TextUtils.isEmpty(str)) {
            x.d("MicroMsg.emoji.EmojiLogic", "getIcon : productId is null.");
            return null;
        }
        int i3;
        EmojiInfo emojiInfo = new EmojiInfo();
        if (z) {
            as.Hm();
            String H = H(c.Fw(), str, str2);
            if (e.bO(H)) {
                File file = new File(H);
                if (file.exists()) {
                    if (file.length() < 1) {
                        file.delete();
                    } else {
                        emojiInfo.field_type = al(e.d(H, 0, 10));
                        i2 = 1;
                    }
                }
            }
            if (i2 == 0) {
                x.d("MicroMsg.emoji.EmojiLogic", "banner icon does not exist. icon path :" + H + "...., icon type:" + i);
                return null;
            }
        }
        as.Hm();
        if (!e.bO(H(c.Fw(), str, str2))) {
            x.d("MicroMsg.emoji.EmojiLogic", "icon file no exist. path:%s type:%d, url:%s", H(c.Fw(), str, str2), Integer.valueOf(i), str2);
            return null;
        }
        emojiInfo.field_md5 = cs(str, str2);
        switch (i) {
            case 2:
                i3 = 82;
                break;
            case 4:
                i3 = 83;
                break;
            case 8:
                i3 = 84;
                break;
            default:
                i3 = EmojiInfo.xIJ;
                break;
        }
        emojiInfo.field_catalog = i3;
        emojiInfo.field_groupId = str;
        emojiInfo.field_temp = 1;
        return emojiInfo;
    }

    public static boolean a(String str, String str2, EmojiGroupInfo emojiGroupInfo) {
        Exception e;
        OutputStream outputStream;
        Throwable th;
        OutputStream outputStream2;
        String str3 = com.tencent.mm.compatible.util.e.gJd + str;
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        String stringBuilder2 = stringBuilder.append(c.Fw()).append(str).toString();
        InputStream inputStream = null;
        ZipFile zipFile = null;
        HashMap hashMap = new HashMap();
        Object arrayList = new ArrayList();
        ZipFile zipFile2;
        OutputStream outputStream3;
        InputStream inputStream2;
        try {
            zipFile2 = new ZipFile(str3);
            try {
                ZipEntry zipEntry;
                InputStream inputStream3;
                OutputStream outputStream4;
                byte[] bArr;
                int read;
                EmojiInfo YB;
                Enumeration entries = zipFile2.entries();
                int i = 0;
                outputStream3 = null;
                inputStream2 = null;
                while (entries.hasMoreElements()) {
                    try {
                        zipEntry = (ZipEntry) entries.nextElement();
                        if (zipEntry.isDirectory()) {
                            inputStream3 = inputStream2;
                            outputStream4 = outputStream3;
                        } else {
                            inputStream = zipFile2.getInputStream(zipEntry);
                            try {
                                String toLowerCase = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                                File file = new File(stringBuilder2 + "/" + zipEntry.getName());
                                if (file.isFile()) {
                                    file.delete();
                                }
                                file.getParentFile().mkdirs();
                                if (!toLowerCase.startsWith(".") && (toLowerCase.endsWith(".gif") || toLowerCase.endsWith(".png"))) {
                                    if (zipEntry.getName().toLowerCase().contains("/large/")) {
                                        outputStream4 = new FileOutputStream(stringBuilder2 + File.separator + toLowerCase);
                                        try {
                                            int i2;
                                            bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                            while (true) {
                                                read = inputStream.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                outputStream4.write(bArr, 0, read);
                                            }
                                            outputStream4.close();
                                            outputStream3 = null;
                                            String bV = g.bV(stringBuilder2 + File.separator + toLowerCase);
                                            x.i("MicroMsg.emoji.EmojiLogic", "md5:%s index:%d", bV, Integer.valueOf(i));
                                            File file2 = new File(stringBuilder2 + File.separator + toLowerCase);
                                            File file3 = new File(stringBuilder2 + File.separator + bV);
                                            if (p.Vw(file2.getPath())) {
                                                i2 = EmojiInfo.xIP;
                                            } else {
                                                i2 = EmojiInfo.xIO;
                                            }
                                            YB = i.aCl().lCw.YB(bV);
                                            if (YB == null) {
                                                YB = new EmojiInfo();
                                                YB.field_catalog = 0;
                                            }
                                            YB.field_name = toLowerCase;
                                            YB.field_md5 = bV;
                                            YB.field_size = (int) file2.length();
                                            YB.field_type = i2;
                                            YB.field_groupId = str;
                                            YB.field_idx = i;
                                            arrayList.add(YB);
                                            file2.renameTo(file3);
                                            hashMap.put(toLowerCase.substring(0, toLowerCase.length() - 4), bV);
                                            outputStream4 = null;
                                            inputStream3 = inputStream;
                                        } catch (Exception e2) {
                                            e = e2;
                                            zipFile = zipFile2;
                                            outputStream = outputStream4;
                                            inputStream2 = inputStream;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            outputStream3 = outputStream4;
                                        }
                                    } else if (toLowerCase.startsWith("icon")) {
                                        outputStream4 = new FileOutputStream(stringBuilder2 + File.separator + (g.s(str.getBytes()) + "_panel_enable"));
                                        try {
                                            bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                            while (true) {
                                                read = inputStream.read(bArr);
                                                if (read <= 0) {
                                                    break;
                                                }
                                                outputStream4.write(bArr, 0, read);
                                            }
                                            outputStream4.close();
                                            outputStream4 = null;
                                            inputStream3 = inputStream;
                                        } catch (Exception e3) {
                                            e = e3;
                                            zipFile = zipFile2;
                                            outputStream = outputStream4;
                                            inputStream2 = inputStream;
                                        } catch (Throwable th3) {
                                            th = th3;
                                            outputStream3 = outputStream4;
                                        }
                                    }
                                }
                                outputStream4 = outputStream3;
                                inputStream3 = inputStream;
                            } catch (Exception e4) {
                                e = e4;
                                inputStream2 = inputStream;
                                outputStream2 = outputStream3;
                                zipFile = zipFile2;
                                outputStream = outputStream2;
                            } catch (Throwable th4) {
                                th = th4;
                            }
                        }
                        if (inputStream3 != null) {
                            try {
                                inputStream3.close();
                                inputStream3 = null;
                            } catch (Exception e5) {
                                Exception exception = e5;
                                zipFile = zipFile2;
                                outputStream = outputStream4;
                                inputStream2 = inputStream3;
                                e = exception;
                            } catch (Throwable th5) {
                                inputStream = inputStream3;
                                th = th5;
                                outputStream3 = outputStream4;
                            }
                        }
                        i++;
                        outputStream3 = outputStream4;
                        inputStream2 = inputStream3;
                    } catch (Exception e6) {
                        e = e6;
                        ZipFile zipFile3 = zipFile2;
                        outputStream = outputStream3;
                        zipFile = zipFile3;
                    } catch (Throwable th6) {
                        th = th6;
                        inputStream = inputStream2;
                    }
                }
                Enumeration entries2 = zipFile2.entries();
                while (entries2.hasMoreElements()) {
                    zipEntry = (ZipEntry) entries2.nextElement();
                    if (zipEntry.isDirectory()) {
                        inputStream3 = inputStream2;
                        outputStream4 = outputStream3;
                    } else {
                        inputStream = zipFile2.getInputStream(zipEntry);
                        String toLowerCase2 = zipEntry.getName().substring(zipEntry.getName().lastIndexOf("/") + 1).toLowerCase();
                        File file4 = new File(stringBuilder2 + "/" + zipEntry.getName());
                        if (file4.isFile()) {
                            file4.delete();
                        }
                        file4.getParentFile().mkdirs();
                        if (zipEntry.getName().toLowerCase().contains("/thumb/")) {
                            int lastIndexOf = toLowerCase2.lastIndexOf(".") + 1;
                            String str4 = toLowerCase2.substring(0, lastIndexOf - 1) + "_cover." + toLowerCase2.substring(lastIndexOf);
                            outputStream4 = new FileOutputStream(stringBuilder2 + File.separator + str4);
                            try {
                                bArr = new byte[WXMediaMessage.MINI_PROGRAM__THUMB_LENGHT];
                                while (true) {
                                    read = inputStream.read(bArr);
                                    if (read <= 0) {
                                        break;
                                    }
                                    outputStream4.write(bArr, 0, read);
                                }
                                outputStream4.close();
                                outputStream3 = null;
                                String substring = str4.substring(0, str4.lastIndexOf("_cover."));
                                if (hashMap.containsKey(substring)) {
                                    substring = (String) hashMap.get(substring);
                                    new File(stringBuilder2 + File.separator + str4).renameTo(new File(stringBuilder2 + File.separator + substring + "_cover"));
                                    hashMap.put(str4, substring);
                                }
                                outputStream4 = null;
                                inputStream3 = inputStream;
                            } catch (Exception e7) {
                                e = e7;
                                zipFile = zipFile2;
                                outputStream = outputStream4;
                                inputStream2 = inputStream;
                            } catch (Throwable th7) {
                                th = th7;
                                outputStream3 = outputStream4;
                            }
                        } else {
                            outputStream4 = outputStream3;
                            inputStream3 = inputStream;
                        }
                    }
                    if (inputStream3 != null) {
                        inputStream3.close();
                        inputStream3 = null;
                    }
                    outputStream3 = outputStream4;
                    inputStream2 = inputStream3;
                }
                hashMap.clear();
                if (emojiGroupInfo == null) {
                    emojiGroupInfo = i.aCl().lCx.bg(str, false);
                }
                emojiGroupInfo.field_productID = str;
                if (!bi.oN(str2)) {
                    emojiGroupInfo.field_packName = str2;
                }
                emojiGroupInfo.field_lastUseTime = System.currentTimeMillis();
                emojiGroupInfo.field_status = 7;
                emojiGroupInfo.field_packStatus = 1;
                emojiGroupInfo.field_type = EmojiGroupInfo.xIB;
                emojiGroupInfo.field_recommand = 0;
                emojiGroupInfo.field_sync = 2;
                emojiGroupInfo.field_count = arrayList.size();
                if (i.aCl().lCw.l(arrayList, str)) {
                    boolean c = i.aCl().lCx.c(emojiGroupInfo);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        YB = (EmojiInfo) it.next();
                        YB.field_reserved4 = 0;
                        com.tencent.mm.plugin.emoji.e.e.aBy().c(YB, true);
                    }
                    x.i("MicroMsg.emoji.EmojiLogic", "saveGroupFlag:%b saveEmojiFlag:%b", Boolean.valueOf(c), Boolean.valueOf(r6));
                } else {
                    x.i("MicroMsg.emoji.EmojiLogic", "saveEmojiFlag:%b", Boolean.valueOf(i.aCl().lCw.l(arrayList, str)));
                }
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                zipFile2.close();
                return true;
            } catch (Exception e8) {
                e = e8;
                zipFile = zipFile2;
                outputStream = null;
                inputStream2 = null;
                try {
                    x.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    return false;
                } catch (Throwable th8) {
                    th = th8;
                    inputStream = inputStream2;
                    outputStream2 = outputStream;
                    zipFile2 = zipFile;
                    outputStream3 = outputStream2;
                    if (outputStream3 != null) {
                        outputStream3.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (zipFile2 != null) {
                        zipFile2.close();
                    }
                    throw th;
                }
            } catch (Throwable th9) {
                th = th9;
                outputStream3 = null;
                if (outputStream3 != null) {
                    outputStream3.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                throw th;
            }
        } catch (Exception e9) {
            e = e9;
            outputStream = null;
            inputStream2 = null;
            x.e("MicroMsg.emoji.EmojiLogic", "un zip package fail." + e.getMessage());
            if (outputStream != null) {
                outputStream.close();
            }
            if (inputStream2 != null) {
                inputStream2.close();
            }
            if (zipFile != null) {
                zipFile.close();
            }
            return false;
        } catch (Throwable th10) {
            th = th10;
            zipFile2 = null;
            outputStream3 = null;
            if (outputStream3 != null) {
                outputStream3.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (zipFile2 != null) {
                zipFile2.close();
            }
            throw th;
        }
    }

    public static acc aCb() {
        acc acc = new acc();
        acc.wrF = 1;
        acc.wrH = 1;
        return acc;
    }

    public static String yU(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<productid>" + str + "</productid>");
        stringBuilder.append("</xml>");
        x.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static String i(int i, String str, String str2) {
        if (i == 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<designeruin>" + i + "</designeruin>");
        stringBuilder.append("<designername>" + str + "</designername>");
        stringBuilder.append("<designerrediretcturl>" + str2 + "</designerrediretcturl>");
        stringBuilder.append("</xml>");
        x.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static int yP(String str) {
        int bY;
        Exception e;
        try {
            bY = com.tencent.mm.a.o.bY((String) bj.y(str, "xml").get(".xml.designeruin"));
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", Integer.valueOf(bY));
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getDesignerUINBySnsObjData exception. %s", e.toString());
                return bY;
            }
        } catch (Exception e3) {
            e = e3;
            bY = 0;
        }
        return bY;
    }

    public static String yQ(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bj.y(str, "xml").get(".xml.designername");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "designeruin:%s", str2);
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", e.toString());
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getDesignerNameBySnsObjData exception. %s", e.toString());
            return str2;
        }
        return str2;
    }

    public static String yV(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bj.y(str, "xml").get(".xml.designerrediretcturl");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "designerrediretcturl:%s", str2);
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", e.toString());
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getDesignerRediretctUrlBySnsObjData exception. %s", e.toString());
            return str2;
        }
        return str2;
    }

    public static String yO(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bj.y(str, "xml").get(".xml.productid");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "productId:%s", str2);
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", e.toString());
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getProductIdBySnsObjData exception. %s", e.toString());
            return str2;
        }
        return str2;
    }

    public static String yN(String str) {
        x.d("MicroMsg.emoji.EmojiLogic", "url:%s", str);
        String str2 = "";
        if (TextUtils.isEmpty(str) || !str.startsWith("http://weixin.qq.com/emoticonstore/")) {
            return str2;
        }
        return str.substring(str.lastIndexOf("/") + 1);
    }

    public static String a(int i, String str, String str2, String str3, String str4, int i2) {
        if (i <= 0) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<xml>");
        stringBuilder.append("<tid>" + i + "</tid>");
        stringBuilder.append("<title>" + str + "</title>");
        stringBuilder.append("<desc>" + str2 + "</desc>");
        stringBuilder.append("<iconUrl>" + str3 + "</iconUrl>");
        stringBuilder.append("<secondUrl>" + str4 + "</secondUrl>");
        stringBuilder.append("<pageType>" + i2 + "</pageType>");
        stringBuilder.append("</xml>");
        x.i("MicroMsg.emoji.EmojiLogic", "sns object data:%s", stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static int yW(String str) {
        int Wo;
        Exception e;
        try {
            Wo = bi.Wo((String) bj.y(str, "xml").get(".xml.tid"));
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "tid:%s", Integer.valueOf(Wo));
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTid exception. %s", e.toString());
                return Wo;
            }
        } catch (Exception e3) {
            e = e3;
            Wo = 0;
        }
        return Wo;
    }

    public static String yX(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bj.y(str, "xml").get(".xml.title");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "title:%s", str2);
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", e.toString());
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageTitle exception. %s", e.toString());
            return str2;
        }
        return str2;
    }

    public static String yY(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bj.y(str, "xml").get(".xml.desc");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "desc:%s", str2);
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", e.toString());
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageDesc exception. %s", e.toString());
            return str2;
        }
        return str2;
    }

    public static String yZ(String str) {
        String str2;
        Exception e;
        String str3 = "";
        try {
            str2 = (String) bj.y(str, "xml").get(".xml.iconUrl");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "iconUrl:%s", str2);
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", e.toString());
                return str2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str2 = str3;
            e = exception;
            x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageIconUrl exception. %s", e.toString());
            return str2;
        }
        return str2;
    }

    public static String za(String str) {
        String aD;
        Exception e;
        String str2 = "";
        try {
            aD = bi.aD((String) bj.y(str, "xml").get(".xml.secondUrl"), "");
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "secondUrl:%s", aD);
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageSecondUrl exception. %s", e.toString());
                return aD;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            aD = str2;
            e = exception;
        }
        return aD;
    }

    public static int zb(String str) {
        int Wo;
        Exception e;
        try {
            Wo = bi.Wo((String) bj.y(str, "xml").get(".xml.pageType"));
            try {
                x.d("MicroMsg.emoji.EmojiLogic", "pageType:%s", Integer.valueOf(Wo));
            } catch (Exception e2) {
                e = e2;
                x.e("MicroMsg.emoji.EmojiLogic", "getEmojiPageType exception. %s", e.toString());
                return Wo;
            }
        } catch (Exception e3) {
            e = e3;
            Wo = 0;
        }
        return Wo;
    }

    public static String H(String str, String str2, String str3) {
        if (bi.oN(str2) && bi.oN(str3)) {
            x.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and url are null.");
            return null;
        }
        String cs = cs(str2, str3);
        if (bi.oN(cs)) {
            return null;
        }
        if (bi.oN(str2)) {
            return str + cs;
        }
        return str + str2 + lDc + cs;
    }

    public static String I(String str, String str2, String str3) {
        String str4 = null;
        if (bi.oN(str2) && bi.oN(str3)) {
            x.w("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path failed. productid and md5 are null.");
        } else {
            if (!bi.oN(str3)) {
                if (bi.oN(str2)) {
                    str4 = str + str3;
                } else {
                    str4 = str + str2 + lDc + str3;
                }
            }
            x.d("MicroMsg.emoji.EmojiLogic", "[cpan] get icon path. productid:%s md5:%s path:%s", str2, str3, str4);
        }
        return str4;
    }

    private static String cs(String str, String str2) {
        if (bi.oN(str) && bi.oN(str2)) {
            x.e("MicroMsg.emoji.EmojiLogic", "[cpan] product id and url are null.");
            return null;
        } else if (bi.oN(str2)) {
            return g.s(str.getBytes());
        } else {
            return g.s(str2.getBytes());
        }
    }

    public static boolean zc(String str) {
        if (!bi.oN(str)) {
            try {
                if (b.kN(str)) {
                    x.d("MicroMsg.emoji.EmojiLogic", "In Not Auto Download Time Range. timeRange:%s", str);
                    return true;
                }
            } catch (Throwable e) {
                x.e("MicroMsg.emoji.EmojiLogic", "isInNotAutoDownloadTimeRange :%s", bi.i(e));
            }
        }
        return false;
    }
}
