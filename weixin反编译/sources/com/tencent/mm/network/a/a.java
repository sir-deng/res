package com.tencent.mm.network.a;

public interface a {

    public static class a {
        public long beginTime = 0;
        public String clientIp = "";
        public long endTime = 0;
        public int errCode = 0;
        public int errType = 0;
        public long expand1 = 0;
        public long expand2 = 0;
        public long hTo = 0;
        public c idf;
        public boolean idg = false;
        public long idh = 0;
        public long idi = 0;
        public long idj = 0;
        public int idk = 0;
        public int idl = 0;
        public long idm = 0;
        public long idn = 0;
        public long ido = 0;
        public long netSignal = 0;
        public int netType = 0;
        public int retryCount = 0;
        public long rtType = 0;

        public final String toString() {
            String str = "rtType:%d begin:%d, end:%d time:%d cost:%d count:%d ipInfo:%s socket:%b netType:%d err:(%d,%d) tx:%d rx:%d";
            Object[] objArr = new Object[13];
            objArr[0] = Long.valueOf(this.rtType);
            objArr[1] = Long.valueOf(this.beginTime);
            objArr[2] = Long.valueOf(this.endTime);
            objArr[3] = Long.valueOf(this.endTime - this.beginTime);
            objArr[4] = Long.valueOf(this.hTo);
            objArr[5] = Long.valueOf(this.idj);
            objArr[6] = this.idf == null ? "null" : this.idf.toString();
            objArr[7] = Boolean.valueOf(this.idg);
            objArr[8] = Integer.valueOf(this.netType);
            objArr[9] = Integer.valueOf(this.errType);
            objArr[10] = Integer.valueOf(this.errCode);
            objArr[11] = Long.valueOf(this.idh);
            objArr[12] = Long.valueOf(this.idi);
            return String.format(str, objArr);
        }
    }
}
