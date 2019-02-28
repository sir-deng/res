package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.loader.stub.b;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.downloader.model.FileDownloadTaskInfo;
import com.tencent.mm.plugin.game.c.af;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g.a;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class g {
    public static LinkedList<f> aQD() {
        x.d("MicroMsg.GameCenterLogic", "getShowInGameCenterGames");
        LinkedList<f> linkedList = new LinkedList();
        linkedList.addAll(SubCoreGameCenter.aRQ().ngx);
        Collection linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            int i;
            f fVar = (f) it.next();
            if (fVar != null) {
                x.i("MicroMsg.GameCenterLogic", "appinfo:[%s], appinfo flag:[%d]", fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag));
                if ((fVar.field_appInfoFlag & 4) > 0) {
                    i = 1;
                    if (i == 0) {
                        x.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", fVar.field_appName);
                        linkedList2.add(fVar);
                    }
                }
            }
            i = 0;
            if (i == 0) {
                x.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", fVar.field_appName);
                linkedList2.add(fVar);
            }
        }
        if (linkedList2.size() > 0) {
            linkedList.removeAll(linkedList2);
        }
        return linkedList;
    }

    public static LinkedList<String> aQE() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(SubCoreGameCenter.aRQ().ngw);
        return linkedList;
    }

    public static void Y(Context context, final String str) {
        a(context, str, null, "WX_GameCenter", new a() {
            public final void cI(boolean z) {
                if (z) {
                    SubCoreGameCenter.aRN();
                    z.b(str, 0, 0, null, null);
                }
            }
        });
    }

    public static void a(final Context context, String str, String str2, String str3, final a aVar) {
        if (bi.oN(str)) {
            x.e("MicroMsg.GameCenterLogic", "null or nil appid");
            if (aVar != null) {
                aVar.cI(false);
            }
        }
        final f aZ = com.tencent.mm.pluginsdk.model.app.g.aZ(str, true);
        if (aZ == null || bi.oN(aZ.field_appId)) {
            x.e("MicroMsg.GameCenterLogic", "appinfo is null or appid is null");
            if (aVar != null) {
                aVar.cI(false);
            }
        } else if (p.b(context, aZ)) {
            final WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
            wXMediaMessage.sdkVer = 620823552;
            wXMediaMessage.messageAction = str2;
            wXMediaMessage.messageExt = str3;
            x.d("MicroMsg.GameCenterLogic", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", aZ.field_appId, aZ.field_appName, aZ.field_openId);
            if (bi.oN(aZ.field_openId)) {
                x.i("MicroMsg.GameCenterLogic", "open id is null or nil, try to get from server:[%s]", aZ.field_appName);
                an.biV().Pm(aZ.field_appId);
            }
            com.tencent.mm.by.a.post(new Runnable() {
                public final void run() {
                    com.tencent.mm.pluginsdk.model.app.g.a(context, aZ.field_packageName, wXMediaMessage, aZ.field_appId, aZ.field_openId, 0, aVar, null);
                }
            });
        } else {
            x.e("MicroMsg.GameCenterLogic", "The app %s signature is incorrect.", aZ.field_appName);
            Toast.makeText(context, context.getString(R.l.emB, new Object[]{com.tencent.mm.pluginsdk.model.app.g.a(context, aZ, null)}), 1).show();
            if (aVar != null) {
                aVar.cI(false);
            }
        }
    }

    public static String aQF() {
        String chi = bi.chi();
        if (bi.oN(chi)) {
            chi = "CN";
        }
        return chi.toUpperCase();
    }

    public static GameRegionPreference.a cL(Context context) {
        Object cP = cP(context);
        if (bi.oN(cP)) {
            cP = aQF();
        }
        return (GameRegionPreference.a) a.nCD.aSz().get(cP);
    }

    public static String a(GameRegionPreference.a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            String oM = bi.oM(w.cfV());
            if ("zh_CN".equalsIgnoreCase(oM)) {
                stringBuffer.append(aVar.nAi);
            } else if ("zh_TW".equalsIgnoreCase(oM) || "zh_HK".equalsIgnoreCase(oM)) {
                stringBuffer.append(aVar.nAj);
            } else {
                stringBuffer.append(aVar.nAk);
            }
        }
        return stringBuffer.toString();
    }

    public static String CA(String str) {
        String str2;
        InputStream inputStream = null;
        String str3 = "";
        try {
            inputStream = ad.getContext().getAssets().open("game_region_default.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    x.e("MicroMsg.GameCenterLogic", "exception:%s", bi.i(e));
                }
            }
        } catch (Throwable e2) {
            x.e("MicroMsg.GameCenterLogic", "exception:%s", bi.i(e2));
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str2 = str3;
                } catch (Throwable e22) {
                    x.e("MicroMsg.GameCenterLogic", "exception:%s", bi.i(e22));
                    str2 = str3;
                }
            } else {
                str2 = str3;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    x.e("MicroMsg.GameCenterLogic", "exception:%s", bi.i(e3));
                }
            }
        }
        String[] split = str2.trim().split("\\|");
        if (split.length < 3) {
            x.e("MicroMsg.GameCenterLogic", "this region default title has problem %s", str2);
            return "";
        } else if ("zh_CN".equalsIgnoreCase(str)) {
            return split[0];
        } else {
            if ("zh_TW".equalsIgnoreCase(str) || "zh_HK".equalsIgnoreCase(str)) {
                return split[1];
            }
            return split[2];
        }
    }

    public static void aQG() {
        ad.getContext().getSharedPreferences("game_center_pref", 0).edit().putString("game_center_pref_lang", w.cfV()).commit();
    }

    public static void Z(Context context, String str) {
        int i = 0;
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (bi.oN(string)) {
            sharedPreferences.edit().putString("download_app_id_time_map", str + "-" + valueOf).commit();
        } else if (string.contains(str)) {
            String str2 = new String();
            String[] split = string.split(",");
            while (i < split.length) {
                string = split[i];
                if (string.contains(str)) {
                    string = str + "-" + valueOf;
                }
                if (i == split.length - 1) {
                    str2 = str2 + string;
                } else {
                    str2 = str2 + string + ",";
                }
                i++;
            }
            sharedPreferences.edit().putString("download_app_id_time_map", str2).apply();
        } else {
            sharedPreferences.edit().putString("download_app_id_time_map", string + "," + str + "-" + valueOf).apply();
        }
    }

    public static void cM(Context context) {
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (!bi.oN(string)) {
            String[] split = string.split(",");
            String str = new String();
            string = str;
            for (String str2 : split) {
                String[] split2 = str2.split("-");
                String str3 = split2[0];
                if (!(bi.oN(str3) || com.tencent.mm.pluginsdk.model.app.g.m(context, str3))) {
                    if (currentTimeMillis - bi.getLong(split2[1], 0) < 86400) {
                        string = string + str2 + ",";
                    } else {
                        FileDownloadTaskInfo yo = com.tencent.mm.plugin.downloader.model.f.aAK().yo(str3);
                        x.i("MicroMsg.GameCenterLogic", "checkGameDownloadTime, status = %d, id = %d", Integer.valueOf(yo.status), Long.valueOf(yo.id));
                        if (yo.status == 2) {
                            com.tencent.mm.plugin.downloader.model.f.aAK().bY(yo.id);
                        } else if ((yo.status == 0 || yo.status == 4) && e.bO(yo.path)) {
                            b.deleteFile(yo.path);
                        }
                    }
                }
            }
            if (!bi.oN(string)) {
                if (string.charAt(string.length() - 1) == ',') {
                    string = string.substring(0, string.length() - 1);
                }
                sharedPreferences.edit().putString("download_app_id_time_map", string.toString()).apply();
            }
        }
    }

    public static Set<String> cN(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getStringSet("show_download_gift_tips", new HashSet());
    }

    public static ShapeDrawable cm(int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static int cO(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getInt("game_top_banner_id", 0);
    }

    public static void D(Context context, int i) {
        context.getSharedPreferences("game_center_pref", 0).edit().putInt("game_top_banner_id", i).apply();
    }

    public static int aQH() {
        af aQJ = i.aQI().aQJ();
        return aQJ != null ? aQJ.nmk : 0;
    }

    public static String cP(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getString("game_region_code", "");
    }
}
