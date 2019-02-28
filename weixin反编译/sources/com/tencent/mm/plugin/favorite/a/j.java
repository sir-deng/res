package com.tencent.mm.plugin.favorite.a;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Looper;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.a.g;
import com.tencent.mm.bh.a;
import com.tencent.mm.bl.d;
import com.tencent.mm.f.a.fw;
import com.tencent.mm.f.a.kp;
import com.tencent.mm.f.a.nt;
import com.tencent.mm.f.b.ag;
import com.tencent.mm.modelvideo.t;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.pluginsdk.ui.tools.k;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.bj;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.m;
import com.tencent.mm.y.q;
import com.tencent.mm.y.s;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class j {
    private static long mwa = 0;
    public static List<Integer> mwb = new LinkedList();
    private static HashMap<Long, ArrayList<String>> mwc = new HashMap();

    public static long b(f fVar) {
        return b.b(fVar);
    }

    public static String aJk() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(c.FJ()).append("favorite/").toString();
    }

    public static String aJl() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(c.FJ()).append("favorite/web/").toString();
    }

    public static String aJm() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(c.FJ()).append("favorite/voice/").toString();
    }

    public static String aJn() {
        StringBuilder stringBuilder = new StringBuilder();
        as.Hm();
        return stringBuilder.append(c.FJ()).append("favorite/music/").toString();
    }

    public static uz a(f fVar, String str) {
        if (bi.oN(str) || fVar == null || fVar.field_favProto.wlY.size() == 0) {
            return null;
        }
        Iterator it = fVar.field_favProto.wlY.iterator();
        while (it.hasNext()) {
            uz uzVar = (uz) it.next();
            if (uzVar.mBr.equals(str)) {
                return uzVar;
            }
        }
        return null;
    }

    public static List<f> b(long j, int i, Set<Integer> set, n nVar) {
        if (j == 0) {
            return h.getFavItemInfoStorage().a(i, 20, (Set) set, nVar);
        }
        return h.getFavItemInfoStorage().a(j, i, (Set) set, nVar);
    }

    public static long s(long j, int i) {
        x.i("MicroMsg.FavoriteLogic", "tryStartBatchGet...");
        long g = h.getFavItemInfoStorage().g(j, 20, i);
        long f = h.getFavItemInfoStorage().f(j, 20, i);
        x.v("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", Long.valueOf(g), Long.valueOf(f), Long.valueOf(j));
        if (g == 0) {
            return f;
        }
        LinkedList r = h.getFavItemInfoStorage().r(g, i);
        if (r.size() > 0) {
            x.i("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, batchGetTime:%d, itemTiem:%d, updateTime:%d", Long.valueOf(g), Long.valueOf(f), Long.valueOf(j));
            x.i("MicroMsg.FavoriteLogic", "klem, tryStartBatchGet, need batch get idList size:%d", Integer.valueOf(r.size()));
            if (!as.CN().a(new n(r), 0)) {
                x.w("MicroMsg.FavoriteLogic", "do scene BatchGetFav fail");
                n.aJA();
            }
        }
        if (f == 0) {
            return g;
        }
        return g < f ? g : f;
    }

    public static void startSync() {
        as.CN().a(new p(), 0);
    }

    public static String AF(String str) {
        if (bi.oN(str)) {
            return null;
        }
        File file = new File(aJl() + g.s(str.getBytes()));
        if (file.exists()) {
            return file.getAbsolutePath();
        }
        return null;
    }

    public static boolean e(uz uzVar) {
        return new File(h(uzVar)).exists();
    }

    public static boolean f(uz uzVar) {
        return p.Vw(h(uzVar));
    }

    public static boolean aJo() {
        return n.aJB() > 0;
    }

    public static void n(f fVar) {
        if (fVar.aIt()) {
            switch (fVar.field_itemStatus) {
                case 3:
                    fVar.field_itemStatus = 1;
                    h.getFavItemInfoStorage().a(fVar, "localId");
                    h.aIV().run();
                    return;
                case 6:
                    if (h.aIZ().cX(fVar.field_localId).size() == 0) {
                        fVar.field_itemStatus = 9;
                        h.getFavItemInfoStorage().a(fVar, "localId");
                        as.CN().a(new l(fVar), 0);
                        return;
                    }
                    fVar.field_itemStatus = 4;
                    h.aIZ().d(fVar);
                    h.getFavItemInfoStorage().a(fVar, "localId");
                    for (com.tencent.mm.plugin.fav.a.c cVar : h.aIZ().cX(fVar.field_localId)) {
                        x.i("MicroMsg.FavoriteLogic", "force upload favItem[last failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), cVar.field_dataId, Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen));
                        h.aIY().AM(cVar.field_dataId);
                    }
                    h.aIY().run();
                    return;
                case 11:
                    fVar.field_itemStatus = 9;
                    h.getFavItemInfoStorage().a(fVar, "localId");
                    h.aIU().run();
                    return;
                case 14:
                    h.getFavItemInfoStorage().t(12, fVar.field_localId);
                    h.aIU().run();
                    return;
                case 16:
                    h.getFavItemInfoStorage().t(15, fVar.field_localId);
                    h.aIZ().d(fVar);
                    for (com.tencent.mm.plugin.fav.a.c cVar2 : h.aIZ().cX(fVar.field_localId)) {
                        x.i("MicroMsg.FavoriteLogic", "force upload favItem[last mod failed], favid:%d localId:%d, dataId:%s, dataType:%d totalLength %d", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), cVar2.field_dataId, Integer.valueOf(cVar2.field_dataType), Integer.valueOf(cVar2.field_totalLen));
                        h.aIY().AM(cVar2.field_dataId);
                    }
                    h.aIY().run();
                    return;
                case 18:
                    h.getFavItemInfoStorage().t(17, fVar.field_localId);
                    h.aIW().run();
                    return;
                default:
                    return;
            }
        }
        x.f("MicroMsg.FavoriteLogic", "restartItemUpload status not upload failed!");
    }

    public static void o(f fVar) {
        if (fVar != null) {
            if (fVar.field_itemStatus == 8 || fVar.field_itemStatus == 10) {
                fVar.field_itemStatus = 7;
                List<uz> list = fVar.field_favProto.wlY;
                if (list.size() != 0) {
                    for (uz uzVar : list) {
                        a(fVar, uzVar, true);
                        b(fVar, uzVar, true);
                    }
                    return;
                }
                return;
            }
            x.e("MicroMsg.FavoriteLogic", "status not download failed or done!");
        }
    }

    public static void a(f fVar, uz uzVar, boolean z) {
        if (fVar != null && !bi.oN(uzVar.mBr)) {
            x.i("MicroMsg.FavoriteLogic", "restart cdndata download, favId %d, favLocalId %d, dataId %s", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), uzVar.mBr);
            com.tencent.mm.plugin.fav.a.c Ay = h.aIZ().Ay(uzVar.mBr);
            if (Ay != null && Ay.field_status == 3) {
                h.aIZ().b(Ay, "dataId");
                Ay = null;
            }
            if (Ay != null && (bi.oN(Ay.field_cdnUrl) || bi.oN(Ay.field_cdnKey) || bi.oN(Ay.field_dataId) || !Ay.field_cdnUrl.equals(uzVar.wjN) || !Ay.field_cdnKey.equals(uzVar.wjP) || !Ay.field_dataId.equals(uzVar.mBr))) {
                h.aIZ().b(Ay, "dataId");
                Ay = null;
            }
            if (Ay == null || Ay.field_type != 1) {
                File file = new File(h(uzVar));
                if (!bi.oN(uzVar.wjP) && !bi.oN(uzVar.wjN) && !file.exists()) {
                    x.i("MicroMsg.FavoriteLogic", "klem big img not exist, start download.");
                    long currentTimeMillis = System.currentTimeMillis();
                    a(uzVar, fVar, 1, true);
                    if (z) {
                        h.aIY().AM(uzVar.mBr);
                        if (!bi.oN(uzVar.wkP) && uzVar.wkP.equals("WeNoteHtmlFile")) {
                            h.aIY().g(h.aIZ().Ay(uzVar.mBr));
                        }
                    }
                    h.aIY().run();
                    x.i("MicroMsg.FavoriteLogic", "insert cdn item use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
                return;
            }
            x.i("MicroMsg.FavoriteLogic", "klem data not download completed.");
            Ay.field_status = 1;
            h.aIZ().a(Ay, "dataId");
            if (z) {
                h.aIY().AM(uzVar.mBr);
                if (!bi.oN(uzVar.wkP) && uzVar.wkP.equals("WeNoteHtmlFile")) {
                    h.aIY().g(h.aIZ().Ay(uzVar.mBr));
                }
            }
            h.aIY().run();
        }
    }

    public static void b(f fVar, uz uzVar, boolean z) {
        if (!bi.oN(uzVar.mBr)) {
            String AH = AH(uzVar.mBr);
            com.tencent.mm.plugin.fav.a.c Ay = h.aIZ().Ay(AH);
            if (Ay != null && Ay.field_status == 3) {
                h.aIZ().b(Ay, "dataId");
                Ay = null;
            }
            if (Ay == null || Ay.field_type != 1) {
                File file = new File(i(uzVar));
                if (!bi.oN(uzVar.wjJ) && !bi.oN(uzVar.hcU) && !file.exists()) {
                    a(uzVar, fVar, 1);
                    h.aIY().AM(AH);
                    h.aIY().run();
                    return;
                }
                return;
            }
            Ay.field_status = 1;
            h.aIZ().a(Ay, "dataId");
            h.aIY().AM(AH);
            h.aIY().run();
        }
    }

    public static void g(uz uzVar) {
        com.tencent.mm.plugin.fav.a.c Ay = h.aIZ().Ay(uzVar.mBr);
        if (!(Ay == null || Ay.field_status == 3)) {
            Ay.field_status = 2;
            h.aIZ().a(Ay, "dataId");
            h.aIY().pauseDownload(uzVar.mBr);
        }
        Ay = h.aIZ().Ay(AH(uzVar.mBr));
        if (Ay != null && Ay.field_status != 3) {
            Ay.field_status = 2;
            h.aIZ().a(Ay, "dataId");
            h.aIY().pauseDownload(AH(uzVar.mBr));
        }
    }

    public static uz p(f fVar) {
        if (fVar == null) {
            return new uz();
        }
        return fVar.field_favProto.wlY.size() == 0 ? new uz() : (uz) fVar.field_favProto.wlY.get(0);
    }

    public static float bw(long j) {
        float f = 60.0f;
        float f2 = 1.0f;
        float f3 = ((float) j) / 1000.0f;
        if (f3 >= 1.0f) {
            f2 = f3;
        }
        if (f2 <= 60.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static float di(long j) {
        float f = 1.0f;
        float f2 = ((float) j) / 1000.0f;
        if (f2 >= 1.0f) {
            f = f2;
        }
        return (float) Math.round(f);
    }

    public static void q(f fVar) {
        if (fVar.aIs()) {
            x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, itemStatu:%d", Integer.valueOf(fVar.field_itemStatus));
            Iterator it = fVar.field_favProto.wlY.iterator();
            while (it.hasNext()) {
                uz uzVar = (uz) it.next();
                com.tencent.mm.plugin.fav.a.c Ay = h.aIZ().Ay(uzVar.mBr);
                if (!(Ay == null || Ay.field_status == 3)) {
                    Ay.field_status = 2;
                    h.aIZ().a(Ay, "dataId");
                    h.aIY().AN(uzVar.mBr);
                }
                Ay = h.aIZ().Ay(AH(uzVar.mBr));
                if (!(Ay == null || Ay.field_status == 3)) {
                    Ay.field_status = 2;
                    h.aIZ().a(Ay, "dataId");
                    h.aIY().AN(AH(uzVar.mBr));
                }
            }
            f dc = h.getFavItemInfoStorage().dc(fVar.field_localId);
            x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, after pause data itemStatu:%d", Integer.valueOf(dc.field_itemStatus));
            switch (dc.field_itemStatus) {
                case 1:
                    h.getFavItemInfoStorage().t(3, dc.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(3));
                    return;
                case 4:
                    h.getFavItemInfoStorage().t(6, dc.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(6));
                    return;
                case 9:
                    h.getFavItemInfoStorage().t(11, dc.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(11));
                    return;
                case 12:
                    h.getFavItemInfoStorage().t(14, dc.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(14));
                    return;
                case 15:
                    h.getFavItemInfoStorage().t(16, dc.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(16));
                    return;
                case 17:
                    h.getFavItemInfoStorage().t(18, dc.field_localId);
                    x.v("MicroMsg.FavoriteLogic", "pauseItemUpload, final itemStatu:%d", Integer.valueOf(18));
                    return;
                default:
                    return;
            }
        }
        x.e("MicroMsg.FavoriteLogic", "pauseItemUpload, not uploading");
    }

    public static String bm(String str, int i) {
        return g.s((str + i + System.currentTimeMillis()).getBytes());
    }

    public static String h(uz uzVar) {
        if (uzVar == null) {
            return "";
        }
        String str = uzVar.mBr;
        if (bi.oN(str) || !as.Hp()) {
            return "";
        }
        File AG = AG(str);
        Object obj = null;
        if (uzVar.bjS == 8 && !bi.oN(uzVar.title)) {
            str = uzVar.title;
            AG = AG(uzVar.mBr);
            obj = 1;
        }
        if (uzVar.wkc != null && uzVar.wkc.trim().length() > 0 && obj == null) {
            str = str + "." + uzVar.wkc;
        }
        return new File(AG, str).getAbsolutePath();
    }

    public static String i(uz uzVar) {
        if (uzVar == null || bi.oN(uzVar.mBr)) {
            return "";
        }
        String AH = AH(uzVar.mBr);
        return new File(AG(AH), AH).getAbsolutePath();
    }

    private static File AG(String str) {
        int hashCode = str.hashCode() & 255;
        r3 = new Object[3];
        as.Hm();
        r3[0] = c.FJ();
        r3[1] = "favorite";
        r3[2] = Integer.valueOf(hashCode);
        File file = new File(String.format("%s/%s/%d/", r3));
        if (!(file.exists() && file.isDirectory())) {
            file.mkdirs();
        }
        return file;
    }

    public static String AH(String str) {
        return str + "_t";
    }

    public static boolean AI(String str) {
        if (bi.oN(str)) {
            return false;
        }
        return str.endsWith("_t");
    }

    public static boolean a(long j, Runnable runnable) {
        return a(h.getFavItemInfoStorage().dc(j), true, runnable);
    }

    public static boolean a(f fVar, Runnable runnable) {
        return a(fVar, true, null);
    }

    public static boolean a(final f fVar, final boolean z, final Runnable runnable) {
        if (fVar == null) {
            x.w("MicroMsg.FavoriteLogic", "delete fav item fail, item is null");
            ah.y(runnable);
            return false;
        }
        if (Looper.myLooper() == as.Dt().oFY.getLooper()) {
            x.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, do directly", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), Boolean.valueOf(z));
            a(fVar, z);
            ah.y(runnable);
        } else {
            x.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, post to worker", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), Boolean.valueOf(z));
            as.Dt().F(new Runnable() {
                public final void run() {
                    x.i("MicroMsg.FavoriteLogic", "delete favItem id %d, localId %d, needBatchDel %B, do on worker thread", Integer.valueOf(fVar.field_id), Long.valueOf(fVar.field_localId), Boolean.valueOf(z));
                    j.a(fVar, z);
                    ah.y(runnable);
                }
            });
        }
        return true;
    }

    private static void a(f fVar, boolean z) {
        r(fVar);
        h.aJc().de(fVar.field_localId);
        h.getFavItemInfoStorage().g(fVar);
        h.aIZ().da(fVar.field_localId);
        h.aIX().l(fVar);
        if (z) {
            Set aJq = aJq();
            aJq.add(fVar.field_id);
            d(aJq);
            aJp();
        }
    }

    public static boolean aM(List<f> list) {
        if (list == null || list.isEmpty()) {
            x.w("MicroMsg.FavoriteLogic", "delete fav item fail, item is null");
            return false;
        }
        Set aJq = aJq();
        for (f fVar : list) {
            r(fVar);
            h.aJc().de(fVar.field_localId);
            h.getFavItemInfoStorage().g(fVar);
            h.aIZ().da(fVar.field_localId);
            h.aIX().l(fVar);
            aJq.add(fVar.field_id);
            x.d("MicroMsg.FavoriteLogic", "delete id %d", Integer.valueOf(fVar.field_id));
        }
        d(aJq);
        aJp();
        return true;
    }

    public static void aN(List<Integer> list) {
        if (list.size() == 0) {
            x.e("MicroMsg.FavoriteLogic", "setDeleted list null");
            return;
        }
        Set aJq = aJq();
        x.i("MicroMsg.FavoriteLogic", "setDeleted before del:%s", aJq.toString());
        for (Integer num : list) {
            boolean remove = aJq.remove(num.toString());
            x.i("MicroMsg.FavoriteLogic", "setDeleted id:%d, ret:%b", num, Boolean.valueOf(remove));
        }
        x.i("MicroMsg.FavoriteLogic", "setDeleted after del:%s", aJq.toString());
        d(aJq);
    }

    public static void aJp() {
        Set<String> aJq = aJq();
        if (aJq.size() == 0) {
            x.v("MicroMsg.FavoriteLogic", "doBatchDel no item to delete");
            return;
        }
        x.i("MicroMsg.FavoriteLogic", "doBatchDel idList:%s", aJq.toString());
        LinkedList linkedList = new LinkedList();
        for (String str : aJq) {
            try {
                linkedList.add(Integer.valueOf(bi.getInt(str, 0)));
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.FavoriteLogic", e, "", new Object[0]);
                x.e("MicroMsg.FavoriteLogic", "doBatchDel parseInt error:%s", e.getMessage());
            }
        }
        x.i("MicroMsg.FavoriteLogic", "doBatchDel after parse, total size %d", Integer.valueOf(linkedList.size()));
        if (linkedList.size() > 0) {
            as.CN().a(new m(linkedList), 0);
        }
    }

    private static void d(Set<String> set) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String append : set) {
            stringBuffer.append(append).append(",");
        }
        Object obj = "";
        if (stringBuffer.length() > 0) {
            obj = stringBuffer.substring(0, stringBuffer.length() - 1);
        }
        x.i("MicroMsg.FavoriteLogic", "set need del IDs: %s", obj);
        as.Hm();
        c.Db().set(225282, obj);
    }

    private static Set<String> aJq() {
        as.Hm();
        String str = (String) c.Db().get(225282, (Object) "");
        x.i("MicroMsg.FavoriteLogic", "get need del IDs: %s", str);
        Set<String> hashSet = new HashSet();
        if (bi.oN(str)) {
            return hashSet;
        }
        String[] split = str.split(",");
        if (split == null || split.length == 0) {
            return hashSet;
        }
        for (Object add : split) {
            hashSet.add(add);
        }
        return hashSet;
    }

    private static void r(f fVar) {
        Set set = a.ibe;
        List list = fVar.field_favProto.wlY;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < list.size()) {
                String i3 = i((uz) list.get(i2));
                if (set == null || !set.contains(i3)) {
                    com.tencent.mm.loader.stub.b.deleteFile(i3);
                }
                i3 = h((uz) list.get(i2));
                if (set == null || !set.contains(i3)) {
                    com.tencent.mm.loader.stub.b.deleteFile(i3);
                }
                i = i2 + 1;
            } else {
                return;
            }
        }
    }

    public static void a(uz uzVar, f fVar, int i, boolean z) {
        if (i == 1 && (bi.oN(uzVar.wjP) || bi.oN(uzVar.wjN))) {
            x.e("MicroMsg.FavoriteLogic", "insertCdnDataInfo, type recv, cdndataurl must not be null!");
        } else if (i == 0 && bi.oN(h(uzVar))) {
            x.e("MicroMsg.FavoriteLogic", "insertCdnDataInfo, type send, path must not be null!");
        } else if (h.aIZ().Ay(uzVar.mBr) != null) {
            x.v("MicroMsg.FavoriteLogic", "cdn info exist, id[%s], return", uzVar.mBr);
        } else {
            int i2;
            x.i("MicroMsg.FavoriteLogic", "insert cdn data info, fav local id[%d] fav id[%d]", Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id));
            com.tencent.mm.plugin.fav.a.c cVar = new com.tencent.mm.plugin.fav.a.c();
            cVar.field_dataId = uzVar.mBr;
            cVar.field_totalLen = (int) uzVar.wki;
            cVar.field_type = i;
            cVar.field_favLocalId = fVar.field_localId;
            cVar.field_cdnKey = uzVar.wjP;
            cVar.field_cdnUrl = uzVar.wjN;
            cVar.field_path = h(uzVar);
            if (uzVar.bjS == 3) {
                String str = uzVar.wkc;
                i2 = (bi.oN(str) || !str.equals("speex")) ? (bi.oN(str) || !str.equals("silk")) ? -2 : -4 : -3;
                cVar.field_dataType = i2;
            } else {
                cVar.field_dataType = uzVar.bjS;
            }
            cVar.field_modifyTime = bi.Wy();
            boolean isWifi = ao.isWifi(ad.getContext());
            if (i == 0) {
                x.i("MicroMsg.FavoriteLogic", "can auto upload, force %B, isWifi %B, dataType %d, totalLen %d", Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen));
                if (z) {
                    i2 = 1;
                } else if (isWifi) {
                    i2 = 1;
                } else if (cVar.field_dataType == 8 || cVar.field_dataType == 4 || cVar.field_dataType == 15) {
                    long j = ad.getContext().getSharedPreferences(ad.cgf(), 0).getLong("fav_mx_auto_upload_size", 0);
                    if (j == 0) {
                        j = 26214400;
                    }
                    if (((long) cVar.field_totalLen) <= j) {
                        x.i("MicroMsg.FavoriteLogic", "match max auto upload, max size %d", Long.valueOf(j));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    cVar.field_status = 1;
                    x.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo upload status traning");
                } else {
                    cVar.field_status = 4;
                    x.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo upload status pause");
                }
            }
            if (i == 1) {
                x.i("MicroMsg.FavoriteLogic", "can auto download, force %B, isWifi %B, dataType %d, totalLen %d", Boolean.valueOf(z), Boolean.valueOf(isWifi), Integer.valueOf(cVar.field_dataType), Integer.valueOf(cVar.field_totalLen));
                if (z) {
                    i2 = 1;
                } else if (isWifi) {
                    i2 = 1;
                } else if (cVar.field_dataType == 8 || cVar.field_dataType == 4 || cVar.field_dataType == 15) {
                    if (((long) cVar.field_totalLen) <= ad.getContext().getSharedPreferences(ad.cgf(), 0).getLong("fav_mx_auto_download_size", 26214400)) {
                        x.i("MicroMsg.FavoriteLogic", "match max auto download, max size %d", Long.valueOf(ad.getContext().getSharedPreferences(ad.cgf(), 0).getLong("fav_mx_auto_download_size", 26214400)));
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                } else {
                    i2 = 1;
                }
                if (i2 != 0) {
                    cVar.field_status = 1;
                    x.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo download status traning");
                } else {
                    cVar.field_status = 4;
                    x.i("MicroMsg.FavoriteLogic", "insertCdnDataInfo download status pause");
                }
            }
            h.aIZ().b(cVar);
            if (i == 1) {
                com.tencent.mm.plugin.favorite.b.b.f(cVar);
            } else {
                com.tencent.mm.plugin.favorite.b.b.e(cVar);
            }
        }
    }

    public static void a(uz uzVar, f fVar, int i) {
        if (i == 1 && (uzVar.wkt <= 0 || bi.oN(uzVar.wjJ) || bi.oN(uzVar.hcU))) {
            x.e("MicroMsg.FavoriteLogic", "insertCdnThumbInfo, type recv, cdndataurl must not be null!");
        } else if (i == 0 && bi.oN(i(uzVar))) {
            x.e("MicroMsg.FavoriteLogic", "insertCdnThumbInfo, type send, path must not be null!");
        } else {
            String AH = AH(uzVar.mBr);
            if (h.aIZ().Ay(AH) != null) {
                x.w("MicroMsg.FavoriteLogic", "cdn info exist, id[%s], return", AH);
                return;
            }
            x.v("MicroMsg.FavoriteLogic", "insert cdn thumb info, fav local id[%d] fav id[%d]", Long.valueOf(fVar.field_localId), Integer.valueOf(fVar.field_id));
            com.tencent.mm.plugin.fav.a.c cVar = new com.tencent.mm.plugin.fav.a.c();
            cVar.field_cdnKey = uzVar.wjJ;
            cVar.field_cdnUrl = uzVar.hcU;
            cVar.field_dataId = AH;
            cVar.field_favLocalId = fVar.field_localId;
            cVar.field_totalLen = (int) uzVar.wkt;
            cVar.field_type = i;
            cVar.field_status = 1;
            cVar.field_path = i(uzVar);
            cVar.field_modifyTime = bi.Wy();
            cVar.field_attrFlag |= 1;
            h.aIZ().b(cVar);
            if (i == 1) {
                com.tencent.mm.plugin.favorite.b.b.f(cVar);
            } else {
                com.tencent.mm.plugin.favorite.b.b.e(cVar);
            }
        }
    }

    private static void s(f fVar) {
        int i;
        com.tencent.mm.plugin.fav.a.h hVar;
        com.tencent.mm.plugin.fav.a.h df = h.aJc().df(fVar.field_localId);
        if (df == null) {
            df = new com.tencent.mm.plugin.fav.a.h();
            df.field_localId = fVar.field_localId;
            i = 1;
            hVar = df;
        } else {
            i = 0;
            hVar = df;
        }
        hVar.field_tagContent = "";
        for (String str : fVar.field_tagProto.wmm) {
            hVar.field_tagContent += " " + str;
        }
        for (String str2 : fVar.field_tagProto.wmn) {
            hVar.field_tagContent += " " + str2;
            h.aIX().AC(str2);
        }
        hVar.field_content = "";
        hVar.field_time = fVar.field_updateTime;
        hVar.field_type = fVar.field_type;
        if (i != 0) {
            h.aJc().a(hVar);
            return;
        }
        h.aJc().a(hVar, "localId");
    }

    public static void t(f fVar) {
        int i;
        com.tencent.mm.plugin.fav.a.h hVar;
        com.tencent.mm.plugin.fav.a.h df = h.aJc().df(fVar.field_localId);
        if (df == null) {
            df = new com.tencent.mm.plugin.fav.a.h();
            df.field_localId = fVar.field_localId;
            i = 1;
            hVar = df;
        } else {
            i = 0;
            hVar = df;
        }
        StringBuffer stringBuffer = new StringBuffer();
        if (fVar.field_favProto.title != null) {
            stringBuffer.append(fVar.field_favProto.title);
        }
        if (fVar.field_favProto.desc != null) {
            stringBuffer.append(fVar.field_favProto.desc);
        }
        if (fVar.field_favProto.wlW != null) {
            vt vtVar = fVar.field_favProto.wlW;
            if (!bi.oN(vtVar.fAJ)) {
                stringBuffer.append(vtVar.fAJ);
                as.Hm();
                ag Xv = c.Ff().Xv(vtVar.fAJ);
                if (Xv != null) {
                    stringBuffer.append(Xv.field_nickname).append(Xv.field_conRemark);
                }
                as.Hm();
                Xv = c.Ff().Xv(vtVar.toUser);
                if (Xv != null) {
                    stringBuffer.append(Xv.field_nickname).append(Xv.field_conRemark);
                }
                stringBuffer.append(vtVar.wlx);
            }
        }
        LinkedList linkedList = fVar.field_favProto.wlY;
        hVar.field_subtype = 0;
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            uz uzVar = (uz) it.next();
            if (uzVar.desc != null) {
                stringBuffer.append(uzVar.desc);
            }
            if (uzVar.title != null) {
                stringBuffer.append(uzVar.title);
            }
            int i2 = uzVar.bjS;
            hVar.field_subtype = com.tencent.mm.plugin.fav.a.h.pY(i2) | hVar.field_subtype;
        }
        if (fVar.field_favProto.wlf != null) {
            if (fVar.field_favProto.wlf.desc != null) {
                stringBuffer.append(fVar.field_favProto.wlf.desc);
            }
            if (fVar.field_favProto.wlf.title != null) {
                stringBuffer.append(fVar.field_favProto.wlf.title);
            }
        }
        if (fVar.field_favProto.wlh != null) {
            if (fVar.field_favProto.wlh.desc != null) {
                stringBuffer.append(fVar.field_favProto.wlh.desc);
            }
            if (fVar.field_favProto.wlh.title != null) {
                stringBuffer.append(fVar.field_favProto.wlh.title);
            }
        }
        hVar.field_tagContent = "";
        for (String str : fVar.field_tagProto.wmm) {
            hVar.field_tagContent += " " + str;
            stringBuffer.append(str);
        }
        for (String str2 : fVar.field_tagProto.wmn) {
            hVar.field_tagContent += " " + str2;
            stringBuffer.append(str2);
            h.aIX().AC(str2);
        }
        hVar.field_content = stringBuffer.toString();
        hVar.field_time = fVar.field_updateTime;
        hVar.field_type = fVar.field_type;
        if (i != 0) {
            h.aJc().a(hVar);
            return;
        }
        h.aJc().a(hVar, "localId");
    }

    public static ArrayList<f> a(List<String> list, List<String> list2, List<Integer> list3, List<f> list4, Set<Integer> set, n nVar) {
        List a = h.aJc().a(list, list2, list3);
        ArrayList<f> arrayList = new ArrayList();
        if (a.size() == 0) {
            return arrayList;
        }
        int i = 0;
        while (true) {
            int size = i + 20 < a.size() ? i + 20 : a.size();
            x.v("MicroMsg.FavoriteLogic", "start:%d  end:%d listSize:%d", Integer.valueOf(i), Integer.valueOf(size), Integer.valueOf(a.size()));
            Collection a2 = h.getFavItemInfoStorage().a(a.subList(i, size), (List) list4, (Set) set, nVar);
            if (a2 != null && a2.size() > 0) {
                arrayList.addAll(a2);
            }
            if (size >= a.size()) {
                return arrayList;
            }
            i = size;
        }
    }

    public static int AJ(String str) {
        if (!bi.oN(str) && str.equals("speex")) {
            return 1;
        }
        if (bi.oN(str) || !str.equals("silk")) {
            return 0;
        }
        return 2;
    }

    public static void dj(long j) {
        x.i("MicroMsg.FavoriteLogic", "setUsedCapacity:%d", Long.valueOf(j));
        as.Hm();
        c.Db().a(w.a.USERFINO_FAV_USED_CAPACITY_LONG, Long.valueOf(j));
    }

    public static void dk(long j) {
        x.i("MicroMsg.FavoriteLogic", "setTotalCapacity:%d", Long.valueOf(j));
        as.Hm();
        c.Db().a(w.a.USERFINO_FAV_TOTAL_CAPACITY_LONG, Long.valueOf(j));
    }

    public static long aJr() {
        long aJs = aJs() - aJt();
        if (aJs < 0) {
            return 1024;
        }
        return aJs;
    }

    public static long aJs() {
        as.Hm();
        return ((Long) c.Db().get(w.a.USERFINO_FAV_TOTAL_CAPACITY_LONG, Long.valueOf(0))).longValue();
    }

    public static long aJt() {
        as.Hm();
        return ((Long) c.Db().get(w.a.USERFINO_FAV_USED_CAPACITY_LONG, Long.valueOf(0))).longValue();
    }

    public static boolean aJu() {
        if (aJs() != 0 && aJr() < 10485760) {
            return true;
        }
        return false;
    }

    public static boolean aJv() {
        if (aJs() != 0 && aJr() < 52428800) {
            return true;
        }
        return false;
    }

    public static void dl(long j) {
        ad.getContext().getSharedPreferences(ad.cgf(), 0).edit().putLong("fav_mx_auto_download_size", j).commit();
    }

    public static void dm(long j) {
        ad.getContext().getSharedPreferences(ad.cgf(), 0).edit().putLong("fav_mx_auto_upload_size", j).commit();
    }

    public static void dn(long j) {
        ad.getContext().getSharedPreferences(ad.cgf(), 0).edit().putLong("fav_mx_file_size", j).commit();
    }

    public static String ah(float f) {
        if (f < 1024.0f) {
            return String.format("%.1fB", new Object[]{Float.valueOf(f)});
        } else if (f < 1048576.0f) {
            return String.format("%.1fKB", new Object[]{Float.valueOf(f / 1024.0f)});
        } else if (f < 1.07374182E9f) {
            return String.format("%.1fMB", new Object[]{Float.valueOf((f / 1024.0f) / 1024.0f)});
        } else {
            return String.format("%.1fGB", new Object[]{Float.valueOf(((f / 1024.0f) / 1024.0f) / 1024.0f)});
        }
    }

    public static void a(List<f> list, String[] strArr) {
        if (list != null && !list.isEmpty() && strArr != null && strArr.length > 0) {
            List<f> linkedList = new LinkedList();
            for (f fVar : list) {
                int i = 0;
                for (String Ax : strArr) {
                    i |= fVar.Ax(Ax);
                }
                if (i != 0) {
                    h.getFavItemInfoStorage().a(fVar, "localId");
                    s(fVar);
                    linkedList.add(fVar);
                }
            }
            for (f fVar2 : linkedList) {
                k.a(fVar2, 3);
            }
        }
    }

    public static void a(f fVar, Collection<String> collection, int i) {
        if (fVar != null) {
            x.d("MicroMsg.FavoriteLogic", "mod tags %s", collection);
            Set hashSet = new HashSet();
            hashSet.addAll(fVar.field_tagProto.wmn);
            fVar.field_tagProto.wmn.clear();
            if (!(collection == null || collection.isEmpty())) {
                fVar.field_tagProto.wmn.addAll(collection);
                hashSet.removeAll(collection);
            }
            h.getFavItemInfoStorage().a(fVar, "localId");
            s(fVar);
            h.aIX().c(hashSet);
            k.a(fVar, i);
        }
    }

    public static String a(Context context, List<String> list) {
        if (context == null || list == null || list.isEmpty()) {
            return "";
        }
        String str = (String) list.get(0);
        String string = context.getResources().getString(R.l.egX);
        int i = 1;
        while (i < list.size()) {
            String str2 = str + string + ((String) list.get(i));
            i++;
            str = str2;
        }
        return str;
    }

    public static String B(Context context, int i) {
        if (context == null) {
            return "";
        }
        switch (i) {
            case 1:
                return context.getString(R.l.egO);
            case 2:
                return context.getString(R.l.egQ);
            case 3:
                return context.getString(R.l.egW);
            case 4:
                return context.getString(R.l.egV);
            case 5:
                return context.getString(R.l.egU);
            case 6:
                return context.getString(R.l.egR);
            case 7:
                return context.getString(R.l.egS);
            case 8:
                return context.getString(R.l.egP);
            default:
                return "";
        }
    }

    public static Integer W(Context context, String str) {
        if (context == null) {
            return Integer.valueOf(-1);
        }
        if (context.getString(R.l.egQ).equals(str)) {
            return Integer.valueOf(2);
        }
        if (context.getString(R.l.egS).equals(str)) {
            return Integer.valueOf(7);
        }
        if (context.getString(R.l.egR).equals(str)) {
            return Integer.valueOf(6);
        }
        if (context.getString(R.l.egO).equals(str)) {
            return Integer.valueOf(1);
        }
        if (context.getString(R.l.egV).equals(str)) {
            return Integer.valueOf(4);
        }
        if (context.getString(R.l.egU).equals(str)) {
            return Integer.valueOf(5);
        }
        if (context.getString(R.l.egW).equals(str)) {
            return Integer.valueOf(3);
        }
        if (context.getString(R.l.egP).equals(str)) {
            return Integer.valueOf(8);
        }
        return Integer.valueOf(-1);
    }

    public static String gx(String str) {
        as.Hm();
        com.tencent.mm.storage.x Xv = c.Ff().Xv(str);
        if (Xv == null) {
            x.w("MicroMsg.FavoriteLogic", "wtf get contact null, username %s", str);
            return "";
        }
        String AX = Xv.AX();
        if (!s.eX(AX)) {
            return AX;
        }
        List gl = m.gl(str);
        String FY = q.FY();
        if (gl == null || gl.isEmpty()) {
            x.w("MicroMsg.FavoriteLogic", "get members from username error, content empty");
            return AX;
        }
        gl.remove(FY);
        gl.add(0, FY);
        return m.b(gl, 3);
    }

    public static void do(long j) {
        mwa = j;
    }

    public static void aJw() {
        if (0 >= mwa) {
            x.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav,try to add tag ,but favLocalId is null, return");
            return;
        }
        f dc = h.getFavItemInfoStorage().dc(mwa);
        mwa = 0;
        if (dc == null) {
            x.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav,try to add tag ,but iteminfo is null, return");
            return;
        }
        x.i("MicroMsg.FavoriteLogic", "addTagWhenAddToFav ,go on");
        Intent intent = new Intent();
        intent.putExtra("key_fav_scene", 5);
        intent.putExtra("key_fav_item_id", dc.field_localId);
        d.b(ad.getContext(), "favorite", ".ui.FavTagEditUI", intent);
    }

    public static boolean u(f fVar) {
        if (fVar == null) {
            return false;
        }
        if (fVar.field_itemStatus == 8 || fVar.field_itemStatus == 10 || fVar.field_itemStatus == 7) {
            return true;
        }
        return false;
    }

    public static List<Long> aJx() {
        return h.getFavItemInfoStorage().aIN();
    }

    public static List<f> f(List<f> list, List<Long> list2) {
        int i = 0;
        List<f> arrayList = new ArrayList();
        if (list2 == null) {
            return arrayList;
        }
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
            Long valueOf = Long.valueOf(((f) list.get(list.size() - 1)).field_localId);
            for (int i2 = 0; i2 < list2.size(); i2++) {
                if (valueOf.equals(list2.get(i2))) {
                    i = i2 + 1;
                    break;
                }
            }
        }
        int i3 = i;
        while (i3 < i + 20 && i3 < list2.size()) {
            f dc = h.getFavItemInfoStorage().dc(((Long) list2.get(i3)).longValue());
            if (dc != null) {
                arrayList.add(dc);
            }
            i3++;
        }
        return arrayList;
    }

    public static boolean qb(int i) {
        for (int i2 : com.tencent.mm.plugin.fav.a.a.mtC) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static f AK(String str) {
        f fVar = new f();
        fVar.field_localId = -1;
        fVar.field_id = -1;
        fVar.field_xml = str;
        fVar.field_type = 18;
        fVar.Av(str);
        return fVar;
    }

    public static void a(uz uzVar, int i) {
        if (!bi.oN(uzVar.mBr)) {
            x.i("MicroMsg.FavoriteLogic", "restart cdndata download, dataId %s", uzVar.mBr);
            com.tencent.mm.plugin.fav.a.c Ay = h.aIZ().Ay(uzVar.mBr);
            if (Ay != null && (Ay.field_status == 3 || Ay.field_status == 4)) {
                h.aIZ().b(Ay, "dataId");
                Ay = null;
            }
            if (Ay == null || Ay.field_type != 1) {
                File file = new File(h(uzVar));
                if (!bi.oN(uzVar.wjP) && !bi.oN(uzVar.wjN) && !file.exists()) {
                    x.i("MicroMsg.FavoriteLogic", "klem big img not exist, start download.");
                    long currentTimeMillis = System.currentTimeMillis();
                    f fVar = new f();
                    fVar.field_localId = -1;
                    fVar.field_id = -1;
                    fVar.field_type = i;
                    a(uzVar, fVar, 1, true);
                    h.aIY().AM(uzVar.mBr);
                    h.aIY().run();
                    x.i("MicroMsg.FavoriteLogic", "insert cdn item use %d ms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    return;
                }
                return;
            }
            x.i("MicroMsg.FavoriteLogic", "klem data not download completed.");
            Ay.field_status = 1;
            h.aIZ().a(Ay, "dataId");
            h.aIY().AM(uzVar.mBr);
            h.aIY().run();
        }
    }

    public static void b(uz uzVar, int i) {
        if (!bi.oN(uzVar.mBr) && !bi.oN(uzVar.wjJ) && !bi.oN(uzVar.hcU)) {
            String AH = AH(uzVar.mBr);
            com.tencent.mm.plugin.fav.a.c Ay = h.aIZ().Ay(AH);
            if (Ay != null && (Ay.field_status == 3 || Ay.field_status == 4)) {
                h.aIZ().b(Ay, "dataId");
                Ay = null;
            }
            if (Ay == null || Ay.field_type != 1) {
                File file = new File(i(uzVar));
                if (!bi.oN(uzVar.wjJ) && !bi.oN(uzVar.hcU) && !file.exists()) {
                    f fVar = new f();
                    fVar.field_localId = -1;
                    fVar.field_id = -1;
                    fVar.field_type = i;
                    a(uzVar, fVar, 1);
                    h.aIY().AM(AH);
                    h.aIY().run();
                    return;
                }
                return;
            }
            Ay.field_status = 1;
            h.aIZ().a(Ay, "dataId");
            h.aIY().AM(AH);
            h.aIY().run();
        }
    }

    public static boolean v(f fVar) {
        if (fVar == null) {
            return false;
        }
        uz p = p(fVar);
        if (p == null) {
            return false;
        }
        int btk;
        int i;
        boolean a;
        long Wz = bi.Wz();
        com.tencent.mm.plugin.sight.base.a JX = com.tencent.mm.plugin.sight.base.d.JX(h(p));
        if (JX != null) {
            btk = JX.btk();
            i = p.duration;
            if (i <= 0 || Math.abs(i - btk) >= 2) {
                p.Db(btk);
                a = h.getFavItemInfoStorage().a(fVar, "localId");
            } else {
                a = false;
            }
        } else {
            a = false;
            i = 0;
            btk = 0;
        }
        x.i("MicroMsg.FavoriteLogic", "repair video duration[%d TO %d] %b cost time %d", Integer.valueOf(i), Integer.valueOf(btk), Boolean.valueOf(a), Long.valueOf(bi.bB(Wz)));
        return a;
    }

    public static void a(r rVar) {
        if (rVar.hoq != null && rVar.hoq.Hv() != null && rVar.hoq.Hv().vIb == -435) {
            f dd = h.getFavItemInfoStorage().dd((long) rVar.mwy);
            if (dd != null && dd.field_favProto != null && dd.field_favProto.wlY != null) {
                dd.field_favProto.Dk(dd.field_favProto.version + 2);
                dd.field_itemStatus = 1;
                h.getFavItemInfoStorage().a(dd, "localId");
                h.aIV().run();
            }
        }
    }

    public static void e(String str, Context context) {
        String nK = t.nK(str);
        x.i("MicroMsg.FavoriteLogic", "save video now video path %s out path %s", str, nK);
        if (bi.oN(nK)) {
            Toast.makeText(context, context.getString(R.l.eTt), 1).show();
            return;
        }
        Toast.makeText(context, context.getString(R.l.eTu, new Object[]{nK}), 1).show();
        k.b(nK, context);
    }

    public static boolean a(List<f> list, Context context, OnClickListener onClickListener) {
        if (list == null || list.isEmpty()) {
            return true;
        }
        d dVar = new d();
        int i = 0;
        int i2 = 0;
        Object obj = null;
        int i3 = 0;
        int i4 = 0;
        for (f fVar : list) {
            if (!(fVar == null || fVar.field_favProto == null || fVar.field_favProto.wlY == null)) {
                if (fVar.field_type == 3) {
                    i2++;
                } else {
                    Iterator it = fVar.field_favProto.wlY.iterator();
                    int i5 = 0;
                    int i6 = i;
                    i = i4;
                    while (it.hasNext()) {
                        uz uzVar = (uz) it.next();
                        if (uzVar.wkV == 2) {
                            i6++;
                        } else if (uzVar.wkV == 1) {
                            i++;
                        } else {
                            i5++;
                        }
                    }
                    if (d.k(fVar)) {
                        i4 = i3 + 1;
                        if (i5 > 0) {
                            i5--;
                        }
                    } else {
                        i4 = i3;
                    }
                    if (obj == null && r7 == fVar.field_favProto.wlY.size()) {
                        obj = 1;
                    }
                    obj = obj;
                    i3 = i4;
                    i4 = i;
                    i = i6;
                }
            }
        }
        if (1 == list.size()) {
            if (((f) list.get(0)).field_type == 14 && (i > 0 || i4 > 0)) {
                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.efb));
                return false;
            } else if (i > 0) {
                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.efc));
                return false;
            } else if (i4 > 0) {
                switch (((f) list.get(0)).field_type) {
                    case 2:
                        com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.efe));
                        break;
                    case 4:
                    case 16:
                        com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.eff));
                        break;
                    case 8:
                        com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.efd));
                        break;
                }
                return false;
            } else if (i3 > 0) {
                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.dBY));
                return false;
            } else if (i2 > 0) {
                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.dBZ));
                return false;
            }
        } else if (i > 0 || i4 > 0 || i3 > 0 || i2 > 0) {
            if (obj != null) {
                com.tencent.mm.ui.base.h.a(context, context.getString(R.l.efh), "", context.getString(R.l.dUn), context.getString(R.l.dUl), onClickListener, null, R.e.buj);
            } else {
                com.tencent.mm.ui.base.h.bu(context, context.getString(R.l.efg));
            }
            return false;
        }
        return true;
    }

    public static boolean w(f fVar) {
        if (fVar.field_favProto == null) {
            return false;
        }
        Iterator it = fVar.field_favProto.wlY.iterator();
        while (it.hasNext()) {
            uz uzVar = (uz) it.next();
            if (uzVar.wkV == 2) {
                return true;
            }
            if (uzVar.wkV == 1) {
                return true;
            }
        }
        return false;
    }

    public static f dp(long j) {
        f fVar = new f();
        fVar.field_type = 18;
        fVar.field_sourceType = 6;
        String FY = q.FY();
        vt vtVar = new vt();
        vtVar.UN(FY);
        vtVar.UO(FY);
        vtVar.Dl(fVar.field_sourceType);
        vtVar.fD(bi.Wy());
        fVar.field_favProto.a(vtVar);
        fVar.field_fromUser = vtVar.fAJ;
        fVar.field_toUser = vtVar.toUser;
        fVar.field_favProto.Dk(1);
        fVar.field_favProto.Dj(127);
        fVar.field_edittime = bi.Wx();
        fVar.field_updateTime = bi.Wy();
        fVar.field_favProto.fC(fVar.field_edittime);
        fVar.field_favProto.wlW.fD(bi.Wy());
        fVar.field_itemStatus = 9;
        fVar.field_localId = j;
        h.getFavItemInfoStorage().f(fVar);
        return fVar;
    }

    public static boolean x(f fVar) {
        if (h.getFavItemInfoStorage().dc(fVar.field_localId) != null) {
            return true;
        }
        return false;
    }

    private static String dq(long j) {
        StringBuilder stringBuilder = new StringBuilder();
        f dc = h.getFavItemInfoStorage().dc(j);
        if (dc == null || dc.field_favProto == null || dc.field_favProto.wlY.size() <= 1) {
            return "";
        }
        vh vhVar = dc.field_favProto.vJG;
        String str = "";
        String str2 = "";
        if (vhVar != null) {
            str = vhVar.wlQ;
            str2 = vhVar.wlP;
        }
        stringBuilder.append("<noteinfo>");
        stringBuilder.append("<noteauthor>").append(str2).append("</noteauthor>");
        stringBuilder.append("<noteeditor>").append(str).append("</noteeditor>");
        stringBuilder.append("<edittime>").append(dc.field_favProto.vJH).append("</edittime>");
        stringBuilder.append("<favlocalid>").append(dc.field_localId).append("</favlocalid>");
        stringBuilder.append(com.tencent.mm.plugin.fav.a.a.a.aI(dc.field_favProto.wlY).replace("cdn_dataurl", "cdndataurl").replace("cdn_datakey", "cdndatakey").replace("cdn_thumburl", "cdnthumburl").replace("cdn_thumbkey", "cdnthumbkey").replace("thumbfullsize", "thumbsize").replace("fullsize", "datasize").replace("datasrcname", "sourcename").replace("datasrctime", "sourcetime").replace("stream_lowbandurl", "streamlowbandurl").replace("stream_dataurl", "streamdataurl").replace("stream_weburl", "streamweburl"));
        stringBuilder.append("</noteinfo>");
        return stringBuilder.toString();
    }

    private static f AL(String str) {
        if (str == null || str.equals("")) {
            x.e("MicroMsg.FavoriteLogic", "parseSnsNoteInfoXml but xml is null");
            return null;
        }
        String str2;
        String replace = str.replace("cdndataurl", "cdn_dataurl").replace("cdndatakey", "cdn_datakey").replace("cdnthumburl", "cdn_thumburl").replace("cdnthumbkey", "cdn_thumbkey").replace("datasize", "fullsize").replace("thumbsize", "thumbfullsize").replace("sourcename", "datasrcname").replace("sourcetime", "datasrctime").replace("streamlowbandurl", "stream_lowbandurl").replace("streamdataurl", "stream_dataurl").replace("streamweburl", "stream_weburl");
        if (replace.startsWith("<noteinfo>")) {
            str2 = replace;
        } else {
            str2 = "<noteinfo>" + replace + "</noteinfo>";
        }
        Map y = bj.y(str2, "noteinfo");
        if (y == null) {
            x.e("MicroMsg.FavoriteLogic", "parseSnsNoteInfoXml, FavItemInfo maps null");
            return null;
        }
        f fVar = new f();
        try {
            fVar.field_favProto = new vn();
            fVar.field_type = 18;
            fVar.field_favProto.fC(bi.getLong((String) y.get(".noteinfo.edittime"), 0));
            vh vhVar = new vh();
            vhVar.wlQ = (String) y.get(".noteinfo.noteeditor");
            vhVar.wlP = (String) y.get(".noteinfo.noteauthor");
            fVar.field_favProto.a(vhVar);
            fVar.field_localId = bi.getLong((String) y.get(".noteinfo.favlocalid"), System.currentTimeMillis());
            com.tencent.mm.plugin.fav.a.a.b.a(str2, fVar.field_favProto);
            return fVar;
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.FavoriteLogic", e, "", new Object[0]);
            x.e("MicroMsg.FavoriteLogic", "parseSnsNoteInfoXml , FavItemInfo exception:+%s", e.toString());
            return null;
        }
    }

    public static void d(Context context, String str, String str2, String str3) {
        f AL = AL(str);
        if (AL != null) {
            com.tencent.mm.sdk.b.b kpVar = new kp();
            kpVar.fCH.type = 2;
            kpVar.fCH.field_localId = -1;
            kpVar.fCH.context = context;
            kpVar.fCH.fCO = 4;
            kpVar.fCH.fCQ = true;
            Bundle bundle = new Bundle();
            bundle.putString("noteauthor", AL.field_favProto.vJG.wlP);
            bundle.putString("noteeditor", AL.field_favProto.vJG.wlQ);
            bundle.putLong("edittime", AL.field_favProto.vJH);
            bundle.putString("notexml", f.c(AL));
            bundle.putString("snslocalid", str2);
            bundle.putString("snsthumbpath", str3);
            bundle.putString("snsnotelinkxml", str);
            kpVar.fCH.fCM = bundle;
            kpVar.fCH.field_favProto = AL.field_favProto;
            com.tencent.mm.sdk.b.a.xmy.m(kpVar);
        }
    }

    public static f a(vn vnVar) {
        f fVar = new f();
        fVar.field_favProto = new vn();
        fVar.field_type = 18;
        fVar.field_favProto = vnVar;
        return fVar;
    }

    public static void b(fw fwVar) {
        f dc;
        uz uzVar;
        if (fwVar.fwl.fws == -1) {
            dc = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
            if (dc != null && dc.field_favProto != null && dc.field_favProto.wlY.size() > 1) {
                uzVar = (uz) dc.field_favProto.wlY.get(0);
                fwVar.fwm.fwD = bi.oN(uzVar.wjN);
            }
        } else if (fwVar.fwl.fws != -3 || fwVar.fwl.frf <= 0) {
            f dc2;
            if (fwVar.fwl.fws == -2 && fwVar.fwl.frf > 0) {
                dc2 = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
                if (!(dc2 == null || dc2.field_itemStatus != 10 || bi.oN(dc2.field_xml))) {
                    dc2.Av(dc2.field_xml);
                    if (dc2.field_favProto != null && dc2.field_favProto.wlY.size() > 1) {
                        uzVar = (uz) dc2.field_favProto.wlY.get(0);
                        if (!(bi.oN(uzVar.wjN) || bi.oN(uzVar.wjP))) {
                            h.getFavItemInfoStorage().a(dc2, "localId");
                            return;
                        }
                    }
                }
            }
            Intent intent = new Intent();
            if (fwVar.fwl.frf > 0 && !bi.oN(fwVar.fwl.desc) && fwVar.fwl.fws > 0) {
                dc2 = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
                if (dc2 != null) {
                    intent.putExtra("fav_note_xml", f.c(dc2));
                    intent.putExtra("fav_note_item_updatetime", dc2.field_updateTime);
                }
            }
            dc2 = c.a(fwVar.fwl.frm.wlY, fwVar.fwl.frf);
            if (bi.oN(fwVar.fwl.desc)) {
                if (dc2.field_favProto.version != 0) {
                    dc2.field_favProto.Dk(dc2.field_favProto.version + 1);
                } else {
                    dc2.field_favProto.Dk(dc2.field_favProto.version + 2);
                }
                dc2.field_itemStatus = 1;
                y(dc2);
                h.getFavItemInfoStorage().a(dc2, "localId");
                h.aIV().run();
                return;
            }
            if (fwVar.fwl.fws > 0) {
                intent.putExtra("fav_note_item_status", dc2.field_itemStatus);
                fwVar.fwl.fwo = intent;
                dc2.field_favProto.Dk(dc2.field_favProto.version + 1);
            }
            dc2.field_itemStatus = 1;
            y(dc2);
            h.getFavItemInfoStorage().a(dc2, "localId");
            if (fwVar.fwl.desc.equals("fav_add_new_note")) {
                if (dc2.field_favProto.version != 0) {
                    dc2.field_favProto.Dk(dc2.field_favProto.version + 1);
                } else {
                    dc2.field_favProto.Dk(dc2.field_favProto.version + 2);
                }
                h.getFavItemInfoStorage().a(dc2, "localId");
                c.a(fwVar.fwl.title, fwVar.fwl.frm.wlY, fwVar.fwl.frf);
            }
        } else {
            dc = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
            if (dc != null) {
                dc.field_itemStatus = fwVar.fwl.fwo.getIntExtra("fav_note_item_status", dc.field_itemStatus);
                dc.field_updateTime = fwVar.fwl.fwo.getLongExtra("fav_note_item_updatetime", dc.field_updateTime);
                dc.Av(fwVar.fwl.fwo.getStringExtra("fav_note_xml"));
                h.getFavItemInfoStorage().a(dc, "localId");
            }
        }
    }

    private static void b(f fVar, boolean z) {
        vh vhVar = new vh();
        if (!z) {
            vhVar.wlP = q.FY();
        }
        vhVar.wlQ = q.FY();
        fVar.field_favProto.fC(bi.Wx());
        fVar.field_favProto.a(vhVar);
    }

    public static void y(f fVar) {
        if (fVar != null) {
            vh vhVar = fVar.field_favProto.vJG;
            if ((vhVar == null || bi.oN(vhVar.wlQ)) && fVar.field_type == 18) {
                if (fVar.field_favProto.wlW.fqY == 6) {
                    b(fVar, false);
                } else {
                    b(fVar, true);
                }
                h.getFavItemInfoStorage().a(fVar, "localId");
            }
        }
    }

    private static void c(fw fwVar) {
        if (bi.oN(fwVar.fwl.desc)) {
            fwVar.fwm.ret = -1;
            return;
        }
        f AL = AL(fwVar.fwl.desc);
        if (AL == null || AL.field_localId <= 0) {
            fwVar.fwm.ret = -1;
            return;
        }
        boolean A = A(AL);
        String str = fwVar.fwl.fwr;
        ArrayList arrayList;
        if (A) {
            fwVar.fwm.ret = 1;
            arrayList = (ArrayList) mwc.get(Long.valueOf(AL.field_localId));
            if (arrayList != null) {
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
                if (arrayList.size() == 0) {
                    mwc.remove(Long.valueOf(AL.field_localId));
                }
            }
        } else if (bi.oN(str)) {
            fwVar.fwm.ret = -1;
        } else {
            long j = AL.field_localId;
            if (mwc.get(Long.valueOf(j)) == null) {
                arrayList = new ArrayList();
            } else {
                arrayList = (ArrayList) mwc.get(Long.valueOf(j));
            }
            arrayList.add(str);
            mwc.put(Long.valueOf(j), arrayList);
            final f dc = h.getFavItemInfoStorage().dc(j);
            if (dc == null || dc.field_localId <= 0) {
                fwVar.fwm.ret = -1;
            } else if (A(dc) || dc.field_itemStatus == 10) {
                fwVar.fwm.ret = -1;
                as.Dt().g(new Runnable() {
                    public final void run() {
                        j.z(dc);
                    }
                }, 500);
            } else {
                fwVar.fwm.ret = -1;
            }
        }
    }

    public static synchronized void z(f fVar) {
        synchronized (j.class) {
            if (fVar != null) {
                if (fVar.field_type == 18) {
                    if (!(!mwc.containsKey(Long.valueOf(fVar.field_localId)) || mwc.get(Long.valueOf(fVar.field_localId)) == null || ((ArrayList) mwc.get(Long.valueOf(fVar.field_localId))).size() == 0)) {
                        x.i("MicroMsg.FavoriteLogic", "checkUpdateSnsNotePostXml, resend favlocal id:%d,xml:%s", Long.valueOf(fVar.field_localId), dq(fVar.field_localId));
                        com.tencent.mm.sdk.b.b ntVar = new nt();
                        ntVar.fGC.fGD = (ArrayList) mwc.get(Long.valueOf(fVar.field_localId));
                        ntVar.fGC.fGE = r2;
                        com.tencent.mm.sdk.b.a.xmy.m(ntVar);
                        mwc.remove(Long.valueOf(fVar.field_localId));
                    }
                }
            }
        }
    }

    private static boolean A(f fVar) {
        if (fVar == null) {
            return false;
        }
        boolean z;
        Iterator it = fVar.field_favProto.wlY.iterator();
        while (it.hasNext()) {
            uz uzVar = (uz) it.next();
            if ((uzVar.bjS == 8 || uzVar.bjS == 4 || uzVar.bjS == 2 || uzVar.bjS == 3) && (bi.oN(uzVar.wjN) || bi.oN(uzVar.wjP))) {
                z = false;
                break;
            }
        }
        z = true;
        return z;
    }

    public static void d(fw fwVar) {
        int i = 0;
        f fVar;
        if (fwVar.fwl.fws == 1) {
            String str;
            fwVar.fwm.path = dq(fwVar.fwl.frf);
            fw.b bVar = fwVar.fwm;
            f dc = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
            if (dc == null || dc.field_favProto == null) {
                str = "";
            } else {
                if (dc.field_type != 18 || dc.field_favProto.wlY.size() > 1) {
                    Iterator it = dc.field_favProto.wlY.iterator();
                    while (it.hasNext()) {
                        uz uzVar = (uz) it.next();
                        switch (uzVar.bjS) {
                            case 2:
                                str = i(uzVar);
                                if (!e.bO(str)) {
                                    String h = h(uzVar);
                                    if (!e.bO(h)) {
                                        if (!uzVar.wjI) {
                                            if (!uzVar.wjO) {
                                                str = "";
                                                break;
                                            }
                                            a(dc, uzVar, true);
                                            str = h;
                                            break;
                                        }
                                        b(dc, uzVar, true);
                                        break;
                                    }
                                    com.tencent.mm.sdk.platformtools.d.b(h, 150, 150, CompressFormat.JPEG, 90, str);
                                    str = i(uzVar);
                                    break;
                                }
                                break;
                            default:
                        }
                    }
                }
                str = "";
            }
            bVar.fwx = str;
        } else if (fwVar.fwl.fws == 2) {
            fVar = new f();
            fVar.field_type = 2;
            uz uzVar2 = new uz();
            uzVar2.Ui(bm(uzVar2.toString(), 2));
            String h2 = h(uzVar2);
            uzVar2.Uj(h2);
            uzVar2.Dc(2);
            fVar.field_favProto.wlY.add(uzVar2);
            fwVar.fwm.path = f.c(fVar);
            fwVar.fwm.fwx = h2;
        } else if (fwVar.fwl.fws == 3) {
            fVar = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
            if (fVar != null) {
                fwVar.fwm.path = q.FY() + ";" + fVar.field_fromUser + ";" + fVar.field_updateTime;
            }
        } else if (fwVar.fwl.fws == 4) {
            fVar = AL(fwVar.fwl.desc);
            if (fVar != null) {
                fwVar.fwl.frm = fVar.field_favProto;
            }
        } else if (fwVar.fwl.fws == 5) {
            c(fwVar);
        } else if (fwVar.fwl.fws == 6) {
            f dc2 = h.getFavItemInfoStorage().dc(fwVar.fwl.frf);
            if (dc2 == null) {
                fwVar.fwm.ret = 0;
                return;
            }
            fw.b bVar2 = fwVar.fwm;
            if (dc2.field_id > 0) {
                i = 1;
            }
            bVar2.ret = i;
        } else {
            fVar = new f();
            fVar.field_type = 18;
            fVar.field_favProto = fwVar.fwl.frm;
            fwVar.fwm.path = f.c(fVar);
        }
    }
}
