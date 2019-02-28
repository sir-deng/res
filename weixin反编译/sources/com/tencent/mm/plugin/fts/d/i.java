package com.tencent.mm.plugin.fts.d;

import android.view.View;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public interface i {

    public static class a {
        public int hMM = 0;
        public e mRM = null;
        public int mUE = Integer.MAX_VALUE;
        public boolean mUF = true;
        public int mUG = Integer.MAX_VALUE;
        public boolean mUH = false;
        public List<j> mUI = null;
        public boolean mUJ = true;
        public j mUK;
        public int mUL = 0;

        public final String toString() {
            int i = 0;
            String str = "{%d, %b, %d, %b, %d, %d, %d}";
            Object[] objArr = new Object[7];
            objArr[0] = Integer.valueOf(this.mUE);
            objArr[1] = Boolean.valueOf(this.mUF);
            objArr[2] = Integer.valueOf(this.mUG);
            objArr[3] = Boolean.valueOf(this.mUH);
            objArr[4] = Integer.valueOf(this.hMM);
            if (this.mUI != null) {
                i = this.mUI.size();
            }
            objArr[5] = Integer.valueOf(i);
            objArr[6] = Integer.valueOf(this.mUL);
            return String.format(str, objArr);
        }
    }

    public interface b {
        void a(i iVar, String str);
    }

    void a(String str, ag agVar, HashSet<String> hashSet);

    boolean a(View view, com.tencent.mm.plugin.fts.d.a.b bVar, boolean z);

    void aNT();

    LinkedList<Integer> aNU();

    int aNW();

    void abi();

    int getType();

    int qw(int i);

    com.tencent.mm.plugin.fts.d.a.b qx(int i);
}
