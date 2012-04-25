package ch.zhaw.ads.Stack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ch.zhaw.ads.CommandInterpreter;

public class checkXml implements CommandInterpreter  {
private ListStack xmlStack = new ListStack();
	
	public String interpret(String xml) throws Exception {
		xml = xml.replaceFirst("<\\?xml.*\\?>", "");
		String tagName = "", stackItem;
		Pattern pat = Pattern.compile("<[^>]+>");
		
		Matcher m = pat.matcher(xml);
		
		xmlStack.makeEmpty();
		
		while (m.find()) {
			if (this.isSelfClosingTag(m.group())) {
				continue;
			}
			
			tagName = this.getTagName(m.group());
			
			if (this.isClosingTag(m.group())) {
				stackItem = (String) xmlStack.pop();
				
				if (! stackItem.equals(tagName)) {
					throw new Exception("Wrong xml format: " + stackItem);
				}
			} else {
				xmlStack.push(tagName);
			}
		}
		
		if (! xmlStack.isEmpty()) {
			throw new Exception("Missing tags in xml");
		}
		return "String is valid";
	}
	
	/* Helpers */
	private String getTagName(String tag) {
		String tagName = "";
		
		Pattern pat = Pattern.compile("</*([^>^/]+)\\s|/*>");
		Matcher m = pat.matcher(tag);
		
		if(m.matches()) {
			tagName = m.group(1);
		}
		
		return tagName;
	}
	
	private boolean isClosingTag(String tag) {
		Pattern p = Pattern.compile("</[^>]+>");
		Matcher m = p.matcher(tag);
		return m.matches();
	}
	
	private boolean isSelfClosingTag(String tag) {
		Pattern p = Pattern.compile("<[^>]+/{1}>");
		Matcher m = p.matcher(tag);
		return m.matches();
	}
}
