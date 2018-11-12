
public class Main {
	public static void main(String[] args) {
		Leaf folha1 = new Leaf("folha 1");
		Leaf folha2 = new Leaf("folha 2");
		
		Composite c = new Composite();
		Composite c2 = new Composite();
		Composite c3 = new Composite();
		
		c.add(folha1);
		c.add(folha2);
		
		c2.add(folha2);
		c2.add(folha1);
		
		c.add(c2);
		c.add(c3);
		
		c.print();
		System.out.println("Executado");	
	}

	public Main() {
		super();
		
		
	}

}