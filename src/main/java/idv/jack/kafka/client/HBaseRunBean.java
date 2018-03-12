package idv.jack.kafka.client;

import java.util.Map;

public class HBaseRunBean {
    private String store;
    private Map<String, String> meta;
    private String rawtrace_header;
    private String rowkey;
    private Map<String, String> value;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }

    public String getRawtrace_header() {
        return rawtrace_header;
    }

    public void setRawtrace_header(String rawtrace_header) {
        this.rawtrace_header = rawtrace_header;
    }

    public String getRowkey() {
        return rowkey;
    }

    public void setRowkey(String rowkey) {
        this.rowkey = rowkey;
    }

    public Map<String, String> getValue() {
        return value;
    }

    public void setValue(Map<String, String> value) {
        this.value = value;
    }
}
