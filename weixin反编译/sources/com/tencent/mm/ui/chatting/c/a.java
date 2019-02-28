package com.tencent.mm.ui.chatting.c;

import android.content.Context;
import android.support.v7.widget.RecyclerView.g;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;

public final class a {

    public interface a extends com.tencent.mm.ui.chatting.e.c<b> {
        void FZ(int i);

        String Xf();

        android.support.v7.widget.RecyclerView.a aw(String str, long j);

        <T extends android.support.v7.widget.RecyclerView.a> T cuU();

        int cuV();

        void cuW();

        void cuX();

        boolean cuY();

        void cuZ();

        <T extends h> T fN(Context context);

        g fO(Context context);

        void onResume();

        void y(boolean z, int i);
    }

    public interface b extends com.tencent.mm.ui.chatting.h.a<a> {
        void Ga(int i);

        void Gb(int i);

        void cuX();

        void cuZ();

        void cva();

        void cvb();

        boolean cvc();

        View getChildAt(int i);

        void mY(boolean z);

        void z(boolean z, int i);
    }

    public enum c {
        ;

        public static int[] cvd() {
            return (int[]) yLD.clone();
        }

        static {
            yLC = 1;
            yLD = new int[]{yLC};
        }
    }
}
