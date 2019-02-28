package com.google.android.gms.tagmanager;

import android.content.SharedPreferences.Editor;

final class af {

    /* renamed from: com.google.android.gms.tagmanager.af$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ Editor bcC;

        AnonymousClass1(Editor editor) {
            this.bcC = editor;
        }

        public final void run() {
            this.bcC.commit();
        }
    }
}
