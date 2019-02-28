package com.tencent.mm.plugin.subapp.ui.voicereminder;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.R;
import com.tencent.mm.plugin.subapp.b;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.y.ak.d;
import com.tencent.mm.y.as;
import com.tencent.mm.y.s;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

@a(3)
public class RemindDialog extends Activity {
    private static boolean fpU = false;
    private static List<String> seT = new ArrayList();
    private ag handler = new ag();
    private i pDT;
    private List<String> seS = new ArrayList();
    private d seU = new d() {
        public final void m(String str, long j) {
            x.d("MicroMsg.RemindDialog", "onVoiceRemind " + str);
            RemindDialog.this.seS.add(str);
            RemindDialog.this.bET();
        }
    };
    private String talker = "";

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        i.a aVar = new i.a(this);
        aVar.ES(R.l.eUg);
        aVar.Zn(" ");
        aVar.EV(R.l.eUd).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.plugin.subapp.c.d bEK = com.tencent.mm.plugin.subapp.c.d.bEK();
                if (bEK != null) {
                    bEK.hO(RemindDialog.this.talker);
                }
                if (s.he(as.getNotification().xe())) {
                    RemindDialog.this.finish();
                    return;
                }
                b.ihN.e(new Intent().putExtra("Chat_User", RemindDialog.this.talker), RemindDialog.this);
                RemindDialog.this.finish();
            }
        });
        aVar.EW(R.l.eUf).b(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                com.tencent.mm.plugin.subapp.c.d bEK = com.tencent.mm.plugin.subapp.c.d.bEK();
                if (bEK != null) {
                    bEK.hO(RemindDialog.this.talker);
                }
                RemindDialog.this.finish();
            }
        });
        aVar.a(new OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                RemindDialog.this.finish();
            }
        });
        this.talker = getIntent().getStringExtra("_RemindDialog_User");
        String stringExtra = getIntent().getStringExtra("_RemindDialog_Remind");
        this.seS.clear();
        this.seS.add(stringExtra);
        for (String stringExtra2 : seT) {
            this.seS.add(stringExtra2);
        }
        this.pDT = aVar.ale();
        this.pDT.setCanceledOnTouchOutside(false);
        this.pDT.show();
        bET();
    }

    private void bET() {
        this.handler.post(new Runnable() {
            public final void run() {
                CharSequence stringBuffer = new StringBuffer();
                for (String str : RemindDialog.this.seS) {
                    if (bi.oN(str)) {
                        stringBuffer.append("\n\n");
                    } else {
                        stringBuffer.append(str + "\n\n");
                    }
                }
                if (RemindDialog.this.pDT != null) {
                    RemindDialog.this.pDT.setMessage(stringBuffer);
                }
            }
        });
    }

    public void onResume() {
        fpU = true;
        com.tencent.mm.plugin.subapp.c.d bEK = com.tencent.mm.plugin.subapp.c.d.bEK();
        if (bEK != null) {
            bEK.a(this.seU);
        }
        super.onResume();
    }

    public void onPause() {
        fpU = false;
        com.tencent.mm.plugin.subapp.c.d bEK = com.tencent.mm.plugin.subapp.c.d.bEK();
        if (bEK != null) {
            bEK.b(this.seU);
        }
        super.onPause();
    }

    public static void u(Context context, String str, String str2) {
        x.d("MicroMsg.RemindDialog", "show " + fpU + " remind " + str2);
        if (fpU) {
            seT.add(str2);
            return;
        }
        seT.clear();
        fpU = true;
        Intent intent;
        if (as.CN().foreground) {
            intent = new Intent(context, RemindDialog.class);
            intent.putExtra("_RemindDialog_User", str);
            intent.putExtra("_RemindDialog_Remind", str2);
            intent.setFlags(603979776);
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            return;
        }
        intent = new Intent(context, RemindDialog.class);
        intent.putExtra("_RemindDialog_User", str);
        intent.putExtra("_RemindDialog_Remind", str2);
        intent.setFlags(604012544);
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent);
    }
}
