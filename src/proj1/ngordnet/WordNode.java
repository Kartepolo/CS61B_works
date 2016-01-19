package ngordnet;
/* a generic abstract class for hypernyms and hyponyms */
public class WordNode{
private int ID;
private String[] items;
private String definition;
WordNode(int ID,String items,String defi){
	this.ID = ID;
	this.items = items.split(" ");
	this.definition = defi;
}
public int getID(){
	return ID;
}
public String[] getitem(){
	return items;
}
public boolean has_item(String input){
	for (String s : items){
		if (s.equals(input)) return true;
	}
	return false;
}
}
