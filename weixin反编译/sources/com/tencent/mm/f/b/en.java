package com.tencent.mm.f.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.sdk.e.c;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;

public abstract class en extends c {
    public static final String[] fNF = new String[]{"CREATE INDEX IF NOT EXISTS WebViewResourceCacheAppIdIndex ON WebViewResourceCache(appId)", "CREATE INDEX IF NOT EXISTS WebViewResourceCacheDomainIndex ON WebViewResourceCache(domain)", "CREATE INDEX IF NOT EXISTS WebViewResourceCachePackageIdIndex ON WebViewResourceCache(packageId)"};
    private static final int fNO = "rowid".hashCode();
    private static final int fOS = "createTime".hashCode();
    private static final int fPG = "appId".hashCode();
    private static final int fQv = "version".hashCode();
    private static final int fVi = SlookSmartClipMetaTag.TAG_TYPE_URL.hashCode();
    private static final int gce = "configId".hashCode();
    private static final int gfi = "expireTime".hashCode();
    private static final int gmp = "protocol".hashCode();
    private static final int goY = "contentLength".hashCode();
    private static final int goZ = DownloadInfo.CONTENTTYPE.hashCode();
    private static final int gpq = "packageId".hashCode();
    private static final int gwS = "urlMd5Hashcode".hashCode();
    private static final int gwT = "domain".hashCode();
    private static final int gwU = "localPath".hashCode();
    private static final int gwV = "isLatestVersion".hashCode();
    private static final int gwW = "accessTime".hashCode();
    private static final int gwX = "cacheType".hashCode();
    private static final int gwY = "contentMd5".hashCode();
    private boolean fOw = true;
    private boolean fPp = true;
    private boolean fQp = true;
    private boolean fUP = true;
    public long field_accessTime;
    public String field_appId;
    public int field_cacheType;
    public String field_configId;
    public long field_contentLength;
    public String field_contentMd5;
    public String field_contentType;
    public long field_createTime;
    public String field_domain;
    public long field_expireTime;
    public boolean field_isLatestVersion;
    public String field_localPath;
    public String field_packageId;
    public int field_protocol;
    public String field_url;
    public int field_urlMd5Hashcode;
    public String field_version;
    private boolean gcd = true;
    private boolean geZ = true;
    private boolean glI = true;
    private boolean goB = true;
    private boolean goC = true;
    private boolean goT = true;
    private boolean gwL = true;
    private boolean gwM = true;
    private boolean gwN = true;
    private boolean gwO = true;
    private boolean gwP = true;
    private boolean gwQ = true;
    private boolean gwR = true;

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (gwS == hashCode) {
                    this.field_urlMd5Hashcode = cursor.getInt(i);
                } else if (fVi == hashCode) {
                    this.field_url = cursor.getString(i);
                } else if (fPG == hashCode) {
                    this.field_appId = cursor.getString(i);
                } else if (gwT == hashCode) {
                    this.field_domain = cursor.getString(i);
                } else if (fQv == hashCode) {
                    this.field_version = cursor.getString(i);
                } else if (gwU == hashCode) {
                    this.field_localPath = cursor.getString(i);
                } else if (goZ == hashCode) {
                    this.field_contentType = cursor.getString(i);
                } else if (goY == hashCode) {
                    this.field_contentLength = cursor.getLong(i);
                } else if (gwV == hashCode) {
                    this.field_isLatestVersion = cursor.getInt(i) != 0;
                } else if (fOS == hashCode) {
                    this.field_createTime = cursor.getLong(i);
                } else if (gwW == hashCode) {
                    this.field_accessTime = cursor.getLong(i);
                } else if (gfi == hashCode) {
                    this.field_expireTime = cursor.getLong(i);
                } else if (gwX == hashCode) {
                    this.field_cacheType = cursor.getInt(i);
                } else if (gce == hashCode) {
                    this.field_configId = cursor.getString(i);
                } else if (gmp == hashCode) {
                    this.field_protocol = cursor.getInt(i);
                } else if (gpq == hashCode) {
                    this.field_packageId = cursor.getString(i);
                } else if (gwY == hashCode) {
                    this.field_contentMd5 = cursor.getString(i);
                } else if (fNO == hashCode) {
                    this.xrR = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues vP() {
        ContentValues contentValues = new ContentValues();
        if (this.gwL) {
            contentValues.put("urlMd5Hashcode", Integer.valueOf(this.field_urlMd5Hashcode));
        }
        if (this.fUP) {
            contentValues.put(SlookSmartClipMetaTag.TAG_TYPE_URL, this.field_url);
        }
        if (this.fPp) {
            contentValues.put("appId", this.field_appId);
        }
        if (this.gwM) {
            contentValues.put("domain", this.field_domain);
        }
        if (this.fQp) {
            contentValues.put("version", this.field_version);
        }
        if (this.gwN) {
            contentValues.put("localPath", this.field_localPath);
        }
        if (this.goC) {
            contentValues.put(DownloadInfo.CONTENTTYPE, this.field_contentType);
        }
        if (this.goB) {
            contentValues.put("contentLength", Long.valueOf(this.field_contentLength));
        }
        if (this.gwO) {
            contentValues.put("isLatestVersion", Boolean.valueOf(this.field_isLatestVersion));
        }
        if (this.fOw) {
            contentValues.put("createTime", Long.valueOf(this.field_createTime));
        }
        if (this.gwP) {
            contentValues.put("accessTime", Long.valueOf(this.field_accessTime));
        }
        if (this.geZ) {
            contentValues.put("expireTime", Long.valueOf(this.field_expireTime));
        }
        if (this.gwQ) {
            contentValues.put("cacheType", Integer.valueOf(this.field_cacheType));
        }
        if (this.gcd) {
            contentValues.put("configId", this.field_configId);
        }
        if (this.glI) {
            contentValues.put("protocol", Integer.valueOf(this.field_protocol));
        }
        if (this.goT) {
            contentValues.put("packageId", this.field_packageId);
        }
        if (this.gwR) {
            contentValues.put("contentMd5", this.field_contentMd5);
        }
        if (this.xrR > 0) {
            contentValues.put("rowid", Long.valueOf(this.xrR));
        }
        return contentValues;
    }
}
