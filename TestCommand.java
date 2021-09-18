
	
	 
	import java.util.List;
	import java.util.ArrayList;
	 
	
	interface Command {
	   void execute();
	}
	 
	
	 class Switch { 
	   private List<Command> history = new ArrayList<Command>();
	 
	   public Switch() {
	   }
	 
	   public void storeAndExecute(Command command) {
	      this.history.add(command);
	      command.execute();        
	   }
	}
	 
	
	 class Computer {
	 
	   public void UpdateshutDown() {
	      System.out.println("computer is Updated and shutting down");
	   }
	 
	   public void Updaterestart() {
	      System.out.println("computer is Updated and restarting");
	   }
	}
	 
	
	 class ShutDownCommand implements Command {
	   private Computer computer;
	 
	   public ShutDownCommand(Computer computer) {
	      this.computer = computer;
	   }
	 
	   public void execute(){
	      computer.UpdateshutDown();
	   }
	}
	 
	
	 class RestartCommand implements Command {
	   private Computer computer;
	 
	   public RestartCommand(Computer computer) {
	      this.computer = computer;
	   }
	 
	   public void execute() {
	      computer.Updaterestart();
	   }
	}
	
	public class TestCommand {
	   public static void main(String[] args){
	      Computer computer = new Computer();
	      Command shutdown = new ShutDownCommand(computer);
	      Command restart = new RestartCommand(computer);
	 
	      Switch s = new Switch();
	 
	      String str = "shutdown"; 
	 
	      if(str == "shutdown"){
	    	  s.storeAndExecute(shutdown);
	      }else{
	    	  s.storeAndExecute(restart);
	      }
	   }
	}
	
