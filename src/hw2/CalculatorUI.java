import list.EquationList;
public class CalculatorUI {

	public static void main(String[] args) {
		int result;
		Calculator c = new Calculator();
        while (true) {
            System.out.print("> ");
            String input = StdIn.readString();
            switch (input){
            case"quit":return;
            case "history": 
                int count = StdIn.readInt();
                c.printHistory(count);
                break;
            case "dump": c.printAllHistory(); break;
            case "undo": c.undoEquation(); break;
            case "clear": c.clearHistory(); break;
            case "sum": System.out.println(c.cumulativeSum()); break;
            case "product": System.out.println(c.cumulativeProduct()); break;
            default:
            	int a = Integer.parseInt(input);
            	StdIn.readChar();
            	String operator = StdIn.readString();
            	StdIn.readChar();
            	input = StdIn.readString();
            	if (input.equals("-") || input.lastIndexOf('-')>0){
            		System.out.println("Invalid input");
            		continue;
            	}
            	int b = Integer.parseInt(input);
            	if(operator.equals("+")){
            		result = c.add(a, b);
                    c.saveEquation(a + " + " + b, result);
            		System.out.println(result);
            	}else if(operator.equals("-")){
            		result = c.add(a, -b);
                    c.saveEquation(a + " - " + b, result);
            		System.out.println(result);
            	}else if(operator.equals("*")){
            		result = c.multiply(a, b);
                    c.saveEquation(a + " * " + b, result);
            		System.out.println(result);
            	}else{
            		System.out.println("Invalid operators");
            	}
            }
        }

	}


}
