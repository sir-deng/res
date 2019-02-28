package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.kvdata.VoiceInputBehavior;
import com.tencent.mm.plugin.report.kvdata.log_13905;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.pluginsdk.ui.chat.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class VoiceInputFooter extends BasePanelKeybordLayout {
    private MMActivity fnF;
    LinearLayout oJd;
    ChatFooterPanel oqc;
    MMEditText rMD = null;
    n vso;
    ImageButton vsp;
    private ImageButton vsq;
    private boolean vsr = false;
    private boolean vss = false;
    private final int vst = 1;
    private final int vsu = 2;
    a vsv;

    public interface a {
        void cbk();

        void lc(boolean z);
    }

    static /* synthetic */ void c(VoiceInputFooter voiceInputFooter) {
        voiceInputFooter.rMD.requestFocus();
        if (voiceInputFooter.vsr) {
            voiceInputFooter.cbj();
            voiceInputFooter.fnF.showVKB();
        } else {
            voiceInputFooter.vsr = true;
            voiceInputFooter.fnF.aWY();
            if (voiceInputFooter.bCO()) {
                voiceInputFooter.hideSmileyPanel();
            }
            if (voiceInputFooter.vso != null) {
                voiceInputFooter.vso.setVisibility(0);
            }
            voiceInputFooter.vsq.setImageResource(R.g.bBp);
            int ab = com.tencent.mm.bu.a.ab(voiceInputFooter.fnF, R.f.byi);
            voiceInputFooter.vsq.setPadding(ab, 0, ab, 0);
            voiceInputFooter.vsp.setImageResource(R.g.bBo);
            voiceInputFooter.vsp.setVisibility(8);
            if (voiceInputFooter.vsv != null) {
                voiceInputFooter.vsv.lc(true);
            }
        }
        qq(2);
    }

    static /* synthetic */ void d(VoiceInputFooter voiceInputFooter) {
        if (voiceInputFooter.cbi()) {
            voiceInputFooter.cbj();
        }
        if (voiceInputFooter.vss) {
            voiceInputFooter.rMD.requestFocus();
            voiceInputFooter.hideSmileyPanel();
            voiceInputFooter.fnF.showVKB();
            voiceInputFooter.vsp.setImageResource(R.g.bBo);
        } else {
            voiceInputFooter.fnF.aWY();
            voiceInputFooter.vss = true;
            voiceInputFooter.oqc.onResume();
            voiceInputFooter.oqc.setVisibility(0);
            voiceInputFooter.rMD.requestFocus();
            voiceInputFooter.vsp.setImageResource(R.g.bBp);
            voiceInputFooter.vsq.setImageResource(R.g.bHo);
        }
        qq(1);
    }

    public VoiceInputFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnF = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) v.fw(this.fnF).inflate(R.i.dtL, this);
        this.vsq = (ImageButton) viewGroup.findViewById(R.h.bJX);
        this.vsq.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VoiceInputFooter.c(VoiceInputFooter.this);
            }
        });
        this.vsp = (ImageButton) viewGroup.findViewById(R.h.bJR);
        this.vsp.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                VoiceInputFooter.d(VoiceInputFooter.this);
            }
        });
        if (e.vxZ == null) {
            this.oqc = new d(this.fnF);
            return;
        }
        this.oqc = e.vxZ.cw(getContext());
        this.oqc.ej(ChatFooterPanel.SCENE_SNS);
        this.oqc.setVisibility(8);
        this.oJd = (LinearLayout) findViewById(R.h.cIB);
        this.oJd.setOnClickListener(null);
        this.oJd.addView(this.oqc, -1, 0);
        this.oqc.tk();
        this.oqc.aH(false);
        this.oqc.vqj = new com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a() {
            public final void aYA() {
            }

            public final void gA(boolean z) {
            }

            public final void anG() {
                VoiceInputFooter.this.rMD.zCS.sendKeyEvent(new KeyEvent(0, 67));
                VoiceInputFooter.this.rMD.zCS.sendKeyEvent(new KeyEvent(1, 67));
            }

            public final void append(String str) {
                try {
                    VoiceInputFooter.this.rMD.aaU(str);
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.VoiceInputFooter", e, "", new Object[0]);
                }
            }
        };
    }

    public final boolean bCO() {
        return this.oqc.getVisibility() == 0;
    }

    public final boolean cbi() {
        return this.vso.getVisibility() == 0;
    }

    final void cbj() {
        this.vsr = false;
        if (this.vso != null) {
            this.vso.pause();
            this.vso.setVisibility(8);
            this.vsq.setImageResource(R.g.bHo);
            this.vsq.setPadding(0, 0, com.tencent.mm.bu.a.ab(this.fnF, R.f.byi), 0);
            this.vsp.setVisibility(0);
            if (this.vsv != null) {
                this.vsv.lc(false);
            }
        }
    }

    final void hideSmileyPanel() {
        this.vss = false;
        this.oqc.onPause();
        this.oqc.setVisibility(8);
    }

    protected final List<View> aYz() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.oqc);
        arrayList.add(this.vso);
        return arrayList;
    }

    private static void qq(int i) {
        VoiceInputBehavior voiceInputBehavior = new VoiceInputBehavior();
        if (i == 1) {
            voiceInputBehavior.smileIconClick = 1;
        } else if (i == 2) {
            voiceInputBehavior.voiceIconClick = 1;
        } else {
            return;
        }
        x.i("MicroMsg.VoiceInputFooter", "report cancel = %s send = %s click = %s longClick = %s longClickTime = %s textClick = %s textChangeCount = %s textChangeTime = %s textChangeReturn = %s voiceInputTime = %s fail = %s clear = %s smileIconClick = %s voiceIconClick = %s fullScreenVoiceLongClick = %s fullScreenVoiceLongClickTime = %s", Integer.valueOf(voiceInputBehavior.cancel), Integer.valueOf(voiceInputBehavior.send), Integer.valueOf(voiceInputBehavior.click), Integer.valueOf(voiceInputBehavior.longClick), Long.valueOf(voiceInputBehavior.longClickTime), Integer.valueOf(voiceInputBehavior.textClick), Integer.valueOf(voiceInputBehavior.textChangeCount), Long.valueOf(voiceInputBehavior.textChangeTime), Integer.valueOf(voiceInputBehavior.textChangeReturn), Long.valueOf(voiceInputBehavior.voiceInputTime), Integer.valueOf(voiceInputBehavior.fail), Integer.valueOf(voiceInputBehavior.clear), Integer.valueOf(voiceInputBehavior.smileIconClick), Integer.valueOf(voiceInputBehavior.voiceIconClick), Integer.valueOf(voiceInputBehavior.fullScreenVoiceLongClick), Long.valueOf(voiceInputBehavior.fullScreenVoiceLongClickTime));
        com.tencent.mm.bp.a log_13905 = new log_13905();
        log_13905.viOp_ = voiceInputBehavior;
        g.pWK.c(13905, log_13905);
    }
}
