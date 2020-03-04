public class driver {
	public static void main(String[] args) {
		FurnitureProduct thing = new FurnitureProduct("Thing", 12345);
		Table myTable = new Table("Table", 12341, 2);
		Chair myChair = new Chair("Chair", 34521, true);
		
		System.out.printf("Thing: %s\nTable: %s\nChair: %s\n", thing.toString(), myTable.toString(), myChair.toString());
	}
}