import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		DoubleLinkedList d = new DoubleLinkedList();
		Scanner scnr = new Scanner(System.in);
	
		int input;
		d.addNode(5);
		d.addNode(10);
		d.addNode(15);
		d.addNode(20);
//		d.addNode(25);
//		d.addNode(5);
//		d.addNode(10);
//		d.addNode(153);
//		d.addNode(2);
//		d.addNode(25);
//		d.addNode(5);
//		d.addNode(10);
//		d.addNode(185);
//		d.addNode(21);
//		d.addNode(125);
		d.displayAll();
		do {
			printMenu();
			input = getInput(scnr);
			switch(input) {
			case 1:
				System.out.print("Enter in item to add: ");
				d.addNode(getInput(scnr));
				break;
			case 2:
				System.out.print("Enter in item to Delete: ");
				d.deleteNode(getInput(scnr));
				break;
			case 3:
				System.out.print("Enter in item to Find: ");
				d.findNode(getInput(scnr));
				break;
			case 4:
				System.out.println("Deleting first Node.");
				d.deleteFirstNode();;
				break;
			case 5:
				System.out.println("Deleting last Node.");
				d.deleteLastNode();;
				break;
			case 6:
				d.displayAll();
				break;
			case 7:
				d.size();
				break;
			case 8:
				System.out.print("Enter in item to Update: ");
				int update = getInput(scnr);
				if(!d.find(update)) {
					System.out.println("Not Found");
					break;
				}
				System.out.print("Enter in new value: ");
				d.updateNode(update, getInput(scnr));
				break;
			default:
				System.out.println("Bad input");
				break;
			}
		}
		while(input != 0);
		
		
	}
	
	public static void printMenu() {
		System.out.println(
		"|-----------------Menu-----------------|\n"+
		"|    1. Add          2. Delete         |\n"+
		"|    3. Find         4. Delete First   |\n"+
		"|    5. Delete Last  6. Display All    |\n"+
		"|    7. Size         8. Update         |\n"+
		"|               0. Exit                |\n"+
		"|-----------Select An Option-----------|\n"
				);
	}
	public static int getInput(Scanner sc) {
		int input = -1;
		while(sc.hasNext()) {
			if(sc.hasNextInt()) {
				input = sc.nextInt();
				break;
			}
			else {
				sc.next();
			}
		}
		return input;
	}
	
}
