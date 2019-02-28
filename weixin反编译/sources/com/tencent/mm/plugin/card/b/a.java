package com.tencent.mm.plugin.card.b;

import com.tencent.mm.a.e;
import com.tencent.mm.modelcdntran.b;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.modelcdntran.i;
import com.tencent.mm.modelcdntran.keep_ProgressInfo;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static List<WeakReference<a>> kOg = new ArrayList();

    public interface a {
        void aY(String str, int i);

        void cb(String str, String str2);

        void fail(String str);
    }

    public static void a(a aVar) {
        if (kOg == null) {
            kOg = new ArrayList();
        }
        if (aVar == null) {
            x.e("MicroMsg.CDNDownloadHelpper", "ICDNDownloadCallback is null");
            return;
        }
        x.i("MicroMsg.CDNDownloadHelpper", "register:%d", Integer.valueOf(aVar.hashCode()));
        kOg.add(new WeakReference(aVar));
    }

    public static void b(a aVar) {
        int i = 0;
        if (kOg != null && aVar != null) {
            x.i("MicroMsg.CDNDownloadHelpper", "unregister:%d", Integer.valueOf(aVar.hashCode()));
            while (true) {
                int i2 = i;
                if (i2 < kOg.size()) {
                    WeakReference weakReference = (WeakReference) kOg.get(i2);
                    if (weakReference != null) {
                        a aVar2 = (a) weakReference.get();
                        if (aVar2 != null && aVar2.equals(aVar)) {
                            kOg.remove(weakReference);
                            return;
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public static void h(final String str, String str2, int i, int i2) {
        int i3 = 0;
        if (str == null || str2 == null || i == 0) {
            x.e("MicroMsg.CDNDownloadHelpper", "the params is wrongful");
            return;
        }
        String str3;
        String VF = ac.VF(str);
        File file = new File(m.kRp);
        if (!file.mkdirs()) {
            x.i("MicroMsg.CDNDownloadHelpper", "mkdirs failed.File is exist = " + file.exists());
        }
        String str4 = i2 == 2 ? ".jpeg" : ".mp4";
        if (file.getAbsolutePath().endsWith("/")) {
            str3 = file.getAbsolutePath() + VF + str4;
        } else {
            str3 = file.getAbsolutePath() + File.separator + VF + str4;
        }
        x.i("MicroMsg.CDNDownloadHelpper", "get file path from capture file name : %s == %s", VF, str3);
        x.i("MicroMsg.CDNDownloadHelpper", "before downloadVideoFromCDN fieldId:%s, aseKey:%s, dataLength:%d, type:%d, filePath:%s", str, str2, Integer.valueOf(i), Integer.valueOf(i2), str3);
        x.i("MicroMsg.CDNDownloadHelpper", "read file length = " + e.bN(str3));
        WeakReference weakReference;
        a aVar;
        if (e.bO(str3) && e.bN(str3) == i) {
            while (i3 < kOg.size()) {
                weakReference = (WeakReference) kOg.get(i3);
                if (weakReference != null) {
                    aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.cb(str, str3);
                    }
                }
                i3++;
            }
            return;
        }
        x.i("MicroMsg.CDNDownloadHelpper", "filePath:%s is't exist, so download from CDN", str3);
        i iVar = new i();
        iVar.hve = new com.tencent.mm.modelcdntran.i.a() {
            public final int a(String str, int i, keep_ProgressInfo keep_progressinfo, keep_SceneResult keep_sceneresult, boolean z) {
                int i2;
                WeakReference weakReference;
                a aVar;
                if (i == -21005) {
                    x.i("MicroMsg.CDNDownloadHelpper", "duplicate request, ignore this request, media id is %s", str);
                } else if (i != 0) {
                    x.e("MicroMsg.CDNDownloadHelpper", "start failed : %d, media id is :%s", Integer.valueOf(i), str);
                    for (i2 = 0; i2 < a.kOg.size(); i2++) {
                        weakReference = (WeakReference) a.kOg.get(i2);
                        if (weakReference != null) {
                            aVar = (a) weakReference.get();
                            if (aVar != null) {
                                aVar.fail(str);
                            }
                        }
                    }
                } else if (keep_progressinfo != null) {
                    x.i("MicroMsg.CDNDownloadHelpper", "progressInfo : %s", keep_progressinfo.toString());
                    if (keep_progressinfo.field_toltalLength > 0) {
                        i2 = (keep_progressinfo.field_finishedLength * 100) / keep_progressinfo.field_toltalLength;
                    } else {
                        i2 = 0;
                    }
                    if (i2 < 0) {
                        i2 = 0;
                    } else if (i2 > 100) {
                        i2 = 100;
                    }
                    for (int i3 = 0; i3 < a.kOg.size(); i3++) {
                        weakReference = (WeakReference) a.kOg.get(i3);
                        if (weakReference != null) {
                            aVar = (a) weakReference.get();
                            if (aVar != null) {
                                aVar.aY(str, i2);
                            }
                        }
                    }
                } else if (keep_sceneresult != null) {
                    if (keep_sceneresult.field_retCode != 0) {
                        x.e("MicroMsg.CDNDownloadHelpper", "cdntra clientid:%s , sceneResult.retCode:%d , sceneResult[%s]", str, Integer.valueOf(keep_sceneresult.field_retCode), keep_sceneresult);
                        for (i2 = 0; i2 < a.kOg.size(); i2++) {
                            weakReference = (WeakReference) a.kOg.get(i2);
                            if (weakReference != null) {
                                aVar = (a) weakReference.get();
                                if (aVar != null) {
                                    aVar.fail(str);
                                }
                            }
                        }
                    } else {
                        x.i("MicroMsg.CDNDownloadHelpper", "cdn trans suceess, sceneResult[%s]", keep_sceneresult);
                        for (i2 = 0; i2 < a.kOg.size(); i2++) {
                            weakReference = (WeakReference) a.kOg.get(i2);
                            if (weakReference != null) {
                                aVar = (a) weakReference.get();
                                if (aVar != null) {
                                    aVar.cb(str, str3);
                                }
                            }
                        }
                    }
                }
                return 0;
            }

            public final void a(String str, ByteArrayOutputStream byteArrayOutputStream) {
                x.i("MicroMsg.CDNDownloadHelpper", "getCdnAuthInfo, mediaId = %s", str);
            }

            public final byte[] h(String str, byte[] bArr) {
                x.i("MicroMsg.CDNDownloadHelpper", "decodePrepareResponse, mediaId = %s", str);
                return null;
            }
        };
        iVar.fMC = false;
        iVar.field_mediaId = d.a("cardgiftfile", bi.Wy(), str, str);
        iVar.field_fullpath = str3;
        iVar.field_totalLen = i;
        iVar.field_fileType = b.hty;
        iVar.field_fileId = str;
        iVar.field_aesKey = str2;
        iVar.field_priority = b.htu;
        iVar.field_needStorage = true;
        x.i("MicroMsg.CDNDownloadHelpper", "add download cdn task : %b, fileId : %s", Boolean.valueOf(g.MP().b(iVar, -1)), iVar.field_fileId);
        if (!g.MP().b(iVar, -1)) {
            while (i3 < kOg.size()) {
                weakReference = (WeakReference) kOg.get(i3);
                if (weakReference != null) {
                    aVar = (a) weakReference.get();
                    if (aVar != null) {
                        aVar.fail(str);
                    }
                }
                i3++;
            }
            x.e("MicroMsg.CDNDownloadHelpper", "can't download from cdn!!!");
        }
    }
}
