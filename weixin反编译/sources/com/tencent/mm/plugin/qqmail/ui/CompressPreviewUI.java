package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.plugin.qqmail.b.p;
import com.tencent.mm.plugin.qqmail.b.w;
import com.tencent.mm.pluginsdk.ui.tools.FileExplorerUI;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CompressPreviewUI extends MMActivity {
    private ProgressBar ksa;
    private TextView mVB;
    private String ptN = null;
    private String puB = null;
    private String pwa;
    private c pwz = new c(this);
    private long pxp = 0;
    private List<a> pxq = new ArrayList();
    private String pxr;
    private ListView pxs;
    private b pxt;
    private com.tencent.mm.plugin.qqmail.b.p.a pxu = new com.tencent.mm.plugin.qqmail.b.p.a() {
        public final void onSuccess(String str, Map<String, String> map) {
            CompressPreviewUI.this.pxr = (String) map.get(".Response.result.compressfilepath");
            int i = bi.getInt((String) map.get(".Response.result.filelist.count"), 0);
            int i2 = 0;
            while (i2 < i) {
                try {
                    String str2 = ".Response.result.filelist.list.item" + (i2 > 0 ? Integer.valueOf(i2) : "");
                    String str3 = (String) map.get(str2 + ".path");
                    if (str3 != null) {
                        String str4;
                        String decode = URLDecoder.decode(str3, ProtocolPackage.ServerEncoding);
                        String str5 = (String) map.get(str2 + ".parentpath");
                        int i3 = bi.getInt((String) map.get(str2 + ".size"), 0);
                        int i4 = bi.getInt((String) map.get(str2 + ".type"), 0);
                        boolean equals = ((String) map.get(str2 + ".preview")).equals("1");
                        String str6 = (String) map.get(str2 + ".name");
                        List h = CompressPreviewUI.this.pxq;
                        CompressPreviewUI compressPreviewUI = CompressPreviewUI.this;
                        if (i3 == 0) {
                            str4 = "";
                        } else {
                            str4 = "(" + bi.by((long) i3) + ")";
                        }
                        h.add(new a(decode, str6, str5, i4, str4, equals));
                    }
                    i2++;
                } catch (Throwable e) {
                    x.printErrStackTrace("MicroMsg.CompressPreviewUI", e, "", new Object[0]);
                }
            }
            CompressPreviewUI.this.Iv("");
        }

        public final void onError(int i, String str) {
            if (i == -5) {
                CompressPreviewUI.this.pwz.a(new com.tencent.mm.plugin.qqmail.ui.c.a() {
                    public final void blc() {
                        CompressPreviewUI.this.blq();
                    }

                    public final void bld() {
                    }
                });
                return;
            }
            CompressPreviewUI.this.ksa.setVisibility(8);
            CompressPreviewUI.this.mVB.setVisibility(0);
            CompressPreviewUI.this.pxs.setVisibility(8);
        }
    };

    private class b extends BaseAdapter {
        a pxA;
        List<a> pxB;

        private class a {
            ImageView jIs;
            TextView lmk;
            TextView pxC;
            ImageView pxD;

            private a() {
            }

            /* synthetic */ a(b bVar, byte b) {
                this();
            }
        }

        private b() {
            this.pxB = null;
        }

        /* synthetic */ b(CompressPreviewUI compressPreviewUI, byte b) {
            this();
        }

        public final /* synthetic */ Object getItem(int i) {
            return vu(i);
        }

        public final String bls() {
            if (this.pxA == null || this.pxA.pxx == null) {
                return null;
            }
            if (this.pxA.pxx.length() == 0) {
                return "";
            }
            int indexOf = this.pxA.id.indexOf(this.pxA.pxx);
            if (indexOf >= 0) {
                return this.pxA.id.substring(0, indexOf) + this.pxA.pxx;
            }
            return null;
        }

        public final int getCount() {
            return this.pxB != null ? this.pxB.size() : 0;
        }

        public final a vu(int i) {
            return (this.pxB == null || this.pxB.size() <= i) ? null : (a) this.pxB.get(i);
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            ImageView imageView;
            int Tr;
            if (view == null) {
                view = View.inflate(CompressPreviewUI.this.mController.xRr, R.i.dmU, null);
                a aVar = new a();
                aVar.jIs = (ImageView) view.findViewById(R.h.chJ);
                aVar.lmk = (TextView) view.findViewById(R.h.chP);
                aVar.pxC = (TextView) view.findViewById(R.h.chQ);
                aVar.pxD = (ImageView) view.findViewById(R.h.chR);
                view.setTag(aVar);
            }
            a aVar2 = (a) view.getTag();
            a vu = vu(i);
            if (i != 0 || bls() == null) {
                imageView = aVar2.jIs;
                Tr = vu.blr() ? R.g.bET : FileExplorerUI.Tr(vu.name);
            } else {
                imageView = aVar2.jIs;
                Tr = R.g.bES;
            }
            imageView.setImageResource(Tr);
            aVar2.pxD.setVisibility(vu.pxz ? 0 : 4);
            aVar2.lmk.setText(vu.name);
            aVar2.pxC.setText(vu.pxy);
            return view;
        }
    }

    private class a {
        String id;
        String name;
        String pxx;
        String pxy;
        boolean pxz;
        int type;

        public a(String str, String str2, String str3, int i, String str4, boolean z) {
            this.id = str;
            this.name = str2;
            if (str3 == null) {
                str3 = "";
            }
            this.pxx = str3;
            this.type = i;
            this.pxy = str4;
            this.pxz = z;
        }

        public final boolean blr() {
            return this.type == 1;
        }
    }

    protected final int getLayoutId() {
        return R.i.dmV;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.ptN = getIntent().getStringExtra("mail_id");
        this.puB = getIntent().getStringExtra("attach_id");
        this.pxp = getIntent().getLongExtra("attach_size", 0);
        this.pwa = getIntent().getStringExtra("attach_name");
        initView();
        setMMTitle(this.pwa);
    }

    protected final void initView() {
        this.pxs = (ListView) findViewById(R.h.bWN);
        this.mVB = (TextView) findViewById(R.h.bWL);
        this.ksa = (ProgressBar) findViewById(R.h.bWM);
        if (this.ptN == null || this.puB == null) {
            this.ksa.setVisibility(8);
            this.mVB.setText(R.l.eul);
            return;
        }
        this.pxt = new b();
        this.pxs.setAdapter(this.pxt);
        this.pxs.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                a vu = CompressPreviewUI.this.pxt.vu(i);
                String str = vu.id;
                b a = CompressPreviewUI.this.pxt;
                if (str.equals(a.pxA == null ? null : a.pxA.id)) {
                    CompressPreviewUI.this.Iv(CompressPreviewUI.this.pxt.bls());
                } else if (vu.blr()) {
                    CompressPreviewUI.this.Iv(vu.id);
                } else if (vu.pxz) {
                    String[] strArr = new String[]{"mailid=" + CompressPreviewUI.this.ptN, "attachid=" + vu.id, "compressfilepath=" + CompressPreviewUI.this.pxr, "texttype=html"};
                    Intent intent = new Intent(CompressPreviewUI.this, MailWebViewUI.class);
                    intent.putExtra("uri", "/cgi-bin/viewdocument");
                    intent.putExtra("params", strArr);
                    intent.putExtra("baseurl", p.bkU());
                    intent.putExtra("method", "get");
                    intent.putExtra("singleColumn", FileExplorerUI.Ts(vu.name));
                    intent.putExtra("title", CompressPreviewUI.this.getString(R.l.eCr));
                    CompressPreviewUI.this.startActivity(intent);
                }
            }
        });
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                CompressPreviewUI.this.onKeyDown(4, null);
                return true;
            }
        });
        AnonymousClass3 anonymousClass3 = new OnClickListener() {
            public final void onClick(View view) {
                c.a(CompressPreviewUI.this.pxs);
            }
        };
        addTextOptionMenu(0, getString(R.l.dEK), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                Intent intent = new Intent(CompressPreviewUI.this, AttachDownloadPage.class);
                intent.putExtra("attach_name", CompressPreviewUI.this.pwa);
                intent.putExtra("mail_id", CompressPreviewUI.this.ptN);
                intent.putExtra("attach_id", CompressPreviewUI.this.puB);
                intent.putExtra("total_size", CompressPreviewUI.this.pxp);
                intent.putExtra("is_preview", 0);
                intent.putExtra("is_compress", true);
                CompressPreviewUI.this.startActivity(intent);
                return true;
            }
        });
        blq();
    }

    public void onDestroy() {
        super.onDestroy();
        this.pwz.release();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.pxt.bls() != null) {
            Iv(this.pxt.bls());
            return true;
        } else if (keyEvent != null) {
            return super.onKeyDown(i, keyEvent);
        } else {
            finish();
            return true;
        }
    }

    private void Iv(String str) {
        x.i("MicroMsg.CompressPreviewUI", "curPath=" + str);
        this.ksa.setVisibility(8);
        this.mVB.setVisibility(8);
        this.pxs.setVisibility(0);
        a Iw = Iw(str);
        List arrayList = new ArrayList();
        if (Iw != null) {
            arrayList.add(Iw);
        }
        for (int i = 0; i < this.pxq.size(); i++) {
            a aVar = (a) this.pxq.get(i);
            if ((str.endsWith(aVar.pxx) && aVar.pxx.length() > 0) || aVar.pxx.equals(str)) {
                arrayList.add(aVar);
            }
        }
        b bVar = this.pxt;
        bVar.pxA = Iw;
        bVar.pxB = arrayList;
        this.pxt.notifyDataSetChanged();
        this.pxs.setSelection(0);
    }

    private a Iw(String str) {
        for (a aVar : this.pxq) {
            if (aVar.id.equals(str)) {
                return aVar;
            }
        }
        return null;
    }

    private void blq() {
        Map hashMap = new HashMap();
        hashMap.put("mailid", this.ptN);
        hashMap.put("attachid", this.puB);
        hashMap.put("fun", "list");
        w.bkZ().a("/cgi-bin/viewcompress", hashMap, new p.c(), this.pxu);
    }
}
