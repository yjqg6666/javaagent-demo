package com.demo.agent;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

public class EnvExporter {
    private final String path;

    public EnvExporter(String path) {
        this.path = path;
    }

    public void export() {
        try {
            export0();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void export0() throws IOException {
        final FileWriter writer = new FileWriter(path);
        System.getProperties().store(writer, "properties");
        writeEnvs(writer);
        writer.flush();
    }

    private void writeEnvs(Writer writer) throws IOException {
        writer.write("# environments\n");
        final Map<String, String> map = System.getenv();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            writer.write(String.format("%s=%s\n", k, v));
        }
    }

}
