package com.tencent.magicbrush.handler.a;

import android.graphics.Rect;
import java.util.LinkedList;
import java.util.Queue;

interface d {

    public static class a {
        public Queue<b> bnH = new LinkedList();

        public final b sE() {
            b bVar = (b) this.bnH.poll();
            if (bVar == null) {
                return new b();
            }
            return bVar;
        }

        public final void a(b bVar) {
            this.bnH.offer(bVar);
        }
    }

    public static class c {
        public int height;
        public int width;
        public int x;
        public int y;

        public final String toString() {
            return "[" + this.x + ", " + this.y + ", " + this.width + ", " + this.height + "]";
        }
    }

    public static class b {
        public int x;
        public int y;
        public int z;

        public final String toString() {
            return "[" + this.x + ", " + this.y + ", " + this.z + "]";
        }
    }

    void a(int i, int i2, Rect rect);

    void init(int i, int i2);

    void reset();
}
