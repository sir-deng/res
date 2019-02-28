package com.tencent.mm.pluginsdk.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.f.a.sl;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.wcdb.FileUtils;

@a(3)
public class VoiceInputUI extends MMActivity {
    private String fKZ;
    private String fpV;
    private Button lKp;
    private int offset;
    private int textChangeCount = 0;
    private MMEditText vsV;
    private VoiceInputFooter vsW;
    private String vsX;
    private long vsY = 0;
    private boolean vsZ = true;
    private boolean vta = false;
    private OnTouchListener vtb = new OnTouchListener() {
        public final boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                VoiceInputUI.this.textChangeCount = VoiceInputUI.this.textChangeCount + 1;
            } else if (motionEvent.getAction() == 1) {
                VoiceInputFooter b;
                if (VoiceInputUI.this.vsW.cbi()) {
                    b = VoiceInputUI.this.vsW;
                    b.cbj();
                    b.setVisibility(8);
                }
                if (VoiceInputUI.this.vsW.bCO()) {
                    b = VoiceInputUI.this.vsW;
                    b.hideSmileyPanel();
                    b.setVisibility(8);
                }
                b = VoiceInputUI.this.vsW;
                b.setVisibility(0);
                if (b.vsp != null) {
                    b.vsp.setImageResource(R.g.bBo);
                }
            }
            return false;
        }
    };
    private OnMenuItemClickListener vtc = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            VoiceInputUI.this.vsV.setText("");
            VoiceInputUI.this.vta = true;
            VoiceInputUI.this.Cm(6);
            return true;
        }
    };
    private VoiceInputFooter.a vtd = new VoiceInputFooter.a() {
        public final void lc(boolean z) {
            if (z) {
                VoiceInputUI.this.lKp.setVisibility(4);
            } else {
                VoiceInputUI.this.lKp.setVisibility(0);
            }
        }

        public final void cbk() {
            VoiceInputUI.this.Cm(8);
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(FileUtils.S_IWUSR);
        Intent intent = getIntent();
        if (intent != null) {
            this.fpV = intent.getStringExtra("text");
            this.offset = intent.getIntExtra("offset", -1);
            this.vsX = intent.getStringExtra("punctuation");
            this.fKZ = intent.getStringExtra("userCode");
        }
        this.vsY = bi.Wz();
        this.textChangeCount = 0;
        this.vta = false;
        this.vsZ = true;
        this.vsV = (MMEditText) findViewById(R.h.cWu);
        this.lKp = (Button) findViewById(R.h.cWt);
        this.vsV.addTextChangedListener(new TextWatcher() {
            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                x.d("VoiceInputUI", "afterTextChanged firstTextChange:%s,textChange:%s", Boolean.valueOf(VoiceInputUI.this.vsZ), Boolean.valueOf(VoiceInputUI.this.vta));
                if (VoiceInputUI.this.vsZ) {
                    VoiceInputUI.this.vsZ = false;
                    return;
                }
                VoiceInputUI.this.vta = true;
                VoiceInputUI.this.vsV.requestLayout();
            }
        });
        this.lKp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
                voiceInputBehavior.send = 3;
                VoiceInputUI.a(voiceInputBehavior);
                VoiceInputUI.this.Cm(7);
            }
        });
        setMMTitle(getString(R.l.eTN));
        enableOptionMenu(true);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                VoiceInputUI.this.Cm(1);
                return true;
            }
        });
        this.vsV.setOnTouchListener(this.vtb);
        this.vsV.aaU(this.fpV);
        if (this.offset != -1) {
            this.vsV.setSelection(this.offset);
        }
        this.vsW = (VoiceInputFooter) findViewById(R.h.cIM);
        VoiceInputFooter voiceInputFooter = this.vsW;
        MMEditText mMEditText = this.vsV;
        String str = this.vsX;
        voiceInputFooter.rMD = mMEditText;
        mMEditText.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (VoiceInputFooter.this.getVisibility() == 8) {
                    VoiceInputFooter.this.setVisibility(0);
                }
                if (VoiceInputFooter.this.cbi()) {
                    VoiceInputFooter.this.cbj();
                }
                if (VoiceInputFooter.this.bCO()) {
                    VoiceInputFooter.this.hideSmileyPanel();
                }
            }
        });
        mMEditText.setOnEditorActionListener(new OnEditorActionListener() {
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return false;
            }
        });
        if (voiceInputFooter.vso == null) {
            voiceInputFooter.vso = new n(voiceInputFooter.getContext(), true, voiceInputFooter.rMD);
            voiceInputFooter.vso.vyE = new n.a() {
                public final void bUM() {
                }

                public final void Qb(String str) {
                    if (VoiceInputFooter.this.vsv != null) {
                        VoiceInputFooter.this.vsv.cbk();
                    }
                }

                public final void kF(boolean z) {
                }
            };
            voiceInputFooter.vso.CJ(j.aQ(voiceInputFooter.getContext()));
        }
        voiceInputFooter.vso.ccP();
        voiceInputFooter.vso.cbV();
        voiceInputFooter.vso.setVisibility(8);
        n nVar = voiceInputFooter.vso;
        if (str != null) {
            nVar.vza = str;
        }
        nVar.ccR();
        voiceInputFooter.oJd.addView(voiceInputFooter.vso, -1, 0);
        this.vsW.vsv = this.vtd;
    }

    protected void onResume() {
        super.onResume();
        this.vsV.requestFocus();
    }

    protected void onPause() {
        super.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        if (this.vsW != null) {
            VoiceInputFooter voiceInputFooter = this.vsW;
            if (voiceInputFooter.oqc != null) {
                voiceInputFooter.oqc.tj();
                voiceInputFooter.oqc.destroy();
            }
            if (voiceInputFooter.vso != null) {
                voiceInputFooter.vso.destroy();
            }
        }
    }

    protected final int getLayoutId() {
        return R.i.dtK;
    }

    public void onSwipeBack() {
        Cm(3);
        super.onSwipeBack();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            Cm(2);
        }
        return super.onKeyDown(i, keyEvent);
    }

    public final void Cm(int i) {
        x.i("VoiceInputUI", "alvinluo voiceinputui finish type: %d, call stack: %s", Integer.valueOf(i), bi.chl().toString());
        if (i == 8) {
            qq(7);
        } else {
            qq(i);
        }
        b slVar = new sl();
        if (i == 7) {
            slVar.fKX.action = 1;
        } else if (i == 8) {
            slVar.fKX.action = 4;
        } else {
            slVar.fKX.action = 2;
        }
        if (this.vta) {
            slVar.fKX.fKY = 1;
        } else {
            slVar.fKX.fKY = 2;
        }
        slVar.fKX.result = this.vsV.getText().toString();
        slVar.fKX.fKZ = this.fKZ;
        com.tencent.mm.sdk.b.a.xmy.m(slVar);
        bi.hideVKB(this.vsV);
        super.finish();
    }

    private static void a(VoiceInputBehavior voiceInputBehavior) {
        x.i("VoiceInputUI", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        com.tencent.mm.bp.a log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        g.pWK.c(13905, log_13905);
    }

    private void qq(int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        voiceInputBehavior.textChangeCount = this.textChangeCount;
        voiceInputBehavior.textChangeReturn = i;
        if (this.vsY != 0) {
            voiceInputBehavior.textChangeTime = bi.bB(this.vsY);
            this.vsY = 0;
        }
        a(voiceInputBehavior);
    }
}
