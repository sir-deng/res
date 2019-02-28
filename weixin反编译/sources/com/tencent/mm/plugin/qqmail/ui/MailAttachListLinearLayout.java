package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import java.util.ArrayList;
import java.util.List;

public class MailAttachListLinearLayout extends LinearLayout {
    Context context;
    List<String> pyU = new ArrayList();

    /* renamed from: com.tencent.mm.plugin.qqmail.ui.MailAttachListLinearLayout$1 */
    class AnonymousClass1 implements OnClickListener {
        final /* synthetic */ String pyV;
        final /* synthetic */ String pyW;
        final /* synthetic */ String pyX;
        final /* synthetic */ long pyY;
        final /* synthetic */ int pyZ;
        final /* synthetic */ String pza;

        AnonymousClass1(String str, String str2, String str3, long j, int i, String str4) {
            this.pyV = str;
            this.pyW = str2;
            this.pyX = str3;
            this.pyY = j;
            this.pyZ = i;
            this.pza = str4;
        }

        public final void onClick(View view) {
            Intent intent = new Intent(MailAttachListLinearLayout.this.context, AttachDownloadPage.class);
            intent.putExtra("attach_name", this.pyV);
            intent.putExtra("mail_id", this.pyW);
            intent.putExtra("attach_id", this.pyX);
            intent.putExtra("total_size", this.pyY);
            intent.putExtra("is_preview", this.pyZ);
            intent.putExtra("is_compress", MailAttachListLinearLayout.Iz(this.pza));
            MailAttachListLinearLayout.this.context.startActivity(intent);
        }
    }

    static /* synthetic */ boolean Iz(String str) {
        return str != null && str.contains("/cgi-bin/viewcompress");
    }

    public MailAttachListLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.context = context;
    }

    static String dR(String str, String str2) {
        if (str == null || str.length() == 0 || str2.length() == 0) {
            return null;
        }
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        int indexOf2 = str.indexOf("&", indexOf);
        if (indexOf2 == -1) {
            indexOf2 = str.length();
        }
        return str.substring((indexOf + str2.length()) + 1, indexOf2);
    }
}
