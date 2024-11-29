package Palillos;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Main {
	public static void main(String[] args) {
		int PALILLOS=5;
		Semaphore semaforo=new Semaphore(PALILLOS);

		
		ArrayList<Filosofo> filosofos= new ArrayList<>();
		filosofos.add(new Filosofo("Manolo"));
		filosofos.add(new Filosofo("Xhunxen1¥"));
		filosofos.add(new Filosofo("Guanpatan 2°"));
		filosofos.add(new Filosofo("Akita Mipalo"));
		filosofos.add(new Filosofo("Shisha Tinue"));
		
		int palillosCon=0;
		for (Filosofo i : filosofos) {
			hilo(semaforo,i,filosofos.indexOf(i),palillosCon);
			palillosCon+=2;
			
			if(palillosCon>=PALILLOS){
				palillosCon=0;
			}
		}
	}
	
	public static synchronized void  hilo(Semaphore semaforo,Filosofo filosofo,int contador,int palillosCon) {		
		Runnable run=()->{					
			try {
				System.out.printf("%s esperando a comer...\n\n",filosofo.getNombre());
				semaforo.acquire(2);
		
				int palillosAusar[]={palillosCon,(palillosCon+1)%5};
												
				filosofo.setPalillos(palillosAusar);
						
				System.out.printf("%d. %s ha empezado a comer...\n\n",contador,filosofo.toString());
					
				Thread.sleep(3000);
	
			} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				System.out.printf("%s ha terminado de comar...\n\n",filosofo.toString());
				semaforo.release(2);
			}
		};
		
		new Thread(run).start();
	}
}
