package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ToggleButton;
import com.tencent.mm.R;
import com.tencent.mm.ax.k;
import com.tencent.mm.k.a;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.y.as;
import com.tencent.mm.y.c;
import com.tencent.mm.y.s;

public class SpecialCheckBoxPreference extends Preference {
    private boolean fAu;
    private String iTE;
    private boolean kYN = false;
    private x lLc;
    private boolean lfm;
    private Context mContext;
    private ToggleButton vAU;
    private ToggleButton vAV;
    private ToggleButton vAW;
    private OnCheckedChangeListener vAX = new OnCheckedChangeListener() {
        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            int id = compoundButton.getId();
            if (id == R.h.cIv) {
                SpecialCheckBoxPreference.a(SpecialCheckBoxPreference.this);
            } else if (id == R.h.cIu) {
                SpecialCheckBoxPreference.b(SpecialCheckBoxPreference.this);
            } else if (id == R.h.cIx) {
                SpecialCheckBoxPreference.c(SpecialCheckBoxPreference.this);
            }
        }
    };

    static /* synthetic */ void a(SpecialCheckBoxPreference specialCheckBoxPreference) {
        if (specialCheckBoxPreference.lLc != null) {
            as.Hm();
            if (c.Fk().XM(specialCheckBoxPreference.lLc.field_username)) {
                s.s(specialCheckBoxPreference.lLc.field_username, true);
            } else {
                s.r(specialCheckBoxPreference.lLc.field_username, true);
            }
        }
    }

    static /* synthetic */ void b(SpecialCheckBoxPreference specialCheckBoxPreference) {
        int i = 0;
        specialCheckBoxPreference.kYN = !specialCheckBoxPreference.kYN;
        if (specialCheckBoxPreference.fAu) {
            if (!specialCheckBoxPreference.kYN) {
                i = 1;
            }
            as.Hm();
            c.Fe().b(new k(specialCheckBoxPreference.iTE, i));
            specialCheckBoxPreference.lLc.eH(i);
            as.Hm();
            c.Ff().a(specialCheckBoxPreference.iTE, specialCheckBoxPreference.lLc);
        }
        specialCheckBoxPreference.cdc();
    }

    static /* synthetic */ void c(SpecialCheckBoxPreference specialCheckBoxPreference) {
        if (specialCheckBoxPreference.lLc == null) {
            return;
        }
        if (a.ga(specialCheckBoxPreference.lLc.field_type)) {
            specialCheckBoxPreference.lLc.Ao();
            s.t(specialCheckBoxPreference.lLc);
            h.bu(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.l.eGe));
            return;
        }
        s.q(specialCheckBoxPreference.lLc);
        h.bu(specialCheckBoxPreference.mContext, specialCheckBoxPreference.mContext.getString(R.l.eGm));
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
    }

    public SpecialCheckBoxPreference(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        this.vAU = (ToggleButton) view.findViewById(R.h.cIv);
        this.vAV = (ToggleButton) view.findViewById(R.h.cIu);
        this.vAW = (ToggleButton) view.findViewById(R.h.cIx);
        this.iTE = ((MMActivity) this.mContext).getIntent().getStringExtra("RoomInfo_Id");
        this.fAu = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Chatroom", true);
        this.lfm = ((MMActivity) this.mContext).getIntent().getBooleanExtra("Is_Lbsroom", false);
        as.Hm();
        this.lLc = c.Ff().Xv(this.iTE);
        if (this.lLc != null) {
            ToggleButton toggleButton = this.vAU;
            as.Hm();
            toggleButton.setChecked(c.Fk().XM(this.lLc.field_username));
            this.vAW.setChecked(a.ga(this.lLc.field_type));
            this.vAV.setChecked(cdc());
        }
        this.vAU.setOnCheckedChangeListener(this.vAX);
        this.vAV.setOnCheckedChangeListener(this.vAX);
        this.vAW.setOnCheckedChangeListener(this.vAX);
    }

    private boolean cdc() {
        if (this.fAu) {
            this.kYN = this.lLc.fXi == 0;
        } else if (!this.lfm) {
            this.kYN = this.lLc.AP();
        }
        if (!(this.mContext instanceof MMActivity)) {
            return false;
        }
        if (this.kYN) {
            ((MMActivity) this.mContext).setTitleMuteIconVisibility(0);
            return true;
        }
        ((MMActivity) this.mContext).setTitleMuteIconVisibility(8);
        return false;
    }
}
