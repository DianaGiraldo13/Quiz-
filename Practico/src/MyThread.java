
public class MyThread extends Thread{
	Main main;
	public int value;
	
	public MyThread(Main main,int value) {
		this.main=main;
		this.value=value;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		while(value!=3) {
			if(value==0) {
				value=1;
			}
			else {
				value=0;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
