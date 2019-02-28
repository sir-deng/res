package com.tencent.mm.pluginsdk.i.a.b;

import com.tencent.mm.a.g;
import com.tencent.mm.pluginsdk.i.a.d.k;
import com.tencent.mm.pluginsdk.i.a.d.q;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

final class f {

    private static final class a {
        static void a(q qVar, g gVar) {
            if (qVar == null) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record is null");
            } else {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record: urlKey = %s, url = %s, contentLength = %d, deleted = %b, eccSignature = %s, expireTime = %d, fileCompress = %b, fileEncrypt = %b, filePath = %s, fileUpdated = %b, fileVersion = %s, from = %s, keyVersion = %s, (encryptKey == null) = %b, maxRetryTimes = %d, retriedTimes = %d, sampleId = %s, dlStatus = %d", qVar.field_urlKey, qVar.field_url, Long.valueOf(qVar.field_contentLength), Boolean.valueOf(qVar.field_deleted), qVar.field_eccSignature, Long.valueOf(qVar.field_expireTime), Boolean.valueOf(qVar.field_fileCompress), Boolean.valueOf(qVar.field_fileEncrypt), qVar.field_filePath, Boolean.valueOf(qVar.field_fileUpdated), qVar.field_fileVersion, qVar.field_groupId2, Integer.valueOf(qVar.field_keyVersion), Boolean.valueOf(bi.oN(qVar.field_encryptKey)), Integer.valueOf(qVar.field_maxRetryTimes), Integer.valueOf(qVar.field_retryTimes), qVar.field_sampleId, Integer.valueOf(qVar.field_status));
                x.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "queried record.encryptKey = %s", qVar.field_encryptKey);
            }
            q cab;
            if (qVar != null && qVar.field_deleted && gVar.Sv(qVar.field_fileVersion) <= 0) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "deletedFile.version = %s, cacheReq.version = %s, this file should have been deleted, skip this cache-op", qVar.field_fileVersion, gVar.vof);
            } else if (qVar == null) {
                cab = gVar.cab();
                cab.field_fileUpdated = true;
                cab.field_needRetry = true;
                if (bi.oN(cab.field_encryptKey)) {
                    cab.field_keyVersion = -1;
                }
                x.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new record " + cab);
                a.voG.g(cab);
                c.vnr.f(gVar.fqg, gVar.fqh, 0, gVar.fqn);
                a(true, true, cab, gVar);
            } else {
                x.d("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record is not null");
                qVar.field_networkType = gVar.networkType;
                if (bi.oN(qVar.field_originalMd5)) {
                    qVar.field_originalMd5 = gVar.vmQ;
                }
                if (gVar.Sv(qVar.field_fileVersion) > 0) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "new version of file, re-download");
                    cab = gVar.cab();
                    if (qVar.field_keyVersion >= gVar.vmO) {
                        cab.field_keyVersion = qVar.field_keyVersion;
                        cab.field_encryptKey = qVar.field_encryptKey;
                    }
                    cab.field_fileUpdated = true;
                    cab.field_needRetry = true;
                    cab.field_deleted = false;
                    a.voG.g(cab);
                    c.vnr.f(gVar.fqg, gVar.fqh, 0, gVar.fqn);
                    a.voG.SD(gVar.vmK);
                    a(false, true, cab, gVar);
                } else if (gVar.Sv(qVar.field_fileVersion) != 0 || qVar.field_needRetry) {
                    if (qVar.field_status == 2 || qVar.field_status == 1 || qVar.field_status == 0) {
                        long GW = com.tencent.mm.pluginsdk.i.a.e.a.GW(qVar.field_filePath);
                        if (qVar.field_contentLength > GW) {
                            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "content-length(%d) > fileSize(%d), resume download", Long.valueOf(qVar.field_contentLength), Long.valueOf(GW));
                            if (0 == GW) {
                                c.vnr.f(gVar.fqg, gVar.fqh, 0, gVar.fqn);
                                a(false, true, qVar, gVar);
                                return;
                            }
                            a(true, false, qVar, gVar);
                            return;
                        } else if (bi.oM(g.bV(i.Sw(gVar.vmK))).equals(qVar.field_md5)) {
                            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "md5 check ok, file download complete, throw event to do decrypt");
                            qVar.field_status = 2;
                            qVar.field_contentLength = com.tencent.mm.pluginsdk.i.a.e.a.GW(qVar.field_filePath);
                            qVar.field_fileUpdated = false;
                            a.voG.g(qVar);
                            j.o(qVar.field_reportId, 13);
                            j.o(qVar.field_reportId, 44);
                            j.a(qVar.field_resType, qVar.field_subType, qVar.field_url, bi.getInt(qVar.field_fileVersion, 0), com.tencent.mm.pluginsdk.i.a.b.j.a.vnO, true, "NewXml".equalsIgnoreCase(qVar.field_groupId2), true, qVar.field_sampleId);
                            if (gVar.vnt || gVar.vnu) {
                                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "send query and decrypt request");
                                b.a(qVar, false, false);
                                return;
                            }
                            c.vnr.b(gVar.fqg, gVar.fqh, i.Sw(gVar.vmK), bi.getInt(gVar.vof, 0));
                            return;
                        }
                    } else if (!(qVar.field_status == 4 || qVar.field_status == 3)) {
                        return;
                    }
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "file invalid, re-download");
                    a(false, true, qVar, gVar);
                } else {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "no need retry, resType %d, subType %d, version %s", Integer.valueOf(qVar.field_resType), Integer.valueOf(qVar.field_subType), qVar.field_fileVersion);
                }
            }
        }

        private static void a(boolean z, boolean z2, q qVar, g gVar) {
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "sendIORequest, fileAppend = %b, fileUpdate = %b", Boolean.valueOf(z), Boolean.valueOf(z2));
            if (qVar.field_maxRetryTimes <= 0 || qVar.field_retryTimes > 0 || z2) {
                qVar.field_status = 0;
                if (z2) {
                    qVar.field_maxRetryTimes = gVar.vmU;
                    qVar.field_retryTimes = gVar.vmU;
                    qVar.field_fileUpdated = true;
                    qVar.field_priority = gVar.priority;
                    if (gVar.fileSize > 0) {
                        qVar.field_fileSize = gVar.fileSize;
                    }
                    a.voG.g(qVar);
                } else {
                    qVar.field_retryTimes--;
                    qVar.field_priority = gVar.priority;
                    a.voG.g(qVar);
                    j.o(qVar.field_reportId, 12);
                }
                if (a.voG.SC(gVar.vmK)) {
                    x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s is already downloading", gVar.vmK);
                    if (gVar.fqn) {
                        j.o(gVar.vmS, 9);
                        j.o(gVar.vmS, 44);
                        return;
                    }
                    return;
                }
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "urlKey = %s, post network task", gVar.vmK);
                if (z2 && !z) {
                    c.vnr.f(qVar.field_resType, qVar.field_subType, 0, bi.oM(qVar.field_groupId2).equals("NewXml"));
                }
                k c = c.c(qVar);
                c.ttd = z;
                c.vns = gVar.vns;
                if (!z) {
                    com.tencent.mm.pluginsdk.i.a.e.a.SF(i.Sw(c.vmK));
                    com.tencent.mm.pluginsdk.i.a.e.a.SF(i.Sw(c.vmK) + ".decompressed");
                    com.tencent.mm.pluginsdk.i.a.e.a.SF(i.Sw(c.vmK) + ".decrypted");
                }
                a.voG.d(c);
                return;
            }
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoCacheLogic", "record_maxRetryTimes = %d, record_retryTimes = %d, retry times out, skip", Integer.valueOf(qVar.field_maxRetryTimes), Integer.valueOf(qVar.field_retryTimes));
        }
    }

    static final class b {
        static void a(q qVar, boolean z, boolean z2) {
            if (qVar == null) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "get null record, skip");
                return;
            }
            String str = qVar.field_urlKey;
            String str2 = qVar.field_filePath;
            String str3 = qVar.field_md5;
            boolean z3 = qVar.field_fileCompress;
            boolean z4 = qVar.field_fileEncrypt;
            Object obj = qVar.field_eccSignature;
            int i = bi.getInt(qVar.field_fileVersion, 0);
            int i2 = qVar.field_keyVersion;
            String str4 = qVar.field_encryptKey;
            boolean z5 = qVar.field_deleted;
            x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried info: deleted = " + z5 + ", filePath = " + str2 + ", md5 = " + str3 + ", originalMd5 = " + qVar.field_originalMd5 + ", fileCompress = " + z3 + ", fileEncrypt = " + z4 + ", eccSignature = " + obj + ", fileVersion = " + i + ", (encrypt key == empty) = " + bi.oN(str4));
            x.d("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "queried encryptKey = %s", str4);
            if (!z4) {
                if (z) {
                    j.o(qVar.field_reportId, 53);
                    j.o(qVar.field_reportId, 45);
                }
                if (!z3) {
                    x.e("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file is not encrypted nor compressed, just return");
                    return;
                }
            }
            if (i2 != i && z4) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "file version(%d) != key version(%d), skip", Integer.valueOf(i), Integer.valueOf(i2));
                if (i2 >= 0) {
                    j.o(qVar.field_reportId, 52);
                    j.o(qVar.field_reportId, 45);
                }
            } else if (z5) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this file should have been deleted, skip this decrypt-op");
                j.o(qVar.field_reportId, 51);
                j.o(qVar.field_reportId, 45);
            } else if (bi.oN(str4) && z4) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "encryptKey invalid, skip");
                j.o(qVar.field_reportId, 54);
                j.o(qVar.field_reportId, 45);
            } else if (bi.oN(str3) || bi.oN(str2)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "this decrypt-op is invalid, record.md5 = %s, record.filePath = %s", str3, str2);
            } else if (a.voG.SC(str)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request(%s) is downloading or queueing, hold this decrypt-op", str);
            } else if (!bi.oM(g.bV(str2)).equals(str3)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "md5 not match, file spoiled, skip this decrypt-op");
                qVar.field_status = 3;
                a.voG.g(qVar);
                j.o(qVar.field_reportId, 56);
                j.o(qVar.field_reportId, 45);
            } else if (!a.voG.SC(str)) {
                x.i("MicroMsg.ResDownloader.CheckResUpdate.DoDecryptLogic", "request supposed to complete, send decrypt request");
                c.vnr.f(qVar.field_resType, qVar.field_subType, 1, bi.oM(qVar.field_groupId2).equals("NewXml"));
                if (z2) {
                    c.vnr;
                    x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "performDecryptDirectly, urlkey %s", qVar.field_urlKey);
                    k.f(qVar);
                    return;
                }
                c.vnr.b(qVar);
            }
        }
    }
}
