package com.tencent.mm.pluginsdk.model;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.webkit.ValueCallback;
import com.tencent.mm.opensdk.constants.ConstantsAPI.WXApp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.xweb.WebView;
import com.tencent.xweb.r;
import com.tencent.xweb.util.b;
import com.tencent.xweb.x5.sdk.d;
import com.tencent.xweb.x5.sdk.f;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class x {
    private static long vkE;
    private static final Map<String, Object> vkF = new HashMap();

    public static final class a {
        private static boolean vkI = false;

        static {
            com.tencent.mm.sdk.platformtools.x.i("TBSDownloadChecker", "TRACE_ORDER:TBSHelper.java");
            r.a(ad.getContext(), new b() {
                public final void i(String str, String str2) {
                    com.tencent.mm.sdk.platformtools.x.i(str, str2);
                }

                public final void e(String str, String str2) {
                    com.tencent.mm.sdk.platformtools.x.e(str, str2);
                }

                public final void w(String str, String str2) {
                    com.tencent.mm.sdk.platformtools.x.w(str, str2);
                }

                public final void d(String str, String str2) {
                    com.tencent.mm.sdk.platformtools.x.d(str, str2);
                }

                public final void v(String str, String str2) {
                    com.tencent.mm.sdk.platformtools.x.v(str, str2);
                }
            }, null, null);
        }

        public static void eg(Context context) {
            long j;
            long currentTimeMillis;
            int i;
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "webview start check tbs");
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (!(sharedPreferences == null || bi.chp())) {
                j = sharedPreferences.getLong("last_check_xwalk", 0);
                currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j >= 1800000) {
                    Editor edit = sharedPreferences.edit();
                    edit.putLong("last_check_xwalk", currentTimeMillis);
                    edit.apply();
                    Intent intent = new Intent();
                    intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                    intent.putExtra("intent_extra_download_type", 3);
                    context.startService(intent);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download xwalk");
                }
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "user hasDownloadOverSea = %b", Boolean.valueOf(sharedPreferences.getBoolean("tbs_download_oversea", false)));
            if (sharedPreferences.getBoolean("tbs_download_oversea", false)) {
                i = 2;
            } else if (bi.chp()) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "isGPVersion, ignore this request");
                return;
            } else {
                i = 1;
            }
            if ("1".equals(sharedPreferences.getString("tbs_download", null))) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "check, tbsDownload = %s, isWifi = %b", r5, Boolean.valueOf(ao.isWifi(context)));
                if (ao.isWifi(context)) {
                    boolean z;
                    Intent intent2;
                    if (sharedPreferences == null) {
                        com.tencent.mm.sdk.platformtools.x.e("MicroMsg.TBSDownloadChecker", "sp is null");
                    } else {
                        j = sharedPreferences.getLong("last_check_ts", 0);
                        currentTimeMillis = System.currentTimeMillis();
                        if (currentTimeMillis - j > 7200000) {
                            Editor edit2 = sharedPreferences.edit();
                            edit2.putLong("last_check_ts", currentTimeMillis);
                            edit2.apply();
                            z = true;
                            if (!z) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", Integer.valueOf(WebView.getTbsCoreVersion(context)));
                                if (WebView.getTbsCoreVersion(context) > 0) {
                                    return;
                                }
                            }
                            intent2 = new Intent();
                            intent2.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                            intent2.putExtra("intent_extra_download_type", i);
                            context.startService(intent2);
                            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                            return;
                        }
                    }
                    z = false;
                    if (z) {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "check expired false, tbsCoreVersion = %d", Integer.valueOf(WebView.getTbsCoreVersion(context)));
                        if (WebView.getTbsCoreVersion(context) > 0) {
                            return;
                        }
                    }
                    intent2 = new Intent();
                    intent2.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                    intent2.putExtra("intent_extra_download_type", i);
                    context.startService(intent2);
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
                    return;
                }
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "check, net type is not wifi");
                return;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "tbsDownload switch is off, value = %s", sharedPreferences.getString("tbs_download", null));
        }

        public static void bZi() {
            if (bi.chp()) {
                com.tencent.mm.sdk.platformtools.x.d("MicroMsg.TBSDownloadChecker", "preCheck isGPVersion, ignore this request");
            } else if (f.iT(ad.getContext()) && WebView.getTbsCoreVersion(ad.getContext()) <= 0) {
                Intent intent = new Intent();
                intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
                intent.putExtra("intent_extra_download_type", 1);
                ad.getContext().startService(intent);
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            }
        }

        public static boolean bZj() {
            return f.isDownloading() || d.getTBSInstalling() || vkI;
        }

        public static void kY(boolean z) {
            vkI = z;
        }

        public static int bZk() {
            if (!bi.chp()) {
                if (d.getTbsVersion(ad.getContext()) < 36824) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d should download", Integer.valueOf(d.getTbsVersion(ad.getContext())));
                    return 1;
                } else if (d.canOpenWebPlus(ad.getContext())) {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can load x5", Integer.valueOf(r2));
                    return 0;
                } else {
                    com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "tbsCoreVersion %d can not load x5", Integer.valueOf(r2));
                    return 1;
                }
            } else if (com.tencent.mm.compatible.util.d.fO(17)) {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "is GP version can not download");
                return 2;
            } else {
                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "is GP version no need download");
                return 0;
            }
        }

        public static int bZl() {
            if (com.tencent.mm.compatible.util.d.fN(19) || com.tencent.mm.compatible.util.d.fO(16)) {
                return 1;
            }
            if (WebView.getTbsCoreVersion(ad.getContext()) > 0) {
                return 4;
            }
            if (f.isDownloading()) {
                return 2;
            }
            if (d.getTBSInstalling()) {
                return 3;
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "oversea = %b", Boolean.valueOf(ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false)));
            if (ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).getBoolean("tbs_download_oversea", false)) {
                return 2;
            }
            com.tencent.mm.sdk.platformtools.x.e("MicroMsg.TBSDownloadChecker", "WTF, how could it be?");
            return 0;
        }

        public static void eh(Context context) {
            Intent intent = new Intent();
            intent.setClassName(ad.getPackageName(), "com.tencent.mm.sandbox.updater.UpdaterService");
            intent.putExtra("intent_extra_download_type", 2);
            intent.putExtra("intent_extra_download_ignore_network_type", true);
            context.startService(intent);
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSDownloadChecker", "start UpdaterService to download tbs");
            SharedPreferences sharedPreferences = ad.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
            if (sharedPreferences != null) {
                sharedPreferences.edit().putBoolean("tbs_download_oversea", true).apply();
            }
        }
    }

    static /* synthetic */ void access$000(String str, String str2) {
        Intent intent = new Intent();
        intent.setAction("MINIQB_OPEN_RET");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSHelper", "TBS MiniQB cannot open this file:%s", str);
        intent.putExtra("MINIQB_OPEN_RET_VAL", false);
        ad.getContext().sendBroadcast(intent, WXApp.WXAPP_BROADCAST_PERMISSION);
    }

    static /* synthetic */ void bv(String str, String str2) {
        Intent intent = new Intent();
        intent.setClassName(ad.getContext(), "com.tencent.mm.pluginsdk.ui.tools.MiniQBReaderUI");
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        ad.getContext().startActivity(intent);
    }

    public static void ac(Intent intent) {
        final String stringExtra = intent.getStringExtra("file_path");
        final String stringExtra2 = intent.getStringExtra("file_ext");
        if (System.currentTimeMillis() - vkE >= 1000 && !bi.oN(stringExtra)) {
            vkE = System.currentTimeMillis();
            final Context context = ad.getContext();
            String str = "";
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.putOpt("path", stringExtra);
                jSONObject.putOpt("ext", stringExtra2);
                str = jSONObject.toString();
            } catch (Throwable e) {
                com.tencent.mm.sdk.platformtools.x.printErrStackTrace("MicroMsg.TBSHelper", e, "", new Object[0]);
            }
            com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSHelper", "openFileByMiniQB, file pathinfo:%s", str);
            d.a(context, str, new ValueCallback<Boolean>() {
                public final /* synthetic */ void onReceiveValue(Object obj) {
                    if (!((Boolean) obj).booleanValue()) {
                        x.access$000(stringExtra, stringExtra2);
                    } else if (d.isTbsCoreInited()) {
                        x.bv(stringExtra, stringExtra2);
                    } else {
                        com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSHelper", "tbs preInit");
                        d.a(context, new com.tencent.xweb.x5.sdk.d.a() {
                            public final void kX(boolean z) {
                                com.tencent.mm.sdk.platformtools.x.i("MicroMsg.TBSHelper", "tbs preInit callback, %b", Boolean.valueOf(z));
                                if (z) {
                                    x.bv(stringExtra, stringExtra2);
                                } else {
                                    x.access$000(stringExtra, stringExtra2);
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public static void u(String str, Object obj) {
        vkF.put(str, obj);
        d.initTbsSettings(vkF);
    }
}
