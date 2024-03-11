package lab4;

/**
 * This class implements a simple soccer team
 * 
 */
public class SoccerTeam {
	
	private Player[] players;
	private Coach coach1;
		

	/**
	 * This is the default constructors. At most 11 player can play in this team. At
	 * most there are 4 roles players can have.
	 */
	private SoccerTeam() {
		this.players = new Player[11];
		for (int i = 0; i < players.length; i++) {
            this.players[i] = Player.getInstance();
        }
		this.setCoach(Coach.getInstance());
	}

	/**
	 * This is the overloaded constructor for this class
	 * 
	 * @param player is an array containing all the players who entered the team.
	 * @param coach  is the coach that trains the team's players.
	 */

	private SoccerTeam(Player[] player, Coach coach) {
		this.setPlayers(player);
        this.setCoach(coach);

	}

	/**
	 * This is the copy constructor for this class
	 * 
	 * @param team is an object of SoccerTeam, whose component is deeply copied into
	 *             the component of this object.
	 */
	private SoccerTeam(SoccerTeam team) {
		this.setPlayers(team.getPlayers());
        this.setCoach(team.getCoach());

	}

	/**
	 * This is a static factory method
	 * 
	 * @return It returns an object of SoccerTeam
	 */
	public static SoccerTeam getInstance() {
		return new SoccerTeam();
	}

	/**
	 * This is a static factory method
	 * 
	 * @param player is an array that contains players.
	 * @param coach  is a coach of the team
	 * @return It returns an object of SoccerTeam made using the input parameters.
	 */
	public static SoccerTeam getInstance(Player[] player, Coach coach) {
		return new SoccerTeam(player,coach);
	}

	/**
	 * This is a static factory method
	 * 
	 * @param team is an object of SoccerTeam
	 * @return it returns an object of SoccerTeam made using the input parameter.
	 */
	public static SoccerTeam getInstance(SoccerTeam team) {
		return new SoccerTeam(team.getPlayers(), team.getCoach());
	}

	/**
	 * This is the getter method for the player list.
	 * 
	 * @return returns an array containing all the players of this team.
	 */
	public Player[] getPlayers() {
		Player[] arr1 = new Player[this.players.length];
        
        for (int i = 0; i < this.players.length; i++) {
            String temp = new String(Player.getInstance(this.players[i]).getName());
            Player p = Player.getInstance(this.players[i]);
            p.setName(temp);
             arr1[i] = p;
        }
        
        return arr1;
	
	}

	/**
	 * This is the getter method for the coach attribute.
	 * 
	 * @return Returns an object of Coach containing all the info of this team's
	 *         coach.
	 */

	public Coach getCoach() {
		return Coach.getInstance(this.coach1);
	}

	/**
	 * This is the setter method for the player attribute, which deeply copies the
	 * input parameter into the player attribute of this object.
	 * 
	 * @param player is an array of Player, whose elements are copied in the player
	 *               attribute of this object.
	 */

	public void setPlayers(Player[] player) {
		this.players = new Player[player.length];
        for (int i = 0; i < player.length; i++) {
           String temp = new String(Player.getInstance(player[i]).getName());
           Player p = Player.getInstance(player[i]);
           p.setName(temp);
            this.players[i] = p;
       }
	}

	/**
	 * This is the setter method for the coach attribute, which deeply copies the
	 * input parameter into the coach attribute of this object.
	 * 
	 * @param coach is an object of Coach, whose attributes are copied in the coach
	 *              attribute of this object.
	 */
	public void setCoach(Coach coach) {
		String tempName = new String(Coach.getInstance(coach).getName());
        String tempLevel = new String(Coach.getInstance(coach).getLevel());
        Coach c = Coach.getInstance(coach);
        c.setName(tempName);
        c.setLevel(tempLevel);
        this.coach1 = c;
	}

}

/**
 * 
 * This class represent each player required to play in this team. A player has
 * a number, a name, and a role. A role can be either defense, central, striker,
 * or goal keeper. these roles can be represented by the characters 'd', 'c',
 * 's', or 'g'
 *
 */
class Player {
	
	private int number;
	private String name;
	private char role;

	
	
	/**
	 * This is the overloaded constructor for this class
	 * Constructs a new Player instance with the specified attributes.
	 *
	 * @param num  The jersey number of the player.
	 * @param name The name of the player.
	 * @param role The role of the player (use 'D' for defense, 'C' for center, 'S' for striker, 'G' for goalkeeper).
	 */
	private Player(int num, String name, char role) {
	   this.number = num;
	   this.name = name;
	   this.role = role;
	   
	}


