package solpuzzle;


public class Action {
    protected String code;
    /**
     * Default constructor
     * @param _code The code of the action
     */
    public Action( String _code ) {
      code = _code;
    }

    /**
     * Gets the code of the action
     * @return The code of the action
     */
    public String getCode(){ return code; }


}
