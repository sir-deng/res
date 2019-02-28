package com.tencent.mm.plugin.favorite.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mm.a.g;
import com.tencent.mm.f.a.cg;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.fav.a.f;
import com.tencent.mm.plugin.favorite.a.j;
import com.tencent.mm.plugin.favorite.a.r;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.pluginsdk.k.e;
import com.tencent.mm.pluginsdk.model.c;
import com.tencent.mm.protocal.c.ash;
import com.tencent.mm.protocal.c.uz;
import com.tencent.mm.protocal.c.vt;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.downloadservice.Downloads;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

public final class a {

    private static class a implements Runnable {
        f mwn;

        public a(f fVar) {
            this.mwn = fVar;
        }

        public final void run() {
            Throwable e;
            MediaMetadataRetriever mediaMetadataRetriever;
            InputStream inputStream;
            String oM;
            long mi;
            String a;
            String i;
            Throwable th;
            List list = this.mwn.field_favProto.wlY;
            if (list.size() > 0) {
                boolean z = false;
                int size = list.size();
                x.i("MicroMsg.Fav.FavAddService", "run addfavservice copyrunable info.field_type = %d", Integer.valueOf(this.mwn.field_type));
                uz uzVar;
                if (this.mwn.field_type == 18 && this.mwn.field_sourceType == 6) {
                    int i2 = 0;
                    while (i2 < size) {
                        boolean z2;
                        uzVar = (uz) list.get(i2);
                        if (uzVar.wkz && uzVar.wkB) {
                            z2 = z;
                        } else {
                            z2 = true;
                        }
                        i2++;
                        z = z2;
                    }
                } else {
                    for (int i3 = 0; i3 < size; i3++) {
                        String bV;
                        uzVar = (uz) list.get(i3);
                        if (bi.oN(uzVar.mBr)) {
                            uzVar.Ui(j.bm(uzVar.toString(), this.mwn.field_type));
                        }
                        if (!(uzVar.wkz && uzVar.wkB)) {
                            z = true;
                        }
                        long currentTimeMillis = System.currentTimeMillis();
                        String str = uzVar.wkl;
                        if (FileOp.bO(str)) {
                            bV = g.bV(str);
                            String bW = g.bW(str);
                            uzVar.Ug(bV);
                            uzVar.Uh(bW);
                            uzVar.fx(new File(str).length());
                            bV = j.h(uzVar);
                            if (!str.equals(bV)) {
                                FileOp.x(str, bV);
                            }
                        } else {
                            x.i("MicroMsg.Fav.FavAddService", "copy file fail, type:%d, %s not exist!", Integer.valueOf(uzVar.bjS), str);
                        }
                        bV = uzVar.wkn;
                        if (bi.oN(bV) && FileOp.bO(str) && this.mwn.field_type == 4 && this.mwn.field_favProto.wlW.fqY == 13) {
                            bV = j.h(uzVar) + "_tempthumb";
                            Bitmap RX = c.RX(str);
                            if (RX != null) {
                                try {
                                    x.i("MicroMsg.Fav.FavAddService", "add fav service: create thumbpath bitmap, saveBitmapToImage ");
                                    e.a(RX, CompressFormat.JPEG, bV);
                                } catch (Throwable e2) {
                                    x.printErrStackTrace("MicroMsg.Fav.FavAddService", e2, "", new Object[0]);
                                }
                            }
                            uzVar.Uk(bV);
                            try {
                                x.i("MicroMsg.Fav.FavAddService", "add fav service: get video duration");
                                mediaMetadataRetriever = new MediaMetadataRetriever();
                                try {
                                    mediaMetadataRetriever.setDataSource(str);
                                    uzVar.Db(bi.fN((long) bi.getInt(mediaMetadataRetriever.extractMetadata(9), 0)));
                                    mediaMetadataRetriever.release();
                                } catch (Exception e3) {
                                    e2 = e3;
                                    try {
                                        x.printErrStackTrace("MicroMsg.Fav.FavAddService", e2, "get video duration error. path %s", str);
                                        if (mediaMetadataRetriever != null) {
                                            mediaMetadataRetriever.release();
                                        }
                                        if (FileOp.bO(bV)) {
                                            inputStream = null;
                                            try {
                                                inputStream = FileOp.openRead(bV);
                                                oM = bi.oM(g.a(inputStream, Downloads.RECV_BUFFER_SIZE));
                                                mi = FileOp.mi(bV);
                                                a = g.a(inputStream, 0, 256);
                                                uzVar.Ul(oM);
                                                uzVar.Um(a);
                                                uzVar.fy(mi);
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception e4) {
                                                    }
                                                }
                                            } catch (FileNotFoundException e5) {
                                                x.e("MicroMsg.Fav.FavAddService", "FileOp thumbpath error !");
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception e6) {
                                                    }
                                                }
                                            } catch (Throwable th2) {
                                                if (inputStream != null) {
                                                    try {
                                                        inputStream.close();
                                                    } catch (Exception e7) {
                                                    }
                                                }
                                            }
                                            i = j.i(uzVar);
                                            if (bV.equals(i)) {
                                                FileOp.x(bV, i);
                                            }
                                        } else {
                                            x.i("MicroMsg.Fav.FavAddService", "copy thumb fail, %s not exist!", bV);
                                        }
                                        x.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", Long.valueOf(this.mwn.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                                    } catch (Throwable th3) {
                                        th = th3;
                                    }
                                }
                            } catch (Exception e8) {
                                e2 = e8;
                                mediaMetadataRetriever = null;
                                x.printErrStackTrace("MicroMsg.Fav.FavAddService", e2, "get video duration error. path %s", str);
                                if (mediaMetadataRetriever != null) {
                                    mediaMetadataRetriever.release();
                                }
                                if (FileOp.bO(bV)) {
                                    x.i("MicroMsg.Fav.FavAddService", "copy thumb fail, %s not exist!", bV);
                                } else {
                                    inputStream = null;
                                    inputStream = FileOp.openRead(bV);
                                    oM = bi.oM(g.a(inputStream, Downloads.RECV_BUFFER_SIZE));
                                    mi = FileOp.mi(bV);
                                    a = g.a(inputStream, 0, 256);
                                    uzVar.Ul(oM);
                                    uzVar.Um(a);
                                    uzVar.fy(mi);
                                    if (inputStream != null) {
                                        inputStream.close();
                                    }
                                    i = j.i(uzVar);
                                    if (bV.equals(i)) {
                                        FileOp.x(bV, i);
                                    }
                                }
                                x.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", Long.valueOf(this.mwn.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                            } catch (Throwable th4) {
                                th = th4;
                                mediaMetadataRetriever = null;
                            }
                        }
                        if (FileOp.bO(bV)) {
                            inputStream = null;
                            inputStream = FileOp.openRead(bV);
                            oM = bi.oM(g.a(inputStream, Downloads.RECV_BUFFER_SIZE));
                            mi = FileOp.mi(bV);
                            a = g.a(inputStream, 0, 256);
                            uzVar.Ul(oM);
                            uzVar.Um(a);
                            uzVar.fy(mi);
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            i = j.i(uzVar);
                            if (bV.equals(i)) {
                                FileOp.x(bV, i);
                            }
                        } else {
                            x.i("MicroMsg.Fav.FavAddService", "copy thumb fail, %s not exist!", bV);
                        }
                        x.i("MicroMsg.Fav.FavAddService", "klem cul md5 and copy file, favLocalId:%d  time:%d", Long.valueOf(this.mwn.field_localId), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    }
                }
                ah.y(new Runnable() {
                    public final void run() {
                        if (z) {
                            x.i("MicroMsg.Fav.FavAddService", "has data, check cdn now, type %d", Integer.valueOf(a.this.mwn.field_type));
                            a.this.mwn.field_itemStatus = 1;
                            a.this.mwn.field_xml = f.c(a.this.mwn);
                            if (j.x(a.this.mwn)) {
                                h.getFavItemInfoStorage().a(a.this.mwn, new String[0]);
                            } else {
                                h.getFavItemInfoStorage().f(a.this.mwn);
                            }
                            h.aIV().run();
                            return;
                        }
                        x.i("MicroMsg.Fav.FavAddService", "no data, send item now, type %d", Integer.valueOf(a.this.mwn.field_type));
                        a.this.mwn.field_itemStatus = 9;
                        a.this.mwn.field_xml = f.c(a.this.mwn);
                        if (j.x(a.this.mwn)) {
                            h.getFavItemInfoStorage().a(a.this.mwn, new String[0]);
                        } else {
                            h.getFavItemInfoStorage().f(a.this.mwn);
                        }
                        h.aIU().run();
                    }
                });
                return;
            }
            return;
            if (mediaMetadataRetriever != null) {
                mediaMetadataRetriever.release();
            }
            throw th;
        }
    }

    /* renamed from: com.tencent.mm.plugin.favorite.b.a$1 */
    static class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ cg mwI;

        public AnonymousClass1(cg cgVar) {
            this.mwI = cgVar;
        }

        public final void onClick(DialogInterface dialogInterface, int i) {
            if (i == -2) {
                a.a(this.mwI);
            }
        }
    }

    public static int a(cg cgVar) {
        f Az;
        int i = 1;
        f fVar = new f();
        fVar.field_favProto = cgVar.frk.frm;
        fVar.field_sessionId = cgVar.frk.frp;
        vt vtVar = fVar.field_favProto.wlW;
        if (vtVar != null) {
            int i2;
            fVar.field_sourceId = vtVar.wmg;
            if (fVar.field_sourceId == null || fVar.field_sourceId.equals("")) {
                i2 = 0;
            } else {
                f Az2 = h.getFavItemInfoStorage().Az(fVar.field_sourceId);
                if (Az2 != null && Az2.field_id > 0) {
                    int i3 = Az2.field_id;
                    if (i3 <= 0) {
                        x.e("MicroMsg.Fav.ModFavItemLogic", "modUpdateTime favId illegal:%d", Integer.valueOf(i3));
                    } else {
                        LinkedList linkedList = new LinkedList();
                        ash ash = new ash();
                        ash.wGK = 1;
                        ash.wGL = (int) (System.currentTimeMillis() / 1000);
                        linkedList.add(ash);
                        as.CN().a(new r(i3, linkedList, null), 0);
                    }
                }
                i2 = Az2 != null ? 1 : 0;
            }
            if (i2 != 0) {
                x.w("MicroMsg.Fav.FavAddService", "handleEvent, msg already exist, do not insert");
                i = 0;
                if (i != 0) {
                    Az = h.getFavItemInfoStorage().Az(fVar.field_sourceId);
                    if (Az != null) {
                        j.do(Az.field_localId);
                    }
                } else {
                    fVar.field_flag = 0;
                    fVar.field_updateTime = System.currentTimeMillis();
                    fVar.field_localId = System.currentTimeMillis();
                    j.do(fVar.field_localId);
                    fVar.field_type = cgVar.frk.type;
                    if (cgVar.frk.desc != null || cgVar.frk.desc.length() < 10001) {
                        fVar.field_favProto.UM(cgVar.frk.desc);
                    } else {
                        x.w("MicroMsg.Fav.FavAddService", "length more than 10000, do cut desc");
                        fVar.field_favProto.UM(cgVar.frk.desc.substring(0, 10001));
                    }
                    fVar.field_xml = f.c(fVar);
                    C(fVar);
                    j.t(fVar);
                    fVar.Aw("MicroMsg.Fav.FavAddService");
                }
                return 0;
            }
            fVar.field_fromUser = vtVar.fAJ;
            fVar.field_toUser = vtVar.toUser;
            fVar.field_sourceType = vtVar.fqY;
            fVar.field_sourceId = vtVar.wmg;
            fVar.field_sourceCreateTime = vtVar.hXs;
        }
        x.i("MicroMsg.Fav.FavAddService", "deal with source item, fromUser is %s, toUser %s, sourceId %s, sourceType %d", fVar.field_fromUser, fVar.field_toUser, fVar.field_sourceId, Integer.valueOf(fVar.field_sourceType));
        if (i != 0) {
            fVar.field_flag = 0;
            fVar.field_updateTime = System.currentTimeMillis();
            fVar.field_localId = System.currentTimeMillis();
            j.do(fVar.field_localId);
            fVar.field_type = cgVar.frk.type;
            if (cgVar.frk.desc != null) {
            }
            fVar.field_favProto.UM(cgVar.frk.desc);
            fVar.field_xml = f.c(fVar);
            C(fVar);
            j.t(fVar);
            fVar.Aw("MicroMsg.Fav.FavAddService");
        } else {
            Az = h.getFavItemInfoStorage().Az(fVar.field_sourceId);
            if (Az != null) {
                j.do(Az.field_localId);
            }
        }
        return 0;
    }

    public static void B(f fVar) {
        fVar.field_updateTime = System.currentTimeMillis();
        if (!j.x(fVar)) {
            fVar.field_localId = System.currentTimeMillis();
        }
        C(fVar);
        j.t(fVar);
    }

    private static void C(f fVar) {
        com.tencent.mm.plugin.fav.a.g.cU(fVar.field_localId);
        if (fVar.field_favProto.wlY.size() > 0) {
            com.tencent.mm.sdk.f.e.post(new a(fVar), "AddFavService_copy");
            return;
        }
        fVar.field_itemStatus = 9;
        if (j.x(fVar)) {
            h.getFavItemInfoStorage().a(fVar, new String[0]);
        } else {
            h.getFavItemInfoStorage().f(fVar);
        }
        h.aIU().run();
    }
}
