package com.tencent.mm.plugin.music.model.b;

import android.content.ContentValues;
import android.text.TextUtils;
import com.tencent.mm.plugin.music.model.g;
import com.tencent.mm.plugin.music.model.h;
import com.tencent.mm.plugin.music.model.h.b;
import com.tencent.mm.plugin.music.model.h.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.y.as;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class e {
    private static aa<String, String> oQO = new aa(20);
    private static aa<String, Boolean> oQP = new aa(20);
    private static aa<String, Integer> oQQ = new aa(20);
    private static aa<String, Integer> oQR = new aa(20);
    private static aa<String, Long> oQS = new aa(20);
    private static aa<String, String> oQT = new aa(20);

    public static void GQ(String str) {
        b bVar;
        c bej = h.bej();
        if (TextUtils.isEmpty(str)) {
            x.i("MicroMsg.PieceMusicInfoStorage", "updatePieceMusicByUrl url is empty!");
            bVar = null;
        } else {
            int i;
            String Gw = g.Gw(str);
            b Hd = bej.Hd(Gw);
            if (Hd == null) {
                bVar = new b();
                i = 0;
            } else {
                bVar = Hd;
                i = 1;
            }
            bVar.field_musicId = Gw;
            bVar.field_musicUrl = str;
            bVar.field_fileName = g.Gr(str);
            x.i("MicroMsg.PieceMusicInfoStorage", "updatePieceMusicByUrl musicId:%s, field_fileName:%s", Gw, bVar.field_fileName);
            if (i != 0) {
                x.i("MicroMsg.PieceMusicInfoStorage", "update PieceMusicInfo");
                bej.c(bVar, new String[0]);
            } else {
                x.i("MicroMsg.PieceMusicInfoStorage", "insert PieceMusicInfo");
                bej.b((com.tencent.mm.sdk.e.c) bVar);
            }
            bej.oSw.put(Gw, bVar);
        }
        if (bVar != null) {
            CharSequence charSequence = bVar.field_musicId;
            if (!(TextUtils.isEmpty(str) || TextUtils.isEmpty(charSequence))) {
                oQO.put(str, charSequence);
            }
            List arrayList = new ArrayList(1);
            arrayList.add(bVar.field_musicId);
            a aVar = new a(arrayList);
            as.Hm();
            long longValue = ((Long) com.tencent.mm.y.c.Db().get(a.USERINFO_MUSIO_LAST_SCAN_MUSIC_PIECE_FILE_TIME_LONG, Long.valueOf(0))).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue <= a.oQC.longValue()) {
                x.e("MicroMsg.CleanMusicController", "startClean the last clean time is in MUSIC_NO_SCAN_TIME time");
                return;
            }
            x.i("MicroMsg.CleanMusicController", "start clean music file");
            as.Hm();
            com.tencent.mm.y.c.Db().a(a.USERINFO_MUSIO_LAST_SCAN_MUSIC_PIECE_FILE_TIME_LONG, Long.valueOf(currentTimeMillis));
            com.tencent.mm.sdk.f.e.post(new Runnable() {
                public final void run() {
                    a.a(a.this);
                }
            }, "CleanMusicController");
        }
    }

    public static String GR(String str) {
        if (oQO.bu(str)) {
            return (String) oQO.get(str);
        }
        return "";
    }

    public static void at(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            oQP.put(str, Boolean.valueOf(z));
        }
    }

    public static boolean GS(String str) {
        if (oQP.bu(str)) {
            return ((Boolean) oQP.get(str)).booleanValue();
        }
        return false;
    }

    public static void i(String str, Map<String, String> map) {
        if (map != null && GS(str)) {
            map.put("Cookie", "qqmusic_fromtag=97;qqmusic_uin=1234567;qqmusic_key=;");
            map.put("referer", "stream12.qqmusic.qq.com");
        }
    }

    public static void dE(String str, String str2) {
        x.i("MicroMsg.PieceCacheHelper", "setMusicMIMEType mimeType:%s", str2);
        Object GR = GR(str);
        if (TextUtils.isEmpty(GR)) {
            x.e("MicroMsg.PieceCacheHelper", "setMusicMIMEType musicId is empty!");
            return;
        }
        b Hd = h.bej().Hd(GR);
        if (Hd == null) {
            x.e("MicroMsg.PieceCacheHelper", "setMusicMIMEType pMusic is null!'");
        } else if (TextUtils.isEmpty(Hd.field_pieceFileMIMEType)) {
            x.e("MicroMsg.PieceCacheHelper", "updatePieceFileMIMEType()'");
            c bej = h.bej();
            ContentValues contentValues = new ContentValues();
            contentValues.put("pieceFileMIMEType", str2);
            int update = bej.gLA.update("PieceMusicInfo", contentValues, "musicId=?", new String[]{GR});
            x.i("MicroMsg.PieceMusicInfoStorage", "updatePieceFileMIMEType raw=%d musicId=%s", Integer.valueOf(update), GR);
            b bVar = (b) bej.oSw.get(GR);
            if (bVar != null) {
                bVar.field_pieceFileMIMEType = str2;
            }
        } else {
            x.i("MicroMsg.PieceCacheHelper", "don't need update the piece fle mime type");
        }
    }

    public static String GT(String str) {
        Object GR = GR(str);
        if (TextUtils.isEmpty(GR)) {
            x.e("MicroMsg.PieceCacheHelper", "getMusicMIMEType musicId is empty!");
            return null;
        }
        b Hd = h.bej().Hd(GR);
        if (Hd == null) {
            x.e("MicroMsg.PieceCacheHelper", "getMusicMIMEType pMusic is null!'");
            return null;
        }
        x.i("MicroMsg.PieceCacheHelper", "music field_pieceFileMIMEType:%s", Hd.field_pieceFileMIMEType);
        if (!TextUtils.isEmpty(Hd.field_pieceFileMIMEType)) {
            return Hd.field_pieceFileMIMEType;
        }
        x.e("MicroMsg.PieceCacheHelper", "field_pieceFileMIMEType is null!'");
        return null;
    }

    public static String GU(String str) {
        if (oQT.bu(str)) {
            return (String) oQT.get(str);
        }
        return null;
    }

    public static void dF(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            oQT.put(str, str2);
        }
    }

    public static long GV(String str) {
        if (oQS.bu(str)) {
            return ((Long) oQS.get(str)).longValue();
        }
        return -1;
    }

    public static void X(String str, long j) {
        if (j > 0) {
            oQS.put(str, Long.valueOf(j));
        }
    }

    public static long GW(String str) {
        File file = new File(g.Gr(str));
        return file.exists() ? file.length() : -1;
    }

    public static void deleteFile(String str) {
        Logger.i("MicroMsg.PieceFileCache", "deleteFileByUrl");
        f.deleteFile(g.Gr(str));
    }

    public static void bL(String str, int i) {
        if (str != null) {
            oQQ.put(str, Integer.valueOf(i));
        }
    }

    public static int GX(String str) {
        if (str == null || !oQQ.bu(str)) {
            return 0;
        }
        return ((Integer) oQQ.get(str)).intValue();
    }

    public static void bM(String str, int i) {
        if (str != null) {
            oQR.put(str, Integer.valueOf(i));
        }
    }

    public static int GY(String str) {
        if (str == null || !oQR.bu(str)) {
            return 0;
        }
        return ((Integer) oQR.get(str)).intValue();
    }

    public static boolean h(com.tencent.mm.au.a aVar) {
        boolean isWifi = ao.isWifi(ad.getContext());
        boolean z = isWifi ? aVar.field_wifiEndFlag == 1 : aVar.field_endFlag == 1;
        if (z && new File(g.b(aVar, isWifi)).exists()) {
            return true;
        }
        return false;
    }

    public static boolean i(com.tencent.mm.au.a aVar) {
        boolean z;
        if (aVar == null || TextUtils.isEmpty(aVar.hJE)) {
            z = false;
        } else {
            b Hd = h.bej().Hd(g.Gw(aVar.hJE));
            z = Hd != null && Hd.field_fileCacheComplete == 1;
        }
        if (z) {
            String str = aVar.hJE;
            Logger.i("MicroMsg.PieceFileCache", "existFileByUrl");
            str = g.Gr(str);
            Logger.i("MicroMsg.PieceFileCache", "existFile, fileName:" + str);
            x.i("MicroMsg.PieceFileCache", "the piece File exist:%b", Boolean.valueOf(new File(str).exists()));
            if (new File(str).exists()) {
                return true;
            }
        }
        return false;
    }
}
