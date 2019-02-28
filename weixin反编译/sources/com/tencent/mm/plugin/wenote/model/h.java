package com.tencent.mm.plugin.wenote.model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bh.a;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.f.a.kq;
import com.tencent.mm.f.a.qp;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.wenote.b.c;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public final class h {
    private static Map<String, String> tXA;
    private static String[] tXB = new String[]{"<div>", "<div/>", "<object", "<br", "</"};
    private static String[] tXC = new String[]{"＜div>", "＜div/>", "＜object", "＜br", "＜/"};
    private static LinkedList<vl> tXD = null;
    private static String tXE = "";
    public static String tXq = (a.Vn() + "/fav_fileicon_video.png");
    public static String tXr = (a.Vn() + "/fav_fileicon_music.png");
    public static String tXs = (a.Vn() + "/fav_list_img_default.png");
    public static String tXt = (a.Vn() + "/fav_fileicon_zip.png");
    public static String tXu = (a.Vn() + "/fav_fileicon_word.png");
    public static String tXv = (a.Vn() + "/fav_fileicon_ppt.png");
    public static String tXw = (a.Vn() + "/fav_fileicon_xls.png");
    public static String tXx = (a.Vn() + "/fav_fileicon_txt.png");
    public static String tXy = (a.Vn() + "/fav_fileicon_pdf.png");
    public static String tXz = (a.Vn() + "/fav_fileicon_unknow.png");

    private static void ah(JSONObject jSONObject) {
        b kqVar = new kq();
        kqVar.fCS.type = 6;
        kqVar.fCS.fCU = jSONObject.toString();
        kqVar.fCS.fCJ = "";
        com.tencent.mm.sdk.b.a.xmy.m(kqVar);
    }

    public static void m(Context context, String str, int i) {
        if (!bi.oN(str) && new File(str).exists()) {
            JSONObject jSONObject = new JSONObject();
            try {
                int bw = (int) f.bw((long) i);
                jSONObject.put(Columns.TYPE, 4);
                jSONObject.put("downloaded", true);
                jSONObject.put("length", bw);
                jSONObject.put("lengthStr", f.s(context, bw));
                jSONObject.put("iconPath", a.Vn() + "/fav_fileicon_recording.png");
                ah(jSONObject);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
    }

    public static void Rp(String str) {
        if (!bi.oN(str)) {
            File file = new File(str);
            if (file.exists()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(Columns.TYPE, 5);
                    jSONObject.put("downloaded", true);
                    jSONObject.put("title", file.getName());
                    jSONObject.put("content", f.ah((float) e.bN(str)));
                    jSONObject.put("iconPath", Rr(e.bQ(str)));
                    jSONObject.put("localPath", str);
                    ah(jSONObject);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                }
            }
        }
    }

    public static void Rq(String str) {
        x.i("MicroMsg.WNNoteLogic", "insert location run");
        JSONObject jSONObject = new JSONObject(str);
        x.i("MicroMsg.WNNoteLogic", "insert location run :after invoke");
        Object obj = a.Vp() + "/" + g.s((new com.tencent.mm.pluginsdk.location.b(-1, (float) jSONObject.getDouble("lat"), (float) jSONObject.getDouble("lng"), jSONObject.getInt("scale"), 1).toString()).getBytes()) + ".png";
        x.i("MicroMsg.WNNoteLogic", "insert location run :filepath:%s", obj);
        if (FileOp.bO(obj)) {
            x.i("MicroMsg.WNNoteLogic", "insert location run :filepath:is exsit");
        }
        if (e.bO(obj)) {
            x.i("MicroMsg.WNNoteLogic", "fileExist suc, use getimagelocalpath");
        } else {
            x.e("MicroMsg.WNNoteLogic", "Temp file fileExist fail:%s ,use default file", obj);
            obj = d.tXc;
        }
        jSONObject.put("localPath", obj);
        ah(jSONObject);
    }

    public static void aa(ArrayList<String> arrayList) {
        JSONObject jSONObject = new JSONObject();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            try {
                jSONObject.put(Columns.TYPE, 2);
                jSONObject.put("downloaded", true);
                String fh = c.fh(str, "");
                str = c.fi(str, "");
                if (!bi.oN(fh) && !bi.oN(str)) {
                    jSONObject.put("bigImagePath", fh);
                    jSONObject.put("localPath", str);
                    ah(jSONObject);
                } else {
                    return;
                }
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
    }

    public static void aQ(Context context, String str) {
        int i;
        JSONObject jSONObject = new JSONObject();
        if (!bi.oN(str)) {
            i = (int) k.bWD().duration;
            int bw = (int) f.bw((long) i);
            try {
                jSONObject.put("downloaded", true);
                jSONObject.put("length", i);
                jSONObject.put("lengthStr", f.s(context, bw));
                jSONObject.put("iconPath", a.Vn() + "/fav_fileicon_recording.png");
                jSONObject.put("localPath", str);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
            }
        }
        try {
            jSONObject.put(Columns.TYPE, 4);
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.WNNoteLogic", e2, "", new Object[0]);
        }
        i = k.bWD().tXM;
        b kqVar = new kq();
        kqVar.fCS.type = 6;
        kqVar.fCS.fCU = jSONObject.toString();
        kqVar.fCS.fCJ = Integer.toString(i);
        com.tencent.mm.sdk.b.a.xmy.m(kqVar);
    }

    static {
        tXA = new HashMap();
        Map hashMap = new HashMap();
        tXA = hashMap;
        hashMap.put("avi", tXq);
        tXA.put("m4v", tXq);
        tXA.put("vob", tXq);
        tXA.put("mpeg", tXq);
        tXA.put("mpe", tXq);
        tXA.put("asx", tXq);
        tXA.put("asf", tXq);
        tXA.put("f4v", tXq);
        tXA.put("flv", tXq);
        tXA.put("mkv", tXq);
        tXA.put("wmv", tXq);
        tXA.put("wm", tXq);
        tXA.put("3gp", tXq);
        tXA.put("mp4", tXq);
        tXA.put("rmvb", tXq);
        tXA.put("rm", tXq);
        tXA.put("ra", tXq);
        tXA.put("ram", tXq);
        tXA.put("mp3pro", tXr);
        tXA.put("vqf", tXr);
        tXA.put("cd", tXr);
        tXA.put("md", tXr);
        tXA.put("mod", tXr);
        tXA.put("vorbis", tXr);
        tXA.put("au", tXr);
        tXA.put("amr", tXr);
        tXA.put("silk", tXr);
        tXA.put("wma", tXr);
        tXA.put("mmf", tXr);
        tXA.put("mid", tXr);
        tXA.put("midi", tXr);
        tXA.put("mp3", tXr);
        tXA.put("aac", tXr);
        tXA.put("ape", tXr);
        tXA.put("aiff", tXr);
        tXA.put("aif", tXr);
        tXA.put("jfif", tXs);
        tXA.put("tiff", tXs);
        tXA.put("tif", tXs);
        tXA.put("jpe", tXs);
        tXA.put("dib", tXs);
        tXA.put("jpeg", tXs);
        tXA.put("jpg", tXs);
        tXA.put("png", tXs);
        tXA.put("bmp", tXs);
        tXA.put("gif", tXs);
        tXA.put("rar", tXt);
        tXA.put("zip", tXt);
        tXA.put("7z", tXt);
        tXA.put("iso", tXt);
        tXA.put("cab", tXt);
        tXA.put("doc", tXu);
        tXA.put("docx", tXu);
        tXA.put("ppt", tXv);
        tXA.put("pptx", tXv);
        tXA.put("xls", tXw);
        tXA.put("xlsx", tXw);
        tXA.put("txt", tXx);
        tXA.put("rtf", tXx);
        tXA.put("pdf", tXy);
        tXA.put("unknown", tXz);
    }

    public static String Rr(String str) {
        String str2 = (String) tXA.get(str);
        if (str2 == null) {
            return (String) tXA.get("unknown");
        }
        return str2;
    }

    public static ArrayList<com.tencent.mm.plugin.wenote.model.a.b> a(Object obj, List<String> list, boolean z) {
        if (obj == null) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        Collection arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.wenote.model.a.b bVar = (com.tencent.mm.plugin.wenote.model.a.b) it.next();
            if (bVar.getType() != 1) {
                arrayList2.add(bVar);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            if (str.trim().equals("<ThisisNoteNodeHrObj>")) {
                com.tencent.mm.plugin.wenote.model.a.g gVar = new com.tencent.mm.plugin.wenote.model.a.g();
                gVar.tXR = false;
                gVar.tXX = false;
                arrayList2.add(i, gVar);
            } else if (!str.trim().equals("<ThisisNoteNodeObj>")) {
                com.tencent.mm.plugin.wenote.model.a.h hVar = new com.tencent.mm.plugin.wenote.model.a.h();
                hVar.content = str;
                hVar.tXR = false;
                hVar.tXX = false;
                hVar.mBr = f.Rn(hVar.toString());
                if (i < arrayList2.size()) {
                    arrayList2.add(i, hVar);
                } else {
                    arrayList2.add(hVar);
                }
            }
        }
        if (z) {
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
        return arrayList2;
    }

    public static void BD(int i) {
        LinkedList linkedList;
        tXD = null;
        tXE = "";
        String bXj = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().bXj();
        tXE = bXj;
        LinkedList linkedList2 = new LinkedList();
        vn Ru = com.tencent.mm.plugin.wenote.model.nativenote.manager.c.bXc().Ru(bXj);
        if (Ru == null || Ru.wlY.size() <= 1) {
            linkedList = null;
        } else {
            Iterator it = Ru.wlY.iterator();
            while (it.hasNext()) {
                uz uzVar = (uz) it.next();
                String o = f.o(uzVar);
                if (!bi.oN(o) && uzVar.bjS == 2 && e.bO(o)) {
                    vl vlVar = new vl();
                    vlVar.wgP = uzVar.wke;
                    vlVar.wgS = uzVar.wjP;
                    vlVar.wlS = uzVar.wjN;
                    linkedList2.add(vlVar);
                }
            }
            linkedList = linkedList2;
        }
        tXD = linkedList;
        as.CN().a(new b(i, 1, tXE, tXD, null), 0);
    }

    public static void a(Context context, Bitmap bitmap, boolean z) {
        com.tencent.mm.plugin.report.service.g gVar;
        Object[] objArr;
        String oF = d.oF("jpg");
        if (bitmap != null) {
            try {
                com.tencent.mm.sdk.platformtools.d.a(bitmap, 100, CompressFormat.JPEG, oF, true);
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.WNNoteLogic", e, "", new Object[0]);
                x.e("MicroMsg.WNNoteLogic", "save image fail, saveBitmapToImage is null");
                gVar = com.tencent.mm.plugin.report.service.g.pWK;
                objArr = new Object[5];
                objArr[0] = Integer.valueOf(0);
                objArr[1] = Integer.valueOf(0);
                objArr[2] = Integer.valueOf(0);
                objArr[3] = Integer.valueOf(3);
                objArr[4] = Integer.valueOf(z ? 1 : 0);
                gVar.h(14811, objArr);
                oF = "";
            }
        } else {
            x.e("MicroMsg.WNNoteLogic", "save image fail, bigBitmap is null");
            gVar = com.tencent.mm.plugin.report.service.g.pWK;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(0);
            objArr[1] = Integer.valueOf(0);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(1);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            gVar.h(14811, objArr);
            oF = "";
        }
        if (!bi.oN(oF)) {
            d.b(oF, context);
        }
        File file = new File(oF);
        if (file.exists()) {
            long length = file.length() / 1024;
            int i = 0;
            int i2 = 0;
            if (bitmap != null) {
                i = bitmap.getWidth();
                i2 = bitmap.getHeight();
                bitmap.recycle();
            }
            int i3 = i2;
            int i4 = i;
            vl vlVar = new vl();
            vlVar.wgP = g.bV(oF);
            as.CN().a(new b(0, 2, tXE, tXD, vlVar), 0);
            gVar = com.tencent.mm.plugin.report.service.g.pWK;
            objArr = new Object[5];
            objArr[0] = Integer.valueOf(i4);
            objArr[1] = Integer.valueOf(i3);
            objArr[2] = Long.valueOf(length);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = Integer.valueOf(z ? 1 : 0);
            gVar.h(14811, objArr);
        }
    }

    public static void aR(Context context, String str) {
        if (bi.oN(str)) {
            x.e("MicroMsg.WNNoteLogic", "dofavnotelink , but localid is null or nil");
            return;
        }
        b cgVar = new cg();
        b qpVar = new qp();
        qpVar.fIX.fJa = str;
        qpVar.fIX.fJb = cgVar;
        qpVar.fIX.url = "";
        com.tencent.mm.sdk.b.a.xmy.m(qpVar);
        if (qpVar.fIY.fqR) {
            cgVar.frk.activity = (Activity) context;
            cgVar.frk.frr = 28;
            com.tencent.mm.sdk.b.a.xmy.m(cgVar);
            return;
        }
        if (cgVar.frk.frq == 0) {
            cgVar.frk.frq = R.l.efC;
        }
        com.tencent.mm.ui.base.h.h(context, cgVar.frk.frq, 0);
    }
}
