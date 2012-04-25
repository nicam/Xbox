package ch.zhaw.ads;

public class ServerFactory {

	
	public CommandInterpreter createServer(String name, String directory) {
		try {
			String[] path = directory.split("/");
			System.out.println(path[path.length-1]);

			String ns = (path[path.length-1].equals("ads")) ? "" : path[path.length-1] + ".";

			return (CommandInterpreter)Class.forName("ch.zhaw.ads." + ns + name.substring(0,name.indexOf('.'))).newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
