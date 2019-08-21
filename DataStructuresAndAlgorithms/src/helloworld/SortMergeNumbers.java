package helloworld;
import java.util.ArrayList;
import java.util.List;

public class SortMergeNumbers {
	static List<Integer> mergeArrays(ArrayList<Integer> A, ArrayList<Integer> B) {
		List<Integer> C = new ArrayList<Integer>();
		int aCurrent = 0;
		int bCurrent = 0;
		while(!(A.isEmpty()) && !(B.isEmpty()))
			if(A.get(aCurrent)<B.get(bCurrent)) {
				C.add(A.get(aCurrent));
				aCurrent++;
			}else {
				C.add(B.get(bCurrent));
				bCurrent++;
			}
		while(!(A.isEmpty())) {
			C.add(A.get(aCurrent));
			aCurrent++;
		}
		while(!(B.isEmpty())) {
			C.add(B.get(bCurrent));
			bCurrent++;
		}
		return C;
	}
	
}
