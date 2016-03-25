/*
	Mat No: A0138862W
	Name: Wong Kang Fei
*/

import java.util.*;

public class ECP {
	private ArrayList<Championship> championships;

	public ECP(){
		this.championships = new ArrayList<Championship>();
	}

	public void addChampionship(String name){
		this.championships.add(new Championship(name));
	}

    public static void main(String[] args) {
        //define your main method here
		ECP ecp = new ECP();
		Scanner sc = new Scanner(System.in);
		int championshipCount = sc.nextInt();
		int teamCount = sc.nextInt();
		int queryCount = sc.nextInt();

		sc.nextLine();

		for(int i=0; i<championshipCount; i++){
			ecp.addChampionship(sc.nextLine());
		}

		for(int i=0; i<teamCount; i++){
			String teamName = sc.next();
			String championshipName = sc.next();

			Championship championship =ecp.findChampionshipByName(championshipName);
			Team team = new Team(teamName, championship);

			sc.nextLine();
		}

		for(int i=0; i<queryCount; i++){
			String query = sc.next();
			switch(query){
				case "win":
					ecp.execWin(sc.next(), sc.next());
					break;
				case "draw":
					ecp.execDraw(sc.next(), sc.next());
					break;
				case "top":
					ecp.execTop(sc.next());
					break;
				case "max":
					ecp.execMax();
					break;
				case "final":
					ecp.execFinal(sc.next());
					break;
			}

			sc.nextLine();
		}

    }

	public Championship findChampionshipByName(String name){
		for(Championship championship: championships){
			if(name.equals(championship.getName())){
				return championship;
			}
		}
		return null;
	}
	/*
		pre: registered Winning and losing Team Name
		post: print the name of the championship where the matches concluded. if teams are not the same, return invalid matching.
	*/
	public void execWin(String winningTeamName, String losingTeamName){
		Team winningTeam = null;
		Team losingTeam = null;
		
		// find the team in the championship
		for(Championship championship : championships){
			Team targetWinningTeam = championship.findTeamByName(winningTeamName);
			Team targetLosingTeam = championship.findTeamByName(losingTeamName);
			if(targetWinningTeam != null){
				winningTeam = targetWinningTeam;
			}else if(targetLosingTeam != null){
				losingTeam = targetLosingTeam;
			}else if(winningTeam != null && losingTeam != null){
				break;
			}else{
				continue;
			}
		}

		// update status if they are in same championship
		if(winningTeam.isInSameChampionshipAs(losingTeam)){ // exception here, you need to also check winningTeam and losingTeam are not null
			winningTeam.wonMatch();
			losingTeam.loseMatch();
			System.out.println(winningTeam.getChampionship().getName());
		}else{
			System.out.println("invalid matching");
		}
	}

	/*
		pre: registered Winning and losing Team Name
		post: print the name of the championship where the matches concluded. if teams are not the same, return invalid matching.
	*/
	
	public void execDraw(String teamName1, String teamName2){
		Team team1 = null;
		Team team2 = null;

		for(Championship championship : championships){
			Team targetTeam1 = championship.findTeamByName(teamName1);
			Team targetTeam2 = championship.findTeamByName(teamName2);
			if(targetTeam1 != null){
				team1 = targetTeam1;
			}else if(targetTeam2 != null){
				team2 = targetTeam2;
			}else if(team1 != null && team2 != null){
				break;
			}else{
				continue;
			}
		}

		if(team1.isInSameChampionshipAs(team2)){
			team1.wonMatch();
			team2.loseMatch();
			System.out.println(team1.getChampionship().getName());
		}else{
			System.out.println("invalid matching");
		}
	}

	public void execTop(String championshipName){

	}

	public void execMax(){
		
	}

	public void execFinal(String championshipName){

	}


}

class Championship {
    //define the appropriate attributes, constructor, and methods here
	public static final int WIN_POINT = 3;
	public  static final int DRAW_POINT = 1;
	public static final int LOSE_POINT = 0;
	
	private String name;
	private ArrayList<Team> teams;

	public Championship(String name){
		this.name = name;
		this.teams = new ArrayList<Team>();
	}

	public String getName(){
		return name;
	}		

	public ArrayList<Team> getTeams(){
		return teams;
	}

	public void addTeam(Team team){
		teams.add(team);
	}

	public Team findTeamByName(String teamName){
		Team targetTeam = null;

		for(Team team : teams){
			if(teamName.equals(name)){
				targetTeam = team;
				break;
			}else{
				continue;
			}
		}

		return targetTeam;
	}

	public Team getHighestRank(){
		Team highestPointsTeam = null;
		Team mostPointsTeam = null;
		for(Team team : teams){
			if(highestPointsTeam == null){
				highestPointsTeam = team;
			}else if(team.getPoints() > highestPointsTeam.getPoints()){
				highestPointsTeam = team;
			}
		}

		return null;
	}


}

class Team implements Comparable<Team>{
    //define the appropriate attributes, constructor, and methods here
	private String name;
	private int matchCount;
	private int winCount;
	private int drawCount;
	private int loseCount;
	private int points;
	private Championship championship;

	public Team(String name, Championship championship){
		this.name = name;
		this.matchCount = 0;
		this.winCount = 0;
		this.drawCount = 0;
		this.loseCount = 0;
		this.points = 0;
		this.championship = championship;
	}	
	
	public String getName(){
		return name;
	}

	public int getMatchCount(){
		return matchCount;
	}

	public int getWinCount(){
		return winCount;
	}

	public int getDrawCount(){
		return drawCount;
	}

	public int getLoseCount(){
		return loseCount;
	}

	public int getPoints(){
		return points;
	}

	public Championship getChampionship(){
		return championship;
	}

	public void wonMatch(){
		matchCount++;
		points+=Championship.WIN_POINT;
	}

	public void drawMatch(){
		matchCount++;
		points+=Championship.DRAW_POINT;
	}

	public void loseMatch(){
		matchCount++;
		points+=Championship.LOSE_POINT;
	}

	public boolean isInSameChampionshipAs(Team anotherTeam){
		return this.championship == anotherTeam.getChampionship();
	}
	
	// for lexicographically sorting the team by alphabetical order
	public int compareTo(Team team){
		return name.compareTo(team.getName());
	}
}
