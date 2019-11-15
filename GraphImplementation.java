import java.io.*; 
import java.util.EmptyStackException;
import java.util.*; 
public class GraphImplementation{
	private int vertices;
	private List<Integer> a[];

	public GraphImplementation(int v){
		if(vertices< 0 )throw new EmptyStackException();
		vertices = v;
		a = new LinkedList[v]; 
        for (int i=0; i<v; ++i) 
            a[i] = new LinkedList(); 
	}
	void addEdge(int src, int tar){
		a[src].add(tar);; //add edge
	}
	List<Integer> topologicalSort(){
		Stack stack = new Stack();
		boolean[]visited = new boolean[vertices];
		for(int i = 0; i <vertices;i++)
			visited[i]= false;
		for(int j = 0 ;j<vertices;j++)
			if(visited[j]== false)
				topologicalSortUtil(j,visited,stack);
		while(stack.empty()==false){
			stack.pop();
		}
		return stack;	
	}

	void topologicalSortUtil(int v,boolean [] visited,Stack stack){
		visited[v]=true;
		Integer i;
		Iterator<Integer> it =  a[v].iterator();
		while (it.hasNext()){ 
            i = it.next(); 
            if (!visited[i]) 
                topologicalSortUtil(i, visited, stack); 
        }
        stack.push(new Integer(v));  
	}
	List<Integer> neighbors(int vertex){
		return a[vertex]; 
		
	}

}