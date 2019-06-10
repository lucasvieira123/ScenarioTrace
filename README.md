# ScenarioTrace

This project helps to create trace file from events in source code.
There are two main files in this proctect: (i) tracer.properties and (ii) Tracer.java. The first file (i) is a properties file that contains key and value pairs. This pairs, help to configure the trace file and how each one event will be represente into trace file.

Main key and default values:

	file_name = trace-scenario			    // name file that will contain the traces
	extension = csv						          // extesion file that will contain the traces
	separator_event_occorrence = ,		  // character that will separete different events
	separator_scenario_occorrence = \n  // charecter that will separete different scenarios
	identifier_hMSC = hMSC 				      // value that identify the current hMSC
	identifier_bMSC = bMSC  			      // value that identify the current bMSC
	identifier_component = component    // value that identify the current component
	identifier_instance = instance      // value that identify the current instance Object
	identifier_time_event = time        // value that identify the current time
	identifier_event = event            // value that identify the current event
	regex_event_occorrence = [hMSC:bMSC][component:instance]:[event:time]  //statement that represent event default structure

The tracer.properties can be modificade with new values and with new values, but, this modifications, mainly in new keys, can demand in attributes in Tracer.java

The second file (ii) represents a class that save values that will constitute each one of events.

Main metheds:

	public Tracer setHMSC(String hMSCValue)            // replaces the key hMSC in event default structure by hMSCValue
	public Tracer setBMSC (String bMSCValue)					 // replaces the key bMSC in event default structure by bMSCValue
	public Tracer setComponent (String componentValue) // replaces the key component in event default structure by componentValue
	public Tracer setInstanceObject(String instanceObjectValue)  // replaces the key instance in event default structure by instanceObjectValue
	public Tracer setEvent (String eventValue)				// replaces the key event in event default structure by eventValue
	public Tracer setTime (String timeValue)					// replaces the key time in event default structure by timeValue

	public Tracer printEventOccorrence()						  // prints in file event default structure with the new values

In this procject there is a Editor.java file that show a execution example and build a file trace this execution.
