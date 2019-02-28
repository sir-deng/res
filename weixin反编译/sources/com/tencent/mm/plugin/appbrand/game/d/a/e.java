package com.tencent.mm.plugin.appbrand.game.d.a;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.p;
import com.tencent.mm.plugin.appbrand.widget.input.a.b;
import com.tencent.mm.plugin.appbrand.widget.input.af;
import com.tencent.mm.plugin.appbrand.widget.input.n;
import com.tencent.mm.plugin.appbrand.widget.input.u;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.j;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class e extends a {
    private static final int CTRL_INDEX = 1;
    private static final String NAME = "showKeyboard";
    final c jcQ = new c();
    final a jcR = new a();
    final b jcS = new b();

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.a.e$3 */
    class AnonymousClass3 extends j {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.j jcM;

        AnonymousClass3(com.tencent.mm.plugin.appbrand.j jVar) {
            this.jcM = jVar;
        }

        public final void afterTextChanged(Editable editable) {
            if (!af.t(editable)) {
                e.this.jcQ.a(editable.toString(), this.jcM);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.a.e$2 */
    class AnonymousClass2 extends n.a {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.j jcM;
        final /* synthetic */ WAGamePanelInputEditText jcZ;

        AnonymousClass2(WAGamePanelInputEditText wAGamePanelInputEditText, com.tencent.mm.plugin.appbrand.j jVar) {
            this.jcZ = wAGamePanelInputEditText;
            this.jcM = jVar;
        }

        public final void aeD() {
            e.this.jcQ.a(this.jcZ.getEditableText().toString(), this.jcM);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.a.e$5 */
    class AnonymousClass5 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.j jcM;
        final /* synthetic */ WAGamePanelInputEditText jcZ;
        final /* synthetic */ com.tencent.mm.plugin.appbrand.game.widget.input.a jda;

        AnonymousClass5(WAGamePanelInputEditText wAGamePanelInputEditText, com.tencent.mm.plugin.appbrand.j jVar, com.tencent.mm.plugin.appbrand.game.widget.input.a aVar) {
            this.jcZ = wAGamePanelInputEditText;
            this.jcM = jVar;
            this.jda = aVar;
        }

        public final void onClick(View view) {
            e.this.jcS.a(this.jcZ.getEditableText().toString(), this.jcM);
            e.this.jcQ.a(this.jcZ.getEditableText().toString(), this.jcM);
            this.jda.hide();
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.a.e$6 */
    class AnonymousClass6 implements com.tencent.mm.plugin.appbrand.widget.input.u.e {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.j jcM;
        final /* synthetic */ WAGamePanelInputEditText jcZ;

        AnonymousClass6(WAGamePanelInputEditText wAGamePanelInputEditText, com.tencent.mm.plugin.appbrand.j jVar) {
            this.jcZ = wAGamePanelInputEditText;
            this.jcM = jVar;
        }

        public final void ki(int i) {
            if (2 == i) {
                a aVar = e.this.jcR;
                String obj = this.jcZ.getEditableText().toString();
                c cVar = this.jcM;
                Map hashMap = new HashMap(2);
                hashMap.put("errMsg", "ok");
                hashMap.put(Columns.VALUE, obj);
                aVar.v(hashMap).a(cVar).afI();
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.a.e$7 */
    class AnonymousClass7 implements OnEditorActionListener {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.j jcM;
        final /* synthetic */ boolean jcW;
        final /* synthetic */ WAGamePanelInputEditText jcZ;

        AnonymousClass7(boolean z, WAGamePanelInputEditText wAGamePanelInputEditText, com.tencent.mm.plugin.appbrand.j jVar) {
            this.jcW = z;
            this.jcZ = wAGamePanelInputEditText;
            this.jcM = jVar;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (!this.jcW) {
                return false;
            }
            e.this.jcS.a(this.jcZ.getEditableText().toString(), this.jcM);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.game.d.a.e$4 */
    class AnonymousClass4 implements b {
        final /* synthetic */ com.tencent.mm.plugin.appbrand.j jcM;
        final /* synthetic */ WAGamePanelInputEditText jcZ;

        AnonymousClass4(WAGamePanelInputEditText wAGamePanelInputEditText, com.tencent.mm.plugin.appbrand.j jVar) {
            this.jcZ = wAGamePanelInputEditText;
            this.jcM = jVar;
        }

        public final void aeE() {
            e.this.jcQ.a(this.jcZ.getEditableText().toString(), this.jcM);
        }
    }

    public final void a(com.tencent.mm.plugin.appbrand.j jVar, JSONObject jSONObject, int i) {
        final String optString = jSONObject.optString("defaultValue");
        int optInt = jSONObject.optInt("maxLength", com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX);
        if (optInt <= 0) {
            optInt = Integer.MAX_VALUE;
        }
        final boolean optBoolean = jSONObject.optBoolean("multiple", false);
        final boolean optBoolean2 = jSONObject.optBoolean("confirmHold", false);
        final com.tencent.mm.plugin.appbrand.widget.input.b.b vF = com.tencent.mm.plugin.appbrand.widget.input.b.b.vF(jSONObject.optString("confirmType"));
        final com.tencent.mm.plugin.appbrand.j jVar2 = jVar;
        final int i2 = i;
        ah.y(new Runnable() {
            public final void run() {
                e eVar = e.this;
                com.tencent.mm.plugin.appbrand.j jVar = jVar2;
                CharSequence charSequence = optString;
                int i = optInt;
                boolean z = optBoolean;
                boolean z2 = optBoolean2;
                com.tencent.mm.plugin.appbrand.widget.input.b.b bVar = vF;
                if (jVar.Vx) {
                    p b = com.tencent.mm.plugin.appbrand.jsapi.e.b(jVar);
                    if (b != null) {
                        u bG = com.tencent.mm.plugin.appbrand.game.widget.input.a.bG(b.getContentView());
                        EditText afn = bG.afn();
                        if (bi.oN(charSequence)) {
                            afn.setText("");
                        } else {
                            if (charSequence.length() > i) {
                                charSequence = charSequence.substring(0, i);
                            }
                            afn.setText(charSequence);
                            afn.setSelection(afn.getText().length());
                        }
                        afn.setSingleLine(!z);
                        afn.jdQ = i;
                        com.tencent.mm.ui.tools.a.c Hg = n.a(afn).Hg(i);
                        Hg.zwQ = false;
                        Hg.kdI = h.a.ztX;
                        Hg.a(new AnonymousClass2(afn, jVar));
                        afn.addTextChangedListener(new AnonymousClass3(jVar));
                        afn.jdO.keU = new AnonymousClass4(afn, jVar);
                        bG.jdL = new AnonymousClass5(afn, jVar, bG);
                        bG.kek = new AnonymousClass6(afn, jVar);
                        if (!z) {
                            afn.setOnEditorActionListener(new AnonymousClass7(z2, afn, jVar));
                        }
                        bG.afn().setImeOptions((bVar == null ? com.tencent.mm.plugin.appbrand.widget.input.b.b.DONE : bVar).khj);
                        bG.afn().setFocusable(true);
                        bG.afn().setFocusableInTouchMode(true);
                        bG.show();
                    }
                }
                jVar2.E(i2, e.this.e("ok", null));
            }
        });
    }
}
