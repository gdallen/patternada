/**
 * In the context of the strategy pattern, various attacks are handled by
 * differnt defense strategies.  The type of defense to be used is 
 * encapsulated in a concrete class which implements the DefenseStrategy 
 * interface.  The instance of the DefenseStrategy is calculated by 
 * a factory method.
 *
 * The strategies employed in this example are based on the 
 * Monty Python "Self Defense Against Fresh Fruit" skit
 * http://www.youtube.com/watch?v=piWCBOsJr-w
*/
public class SelfDefense {

  public void handleAttack(String attack){
    DefenseStrategy ds = getDefenseStrategy(attack);
    ds.executeDefense();
  }
  public DefenseStrategy getDefenseStrategy(String attack){
    if (attack.equals("man with a banana"))
      return new RevolverDefense();
    if (attack.equals("man with a raspberry"))
      return new SixteenTonWeightDefense();

    return new DefaultDefense();
  }

  public static void main(String [] args){
    SelfDefense sd = new SelfDefense();
    sd.handleAttack("man with a banana");
    sd.handleAttack("man with a raspberry");
  }
}
