package android.support.v4.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class ah extends android.support.v4.app.aj.a {
    private static final b to;
    public static final android.support.v4.app.aj.a.a tp = new android.support.v4.app.aj.a.a() {
    };
    private final Bundle mExtras;
    private final String tk;
    private final CharSequence tl;
    private final CharSequence[] tm;
    private final boolean tn;

    static class d implements b {
        d() {
        }

        public final Bundle getResultsFromIntent(Intent intent) {
            return null;
        }
    }

    static class e implements b {
        e() {
        }

        public final Bundle getResultsFromIntent(Intent intent) {
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                ClipDescription description = clipData.getDescription();
                if (description.hasMimeType("text/vnd.android.intent") && description.getLabel().equals("android.remoteinput.results")) {
                    return (Bundle) clipData.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
                }
            }
            return null;
        }
    }

    interface b {
        Bundle getResultsFromIntent(Intent intent);
    }

    static class c implements b {
        c() {
        }

        public final Bundle getResultsFromIntent(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    public static final class a {
        public Bundle mExtras = new Bundle();
        public final String tk;
        public CharSequence tl;
        public CharSequence[] tm;
        public boolean tn = true;

        public a(String str) {
            this.tk = str;
        }
    }

    public /* synthetic */ ah(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle, byte b) {
        this(str, charSequence, charSequenceArr, z, bundle);
    }

    private ah(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z, Bundle bundle) {
        this.tk = str;
        this.tl = charSequence;
        this.tm = charSequenceArr;
        this.tn = z;
        this.mExtras = bundle;
    }

    public final String getResultKey() {
        return this.tk;
    }

    public final CharSequence getLabel() {
        return this.tl;
    }

    public final CharSequence[] getChoices() {
        return this.tm;
    }

    public final boolean getAllowFreeFormInput() {
        return this.tn;
    }

    public final Bundle getExtras() {
        return this.mExtras;
    }

    public static Bundle getResultsFromIntent(Intent intent) {
        return to.getResultsFromIntent(intent);
    }

    static {
        if (VERSION.SDK_INT >= 20) {
            to = new c();
        } else if (VERSION.SDK_INT >= 16) {
            to = new e();
        } else {
            to = new d();
        }
    }
}
