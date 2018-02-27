package idv.jack.kafka.client;

import java.util.List;
import java.util.Map;

public class RunObject {
    private String store;
    private Map<String, String> meta;
    private String header;
    private List<String> lines;

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

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public List<String> getLines() {
        return lines;
    }

    public void setLines(List<String> lines) {
        this.lines = lines;
    }
}
