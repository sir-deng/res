package com.tencent.mm.plugin.shake.b;

import android.os.Message;
import com.tencent.mm.plugin.shake.c.a.e;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.List;

public final class l {
    protected static long qtP = 16000;
    protected static int qtQ = 54158;
    public int qtR;
    public b qtS;

    public interface a {
        void a(int i, e eVar, long j);

        void d(List<d> list, long j);
    }

    public static abstract class b {
        public a qtT;
        protected boolean qtU = false;
        protected long qtV = l.qtP;
        private ag qtW = new ag(new com.tencent.mm.sdk.platformtools.ag.a() {
            public final boolean handleMessage(Message message) {
                if (!(message.what != l.qtQ || b.this.qtU || b.this.qtT == null)) {
                    b.this.qtT.d(null, 5);
                }
                return false;
            }
        });

        public abstract void init();

        public abstract void pause();

        public abstract void reset();

        public abstract void resume();

        public abstract void start();

        public b(a aVar) {
            this.qtT = aVar;
        }

        public void brZ() {
            reset();
            this.qtT = null;
        }
    }
}
