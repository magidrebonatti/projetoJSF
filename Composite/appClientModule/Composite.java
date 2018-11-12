import java.util.ArrayList;
import java.util.List;

public class Composite extends Component {

	private List<Component> childComponents = new ArrayList<Component>();
	
	public void print(){
		for (Component c: childComponents){
			c.print();
		}
	}
	
	public void add(Component c){
		childComponents.add(c);
	}
	
	public void remove(Component c){
		childComponents.remove(c);
	}
	
}
