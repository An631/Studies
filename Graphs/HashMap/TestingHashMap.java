public class TestingHashMap {
	public static void main (String args[])
	{
		HashMap hasher = new HashMap();
		hasher.put("First", 1);
		hasher.put("Second", 2);
		hasher.put("irstF",3);
		hasher.put("econdS",4);
		hasher.put("condSe",5);
		hasher.put("ondSec",6);
		System.out.println(hasher.get("First"));
		System.out.println(hasher.get("irstF"));
		System.out.println(hasher.get("econdS"));
		System.out.println(hasher.get("condSe"));

		System.out.println("Deleted: "+hasher.remove("econdS"));
		System.out.println("Deleted: "+hasher.remove("condSe"));
		System.out.println("Deleted: "+hasher.remove("Second"));
		System.out.println(hasher.get("ondSec"));		

	}
}