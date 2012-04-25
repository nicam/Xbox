package ch.zhaw.ads.Stack;

import ch.zhaw.ads.CommandInterpreter;


public class BracketServer implements CommandInterpreter  {

	protected ListStack list = new ListStack();
	
	public String interpret(String bracketString) throws Exception {
		String[] c = bracketString.split("");
		System.out.println(c);
		String compare = "";
		
		list.makeEmpty();
		
		for (int i = 0; i < c.length; i++) {
			System.out.println("char is" + i + ":" + c[i]);
			if (c[i].equals("(") || c[i].equals("{") || c[i].equals("[")) {
				System.out.println("Adding" + c[i]);
				list.push(c[i]);
			} else if (c[i].equals(")") || c[i].equals("}") || c[i].equals("]")) {
				if (list.isEmpty()) {
					return "Brackets are incorrect at position: " + i + "\n";
				}
				compare = (String) list.pop();
				
				System.out.println("Popped" + compare);
				System.out.println("Comparing " + compare + "with " + c[i]);
			
				if (!(compare.equals("(") && c[i].equals(")")
					|| compare.equals("{") && c[i].equals("}")
					|| compare.equals("[") && c[i].equals("]"))
				) {
					return "Brackets are incorrect at position: " + i + "\n";
				}
			}
		}
		if (!list.isEmpty()) {
			return "Missing closing brackets\n";
		}
		
		return "Brackets are correct\n";
	}

}
