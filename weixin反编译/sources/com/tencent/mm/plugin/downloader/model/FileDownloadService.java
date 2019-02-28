package com.tencent.mm.plugin.downloader.model;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.a.e;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.plugin.downloader.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.File;

public class FileDownloadService extends IntentService {
    public static final String EXTRA_ID = (lyq + SlookAirButtonFrequentContactAdapter.ID);
    public static final String EXTRA_PACKAGE_NAME = (lyq + "package_name");
    private static final String lyq = (FileDownloadService.class.getSimpleName() + "_extra_");
    public static final String lyr = (lyq + "action_type");
    public static final String lys = (lyq + "file_path");
    public static final String lyt = (lyq + "md5");
    public static final String lyu = (lyq + "change_url");

    public FileDownloadService() {
        super("FileDownloadService");
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            x.i("MicroMsg.FileDownloadService", "handle intent type : %d", Integer.valueOf(intent.getIntExtra(lyr, 0)));
            String str;
            String str2;
            switch (intent.getIntExtra(lyr, 0)) {
                case 1:
                    long longExtra = intent.getLongExtra(EXTRA_ID, -1);
                    boolean booleanExtra = intent.getBooleanExtra(lyu, false);
                    if (longExtra < 0) {
                        x.e("MicroMsg.FileDownloadService", "Invalid id");
                        return;
                    }
                    if (g.Do().CF()) {
                        g.Do();
                        if (!a.Cz()) {
                            com.tencent.mm.plugin.downloader.e.a cf = e.cf(longExtra);
                            if (cf != null) {
                                x.i("MicroMsg.FileDownloadService", "filePath = " + cf.field_filePath);
                                if (bi.oN(cf.field_filePath) || !e.bO(cf.field_filePath)) {
                                    com.tencent.mm.plugin.report.service.g.pWK.a(710, 5, 1, false);
                                    x.i("MicroMsg.FileDownloadService", "file not exists, appid = " + cf.field_appId);
                                    return;
                                } else if (bi.oN(cf.field_md5)) {
                                    x.i("MicroMsg.FileDownloadService", "Invalid original md5, abort checking");
                                    cf.field_status = 3;
                                    e.c(cf);
                                    f.aAK().i(longExtra, booleanExtra);
                                    return;
                                } else if (ck(cf.field_filePath, cf.field_md5)) {
                                    cf.field_status = 3;
                                    e.c(cf);
                                    f.aAK().i(longExtra, booleanExtra);
                                    return;
                                } else {
                                    str = "";
                                    try {
                                        str = n.x(new File(cf.field_filePath));
                                    } catch (Exception e) {
                                        x.e("MicroMsg.FileDownloadService", "readChannelId exception : " + e.getMessage());
                                    }
                                    cf.field_status = 4;
                                    cf.field_channelId = str;
                                    cf.field_errCode = d.lxL;
                                    cf.field_downloadedSize = (long) e.bN(cf.field_filePath);
                                    e.c(cf);
                                    x.i("MicroMsg.FileDownloadService", "ChannelId = %s, receivedSize = %d, fileSize = %d", str, Long.valueOf(cf.field_downloadedSize), Integer.valueOf(e.bN(cf.field_filePath)));
                                    b.deleteFile(cf.field_filePath);
                                    if (!ao.isWifi((Context) this) || booleanExtra || bi.oN(cf.field_secondaryUrl) || cf.field_downloaderType == 3) {
                                        f aAK = f.aAK();
                                        com.tencent.mm.plugin.downloader.e.a cf2 = e.cf(longExtra);
                                        if (cf2 != null) {
                                            Context context = ad.getContext();
                                            if (cf2.field_showNotification && bi.oN(cf2.field_fileName)) {
                                                str2 = cf2.field_downloadUrl;
                                                f.a(context.getString(c.lwO), "", null);
                                            } else if (cf2.field_showNotification && !bi.oN(cf2.field_fileName)) {
                                                String str3 = cf2.field_downloadUrl;
                                                f.a(cf2.field_fileName, context.getString(c.lwO), null);
                                            }
                                            aAK.lya.b(longExtra, d.lxL, booleanExtra);
                                            return;
                                        }
                                        return;
                                    }
                                    g.a aVar = new g.a();
                                    aVar.yr(cf.field_secondaryUrl);
                                    aVar.cj(cf.field_fileSize);
                                    aVar.yt(cf.field_fileName);
                                    aVar.setAppId(cf.field_appId);
                                    aVar.yu(cf.field_md5);
                                    aVar.et(true);
                                    aVar.oP(1);
                                    aVar.cu(cf.field_packageName);
                                    x.i("MicroMsg.FileDownloadService", "MD5 check failed, restart download, id = " + f.aAK().a(aVar.lyp));
                                    return;
                                }
                            }
                            return;
                        }
                    }
                    x.d("MicroMsg.FileDownloadService", "no user login");
                    return;
                case 3:
                    str = intent.getStringExtra(lys);
                    str2 = intent.getStringExtra(lyt);
                    if (bi.oN(str) || !e.bO(str)) {
                        x.i("MicroMsg.FileDownloadService", "Invalid file path, ignored");
                        return;
                    } else if (bi.oN(str2) || ck(str, str2)) {
                        Uri fromFile = Uri.fromFile(new File(str));
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.setDataAndType(fromFile, "application/vnd.android.package-archive");
                        intent2.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                        startActivity(intent2);
                        return;
                    } else {
                        return;
                    }
                default:
                    return;
            }
        }
    }

    private static boolean ck(String str, String str2) {
        File file = new File(str);
        x.i("MicroMsg.FileDownloadService", "MD5 Check: %s, File Exists: %b", str, Boolean.valueOf(file.exists()));
        long currentTimeMillis = System.currentTimeMillis();
        String i = com.tencent.mm.a.g.i(file);
        x.i("MicroMsg.FileDownloadService", "MD5 Check Time: %d", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        x.i("MicroMsg.FileDownloadService", "Original MD5: %s, Calculated MD5: %s", str2, i);
        if (bi.oN(str2)) {
            return file.exists();
        }
        if (!bi.oN(i)) {
            return str2.equalsIgnoreCase(i);
        }
        x.i("MicroMsg.FileDownloadService", "check from file failed, may caused by low memory while checking md5");
        return file.exists();
    }
}
