package puzzle;

public class prueba {
	static int [][]goal = {{1,2,3},{4,5,6},{7,8,0}};

	static int [][] a = new int[3][3];
	
	
	
	
	private static void copiar(int [][]a) {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				a[i][j] = goal[i][j];
			}
		}
	}

	public static void main(String[] args) {
		for(int i = 0; i<a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(goal[i][j]);
			}			
			System.out.println("\n");
		}
		copiar(a);
		for(int i = 0; i<a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(goal[i][j]);
			}			
			System.out.println("\n");
		}
		int x= 1;
		int y= 1;
		int aux = a[x-1][y];
		a[x-1][y] = a[x][y];
		a[x][y] = aux;
		System.out.println("------------------------------");
		for(int i = 0; i<a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(goal[i][j]);
			}
			System.out.println("\n");
		}
		
		for(int i = 0; i<a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(a[i][j]);
			}			
			System.out.println("\n");
		}
	}
	
}
