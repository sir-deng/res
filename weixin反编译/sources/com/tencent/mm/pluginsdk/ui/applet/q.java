package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ad.e;
import com.tencent.mm.ad.k;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.b.b;
import com.tencent.mm.plugin.comm.a.f;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.tools.h;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.i;
import com.tencent.mm.ui.base.r;
import java.util.LinkedList;
import junit.framework.Assert;

public final class q implements e {
    String content = "";
    Context context;
    LinkedList<Integer> pCn;
    i pDT = null;
    View pDU;
    TextView pDV;
    EditText pwv;
    r tipDialog;
    private LinkedList<String> vtx = new LinkedList();
    String vty;
    a vvb;
    LinkedList<String> vvc;
    boolean vvd = true;
    private boolean vve = false;

    public interface a {
        void ep(boolean z);
    }

    public q(Context context, a aVar) {
        this.context = context;
        this.vvb = aVar;
    }

    final void onStart() {
        g.Dp().gRu.a(30, (e) this);
        g.Dp().gRu.a((int) com.tencent.mm.plugin.appbrand.jsapi.f.g.CTRL_INDEX, (e) this);
    }

    final void onStop() {
        g.Dp().gRu.b(30, (e) this);
        g.Dp().gRu.b((int) com.tencent.mm.plugin.appbrand.jsapi.f.g.CTRL_INDEX, (e) this);
        if (this.pDT != null) {
            this.pDT.dismiss();
            this.pDT = null;
        }
    }

    public final void g(LinkedList<String> linkedList, LinkedList<Integer> linkedList2) {
        a(linkedList, linkedList2, new LinkedList());
    }

    public final void a(LinkedList<String> linkedList, LinkedList<Integer> linkedList2, LinkedList<String> linkedList3) {
        boolean z;
        Assert.assertTrue(linkedList.size() > 0);
        if (linkedList2.size() > 0) {
            z = true;
        } else {
            z = false;
        }
        Assert.assertTrue(z);
        onStart();
        this.vvc = linkedList;
        this.pCn = linkedList2;
        this.vtx = linkedList3;
        this.pDU = View.inflate(this.context, f.drZ, null);
        String str = "MicroMsg.SendVerifyRequest";
        String str2 = "verifyTip is null: %b, length : %d, value : [%s]";
        Object[] objArr = new Object[3];
        if (this.vty == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Integer.valueOf(this.vty == null ? 0 : this.vty.length());
        objArr[2] = this.vty;
        x.i(str, str2, objArr);
        if (!bi.oN(this.vty)) {
            ((TextView) this.pDU.findViewById(com.tencent.mm.plugin.comm.a.e.cLI)).setText(this.vty);
        }
        this.pwv = (EditText) this.pDU.findViewById(com.tencent.mm.plugin.comm.a.e.cLH);
        this.pDV = (TextView) this.pDU.findViewById(com.tencent.mm.plugin.comm.a.e.cZN);
        this.pDV.setVisibility(0);
        this.pwv.setText(null);
        this.pDV.setText("50");
        this.pwv.setFilters(h.vEv);
        this.pwv.addTextChangedListener(new TextWatcher() {
            public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public final void afterTextChanged(Editable editable) {
                int length = 50 - editable.length();
                if (length < 0) {
                    length = 0;
                }
                if (q.this.pDV != null) {
                    q.this.pDV.setText(String.valueOf(length));
                }
            }
        });
        this.pDT = com.tencent.mm.ui.base.h.a(this.context, this.context.getString(com.tencent.mm.plugin.comm.a.h.eKt), this.pDU, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (q.this.pDT != null) {
                    q.this.pDT.dismiss();
                    q.this.pDT = null;
                }
                new al(new com.tencent.mm.sdk.platformtools.al.a() {
                    public final boolean uG() {
                        if (q.this.pDU != null) {
                            q qVar = q.this;
                            String trim = q.this.pwv.getText().toString().trim();
                            Context context = qVar.context;
                            qVar.context.getString(com.tencent.mm.plugin.comm.a.h.dGZ);
                            qVar.tipDialog = com.tencent.mm.ui.base.h.a(context, qVar.context.getString(com.tencent.mm.plugin.comm.a.h.eKs), true, new OnCancelListener() {
                                public final void onCancel(DialogInterface dialogInterface) {
                                    q.this.onStop();
                                    if (q.this.vvb != null) {
                                        q.this.vvb.ep(false);
                                    }
                                }
                            });
                            qVar.content = trim;
                            if (qVar.vvc.size() == 1 && com.tencent.mm.storage.x.Xg((String) qVar.vvc.getFirst())) {
                                qVar.cbO();
                            } else {
                                g.Dp().gRu.a(new o(2, qVar.vvc, qVar.pCn, trim, ""), 0);
                            }
                        }
                        return false;
                    }
                }, false).K(500, 500);
            }
        }, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (q.this.pDT != null) {
                    q.this.pDT.dismiss();
                    q.this.pDT = null;
                }
                q.this.onStop();
                if (q.this.vvb != null) {
                    q.this.vvb.ep(false);
                }
            }
        });
        if (this.pDT == null) {
            onStop();
        }
        this.pwv.post(new Runnable() {
            public final void run() {
                if (q.this.context instanceof MMActivity) {
                    ((MMActivity) q.this.context).showVKB();
                }
            }
        });
    }

    final void cbO() {
        if (this.vtx.isEmpty()) {
            this.vve = true;
            g.Dp().gRu.a(881, (e) this);
            g.Dp().gRu.a(new b((String) this.vvc.getFirst(), "", ""), 0);
            return;
        }
        g.Dp().gRu.a(new com.tencent.mm.openim.b.f((String) this.vvc.getFirst(), this.content, (String) this.vtx.getFirst()), 0);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 881) {
            g.Dp().gRu.b(881, (e) this);
            if (i != 0 || i2 != 0) {
                Toast.makeText(this.context, this.context.getString(com.tencent.mm.plugin.comm.a.h.eKq), 1).show();
            } else if (this.vve) {
                g.Dp().gRu.a(new com.tencent.mm.openim.b.f((String) this.vvc.getFirst(), this.content, ((b) kVar).idE.vNZ), 0);
            }
            this.vve = false;
        } else if (kVar.getType() == 30 || kVar.getType() == com.tencent.mm.plugin.appbrand.jsapi.f.g.CTRL_INDEX) {
            x.d("MicroMsg.SendVerifyRequest", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (this.tipDialog != null) {
                this.tipDialog.dismiss();
                this.tipDialog = null;
            }
            onStop();
            if (i == 0 && i2 == 0) {
                if (this.vvd) {
                    com.tencent.mm.ui.base.h.bu(this.context, this.context.getString(com.tencent.mm.plugin.comm.a.h.eKr));
                }
                this.vvb.ep(true);
                return;
            }
            CharSequence str2;
            if (i == 4 && i2 == -34) {
                str2 = this.context.getString(com.tencent.mm.plugin.comm.a.h.eix);
            } else if (i == 4 && i2 == -94) {
                str2 = this.context.getString(com.tencent.mm.plugin.comm.a.h.eiy);
            } else if (!(i == 4 && i2 == -24 && !bi.oN(str2)) && (i != 4 || bi.oN(str2))) {
                str2 = this.context.getString(com.tencent.mm.plugin.comm.a.h.eKq);
            }
            if (this.vvd) {
                Toast.makeText(this.context, str2, 1).show();
            }
            this.vvb.ep(false);
        } else {
            x.w("MicroMsg.SendVerifyRequest", "not expected scene,  type = " + kVar.getType());
        }
    }
}
