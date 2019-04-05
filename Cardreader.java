import javax.smartcardio.*;
import java.util.List;

public class Cardreader {
	public static void main(String [] args) {
		TerminalFactory factory = TerminalFactory.getDefault();
		try {
			List<CardTerminal> terminals = factory.terminals().list();
			System.out.println("Terminals: " + terminals);
		}catch (Exception e) {
			System.out.println(e);
		}
	}
}
