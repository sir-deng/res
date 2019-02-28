package com.tencent.mm.plugin.y.a;

import android.database.Cursor;
import android.graphics.Bitmap;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.i;
import java.util.LinkedList;

public interface a {

    public static class a {
        private static a pft = null;

        public static void a(a aVar) {
            pft = aVar;
        }

        public static a biY() {
            return pft;
        }
    }

    f HL(String str);

    void HM(String str);

    Bitmap a(String str, int i, float f);

    void aa(LinkedList<String> linkedList);

    void bU(String str, int i);

    i biW();

    Cursor biX();

    void c(f fVar);

    void d(f fVar);

    Cursor dj(int i, int i2);

    void e(f fVar);

    Cursor k(int[] iArr);

    Cursor uN(int i);
}
