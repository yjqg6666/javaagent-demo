package com.demo.agent;

import java.lang.instrument.Instrumentation;

public class AgentApp
{

    public static void premain(String agentArgs, Instrumentation inst)
    {
        System.out.println("Agent_premain!");
        export();
    }
    public static void agentmain(String agentArgs, Instrumentation inst)
    {
        System.out.println("Agent_main!");
        export();
    }

    private static void export()
    {
        final String path = "/tmp/agent.properties";
        final EnvExporter exporter = new EnvExporter(path);
        exporter.export();
    }

    public static void main( String[] args )
    {
        System.out.println( "Main" );
    }

}
