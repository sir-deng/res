package com.tencent.mm.api;

import android.content.Context;
import android.graphics.Rect;

public abstract class m {
    public static b fdT;
    public a fdS;

    public static class a {
        public int fdU;
        public boolean fdV;
        public boolean fdW;
        public String path;
        public Rect rect;

        public static class a {
            public int fdU;
            public boolean fdV;
            public boolean fdX = true;
            public Rect fdY;
            public String path;

            public final a th() {
                return new a(this.path, this.fdU, this.fdV, this.fdX, this.fdY);
            }
        }

        public a(String str, int i, boolean z, boolean z2, Rect rect) {
            this.fdU = i;
            this.path = str;
            this.fdV = z;
            this.fdW = z2;
            this.rect = rect;
        }
    }

    public interface b {
        m sV();
    }

    public enum c {
        ;

        static {
            fdZ = 1;
            fea = 2;
            feb = new int[]{fdZ, fea};
        }
    }

    public abstract void a(j jVar);

    public abstract b ai(Context context);

    public abstract void onDestroy();

    public abstract boolean sT();

    public abstract k sU();

    public void a(a aVar) {
        this.fdS = aVar;
    }
}
