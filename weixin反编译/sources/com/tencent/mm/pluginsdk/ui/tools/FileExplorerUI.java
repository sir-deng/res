package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
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
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.y.as;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FileExplorerUI extends MMActivity {
    private int vDl = 0;
    private ListView vDm;
    private a vDn;
    private TextView vDo;
    private TextView vDp;
    private View vDq;
    private View vDr;
    private String vDs;
    private String vDt;
    private File vDu;
    private File vDv;

    private class a extends BaseAdapter {
        String hVg;
        private File vDA;
        private File[] vDB;
        private File vDz;

        private a() {
        }

        /* synthetic */ a(FileExplorerUI fileExplorerUI, byte b) {
            this();
        }

        public final void e(File file, File file2) {
            byte b = (byte) 0;
            this.vDz = file;
            if (file2.getAbsolutePath().equalsIgnoreCase(this.hVg)) {
                this.vDz = null;
            }
            this.vDA = file2;
            if (this.vDA.canRead() && this.vDA.isDirectory()) {
                this.vDB = this.vDA.listFiles(new FileFilter() {
                    public final boolean accept(File file) {
                        if (file.isHidden()) {
                            return false;
                        }
                        return true;
                    }
                });
                if (this.vDB.length > 0) {
                    File[] fileArr = this.vDB;
                    if (fileArr != null && fileArr.length != 0) {
                        int i;
                        List arrayList = new ArrayList();
                        List<b> arrayList2 = new ArrayList();
                        for (File file3 : fileArr) {
                            b bVar = new b(FileExplorerUI.this, (byte) 0);
                            bVar.file = file3;
                            bVar.vDD = com.tencent.mm.platformtools.c.oD(file3.getName()).toUpperCase();
                            if (file3.isDirectory()) {
                                arrayList.add(bVar);
                            } else {
                                arrayList2.add(bVar);
                            }
                        }
                        Collections.sort(arrayList, new Comparator<b>() {
                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return ((b) obj).vDD.compareTo(((b) obj2).vDD);
                            }
                        });
                        Collections.sort(arrayList2, new Comparator<b>() {
                            public final /* synthetic */ int compare(Object obj, Object obj2) {
                                return ((b) obj).vDD.compareTo(((b) obj2).vDD);
                            }
                        });
                        Iterator it = arrayList.iterator();
                        while (true) {
                            i = b;
                            if (!it.hasNext()) {
                                break;
                            }
                            fileArr[i] = ((b) it.next()).file;
                            b = i + 1;
                        }
                        for (b bVar2 : arrayList2) {
                            fileArr[i] = bVar2.file;
                            i++;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            this.vDB = new File[0];
        }

        public final int getCount() {
            int i = 0;
            if (this.vDB == null) {
                return 0;
            }
            int length = this.vDB.length;
            if (this.vDz != null) {
                i = 1;
            }
            return i + length;
        }

        public final Object getItem(int i) {
            if (this.vDz != null && i == 0) {
                return this.vDz;
            }
            x.d("FileExplorer", "pos:" + i + ", subFile length:" + this.vDB.length);
            File[] fileArr = this.vDB;
            if (this.vDz != null) {
                i--;
            }
            return fileArr[i];
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = View.inflate(FileExplorerUI.this, R.i.dmX, null);
                c cVar = new c(FileExplorerUI.this, (byte) 0);
                cVar.jIs = (ImageView) view.findViewById(R.h.chJ);
                cVar.lmk = (TextView) view.findViewById(R.h.chP);
                cVar.vDE = (TextView) view.findViewById(R.h.chS);
                view.setTag(cVar);
            }
            c cVar2 = (c) view.getTag();
            File file = (File) getItem(i);
            if (file == this.vDz) {
                cVar2.lmk.setText(file.getName());
                cVar2.jIs.setImageResource(R.g.bES);
                cVar2.vDE.setVisibility(0);
            } else {
                cVar2.jIs.setImageResource(FileExplorerUI.E(file));
                cVar2.lmk.setText(file.getName());
                cVar2.vDE.setText(DateFormat.format("yyyy-MM-dd hh:mm:ss", file.lastModified()).toString() + (file.isDirectory() ? "" : "  " + bi.by(file.length())));
            }
            return view;
        }
    }

    private class b {
        File file;
        String vDD;

        private b() {
        }

        /* synthetic */ b(FileExplorerUI fileExplorerUI, byte b) {
            this();
        }
    }

    private class c {
        ImageView jIs;
        TextView lmk;
        TextView vDE;

        private c() {
        }

        /* synthetic */ c(FileExplorerUI fileExplorerUI, byte b) {
            this();
        }
    }

    static /* synthetic */ int E(File file) {
        return file.isDirectory() ? R.g.bET : Tr(file.getName());
    }

    static /* synthetic */ void cdi() {
    }

    protected final int getLayoutId() {
        return R.i.dmW;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (bi.oN(stringExtra)) {
            setMMTitle(R.l.eAQ);
        } else {
            setMMTitle(stringExtra);
        }
        initView();
    }

    protected void onResume() {
        super.onResume();
    }

    protected void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || this.vDn.vDz == null) {
            if (this.vDv != null) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(131074, this.vDv.getAbsolutePath());
            }
            if (this.vDu != null) {
                as.Hm();
                com.tencent.mm.y.c.Db().set(131073, this.vDu.getAbsolutePath());
            }
            return super.onKeyDown(i, keyEvent);
        }
        if (1 == this.vDl) {
            this.vDv = this.vDn.vDz;
        } else if (this.vDl == 0) {
            this.vDu = this.vDn.vDz;
        }
        this.vDn.e(this.vDn.vDz.getParentFile(), this.vDn.vDz);
        this.vDn.notifyDataSetChanged();
        this.vDm.setSelection(0);
        return true;
    }

    protected final void initView() {
        File file;
        File externalStorageDirectory;
        t Db;
        File file2;
        TextView textView;
        boolean z;
        TextView textView2;
        boolean z2 = true;
        Object obj = null;
        this.vDm = (ListView) findViewById(R.h.cFc);
        this.vDo = (TextView) findViewById(R.h.cIF);
        this.vDq = findViewById(R.h.cIG);
        this.vDp = (TextView) findViewById(R.h.cJp);
        this.vDr = findViewById(R.h.cJq);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                if (FileExplorerUI.this.vDn.vDz != null) {
                    if (1 == FileExplorerUI.this.vDl) {
                        FileExplorerUI.this.vDv = FileExplorerUI.this.vDn.vDz;
                    } else if (FileExplorerUI.this.vDl == 0) {
                        FileExplorerUI.this.vDu = FileExplorerUI.this.vDn.vDz;
                    }
                    FileExplorerUI.this.vDn.e(FileExplorerUI.this.vDn.vDz.getParentFile(), FileExplorerUI.this.vDn.vDz);
                    FileExplorerUI.this.vDn.notifyDataSetChanged();
                    FileExplorerUI.this.vDm.setSelection(0);
                    FileExplorerUI.cdi();
                } else {
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(131074, FileExplorerUI.this.vDv.getAbsolutePath());
                    as.Hm();
                    com.tencent.mm.y.c.Db().set(131073, FileExplorerUI.this.vDu.getAbsolutePath());
                    FileExplorerUI.this.finish();
                }
                return true;
            }
        });
        this.vDs = getString(R.l.eAO);
        this.vDt = getString(R.l.eAP);
        File rootDirectory = h.getRootDirectory();
        if (rootDirectory.canRead()) {
            file = rootDirectory;
        } else {
            rootDirectory = h.getDataDirectory();
            if (rootDirectory.canRead()) {
                this.vDs = rootDirectory.getName();
                file = rootDirectory;
            } else {
                file = null;
            }
        }
        as.Hm();
        if (com.tencent.mm.y.c.isSDCardAvailable()) {
            externalStorageDirectory = h.getExternalStorageDirectory();
        } else {
            rootDirectory = h.getDownloadCacheDirectory();
            if (rootDirectory.canRead()) {
                this.vDt = rootDirectory.getName();
                externalStorageDirectory = rootDirectory;
            } else {
                externalStorageDirectory = null;
            }
        }
        as.Hm();
        String str = (String) com.tencent.mm.y.c.Db().get(131073, file == null ? null : file.getAbsolutePath());
        if (!(str == null || file == null || file.getAbsolutePath().equals(str))) {
            File file3 = new File(str);
            if (file3.exists()) {
                rootDirectory = file3;
                this.vDu = rootDirectory;
                as.Hm();
                Db = com.tencent.mm.y.c.Db();
                if (externalStorageDirectory != null) {
                    obj = externalStorageDirectory.getAbsolutePath();
                }
                str = (String) Db.get(131074, obj);
                if (!(str == null || externalStorageDirectory == null || externalStorageDirectory.getAbsolutePath().equals(str))) {
                    file2 = new File(str);
                    if (file2.exists()) {
                        rootDirectory = file2;
                        this.vDv = rootDirectory;
                        this.vDn = new a();
                        if (externalStorageDirectory == null) {
                            CS(1);
                            this.vDn.hVg = externalStorageDirectory.getPath();
                            this.vDn.e(this.vDv.getParentFile(), this.vDv);
                        } else if (file == null) {
                            CS(0);
                            this.vDn.hVg = file.getPath();
                            this.vDn.e(this.vDu.getParentFile(), this.vDu);
                        } else {
                            x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                            return;
                        }
                        textView = this.vDo;
                        if (file == null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        textView.setEnabled(z);
                        textView2 = this.vDp;
                        if (externalStorageDirectory == null) {
                            z2 = false;
                        }
                        textView2.setEnabled(z2);
                        this.vDm.setAdapter(this.vDn);
                        this.vDn.notifyDataSetChanged();
                        this.vDm.setOnItemClickListener(new OnItemClickListener() {
                            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                                File file = (File) FileExplorerUI.this.vDn.getItem(i);
                                if (1 == FileExplorerUI.this.vDl) {
                                    if (file.isFile()) {
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().set(131074, FileExplorerUI.this.vDn.vDA.getAbsolutePath());
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().set(131073, FileExplorerUI.this.vDu.getAbsolutePath());
                                    } else {
                                        FileExplorerUI.this.vDv = file;
                                    }
                                } else if (FileExplorerUI.this.vDl == 0) {
                                    if (file.isFile()) {
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().set(131073, FileExplorerUI.this.vDn.vDA.getAbsolutePath());
                                        as.Hm();
                                        com.tencent.mm.y.c.Db().set(131074, FileExplorerUI.this.vDv.getAbsolutePath());
                                    } else {
                                        FileExplorerUI.this.vDu = file;
                                    }
                                }
                                if (file == FileExplorerUI.this.vDn.vDz) {
                                    FileExplorerUI.this.vDn.e(FileExplorerUI.this.vDn.vDz.getParentFile(), FileExplorerUI.this.vDn.vDz);
                                } else if (file.isDirectory()) {
                                    FileExplorerUI.this.vDn.e(FileExplorerUI.this.vDn.vDA, file);
                                } else if (file.isFile()) {
                                    FileExplorerUI.this.setResult(-1, new Intent().putExtra("choosed_file_path", file.getAbsolutePath()));
                                    FileExplorerUI.this.finish();
                                }
                                FileExplorerUI.cdi();
                                FileExplorerUI.this.vDn.notifyDataSetChanged();
                                FileExplorerUI.this.vDm.setSelection(0);
                            }
                        });
                        this.vDo.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                FileExplorerUI.this.CS(0);
                                FileExplorerUI.this.vDn.hVg = file.getPath();
                                FileExplorerUI.this.vDn.e(FileExplorerUI.this.vDu.getParentFile(), FileExplorerUI.this.vDu);
                                FileExplorerUI.this.vDn.notifyDataSetInvalidated();
                                FileExplorerUI.this.vDn.notifyDataSetChanged();
                                FileExplorerUI.this.vDm.setSelection(0);
                            }
                        });
                        this.vDp.setOnClickListener(new OnClickListener() {
                            public final void onClick(View view) {
                                FileExplorerUI.this.CS(1);
                                FileExplorerUI.this.vDn.hVg = externalStorageDirectory.getPath();
                                FileExplorerUI.this.vDn.e(FileExplorerUI.this.vDv.getParentFile(), FileExplorerUI.this.vDv);
                                FileExplorerUI.this.vDn.notifyDataSetInvalidated();
                                FileExplorerUI.this.vDn.notifyDataSetChanged();
                                FileExplorerUI.this.vDm.setSelection(0);
                            }
                        });
                    }
                }
                rootDirectory = externalStorageDirectory;
                this.vDv = rootDirectory;
                this.vDn = new a();
                if (externalStorageDirectory == null) {
                    CS(1);
                    this.vDn.hVg = externalStorageDirectory.getPath();
                    this.vDn.e(this.vDv.getParentFile(), this.vDv);
                } else if (file == null) {
                    x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                    return;
                } else {
                    CS(0);
                    this.vDn.hVg = file.getPath();
                    this.vDn.e(this.vDu.getParentFile(), this.vDu);
                }
                textView = this.vDo;
                if (file == null) {
                    z = false;
                } else {
                    z = true;
                }
                textView.setEnabled(z);
                textView2 = this.vDp;
                if (externalStorageDirectory == null) {
                    z2 = false;
                }
                textView2.setEnabled(z2);
                this.vDm.setAdapter(this.vDn);
                this.vDn.notifyDataSetChanged();
                this.vDm.setOnItemClickListener(/* anonymous class already generated */);
                this.vDo.setOnClickListener(/* anonymous class already generated */);
                this.vDp.setOnClickListener(/* anonymous class already generated */);
            }
        }
        rootDirectory = file;
        this.vDu = rootDirectory;
        as.Hm();
        Db = com.tencent.mm.y.c.Db();
        if (externalStorageDirectory != null) {
            obj = externalStorageDirectory.getAbsolutePath();
        }
        str = (String) Db.get(131074, obj);
        file2 = new File(str);
        if (file2.exists()) {
            rootDirectory = file2;
            this.vDv = rootDirectory;
            this.vDn = new a();
            if (externalStorageDirectory == null) {
                CS(1);
                this.vDn.hVg = externalStorageDirectory.getPath();
                this.vDn.e(this.vDv.getParentFile(), this.vDv);
            } else if (file == null) {
                CS(0);
                this.vDn.hVg = file.getPath();
                this.vDn.e(this.vDu.getParentFile(), this.vDu);
            } else {
                x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
                return;
            }
            textView = this.vDo;
            if (file == null) {
                z = true;
            } else {
                z = false;
            }
            textView.setEnabled(z);
            textView2 = this.vDp;
            if (externalStorageDirectory == null) {
                z2 = false;
            }
            textView2.setEnabled(z2);
            this.vDm.setAdapter(this.vDn);
            this.vDn.notifyDataSetChanged();
            this.vDm.setOnItemClickListener(/* anonymous class already generated */);
            this.vDo.setOnClickListener(/* anonymous class already generated */);
            this.vDp.setOnClickListener(/* anonymous class already generated */);
        }
        rootDirectory = externalStorageDirectory;
        this.vDv = rootDirectory;
        this.vDn = new a();
        if (externalStorageDirectory == null) {
            CS(1);
            this.vDn.hVg = externalStorageDirectory.getPath();
            this.vDn.e(this.vDv.getParentFile(), this.vDv);
        } else if (file == null) {
            x.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
            return;
        } else {
            CS(0);
            this.vDn.hVg = file.getPath();
            this.vDn.e(this.vDu.getParentFile(), this.vDu);
        }
        textView = this.vDo;
        if (file == null) {
            z = false;
        } else {
            z = true;
        }
        textView.setEnabled(z);
        textView2 = this.vDp;
        if (externalStorageDirectory == null) {
            z2 = false;
        }
        textView2.setEnabled(z2);
        this.vDm.setAdapter(this.vDn);
        this.vDn.notifyDataSetChanged();
        this.vDm.setOnItemClickListener(/* anonymous class already generated */);
        this.vDo.setOnClickListener(/* anonymous class already generated */);
        this.vDp.setOnClickListener(/* anonymous class already generated */);
    }

    private void CS(int i) {
        if (1 == i) {
            this.vDl = 1;
            this.vDp.setTextColor(getResources().getColor(R.e.buj));
            this.vDo.setTextColor(getResources().getColor(R.e.btv));
            this.vDq.setVisibility(4);
            this.vDr.setVisibility(0);
            return;
        }
        this.vDl = 0;
        this.vDo.setTextColor(getResources().getColor(R.e.buj));
        this.vDp.setTextColor(getResources().getColor(R.e.btv));
        this.vDq.setVisibility(0);
        this.vDr.setVisibility(4);
    }

    public static int Tr(String str) {
        Object obj = null;
        String toLowerCase = str.toLowerCase();
        String toLowerCase2 = bi.oM(toLowerCase).toLowerCase();
        Object obj2 = (toLowerCase2.endsWith(".doc") || toLowerCase2.endsWith(".docx") || toLowerCase2.endsWith("wps")) ? 1 : null;
        if (obj2 != null) {
            return R.k.dvP;
        }
        if (Ts(toLowerCase)) {
            return R.g.bEU;
        }
        toLowerCase2 = bi.oM(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".rar") || toLowerCase2.endsWith(".zip") || toLowerCase2.endsWith(".7z") || toLowerCase2.endsWith("tar") || toLowerCase2.endsWith(".iso")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.dvG;
        }
        toLowerCase2 = bi.oM(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".txt") || toLowerCase2.endsWith(".rtf")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.dvH;
        }
        if (bi.oM(toLowerCase).toLowerCase().endsWith(".pdf")) {
            return R.k.dvC;
        }
        toLowerCase2 = bi.oM(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".ppt") || toLowerCase2.endsWith(".pptx")) {
            obj2 = 1;
        } else {
            obj2 = null;
        }
        if (obj2 != null) {
            return R.k.dvE;
        }
        toLowerCase2 = bi.oM(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".xls") || toLowerCase2.endsWith(".xlsx")) {
            obj = 1;
        }
        if (obj != null) {
            return R.k.dvs;
        }
        return R.k.dvI;
    }

    public static boolean Ts(String str) {
        String toLowerCase = bi.oM(str).toLowerCase();
        return toLowerCase.endsWith(".bmp") || toLowerCase.endsWith(".png") || toLowerCase.endsWith(".jpg") || toLowerCase.endsWith(".jpeg") || toLowerCase.endsWith(".gif");
    }

    public static boolean Tt(String str) {
        String toLowerCase = bi.oM(str).toLowerCase();
        return toLowerCase.endsWith(".mp3") || toLowerCase.endsWith(".wma") || toLowerCase.endsWith(".mp4") || toLowerCase.endsWith(".rm");
    }
}
