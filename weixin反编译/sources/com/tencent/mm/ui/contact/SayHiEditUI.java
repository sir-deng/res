package com.tencent.mm.ui.contact;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.p.b;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.y.as;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.DownloadResult;
import java.util.LinkedList;
import java.util.List;
import org.xwalk.core.XWalkUpdater;

public class SayHiEditUI extends MMActivity implements e {
    private ProgressDialog inI = null;
    private MMEditText zdd;

    private static class a implements TextWatcher {
        private boolean gTZ;

        private a() {
            this.gTZ = false;
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (!this.gTZ) {
                this.gTZ = true;
                d.oXY.T(3, 2, 5);
            }
        }

        public final void afterTextChanged(Editable editable) {
        }
    }

    static /* synthetic */ String a(SayHiEditUI sayHiEditUI) {
        String trim = sayHiEditUI.zdd.getText().toString().trim();
        return trim.length() <= 50 ? trim : trim.substring(0, 50);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        as.CN().a(30, (e) this);
        setMMTitle(R.l.exz);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.drb;
    }

    public void onDestroy() {
        as.CN().b(30, (e) this);
        super.onDestroy();
    }

    protected final void initView() {
        this.zdd = (MMEditText) findViewById(R.h.cIN);
        this.zdd.addTextChangedListener(new a());
        c.d(this.zdd).Hg(100).a(null);
        final String stringExtra = getIntent().getStringExtra("Contact_User");
        final int intExtra = getIntent().getIntExtra("Contact_Scene", 18);
        final String stringExtra2 = getIntent().getStringExtra(com.tencent.mm.ui.e.a.xML);
        a(0, getString(R.l.dGL), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SayHiEditUI.this.aWY();
                d.oXY.T(2, 1, 3);
                List linkedList = new LinkedList();
                linkedList.add(stringExtra);
                List linkedList2 = new LinkedList();
                linkedList2.add(Integer.valueOf(intExtra));
                List linkedList3 = new LinkedList();
                if (!t.oN(stringExtra2)) {
                    linkedList3.add(stringExtra2);
                }
                final k oVar = new o(2, linkedList, linkedList2, linkedList3, SayHiEditUI.a(SayHiEditUI.this), "", null, null, "");
                as.CN().a(oVar, 0);
                SayHiEditUI sayHiEditUI = SayHiEditUI.this;
                Context context = SayHiEditUI.this.mController.xRr;
                SayHiEditUI.this.getString(R.l.dGZ);
                sayHiEditUI.inI = h.a(context, SayHiEditUI.this.getString(R.l.eKs), true, new OnCancelListener() {
                    public final void onCancel(DialogInterface dialogInterface) {
                        as.CN().c(oVar);
                    }
                });
                return false;
            }
        }, b.xSe);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                SayHiEditUI.this.finish();
                return true;
            }
        });
    }

    public final void a(int i, int i2, String str, k kVar) {
        Object obj = 1;
        x.i("MicroMsg.SayHiEditUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        try {
            if (this.inI != null) {
                this.inI.dismiss();
                this.inI = null;
            }
            switch (i2) {
                case -34:
                case DownloadResult.CODE_CONNECTION_EXCEPTION /*-24*/:
                    Toast.makeText(this, R.l.exC, 0).show();
                    break;
                case DownloadResult.CODE_CLIENT_PROTOCOL_EXCEPTION /*-22*/:
                    Toast.makeText(this, R.l.exA, 0).show();
                    break;
                default:
                    obj = null;
                    break;
            }
            if (obj == null) {
                if (i == 0 && i2 == 0) {
                    h.bu(this, getString(R.l.dUo));
                    finish();
                } else if (i == 4 && i2 == -24 && !t.oN(str)) {
                    Toast.makeText(this, str, 1).show();
                } else if (i2 != XWalkUpdater.ERROR_SET_VERNUM || t.oN(str)) {
                    Toast.makeText(this, R.l.exB, 0).show();
                } else {
                    h.a((Context) this, str, getString(R.l.dGZ), getString(R.l.dGf), null);
                }
            }
        } catch (Exception e) {
            x.e("MicroMsg.SayHiEditUI", "exception in onSceneEnd : " + e.getMessage());
        }
    }
}
