package com.tencent.mm.plugin.gallery.model;

import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.a.f.a;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.platformtools.d;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

public final class c {
    private static int bkq = 0;
    private static c mWv = null;
    public static boolean mWw = false;
    public static boolean mWx = false;
    public static boolean mWy = false;
    public static boolean mWz = false;
    private HashSet<MediaItem> mWA = new HashSet();
    private ArrayList<Bundle> mWB = new ArrayList();
    private HashMap<Integer, Boolean> mWC = new HashMap();
    private l mWq;
    private a mWr;
    private e mWs;
    private ArrayList<MediaItem> mWt = null;
    private LinkedHashSet<MediaItem> mWu = new LinkedHashSet();

    public static MediaItem BY(String str) {
        MediaItem a = MediaItem.a(0, 0, str, "", "");
        if (aOj().mWt != null) {
            int indexOf = aOj().mWt.indexOf(a);
            if (indexOf >= 0) {
                return (MediaItem) aOj().mWt.get(indexOf);
            }
        }
        return null;
    }

    private c() {
        if (this.mWr == null) {
            this.mWr = new a();
        }
        if (this.mWq == null) {
            this.mWq = new l();
        }
        if (this.mWs == null) {
            this.mWs = new e();
        }
    }

    private static c aOj() {
        if (mWv == null) {
            mWv = new c();
        }
        return mWv;
    }

    public static a aOk() {
        return aOj().mWr;
    }

    public static l aOl() {
        return aOj().mWq;
    }

    public static e aOm() {
        return aOj().mWs;
    }

    public static void initialize() {
        synchronized (c.class) {
            bkq++;
        }
    }

    public static void release(boolean z) {
        synchronized (c.class) {
            if (bkq > 0) {
                bkq--;
            }
            if (z && bkq == 0) {
                aOj().mWq = null;
                if (aOj().mWr != null) {
                    b bVar = aOj().mWr.mWb;
                    if (bVar.mWm != null) {
                        bVar.mWm.a(new a<String, a>() {
                        });
                        bVar.mWm = null;
                    }
                    if (bVar.mWn != null) {
                        d dVar = bVar.mWn;
                        dVar.aOu();
                        dVar.aOv();
                        dVar.aOx();
                        bVar.mWn = null;
                    }
                    aOj().mWr = null;
                }
                e eVar = aOj().mWs;
                if (eVar.mWH != null) {
                    eVar.mWH.quit();
                    eVar.mWH = null;
                }
                eVar.mWK = null;
                if (eVar.mWI != null) {
                    eVar.mWI.quit();
                    eVar.mWI = null;
                }
                eVar.mWL = null;
                if (eVar.mWJ != null) {
                    eVar.mWJ.quit();
                    eVar.mWJ = null;
                }
                eVar.mWM = null;
                aOj().mWs = null;
                mWv = null;
            }
        }
    }

    public static ArrayList<MediaItem> aOn() {
        return aOj().mWt;
    }

    public static HashSet<MediaItem> aOo() {
        return aOj().mWA;
    }

    public static ArrayList<Bundle> aOp() {
        return aOj().mWB;
    }

    public static LinkedHashSet<MediaItem> aOq() {
        return aOj().mWu;
    }

    public static void w(ArrayList<MediaItem> arrayList) {
        aOj().mWt = arrayList;
    }

    public static void qA(int i) {
        aOj().mWC.put(Integer.valueOf(i), Boolean.valueOf(true));
    }

    public static void aOr() {
        aOj().mWC.clear();
    }

    public static int aOs() {
        return aOj().mWC.size();
    }

    public static void a(com.tencent.mm.plugin.gallery.stub.a aVar, int i, boolean z) {
        x.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] selectSize:%s isSendRaw:%s", Integer.valueOf(i), Boolean.valueOf(z));
        if (aVar == null) {
            x.e("MicroMsg.GalleryCore", "invoker is null");
            return;
        }
        int i2;
        int size;
        if (aOj().mWq.aOO() == 3) {
            i2 = 1;
        } else if (aOj().mWq.aOO() == 4) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        if (aOj().mWA != null) {
            size = aOj().mWA.size();
        } else {
            size = 0;
        }
        x.i("MicroMsg.GalleryCore", "[reportPhotoEdit] fromScene:%s,selectSize:%s,editSize:%s", Integer.valueOf(i2), Integer.valueOf(i), Integer.valueOf(size));
        if (size > 0) {
            aVar.ap(13858, i2 + "," + i + "," + size + ",0");
        }
        x.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] imageState:%s", Boolean.valueOf(aVar.ft(true)));
        Iterator it = aOj().mWB.iterator();
        while (it.hasNext()) {
            Bundle bundle = (Bundle) it.next();
            String string = bundle.getString("after_photo_edit");
            if (!r4) {
                x.i("MicroMsg.GalleryCore", "[handlePhotoEditInfo] delete file:%s", string);
                FileOp.deleteFile(string);
                d.b(string, ad.getContext());
            }
            int i3 = bundle.getInt("report_info_emotion_count");
            int i4 = bundle.getInt("report_info_text_count");
            int i5 = bundle.getInt("report_info_mosaic_count");
            int i6 = bundle.getInt("report_info_doodle_count");
            boolean z2 = bundle.getBoolean("report_info_iscrop");
            int i7 = bundle.getInt("report_info_undo_count");
            boolean z3 = bundle.getBoolean("report_info_is_rotation");
            String str = "MicroMsg.GalleryCore";
            String str2 = "[reportPhotoEdit] emojiCount:%s,textCount:%s,mosaicCount:%s,penCount:%s,isCrop:%s,undoCount:%s,isRotation:%s";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = Integer.valueOf(i4);
            objArr[2] = Integer.valueOf(i5);
            objArr[3] = Integer.valueOf(i6);
            objArr[4] = Integer.valueOf(z2 ? 1 : 0);
            objArr[5] = Integer.valueOf(i7);
            objArr[6] = Integer.valueOf(z3 ? 1 : 0);
            x.i(str, str2, objArr);
            if (size > 0) {
                try {
                    aVar.ap(13857, i2 + "," + z + "," + i3 + "," + i4 + "," + i5 + "," + i6 + "," + (z2 ? 1 : 0) + "," + i7 + ",2" + (z3 ? 1 : 0));
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
                }
            }
        }
    }

    public static void a(com.tencent.mm.plugin.gallery.stub.a aVar, String str, int[] iArr, boolean z, boolean z2) {
        int i = 2;
        switch (aOj().mWq.aOO()) {
            case 3:
                i = 1;
                break;
            case 4:
                if (!bi.oN(str) && str.equals(ad.getContext().getString(R.l.eeR))) {
                    i = 6;
                    break;
                }
            case 7:
            case 8:
                i = 3;
                break;
            default:
                i = 0;
                break;
        }
        x.i("MicroMsg.GalleryCore", "[handleSelectImagePreviewReport] source:%s", Integer.valueOf(r4));
        if (aVar == null) {
            x.e("MicroMsg.GalleryCore", "invoker is null");
            return;
        }
        try {
            aVar.ap(14205, i + "," + i + "," + iArr[0] + "," + iArr[1] + "," + iArr[2] + "," + iArr[3] + "," + z + "," + z2 + "," + mWw + "," + mWx + "," + mWy + "," + mWz);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.GalleryCore", e, "", new Object[0]);
        }
        mWw = false;
        mWx = false;
        mWy = false;
        mWz = false;
    }
}
