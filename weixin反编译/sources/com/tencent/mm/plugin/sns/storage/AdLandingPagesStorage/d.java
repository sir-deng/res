package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.File;

public final class d {

    public interface b {
        void LE(String str);

        void LF(String str);
    }

    public interface a {
        void LD(String str);

        void bxM();

        void bxN();
    }

    public static String ep(String str, String str2) {
        return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_img_" + ac.VF(str2);
    }

    public static String eq(String str, String str2) {
        FileOp.ml(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        return Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages/" + str + "_sight_" + ac.VF(str2);
    }

    public static Bitmap er(String str, String str2) {
        if (bi.oN(str2) || bi.oN(str)) {
            return null;
        }
        try {
            String ep = ep(str, str2);
            if (TextUtils.isEmpty(ep) || !new File(ep).exists()) {
                return null;
            }
            return MMBitmapFactory.decodeFile(ep);
        } catch (Throwable e) {
            x.e("AdLandingPagesDownloadResourceHelper", "%s", bi.i(e));
            return null;
        }
    }

    public static void a(String str, int i, a aVar) {
        a("adId", str, false, i, 0, aVar);
    }

    public static void a(final String str, final String str2, boolean z, int i, int i2, final a aVar) {
        if (bi.oN(str2) || bi.oN(str)) {
            aVar.bxN();
            return;
        }
        x.i("AdLandingPagesDownloadResourceHelper", "start download img for " + str2 + " for adid:" + str);
        final String ep = ep(str, str2);
        new b(ep, z, i, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.b.a() {
            public final void bxM() {
                ah.y(new Runnable() {
                    public final void run() {
                        aVar.bxM();
                    }
                });
            }

            public final void bxN() {
                x.e("AdLandingPagesDownloadResourceHelper", " download error img for " + str2 + " for adid:" + str);
                ah.y(new Runnable() {
                    public final void run() {
                        aVar.bxN();
                    }
                });
            }

            public final void byw() {
                x.i("AdLandingPagesDownloadResourceHelper", " download success img for " + str2 + " for adid:" + str);
                ah.y(new Runnable() {
                    public final void run() {
                        aVar.LD(ep);
                    }
                });
            }
        }).execute(new String[]{str2});
    }

    public static void a(final String str, final String str2, boolean z, int i, final a aVar) {
        FileOp.ml(Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages");
        ac.VF(str2);
        final String eq = eq(str, str2);
        if (FileOp.bO(eq)) {
            ah.y(new Runnable() {
                public final void run() {
                    aVar.LD(eq);
                }
            });
            return;
        }
        x.i("AdLandingPagesDownloadResourceHelper", "start download sight for " + str2 + " for adid:" + str);
        new b(eq, z, i, 0, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.b.a() {
            public final void bxM() {
                ah.y(new Runnable() {
                    public final void run() {
                        aVar.bxM();
                    }
                });
            }

            public final void bxN() {
                x.e("AdLandingPagesDownloadResourceHelper", " download error sight for " + str2 + " for adid:" + str);
                ah.y(new Runnable() {
                    public final void run() {
                        aVar.bxN();
                    }
                });
            }

            public final void byw() {
                x.i("AdLandingPagesDownloadResourceHelper", " download success sight for " + str2 + " for adid:" + str);
                ah.y(new Runnable() {
                    public final void run() {
                        aVar.LD(eq);
                    }
                });
            }
        }).execute(new String[]{str2});
    }

    public static void a(final String str, final String str2, boolean z, int i, final b bVar) {
        if (bi.oN(str2) || bi.oN(str)) {
            bVar.LE("the res or adId is null");
            return;
        }
        ep(str, str2);
        String str3 = Environment.getExternalStorageDirectory().toString() + "/tencent/MicroMsg/sns_ad_landingpages";
        String str4 = str + "_stream_" + ac.VF(str2);
        x.i("AdLandingPagesDownloadResourceHelper", "start download video for " + str2 + " for adid:" + str);
        new ad(str3, str4, z, i, 0, new ag(Looper.getMainLooper()), new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.ad.a() {
            public final void ci(final String str, final int i) {
                ah.y(new Runnable() {
                    public final void run() {
                    }
                });
            }

            public final void LE(final String str) {
                x.e("AdLandingPagesDownloadResourceHelper", " download error video for " + str2 + " for adid:" + str);
                ah.y(new Runnable() {
                    public final void run() {
                        bVar.LE(str);
                    }
                });
            }

            public final void LF(final String str) {
                x.i("AdLandingPagesDownloadResourceHelper", " download success video for " + str2 + " for adid:" + str);
                ah.y(new Runnable() {
                    public final void run() {
                        bVar.LF(str);
                    }
                });
            }
        }).execute(new String[]{str2});
    }
}
