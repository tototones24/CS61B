/** @author Antonio Contreras. */

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class SetDemo {
	public static void main(String[] args) {
		HashSet<String> h = new HashSet<String>();
		h.add("papa"); h.add("bear"); h.add("mama");
		h.add("bear"); h.add("baby"); h.add("bear");
		System.out.println(h);
	}
}