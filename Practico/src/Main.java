import processing.core.PApplet;

public class Main extends PApplet{
	
	public static void main(String[] args) {
		PApplet.main(Main.class);
		
	}
	
	private MyThread [][] matrix = new MyThread [30][20];
	public boolean pressed=false;
	
	public void settings() {
    	size(600,400);
    	

    }
	
	public void setup() {
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if((i%2==0)==(j%2==0)) {
					matrix[i][j]=new MyThread(this, 0);
				}
				else {
					matrix[i][j]=new MyThread(this, 1);
			}
		}
		
	}
	}
	
	public void draw() {
		background(50);
		noStroke();
		//System.out.println("papu");
		for(int i=0;i<matrix.length;i++) {
			for(int j=0;j<matrix[0].length;j++) {
				if(matrix[i][j].value==0) {
					fill(0);
				}
				else if(matrix[i][j].value==1){
					fill(255);
				}
				else {
					fill(255,0,0);
				}
				rect(i*20, j*20,20, 20);
			}
		}
		
	}
	
	public boolean checkThread() throws MyCustomExeption{
		if(!pressed) {
			return true;
		}
		else {
			int i=mouseX/20;
			int j=mouseY/20;
			if(matrix[i][j].value==3) {
				throw new MyCustomExeption("Este hilo ya no esta disponible");
			}
			else {
				System.out.println("rojo");
				matrix[i][j].value=3;
				return false;
				
			}
			
		}
	}
	public void mouseClicked() {
		try {
			if(checkThread()) {
				for(int i=0;i<matrix.length;i++) {
					for(int j=0;j<matrix[0].length;j++) {
						
						if(i%2!=0) {
							if((i%2==0)==(j%2==0)) {
								
								matrix[i][j].value=1;
								matrix[i][j].start();
							}
						}
				}
				
			}
				pressed=true;
			}
		
		} catch (Exception e) {
			System.out.println("Este hilo ya no esta disponible");
		}
		
		
		
		
	}

}
