package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Process;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;

public class NoRomSpaceDexUI extends Activity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        bi.initLanguage(ad.getContext());
        setContentView(R.i.dph);
        CharSequence string = getString(R.l.dTE);
        n nVar = new n(this);
        nVar.setTitle(R.l.dTF);
        nVar.xQG.setVisibility(0);
        nVar.xQE.setVisibility(0);
        nVar.xQE.setText(string);
        string = getString(R.l.dTC);
        OnClickListener anonymousClass1 = new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                Process.killProcess(Process.myPid());
            }
        };
        if (nVar.tbx != null) {
            nVar.tbx.setVisibility(0);
            nVar.tbx.setText(string);
            nVar.tbx.setOnClickListener(new com.tencent.mm.ui.n.AnonymousClass1(anonymousClass1, true));
        }
        nVar.setCancelable(false);
        nVar.cnB();
        nVar.show();
    }
}
