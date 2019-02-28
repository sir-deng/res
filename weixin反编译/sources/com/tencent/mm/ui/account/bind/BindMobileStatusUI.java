package com.tencent.mm.ui.account.bind;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.modelsimple.BindWordingContent;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.messenger.foundation.a.a.e;
import com.tencent.mm.protocal.c.wu;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.q;
import java.util.HashMap;
import java.util.Map.Entry;

public class BindMobileStatusUI extends MMWizardActivity {
    private SharedPreferences hbz;
    @SuppressLint({"UseSparseArrays"})
    private HashMap<Integer, Integer> kHY = new HashMap();
    private Button kxK;
    private int status;
    private ImageView ybC;
    private TextView ybD;
    private TextView ybE;
    private ImageView ybF;
    private ImageView ybG;
    private Boolean ybH = Boolean.valueOf(true);
    private Boolean ybI = Boolean.valueOf(true);
    private RelativeLayout ybJ;
    private RelativeLayout ybK;
    private BindWordingContent ybL;
    private int ybM;
    private boolean ybN;
    private boolean ybO;
    private SparseArray<String> ybP = new SparseArray(3);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hbz = getSharedPreferences(getPackageName() + "_preferences", 0);
        this.status = q.Gc();
        this.ybP.put(8, "settings_find_me_by_mobile");
        this.ybP.put(7, "settings_recommend_mobilefriends_to_me");
        this.ybP.put(32, "settings_autoadd_mobilefriends");
        e(false, WXMediaMessage.TITLE_LENGTH_LIMIT, 8);
        e(false, 256, 7);
        setMMTitle(R.l.dLw);
        this.ybL = (BindWordingContent) getIntent().getParcelableExtra("kstyle_bind_wording");
        this.ybM = getIntent().getIntExtra("kstyle_bind_recommend_show", 0);
        this.ybN = getIntent().getBooleanExtra("Kfind_friend_by_mobile_flag", false);
        this.ybO = getIntent().getBooleanExtra("Krecom_friends_by_mobile_flag", false);
        initView();
    }

    protected final int getLayoutId() {
        return R.i.dbg;
    }

    protected void onPause() {
        as.Hm();
        c.Db().set(7, Integer.valueOf(this.status));
        for (Entry entry : this.kHY.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            a wuVar = new wu();
            wuVar.wnP = intValue;
            wuVar.wnQ = intValue2;
            as.Hm();
            c.Fe().b(new e.a(23, wuVar));
            x.d("MicroMsg.BindMobileStatusUI", "switch  " + intValue + " " + intValue2);
        }
        this.kHY.clear();
        super.onPause();
    }

    private boolean e(boolean z, int i, int i2) {
        x.d("MicroMsg.BindMobileStatusUI", "switch change : open = " + z + " item value = " + i + " functionId = " + i2);
        if (z) {
            this.status |= i;
        } else {
            this.status &= i ^ -1;
        }
        this.kHY.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        String str = (String) this.ybP.get(i2);
        if (!(this.hbz == null || str == null || str.length() <= 0)) {
            Boolean valueOf = Boolean.valueOf(z);
            if (i2 == 8 || i2 == 7) {
                valueOf = Boolean.valueOf(!z);
            }
            this.hbz.edit().putBoolean(str, valueOf.booleanValue()).commit();
        }
        return true;
    }

    protected final void initView() {
        boolean z = true;
        this.ybC = (ImageView) findViewById(R.h.bNn);
        this.ybE = (TextView) findViewById(R.h.bNl);
        this.ybD = (TextView) findViewById(R.h.bNk);
        this.kxK = (Button) findViewById(R.h.bNm);
        this.ybF = (ImageView) findViewById(R.h.bNJ);
        this.ybG = (ImageView) findViewById(R.h.bNI);
        this.ybJ = (RelativeLayout) findViewById(R.h.bNh);
        this.ybK = (RelativeLayout) findViewById(R.h.bNi);
        switch (this.ybM) {
            case 0:
                boolean z2;
                this.ybJ.setVisibility(8);
                this.ybK.setVisibility(8);
                if (this.ybN) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                e(z2, WXMediaMessage.TITLE_LENGTH_LIMIT, 8);
                if (this.ybO) {
                    z = false;
                }
                e(z, 256, 7);
                break;
            case 1:
                this.ybJ.setVisibility(0);
                this.ybJ.setBackgroundResource(R.g.bzs);
                this.ybK.setVisibility(8);
                break;
        }
        if (this.ybL != null) {
            switch (this.ybL.hOj.intValue()) {
                case 2:
                    this.ybD.setVisibility(8);
                    break;
            }
        }
        this.kxK.setVisibility(8);
        addTextOptionMenu(0, getString(R.l.dFw), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                BindMobileStatusUI.this.En(1);
                return false;
            }
        });
        if (m.NT() == m.a.SUCC || m.NT() == m.a.SUCC_UNLOAD) {
            this.ybC.setImageResource(R.g.bzq);
            as.Hm();
            String str = (String) c.Db().get(6, null);
            if (str == null || str.equals("")) {
                as.Hm();
                c.Db().get(4097, null);
            }
        } else {
            this.ybC.setImageResource(R.g.bzn);
            this.ybD.setVisibility(8);
            this.ybE.setText(getString(R.l.dKR));
        }
        this.ybF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z = true;
                BindMobileStatusUI.this.ybH = Boolean.valueOf(!BindMobileStatusUI.this.ybH.booleanValue());
                if (BindMobileStatusUI.this.ybH.booleanValue()) {
                    BindMobileStatusUI.this.ybF.setImageResource(R.k.dxZ);
                } else {
                    BindMobileStatusUI.this.ybF.setImageResource(R.k.dya);
                }
                BindMobileStatusUI bindMobileStatusUI = BindMobileStatusUI.this;
                if (BindMobileStatusUI.this.ybH.booleanValue()) {
                    z = false;
                }
                bindMobileStatusUI.e(z, WXMediaMessage.TITLE_LENGTH_LIMIT, 8);
            }
        });
        this.ybG.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                boolean z = true;
                BindMobileStatusUI.this.ybI = Boolean.valueOf(!BindMobileStatusUI.this.ybI.booleanValue());
                if (BindMobileStatusUI.this.ybI.booleanValue()) {
                    BindMobileStatusUI.this.ybG.setImageResource(R.k.dxZ);
                } else {
                    BindMobileStatusUI.this.ybG.setImageResource(R.k.dya);
                }
                BindMobileStatusUI bindMobileStatusUI = BindMobileStatusUI.this;
                if (BindMobileStatusUI.this.ybI.booleanValue()) {
                    z = false;
                }
                bindMobileStatusUI.e(z, 256, 7);
                if (!BindMobileStatusUI.this.ybI.booleanValue()) {
                    BindMobileStatusUI.this.e(false, 2097152, 32);
                }
            }
        });
        this.kxK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                BindMobileStatusUI.this.En(1);
            }
        });
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        En(1);
        return true;
    }

    public static void c(Context context, boolean z, boolean z2) {
        boolean z3 = false;
        int i = 1;
        SharedPreferences sharedPreferences = context.getSharedPreferences(context.getPackageName() + "_preferences", 0);
        sharedPreferences.edit().putBoolean("settings_find_me_by_mobile", !z).commit();
        Editor edit = sharedPreferences.edit();
        String str = "settings_recommend_mobilefriends_to_me";
        if (!z2) {
            z3 = true;
        }
        edit.putBoolean(str, z3).commit();
        int Gc = q.Gc();
        Gc = z ? Gc | WXMediaMessage.TITLE_LENGTH_LIMIT : Gc & -513;
        Gc = z2 ? Gc | 256 : Gc & -257;
        as.Hm();
        c.Db().set(7, Integer.valueOf(Gc));
        a wuVar = new wu();
        wuVar.wnP = 8;
        if (z2) {
            Gc = 1;
        } else {
            Gc = 2;
        }
        wuVar.wnQ = Gc;
        as.Hm();
        c.Fe().b(new e.a(23, wuVar));
        a wuVar2 = new wu();
        wuVar2.wnP = 7;
        if (!z) {
            i = 2;
        }
        wuVar.wnQ = i;
        as.Hm();
        c.Fe().b(new e.a(23, wuVar2));
        com.tencent.mm.plugin.c.a.ihO.un();
    }
}
