package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.i.a.b.b.b;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.o;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.pluginsdk.i.a.e.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class h implements com.tencent.mm.pluginsdk.i.a.d.h {
    h() {
    }

    public final void a(q qVar, int i) {
        if (qVar.field_expireTime != 0 && qVar.field_expireTime <= bi.Wx()) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "urlKey(%s) exceed expire time(%d), delete", qVar.field_urlKey, Long.valueOf(qVar.field_expireTime));
            o cap = a.voG;
            String str = qVar.field_urlKey;
            if (cap.jbr) {
                cap.voD.iI(str);
            }
            a.SF(qVar.field_filePath);
            a.SF(qVar.field_filePath + ".decompressed");
            a.SF(qVar.field_filePath + ".decrypted");
            a.voG.SD(qVar.field_urlKey);
        } else if (i == 0) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network unavailable, skip");
        } else if (2 == i && 1 == qVar.field_networkType) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "network type = gprs, record network type = wifi, skip this ");
        } else if (qVar.field_deleted) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record(%s), should have been deleted", qVar.field_urlKey);
            a.SF(qVar.field_filePath);
            a.SF(qVar.field_filePath + ".decompressed");
            a.SF(qVar.field_filePath + ".decrypted");
        } else if (qVar.field_status == 2) {
            long GW = a.GW(qVar.field_filePath);
            if (qVar.field_contentLength > GW) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "content-length > fileSize, resume download");
                if (0 == GW) {
                    if (!qVar.field_needRetry) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(qVar.field_resType), Integer.valueOf(qVar.field_subType), qVar.field_fileVersion);
                        return;
                    } else if (1 != i) {
                        x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "fileSize = 0, completed file may be deleted by user, skip this because it's not wifi");
                        return;
                    } else {
                        for (b bVar : c.vnr.bZX()) {
                            int i2 = qVar.field_resType;
                            i2 = qVar.field_subType;
                            bi.getInt(qVar.field_fileVersion, 0);
                            if (bVar.bZY()) {
                                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "filterNotRetry by %s, resType %d, subType %d, version %s", bVar.getClass().getName(), Integer.valueOf(qVar.field_resType), Integer.valueOf(qVar.field_subType), qVar.field_fileVersion);
                                return;
                            }
                        }
                        qVar.field_fileUpdated = true;
                        c.vnr.f(qVar.field_resType, qVar.field_subType, 0, bi.oM(qVar.field_groupId2).equals("NewXml"));
                        a.voG.g(qVar);
                    }
                }
                a.voG.d(c.c(qVar));
            } else if (d(qVar)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 check ok, file download complete, throw event to do decrypt");
                e(qVar);
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
                a(qVar, 1 == i);
            }
        } else if (qVar.field_status == 1 || qVar.field_status == 0) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "db status: downloading or waiting, db content-length %d", Long.valueOf(qVar.field_contentLength));
            if (a.voG.SC(qVar.field_urlKey)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "request already in downloading queue");
                return;
            }
            x.d("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "check md5");
            if (d(qVar)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 match, request complete, throw event to do decrypt");
                qVar.field_status = 2;
                qVar.field_contentLength = a.GW(qVar.field_filePath);
                a.voG.g(qVar);
                e(qVar);
                return;
            }
            if (0 == a.GW(qVar.field_filePath)) {
                qVar.field_fileUpdated = true;
                a.voG.g(qVar);
                c.vnr.f(qVar.field_resType, qVar.field_subType, 0, bi.oM(qVar.field_groupId2).equals("NewXml"));
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "md5 not match,  download");
            a.voG.d(c.c(qVar));
        } else if (qVar.field_status == 4 || qVar.field_status == 3) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "file invalid, re-download");
            qVar.field_status = 0;
            a(qVar, true);
        }
    }

    private static boolean d(q qVar) {
        return bi.oM(g.bV(qVar.field_filePath)).equals(qVar.field_md5);
    }

    private static void a(q qVar, boolean z) {
        a.voG.SD(qVar.field_urlKey);
        a.SF(qVar.field_filePath);
        a.SF(qVar.field_filePath + ".decompressed");
        a.SF(qVar.field_filePath + ".decrypted");
        if (2 == qVar.field_status && !z) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "delete completed but invalid file, but forceDL = false, skip this downloading");
        } else if (qVar.field_maxRetryTimes <= 0 || qVar.field_retryTimes > 0) {
            qVar.field_retryTimes--;
            qVar.field_fileUpdated = true;
            a.voG.g(qVar);
            j.o(qVar.field_reportId, 12);
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "post network task");
            k c = c.c(qVar);
            c.ttd = false;
            a.voG.d(c);
        } else {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip ", Integer.valueOf(qVar.field_maxRetryTimes), Integer.valueOf(qVar.field_retryTimes));
        }
    }

    private static void e(q qVar) {
        if (qVar.field_fileUpdated) {
            j.o(qVar.field_reportId, 13);
            j.o(qVar.field_reportId, 44);
        }
        if (qVar.field_fileCompress || qVar.field_fileEncrypt) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateResumeRecordHandler", "send query and decrypt request");
            c.vnr.b(qVar);
            return;
        }
        c.vnr.b(qVar.field_resType, qVar.field_subType, qVar.field_filePath, bi.getInt(qVar.field_fileVersion, 0));
    }
}
