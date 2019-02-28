package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.g;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.pluginsdk.ui.chat.d;
import com.tencent.mm.pluginsdk.ui.chat.e;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.BasePanelKeybordLayout;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;

public class SnsSightUploadSayFooter extends BasePanelKeybordLayout {
    MMActivity fnF;
    private ImageButton opZ;
    ChatFooterPanel oqc;
    private boolean oqf = true;
    MMEditText rMD = null;
    SightRangeWidget rME;
    SightLocationWidget rMF;

    static /* synthetic */ void d(SnsSightUploadSayFooter snsSightUploadSayFooter) {
        if (snsSightUploadSayFooter.oqc.getVisibility() == 8) {
            snsSightUploadSayFooter.fnF.aWY();
            snsSightUploadSayFooter.oqc.onResume();
            snsSightUploadSayFooter.oqc.setVisibility(0);
            snsSightUploadSayFooter.rMD.requestFocus();
            snsSightUploadSayFooter.opZ.setImageResource(i.qOX);
            snsSightUploadSayFooter.oqf = false;
            return;
        }
        snsSightUploadSayFooter.oqf = false;
        snsSightUploadSayFooter.rMD.requestFocus();
        snsSightUploadSayFooter.hideSmileyPanel();
        snsSightUploadSayFooter.fnF.showVKB();
        snsSightUploadSayFooter.opZ.setImageResource(i.qOW);
    }

    public SnsSightUploadSayFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fnF = (MMActivity) context;
        ViewGroup viewGroup = (ViewGroup) inflate(this.fnF, g.qNS, this);
        this.opZ = (ImageButton) viewGroup.findViewById(f.bJR);
        this.opZ.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                SnsSightUploadSayFooter.d(SnsSightUploadSayFooter.this);
            }
        });
        if (e.vxZ == null) {
            this.oqc = new d(this.fnF);
        } else {
            this.oqc = e.vxZ.cw(getContext());
            this.oqc.ej(ChatFooterPanel.SCENE_SNS);
            this.oqc.setVisibility(8);
            ((LinearLayout) findViewById(f.cIB)).addView(this.oqc, -1, 0);
            this.oqc.tk();
            this.oqc.aH(false);
            this.oqc.vqj = new a() {
                public final void aYA() {
                }

                public final void gA(boolean z) {
                }

                public final void anG() {
                    SnsSightUploadSayFooter.this.rMD.zCS.sendKeyEvent(new KeyEvent(0, 67));
                    SnsSightUploadSayFooter.this.rMD.zCS.sendKeyEvent(new KeyEvent(1, 67));
                }

                public final void append(String str) {
                    try {
                        SnsSightUploadSayFooter.this.rMD.aaU(str);
                    } catch (Throwable e) {
                        x.printErrStackTrace("MicroMsg.SnsSightUploadSayFooter", e, "", new Object[0]);
                    }
                }
            };
        }
        this.rME = (SightRangeWidget) viewGroup.findViewById(f.qJh);
        this.rME.rxp = null;
        this.rME.style = 1;
        this.rMF = (SightLocationWidget) viewGroup.findViewById(f.qIR);
    }

    private void hideSmileyPanel() {
        this.oqc.onPause();
        this.oqc.setVisibility(8);
    }

    protected final List<View> aYz() {
        List<View> arrayList = new ArrayList();
        arrayList.add(this.oqc);
        return arrayList;
    }
}
