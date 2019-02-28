package com.tencent.mm.plugin.game.d;

import com.tencent.mm.plugin.game.model.g;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a {
    private Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> nAm;
    public boolean nCB;
    private Map<String, Boolean> nCC;

    private static class a {
        private static a nCD = new a();
    }

    /* synthetic */ a(byte b) {
        this();
    }

    private a() {
        this.nCB = false;
        this.nCC = new ConcurrentHashMap();
    }

    public final synchronized void clearCache() {
        if (this.nAm != null) {
            this.nAm.clear();
        }
        this.nCB = false;
    }

    public final synchronized void aSx() {
        if (this.nAm != null) {
            for (com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar : this.nAm.values()) {
                aVar.nAl = false;
            }
        }
    }

    public final synchronized void aSy() {
        if (this.nAm == null) {
            this.nAm = new LinkedHashMap();
        }
        if (this.nAm.size() <= 0) {
            String str;
            InputStream inputStream = null;
            String str2 = "";
            try {
                inputStream = ad.getContext().getAssets().open("game_region_data.txt");
                byte[] bArr = new byte[inputStream.available()];
                inputStream.read(bArr);
                str = new String(bArr);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e) {
                        x.e("MicroMsg.GameCacheUtil", "exception:%s", bi.i(e));
                    }
                }
            } catch (Throwable e2) {
                x.e("MicroMsg.GameCacheUtil", "exception:%s", bi.i(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        str = str2;
                    } catch (Throwable e22) {
                        x.e("MicroMsg.GameCacheUtil", "exception:%s", bi.i(e22));
                        str = str2;
                    }
                } else {
                    str = str2;
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e3) {
                        x.e("MicroMsg.GameCacheUtil", "exception:%s", bi.i(e3));
                    }
                }
            }
            String[] split = str.trim().split("\n|\r\n|\r");
            for (String trim : split) {
                String[] split2 = trim.trim().split("\\|");
                if (split2.length < 4) {
                    x.e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", split[r0]);
                } else {
                    com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar = new com.tencent.mm.plugin.game.ui.GameRegionPreference.a();
                    aVar.nAi = split2[0];
                    aVar.nAj = split2[1];
                    aVar.nAk = split2[2];
                    aVar.fXq = split2[3];
                    aVar.nAl = false;
                    aVar.isDefault = false;
                    this.nAm.put(aVar.fXq, aVar);
                }
            }
            com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar2 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) this.nAm.get(g.aQF());
            if (aVar2 != null) {
                com.tencent.mm.plugin.game.ui.GameRegionPreference.a aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.nCD.aSz().get(g.aQF());
                StringBuffer stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.nAi);
                    stringBuffer.append(g.CA("zh_CN"));
                }
                aVar2.nAi = stringBuffer.toString();
                aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.nCD.aSz().get(g.aQF());
                stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.nAj);
                    stringBuffer.append(g.CA("zh_TW"));
                }
                aVar2.nAj = stringBuffer.toString();
                aVar3 = (com.tencent.mm.plugin.game.ui.GameRegionPreference.a) a.nCD.aSz().get(g.aQF());
                stringBuffer = new StringBuffer();
                if (aVar3 != null) {
                    stringBuffer.append(aVar3.nAk);
                    stringBuffer.append(g.CA("en"));
                }
                aVar2.nAk = stringBuffer.toString();
                aVar2.isDefault = true;
            }
        }
    }

    public final synchronized Map<String, com.tencent.mm.plugin.game.ui.GameRegionPreference.a> aSz() {
        aSy();
        return this.nAm;
    }

    public final synchronized boolean CO(String str) {
        boolean z;
        if (bi.oN(str)) {
            z = false;
        } else if (this.nCC.containsKey(str) && ((Boolean) this.nCC.get(str)).booleanValue()) {
            z = false;
        } else {
            x.i("MicroMsg.GameCacheUtil", "download entrance image start : %s", str);
            this.nCC.put(str, Boolean.valueOf(true));
            z = true;
        }
        return z;
    }

    public final synchronized void CP(String str) {
        if (!bi.oN(str) && this.nCC.containsKey(str)) {
            x.i("MicroMsg.GameCacheUtil", "download entrance image finish : %s", str);
            this.nCC.remove(str);
        }
    }
}
