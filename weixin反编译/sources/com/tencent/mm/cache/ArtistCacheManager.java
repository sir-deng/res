package com.tencent.mm.cache;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.x;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class ArtistCacheManager extends BroadcastReceiver {
    private static ArtistCacheManager gCV;
    public static HashMap<String, a> gCW = new HashMap();
    private static HashSet<com.tencent.mm.d.a> gCX = new HashSet();
    public String gCY;

    class a {
        public HashMap<com.tencent.mm.d.a, d> gDb = new HashMap();

        public final void clearAll() {
            for (Entry value : this.gDb.entrySet()) {
                ((d) value.getValue()).onDestroy();
            }
        }
    }

    public static ArtistCacheManager xB() {
        if (gCV == null) {
            gCV = new ArtistCacheManager();
        }
        return gCV;
    }

    public final <T extends d> T a(com.tencent.mm.d.a aVar) {
        d dVar = null;
        if (gCW.containsKey(this.gCY)) {
            a aVar2 = (a) gCW.get(this.gCY);
            if (!aVar2.gDb.containsKey(aVar)) {
                switch (aVar) {
                    case DOODLE:
                        dVar = new b();
                        break;
                    case EMOJI_AND_TEXT:
                        dVar = new c();
                        break;
                    case MOSAIC:
                        dVar = new g();
                        break;
                    case CROP_PHOTO:
                        dVar = new a();
                        break;
                }
                if (dVar != null) {
                    dVar.onCreate();
                }
                if (!(dVar == null || aVar2.gDb.containsKey(aVar))) {
                    aVar2.gDb.put(aVar, dVar);
                }
            }
            return (d) aVar2.gDb.get(aVar);
        }
        x.e("MicroMsg.ArtistCacheManager", "[getArtistCache] id is not contains! %s", this.gCY);
        return null;
    }

    @Deprecated
    public void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.ArtistCacheManager", "[onReceive]");
        if (intent != null && intent.getAction().equals("com.tencent.mm.plugin.photoedit.action.clear")) {
            x.i("MicroMsg.ArtistCacheManager", "[clearAllCache]");
            for (Entry value : gCW.entrySet()) {
                ((a) value.getValue()).clearAll();
            }
            gCX.clear();
            gCV = null;
            e.chE();
            e.post(new Runnable() {
                public final void run() {
                    com.tencent.mm.cb.a.aaW(com.tencent.mm.compatible.util.e.gJe);
                }
            }, "MicroMsg.ArtistCacheManager[clearAllCache]");
        }
    }
}
