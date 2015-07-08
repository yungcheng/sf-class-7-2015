package methodrefs;

import java.util.function.BiFunction;

public class Methods {

	public Methods(String s, String t) {
		System.out.println("Meths(" + s + "," + t + ")");
	}
	
	public Methods() {
		System.out.println("Meths()");
	}
	
	public static <T,U,R> R stuff(T t, U u) {
		System.out.println("called static stuff t=" + t + " u=" + u);
		return null;
	}
	
	public <T,U,R> R instStuff(T t, U u) {
		System.out.println("instStuff t=" + t + " u=" + u);
		return null;
	}
	
	public <U,R> R moreInst(U u) {
		System.out.println("moreInst u=" + u);
		return null;
	}
	
	public static void main(String[] args) {
		BiFunction<String, String, String> bfs = Methods::stuff;
		Object o = bfs.apply("A", "B");

		Methods m = new Methods();
		
		bfs = m::instStuff;
		bfs.apply("C","D");
		
		BiFunction<Methods, String, String> bfms = Methods::moreInst;
		bfms.apply(m, "E");
		
		BiFunction<String, String, Methods> bfssm = Methods::new;
		bfssm.apply("F", "G");
	}	

}
