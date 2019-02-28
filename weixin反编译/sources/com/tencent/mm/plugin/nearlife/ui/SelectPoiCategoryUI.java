package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ay.k;
import com.tencent.mm.f.a.lu;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SelectPoiCategoryUI extends MMActivity {
    static final String oWM = (w.hbv + "poi_categories");
    private ListView Fv;
    private OnMenuItemClickListener oWH = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            SelectPoiCategoryUI.this.setResult(0, null);
            SelectPoiCategoryUI.this.finish();
            return true;
        }
    };
    private a oWN;
    private ArrayAdapter<String> oWO;
    private List<String> oWP;
    private OnItemClickListener oWQ = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            x.d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", Integer.valueOf(i), Integer.valueOf(SelectPoiCategoryUI.this.oWP.size()));
            Intent intent = new Intent();
            intent.putExtra("poi_category", (String) SelectPoiCategoryUI.this.oWP.get(i));
            SelectPoiCategoryUI.this.setResult(-1, intent);
            SelectPoiCategoryUI.this.finish();
        }
    };

    private class a extends c<lu> {
        SelectPoiCategoryUI oWS;

        public a() {
            super(0);
            this.xmG = lu.class.getName().hashCode();
        }

        private boolean a(lu luVar) {
            if (luVar instanceof lu) {
                SelectPoiCategoryUI selectPoiCategoryUI = this.oWS;
                byte[] bArr = luVar.fEa.content;
                File file = new File(SelectPoiCategoryUI.oWM);
                if (!file.exists()) {
                    file.mkdir();
                }
                try {
                    String str = SelectPoiCategoryUI.oWM + "/lastest_poi_categories.dat";
                    File file2 = new File(str);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    e.b(str, bArr, bArr.length);
                } catch (Exception e) {
                    x.e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + e.getMessage());
                }
                selectPoiCategoryUI.aE(bArr);
                selectPoiCategoryUI.bfQ();
            }
            return false;
        }
    }

    protected final int getLayoutId() {
        return R.i.drS;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.oWP = new ArrayList();
        initView();
        this.oWN = new a();
        com.tencent.mm.sdk.b.a.xmy.b(this.oWN);
        this.oWN.oWS = this;
        as.CN().a(new k(17), 0);
    }

    protected final void initView() {
        setMMTitle(R.l.eym);
        setBackBtn(this.oWH);
        this.oWO = new ArrayAdapter(this, R.i.dpu);
        this.Fv = (ListView) findViewById(R.h.bSy);
        this.Fv.setAdapter(this.oWO);
        this.Fv.setOnItemClickListener(this.oWQ);
        if (!Hi(oWM + "/lastest_poi_categories.dat")) {
            try {
                o(getAssets().open("default_poi_categories.dat"));
            } catch (IOException e) {
                x.d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + e.getMessage());
            }
        }
        bfQ();
    }

    private boolean o(InputStream inputStream) {
        IOException e;
        Throwable th;
        if (inputStream == null) {
            return false;
        }
        this.oWP.clear();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.oWP.add(readLine);
                    } else {
                        try {
                            bufferedReader.close();
                            inputStream.close();
                            break;
                        } catch (Exception e2) {
                            x.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e2.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                }
            }
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            try {
                x.d("MicroMsg.SelectPoiCategoryUI", "read file failed: " + e.getMessage());
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e22) {
                        x.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e22.getMessage());
                    }
                }
                inputStream.close();
                return true;
            } catch (Throwable th2) {
                th = th2;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e5) {
                        x.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e5.getMessage());
                        throw th;
                    }
                }
                inputStream.close();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            inputStream.close();
            throw th;
        }
        return true;
    }

    private boolean Hi(String str) {
        boolean z = false;
        if (bi.oN(str)) {
            return z;
        }
        File file = new File(str);
        if (!file.exists()) {
            return z;
        }
        try {
            return o(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            x.d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", str, e.getMessage());
            return z;
        }
    }

    protected void onDestroy() {
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xmy.c(this.oWN);
    }

    final void aE(byte[] bArr) {
        String[] split = new String(bArr).split("\n");
        this.oWP.clear();
        for (String trim : split) {
            this.oWP.add(trim.trim());
        }
    }

    final void bfQ() {
        this.oWO.clear();
        for (int i = 0; i < this.oWP.size(); i++) {
            this.oWO.add(this.oWP.get(i));
        }
        this.oWO.notifyDataSetChanged();
    }
}
