package com.tencent.mm.plugin.appbrand.wxawidget.console;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.i;
import com.tencent.mm.ipcinvoker.type.IPCInteger;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.modelappbrand.e;
import com.tencent.mm.plugin.appbrand.wxawidget.b.b;
import com.tencent.mm.plugin.appbrand.wxawidget.b.c;
import com.tencent.mm.u.g;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;

public class SettingsPanel extends FrameLayout {
    private Button knE;
    private Button knF;
    OnClickListener knG;
    Runnable knH;

    private static class a implements h<IPCInteger, IPCVoid> {
        private a() {
        }

        public final /* synthetic */ void a(Object obj, i iVar) {
            g.gz(((IPCInteger) obj).value);
        }
    }

    public SettingsPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public SettingsPanel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(c.kmN, this, true);
        findViewById(b.kmK).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ((e) com.tencent.mm.kernel.g.h(e.class)).Jc().restart();
                com.tencent.mm.by.a.i(new Runnable() {
                    public final void run() {
                        Toast.makeText(SettingsPanel.this.getContext(), com.tencent.mm.plugin.appbrand.wxawidget.b.e.kmZ, 1).show();
                        if (SettingsPanel.this.knH != null) {
                            SettingsPanel.this.knH.run();
                        }
                    }
                }, 2000);
            }
        });
        MMSwitchBtn mMSwitchBtn = (MMSwitchBtn) findViewById(b.kmq);
        mMSwitchBtn.nJ(((e) com.tencent.mm.kernel.g.h(e.class)).Jd().Jf());
        mMSwitchBtn.zEt = new com.tencent.mm.ui.widget.MMSwitchBtn.a() {
            public final void cy(boolean z) {
                ((e) com.tencent.mm.kernel.g.h(e.class)).Jd().bB(z);
            }
        };
        this.knE = (Button) findViewById(b.kmo);
        mO(com.tencent.mm.plugin.appbrand.dynamic.widget.c.adD());
        this.knE.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("MHADrawableView");
                arrayList.add("MTextureView");
                arrayList.add("MSurfaceView");
                arrayList.add("MCanvasView");
                arrayList.add("MDrawableView");
                final com.tencent.mm.ui.widget.picker.b bVar = new com.tencent.mm.ui.widget.picker.b(SettingsPanel.this.getContext(), arrayList);
                bVar.HE(((Integer) SettingsPanel.this.knE.getTag()).intValue());
                bVar.zHi = new com.tencent.mm.ui.widget.picker.b.a() {
                    public final void f(boolean z, Object obj) {
                        bVar.hide();
                        if (z) {
                            SettingsPanel.this.knE.setText((CharSequence) obj);
                        }
                        SettingsPanel.this.mO(bVar.cAm());
                    }
                };
                bVar.HD(com.tencent.mm.bu.a.fromDPToPix(SettingsPanel.this.getContext(), 288));
                bVar.show();
            }
        });
        this.knF = (Button) findViewById(b.kmu);
        mP(g.Cm());
        this.knF.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                arrayList.add("Normal");
                arrayList.add("Minimal-json");
                final com.tencent.mm.ui.widget.picker.b bVar = new com.tencent.mm.ui.widget.picker.b(SettingsPanel.this.getContext(), arrayList);
                bVar.HE(((Integer) SettingsPanel.this.knF.getTag()).intValue());
                bVar.zHi = new com.tencent.mm.ui.widget.picker.b.a() {
                    public final void f(boolean z, Object obj) {
                        bVar.hide();
                        if (z) {
                            SettingsPanel.this.knF.setText((CharSequence) obj);
                        }
                        SettingsPanel.this.mP(bVar.cAm());
                    }
                };
                bVar.HD(com.tencent.mm.bu.a.fromDPToPix(SettingsPanel.this.getContext(), 288));
                bVar.show();
            }
        });
        findViewById(b.kme).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (SettingsPanel.this.knG != null) {
                    SettingsPanel.this.knG.onClick(view);
                }
            }
        });
        if (((e) com.tencent.mm.kernel.g.h(e.class)).Jd().Jg()) {
            findViewById(b.kmr).setVisibility(0);
            findViewById(b.kmp).setVisibility(0);
            findViewById(b.kmv).setVisibility(0);
        }
    }

    private void mO(int i) {
        this.knE.setTag(Integer.valueOf(i));
        switch (i) {
            case 1:
                this.knE.setText("MTextureView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.ke(1);
                return;
            case 2:
                this.knE.setText("MSurfaceView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.ke(2);
                return;
            case 3:
                this.knE.setText("MCanvasView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.ke(3);
                return;
            case 4:
                this.knE.setText("MDrawableView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.ke(4);
                return;
            default:
                this.knE.setText("MHADrawableView");
                com.tencent.mm.plugin.appbrand.dynamic.widget.c.ke(0);
                return;
        }
    }

    private void mP(int i) {
        CharSequence charSequence;
        int i2;
        this.knF.setTag(Integer.valueOf(i));
        switch (i) {
            case 1:
                charSequence = "Minimal-json";
                i2 = 1;
                break;
            default:
                charSequence = "Normal";
                i2 = 0;
                break;
        }
        this.knF.setText(charSequence);
        g.gz(i2);
        f.a("com.tencent.mm:support", new IPCInteger(i2), a.class, null);
    }
}
