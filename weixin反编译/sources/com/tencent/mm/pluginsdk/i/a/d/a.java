package com.tencent.mm.pluginsdk.i.a.d;

public abstract class a {
    private final String filePath;
    public final String frM;
    private volatile int hLa;
    private final long hSg;
    public final int networkType;
    public final int priority;
    protected volatile int status = 0;
    public final String url;
    public final String vmK;
    public final int vmU;
    public final String vof;
    private final String vog;
    private final String voh;

    public static abstract class a<T extends a> {
        public String frM;
        public long hSg;
        public int networkType;
        public int priority;
        public final String url;
        public String vmK;
        public int vmU;

        public a(String str) {
            this.url = str;
        }
    }

    public a(String str, String str2, String str3, int i, int i2, String str4, long j, String str5, String str6, String str7, int i3) {
        this.url = str;
        this.vmK = str2;
        this.vof = str3;
        this.networkType = i;
        this.vmU = i2;
        this.hLa = this.vmU;
        this.filePath = str4;
        this.hSg = j;
        this.vog = str6;
        this.voh = str7;
        this.frM = str5;
        this.priority = i3;
    }

    public q cab() {
        q qVar = new q();
        qVar.field_url = this.url;
        qVar.field_urlKey = this.vmK;
        qVar.field_fileVersion = this.vof;
        qVar.field_networkType = this.networkType;
        qVar.field_maxRetryTimes = this.vmU;
        qVar.field_retryTimes = this.hLa;
        qVar.field_filePath = this.filePath;
        qVar.field_status = this.status;
        qVar.field_expireTime = this.hSg;
        qVar.field_groupId1 = this.vog;
        qVar.field_groupId2 = this.voh;
        qVar.field_md5 = this.frM;
        qVar.field_priority = this.priority;
        return qVar;
    }

    public int Sv(String str) {
        return 0;
    }

    public String toString() {
        return "BaseResDownloadRequest | urlKey='" + this.vmK + '\'' + ", networkType=" + this.networkType + ", expireTime=" + this.hSg + ", fileVersion=" + this.vof + ", maxRetryTimes=" + this.vmU + ", md5='" + this.frM + '\'' + ", groupId1='" + this.vog + '\'' + ", groupId2='" + this.voh + '\'' + ", filePath='" + this.filePath + '\'' + ", retryTimes=" + this.hLa + ", status=" + this.status + ", priority=" + this.priority;
    }
}
