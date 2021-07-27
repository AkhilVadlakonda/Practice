import java.util.*;
import java.util.stream.Collectors;
public class StreamsDemo {

	public static void main(String[] args) {
		List<Integer> al = Arrays.asList(1,2,3,4,5);
	    al.stream().filter(x -> (x%2)==0).map(y -> y+1).forEach(y -> System.out.println(y));
	}

}
