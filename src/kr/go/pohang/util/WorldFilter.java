package kr.go.pohang.util;

public class WorldFilter {
	private String[] list = {"시발", "개새끼", "십새끼"};
	
	public boolean compare(String Keyworld){
		boolean k = false;
		for(String w : list){
			if (Keyworld.contains(w)){
				k = true;
			}
		}
		return k;
		
	}
	

}
