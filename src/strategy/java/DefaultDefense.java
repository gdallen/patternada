public class DefaultDefense implements DefenseStrategy {
  /** 
   * while not used in the skit, it's a good idea to have a 
   * strategy that handles attacks that are not thought of in advance
  */
  public void executeDefense(){
    System.out.println("Run Away");
  }
}

