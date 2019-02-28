package com.tencent.mm.plugin.extqlauncher.ui;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ac.n;
import com.tencent.mm.bl.d;
import com.tencent.mm.k.a;
import com.tencent.mm.plugin.base.model.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMBaseActivity;
import com.tencent.mm.ui.contact.s;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import com.tencent.mm.y.r;
import java.util.List;

public class QLauncherCreateShortcutUI extends MMBaseActivity {
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onCreate");
        requestWindowFeature(1);
        setContentView(R.i.dfs);
        Intent intent = new Intent();
        int p = s.p(s.zcy, 64, 16384);
        s.fe(p, 1);
        intent.putExtra("list_attr", p);
        intent.putExtra("list_type", 12);
        intent.putExtra("stay_in_wechat", false);
        intent.putExtra("titile", getString(R.l.dDz));
        intent.putExtra("block_contact", q.FY());
        d.a((Context) this, ".ui.contact.SelectContactUI", intent, 1);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "onActivityResult resultCode = %s", Integer.valueOf(i2));
        if (i2 != -1) {
            finish();
            return;
        }
        switch (i) {
            case 1:
                if (intent != null) {
                    if (as.Hp()) {
                        List list;
                        String stringExtra = intent.getStringExtra("Select_Contact");
                        if (bi.oN(stringExtra)) {
                            list = null;
                        } else {
                            list = bi.F(stringExtra.split(","));
                        }
                        if (list != null && list.size() > 0) {
                            x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames count " + list.size());
                            String FY = q.FY();
                            try {
                                ContentValues[] contentValuesArr = new ContentValues[list.size()];
                                for (int i3 = 0; i3 < list.size(); i3++) {
                                    as.Hm();
                                    a Xv = c.Ff().Xv((String) list.get(i3));
                                    if (Xv == null || ((int) Xv.gKO) <= 0) {
                                        x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "no such user");
                                        finish();
                                        return;
                                    }
                                    String wk = b.wk((String) list.get(i3));
                                    if (bi.oN(wk)) {
                                        x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "null encryptShortcutUser");
                                        finish();
                                        return;
                                    }
                                    ContentValues contentValues = new ContentValues();
                                    contentValues.put("source_key", b.kAo);
                                    contentValues.put("owner_id", b.wk(FY));
                                    contentValues.put("unique_id", wk);
                                    contentValues.put("container", Integer.valueOf(1));
                                    contentValues.put("item_type", Integer.valueOf(b.y(Xv)));
                                    contentValues.put("name", r.a(Xv, (String) list.get(i3)));
                                    n.JF();
                                    contentValues.put("icon_path", com.tencent.mm.ac.d.x((String) list.get(i3), false));
                                    Intent intent2 = new Intent("com.tencent.mm.action.BIZSHORTCUT");
                                    intent2.putExtra("LauncherUI.Shortcut.Username", wk);
                                    intent2.putExtra("LauncherUI.From.Biz.Shortcut", true);
                                    intent2.addFlags(67108864);
                                    contentValues.put("intent", intent2.toUri(0));
                                    contentValuesArr[i3] = contentValues;
                                }
                                getContentResolver().bulkInsert(a.mhY, contentValuesArr);
                                Toast.makeText(this, R.l.eem, 0).show();
                                com.tencent.mm.plugin.extqlauncher.b.aGI().aGK();
                                break;
                            } catch (Throwable e) {
                                x.d("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "bulkInsert shortcut failed, %s", e.getMessage());
                                x.printErrStackTrace("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", e, "", new Object[0]);
                                Toast.makeText(this, R.l.eel, 0).show();
                                break;
                            }
                        }
                        x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "userNames empty");
                        break;
                    }
                    x.e("MicroMsg.extqlauncher.QLauncherCreateShortcutUI", "account not ready");
                    Toast.makeText(this, R.l.eel, 0).show();
                    finish();
                    return;
                }
                break;
        }
        finish();
    }
}
