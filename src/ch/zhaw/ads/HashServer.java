package ch.zhaw.ads;

import java.util.HashMap;
import java.util.Map;

public class HashServer implements CommandInterpreter {
	ZuerichMarathon zm = new ZuerichMarathon();
	Map<String, Competitor> hashmap = new MyHashtable<String, Competitor>();
	@Override
	public String interpret(String command) throws Exception {
		// TODO Auto-generated method stub
		long startTime = System.currentTimeMillis();

		
		if (command.contains("GET")) {
			String[] cmd = command.split(" ");
			Competitor foo = hashmap.get(cmd[1] + " " + cmd[2]);
			return "\n" + foo.toString();
		} else if (command.contains("REMOVE")) {
			String[] cmd = command.split(" ");
			Competitor foo = hashmap.remove(cmd[1] + " " + cmd[2]);
			return "\n" + foo.toString();
		} else {
			zm.load(command);
			System.out.println("initial load time " + (System.currentTimeMillis() - startTime) + "ms");
			zm.sort();
			System.out.println("initial load time + sorttime " + (System.currentTimeMillis() - startTime) + "ms");
			for (Competitor c : zm) {
				hashmap.put(c.getName() + " " + c.getFirstName(), c);
			}
			System.out.println("Total load time " + (System.currentTimeMillis() - startTime) + "ms");
			return "\nLoaded";
		}
		
	}

}
