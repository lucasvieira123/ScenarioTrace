import java.io.*;
import java.util.Properties;
import java.util.Scanner;

public class Tracer {
    private static Tracer instance;
    private File traceFile;
    private String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
    private final String tracerPropertiesPath = rootPath + "tracer.properties";
    private Properties tracerProperties = new Properties();

    private String absoluteFilePath;
    private String workingDirectory = System.getProperty("user.dir");


    private String file_name;
    private String extension;
    private String identifier_hMSC;
    private String identifier_bMSC;
    private String identifier_component;
    private String identifier_instance;
    private String identifier_time_event;
    private String identifier_event;
    private String regex_event_occorrence;
    private String eventOccorrence;
    private String separator_event_occorrence;
    private String separator_scenario_occorrence;


    private String hMSC;
    private String bMSC;
    private String instanceObject;
    private String component;
    private String event;
    private String time;


    public static Tracer getInstance (){
        if(instance == null){
            instance = new Tracer();
            }

            return instance;

    }

    private Tracer()  {
        tryLoadPropertiesFromFile();
        getProperties();
        absoluteFilePath = workingDirectory + File.separator + file_name +"."+extension;
        try {
            traceFile = createOrOpenFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        eventOccorrence = regex_event_occorrence;

    }

    private File createOrOpenFile() throws IOException {
        File file = new File(absoluteFilePath);

        if (file.createNewFile()){
            System.out.println("File is created!");

        }else{
            System.out.println("File already created!");
        }

        return file;
    }





    private void getProperties() {
        file_name = tracerProperties.getProperty("file_name");
        extension = tracerProperties.getProperty("extension");
        identifier_hMSC = tracerProperties.getProperty("identifier_hMSC","identifier_hMSC_default");
        identifier_bMSC =  tracerProperties.getProperty("identifier_bMSC", "identifier_bMSC_default");
        separator_event_occorrence = tracerProperties.getProperty("separator_event_occorrence",",");
        separator_scenario_occorrence = tracerProperties.getProperty("separator_scenario_occorrence",
                "\n");

        identifier_component = tracerProperties.getProperty("identifier_component",
                "identifier_component_default");

        identifier_instance = tracerProperties.getProperty("identifier_instance",
                "identifier_instance_default");

        identifier_time_event = tracerProperties.getProperty("identifier_time_event",
                "identifier_time_event_default");

        identifier_event = tracerProperties.getProperty("identifier_event","identifier_event_default");

        regex_event_occorrence = tracerProperties.getProperty("regex_event_occorrence");
    }

    private void tryLoadPropertiesFromFile() {
        try {
            tracerProperties.load(new FileInputStream(tracerPropertiesPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    public Tracer printEventOccorrence (){

        BufferedWriter writer = null;
        String currentSeparator = "";
        String space =" ";
        buildEventOccorrence();

        try {
            writer = new BufferedWriter(new FileWriter(traceFile,true));
            writer.write(eventOccorrence);
            writer.write(separator_event_occorrence + space);
            clearEventOccorrence();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }



        return this;
    }

    private void buildEventOccorrence() {
        eventOccorrence = eventOccorrence.replace(identifier_hMSC, hMSC);
        eventOccorrence = eventOccorrence.replace(identifier_bMSC, bMSC);
        eventOccorrence = eventOccorrence.replace(identifier_component, component);
        eventOccorrence = eventOccorrence.replace(identifier_instance, instanceObject);
        eventOccorrence = eventOccorrence.replace(identifier_event, event);
        eventOccorrence = eventOccorrence.replace(identifier_time_event, time);
    }


    public Tracer setHMSC(String hMSC){
        this.hMSC = hMSC;

        return this;
    }

    public Tracer setBMSC (String bMSC){
        this.bMSC = bMSC;

        return this;
    }

    public Tracer setComponent (String component){
        this.component = component;

        return this;
    }

    public Tracer setInstanceObject(String instanceObject){
        this.instanceObject = instanceObject;


        return this;
    }

    public Tracer setEvent (String event){
        this.event = event;


        return this;
    }

    public Tracer setTime (String time){
        this.time = time;

        return this;
    }

    public void finilizeScenario(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(traceFile, true));
            writer.write(separator_scenario_occorrence);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Tracer clearEventOccorrence (){
        eventOccorrence = regex_event_occorrence;
        return this;
    }


}