	/**
	 * This is the copy constructor for this class
	 * Constructs a new Player instance by copying the attributes from an existing Player object.
	 *
	 * @param player The Player object from which to copy attributes.
	 */
	private Player(Player player) {
		this.number = player.getNum();
	    this.setName(player.getName());
	    this.setRole(player.getRole());
	
	}

	/**
	 * This is a static factory method.
	 * 
	 * @return It returns an object of Player
	 */
	public static Player getInstance() {
		return new Player(0, "", '\0');
		
	}

	/**
	 * This is a static factory method
	 * 
	 * @param num  is the player number
	 * @param name is the name of player
	 * @param role is the role of the player in the team
	 * @return It returns an object of player, which is built using the three input
	 *         variables.
	 */
	public static Player getInstance(int num, String name, char role) {
		return new Player(num, name, role);
	}

	/**
	 * This is a static factory method
	 * 
	 * @param player is an object of Player
	 * @return it returns an object of Player that is built using the input
	 *         parameter.
	 */
	public static Player getInstance(Player player) {
		return new Player(player);
		
	}

	/**
	 * This is the getter method for attribute name
	 * 
	 * @return returns the value of attribute name
	 */
	public String getName() {
		return name;
		
	}

	/**
	 * This is the getter method for attribute role
	 * 
	 * @return returns the value of the attribute role.
	 */
	public char getRole() {
		return role;
	}
	
	public int getNum() {
		return number;
		
	}
	

	/**
	 * This is the setter method for attribute name
	 * 
	 * @param name is the value that is used to initialize name attribute
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This is the setter method for attribute role
	 * 
	 * @param role is a character to initialize attribute role.
	 */
	public void setRole(char role) {
		this.role=role;
	}
	
	public void setNum(int num) {
		this.number=number;
	}

}

/**
 * This class represent the coach that trains the team's players. A coach has a
 * name, a number of years of experience, and a level of expertise. The level of
 * expertise can be represented by one of the strings: "high", "average", or
 * "beginner".
 */
class Coach {
	
	private String name;
	private int yearsExp;
	private String level;

	/**
	 * This is a static factory method
	 * 
	 * @param name     is the name of the coach.
	 * @param yearsExp is the number of years of experience as int.
	 * @param level    is a string that indicate the level of experience.
	 */
	private Coach(String name, int yearsExp, String level) {
		this.name = name;
		this.yearsExp = yearsExp;
		this.level = level;
		
		//return this;
	

	}

	/**
	 * This is a static factory method that initializes the attributes to their
	 * default values.
	 * 
	 * @return It returns an object of Coach
	 */
	public static Coach getInstance() {
		return new Coach("", 0, "");
	}

	/**
	 * This is a static factory method
	 * 
	 * @param name     is the name of the coach.
	 * @param yearsExp is the number of years of experience as int.
	 * @param level    is a string that indicate the level of experience.
	 * @return it returns a Coach object.
	 */
	public static Coach getInstance(String name, int yearsExp, String level) {
		return new Coach(name, yearsExp, level);
		
	}

	/**
	 * This is the copy constructor.
	 * 
	 * @param coach is an object of Coach that is used to initialize this object.
	 */
	private Coach(Coach coach) {
		this.setName(coach.getName());
        this.setYearsExp(coach.getYearsExp());
        this.setLevel(coach.getLevel());
		 
	}

	/**
	 * Constructs a new Coach instance by copying the attributes from an existing
	 * Coach object.
	 * 
	 * @param coach The Coach object from which to copy attributes.
	 * @return a new Coach instance by copying the attributes from an existing Coach
	 *         object
	 */
	public static Coach getInstance(Coach coach) {
		return new Coach(coach);
	}

	/**
	 * Retrieves the name of the coach.
	 * 
	 * @return The name of the coach.
	 */
	public String getName() {
		return name;
	
	}

	/**
	 * Retrieves the number of years of coaching experience.
	 * 
	 * @return The number of years of coaching experience.
	 */
	public int getYearsExp() {
		return yearsExp;
	}

	/**
	 * Retrieves the coaching level of the coach.
	 * 
	 * @return The coaching level of the coach
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * Sets the name of the coach.
	 *
	 * @param name The new name for the coach.
	 */
	public void setName(String name) {
	   this.name = name;
	}

	/**
	 * Sets the number of years of coaching experience for the coach.
	 *
	 * @param yearsExp The new number of years of coaching experience.
	 */
	public void setYearsExp(int yearsExp) {
		this.yearsExp = yearsExp;
	}

	/**
	 * Sets the coaching level of the coach.
	 *
	 * @param level The new coaching level for the coach ("beginner", "average", or "high").
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	
	
	

}
