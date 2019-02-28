package com.tencent.mm.plugin.luckymoney.f2f;

import android.content.Context;
import android.media.SoundPool;
import com.tencent.mm.sdk.platformtools.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public final class a {
    public volatile boolean kuZ = false;
    public SoundPool oex = new SoundPool(2, 3, 0);
    Hashtable<String, Integer> oey = new Hashtable();
    Map<Integer, Boolean> oez = new HashMap();

    /* renamed from: com.tencent.mm.plugin.luckymoney.f2f.a$1 */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Set oeA;
        final /* synthetic */ WeakReference oeB;

        public AnonymousClass1(Set set, WeakReference weakReference) {
            this.oeA = set;
            this.oeB = weakReference;
        }

        public final void run() {
            try {
                for (String str : this.oeA) {
                    if (this.oeB.get() == null || a.this.kuZ) {
                        x.i("AsyncSoundPool", "context = null or soundPool is stopped");
                        a.this.oex.release();
                        a.this.oey.clear();
                        a.this.oez.clear();
                        return;
                    }
                    a.this.oey.put(str, Integer.valueOf(a.this.oex.load(((Context) this.oeB.get()).getResources().getAssets().openFd(str), 0)));
                }
            } catch (Exception e) {
                x.e("AsyncSoundPool", "load sound file error:" + e.getMessage());
            }
        }
    }

    public final void ey(String str) {
        if (this.oey.containsKey(str)) {
            int intValue = ((Integer) this.oey.get(str)).intValue();
            if (intValue >= 0 && this.oez.containsKey(Integer.valueOf(intValue)) && ((Boolean) this.oez.get(Integer.valueOf(intValue))).booleanValue()) {
                this.oex.play(intValue, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        }
    }
}
